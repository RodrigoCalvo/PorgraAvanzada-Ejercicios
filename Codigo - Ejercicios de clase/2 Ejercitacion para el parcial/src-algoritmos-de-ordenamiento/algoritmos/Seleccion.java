package algoritmos;

import java.util.ArrayList;
import java.util.Comparator;

public class Seleccion <T> extends Ordenador<T> {
	
	public Seleccion(ArrayList<T> aOrdenar, Comparator<T> comparador) {
		super(aOrdenar, comparador);
	}

	@Override
	public ArrayList<T> realizarOrdenamiento() {
        int pos;
        T tmp, menor;
        for (int i = 0; i < super.aOrdenar.size() - 1; i++) { 			// tomamos como menor el primero
        	menor = super.aOrdenar.get(i); 								// de los elementos que quedan por ordenar
        	pos = i;													// y guardamos su posición
        	for (int j = i + 1; j < super.aOrdenar.size(); j++){ 		// buscamos en el resto
        		if(comparador.compare(super.aOrdenar.get(j), menor) < 0) {
        			menor = super.aOrdenar.get(j); 						// del array algún elemento
    			pos = j;												// menor que el actual
        		}
        	}
        	if (pos != i) {
        		tmp = super.aOrdenar.get(i);
        		super.aOrdenar.set(i, super.aOrdenar.get(pos));			// si hay alguno menor se intercambia
        		super.aOrdenar.set(pos, tmp);
        	}
        }
        return super.aOrdenar;
	}
}
