package geometria;

public class Circulo {
	private double radio;
	private Punto centro;
	
	public Circulo(double radio, Punto centro) throws Exception
	{
		if(radio <= 0)
		{
			throw new Exception();
		}
		this.radio = radio;
		this.centro = centro;
	}
	
	
	public boolean puntoPertenece(Punto p1)	
	{
		if(centro.distanciaHasta(p1)<= radio)
			return true;
		else
			return false;
	}	

}
