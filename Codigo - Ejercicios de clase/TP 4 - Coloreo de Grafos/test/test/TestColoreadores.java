package test;


import org.junit.Test;

import grafo.GrafoNDNP;

public class TestColoreadores {
	private static final String CARPETA_PRUEBAS = "LoteDePruebas/in/";
	private static final String CARPETA_PRUEBAS_SALIDA = "LoteDePruebas/out/";	

	@Test
	public void testREC() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.9.in");
		grafo.colorearREC(true, CARPETA_PRUEBAS_SALIDA);
	}
	
	@Test
	public void testAleatorio() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.9.in");
		grafo.colorearSecuencialAleatorio(true, CARPETA_PRUEBAS_SALIDA);
	}
	@Test
	public void testPowell() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.9.in");
		grafo.colorearPowell(true, CARPETA_PRUEBAS_SALIDA);
	}
	@Test
	public void testMatula() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.9.in");
		grafo.colorearMatula(true, CARPETA_PRUEBAS_SALIDA);
	}
}
