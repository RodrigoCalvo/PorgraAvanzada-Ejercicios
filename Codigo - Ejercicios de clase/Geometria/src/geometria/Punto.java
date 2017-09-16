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
	
	public double distanciaHastaEnX(Punto p2){
		return Math.abs(p2.getX() - this.x);
	}
	
	public double distanciaHastaEnY(Punto p2){
		return Math.abs(p2.getY() - this.y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	

}
