package algoritmos;

import java.util.ArrayList;
import java.util.Comparator;

public class Insercion<T> extends Ordenador<T> {
	
	public Insercion(ArrayList<T> aOrdenar, Comparator<T> comparador) {
		super(aOrdenar, comparador);
	}

	@Override
	public ArrayList<T> realizarOrdenamiento() {
		int p, j;
	    T aux;
	    for (p = 1; p < super.aOrdenar.size(); p++){ 										// desde el segundo elemento hasta
	    	aux = super.aOrdenar.get(p); 													// el final, guardamos el elemento y
	    	j = p - 1; 																		// empezamos a comprobar con el anterior
			  
	    	while (j >= 0 && super.comparador.compare(aux, super.aOrdenar.get(j)) < 0) { 	// mientras queden posiciones y el
	    		super.aOrdenar.set(j + 1, super.aOrdenar.get(j));							// valor de aux sea menor que los
	    		j--; 			                  											// de la izquierda, se desplaza a la derecha
	    	}	              
	    	super.aOrdenar.set(j + 1, aux);													// colocamos aux en su sitio
	    }
	    
	    return super.aOrdenar;
	}
}
