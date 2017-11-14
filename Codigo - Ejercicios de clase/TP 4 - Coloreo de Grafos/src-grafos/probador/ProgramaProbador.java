package probador;

import grafo.*;

public class ProgramaProbador {
	/*
	private static final String CARPETA_PROGRAMA_PROBADOR = "ProgramaProbador/";
	private static final String ARCHIVO_GRAFO = "grafo_programa_probador_correcto.in";
	private static final String ARCHIVO_COLOREADO_MATULA = "grafo_coloreado_matula_programa_probador_correcto.out";
	private static final String ARCHIVO_COLOREADO_POWELL = "grafo_coloreado_powell_programa_probador_correcto.out";
	private static final String ARCHIVO_COLOREADO_ALEATORIO = "grafo_aleatorio_matula_programa_probador_correcto.out";
	*/
	GrafoNDNP grafo;
	
	public ProgramaProbador(String file_grafo, String file_grafo_coloreado) {
		this.grafo = new GrafoNDNP(file_grafo);
		grafo.cargarColoreo(file_grafo_coloreado);
	}
	
	public boolean probar() {
		for(Nodo nodo : this.grafo.getNodos())
			if(!sePuedeColorear(nodo.getNumero(), nodo.getColor())) {
				return false;
			}
		
		return true;
	}

	private boolean sePuedeColorear(int pos, int color) {
		int i = 0;

		//no puedo colorear
		while (i < this.grafo.getNodos().size()) {
			if (i != pos && this.grafo.getNodos().get(i).getColor() == color) { 
				if (esAdyacente(this.grafo.getNodos().get(i), this.grafo.getNodos().get(pos))) {
					System.out.println("Está mal coloreado ya que el nodo " + pos + " color " + color + " es adyacente al nodo " + i + " color " + this.grafo.getNodos().get(i).getColor());
					return false;
				}
			}
			i++;
		}
		return true;
	}

	private boolean esAdyacente(Nodo nodoUno, Nodo nodoDos) {
		return this.grafo.getMatrizSimetrica().getPos(nodoUno.getNumero(), nodoDos.getNumero());
	}
}
