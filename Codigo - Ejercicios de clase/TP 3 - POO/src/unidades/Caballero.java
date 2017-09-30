package unidades;

import mapa.Ubicacion;

public class Caballero  implements Unidad {	
	private final static int RANGO_MINIMO = 1;
	private final static int RANGO_MAXIMO = 2;
	private int caballoRebelde;
	private double defensa;
	private double salud;
	private double da�o;
	private Ubicacion ubicacion;
	
	public Caballero(Ubicacion u) {
		salud = 200;
		da�o = 50;
		ubicacion = u;
		caballoRebelde = 0;
	}

	@Override
	public double getDa�o() {
		return this.da�o;
	}

	@Override
	public double getEnergia() {
		return 0;
	}

	@Override
	public double getDefensa() {
		return this.defensa;
	}

	@Override
	public double getSalud() {
		return this.salud;
	}

	@Override
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	@Override
	public void tomaPocion() {
		this.caballoRebelde = 0;		
	}
	@Override
	public void recarga() {	
	}

	@Override
	public void ataca(Unidad unidad) {
		this.caballoRebelde++; 
	}
	
	@Override
	public void meAtacanCon(double da�o) {		
		if(da�o > 0)
		{
			if(this.salud - da�o < 0)
				this.salud = 0;
			else
				this.salud -= da�o;
		}
	}

	@Override
	public boolean puedoAtacar(Unidad unidad) {
		if(this.getSalud() == 0 || unidad.getSalud() == 0)
			return false;
		
		if(this.ubicacion.distanciaHasta(unidad.getUbicacion()) < RANGO_MINIMO || this.ubicacion.distanciaHasta(unidad.getUbicacion()) > RANGO_MAXIMO)
			return false;
		if(this.caballoRebelde >= 3)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Caballero [caballoRebelde=" + caballoRebelde + ", defensa=" + defensa + ", salud=" + salud + ", da�o="
				+ da�o + ", ubicacion=" + ubicacion + "]";
	}
}
	
