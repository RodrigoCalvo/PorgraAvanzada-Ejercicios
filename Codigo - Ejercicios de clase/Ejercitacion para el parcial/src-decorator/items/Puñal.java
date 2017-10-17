package items;

import unidades.*;

public class Pu�al extends UnidadDecorator{
	public Pu�al(Unidad unidad) {
		super(unidad);
	}

	/**
	 * Muestra el da�o de la unidad
	 * @return devuelve el da�o de la unidad
	 */
	@Override
	public double getDa�o() {
		return this.unidad.getDa�o() + 3;
	}
	/**
	 * Muestra la defensa de la unidad.
	 * @return devuelve la defensa de la unidad.
	 */
	@Override
	public double getDefensa() {
		return this.unidad.getDefensa() - 3;
	}	
}
