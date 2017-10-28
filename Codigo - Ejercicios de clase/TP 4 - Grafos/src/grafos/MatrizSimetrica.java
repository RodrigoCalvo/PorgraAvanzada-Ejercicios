package grafos;

public class MatrizSimetrica {
	private boolean[] vector;
	int n;
	
	public MatrizSimetrica(int n) {
		this.n = n;
		this.vector = new boolean[n*(n-1)/2];
	}
	public boolean getPos(int i, int j) {
		int pos = (int) (i * this.n + j - (Math.pow(i, 2) + 3 * i + 2) / 2);
		return this.vector[pos];
	}
	public void setPos(int i, int j) {
		int pos = (int)(i * this.n + j - (Math.pow(i, 2) + 3 * i + 2) / 2);
		this.vector[pos] = true;
	}
	

}
