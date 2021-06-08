package problemaNro1;

import java.util.List;

public class Alumno implements Comparable<Alumno>{
	
	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public int creditosObtenidos() {
		return this.aprobados.stream().mapToInt(c->c.getCreditosQueOtorga()).sum();
	}

	public void aprobar(Curso c) {
		this.aprobados.add(c);
		this.cursando.remove(c);
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}

	@Override
	public int compareTo(Alumno a) {
		int resultado=0;
		if(this.creditosObtenidos()<a.creditosObtenidos()) {
			resultado=-1;
		}
		else if(this.creditosObtenidos()<a.creditosObtenidos()) {
			resultado=1;
		}
		else {
			resultado=0;
		}
		return resultado;
	}

}
