package ejercito;

public abstract class Unidad {
	public final Boolean equipar(Armamento armamento)
	{
		if(puedoCargar(armamento)) {
			cargo(armamento);
			return true;
		}
		return false;
	}

	protected abstract boolean puedoCargar(Armamento armamento);	
	protected abstract void cargo(Armamento armamento);
}
