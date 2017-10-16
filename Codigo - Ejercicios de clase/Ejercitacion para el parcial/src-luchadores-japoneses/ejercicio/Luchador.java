package ejercicio;

public class Luchador implements Comparable<Luchador> {		
	public int getPeso() {
		return Peso;
	}

	public void setPeso(int peso) {
		Peso = peso;
	}

	public int getAltura() {
		return Altura;
	}

	public void setAltura(int altura) {
		Altura = altura;
	}

	public int getSupera() {
		return Supera;
	}

	public void setSupera(int supera) {
		Supera = supera;
	}

	@Override
	public String toString() {
		return "Luchador [Peso=" + Peso + ", Altura=" + Altura + "]";
	}
	
	@Override
	public int compareTo(Luchador o) {
		if (this.Peso >= o.Peso && this.Altura > o.Altura) 
			return 1;
		
		if (this.Peso > o.Peso && this.Altura >= o.Altura) 
			return 1;
				
		return 0;
	}

	private int Peso;
	private int Altura;
	private int Supera;
}
