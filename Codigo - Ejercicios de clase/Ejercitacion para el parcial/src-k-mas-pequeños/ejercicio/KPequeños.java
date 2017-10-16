package ejercicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

import algoritmos.*;
import comparadores.IntegerComparador;

public class KPequeños {
	private ArrayList<Integer> numeros;
	private String workFolder;
	private int CantNumeros, K;
	private LinkedList<Integer> Kpequenios;
	
	public KPequeños(String folder, String file) {
		this.workFolder = folder;
		
		try {		
			Scanner sc = new Scanner(new File(workFolder + "entrada.in"));
			sc.useLocale(Locale.ENGLISH);
			
			CantNumeros = sc.nextInt();
			K = sc.nextInt();
			
			//Cargo el array a partir del archivo
			numeros = new ArrayList<Integer>(CantNumeros);		
			for (int i = 0; i < CantNumeros; i++) {
				numeros.add(sc.nextInt()); 
			}
			
			sc.close();
		} catch (IOException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public void preparar() {
		IntegerComparador comparador = new IntegerComparador();
		
		numeros = new QuickSort<Integer>(this.numeros, comparador).ordenar();
		
		Kpequenios = new LinkedList<Integer>();	
		Kpequenios.add(numeros.get(0));
		
		int j = 0;
		for(int i = 1; i < CantNumeros && j < K; i++) {
			if (comparador.compare(numeros.get(i), numeros.get(i-1)) != 0) {
				Kpequenios.add(numeros.get(i));
				j++;
			}
		}
	}
	
	public void GuardarResultado() {
		try {		
			PrintWriter salida = new PrintWriter(new FileWriter(this.workFolder + "salida.out"));
			salida.println(K);	 
			
			for (int i = 0; i < K && i< Kpequenios.size(); i++) 
				salida.println(Kpequenios.get(i));
			
			salida.close();
		} catch (IOException ex) {
			System.out.println(ex.toString());
		}
	}
}
