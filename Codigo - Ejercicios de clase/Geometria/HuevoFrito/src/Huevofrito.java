
public class Huevofrito 
{
	private int valor;
	
	public Huevofrito()
	{
		this.valor = 0;
	}
	
	public void contar()
	{
		valor = valor+1;		
	}
	
	public void reiniciar()
	{
		valor = 0;
	}
	
	public int mostrar()
	{
		return valor;
	}
	
}
