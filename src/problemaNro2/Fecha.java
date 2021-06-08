package problemaNro2;

import java.util.ArrayList;

public class Fecha {
	
	ArrayList<Partido> partidos;
	
	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void agregarPartido(Partido p) {
		this.partidos.add(p);
	}

}
