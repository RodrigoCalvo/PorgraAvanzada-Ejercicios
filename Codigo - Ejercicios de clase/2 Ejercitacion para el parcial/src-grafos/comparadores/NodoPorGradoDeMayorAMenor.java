package comparadores;

import java.util.Comparator;

import grafo.Nodo;

public class NodoPorGradoDeMayorAMenor implements Comparator<Nodo> {
	@Override
	public int compare(Nodo o1, Nodo o2) {
		return o2.getGrado() - o1.getGrado();
	}
}

