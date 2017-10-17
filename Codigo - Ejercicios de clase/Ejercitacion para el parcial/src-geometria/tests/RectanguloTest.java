package tests;

import org.junit.Assert;

import ejercicio.*;
import org.junit.Test;


public class RectanguloTest {

	@Test
	public void testRectangulo() throws Exception {
		Punto p1 = new Punto(10, 10);
		Punto p2 = new Punto(15, 5);
		
		Rectangulo rectangulo = new Rectangulo(p1, p2);
	}
	@Test(expected = Exception.class)
	public void testRectanguloQueNoAnda() throws Exception {
		Punto p1 = new Punto(10, 10);
		Punto p2 = new Punto(10, 0);
		
		Rectangulo rectangulo = new Rectangulo(p1, p2);
	}
	@Test(expected = Exception.class)
	public void testRectanguloQueNoAnda2() throws Exception {
		Punto p1 = new Punto(15, 5);
		Punto p2 = new Punto(10, 10);
		
		Rectangulo rectangulo = new Rectangulo(p1, p2);
	}
	

	@Test
	public void testPuntoPertenece() throws Exception {
		Punto p1 = new Punto(10, 10);
		Punto p2 = new Punto(15, 5);
		
		Rectangulo rectangulo = new Rectangulo(p1, p2);
		
		Assert.assertTrue(rectangulo.puntoPertenece(new Punto(11, 6)));
		Assert.assertTrue(rectangulo.puntoPertenece(new Punto(10, 10)));
		Assert.assertTrue(rectangulo.puntoPertenece(new Punto(15, 5)));
		Assert.assertTrue(rectangulo.puntoPertenece(new Punto(15, 10)));
		Assert.assertTrue(rectangulo.puntoPertenece(new Punto(10, 5)));

		Assert.assertFalse(rectangulo.puntoPertenece(new Punto(100, 5)));
		Assert.assertFalse(rectangulo.puntoPertenece(new Punto(10, 11)));
	}

	@Test
	public void testintersecta() throws Exception {
		Punto p1 = new Punto(0, 1);
		Punto p2 = new Punto(1, 0);		
		Rectangulo rectangulo1 = new Rectangulo(p1, p2);

		Punto p3 = new Punto(1, 3);
		Punto p4 = new Punto(2, 1);		
		Rectangulo rectangulo2 = new Rectangulo(p3, p4);
		

		Assert.assertTrue(rectangulo1.intersecta(rectangulo1));
		Assert.assertTrue(rectangulo1.intersecta(rectangulo2));
		Assert.assertTrue(rectangulo2.intersecta(rectangulo2));
		Assert.assertTrue(rectangulo2.intersecta(rectangulo1));
		
		Punto p5 = new Punto(1, 5);
		Punto p6 = new Punto(3, 1);		
		Rectangulo rectangulo3 = new Rectangulo(p5, p6);

		Punto p7 = new Punto(2, 3);
		Punto p8 = new Punto(4, 2);		
		Rectangulo rectangulo4 = new Rectangulo(p7, p8);

		Assert.assertTrue(rectangulo3.intersecta(rectangulo4));
		Assert.assertTrue(rectangulo4.intersecta(rectangulo3));
		

		Punto p9 = new Punto(4, 7);
		Punto p10 = new Punto(6, 5);		
		Rectangulo rectangulo5 = new Rectangulo(p9, p10);
		
		Assert.assertFalse(rectangulo3.intersecta(rectangulo5));
	}
	
	@Test
	public void testCirculoPerteneceARectangulo() throws Exception {
		Punto p1 = new Punto(0, 1);
		Punto p2 = new Punto(5, 0);		
		Rectangulo rectangulo = new Rectangulo(p1, p2);
		
		Punto centro = new Punto(2.5, 0.5);
		Circulo c1 = new Circulo(2, centro);
		
		Assert.assertTrue(rectangulo.intersecta(c1));
		
		centro = new Punto(2.5, 0.5);
		c1 = new Circulo(0.1, centro);
		
		Assert.assertTrue(rectangulo.intersecta(c1));

		
		centro = new Punto(5, 1);
		c1 = new Circulo(0.1, centro);
		
		Assert.assertTrue(rectangulo.intersecta(c1));
		
		centro = new Punto(6, 1);
		c1 = new Circulo(1, centro);
		
		Assert.assertTrue(rectangulo.intersecta(c1));
	}
	
	@Test
	public void testCirculoNoPerteneceARectangulo() throws Exception {
		Punto p1 = new Punto(0, 1);
		Punto p2 = new Punto(5, 0);		
		Rectangulo rectangulo = new Rectangulo(p1, p2);
		
		Punto centro = new Punto(20, 0.5);
		Circulo c1 = new Circulo(2, centro);
		
		Assert.assertFalse(rectangulo.intersecta(c1));
		
		centro = new Punto(6, 1);
		c1 = new Circulo(0.1, centro);
		
		Assert.assertFalse(rectangulo.intersecta(c1));

		centro = new Punto(2.5, 1.5);
		c1 = new Circulo(0.49, centro);
		
		Assert.assertFalse(rectangulo.intersecta(c1));
	}
}
