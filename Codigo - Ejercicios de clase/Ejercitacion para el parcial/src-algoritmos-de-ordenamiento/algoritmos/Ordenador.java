package algoritmos;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Ordenador<T> {
	protected ArrayList<T> aOrdenar;
	protected Comparator<T> comparador;

	public Ordenador(ArrayList<T> aOrdenar, Comparator<T> comparador) {
		this.aOrdenar = aOrdenar;
		this.comparador = comparador;
	}
	
	public final ArrayList<T> ordenar(){
		if (this.aOrdenar == null)
			return this.aOrdenar;
		if (this.aOrdenar.size() < 2)
			return this.aOrdenar;
		if (this.comparador == null)
			return this.aOrdenar;
		
		return realizarOrdenamiento();
	}
	
	public abstract ArrayList<T> realizarOrdenamiento();
}
