package com.desafio.atlantico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string")
public class StringController {

	@Autowired
	private ValidacaoString validacaoString;
	
	@GetMapping
	public ResponseEntity<?> validar(@RequestParam  String string){
		
		if (validacaoString.validar(string)) {
			return ResponseEntity.ok("String valida");
		}
		
		return ResponseEntity.notFound().build();
		
	}
}
