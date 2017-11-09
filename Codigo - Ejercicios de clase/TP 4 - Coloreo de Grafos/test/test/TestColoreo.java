package test;

import static org.junit.Assert.*;

import org.junit.Test;

import grafo.GrafoNDNP;

public class TestColoreo {	
	private static final String CARPETA_PRUEBAS = "LoteDePruebas/in/";
	private static final String CARPETA_PRUEBAS_SALIDA = "LoteDePruebas/out/";	
	private static final int SECUENCIAL_ALEATORIO = 1;
	private static final int POWELL = 2;
	private static final int MATULA = 3;
	private static final int CANTIDAD_DE_VECES_A_CORRER = 1000; 
	
	@Test
	public void analisisGrafo600y40AS() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafo600y40.in");
		grafo.ejecutarCaso(SECUENCIAL_ALEATORIO, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafo600y40_SA.out");
	}	
	@Test
	public void analisisGrafo600y40WP() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafo600y40.in");
		grafo.ejecutarCaso(POWELL, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafo600y40_P.out");
	}	
	@Test
	public void analisisGrafo600y40M() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafo600y40.in");
		grafo.ejecutarCaso(MATULA, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafo600y40_M.out");
	}	
	
	@Test
	public void analisisGrafo600y60AS() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafo600y60.in");		
		grafo.ejecutarCaso(SECUENCIAL_ALEATORIO, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafo600y60_SA.out");	
	}	
	@Test
	public void analisisGrafo600y60WP() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafo600y60.in");
		grafo.ejecutarCaso(POWELL, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafo600y60_P.out");
	}	
	@Test
	public void analisisGrafo600y60M() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafo600y60.in");
		grafo.ejecutarCaso(MATULA, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafo600y60_M.out");
	}	
	@Test
	public void analisisGrafo600y90AS() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafo600y90.in");		
		grafo.ejecutarCaso(SECUENCIAL_ALEATORIO, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafo600y90_SA.out");	
	}	
	@Test
	public void analisisGrafo600y90WP() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafo600y90.in");
		grafo.ejecutarCaso(POWELL, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafo600y90WP_P.out");
	}	
	@Test
	public void analisisGrafo600y90M() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafo600y90.in");
		grafo.ejecutarCaso(MATULA, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafo600y90_M.out");
	}	
	@Test
	public void analisisGrafoRegular1000y50AS() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafoRegular1000y50.in");		
		grafo.ejecutarCaso(SECUENCIAL_ALEATORIO, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafoRegular1000y50_SA.out");	
	}	
	@Test
	public void analisisGrafoRegular1000y50WP() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafoRegular1000y50.in");
		grafo.ejecutarCaso(POWELL, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafoRegular1000y50_P.out");
	}	
	@Test
	public void analisisGrafoRegular1000y50M() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafoRegular1000y50.in");
		grafo.ejecutarCaso(MATULA, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafoRegular1000y50_M.out");
	}	
	@Test
	public void analisisGrafoRegular1000y75AS() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafoRegular1000y75.in");		
		grafo.ejecutarCaso(SECUENCIAL_ALEATORIO, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafoRegular1000y75_SA.out");	
	}	
	@Test
	public void analisisGrafoRegular1000y75WP() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafoRegular1000y75.in");
		grafo.ejecutarCaso(POWELL, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafoRegular1000y75_P.out");
	}	
	@Test
	public void analisisGrafoRegular1000y75M() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "grafoRegular1000y75.in");
		grafo.ejecutarCaso(MATULA, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "grafoRegular1000y75_M.out");
	}
}
