package ejercicio;

import java.util.ArrayList;

public class Lugar {
	private int lugarId;
	private ArrayList<Medicion> mediciones;
	private int incomparableCon;
	private int hostilEnRelacionCon;
	
	public Lugar(int lugarId) {
		super();
		this.lugarId = lugarId;
		this.mediciones = new ArrayList<Medicion>();
		this.incomparableCon = 0;
	}

	public int getLugarId() {
		return lugarId;
	}

	public int getIncomparableCon() {
		return incomparableCon;
	}
	
	public void sumarIncomparableCon() {
		incomparableCon++;
	}
	
	public int getHostilEnRelacionCon() {
		return hostilEnRelacionCon;
	}
	
	public void sumarHostilEnRelacionCon() {
		hostilEnRelacionCon++;
	}
	
	public ArrayList<Medicion> getMediciones() {
		return mediciones;
	}
	
	public void agregarMedicion(Medicion medicion) {
		mediciones.add(medicion);
	}
	
	public double verTemperaturaMasBaja() {
		double masBaja = Double.MAX_VALUE;
		
		for(int i = 0; i < mediciones.size(); i++) {
			if(masBaja > mediciones.get(i).getMin())
				masBaja = mediciones.get(i).getMin();
		}
		
		return masBaja;
	}
	
	public double verTemperaturaMasAlta() {
		double masAlta = Double.MIN_VALUE;
		
		for(int i = 0; i < mediciones.size(); i++) {
			if(masAlta < mediciones.get(i).getMax())
				masAlta = mediciones.get(i).getMax();
		}
		
		return masAlta;
	}

	@Override
	public String toString() {
		return "Lugar [lugarId=" + lugarId + ", mediciones=" + mediciones + ", incomparableCon=" + incomparableCon
				+ ", hostilEnRelacionCon=" + hostilEnRelacionCon + "]";
	}
	
}
