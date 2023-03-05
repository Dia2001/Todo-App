package sbjp.rest.sbjprestful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbjp.rest.sbjprestful.clientsever.request.TokenRequest;
import sbjp.rest.sbjprestful.clientsever.request.UserRequest;
import sbjp.rest.sbjprestful.clientsever.response.NotificationResponse;
import sbjp.rest.sbjprestful.clientsever.response.TokenReponse;
import sbjp.rest.sbjprestful.common.Utils;
import sbjp.rest.sbjprestful.config.JwtTokenProvider;
import sbjp.rest.sbjprestful.services.IUserService;
import sbjp.rest.sbjprestful.services.imp.a;
import sbjp.rest.sbjprestful.entities.*;

@CrossOrigin(origins = "http://localhost:6661/")
@RestController(value = "userAPIofWeb")
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private a av;

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody UserRequest userRequest) {
		try {
			System.out.println(userRequest.toString());
			if (userService.add(userRequest)) {
				return new ResponseEntity<>("Created!", HttpStatus.CREATED);
			}
			return new ResponseEntity<>("Create faile!", HttpStatus.BAD_GATEWAY);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{userId}")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<String> update(@PathVariable("userId") int userId, @RequestBody UserRequest request) {
		
		System.out.println("updateadafaaaaaaaaaaaaaaa"+userId);
		try {
			if (userService.findByUserName() == null) {
				return new ResponseEntity<>("No user found!", HttpStatus.BAD_GATEWAY);
			}

			if (userService.update(userId, request)) {
				return new ResponseEntity<>("Updated!", HttpStatus.OK);
			}
			return new ResponseEntity<>("Update faile!", HttpStatus.BAD_GATEWAY);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/login")
	public TokenReponse authenticateUser(@RequestBody TokenRequest tokenRequest) {

		System.out.println(tokenRequest.toString() + "aaaaaaaaaaaaaaaaaaaaaaaa");
		// Xác thực từ username và password.
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(tokenRequest.getUsername(), tokenRequest.getPassword()));

		System.out.println(authentication.getPrincipal().toString() + "aaaaaaaaaaaaaaaaaaaaaaa");

		// Nếu không xảy ra exception tức là thông tin hợp lệ
		// Set thông tin authentication vào Security Context
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// Trả về jwt cho người dùng. String jwt =
		// jwtUtils.generateJwtToken(authentication);
		String jwt = tokenProvider.generateTokenUsingUserName(tokenRequest.getUsername());
		System.out.println(SecurityContextHolder.getContext().getAuthentication() + "000aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		System.out.println("user" + Utils.GetUserName());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
		   System.out.println("Đây đúng là role user1");
		}else {
			 System.out.println("Đây không đúng là role user1");
		}
		
		 UserDetails details = av.loadUserByUsername( Utils.GetUserName());
		    if (details != null && details.getAuthorities().stream()
		      .anyMatch(a -> a.getAuthority().equals("USER_ROLE"))) {
		    	  System.out.println("Đây đúng là role user2");
		    }else {
		    	System.out.println("Đsây không phải là role2");
		    }
		return new TokenReponse(jwt);
	}

	// Api /api/random yêu cầu phải xác thực mới có thể request
	@GetMapping("/random")
	public NotificationResponse randomStuff() {
		return new NotificationResponse("JWT Hợp lệ mới có thể thấy được message này", false);
	}

}
