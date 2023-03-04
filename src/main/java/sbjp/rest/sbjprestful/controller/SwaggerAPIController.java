package sbjp.rest.sbjprestful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbjp.rest.sbjprestful.services.IUserService;

@CrossOrigin(origins = "http://localhost:6661/")
@RestController
@RequestMapping("/a")
public class SwaggerAPIController {
	@Autowired
	private IUserService ur;
	@GetMapping("/products")
	   public ResponseEntity<Object> getProducts() {
		System.out.println("hello");
		return new ResponseEntity<>(ur.getAllUser(), HttpStatus.OK);
	   }
}
