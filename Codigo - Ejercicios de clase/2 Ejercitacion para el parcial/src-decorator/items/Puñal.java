package items;

import unidades.*;

public class Puñal extends UnidadDecorator{
	public Puñal(Unidad unidad) {
		super(unidad);
	}

	/**
	 * Muestra el daño de la unidad
	 * @return devuelve el daño de la unidad
	 */
	@Override
	public double getDaño() {
		return this.unidad.getDaño() + 3;
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
