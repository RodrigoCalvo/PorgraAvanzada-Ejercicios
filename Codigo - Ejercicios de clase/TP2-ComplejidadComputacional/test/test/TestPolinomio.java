package test;

import java.util.GregorianCalendar;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import trabajoPractico.Polinomio;

public class TestPolinomio {
	/*
	@Test
	public void testEvaluarMSucesivas() throws Exception {
		Polinomio pol = new Polinomio(new double[]{3,2,1});

		Calendar tIni = new GregorianCalendar();
		
		double resultado = pol.evaluarMSucesivas(4);
		
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("testEvaluarMSucesivas: " + diff);
		
		Assert.assertEquals(57, resultado, 0);
	}
	*/
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
	public void testEvaluarHorner() throws Exception {
		Polinomio pol = new Polinomio(new double[]{3,2,1});

		double resultado = pol.evaluarHorner(4);
		
		Assert.assertEquals(57, resultado, 0);
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
}
