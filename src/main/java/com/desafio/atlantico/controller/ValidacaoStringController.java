package com.desafio.atlantico.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.atlantico.service.ValidacaoStringService;

@RestController
@RequestMapping("/string")
public class ValidacaoStringController {

	@Autowired
	private ValidacaoStringService validacaoString;
	
	@GetMapping
	public ResponseEntity<?> validar(@RequestParam("string")  String string){
		
		try {
			String decoded = URLDecoder.decode(string, "UTF-8");
			if (validacaoString.validar(decoded)) {
				return ResponseEntity.ok("String valida");
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.notFound().build();
		
	}
}
