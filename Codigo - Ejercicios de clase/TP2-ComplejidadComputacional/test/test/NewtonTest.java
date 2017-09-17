package test;
import java.util.GregorianCalendar;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import trabajoPractico.BinomioDeNewton;
import trabajoPractico.Polinomio;

public class NewtonTest {

	@Test
	public void testTerminoQueOcupaElLugarKIterativo() {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 2, 6);
		
		double resultado = binomio.terminoQueOcupaElLugarKIterativo(5);
		
		Assert.assertEquals(12, resultado, 0);
	}
	@Test
	public void testTerminoQueOcupaElLugarKIRecursivo() {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 2, 6);
		
		double resultado = binomio.terminoQueOcupaElLugarKRecursivo(5);
		
		Assert.assertEquals(12, resultado, 0);
	}
	@Test
	public void testTerminoQueOcupaElLugarKIPow() {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 2, 6);
		
		double resultado = binomio.terminoQueOcupaElLugarKPow(5);
		
		Assert.assertEquals(12, resultado, 0);
	}
	@Test
	public void testQueDenTodosIgual() {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 2, 6);
		int k = 5;
		
		double resultadoIterativo = binomio.terminoQueOcupaElLugarKIterativo(k);
		double resultadoRecursivo = binomio.terminoQueOcupaElLugarKRecursivo(k);
		double resultadoPow = binomio.terminoQueOcupaElLugarKPow(k);
		
		Assert.assertEquals(resultadoIterativo, resultadoRecursivo, 0);
		Assert.assertEquals(resultadoRecursivo, resultadoPow, 0);
		Assert.assertEquals(resultadoPow, resultadoIterativo, 0);

		binomio = new BinomioDeNewton(8, 2, 10);
		k = 2;
		
		resultadoIterativo = binomio.terminoQueOcupaElLugarKIterativo(k);
		resultadoRecursivo = binomio.terminoQueOcupaElLugarKRecursivo(k);
		resultadoPow = binomio.terminoQueOcupaElLugarKPow(k);
		
		Assert.assertEquals(resultadoIterativo, resultadoRecursivo, 0);
		Assert.assertEquals(resultadoRecursivo, resultadoPow, 0);
		Assert.assertEquals(resultadoPow, resultadoIterativo, 0);
	}

	@Test
	public void testTIEMPOS() throws Exception {
		BinomioDeNewton binomio = new BinomioDeNewton(8, 2, 10);
		int k = 2;
		long startTime, endTime, duration;

		startTime = System.nanoTime();
		double resultadoIterativo = binomio.terminoQueOcupaElLugarKIterativo(k);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("terminoQueOcupaElLugarKIterativo: " + duration + " nanosegundos");

		startTime = System.nanoTime();
		double resultadoRecursivo = binomio.terminoQueOcupaElLugarKRecursivo(k);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("terminoQueOcupaElLugarKRecursivo: " + duration + " nanosegundos");	
		
		startTime = System.nanoTime();
		double resultadoPow = binomio.terminoQueOcupaElLugarKPow(k);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("terminoQueOcupaElLugarKPow: " + duration + " nanosegundos");	
	}
}
