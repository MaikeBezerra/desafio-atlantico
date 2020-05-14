package com.desafio.atlantico.service;

import org.springframework.stereotype.Service;

@Service
public class ValidacaoStringService {
	
	public boolean validar(String simbolos) {
		if(simbolos.isEmpty()) {return true;} 
		
		if (simbolos.length() % 2 != 0) {return false;}
		
		String[] caracteres = simbolos.split("");
		if (isFechamento(caracteres[0]) || isAbertura(caracteres[simbolos.length() -1])) {
			return false;
		}
		
		return encontraFechamento(caracteres, simbolos);
	}
	
	private boolean encontraFechamento(String[] caracteres, String simbolos) {
		
		for (int i = 0; i < caracteres.length; i++) {
			if (isFechamento(caracteres[i])) {
				if(!caracteres[i -1].equals(aberturaEquivalente(caracteres[i]))) {
					return false;
				} else {
					
					String intervalo = simbolos.substring(i-1, i+1);
					String novosSimbolos = simbolos.replace(intervalo, ""); 
					return validar(novosSimbolos);
				}
			}
		}
		return true;
	}
	
	private boolean isFechamento(String simbolo) {
		switch (simbolo) {
		case ")":
		case "]":
		case "}":
			return true;
		}
		
		return false;
	}
	
	private boolean isAbertura(String simbolo) {
		switch (simbolo) {
		case "(":
		case "[":
		case "{":
			return true;
		}
		
		return false;
	}
	
	private String aberturaEquivalente(String simbolo) {
		switch (simbolo) {
		case ")":
			return "(";
		case "]":
			return "[";
		case "}":
			return "{";
		}
		
		return null;
	}
}
