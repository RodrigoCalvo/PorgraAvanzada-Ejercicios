package pequeño;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio 
{

	public static void main(String[] args) throws IOException 
	{
		
		Scanner sc = new Scanner(new File("entrada.in"));
		sc.useLocale(Locale.ENGLISH);
		int CantNumeros = sc.nextInt();
		int K = sc.nextInt();
		
		ArrayList<Integer> Kpequenios = new ArrayList<Integer>();		
		
		for (int i = 0; i < CantNumeros; i++) 
		{
			int num = sc.nextInt(); 			

			if (!Kpequenios.contains(num)) 
				Kpequenios.add(num);
		}
		sc.close();
		
		Integer[] arr = Kpequenios.toArray(new Integer[Kpequenios.size()]);
		
		if (arr.length < K)
			K = arr.length;
		
		int aux;
		int indice = 0, q = 0;
		
		while (q < K)
		{
			int min = arr[q];
			for (int i = q; i < arr.length; i++)
			{
				if (arr[i] < min) 
				{
					min = arr[i];
					indice = i;
				}			
			}		
			
			aux = arr[q];
			arr[indice] = aux;
			arr[q] = min;
			
			q++;
		}
		PrintWriter salida = new PrintWriter(new FileWriter("salida.out"));
		salida.println(K);	   	
		for (int i = 0; i < K; i++) 
		{
			salida.println(arr[i]);
		}
		salida.close();
				
	}
}


