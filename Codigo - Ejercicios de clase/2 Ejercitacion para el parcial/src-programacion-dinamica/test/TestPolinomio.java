package test;

import org.junit.Assert;
import org.junit.Test;

import trabajoPractico.Polinomio;

public class TestPolinomio {
	
	@Test
	public void testEvaluarMSucesivas() throws Exception {
		Polinomio pol = new Polinomio(new double[]{3,2,1});
		
		double resultado = pol.evaluarMSucesivas(4);
		
		Assert.assertEquals(57, resultado, 0);
	}
	
	@Test
	public void testEvaluarRecursiva() throws Exception {
		Polinomio pol = new Polinomio(new double[]{3,2,1});

		double resultado = pol.evaluarRecursiva(4);
		
		Assert.assertEquals(57, resultado, 0); 
		
	}
	
	@Test
	public void testEvaluarRecursivaPar() throws Exception {
		Polinomio pol = new Polinomio(new double[]{3,2,1});

		double resultado = pol.evaluarRecursivaPar(4);
		
		Assert.assertEquals(57, resultado, 0);
	}
	
	@Test
	public void testEvaluarProgDinamica() throws Exception {
		Polinomio pol = new Polinomio(new double[]{3,2,1});

		double resultado = pol.evaluarProgDinamica(4);
		
		Assert.assertEquals(57, resultado, 0);
	}
	
	@Test
	public void testEvaluarMejorada() throws Exception {
		Polinomio pol = new Polinomio(new double[]{3,2,1});

		double resultado = pol.evaluarMejorada(4);
		
		Assert.assertEquals(57, resultado, 0);
	}

	@Test
	public void testEvaluarPow() throws Exception {
		Polinomio pol = new Polinomio(new double[]{3,2,1});

		double resultado = pol.evaluarPow(4);
		
		Assert.assertEquals(57, resultado, 0);
	}
	
	@Test
	public void testEvaluarHorner() throws Exception {
		Polinomio pol = new Polinomio(new double[]{3,2,1});

		double resultado = pol.evaluarHorner(4);
		
		Assert.assertEquals(57, resultado, 0);
	}

	@Test
	public void testQueDenTodasIgual() throws Exception {
		Polinomio pol = new Polinomio(new double[]{123,31,23,9,5,666,89,6,5,54,89,6});
		double x = 5;
		
		double resultadoMSucesivas = pol.evaluarMSucesivas(x);
		double resultadoRecursiva = pol.evaluarRecursiva(x);
		double resultadoRecursivaPar = pol.evaluarRecursivaPar(x);
		double resultadoProgDinamica = pol.evaluarProgDinamica(x);
		double resultadoMejorada = pol.evaluarMejorada(x);
		double resultadoPow = pol.evaluarPow(x);
		double resultadoHorner = pol.evaluarHorner(x);

		//System.out.println("resultadoMSucesivas: " + resultadoMSucesivas);
		//System.out.println("resultadoRecursiva: " + resultadoRecursiva);
		//System.out.println("resultadoRecursivaPar: " + resultadoRecursivaPar);
		//System.out.println("resultadoProgDinamica: " + resultadoProgDinamica);
		//System.out.println("resultadoMejorada: " + resultadoMejorada);		
		//System.out.println("resultadoPow: " + resultadoPow);
		//System.out.println("resultadoHorner: " + resultadoHorner);
		
		Assert.assertEquals(resultadoMSucesivas, resultadoRecursiva, 0.001);
		Assert.assertEquals(resultadoRecursiva, resultadoRecursivaPar, 0.001);
		Assert.assertEquals(resultadoRecursivaPar, resultadoProgDinamica, 0.001);
		Assert.assertEquals(resultadoProgDinamica, resultadoMejorada, 0.001);
		Assert.assertEquals(resultadoMejorada, resultadoPow, 0.001);
		Assert.assertEquals(resultadoPow, resultadoHorner, 0.001);
		Assert.assertEquals(resultadoHorner, resultadoMSucesivas, 0.001);
	}

