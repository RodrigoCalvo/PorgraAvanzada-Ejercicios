package test;
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
	public void testTerminoQueOcupaElLugarKQueDenTodosIgual() {
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
	public void testTerminoQueOcupaElLugarKTIEMPOS() throws Exception {
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


	@Test
	public void testObtenerPolinomioIterativo() throws Exception {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 1, 3);
		Polinomio polimonioCorrecto = new Polinomio(new double[]{1, 3, 3, 1});
		
		Polinomio polinomioIterativo = binomio.obtenerPolinomioIterativo();

		//System.out.println("polimonioCorrecto: " + polimonioCorrecto);
		//System.out.println("polinomioIterativo: " + polinomioIterativo);
		
		Assert.assertEquals(polimonioCorrecto, polinomioIterativo);
	}
	@Test
	public void testObtenerPolinomioRecursivo() throws Exception {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 1, 3);
		Polinomio polimonioCorrecto = new Polinomio(new double[]{1, 3, 3, 1});
		
		Polinomio polinomioRecursivo = binomio.obtenerPolinomioRecursivo();

		//System.out.println("polimonioCorrecto: " + polimonioCorrecto);
		//System.out.println("polinomioRecursivo: " + polinomioRecursivo);
		
		Assert.assertEquals(polimonioCorrecto, polinomioRecursivo);
	}
	@Test
	public void testObtenerPolinomioPow() throws Exception {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 1, 3);
		Polinomio polimonioCorrecto = new Polinomio(new double[]{1, 3, 3, 1});
		
		Polinomio polinomioPow = binomio.obtenerPolinomioPow();

		//System.out.println("polimonioCorrecto: " + polimonioCorrecto);
		//System.out.println("polinomioPow: " + polinomioPow);
		
		Assert.assertEquals(polimonioCorrecto, polinomioPow);
	}
	
	@Test
	public void testObtenerPolinomioQueDenTodosIgual() throws Exception {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 1, 3);
		Polinomio polimonioCorrecto = new Polinomio(new double[]{1, 3, 3, 1});
		
		Polinomio polinomioIterativo = binomio.obtenerPolinomioIterativo();
		Polinomio polinomioRecursivo = binomio.obtenerPolinomioRecursivo();
		Polinomio polinomioPow = binomio.obtenerPolinomioPow();

		//System.out.println("polimonioCorrecto: " + polimonioCorrecto);
		//System.out.println("polinomioIterativo: " + polinomioIterativo);
		
		Assert.assertEquals(polimonioCorrecto, polinomioIterativo);
		Assert.assertEquals(polimonioCorrecto, polinomioRecursivo);
		Assert.assertEquals(polimonioCorrecto, polinomioPow);		
	}

	@Test
	public void testObtenerPolinomioTIEMPOS() throws Exception {
		BinomioDeNewton binomio = new BinomioDeNewton(8, 2, 15);
		long startTime, endTime, duration;

		startTime = System.nanoTime();
		Polinomio polinomioIterativo = binomio.obtenerPolinomioIterativo();
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("obtenerPolinomioIterativo: " + duration + " nanosegundos");

		startTime = System.nanoTime();
		Polinomio polinomioRecursivo = binomio.obtenerPolinomioRecursivo();
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("obtenerPolinomioRecursivo: " + duration + " nanosegundos");

		startTime = System.nanoTime();
		Polinomio polinomioPow = binomio.obtenerPolinomioPow();
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("polinomioPow: " + duration + " nanosegundos");
	}
}
