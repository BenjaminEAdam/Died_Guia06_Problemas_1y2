package problemaNro2;

import java.util.ArrayList;

public class Equipo implements Comparable<Equipo>{
	
	private String nombre;
	private String ubicacion;
	private String colores;
	private int golesAFavor=0;
	private int golesEnContra=0;
	private int partidosGanados=0;
	private int partidosEmpatados=0;
	private int partidosPerdidos=0;
	private ArrayList<Jugador> listaDeJugadores; 
	
	public void agregarJugador(Jugador j) {
		if(this.listaDeJugadores.size()<=21) {
			this.listaDeJugadores.add(j);
		}
		else {
			System.out.println("No se puede añadir el jugador "
					+ "porque el equipo está completo.");
		}
	}
	
	public void modificarEquipo(String nombre, String ubicacion, String colores) {
		
		this.nombre=nombre;
		this.ubicacion=ubicacion;
		this.colores=colores;
		
	}
	
	public int getPartidosGanados() {
		return partidosGanados;
	}
	
	public void addPartidoGanado() {
		this.partidosGanados++;
	}

	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}

	public void addPartidoEmpatado() {
		this.partidosEmpatados++;
	}

	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void addPartidoPerdido() {
		this.partidosPerdidos++;
	}
	
	public int puntosObtenidos() {
		return partidosGanados*3 +
				partidosEmpatados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getColores() {
		return colores;
	}

	public void setColores(String colores) {
		this.colores = colores;
	}

	public int getGolesAFavor() {
		return golesAFavor;
	}

	public void setGolesAFavor(int golesAFavor) {
		this.golesAFavor+=golesAFavor;
	}

	public int getGolesEnContra() {
		return golesEnContra;
	}

	public void setGolesEnContra(int golesEnContra) {
		this.golesEnContra+=golesEnContra;
	}

	public ArrayList<Jugador> getListaDeJugadores() {
		return listaDeJugadores;
	}

	public void setListaDeJugadores(ArrayList<Jugador> listaDeJugadores) {
		this.listaDeJugadores = listaDeJugadores;
	}

	@Override
	public int compareTo(Equipo o) {
		int resultado=0;
		if(this.puntosObtenidos()<o.puntosObtenidos()) {
			resultado=-1;
		}
		else if(this.puntosObtenidos()>o.puntosObtenidos()) {
			resultado=1;
		}
		else {
			resultado=0;
		}
		return resultado;
	}

}
