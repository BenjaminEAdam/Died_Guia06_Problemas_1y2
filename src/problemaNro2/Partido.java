package problemaNro2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Partido {
	
	private Equipo local;
	private Equipo visitante;
	private boolean ganoLocal=false;
	private boolean ganoVisitante=false;
	private boolean empate=false;
	private Fecha fecha;
	private LocalDate dia_hora;
	private ArrayList<Jugador> titulares;
	private ArrayList<Jugador> suplentes;
	private ArrayList<Evento> eventos;
	
	public void agregarEvento(Evento e) {
		this.eventos.add(e);
	}
	
	public void setPartidosJugados(){
		for(Jugador j: titulares) {
			j.setPartidoJugado();
		}
	}
	
	public void setAmonestacionesRecibidas() {
		for(Evento e: this.eventos) {
			if(e instanceof TarjetaAmarillaORoja) {
				((TarjetaAmarillaORoja) e).getRecibio().setAmonestacionRecibida();
			}
		}
	}
	
	public void obtenerResultado() {
		int golesLocal=0;
		int golesVisitante=0;
		for(Evento e: this.eventos) {
			if(e instanceof Gol) {
				if(((Gol) e).getRealizo().getEquipo().equals(this.local)) {
					if(((Gol) e).isAutogol()) {
						golesVisitante++;
					}
					else {
						golesLocal++;
					}
				}
				else {
					if(((Gol) e).isAutogol()) {
						golesLocal++;
					}
					else {
						golesVisitante++;
					}
				}
			}
		}
		this.local.setGolesAFavor(golesLocal);
		this.local.setGolesEnContra(golesVisitante);
		this.visitante.setGolesAFavor(golesVisitante);
		this.visitante.setGolesEnContra(golesLocal);
		if(golesVisitante<golesLocal) {
			this.ganoLocal=true;
		}
		else if(golesVisitante>golesLocal) {
			this.ganoVisitante=true;
		}
		else {
			this.empate=true;
		}
	}
}
