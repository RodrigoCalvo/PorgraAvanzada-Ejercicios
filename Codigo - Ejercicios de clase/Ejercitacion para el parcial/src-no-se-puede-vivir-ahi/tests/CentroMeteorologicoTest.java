package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ejercicio.CentroMeteorologico;

public class CentroMeteorologicoTest {

	@Test
	public void test() {
		CentroMeteorologico centro = new CentroMeteorologico("src-no-se-puede-vivir-ahi/", "entrada.in");
		
		centro.prepararReporte();
		centro.guardarResultado();
	}

}
