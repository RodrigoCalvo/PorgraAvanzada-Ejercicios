package ejercicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Carrera {
	private Participante[] participantes;
	private Participante[] ganadores;
	private Categoria[] F_categorias;
	private Categoria[] M_categorias;
	String workFolder;
	public Carrera(String folder, String inputFile) {
		try {
			workFolder = folder;
			Scanner sc = new Scanner(new File(workFolder + inputFile));
			sc.useLocale(Locale.ENGLISH);
	
			participantes = new Participante[sc.nextInt()]; 
			F_categorias = new Categoria[sc.nextInt()]; 
			M_categorias = new Categoria[sc.nextInt()];
			ganadores = new Participante[sc.nextInt()];
			
			//Categorias de mujeres
			for (int i = 0; i < F_categorias.length; i++) {
				int min_edad = sc.nextInt();
				int max_edad = sc.nextInt();
				Categoria categoria = new Categoria(min_edad, max_edad, i +1);
				
				F_categorias[i] = categoria;
			}

			//Categorias de hombres
			for (int i = 0; i < M_categorias.length; i++) {
				int min_edad = sc.nextInt();
				int max_edad = sc.nextInt();
				Categoria categoria = new Categoria(min_edad, max_edad, i +1);
				
				M_categorias[i] = categoria;
			}

			//Participantes
			for (int i = 0; i < participantes.length; i++) {
				int numero = i + 1;
				int edad =  sc.nextInt();
				
				String s_sexo = sc.next().trim().toLowerCase().toString();				
				Sexo sexo;				
				if(s_sexo.equals("f"))
					sexo = Sexo.F;
				else
					sexo = Sexo.M;
				
				Categoria categoria = getCategoriaPorEdad(edad, sexo);				
				Participante participante = new Participante(numero, categoria, sexo);				
				participantes[i] = participante;
			}

			//Ganadores
			for (int i = 0; i < ganadores.length; i++) {
				int numero = sc.nextInt();
				Participante ganador = getParticipantePorNumero(numero);				
				ganadores[i] = ganador;
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Categoria getCategoriaPorEdad(int edad, Sexo sexo) {
		Categoria categoria = null;
		
		for(Categoria aux : sexo == Sexo.F ? F_categorias : M_categorias) {
			if (aux.aplicaAEdad(edad)) {
				categoria = aux;
				break;
			}
		}
		
		return categoria;
	}
	
	private Participante getParticipantePorNumero(int numero) {
		Participante participante = null;
		
		for(Participante aux : participantes) {
			if (aux.getNumero() == numero) {
				participante = aux;
				break;
			}
		}
		
		return participante;
	}	
	
	public void guardarResultado(){
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(workFolder + "salida.out"));
		   	
			int ganadoresCount = 0;
			for (int i = 0; i < F_categorias.length; i++) {
				Categoria categoria = F_categorias[i];
				
				String s = "";
				ganadoresCount = 0;
				for (int j = 0; j < ganadores.length && ganadoresCount < 3; j++) {
					Participante participante = ganadores[j];
					
					if(participante.getSexo() == Sexo.F && participante.getCategoria().getId() == categoria.getId()) {
						s = s + " " + participante.getNumero();
						ganadoresCount++;
					}
				}
				
				for(;ganadoresCount < 3; ganadoresCount ++)
					s = s + " 0";
				
				salida.println((i+1) + s);
			}

			for (int i = 0; i < M_categorias.length; i++) {
				Categoria categoria = M_categorias[i];
				
				String s = "";
				ganadoresCount = 0;
				for (int j = 0; j < ganadores.length && ganadoresCount < 3; j++) {
					Participante participante = ganadores[j];
					
					if(participante.getSexo() == Sexo.M && participante.getCategoria().getId() == categoria.getId()){
						s = s + " " + participante.getNumero();
						ganadoresCount++;
					}
				}
				
				for(;ganadoresCount < 3; ganadoresCount ++)
					s = s + " 0";
				
				salida.println((i+1) + s);
			}
			
		    salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
