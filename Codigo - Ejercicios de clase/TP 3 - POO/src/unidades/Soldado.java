package unidades;

import mapa.Ubicacion;

public class Soldado implements Unidad {
	private final static int RANGO_MINIMO = 1;
	private final static int RANGO_MAXIMO = 1;
	private int energia;
	private double defensa;
	private double salud;
	private double da�o;
	private Ubicacion ubicacion;
	
	public Soldado(Ubicacion u) {
		energia = 100;
		salud = 200;
		da�o = 10;
		ubicacion = u;
	}

	@Override
	public double getDa�o() {
		return this.da�o;
	}

	@Override
	public double getEnergia() {
		return this.energia;
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
		this.energia = 100;		
	}
	@Override
	public void recarga() {	
	}

	@Override
	public void ataca(Unidad unidad) {
		this.energia-=10; 
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
		if(this.energia < 10)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Soldado [energia=" + energia + ", defensa=" + defensa + ", salud=" + salud + ", da�o=" + da�o
				+ ", ubicacion=" + ubicacion + "]";
	}

	
}
