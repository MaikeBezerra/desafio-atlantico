package com.desafio.atlantico;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafio.atlantico.service.ValidacaoStringService;

@SpringBootTest(classes = ValidacaoStringService.class)
public class ValidacaoStringTest {

	private ValidacaoStringService validacaoString;
	
	@Before
	public void iniciar() {
		this.validacaoString = new ValidacaoStringService();
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
		validacaoString = new ValidacaoStringService();
		return validacaoString.validar(string);
	}
}
