package ejercicio;

public class Medicion {
	private double Max;
	private double Min;
	
	public double getMax() {
		return Max;
	}

	public double getMin() {
		return Min;
	}

	public Medicion(double min, double max) {
		super();
		Max = max;
		Min = min;
	}

	@Override
	public String toString() {
		return "Medicion [Max=" + Max + ", Min=" + Min + "]";
	}
	
	
}
