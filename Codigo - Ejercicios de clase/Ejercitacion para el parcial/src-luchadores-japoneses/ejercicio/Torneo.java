package ejercicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Torneo {
	private String workFolder;
	
	public Torneo(String folder, String fileInput) {
		try {
			this.workFolder = folder;
			Scanner sc = new Scanner(new File(this.workFolder + fileInput));
			sc.useLocale(Locale.ENGLISH);
	
			int cant = sc.nextInt(); 
			Luchadores = new Luchador[cant];
			
			for (int i = 0; i < cant; i++) {	
				this.Luchadores[i] = new Luchador();
				this.Luchadores[i].setPeso(sc.nextInt());
				this.Luchadores[i].setAltura(sc.nextInt());
				this.Luchadores[i].setSupera(0);
				//System.out.println(this.Luchadores[i].toString());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void Preparar() {
		if(Luchadores != null && Luchadores.length > 0) {
			for (int i = 0; i < Luchadores.length; i++) {	
				for (int j = 0; j < Luchadores.length; j++) {				
					if (j != i) {
						if (Luchadores[i].compareTo(Luchadores[j]) == 1)
							Luchadores[i].setSupera((Luchadores[i].getSupera()) + 1);
					}
				}
			}
		}
	}
	
	public void GuardarResultado() {
		if(Luchadores != null && Luchadores.length > 0) {
			try {
				PrintWriter salida = new PrintWriter(new FileWriter(this.workFolder + "salida.out"));
			   	
				for (int i = 0; i < Luchadores.length; i++) {
					//System.out.println(Luchadores[i].getSupera());
					salida.println(Luchadores[i].getSupera());
				}
				
			    salida.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	private Luchador[] Luchadores;
}
