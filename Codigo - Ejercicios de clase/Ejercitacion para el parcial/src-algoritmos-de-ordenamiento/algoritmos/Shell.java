package algoritmos;

import java.util.ArrayList;
import java.util.Comparator;

public class Shell <T> extends Ordenador<T> {
	
	public Shell(ArrayList<T> aOrdenar, Comparator<T> comparador) {
		super(aOrdenar, comparador);
	}

	@Override
	public ArrayList<T> realizarOrdenamiento() {
		int j;
		for(int gap = super.aOrdenar.size() / 2; gap > 0; gap /= 2) {
			for( int i = gap; i < super.aOrdenar.size(); i++) {
				T tmp = super.aOrdenar.get(i);
				for(j = i; j >= gap && comparador.compare(tmp, super.aOrdenar.get(j -gap)) < 0; j -= gap) {
					super.aOrdenar.set(j, super.aOrdenar.get(j -gap));
				}
				super.aOrdenar.set(j, tmp);
			}
		}
		return super.aOrdenar;
	}
}
