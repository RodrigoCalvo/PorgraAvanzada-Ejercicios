package trabajoPractico;

import java.util.Arrays;

public class Polinomio {
	private int grado ;
	private double [] coeficientes;

	//La posicion 0 del arreglo de coeficientes contiene el coeficiente de grado n 
	//y la posicion n contiene al termino independiente .
	
	public Polinomio (double[] coeficientes) throws Exception{
		if(coeficientes.length <= 0)
			throw new Exception("Especifique al menos un coeficiente");
					
		this.coeficientes = coeficientes;
		this.grado = coeficientes.length -1;
		
	}
	public double evaluarMSucesivas (double x) { 
		//Arranco con el termino indepentiende.
		double resultado = this.coeficientes[this.grado];			
		
		for(int i = 0; i < this.grado; i++) {
			double aux = x;
			for(int j = 1; j < this.grado - i; j++) {
				aux*=x;
			}
			resultado += aux * this.coeficientes[i];
		}	
		
		return resultado;
	}
	
	public double evaluarRecursiva (double x) {		
		double resultado = this.coeficientes[this.grado];
		
		for(int i = 0; i < this.grado; i++)
			resultado += this.coeficientes[i] * potencia(x, this.grado-i);
		
		return resultado;
	}
	
	private double potencia(double x, int n){
		if(n == 0)
			return 1;
		else
			return x*=potencia(x, n-1);
	}	
	
	public double evaluarRecursivaPar (double x ) { 
		double resultado = this.coeficientes[this.grado];
		
		for(int i = 0; i < this.grado; i++)
			resultado += this.coeficientes[i] * potenciaConsiderandoExponente(x, this.grado-i); 
		
		return resultado;
	}
	
	private double potenciaConsiderandoExponente(double x, int n) {
		if(n == 0)
			return 1;
		else if(n%2 == 1) 
			return x*= potenciaConsiderandoExponente(x, n-1);
		else
			return x = potenciaConsiderandoExponente(x*x, n/2);
	}
	
	public double evaluarProgDinamica (double x ) { 
		double [] resultados = new double[coeficientes.length];
	
		resultados[grado] = 1;
		
		for (int i = grado - 1; i >= 0; i--) {			
			resultados[i] = x * resultados[i+1];
		}	
		
		double resultado = 0;
		
		for (int j = 0; j <= this.grado; j++) {
			resultado += coeficientes[j] * resultados[j];
		}
		
		return resultado;
	}
	
	public double evaluarMejorada (double x ) { 
		
		double [] resultados = new double[coeficientes.length];
		
		resultados[grado] = 1;
		double resultado = this.coeficientes[this.grado];		
		
		for (int i = grado - 1; i >= 0; i--) {			
			resultados[i] = x * resultados[i+1];
			
			resultado += coeficientes[i] * resultados[i];
		}
		
		return resultado;
	}
	
	public double evaluarPow (double x ) 
	{ 
		double resultado  = this.coeficientes[this.grado];
		for(int i = 0; i< this.grado; i++)
			resultado += this.coeficientes[this.grado-i-1] * Math.pow(x, i+1);
		return resultado;
	}
	
	// y a sugerencia de Lucas P
	public double evaluarHorner ( double x ) { 
		
		double resultado = this.coeficientes[0];
		
        for (int i = 1; i <= this.grado; i++)
        	resultado = this.coeficientes[i] + (x * resultado);
        
        return resultado;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(coeficientes);
		result = prime * result + grado;
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
		Polinomio other = (Polinomio) obj;
		if (!Arrays.equals(coeficientes, other.coeficientes))
			return false;
		if (grado != other.grado)
			return false;
		return true;
	}
	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i <= this.grado; i++) {
			if((this.grado - i) > 0) {
			if(this.coeficientes[i] > 0)
				result += " + " + Math.abs(this.coeficientes[i]) + "x^" + (this.grado - i);
			else if(this.coeficientes[i] < 0)
				result += " - " + Math.abs(this.coeficientes[i]) + "x^" + (this.grado - i);
			} else {
				if(this.coeficientes[i] > 0)
					result += " + " + Math.abs(this.coeficientes[i]);
				else if(this.coeficientes[i] < 0)
					result += " - " + Math.abs(this.coeficientes[i]);				
			}
		}
		return result.substring(3, result.length());
	}
}