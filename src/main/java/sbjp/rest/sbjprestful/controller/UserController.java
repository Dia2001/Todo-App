package sbjp.rest.sbjprestful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbjp.rest.sbjprestful.payload.request.UserRequest;
import sbjp.rest.sbjprestful.payload.response.UserReponse;
import sbjp.rest.sbjprestful.services.UserService;

@CrossOrigin(origins = "http://localhost:6661/")
@RestController(value = "userAPIofWeb")
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping()
	public ResponseEntity<List<UserReponse>> getAll() {

		try {
			return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

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
	public ResponseEntity<String> update(@PathVariable("userId") int userId, @RequestBody UserRequest request) {
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

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> delete(@PathVariable("userId") int userId) {

		if (userService.delete(userId)) {
			return new ResponseEntity<>("Deleted!", HttpStatus.OK);
		}
		return new ResponseEntity<>("Delete faile!", HttpStatus.BAD_GATEWAY);
	}
}
