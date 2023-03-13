package sbjp.rest.sbjprestful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import sbjp.rest.sbjprestful.config.jwt.JwtProvider;
import sbjp.rest.sbjprestful.payload.request.LoginRequest;
import sbjp.rest.sbjprestful.payload.request.TokenRefreshRequest;
import sbjp.rest.sbjprestful.payload.response.JwtTokenResponse;

@CrossOrigin(origins = "http://localhost:6661/")
@RestController(value = "authAPIofWeb")
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtProvider tokenProvider;

	@PostMapping("/login")
	public ResponseEntity<JwtTokenResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateTokenUsingUserName(loginRequest.getUsername());

		return new ResponseEntity<>(new JwtTokenResponse(jwt), HttpStatus.OK);
		
	}
}
