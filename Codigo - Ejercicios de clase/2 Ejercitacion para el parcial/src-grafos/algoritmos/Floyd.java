package algoritmos;

import grafo.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

public class Floyd {

	private static final int INFINITO = -1;
	private GrafoDP grafo;
	private int cantNodos;
	
	private int[][] costosMinimos;

	public GrafoDP getGrafo() {
		return grafo;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public int[][] getCostosMinimos() {
		return costosMinimos;
	}

	public Floyd(GrafoDP grafo) {
		this.grafo = grafo;
		this.cantNodos = grafo.getCantNodos();
		this.costosMinimos = new int[this.cantNodos][this.cantNodos];	
	}
	
	public void ejecutar(String path) {
		// clono la matriz de adyacencia para calcular los costos m�nimos
		this.costosMinimos = this.grafo.getGrafo().clone();
		
		int anterior, ik, kj, actual, minimo;
		
		// para cada iteraci�n k del algoritmo
		for (int k = 0; k < this.cantNodos; k++) {
			// para cada fila de la matriz
			for (int i = 0; i < this.cantNodos; i++) {
				// para cada columna de la matriz
				for (int j = 0; j < this.cantNodos; j++) {
					
					// si el pivot ij no est� en la diagonal principal ni en la fila k o columna k
					if (i != j && k != i && k != j) {
						// costo de la iteraci�n anterior
						anterior = this.costosMinimos[i][j];
						
						// costo de usar como intermediario al nodo k
						ik = this.costosMinimos[i][k];
						kj = this.costosMinimos[k][j];
						if (ik == INFINITO || kj == INFINITO) {
							actual = INFINITO;
						} else {
							actual = ik + kj;
						}
						
						// selecciono el costo m�nimo
						if (actual != INFINITO && actual < anterior) {
							minimo = actual;
						} else {
							minimo = anterior;
						}
						this.costosMinimos[i][j] = minimo;
					}
				}
			}
		}
		
		// muestro soluci�n en consola
		this.escribirSolucionEnConsola();
				
		// escribo la soluci�n completa en un archivo
		this.escribirSolucionEnArchivo(path + "FLOYD" + "_" + this.cantNodos + "_"
						+ String.format("%.2f", this.getGrafo().getPtajeAdyacencia()) + ".out");
			
	}

	private void escribirSolucionEnConsola() {
		int costo;
		System.out.println("FLOYD: Costos m�nimos entre todos los nodos ");
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = 0; j < this.cantNodos; j++) {
				costo = this.costosMinimos[i][j];
				if (costo == INFINITO) {
					System.out.println("Nodo Inicial: " + i + " Nodo Final: " + j + " Costo del Camino M�s Corto: INFINITO");
				} else {
					System.out.println("Nodo Inicial: " + i + " Nodo Final: " + j + " Costo del Camino M�s Corto: " + costo);
				}
			}
		}	
	}

	private void escribirSolucionEnArchivo(String path) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);

			pw.println(this.cantNodos + " " + this.getGrafo().getCantAristas() + " " + this.getGrafo().getPtajeAdyacencia() + " " + 
			this.grafo.getGradoMax() + " " + this.grafo.getGradoMin());


			for (int i = 0; i < this.cantNodos; i++) {
				for (int j = 0; j < this.cantNodos; j++) {
					pw.println(i + " " + j + " " + this.costosMinimos[i][j]);
				}	
			}
				
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}