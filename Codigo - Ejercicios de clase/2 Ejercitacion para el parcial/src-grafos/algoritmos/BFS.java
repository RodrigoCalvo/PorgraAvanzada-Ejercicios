package algoritmos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import grafo.*;

public class BFS {

	private GrafoNDNP grafo;
	private int cantNodos;
	private int cantAristas;

	private int nodoInicial;
	private ArrayList<Arista> arbol;
	private boolean[] nodoTerminado;
	

	public BFS(GrafoNDNP grafo, int nodoInicial) {
		this.grafo = grafo;
		this.cantNodos = grafo.getCantidadNodos();
		this.cantAristas = grafo.getCantAristas();

		this.nodoInicial = nodoInicial;
		this.arbol = new ArrayList<Arista>();
		this.nodoTerminado = new boolean[this.cantNodos];
	}

	public void ejecutar(String path) {
		// cola que almacena los nodos visitados
		Queue<Integer> cola = new LinkedList<Integer>();
		// acolo el nodo inicial
		cola.offer(this.nodoInicial);
		
		int nodo, indice;
		
		// mientras la cola no está vacía
		while(!cola.isEmpty()) {
			// pispeo el primer nodo de la cola
			nodo = cola.peek();
			
			// genero todos los números de nodo
			for (int i = 0; i < this.cantNodos; i++) {
				// si el nodo generado no es el nodo actual y no fue terminado
				if (nodo != i && !this.nodoTerminado[i]) {
					if(this.grafo.getMatrizSimetrica().getPos(nodo, i)) {
						// agrego la arista al árbol
						this.arbol.add(new Arista(nodo, i));
						// acolo el otro nodo de la arista para seguir recorriendo a partir de él
						cola.offer(i);
						// marco como terminado al nodo acolado
						this.nodoTerminado[i] = true;
						
					}
				}
			}
			
			// desacolo el primer nodo de la cola y lo marco como terminado
			nodo = cola.poll();
			this.nodoTerminado[nodo] = true;
		}
		
		// escribo la solucion en consola
		this.escribirSolucionEnConsola();

		// escribo la solucion completa en un archivo
		this.escribirSolucionEnArchivo(path + "BFS" + "_" + this.cantNodos + "_"
				+ String.format("%.2f", this.getGrafo().getPorcentajeAdyacencia()) + ".out");
	}

	public void escribirSolucionEnConsola() {
		System.out.println("BFS - Búsqueda en Anchura:");
		System.out.println("Cantidad de Ramas del arbol: " + this.arbol.size());
		System.out.println("Nodo Inicial del Recorrido (Raíz del arbol): " + this.nodoInicial);
		System.out.println("Lista de Ramas:");
		for (Arista rama : arbol) {
			System.out.println(rama.getNodo1() + " " + rama.getNodo2());
		}
	}

	public void escribirSolucionEnArchivo(String path) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);

			pw.println(this.cantNodos + " " + this.cantAristas + " " + this.grafo.getPorcentajeAdyacencia() + " " + this.grafo.getGradoMax() + " " 
			+ this.grafo.getGradoMin());
			
			pw.println(this.arbol.size() + " " + this.nodoInicial);
			
			for (Arista rama : this.arbol) {
				pw.println(rama.getNodo1() + " " + rama.getNodo2());
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

	public GrafoNDNP getGrafo() {
		return grafo;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public int getNodoInicial() {
		return nodoInicial;
	}
}