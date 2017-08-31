package descubriendoNombresRepetidos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;


public class Campamento {
	private int CantExploradores;
	private int CantFrecuentes;
	private ArrayList<Explorador> Exploradores;

	public Campamento(String filePath) throws FileNotFoundException
	{
			Scanner sc = new Scanner(new File(filePath));
			sc.useLocale(Locale.ENGLISH);
			
			CantExploradores = sc.nextInt();
			CantFrecuentes = sc.nextInt();
			
			this.Exploradores = new ArrayList<Explorador>();
			for (int i = 0; i < CantExploradores; i++)
			{
				Explorador exp = new Explorador();
				exp.setNombre(sc.next());

				if (Exploradores.contains(exp)) 
				{
					int index = Exploradores.indexOf(exp);
					exp = Exploradores.get(index);
					exp.setRepeticiones(exp.getRepeticiones() + 1);
					Exploradores.set(index, exp);

				}
				else
					Exploradores.add(exp);
	
			}

			sc.close();

		
	}
	
	public void Ordenar()
	{
		Collections.sort(Exploradores);		
	}

	
	public void Salida() throws IOException
	{
		PrintWriter salida = new PrintWriter(new FileWriter("salida.out"));
		java.util.Iterator<Explorador> it = Exploradores.iterator();

			
			for (int i = 0; i < CantFrecuentes; i++) {
				Explorador aux = it.next();
				salida.println(aux.getNombre() + " " + aux.getRepeticiones());
			}

			salida.close();
	}
}
