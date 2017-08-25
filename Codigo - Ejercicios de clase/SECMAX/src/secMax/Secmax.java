package secMax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Secmax {

	public static void main(String[] args) throws IOException {
		String miPath = "";
		Scanner sc = new Scanner(new File(miPath + "entrada.in"));
		sc.useLocale(Locale.ENGLISH);

		int cant = sc.nextInt(); // vector para almacenar la lectura
		
		int secMax = 0;
		int sec_aux = 0;
		int valid = 0;
		int num = 0;
		
		for (int i = 0; i < cant; i++) {
			
			num = sc.nextInt();
			if (num%2 == 0 || num%3 == 0 || num%5 ==0)
			{

				sec_aux = 0;
			}
			else
			{
				valid++;
				sec_aux++;
				if (sec_aux > secMax)
					secMax = sec_aux; 
			}
		
		}

		sc.close();

		
		PrintWriter salida = new PrintWriter(new FileWriter(miPath+"salida.out"));  //  preparo el arch de salida
		
		salida.println(valid);
		salida.println(secMax);
	   	
	    salida.close();
	}

}


