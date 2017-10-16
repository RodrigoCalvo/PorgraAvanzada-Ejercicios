package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import ejercicio.SopaDeLetra;

public class SopaDeLetrasTest {

	@Test
	public void test() {
		SopaDeLetra sopita = new SopaDeLetra("src-sopa-de-letras/", "entrada.in");
		/*
		for (int i = 0; i < sopita.getSopaDeLetras().length; i++) {					
			System.out.println(Arrays.toString(sopita.getSopaDeLetras()[i]));			
		}
		*/
		sopita.prepararResultado();
	}

}
