package test;

import grafo.*;
import algoritmos.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlgoritmos {
	private static final String CARPETA_PRUEBAS = "src-grafos/LoteDePruebas/in/";
	private static final String CARPETA_PRUEBAS_SALIDA = "src-grafos/LoteDePruebas/out/";	

	@Test
	public void testBFS() {
		GrafoNDNP grafoNDNP = new GrafoNDNP(CARPETA_PRUEBAS + "simple_8nodos.in");
		BFS bfs = new BFS(grafoNDNP, 0);
		
		bfs.ejecutar(CARPETA_PRUEBAS_SALIDA);
	}
	@Test
	public void testDFS() {
		GrafoNDNP grafoNDNP = new GrafoNDNP(CARPETA_PRUEBAS + "simple_8nodos.in");
		DFS dfs = new DFS(grafoNDNP, 0);
		
		dfs.ejecutar(CARPETA_PRUEBAS_SALIDA);
	}
	@Test
	public void testDijkstra() {
		GrafoNDP drafoNDP = new GrafoNDP(CARPETA_PRUEBAS + "ALEATORIO_PROB_10_0.2_PONDERADO.in");
		Dijkstra dijkstra = new Dijkstra(drafoNDP, 0);
		
		dijkstra.ejecutar(CARPETA_PRUEBAS_SALIDA);
	}

}
