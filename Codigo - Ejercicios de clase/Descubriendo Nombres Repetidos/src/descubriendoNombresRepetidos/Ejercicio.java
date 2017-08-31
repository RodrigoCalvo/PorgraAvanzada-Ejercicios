package descubriendoNombresRepetidos;

import java.io.IOException;

public class Ejercicio {

	public static void main(String[] args) throws IOException 
	{
		String miPath = "";
		Campamento camp = new Campamento(miPath + "entrada.in");	
		camp.Ordenar();
		camp.Salida();	

	}

}
