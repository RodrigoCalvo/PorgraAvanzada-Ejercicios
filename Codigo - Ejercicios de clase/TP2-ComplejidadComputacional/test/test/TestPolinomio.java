package test;

import java.util.GregorianCalendar;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import trabajoPractico.Polinomio;

public class TestPolinomio {

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
	@Test
	public void testTIEMPOS() throws Exception {
		Polinomio pol = new Polinomio(new double[]{9,5,666,89,6,5,54,89,6,5,54,89,6,5,54,89,6,5,54});

		Calendar tIni = new GregorianCalendar();
		
		double resultado = pol.evaluarMSucesivas(4);
		
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("testTIEMPOS - evaluarMSucesivas: " + diff);
	}

}
