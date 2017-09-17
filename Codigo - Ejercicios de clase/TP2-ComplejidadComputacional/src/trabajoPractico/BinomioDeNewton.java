package trabajoPractico;

public class BinomioDeNewton {
	private double a;
	private double b;
	private int n;
	
	public BinomioDeNewton(double a, double b, int n) {
		super();
		this.a = a;
		this.b = b;
		this.n = n;
	}
	
	//############### ITERATIVOS ##############
	public Polinomio obtenerPolinomioIterativo() throws Exception {
		double[] coeficientes = new double[this.n+1];
		
		for(int i = 0; i <= this.n; i++) {
			coeficientes[this.n - i] = terminoQueOcupaElLugarKIterativo(i);
		}
		
		return new Polinomio(coeficientes);
	}
	
	public double terminoQueOcupaElLugarKIterativo(int k) {
		return combinatoriaIterativo(this.n, k) * potenciaIterativa(this.a, k) * potenciaIterativa(this.b, this.n-k);
	}
	
	private double combinatoriaIterativo(int n, int m) {
		return factorialIterativo(n) / (factorialIterativo(m)*factorialIterativo(n-m));
	}

    private int factorialIterativo(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
    
    private double potenciaIterativa(double n, int exponente) {
    	double resultado = 1;
    	
    	for(int i = 0; i < exponente; i++) {
    		resultado *= n;
    	}
    	
    	return resultado;
    }
	//############ FIN - ITERATIVOS ###########

	//############### RECURSIVOS ##############
	public Polinomio obtenerPolinomioRecursivo() throws Exception {
		double[] coeficientes = new double[this.n+1];
		
		for(int i = 0; i <= this.n; i++) {
			coeficientes[this.n - i] = terminoQueOcupaElLugarKRecursivo(i);
		}
		
		return new Polinomio(coeficientes);
	}
	
	public double terminoQueOcupaElLugarKRecursivo(int k) {
		return combinatoriaRecursivo(this.n, k) * potenciaRecursivo(this.a, k) * potenciaRecursivo(this.b, this.n-k);
	}
	
	private double combinatoriaRecursivo(int n, int m) {
		return factorialRecursivo(n) / (factorialRecursivo(m)*factorialRecursivo(n-m));
	}

    private int factorialRecursivo(int n) {
    	if (n == 0) 
    		return 1;
    	else 
			return n * factorialRecursivo(n-1);
    }
    
    private double potenciaRecursivo(double n, int exponente) {
		if(exponente == 0)
			return 1;
		else
			return n*=potenciaRecursivo(n, exponente-1);
    }
	//############ FIN - RECURSIVOS ###########
    
	//################## POW ##################
	public Polinomio obtenerPolinomioPow() throws Exception {
		double[] coeficientes = new double[this.n+1];
		
		for(int i = 0; i <= this.n; i++) {
			coeficientes[this.n - i] = terminoQueOcupaElLugarKPow(i);
		}
		
		return new Polinomio(coeficientes);
	}
	public double terminoQueOcupaElLugarKPow(int k) {
		return combinatoriaIterativo(this.n, k) * Math.pow(this.a, k) * Math.pow(this.b, this.n-k);
	}
	//############### FIN - POW ###############
}
