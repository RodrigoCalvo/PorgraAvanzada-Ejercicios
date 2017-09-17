package trabajoPractico;

public class Polinomio {
	private int grado ;
	private double [] coeficientes;
	//La posicion 0 del arreglo de coeficients con tiene el coeficiente de grado n y la
	//posicion n contiene al termino independiente.
	
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
		for(int i = 0; i<grado ; i++)
			resultado += this.coeficientes[i] * potencia(x, this.grado-i); 	
		return resultado;
	}
	
	
	
	public double evaluarRecursivaPar (double x ) { 
		double resultado = this.coeficientes[this.grado];
		for(int i = 0; i<grado ; i++)
			resultado += this.coeficientes[i] * potenciaConsiderandoExponente(x, this.grado-i); 	
		return resultado;
	}
	
	double evaluarProgDinamica (double x ) { 
		return 0;
	}
	double evaluarMejorada (double x ) { 
		return 0; 
	}
	public double evaluarPow (double x ) 
	{ 
		double resultado  = this.coeficientes[this.grado];
		for(int i = 0; i< this.grado; i++)
			resultado += this.coeficientes[this.grado-i-1 ] * Math.pow(x, i+1);
		return resultado;
	}
	// y a sugerencia de Lucas P
	double evaluarHorner ( double x ) { 
		return 0;
	}
	
	public double potencia(double x, int n){
		if(n == 0)
			return 1;
		else
			return x*=potencia(x, n-1);
	}
	
	public double potenciaConsiderandoExponente(double x, int n) {
		if(n == 0)
			return 1;
		else if(n%2 == 1) 
			return x*= potenciaConsiderandoExponente(x, n-1);
		else
			return x =potenciaConsiderandoExponente(x*x, n/2);
	}
}