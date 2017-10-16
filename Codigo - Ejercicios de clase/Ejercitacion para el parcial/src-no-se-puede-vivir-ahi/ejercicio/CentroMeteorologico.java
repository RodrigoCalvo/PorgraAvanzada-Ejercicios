package ejercicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CentroMeteorologico {
	private ArrayList<Lugar> lugaresHostiles;
	private ArrayList<Lugar> lugares;
	private String workFolder;
	
	public CentroMeteorologico(String folder, String fileInput) {
		try {
			this.workFolder = folder;
			Scanner sc = new Scanner(new File(this.workFolder + fileInput));
			sc.useLocale(Locale.ENGLISH);

			int cantidad_de_lugares = sc.nextInt();
			lugares = new ArrayList<>(cantidad_de_lugares);
			
			for (int i = 0; i < cantidad_de_lugares; i++) {
				int cantidad_de_mediciones = sc.nextInt();
				Lugar lugar = new Lugar(i + 1);
				
				for(int j = 0; j < cantidad_de_mediciones; j++) {
					Medicion medicion = new Medicion(sc.nextDouble(), sc.nextDouble());
					lugar.agregarMedicion(medicion);
				}
				
				lugares.add(lugar);
			}			
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void prepararReporte() {
		lugaresHostiles = new ArrayList<>(lugares.size());
		
		for(Lugar lugar : lugares) {
			for (Lugar lugarParaComparar : lugares) {
				if (lugar.getLugarId() != lugarParaComparar.getLugarId()) {
					if(lugar.verTemperaturaMasBaja() < lugarParaComparar.verTemperaturaMasBaja() 
						&& lugar.verTemperaturaMasAlta() >= lugarParaComparar.verTemperaturaMasAlta())
						lugar.sumarHostilEnRelacionCon();
					else if (lugar.verTemperaturaMasAlta() > lugarParaComparar.verTemperaturaMasAlta() 
						&& lugar.verTemperaturaMasBaja() <= lugarParaComparar.verTemperaturaMasBaja())
						lugar.sumarHostilEnRelacionCon();
					else if ((lugar.verTemperaturaMasBaja() < lugarParaComparar.verTemperaturaMasBaja() && lugar.verTemperaturaMasAlta() < lugarParaComparar.verTemperaturaMasAlta())
						|| (lugar.verTemperaturaMasAlta() > lugarParaComparar.verTemperaturaMasAlta() && lugar.verTemperaturaMasBaja() > lugarParaComparar.verTemperaturaMasBaja()))
						lugar.sumarIncomparableCon();
				}
			}
		}
		
		int max_hostil = 0;
		
		for (Lugar lugar : lugares) {
			if(max_hostil < lugar.getHostilEnRelacionCon())
				max_hostil = lugar.getHostilEnRelacionCon();
		}
		
		for (Lugar lugar : lugares) {
			if (lugar.getHostilEnRelacionCon() == max_hostil)
				lugaresHostiles.add(lugar);
		}
	}
	
	public void guardarResultado() {

		try {
			PrintWriter salida = new PrintWriter(new FileWriter(this.workFolder + "salida.out"));

			for(Lugar lugar : lugaresHostiles) {
				salida.println(lugar.getLugarId() + " " + lugar.getIncomparableCon());
			}
			
		    salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
