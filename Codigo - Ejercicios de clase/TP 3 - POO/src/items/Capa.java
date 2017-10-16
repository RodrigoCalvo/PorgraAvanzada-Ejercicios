package items;

import unidades.Unidad;

public class Capa extends UnidadDecorator  {
	public Capa(Unidad unidad) {
		super(unidad);
	}	

	/**
	 * Muestra el daño de la unidad
	 * @return devuelve el daño de la unidad
	 */
	@Override
	public double getDaño() {
		return this.unidad.getDaño() * 0.9;
	}
	/**
	 * Muestra la energía de la unidad
	 * @return devuelve la energía de la unidad
	 */
	@Override
	public double getEnergia() {
		return this.unidad.getEnergia() * 2; 
	}	
	/**
	 * Muestra la energía que gastará la unidad para atacar.
	 * @return devuelve la energía que gastará la unidad para atacar.
	 */	
	@Override
	public double getGasto() {
		return this.unidad.getGasto() / 2;
	}	
}
