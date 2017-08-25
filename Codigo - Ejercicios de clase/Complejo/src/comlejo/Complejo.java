package comlejo;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import javax.tools.JavaCompiler;

public class Complejo implements Comparable<Complejo> {
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
	
	public static void main(String[] args){
		
/*		Complejo C1 = new Complejo(10.32, 55.68);
		
		System.out.println(C1.Modulo());
		
		Complejo C2 = new Complejo(1, 0.000898);
		
		Complejo C3 = C1.Suma(C2);			
		String c3ToString = C3.toString();
		System.out.println(c3ToString);		
		
		Complejo C4 = Complejo.Suma(C1, C2);		
		System.out.println(C4.toString());	

		if(C3.equals(C4))
			System.out.println("La suma dio bien");
		
		Complejo C5 = C1.Resta(C2);		
		String c5ToString = C5.toString();
		System.out.println(c5ToString);		
		
		Complejo C6 = Complejo.Resta(C1, C2);		
		System.out.println(C6.toString());

		if(C3.equals(C4))
			System.out.println("La resta dio bien");
		
		Complejo C7 = C6.Clone();	
		System.out.println(C7.toString());		*/	

		Complejo[] complejos = new Complejo[3];
		
		complejos[0] = new Complejo(1,1);
		complejos[1] = new Complejo(3,3);
		complejos[2] = new Complejo(2,2);
		
		for (int i = 0;i<complejos.length;i++){
			System.out.println(complejos[i]);
		}
		
		Arrays.sort(complejos);
		
		for (int i = 0;i<complejos.length;i++){
			System.out.println(complejos[i]);
		}
		
		
	}	
}
