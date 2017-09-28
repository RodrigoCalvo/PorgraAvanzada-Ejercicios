package unidades;



public abstract class Unidad {
	
	public final Boolean atacar()
	{
		if(puedoAtacar()) {
			ataco();
			return true;
		}
		return false;
	}
	
	protected abstract boolean puedoAtacar();	
	protected abstract void ataco();

}
