package colaDePrioridad;

import java.util.Comparator;

import monticulo.Monticulo;

public class ColaDePrioridad<T> {
	
	public Monticulo<T> cola;

	public ColaDePrioridad(int tipo, Comparator<T> comparador) {		
		this.cola = new Monticulo<T>(tipo, comparador);
	}
	public T verPrimero() {
		return this.cola.getVector().get(1);
	}
	public void encolar(T elemento) {
		this.cola.agregar(elemento);
	}
	public T desacolar(){
		return cola.sacar();
	}
	
	public void vaciarCola() {
		cola.vaciar();
	}
}
