package test;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;
import geometria.*;

public class TestCirculo {

	@Test(expected = Exception.class)
	public void testRadioMenorA0() throws Exception {
		Punto p1 = new Punto(55, 99);
		Circulo c1 = new Circulo(-1, p1);
	}
	
	@Test
	public void testPuntoPertenece() throws Exception{
		Punto p1 = new Punto(55, 99);
		Circulo c1 = new Circulo(1, p1);
		
		Assert.assertTrue(c1.puntoPertenece(p1));	
		Assert.assertTrue(c1.puntoPertenece(new Punto(56, 99)));
		Assert.assertTrue(c1.puntoPertenece(new Punto(55, 100)));		
	}
	
	@Test
	public void testPuntoNoPertenece() throws Exception{
		Punto p1 = new Punto(55, 99);
		Circulo c1 = new Circulo(1, p1);
		
		Assert.assertFalse(c1.puntoPertenece(new Punto(1,1)));	
		Assert.assertFalse(c1.puntoPertenece(new Punto(57,99)));
		Assert.assertFalse(c1.puntoPertenece(new Punto(56,100)));			
	}
	
	@Test
	public void testCirculoPertenece() throws Exception{
		Punto p1 = new Punto(55, 99);
		Circulo c1 = new Circulo(1, p1);
		
		Assert.assertFalse(c1.puntoPertenece(new Punto(1,1)));	
		Assert.assertFalse(c1.puntoPertenece(new Punto(57,99)));
		Assert.assertFalse(c1.puntoPertenece(new Punto(56,100)));			
	}
}
