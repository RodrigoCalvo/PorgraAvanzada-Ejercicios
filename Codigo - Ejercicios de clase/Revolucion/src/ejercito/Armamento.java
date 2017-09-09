package ejercito;

public class Armamento {
	private double Peso;
	private double Volumen;
	private double Distancia;
	
	public double getDistancia() {
		return Distancia;
	}

	public void setDistancia(double distancia) {
		Distancia = distancia;
	}

	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		Peso = peso;
	}

	public Armamento(double volumen, double distancia) {
		Volumen = volumen;
		Distancia = distancia;
	}
	public Armamento(double volumen, double peso, double distancia) {
		Volumen = volumen;
		Distancia = distancia;
		Peso = peso;
	}
	public Armamento(double peso) {
		Peso = peso;
	}

	public double getVolumen() {
		return Volumen;
	}

	public void setVolumen(double volumen) {
		Volumen = volumen;
	}


}
