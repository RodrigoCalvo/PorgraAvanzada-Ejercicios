package algoritmos;

import java.util.ArrayList;
import java.util.Comparator;

public class Burbujeo<T> extends Ordenador<T> {
	
	public Burbujeo(ArrayList<T> aOrdenar, Comparator<T> comparador) {
		super(aOrdenar, comparador);
	}
	@Override
	public ArrayList<T> realizarOrdenamiento() {
        int i, j;
        T aux;
        
        for(i=0; i < super.aOrdenar.size() - 1; i++) {
             for(j=0; j < super.aOrdenar.size() - i - 1; j++) {
            	 if(comparador.compare(super.aOrdenar.get(j + 1), super.aOrdenar.get(j)) < 0) {
            		 aux = super.aOrdenar.get(j + 1);
            		 super.aOrdenar.set(j + 1, super.aOrdenar.get(j));
            		 super.aOrdenar.set(j, aux);
            	 }
             }
        }
        return aOrdenar;
	}
}
