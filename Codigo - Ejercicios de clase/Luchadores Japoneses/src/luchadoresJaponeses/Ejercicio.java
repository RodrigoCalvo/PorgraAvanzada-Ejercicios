package luchadoresJaponeses;

public class Ejercicio {
	public static void main(String[] args) {
		String miPath = "";
		Torneo torneo = new Torneo(miPath + "entrada.in");
		
		torneo.Preparar();
		torneo.GuardarResultado();
	}
}
