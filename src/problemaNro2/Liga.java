package problemaNro2;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Liga {
	
	private ArrayList<Equipo> equipos;
	private ArrayList<Fecha> partidos;
	
	public void agregarEquipo(Equipo e) {
		this.equipos.add(e);
	}
	
	public void quitarEquipo(Equipo e) {
		this.equipos.remove(e);
	}

	public void consultarEquipos(Equipo e) {
		System.out.println(this.equipos.toString());
	}
	
	public void modificarEquipo(Equipo e, String nombre, String ubicacion, String colores) {
		e.modificarEquipo(nombre, ubicacion, colores);
	}
	
	public void agregarFeha(Fecha f) {
		this.partidos.add(f);
	}
	
	public void registrarPartido(Fecha f, Partido p) {
		f.agregarPartido(p);
	}
	
	public void registrarEvento(Partido p, Evento e) {
		p.agregarEvento(e);
	}
	
	public void imprimirTablaDePosiciones() {
		for(Equipo e: this.equipos.stream()
		.sorted((e1,e2) -> e1.compareTo(e2))
		.collect(Collectors.toList())) {
			System.out.println("Equipo: "+e.getNombre()
			+". Puntos: "+e.puntosObtenidos()
			+". Goles a favor: "+e.getGolesAFavor()
			+". Goles en contra: "+e.getGolesEnContra()
			+". Diferencia de goles: "+(e.getGolesAFavor()-e.getGolesEnContra()));
		}
	}
	
	public void imprimirTablaDeGoleadores() {
		ArrayList<Jugador> jugadoresLiga = this.equipos.get(0).getListaDeJugadores();
		for(int i=1; i<this.equipos.size(); i++) {
			jugadoresLiga.addAll(this.equipos.get(i).getListaDeJugadores());
		}
		for(Jugador j: jugadoresLiga.stream()
		.sorted((j1,j2) -> j1.compareTo(j2))
		.filter(j -> j.getGoles()>0)
		.collect(Collectors.toList())) {
			System.out.println("Jugador: "+j.getNombre()
			+". Goles: "+j.getGoles());
		}
	}
	
	public void imprimirListaDeJugadores() {
		ArrayList<Jugador> jugadoresLiga = this.equipos.get(0).getListaDeJugadores();
		for(int i=1; i<this.equipos.size(); i++) {
			jugadoresLiga.addAll(this.equipos.get(i).getListaDeJugadores());
		}
		for(Jugador j: jugadoresLiga.stream()
		.sorted((j1,j2) -> j1.compareTo(j2))
		.collect(Collectors.toList())) {
			System.out.println("Jugador: "+j.getNombre()
			+". Goles: "+j.getGoles());
		}
	}
}
