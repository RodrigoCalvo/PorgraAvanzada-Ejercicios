package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ejercicio.*
;public class CarreraTest {

	@Test
	public void test() {
		Carrera carrera = new Carrera("src-a-correr-que-es-muy-saludable/", "input.in");
		
		carrera.guardarResultado();
	}

}
