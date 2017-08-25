import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ordenados {

	public static void main(String[] args) throws IOException {
		String miPath = "";
		Scanner sc = new Scanner(new File(miPath + "enteros.in"));
		sc.useLocale(Locale.ENGLISH);

		int[] vec = new int[sc.nextInt()]; // vector para almacenar la lectura

		for (int i = 0; i < vec.length; i++) {
			vec[i] = sc.nextInt();
			System.out.println(vec[i]);
		}

		sc.close();

		
		Arrays.sort(vec);		
		
		PrintWriter salida = new PrintWriter(new FileWriter(miPath+"salida.out"));  //  preparo el arch de salida
		
		for (int i = 0; i < vec.length; i++) {
			 salida.println(vec[i]);	
		}
	   	
	    salida.close();
	}

}


