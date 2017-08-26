package geometria;

public class Punto {
	private double x;
	private double y;
	
	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double distanciaHasta(Punto p2)
	{
		return(Math.sqrt(
				Math.pow(this.x - p2.x, 2)+
				Math.pow(this.y - p2.y, 2)
						)
				);			
				
	}
	

}
