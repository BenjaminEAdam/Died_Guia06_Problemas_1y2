package problemaNro1;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Curso {
	
	private int id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditosQueOtorga;
	private Integer creditosRequeridos;
	private Registro log;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditosQueOtorga() {
		return creditosQueOtorga;
	}

	public void setCreditosQueOtorga(Integer creditosQueOtorga) {
		this.creditosQueOtorga = creditosQueOtorga;
	}

	public boolean inscribirAlumno(Alumno a) throws IOException {
		int cursosIgualCL=0;
		for(Curso c: a.getCursando()) {
			if(c.cicloLectivo==this.cicloLectivo) {
				cursosIgualCL++;
			}
		}
		if(this.creditosRequeridos<=a.creditosObtenidos()
				&& this.inscriptos.size()<this.cupo
				&& cursosIgualCL<3) {
			this.inscriptos.add(a);
			a.inscripcionAceptada(this);
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			return true;
		}
		else {
			return false;
		}
	}
	
	public void imprimirCurso(Orden o) throws IOException {
		if(o.equals(Orden.ALFABETICAMENTE)) {
			for (Alumno a: this.inscriptos
					.stream()
					.sorted((a1,a2)-> a1.getNombre().compareTo(a2.getNombre()))
					.collect(Collectors.toList())) {
				System.out.println("Alumno: "+a.getNombre()
				+". Libreta universitaria: "+a.getNroLibreta()
				+". Créditos obtenidos: "+a.creditosObtenidos()+".");
			}
		}
		if(o.equals(Orden.LIBRETA_UNIVERSITARIA)) {
			for(Alumno a: this.inscriptos
					.stream()
					.sorted((a1,a2)->a1.getNroLibreta().compareTo(a2.getNroLibreta()))
					.collect(Collectors.toList())) {
				System.out.println("Alumno: "+a.getNombre()
				+". Libreta universitaria: "+a.getNroLibreta()
				+". Créditos obtenidos: "+a.creditosObtenidos()+".");
			}
		}
		if(o.equals(Orden.CREDITOS_OBTENIDOS)) {
			for(Alumno a: this.inscriptos
					.stream()
					.sorted((a1,a2)->a1.compareTo(a2))
					.collect(Collectors.toList())) {
				System.out.println("Alumno: "+a.getNombre()
				+". Libreta universitaria: "+a.getNroLibreta()
				+". Créditos obtenidos: "+a.creditosObtenidos()+".");
			}
		}
		log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
	}
}