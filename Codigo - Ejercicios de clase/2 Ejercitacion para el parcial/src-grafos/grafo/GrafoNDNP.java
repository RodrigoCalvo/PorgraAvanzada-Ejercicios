package grafo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import comparadores.NodoPorGradoDeMayorAMenor;
import comparadores.NodoPorGradoDeMenorAMayor;
import sorter.QuickSort;

/**
 * Grafo no ponderado no direccionado
 * 
 * @author Grupo 22
 */
public class GrafoNDNP {
	private ArrayList<Nodo> nodos;
	private int cantAristas;
	private MatrizSimetrica matrizSimetrica;
	private double porcentajeAdyacencia;
	private int gradoMax;
	private int gradoMin;
	private int cantidadNodos;
	private int cantidadDeColores;

	public GrafoNDNP(String inputFile) {
		try {
			Scanner sc = new Scanner(new File(inputFile));
			sc.useLocale(Locale.ENGLISH);

			this.cantidadNodos = sc.nextInt();
			this.nodos = new ArrayList<>(cantidadNodos);
			this.matrizSimetrica = new MatrizSimetrica(this.cantidadNodos);
			this.cantAristas = sc.nextInt();
			this.porcentajeAdyacencia = sc.nextDouble();
			this.gradoMax = sc.nextInt();
			this.gradoMin = sc.nextInt();

			for (int i = 0; i < this.cantidadNodos; i++) {
				this.nodos.add(i, new Nodo(i, 0, 0));
			}

			for (int i = 0; i < this.cantAristas; i++) {
				int fila = sc.nextInt();
				int columna = sc.nextInt();

				this.matrizSimetrica.setPos(fila, columna);

				this.nodos.get(fila).setGrado(this.nodos.get(fila).getGrado() + 1);
				this.nodos.get(columna).setGrado(this.nodos.get(columna).getGrado() + 1);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public GrafoNDNP(MatrizSimetrica matrizSimetrica, int cantidadNodos, int cantAristas, double porcentajeAdyacencia,
			int gradoMax, int gradoMin) {

		this.matrizSimetrica = matrizSimetrica;
		this.cantidadNodos = cantidadNodos;
		this.cantAristas = cantAristas;
		this.porcentajeAdyacencia = porcentajeAdyacencia;
		this.gradoMax = gradoMax;
		this.gradoMin = gradoMin;
	}

	public void escribirArchivoEntrada(String inputFile) {
		PrintWriter entrada = null;

		try {
			entrada = new PrintWriter(new File(inputFile));

			entrada.println(this.cantidadNodos + " " + this.cantAristas + " " + this.porcentajeAdyacencia + " "
					+ this.gradoMax + " " + this.gradoMin);

			for (int i = 0; i < this.cantidadNodos; i++) {
				for (int j = i + 1; j < this.cantidadNodos; j++) {
					if (this.matrizSimetrica.getPos(i, j))
						entrada.println(i + " " + j);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			entrada.close();
		}
	}

	private void colorearPowell() {
		this.colorearPowell(false, "");
	}
	
	public void colorearPowell(boolean imprimirArchivo, String path) {
		NodoPorGradoDeMayorAMenor comparador = new NodoPorGradoDeMayorAMenor();
		QuickSort<Nodo> sort = new QuickSort<>(this.nodos, comparador);
		this.nodos = sort.realizarOrdenamiento();
		
		colorear();
		
		if(imprimirArchivo)
			escribirSolucionDeColoreo(path, "POWELL");
	}

	private void colorearMatula() {
		this.colorearMatula(false, "");
	}

	public void colorearMatula(boolean imprimirArchivo, String path) {
		NodoPorGradoDeMenorAMayor comparador = new NodoPorGradoDeMenorAMayor();
		QuickSort<Nodo> sort = new QuickSort<>(this.nodos, comparador);
		this.nodos = sort.realizarOrdenamiento();
		
		colorear();
		
		if(imprimirArchivo)
			escribirSolucionDeColoreo(path, "MATULA");
	}

	private void colorearSecuencialAleatorio() {
		this.colorearSecuencialAleatorio(false, "");
	}
	
	public void colorearSecuencialAleatorio(boolean imprimirArchivo, String path) {
		colorear();
		
		if(imprimirArchivo)
			escribirSolucionDeColoreo(path, "SECUENCIAL");
	}
	
	public void colorearREC() {
		this.colorearREC(false, "");
	}
	
	public void colorearREC(boolean imprimirArchivo, String path) {
		/*
		Paso 1: Ordenamos por grado de menor a mayor.
		Paso 2: Creamos un arrayList de arrayList de nodos para los grupos
		Paso 3: Recorremos nodo a nodo y armamos grupos donde no haya adyacencias entre si
		*/
		NodoPorGradoDeMenorAMayor comparador = new NodoPorGradoDeMenorAMayor();
		QuickSort<Nodo> sort = new QuickSort<>(this.nodos, comparador);
		this.nodos = sort.realizarOrdenamiento();
		
		ArrayList<ArrayList<Nodo>> grupos = new ArrayList<>();
		
		for (Nodo nodo : this.nodos) {
			int indiceDelGrupo = 0;
			
			for (ArrayList<Nodo> grupo : grupos) {
				boolean puedeIrAlGrupo = true;
				
				for(Nodo integranteDelGrupo : grupo) {
					if(esAdyacente(nodo, integranteDelGrupo)) {
						puedeIrAlGrupo = false;
						break;
					} 
				}
				if(puedeIrAlGrupo)
					break;
				else
					indiceDelGrupo++;
			}
			
			nodo.setColor(indiceDelGrupo);
			
			if(indiceDelGrupo >= grupos.size()) {
				ArrayList<Nodo> nuevoGrupo = new ArrayList<>();
				nuevoGrupo.add(nodo);
				grupos.add(nuevoGrupo);
			} else {
				grupos.get(indiceDelGrupo).add(nodo);
			}
		}
		
		this.cantidadDeColores = grupos.size();
		
		if(imprimirArchivo)
			escribirSolucionDeColoreo(path, "REC");
	}

	
	private void colorear() {
		int i;
		int color;
		this.cantidadDeColores = 0;

		for (i = 0; i < this.cantidadNodos; i++) {
			color = 1;
			while (!sePuedeColorear(i, color))
				color++;

			this.nodos.get(i).setColor(color);
			if (color > this.cantidadDeColores)
				this.cantidadDeColores = color;
		}
	}

	public ArrayList<Nodo> getNodos() {
		return nodos;
	}

	private boolean sePuedeColorear(int pos, int color) {
		int i = 0;
		/*
		if (this.nodos.get(pos).getColor() != 0) //si el nodo fue coloreado 
			return false;
		*/
		//no puedo colorear
		while (i < this.cantidadNodos) {
			if (this.nodos.get(i).getColor() == color) { //si el nodo a colorear es adyacente a un nodo ya pintado de ese
				if (esAdyacente(this.nodos.get(i), this.nodos.get(pos))) //color, no lo podré colorear
					return false;
			}
			i++;
		}
		return true;
	}

	private boolean esAdyacente(Nodo nodoUno, Nodo nodoDos) {
		return this.matrizSimetrica.getPos(nodoUno.getNumero(), nodoDos.getNumero());
	}

	public void selectorColoreoGrafo(int algoritmo) {
		if (algoritmo == 1)
			colorearSecuencialAleatorio();

		if (algoritmo == 2)
			colorearPowell();

		if (algoritmo == 3)
			colorearMatula();
	}

	public void ejecutarCaso(int cod_algoritmo, int cantCorridas, String path) {
		int cantColor[] = new int[this.cantidadNodos];
		int nroCromatico = this.cantidadNodos;
		int corri=0;
		ArrayList<Nodo> grafoColoreado = null;

		for (int i = 0; i < cantCorridas; i++) {
			selectorColoreoGrafo(cod_algoritmo);
			cantColor[cantidadDeColores] += 1;
			if (cantidadDeColores < nroCromatico) {
				nroCromatico = cantidadDeColores;
				corri =  i+1;
				grafoColoreado = nodos;
			}
			alterarOrdenNodos();
		}

		grabarResumenCaso(cod_algoritmo, cantColor, nroCromatico, path, corri);
	}
	public void ejecutarCasoREC(int cantCorridas, String path) {
		int cantColor[] = new int[this.cantidadNodos];
		int nroCromatico = this.cantidadNodos;
		int corri=0;
		ArrayList<Nodo> grafoColoreado = null;

		for (int i = 0; i < cantCorridas; i++) {
			colorearREC();
			cantColor[cantidadDeColores] += 1;
			if (cantidadDeColores < nroCromatico) {
				nroCromatico = cantidadDeColores;
				corri =  i+1;
				grafoColoreado = nodos;
			}
			alterarOrdenNodos();
		}

		grabarResumenCaso(4, cantColor, nroCromatico, path, corri);
	}

	private void alterarOrdenNodos() {
		cantidadDeColores = 0; //vuelvo a setearlo en 0 por si se ejecuta varias veces el coloreo
		ArrayList<Nodo> vectorAux =  new ArrayList<Nodo>(this.cantidadNodos); //creo vector auxiliar donde voy a alterar posiciones 
		int[] numeros = new int[this.cantidadNodos];
		Random rnd = new Random();
		int aux = this.cantidadNodos, pos;
		
		/*
		//se rellena una matriz ordenada del 1 al..n
		for (int i = 0; i < this.cantidadNodos; i++) {
			numeros[i] = i;
			vectorAux.add(i, null);
		}
		*/
		for (int i = 0; i < this.cantidadNodos; i++) {
			this.nodos.get(i).setColor(0);
		}
		Collections.shuffle(this.nodos);
		/*
		for (int i = 0; i < this.cantidadNodos; i++) {
			pos = rnd.nextInt(aux);
			vectorAux.set(numeros[pos], new Nodo(this.nodos.get(i).getNumero(), 0, this.nodos.get(i).getGrado())); //cambio la pos del nodo, en un vector de nodos aux
			numeros[pos] = numeros[aux - 1];
			aux--;
		}*/
		//this.nodos = vectorAux;
		vectorAux = null;
	}

	public void grabarResumenCaso(int cod_algoritmo, int[] cantColor, int nroCromatico, String path, int corri) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			pw.println("Algoritmo: " + cod_algoritmo);
			pw.println("NRO CROMATICO: " + nroCromatico);
			pw.println("Corrida con menor cant. de colores: " + corri);
			pw.println("CantColores  CantRepeticiones");
		
			for (int i = 0; i < cantColor.length; i++) {
				if (cantColor[i] > 0)
					pw.println(i + " " + cantColor[i]);
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
	
	private void escribirSolucionDeColoreo(String path, String algoritmo) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(path + "COLOREO" + "_" + algoritmo + "_" + this.cantidadNodos + "_"
					+ String.format("%.2f", this.porcentajeAdyacencia) + ".out");
			pw = new PrintWriter(fw);

			pw.println(this.cantidadNodos + " " + this.cantidadDeColores + " " + this.cantAristas + " " + this.porcentajeAdyacencia + " " 
			+ this.gradoMax + " " + this.gradoMin);
			
			for (Nodo nodo : this.nodos) {
				pw.println(nodo.getNumero() + " " + nodo.getColor());
			}
			/*
			for (int i = 0; i < this.nodos.size(); i++) {
				pw.println(i + " " + nodos.get(i).getColor());
			}*/
			
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

	public MatrizSimetrica getMatrizSimetrica() {
		return matrizSimetrica;
	}
	
	public void cargarColoreo(String inputFile) {
		try {
			Scanner sc = new Scanner(new File(inputFile));
			sc.useLocale(Locale.ENGLISH);

			this.cantidadNodos = sc.nextInt();
			this.cantidadDeColores = sc.nextInt();
			this.cantAristas = sc.nextInt();
			this.porcentajeAdyacencia = sc.nextDouble();
			this.gradoMax = sc.nextInt();
			this.gradoMin = sc.nextInt();
			
			for (int i = 0; i < this.cantidadNodos; i++) {
				this.nodos.get(sc.nextInt()).setColor(sc.nextInt());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public double getPorcentajeAdyacencia() {
		return porcentajeAdyacencia;
	}

	public int getGradoMax() {
		return gradoMax;
	}

	public int getGradoMin() {
		return gradoMin;
	}

	public int getCantidadNodos() {
		return cantidadNodos;
	}

	public int getCantidadDeColores() {
		return cantidadDeColores;
	}
	
	
}
