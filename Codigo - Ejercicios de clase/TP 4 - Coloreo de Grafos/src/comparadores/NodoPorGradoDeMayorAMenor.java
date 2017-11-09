package comparadores;

import java.util.Comparator;

import grafo.Nodo;

public class NodoPorGradoDeMayorAMenor implements Comparator<Nodo> {
	@Override
	public int compare(Nodo o1, Nodo o2) {
		return o1.getGrado() - o2.getGrado();
	}
}

