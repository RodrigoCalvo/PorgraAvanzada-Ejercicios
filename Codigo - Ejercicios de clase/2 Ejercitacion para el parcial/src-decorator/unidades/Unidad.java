package unidades;

import mapa.Ubicacion;

public interface Unidad {
	/**
	 * Muestra el da�o de la unidad
	 * @return devuelve el da�o de la unidad
	 */
	public double getDa�o();
	
	/**
	 * Muestra la energ�a de la unidad
	 * @return devuelve la energ�a de la unidad
	 */
	public default double getEnergia() { 
		return 0;
	}

	/**
	 * Muestra la energ�a que gastar� la unidad para atacar.
	 * @return devuelve la energ�a que gastar� la unidad para atacar.
	 */
	public default double getGasto() { 
		return 0;
	}

	/**
	 * Muestra la defensa de la unidad.
	 * @return devuelve la defensa de la unidad.
	 */
	public double getDefensa();

	/**
	 * Muestra la salud de la unidad.
	 * @return devuelve la salud de la unidad.
	 */
	public double getSalud();

	/**
	 * Muestra la cantidad de flechas de la unidad.
	 * @return devuelve la cantidad de flechas de la unidad.
	 */
	public default int getCant_flechas() { 
		return 0;
	}

	/**
	 * Muestra la cantidad de ataques que hizo el caballo de la unidad.
	 * @return devuelve la cantidad de ataques que hizo el caballo de la unidad.
	 */
	public default int getCaballoRebelde() { 
		return 0;
	};	


	/**
	 * Muestra la Ubicacion de la unidad.
	 * @return devuelve la Ubicacion de la unidad.
	 */
	public Ubicacion getUbicacion();

	/**
	 * Le da una pocion a la unidad.
	 */
	public default void tomaPocion(){		
	};	

	/**
	 * La unidad recarga flechas.
	 */
	public default void recarga() {		
	};	
	
	/**
	 * Metodo predilecto para atacar unidades. Usar este ya que indica como deben hacerse las cosas.
	 * @param unidad a la que vamos a atacar
	 * @return devuelve si se pudo atacar o no.
	 */
	public default Boolean atacar(Unidad unidad) {		
		if(this.puedoAtacar(unidad)) {			
			this.efectuarAtaque(this.getGasto());
			unidad.meAtacanCon(unidad.calcularDa�oQueMeInfligen(this.getDa�o()));			
			return true;			
		}
		return false;
	}

	/**
	 * Cancula en base al da�o base que me quieren inflingir cuanto de ese da�o llegar� a mis puntos de salud. Tiene en cuenta la defensa de la unidad
	 * @param da�o que me quieren hacer
	 * @return da�o real que me van a hacer
	 */
	public default double calcularDa�oQueMeInfligen(double da�o) {
		da�o = da�o - getDefensa();
		if(da�o < 0)
			return 0;		
		return da�o;
	}

	/**
	 * La unidad calcula si puede o no atacar a otra.
	 * @param unidad a la que vamos a atacar
	 * @return devuelve si se puede atacar o no.
	 */
	public boolean puedoAtacar(Unidad unidad);


	/**
	 * La unidad calcula las consecuencias de haber atacado
	 */
	public default void efectuarAtaque(double d) {		
	}

	/**
	 * Toca la salud del personaje en base al da�o que me hacen.
	 * @param da�o recibido
	 */
	public void meAtacanCon(double da�o);
}
