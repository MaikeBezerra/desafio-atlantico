package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafio.atlantico.ValidacaoString;

@SpringBootTest(classes = ValidacaoString.class)
public class ValidacaoStringTest {

	private ValidacaoString validacaoString;
	
	@Before
	public void iniciar() {
		this.validacaoString = new ValidacaoString();
	}
	
	@Test
	public void exemploTest() {
		assertEquals(true, validaStringTest(""));
	}
	
	@Test
	public void exemplo1Test() {
		assertEquals(true, validaStringTest("()"));
	}
	
	@Test
	public void exemplo2Test() {
		assertEquals(true, validaStringTest("()[]{}"));
	}
	
	@Test
	public void exemplo3Test() {
		assertEquals(false, validaStringTest("(]"));
	}
	
	@Test
	public void exemplo4Test() {
		assertEquals(false, validaStringTest("([)]"));
	}
	
	@Test
	public void exemplo5Test() {
		assertEquals(true, validaStringTest("{[]}"));
	}
	
	@Test
	public void exemplo6Test() {
		assertEquals(false, validaStringTest("]}"));
	}
	
	@Test
	public void exemplo7Test() {
		assertEquals(false, validaStringTest("[]}{()"));
	}
	
	private boolean validaStringTest(String string) {
		validacaoString = new ValidacaoString();
		return validacaoString.validar(string);
	}
}
