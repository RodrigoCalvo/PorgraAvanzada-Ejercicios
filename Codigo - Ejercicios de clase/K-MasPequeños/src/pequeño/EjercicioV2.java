package pequeño;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import com.sun.jmx.snmp.Timestamp;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class EjercicioV2 {

	public static void main(String[] args) throws IOException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("Arranca todo: " + timestamp);
		
		Scanner sc = new Scanner(new File("entrada.in"));
		sc.useLocale(Locale.ENGLISH);
		int CantNumeros = sc.nextInt();
		int K = sc.nextInt();
		
		//Cargo el array a partir del archivo
		Integer[] arr = new Integer[CantNumeros];		
		for (int i = 0; i < CantNumeros; i++) {
			arr[i] = sc.nextInt(); 
		}
		
		sc.close();
		
		timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("Termino de leer archivo: " + timestamp);
		//Cargo el array a partir del archivo
		
		//Ordeno el array.
		Arrays.sort(arr);
		
		timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("Ordeno el array: " + timestamp);
		
		//Saco repetidos
		ArrayList<Integer> Kpequenios = new ArrayList<Integer>();	
		Kpequenios.add(arr[0]);
		
		int j = 0;
		for(int i = 1; i < CantNumeros && j < K; i++) {
			if (arr[i] != arr[i-1]) {
				Kpequenios.add(arr[i]);
				j++;
			}
		}

		timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("saco repetidos: " + timestamp);
		//Saco repetidos
		
		//Imprimo el archivo.		
		PrintWriter salida = new PrintWriter(new FileWriter("salida.out"));
		salida.println(K);	 
		
		for (int i = 0; i < K && i< Kpequenios.size(); i++) 
			salida.println(Kpequenios.get(i));
		
		salida.close();
		timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("Termino de escribir archivo: " + timestamp);

	}

}
