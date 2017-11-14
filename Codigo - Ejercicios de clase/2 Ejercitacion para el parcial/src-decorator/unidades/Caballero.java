package unidades;

import mapa.Ubicacion;

public class Caballero  implements Unidad {	
	private final static int RANGO_MINIMO = 1;
	private final static int RANGO_MAXIMO = 2;
	private int caballoRebelde;
	private double defensa;
	private double salud = 200;
	private double daño;
	private Ubicacion ubicacion;
	
	public Caballero(Ubicacion u) {
		salud = 200;
		daño = 50;
		ubicacion = u;
		caballoRebelde = 0;		
	}

	/**
	 * Muestra el daño de la unidad
	 * @return devuelve el daño de la unidad
	 */
	@Override
	public double getDaño() {
		return this.daño;
	}
	/**
	 * Muestra la defensa de la unidad.
	 * @return devuelve la defensa de la unidad.
	 */
	@Override
	public double getDefensa() {
		return this.defensa;
	}
	/**
	 * Muestra la salud de la unidad.
	 * @return devuelve la salud de la unidad.
	 */
	@Override
	public double getSalud() {
		return this.salud;
	}
	/**
	 * Muestra la Ubicacion de la unidad.
	 * @return devuelve la Ubicacion de la unidad.
	 */
	@Override
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	/**
	 * Le da una pocion a la unidad.
	 */
	@Override
	public void tomaPocion() {
		this.caballoRebelde = 0;		
	}
	/**
	 * La unidad calcula las consecuencias de haber atacado
	 */
	@Override
	public void efectuarAtaque(double energia) {
		this.caballoRebelde++; 
	}	
	/**
	 * Muestra la cantidad de ataques que hizo el caballo de la unidad.
	 * @return devuelve la cantidad de ataques que hizo el caballo de la unidad.
	 */
	@Override
	public int getCaballoRebelde() {
		return caballoRebelde;
	}
	/**
	 * Toca la salud del personaje en base al daño que me hacen.
	 * @param daño recibido
	 */
	@Override
	public void meAtacanCon(double daño) {		
		if(daño > 0)
		{
			if(this.salud - daño < 0)
				this.salud = 0;
			else
				this.salud -= daño;
		}
	}
	/**
	 * La unidad calcula si puede o no atacar a otra.
	 * @param unidad a la que vamos a atacar
	 * @return devuelve si se puede atacar o no.
	 */
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
		return "Caballero [caballoRebelde=" + caballoRebelde + ", defensa=" + defensa + ", salud=" + salud + ", daño="
				+ daño + ", ubicacion=" + ubicacion + "]";
	}
}
	
