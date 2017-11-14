package unidades;

import mapa.Ubicacion;

public class Soldado implements Unidad {
	private final static int RANGO_MAXIMO = 0;
	private double energia;
	private double defensa;
	private double salud;
	private double daño;
	private Ubicacion ubicacion;
	
	public Soldado(Ubicacion u) {
		energia = 100;
		salud = 200;
		daño = 10;
		ubicacion = u;	
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
	 * Muestra la energía de la unidad
	 * @return devuelve la energía de la unidad
	 */
	@Override
	public double getEnergia() {
		return this.energia;
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
		this.energia = 100;		
	}
	/**
	 * Muestra la energía que gastará la unidad para atacar.
	 * @return devuelve la energía que gastará la unidad para atacar.
	 */
	@Override
	public double getGasto() {		
		return 10;
	}	
	/**
	 * La unidad calcula las consecuencias de haber atacado
	 */
	@Override
	public void efectuarAtaque(double energia) {		
		this.energia -= energia; 
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
		
		if(this.ubicacion.distanciaHasta(unidad.getUbicacion()) > RANGO_MAXIMO)
			return false;
		if(this.energia < 10)
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "Soldado [energia=" + energia + ", defensa=" + defensa + ", salud=" + salud + ", daño=" + daño
				+ ", ubicacion=" + ubicacion + "]";
	}
}
