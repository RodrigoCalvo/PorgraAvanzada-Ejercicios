package grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import algoritmos.Prim;

public class Laberinto {
	private int cant_descansos;
	
	public Laberinto(String filePath) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(filePath));
		sc.useLocale(Locale.ENGLISH);

		this.cant_descansos = sc.nextInt();
		MatrizSimetrica lamatriz = new MatrizSimetrica(this.cant_descansos);

		for(int i=0; i<this.cant_descansos; i++)
		{
			for(int k = 0; k<=i; k++)
				sc.nextInt();
			for(int j = i+1; j<this.cant_descansos; j++)
			{					
				lamatriz.setPos(i, j, sc.nextInt());;
			}
		}

		System.out.println(lamatriz.toString());
		Prim prim = new Prim(lamatriz);
		prim.doPrim();
		System.out.println(lamatriz.toString());
		
	}

}
