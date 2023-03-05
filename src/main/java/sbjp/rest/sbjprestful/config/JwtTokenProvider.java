package sbjp.rest.sbjprestful.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenProvider {
	@Value("${sbjp.app.jwtSecret}")
	private String jwtSecret;

	@Value("${sbjp.app.jwtExpirationMs}")
	private int jwtExpirationMs;
	// private static final Logger logger =
	// LoggerFactory.getLogger(JwtTokenProvider.class); (JwtTokenProvider.class);

	/*
	 * alue("${bezkoder.app.jwtSecret}") private String jwtSecret;
	 * 
	 * @Value("${bezkoder.app.jwtExpirationMs}") private int jwtExpirationMs;
	 */
	public String generateTokenUsingUserName(String userName) {
		System.out.println("helaaaaaaaaaaaaa");
		String token = Jwts.builder().setSubject(userName)
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512,jwtSecret).compact();
		System.out.println(token + "helaaaaaaaaaaaaa");
		return token;
	}

//	public Long getUserIdFromJWT(String token) {
//		Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
//
//		return Long.parseLong(claims.getSubject());
//	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (MalformedJwtException ex) {
			// log.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			// log.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			// log.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			// log.error("JWT claims string is empty.");
		}
		return false;
	}
}
