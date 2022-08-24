package com.cw.ap.azurePoc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = { "/api" })
public class UserController {

	@GetMapping("/user/{code}")
	public ResponseEntity<?> getMessageStatus(@PathVariable String code) {

		
		// return new ResponseEntity<>("http code "+HttpStatus.OK, HttpStatus.OK);
		
		if(code.equals("200")) {
			return new ResponseEntity<>("http code "+HttpStatus.OK, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("http code " + HttpStatus.ACCEPTED, HttpStatus.ACCEPTED);
		}

	}
	
}
