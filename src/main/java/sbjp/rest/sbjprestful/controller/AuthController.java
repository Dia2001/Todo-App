package sbjp.rest.sbjprestful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbjp.rest.sbjprestful.payload.request.LoginRequest;
import sbjp.rest.sbjprestful.payload.response.JwtTokenResponse;
import sbjp.rest.sbjprestful.services.AuthenticationService;

@CrossOrigin(origins = "http://localhost:6661/")
@RestController(value = "authAPIofWeb")
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@PostMapping("/login")
	public ResponseEntity<JwtTokenResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

		return new ResponseEntity<>(authenticationService.authenticate(loginRequest), HttpStatus.OK);

	}
}
