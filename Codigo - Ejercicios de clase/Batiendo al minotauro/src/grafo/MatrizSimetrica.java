package grafo;

import java.util.Arrays;

public class MatrizSimetrica {
	private int[] vector;
	private int n;
	
	public MatrizSimetrica(int n) {
		this.n = n;
		this.vector = new int[n*(n-1)/2];
	}
	public int getPos(int i, int j) {
		if(i > j) {
			int aux = i;
			i = j;
			j = aux;
		}
		
		int pos = (int) (i * this.n + j - (Math.pow(i, 2) + 3 * i + 2) / 2);
		return this.vector[pos];
	}
	public void setPos(int i, int j, int valor) {
		if(i > j) {
			int aux = i;
			i = j;
			j = aux;
		}
			
		int pos = (int)(i * this.n + j - (Math.pow(i, 2) + 3 * i + 2) / 2);
		this.vector[pos] = valor;
	}
	@Override
	public String toString() {
		return "MatrizSimetrica [vector=" + Arrays.toString(vector) + "]";
	}
	
	public int getMatrizSize() {
		return this.n;
	}
}
