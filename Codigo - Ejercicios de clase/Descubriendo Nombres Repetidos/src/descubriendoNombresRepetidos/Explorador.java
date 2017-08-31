package descubriendoNombresRepetidos;

public class Explorador implements Comparable<Explorador>
{
	private String Nombre;
	private int Repeticiones = 1;
	
	@Override
	public int compareTo(Explorador arg0) {
		if(this.Repeticiones > arg0.Repeticiones)
			return -1;
		else
			return 1;
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
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
		Explorador other = (Explorador) obj;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}
	public int getRepeticiones() {
		return Repeticiones;
	}
	public void setRepeticiones(int repeticiones) {
		Repeticiones = repeticiones;
	}

}
