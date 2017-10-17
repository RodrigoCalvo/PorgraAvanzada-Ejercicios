package ejercicio;


public class Complejo  implements Comparable<Complejo> {
	private double real;
	private double im;	
	
	public Complejo(){	
		this(0, 0);
	}
	
	public Complejo(double real, double im){
		this.real = real;
		this.im = im;
	}
	
	public Complejo Suma(Complejo C1){
		Complejo ret = new Complejo();

		ret.real = C1.real + this.real;
		ret.im = C1.im + this.im;
		
		return ret;
	}
	public static Complejo Suma(Complejo C1, Complejo C2){
		Complejo ret = new Complejo();
		
		ret.real = C1.real + C2.real;
		ret.im = C1.im + C2.im;
		
		return ret;
	}
	public Complejo Resta(Complejo C1){
		Complejo ret = new Complejo();
		
		ret.real = this.real - C1.real;
		ret.im = this.im - C1.im;
		
		return ret;
	}
	public static Complejo Resta(Complejo C1, Complejo C2){
		Complejo ret = new Complejo();
		
		ret.real = C1.real - C2.real;
		ret.im = C1.im - C2.im;
		
		return ret;
	}
	
	public Complejo Clone(){
		return new Complejo(this.real, this.im);
	}
	
	public double Modulo(){
		double res = 0;
		res = Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.im, 2));
		
		return res;
	}
	
	//overriding the toString() method
	@Override
	public String toString(){ 
		return this.real + " + " + this.im + "i";
	} 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(im);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(real);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complejo other = (Complejo) obj;
		if (Double.doubleToLongBits(im) != Double.doubleToLongBits(other.im))
			return false;
		if (Double.doubleToLongBits(real) != Double.doubleToLongBits(other.real))
			return false;
		return true;
	}

	@Override
	public int compareTo(Complejo c) {
		/*
		-1 this < c
		0  this = c
		1  this > 0
		*/
		if (this.Modulo() > c.Modulo())
			return 1;
		if (this.Modulo() < c.Modulo())
			return -1;
				
		return 0;
	}

}