	@Test
	public void testTIEMPOS() throws Exception {
		Polinomio pol = new Polinomio(new double[]{123,31,23,9,5,666,89,6,5,54,89,6,5,54,89,6,5,54,89,6,5,123,31,23,9,5,666,89,6,5,54,89,6,5,54,89,6,5,54,89,6,5,54});
		double x = 45;
		long startTime, endTime, duration;

		startTime = System.nanoTime();
		double resultadoMSucesivas = pol.evaluarMSucesivas(x);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("evaluarMSucesivas: " + duration + " nanosegundos");

		startTime = System.nanoTime();
		double resultadoRecursiva = pol.evaluarRecursiva(x);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("evaluarRecursiva: " + duration + " nanosegundos");

		startTime = System.nanoTime();
		double resultadoRecursivaPar = pol.evaluarRecursivaPar(x);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("evaluarRecursivaPar: " + duration + " nanosegundos");

		startTime = System.nanoTime();
		double resultadoProgDinamica = pol.evaluarProgDinamica(x);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("evaluarProgDinamica: " + duration + " nanosegundos");

		startTime = System.nanoTime();
		double resultadoMejorada = pol.evaluarMejorada(x);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("evaluarMejorada: " + duration + " nanosegundos");

		startTime = System.nanoTime();
		double resultadoPow = pol.evaluarPow(x);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("evaluarPow: " + duration + " nanosegundos");

		startTime = System.nanoTime();
		double resultadoHorner = pol.evaluarHorner(x);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("evaluarHorner: " + duration + " nanosegundos");		
	}

	@Test
	public void testToString() throws Exception {
		Polinomio pol = new Polinomio(new double[]{123,31,23,9,5,666,89,6,5,54,89,6,5,54,89,6,5,54,89,6,5,123,31,23,9,5,666,89,6,5,54,89,6,5,54,89,6,5,54,89,6,5,54});
		
		System.out.println(pol);
	}
	/*
	@Test
	public void testTIEMPOS() throws Exception {
		Polinomio pol = new Polinomio(new double[]{123,31,23,9,5,666,89,6,5,54,89,6,5,54,89,6,5,54,89,6,5,123,31,23,9,5,666,89,6,5,54,89,6,5,54,89,6,5,54,89,6,5,54});


		long startTime = System.nanoTime();
		double resultado = pol.evaluarMSucesivas(55);
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		
		System.out.println("testTIEMPOS - evaluarMSucesivas: " + duration + " nanosegundos - Resultado: " + resultado);
	}
	
	
	@Test
	public void testTIEMPOSDinamica() throws Exception {
		Polinomio pol = new Polinomio(new double[]{123,31,23,9,5,666,89,6,5,54,89,6,5,54,89,6,5,54,89,6,5,123,31,23,9,5,666,89,6,5,54,89,6,5,54,89,6,5,54,89,6,5,54});
		
		long startTime = System.nanoTime();
		double resultado = pol.evaluarProgDinamica(55);
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.

		
		System.out.println("testTIEMPOS - evaluarProgDinamica: " + duration + " nanosegundos - Resultado: " + resultado);
		
	}
	
	@Test
	public void testTIEMPOSMejorada() throws Exception {
		Polinomio pol = new Polinomio(new double[]{123,31,23,9,5,666,89,6,5,54,89,6,5,54,89,6,5,54,89,6,5,123,31,23,9,5,666,89,6,5,54,89,6,5,54,89,6,5,54,89,6,5,54});
		
		long startTime = System.nanoTime();
		double resultado = pol.evaluarMejorada(55);
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.

		//nano segundos = 4345
		
		System.out.println("testTIEMPOS - evaluarMejorada: " + duration + " nanosegundos - Resultado: " + resultado);
		
	}
	*/
}
