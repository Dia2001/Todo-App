package sbjp.rest.sbjprestful.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import sbjp.rest.sbjprestful.config.jwt.JwtProvider;
import sbjp.rest.sbjprestful.entities.Token;
import sbjp.rest.sbjprestful.entities.User;
import sbjp.rest.sbjprestful.enums.TokenType;
import sbjp.rest.sbjprestful.payload.request.LoginRequest;
import sbjp.rest.sbjprestful.payload.response.JwtTokenResponse;
import sbjp.rest.sbjprestful.repositories.TokenRepository;
import sbjp.rest.sbjprestful.repositories.UserRepository;
import sbjp.rest.sbjprestful.services.AuthenticationService;

@Component
public class AuthServiceImpl implements AuthenticationService {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtProvider tokenProvider;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private TokenRepository tokenRepository;

	@Override
	public JwtTokenResponse authenticate(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateTokenUsingUserName(loginRequest.getUsername());

		var user = userRepository.findByuserName(loginRequest.getUsername());
		revokeAllUserTokens(user);
		saveUserToken(user, jwt);

		return new JwtTokenResponse(jwt);
	}
	
	private void saveUserToken(User user, String jwtToken) {
		Token token = new Token();
		token.setUser(user);
		token.setToken(jwtToken);
		token.setExpired(false);
		token.setRevoked(false);
		token.setTokenType(TokenType.BEARER);
		tokenRepository.save(token);
	}

	private void revokeAllUserTokens(User user) {
		var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
		if (validUserTokens.isEmpty())
			return;
		validUserTokens.forEach(token -> {
			token.setExpired(true);
			token.setRevoked(true);
		});
		tokenRepository.saveAll(validUserTokens);
	}
}
