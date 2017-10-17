package tests;

import org.junit.Assert;

import ejercicio.*;
import org.junit.Test;


public class TestPunto {

	@Test
	public void testDistanciaHasta() {
		Punto p1 = new Punto(1, 1);
		Punto p2 = new Punto(1, 1);
		
		Assert.assertTrue(p1.distanciaHasta(p2) == 0);
	}

}
