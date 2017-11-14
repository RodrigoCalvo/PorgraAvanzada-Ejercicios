package generadores;

import java.util.ArrayList;
import java.util.Random;

import grafo.GrafoNDNP;
import grafo.MatrizSimetrica;



public class Generador {
	public static GrafoNDNP generarGrafoNDNPAleatorioProba(int cantNodos, double probabilidad) {
		MatrizSimetrica matrizSimetrica = new MatrizSimetrica(cantNodos);
		int cantAristas = 0;

		for (int i = 0; i < cantNodos - 1; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (Math.random() <= probabilidad) {
					matrizSimetrica.setPos(i, j);
					cantAristas++;
				}
			}
		}

		int cantMaxAristas = (cantNodos * (cantNodos - 1)) / 2;
		double porcentajeDeAdyacencia = Math.rint((cantAristas / cantMaxAristas) * 100.0);

		int[] gradoNodos = calcularGrados(matrizSimetrica, cantNodos);

		return new GrafoNDNP(matrizSimetrica, cantNodos, cantAristas, porcentajeDeAdyacencia,
				calcularGradoMax(gradoNodos, cantNodos), calcularGradoMin(gradoNodos, cantNodos));
	}

	public static GrafoNDNP generarGrafoNDNPAleatorioAdyac(int cantNodos, double porcentaje) {
		MatrizSimetrica matrizSimetrica = new MatrizSimetrica(cantNodos);
		int cantAristasMax = ((cantNodos * (cantNodos - 1)) / 2);
		int cantAristasDeseadas = (int) (cantAristasMax * porcentaje);
		int cantAristas = 0;

		while (cantAristas < cantAristasDeseadas) {
			for (int i = 0; i < cantNodos - 1; i++) {
				for (int j = i + 1; j < cantNodos; j++) {
					if (Math.random() < 0.5 && cantAristas < cantAristasDeseadas && !matrizSimetrica.getPos(i, j)) {
						matrizSimetrica.setPos(i, j);
						cantAristas++;
					}
				}
			}
		}

		int[] gradoNodos = calcularGrados(matrizSimetrica, cantNodos);

		return new GrafoNDNP(matrizSimetrica, cantNodos, cantAristas, porcentaje, calcularGradoMax(gradoNodos, cantNodos),
				calcularGradoMin(gradoNodos, cantNodos));
	}

	public static GrafoNDNP generarGrafoNDNPRegularGradoN(int cantNodos, int grado) {

		MatrizSimetrica matrizSimetrica = new MatrizSimetrica(cantNodos);
		int cantAristas = 0;
		int gradoActual = 2;
		int cantMaximaAristas = (cantNodos * (cantNodos - 1)) / 2;
		int salto = 0;
		int j = 0;

		int nodo1;
		int nodo2;

		if (grado % 2 != 0 && cantNodos % 2 != 0) {
			System.out.println("No se puede generar un GrafoNDNP regular de grado impar con N impar");
			return null;
		}
		if (grado >= cantNodos) {
			System.out.println("El grado no puede ser igual, o mayor a la cantidad de nodos");
			return null;
		}

		if (grado % 2 != 0) { // si el grado es impar, genero la cruz
			for (int i = 0; i < cantNodos / 2; i++) {
				nodo1 = i;
				nodo2 = i + cantNodos / 2;
				
				matrizSimetrica.setPos(nodo1, nodo2);

				cantAristas++;
			}
		}

		if (grado > 1) {
			while (gradoActual <= grado) {
				salto = gradoActual / 2;
				j = 0;
				for (int i = 0; i < cantNodos; i++) {
					if (i + salto < cantNodos) {
						nodo1 = i;
						nodo2 = i + salto;
						
						matrizSimetrica.setPos(nodo1, nodo2);
					} else {
						matrizSimetrica.setPos(i, j);
						
						j++;
					}
					cantAristas++;
				}
				gradoActual += 2;
			}
		}
		
		double porcentajeAdyacencia = (double) cantAristas / cantMaximaAristas;
		
		int[] gradoNodos = calcularGrados(matrizSimetrica, cantNodos);

		return new GrafoNDNP(matrizSimetrica, cantNodos, cantAristas, porcentajeAdyacencia,
				calcularGradoMax(gradoNodos, cantNodos), calcularGradoMin(gradoNodos, cantNodos));		
	}
	
	public static GrafoNDNP generarGrafoNDNPRegularGradoNYPorcentajeDeAdyacencia(int cantNodos, double porcAdyacencia) {
		int cantMaximaAristas = (cantNodos * (cantNodos - 1)) / 2;
		int grado = (int) Math.ceil((cantNodos-1) * porcAdyacencia);
		
		System.out.println("grado: " + grado + " la cuenta: " + (cantNodos-1) * porcAdyacencia);
		
		double minimo = (double) (cantNodos / 2) / cantMaximaAristas;

		if (porcAdyacencia < minimo) {
			System.out.println(
					"El porcentaje de adyacencia ingresado es demasiado bajo para generar un GrafoNDNP regular (el minimo es: "
							+ String.format("%1.3f", minimo) + ")");
			System.exit(1);
		}
		if (porcAdyacencia > 1) {
			System.out.println("El porcentaje de adyacencia ingresado es superior al 100%");
			System.exit(1);
		}

		return generarGrafoNDNPRegularGradoN(cantNodos, grado);
	}

	public static GrafoNDNP generarGrafoNDNPNPartito(int cantNodos, int n) {
		
		MatrizSimetrica matrizSimetrica = new MatrizSimetrica(cantNodos);

		ArrayList<Integer> conjuntos = new ArrayList<Integer>();
		Random rand = new Random();
		int random;
		int cantMaximaAristas = (cantNodos * (cantNodos - 1)) / 2;
		int cantAristas = 0;

		if (n > cantNodos) {
			System.out.println("La cantidad de conjuntos no puede ser mayor a la cantidad de nodos");
			System.exit(1);
		}

		for (int i = 0; i < cantNodos; i++) {
			random = rand.nextInt(n);
			conjuntos.add(random);
			//System.out.println(random);
		}

		for (int i = 0; i < cantNodos - 1; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (conjuntos.get(i) != conjuntos.get(j)) { // Si el nodo1 y el
															// nodo2 estan en
															// conjuntos
															// diferentes
					matrizSimetrica.setPos(i, j);
					cantAristas++;
				}
			}
		}

	
		
		
		double porcentajeAdyacencia = (double) cantAristas / cantMaximaAristas;
		
		int[] gradoNodos = calcularGrados(matrizSimetrica, cantNodos);

		return new GrafoNDNP(matrizSimetrica, cantNodos, cantAristas, porcentajeAdyacencia,
				calcularGradoMax(gradoNodos, cantNodos), calcularGradoMin(gradoNodos, cantNodos));	
	}

	private static int[] calcularGrados(MatrizSimetrica matrizSimetrica, int cantNodos) {
		int[] sumador = new int[cantNodos];

		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (matrizSimetrica.getPos(i, j)) {
					sumador[i] += 1;
					sumador[j] += 1;
				}
			}
		}

		return sumador;
	}

	private static int calcularGradoMax(int[] gradoNodos, int cantNodos) {
		int gradoMax = 0;

		for (int j = 0; j < gradoNodos.length; j++) {
			if (gradoNodos[j] > gradoMax)
				gradoMax = gradoNodos[j];
		}

		return gradoMax;
	}

	private static int calcularGradoMin(int[] gradoNodos, int cantNodos) {
		int gradoMin = Integer.MAX_VALUE;

		for (int j = 0; j < gradoNodos.length; j++) {
			if (gradoNodos[j] < gradoMin)
				gradoMin = gradoNodos[j];
		}

		return gradoMin;
	}
}
