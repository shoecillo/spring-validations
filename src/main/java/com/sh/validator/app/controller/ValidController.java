package com.sh.validator.app.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sh.validator.app.dto.DataIn;
import com.sh.validator.app.exceptions.FunctionalException;

@RestController
public class ValidController {

	@PostMapping("/getValid")
	public ResponseEntity<String> getValid(@Valid @RequestBody DataIn in) throws Exception{
		
		if(in.getAge() == 3) {
			throw new NullPointerException("Null Pointer Exception");
		} else if(in.getAge() == 4) {
			throw new FunctionalException("My own funcional exception");
		}
		
		return new ResponseEntity<String>("Valid", HttpStatus.OK);
	}
}
