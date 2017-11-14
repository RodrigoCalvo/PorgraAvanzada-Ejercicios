package test;

import org.junit.Test;

import grafo.Generador;
import grafo.GrafoNDNP;

public class TestGenerador {	
	private static final String CARPETA_PRUEBAS = "LoteDePruebas/in/";

	@Test
	public void generarGrafoNDNPProfe() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPRegularGradoN(200, 20);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "PROFE_GrafoReg_200_20.in");
	}
	@Test
	public void generarGrafoNDNPAleatorioAdyac600y40() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPAleatorioAdyac(600, 0.4);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "Grafo_600_0.4.in");
	}
	
	@Test
	public void generarGrafoNDNPAleatorioAdyac600y60() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPAleatorioAdyac(600, 0.6);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "Grafo_600_0.6.in");
	}
	
	@Test
	public void generarGrafoNDNPAleatorioAdyac600y90() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPAleatorioAdyac(600, 0.9);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "Grafo_600_0.9.in");
	}

	@Test
	public void generarGrafoNDNPRegularGradoNYPorcentajeDeAdyacencia1000y50() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPRegularGradoNYPorcentajeDeAdyacencia(1000, 0.5);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "GrafoReg_1000_50.in");
	}
	
	@Test
	public void generarGrafoNDNPRegularGradoNYPorcentajeDeAdyacencia1000y75() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPRegularGradoNYPorcentajeDeAdyacencia(1000, 0.75);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "GrafoReg_1000_75.in");
	}
}
