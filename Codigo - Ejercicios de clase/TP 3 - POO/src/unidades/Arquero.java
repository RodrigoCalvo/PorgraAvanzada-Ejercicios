package unidades;

import mapa.Ubicacion;

public class Arquero implements Unidad {	
	private final static int RANGO_MINIMO = 2;
	private final static int RANGO_MAXIMO = 5;
	private int cant_flechas;
	private double defensa;
	private double salud;
	private double da�o;
	private Ubicacion ubicacion;
	
	public Arquero(Ubicacion u) {
		cant_flechas = 20;
		salud = 50;
		da�o = 5;
		ubicacion = u;	
	}

	/**
	 * Muestra la cantidad de flechas de la unidad.
	 * @return devuelve la cantidad de flechas de la unidad.
	 */
	@Override
	public int getCant_flechas() {
		return this.cant_flechas;
	}
	/**
	 * Muestra el da�o de la unidad
	 * @return devuelve el da�o de la unidad
	 */
	@Override
	public double getDa�o() {
		return this.da�o;
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
	 * La unidad recarga flechas.
	 */
	@Override
	public void recarga() {
		this.cant_flechas += 6;		
	}
	/**
	 * La unidad calcula las consecuencias de haber atacado
	 */
	@Override
	public void efectuarAtaque(double gasto) {
		this.cant_flechas -= 1; 
	}	
	/**
	 * Toca la salud del personaje en base al da�o que me hacen.
	 * @param da�o recibido
	 */
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
		if(this.cant_flechas < 1)
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "Arquero [cant_flechas=" + cant_flechas + ", defensa=" + defensa + ", salud=" + salud + ", da�o=" + da�o
				+ ", ubicacion=" + ubicacion + "]";
	}
}
