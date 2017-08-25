package luchadoresJaponeses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LuchadoresJaponeses implements Comparable<LuchadoresJaponeses> {
	
	private int Peso;
	private int Altura;
	private int Supera;
		
	@Override
	public String toString() {
		return "LuchadoresJaponeses [Peso=" + Peso + ", Altura=" + Altura + "]";
	}


	public static void main(String[] args) throws IOException  {
		String miPath = "";
		Scanner sc = new Scanner(new File(miPath + "entrada.in"));
		sc.useLocale(Locale.ENGLISH);

		int cant = sc.nextInt(); // vector para almacenar la lectura
		LuchadoresJaponeses[] luchadores = new LuchadoresJaponeses[cant];
		
		for (int i = 0; i < cant; i++) {	
			luchadores[i] = new LuchadoresJaponeses();
			luchadores[i].Peso = sc.nextInt();
			luchadores[i].Altura = sc.nextInt();
			luchadores[i].Supera = 0;
			System.out.println(luchadores[i].toString());
		}

		sc.close();

		for (int i = 0; i < cant; i++) {	
			for (int j = 0; j < cant; j++) {
				
				if (j != i)
				{
					if (luchadores[i].compareTo(luchadores[j]) == 1)
						luchadores[i].Supera++;
				}
			}
		}
		
		PrintWriter salida = new PrintWriter(new FileWriter(miPath+"salida.out"));  //  preparo el arch de salida
			   	
		for (int i = 0; i < cant; i++) {
			System.out.println(luchadores[i].Supera);
			salida.println(luchadores[i].Supera);
		}
		
	    salida.close();

	}


	@Override
	public int compareTo(LuchadoresJaponeses o) {
		if (this.Peso >= o.Peso && this.Altura > o.Altura) 
			return 1;
		
		if (this.Peso > o.Peso && this.Altura >= o.Altura) 
			return 1;
				
		return 0;
	}

}
