package sbjp.rest.sbjprestful.services;

import org.springframework.stereotype.Service;

import sbjp.rest.sbjprestful.payload.request.LoginRequest;
import sbjp.rest.sbjprestful.payload.response.JwtTokenResponse;

@Service
public interface AuthenticationService {
	 JwtTokenResponse authenticate(LoginRequest loginRequest);
}
