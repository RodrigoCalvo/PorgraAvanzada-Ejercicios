package items;

import mapa.Ubicacion;
import unidades.Unidad;

public abstract class UnidadDecorator implements Unidad {		
	protected Unidad unidad;
	
	public UnidadDecorator(Unidad unidad) {
		setUnidad(unidad);
	}

	/**
	 * Devuelve la unidad guardada en el objeto unidad de la clase
	 * @return la unidad.
	 */	
	public Unidad getUnidad() {
		return this.unidad;
	}
	/**
	 * Guarda la unidad en el objeto unidad de la clase
	 * @param la unidad a guardar
	 */	
	public void setUnidad(Unidad unidad) {
			this.unidad = unidad;
	}	
	/**
	 * Muestra el daño de la unidad
	 * @return devuelve el daño de la unidad
	 */	
	@Override
	public double getDaño() {
		return this.unidad.getDaño();
	}
	/**
	 * Muestra la energía de la unidad
	 * @return devuelve la energía de la unidad
	 */
	@Override
	public double getEnergia() {
		return this.unidad.getEnergia();
	}	
	/**
	 * Muestra la energía que gastará la unidad para atacar.
	 * @return devuelve la energía que gastará la unidad para atacar.
	 */
	@Override
	public double getGasto() {
		return this.unidad.getGasto();
	}
	/**
	 * Muestra la defensa de la unidad.
	 * @return devuelve la defensa de la unidad.
	 */
	@Override
	public double getDefensa() {
		return this.unidad.getDefensa();
	}
	/**
	 * Muestra la salud de la unidad.
	 * @return devuelve la salud de la unidad.
	 */
	@Override
	public double getSalud() {
		return this.unidad.getSalud();
	}	
	/**
	 * Muestra la cantidad de ataques que hizo el caballo de la unidad.
	 * @return devuelve la cantidad de ataques que hizo el caballo de la unidad.
	 */
	@Override
	public int getCaballoRebelde() {
		return this.unidad.getCaballoRebelde();
	}
	/**
	 * Muestra la cantidad de flechas de la unidad.
	 * @return devuelve la cantidad de flechas de la unidad.
	 */
	@Override
	public int getCant_flechas() {
		return this.unidad.getCant_flechas();
	}
	/**
	 * Muestra la Ubicacion de la unidad.
	 * @return devuelve la Ubicacion de la unidad.
	 */
	@Override
	public Ubicacion getUbicacion() {
		return this.unidad.getUbicacion();
	}
	/**
	 * Le da una pocion a la unidad.
	 */
	@Override
	public void tomaPocion() {
		this.unidad.tomaPocion();
	}
	/**
	 * La unidad recarga flechas.
	 */
	@Override
	public void recarga() {
		this.unidad.recarga();
	}
	/**
	 * La unidad calcula las consecuencias de haber atacado
	 */
	@Override
	public void efectuarAtaque(double energia) {
		this.unidad.efectuarAtaque(energia);
	}	
	/**
	 * Toca la salud del personaje en base al daño que me hacen.
	 * @param daño recibido
	 */
	@Override
	public void meAtacanCon(double daño) {
		this.unidad.meAtacanCon(daño);
	}

	/**
	 * La unidad calcula si puede o no atacar a otra.
	 * @param unidad a la que vamos a atacar
	 * @return devuelve si se puede atacar o no.
	 */
	@Override
	public boolean puedoAtacar(Unidad unidad) {
		return this.unidad.puedoAtacar(unidad);
	}
	/**
	 * Cancula en base al daño base que me quieren inflingir cuanto de ese daño llegará a mis puntos de salud. Tiene en cuenta la defensa de la unidad
	 * @param daño que me quieren hacer
	 * @return daño real que me van a hacer
	 */
	@Override
	public double calcularDañoQueMeInfligen(double daño) {
		return this.unidad.calcularDañoQueMeInfligen(daño);
	}
	@Override
	public String toString() {
		return unidad.toString();
	}	
}
