package test;

import static org.junit.Assert.*;

import org.junit.Test;

import grafo.GrafoNDNP;

public class TestColoreo {	
	private static final String CARPETA_PRUEBAS = "src-grafos/LoteDePruebas/in/";
	private static final String CARPETA_PRUEBAS_SALIDA = "src-grafos/LoteDePruebas/out/";	
	private static final int SECUENCIAL_ALEATORIO = 1;
	private static final int POWELL = 2;
	private static final int MATULA = 3;
	private static final int CANTIDAD_DE_VECES_A_CORRER = 20000; 
	/*
	@Test
	public void analisisGrafo600y40AS() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.4.in");
		grafo.ejecutarCaso(SECUENCIAL_ALEATORIO, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "Coloreo_Secuencial_0.4.out");
	}
	@Test
	public void analisisGrafo600y40WP() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.4.in");
		grafo.ejecutarCaso(POWELL, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "Coloreo_Powell_0.4.out");
	}	
	@Test
	public void analisisGrafo600y40M() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.4.in");
		grafo.ejecutarCaso(MATULA, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "Coloreo_Matula_0.4.out");
	}	
	@Test
	public void analisisGrafo600y40REC() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.4.in");
		grafo.ejecutarCasoREC(CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "Coloreo_REC_0.4.out");
	}
	@Test
	public void analisisGrafo600y60AS() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.6.in");		
		grafo.ejecutarCaso(SECUENCIAL_ALEATORIO, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "Coloreo_Secuencial_0.6.out");	
	}	
	@Test
	public void analisisGrafo600y60WP() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.6.in");
		grafo.ejecutarCaso(POWELL, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "Coloreo_Powell_0.6.out");
	}	
	@Test
	public void analisisGrafo600y60M() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.6.in");
		grafo.ejecutarCaso(MATULA, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "Coloreo_Matula_0.6.out");
	}	
	*//*
	@Test
	public void analisisGrafo600y90AS() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.9.in");		
		grafo.ejecutarCaso(SECUENCIAL_ALEATORIO, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "Coloreo_Secuencial_0.9.out");	
	}	
	@Test
	public void analisisGrafo600y90WP() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.9.in");
		grafo.ejecutarCaso(POWELL, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "Coloreo_Powell_0.9.out");
	}	
	@Test
	public void analisisGrafo600y90M() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.9.in");
		grafo.ejecutarCaso(MATULA, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "Coloreo_Matula_0.9.out");
	}	*/
	@Test
	public void analisisGrafo600y90REC() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "Grafo_600_0.9.in");
		grafo.ejecutarCasoREC(1000000, CARPETA_PRUEBAS_SALIDA + "Coloreo_REC_0.9.out");
	}
	/*
	@Test
	public void analisisGrafoRegular1000y50AS() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "GrafoReg_1000_50.in");		
		grafo.ejecutarCaso(SECUENCIAL_ALEATORIO, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "GrafoReg_Coloreo_Secuencial_50.out");	
	}	
	@Test
	public void analisisGrafoRegular1000y50WP() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "GrafoReg_1000_50.in");
		grafo.ejecutarCaso(POWELL, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "GrafoReg_Coloreo_Powell_50.out");
	}	
	@Test
	public void analisisGrafoRegular1000y50M() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "GrafoReg_1000_50.in");
		grafo.ejecutarCaso(MATULA, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "GrafoReg_Coloreo_Matula_50.out");
	}	
	
	@Test
	public void analisisGrafoRegular1000y75AS() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "GrafoReg_1000_75.in");		
		grafo.ejecutarCaso(SECUENCIAL_ALEATORIO, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "GrafoReg_Coloreo_Secuencial_75.out");	
	}	
	@Test
	public void analisisGrafoRegular1000y75WP() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "GrafoReg_1000_75.in");
		grafo.ejecutarCaso(POWELL, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "GrafoReg_Coloreo_Powell_75.out");
	}	
	@Test
	public void analisisGrafoRegular1000y75M() {
		GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "GrafoReg_1000_75.in");
		grafo.ejecutarCaso(MATULA, CANTIDAD_DE_VECES_A_CORRER, CARPETA_PRUEBAS_SALIDA + "GrafoReg_Coloreo_Matula_75.out");
	}
	*/
}
