package items;

import unidades.Unidad;

public class Capa extends UnidadDecorator  {
	public Capa(Unidad unidad) {
		super(unidad);
	}	

	/**
	 * Muestra el da�o de la unidad
	 * @return devuelve el da�o de la unidad
	 */
	@Override
	public double getDa�o() {
		return this.unidad.getDa�o() * 0.9;
	}
	/**
	 * Muestra la energ�a de la unidad
	 * @return devuelve la energ�a de la unidad
	 */
	@Override
	public double getEnergia() {
		return this.unidad.getEnergia() * 2; 
	}	
	/**
	 * Muestra la energ�a que gastar� la unidad para atacar.
	 * @return devuelve la energ�a que gastar� la unidad para atacar.
	 */	
	@Override
	public double getGasto() {
		return this.unidad.getGasto() / 2;
	}	
}
