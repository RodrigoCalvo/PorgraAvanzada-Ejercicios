package main;

public class Categoria {
	private int id;
	private int min_edad;
	private int max_edad;
	
	public Boolean aplicaAEdad(int edad) {
		return edad >= min_edad && edad <= max_edad;
	}
	
	public int getMin_edad() {
		return min_edad;
	}

	public void setMin_edad(int min_edad) {
		this.min_edad = min_edad;
	}

	public int getMax_edad() {
		return max_edad;
	}

	public void setMax_edad(int max_edad) {
		this.max_edad = max_edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria(int min_edad, int max_edad, int id) {
		super();
		this.min_edad = min_edad;
		this.max_edad = max_edad;
		this.id = id;
	}
	
	
}
