package test;

import probador.*;

import org.junit.Assert;
import org.junit.Test;

import grafo.Generador;
import grafo.GrafoNDNP;


public class TestProgramaProbador {
	private static final String CARPETA_PROGRAMA_PROBADOR = "ProgramaProbador/";
	private static final String CARPETA_PRUEBAS = "LoteDePruebas/in/";
	private static final String CARPETA_PRUEBAS_SALIDA = "LoteDePruebas/out/";	

	@Test
	public void test() {
		//GrafoNDNP grafo = new GrafoNDNP(CARPETA_PRUEBAS + "GrafoReg_1000_75.in");
		/*
		GrafoNDNP grafo = Generador.generarGrafoNDNPAleatorioAdyac(10, 0.2);
		grafo.escribirArchivoEntrada(CARPETA_PROGRAMA_PROBADOR + "adyacente10_0_2.in");
		
		grafo = new GrafoNDNP(CARPETA_PROGRAMA_PROBADOR + "adyacente10_0_2.in");
		grafo.colorearSecuencialAleatorio(true, CARPETA_PROGRAMA_PROBADOR);
		*/
		ProgramaProbador pp = new ProgramaProbador(CARPETA_PRUEBAS + "simple_8nodos.in",
				CARPETA_PRUEBAS_SALIDA + "COLOREO_REC_8_0,39.out");
		
		Assert.assertEquals(true, pp.probar());
	}

}
