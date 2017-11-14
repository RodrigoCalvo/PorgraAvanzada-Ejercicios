package monticulo;

import java.util.ArrayList;
import java.util.Comparator;

public class Monticulo<T> {
	private ArrayList<T> vector;	
	private int tope = 0;
	private Comparator<T> comparador;
	private int tipo;

	/**
	 * Constructor del monticulo
	 * @param tipo, indica si el monticulo es de baja o de alta. 1 alta, 0 baja.
	 */
	public Monticulo(int tipo, Comparator<T> comparador) {
		this.tipo = tipo;
		this.comparador = comparador;
		this.vector = new ArrayList<>();
		this.vector.add(null);
	}
	
	public void agregar(T elemento){		
		this.tope++;
		this.vector.add(elemento);		
		
		if(this.tope > 1) {			
			 int i = this.tope /2;
			 int j = this.tope;
			 T aux;			 
			 
			 if (tipo == 1) {
				 while (i >= 1 && this.comparador.compare(vector.get(i), this.vector.get(j)) < 0) {
					 aux = this.vector.get(i);
					 this.vector.set(i, this.vector.get(j));
					 this.vector.set(j, aux);
					 
					 j = i;
					 i = i / 2;
				 }	
			 } else {
				 while (i >= 1 && this.comparador.compare(vector.get(i), this.vector.get(j)) > 0) {
					 aux = this.vector.get(i);
					 this.vector.set(i, this.vector.get(j));
					 this.vector.set(j, aux);
					 
					 j = i;
					 i = i / 2;
				 }					 
			 }
		}		
	}
	
	public T sacar() {
		T aux ;
		aux = this.vector.get(1);
		this.vector.set(1, this.vector.get(this.tope));
		this.vector.remove(tope);
		this.tope--;
		
		int i = 1;
		int hi = 2;
		int hd = 3;		

		if (tipo == 1) {
			while(i < this.tope && hi < this.tope 
				&&(this.comparador.compare(this.vector.get(i), this.vector.get(hi)) < 0 
						|| this.comparador.compare(this.vector.get(i), this.vector.get(hd)) < 0)) {
				if(this.comparador.compare(this.vector.get(hi), this.vector.get(hd)) < 0) {
					T aux1 = this.vector.get(i);
					this.vector.set(i, this.vector.get(hd));
					this.vector.set(hd, aux1);
					i = hd;			
				} else {
					T aux1 = this.vector.get(i);
					this.vector.set(i, this.vector.get(hi));
					this.vector.set(hi, aux1);
					i = hi;
				}		
				
				hi = i * 2;
				hd = i * 2 + 1;
				if(hd > this.tope)
					hd = hi;
			}
		} else {
			while(i < this.tope && hi < this.tope 
					&&(this.comparador.compare(this.vector.get(i), this.vector.get(hi)) > 0 
							|| this.comparador.compare(this.vector.get(i), this.vector.get(hd)) > 0)) {
				if(this.comparador.compare(this.vector.get(hi), this.vector.get(hd)) > 0) {
					T aux1 = this.vector.get(i);
					this.vector.set(i, this.vector.get(hd));
					this.vector.set(hd, aux1);
					i = hd;			
				} else {
					T aux1 = this.vector.get(i);
					this.vector.set(i, this.vector.get(hi));
					this.vector.set(hi, aux1);
					i = hi;
				}		
				
				hi = i * 2;
				hd = i * 2 + 1;
				if(hd > this.tope)
					hd = hi;
			}			
		}
		
		return aux;
	}

	public void vaciar() {
		this.vector = new ArrayList<>();
		this.tope = 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tope;
		result = prime * result + ((vector == null) ? 0 : vector.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monticulo other = (Monticulo) obj;
		if (tope != other.tope)
			return false;
		if (vector == null) {
			if (other.vector != null)
				return false;
		} else if (!vector.equals(other.vector))
			return false;
		return true;
	}

	public ArrayList<T> getVector() {
		return vector;
	}
}
