package problemaNro2;

import java.time.LocalDate;

public class Jugador implements Comparable<Jugador>{
	
	private String Nombre;
	private String dni;
	private LocalDate fechaNac;
	private Posicion posicion;
	private double altura;
	private double peso;
	private boolean izquierdo;
	private Equipo equipo;
	private int goles=0;
	private int partidosJugados;
	private int amonestacionesRecibidas;
	
	public int getPartidosJugados() {
		return partidosJugados;
	}
	public void setPartidoJugado() {
		this.partidosJugados++;
	}
	public int getAmonestacionesRecibidas() {
		return amonestacionesRecibidas;
	}
	public void setAmonestacionRecibida() {
		this.amonestacionesRecibidas++;
	}
	public int getGoles() {
		return goles;
	}
	public void setGol() {
		this.goles++;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public boolean isIzquierdo() {
		return izquierdo;
	}
	public void setIzquierdo(boolean izquierdo) {
		this.izquierdo = izquierdo;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	@Override
	public int compareTo(Jugador j) {
		int resultado=0;
		if(this.getGoles()<j.getGoles()) {
			resultado=-1;
		}
		else if(this.getGoles()>j.getGoles()) {
			resultado=1;
		}
		else {
			resultado=0;
		}
		return resultado;
	}

}
