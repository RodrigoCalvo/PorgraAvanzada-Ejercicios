package grafo;

public class Nodo {
	@Override
	public String toString() {
		return "Nodo [color=" + color + ", numero=" + numero + ", grado=" + grado + "]";
	}

	private int color;
	private int numero;
	private int grado;

	public Nodo(int numero, int color, int grado) {
		this.numero = numero;
		this.color = color;
		this.grado = grado;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}
}