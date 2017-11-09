package test;

import org.junit.Test;

import grafo.Generador;
import grafo.GrafoNDNP;

public class TestGenerador {	
	private static final String CARPETA_PRUEBAS = "LoteDePruebas/in/";
	
	@Test
	public void generarGrafoNDNPAleatorioAdyac600y40() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPAleatorioAdyac(600, 0.4);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "grafo600y40.in");
	}
	
	@Test
	public void generarGrafoNDNPAleatorioAdyac600y60() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPAleatorioAdyac(600, 0.6);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "grafo600y60.in");
	}
	
	@Test
	public void generarGrafoNDNPAleatorioAdyac600y90() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPAleatorioAdyac(600, 0.9);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "grafo600y90.in");
	}

	@Test
	public void generarGrafoNDNPRegularGradoNYPorcentajeDeAdyacencia1000y50() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPRegularGradoNYPorcentajeDeAdyacencia(1000, 0.5);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "grafoRegular1000y50.in");
	}

	@Test
	public void generarGrafoNDNPRegularGradoNYPorcentajeDeAdyacencia1000y75() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPRegularGradoNYPorcentajeDeAdyacencia(1000, 0.75);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "grafoRegular1000y75.in");
	}
	/*
	@Test
	public void generarGrafoNDNPNPartito800y400() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPNPartito(800, 400);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "grafoNPartito800y400.in");
	}
	
	@Test
	public void generarGrafoNDNPNPartito100y50() {
		GrafoNDNP grafo = Generador.generarGrafoNDNPNPartito(100, 50);
		grafo.escribirArchivoEntrada(CARPETA_PRUEBAS + "grafoNPartito100y50.in");
	}
	*/
}
