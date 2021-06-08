package problemaNro2;

public class Gol extends Evento{
	
	private Jugador asistio;
	private Jugador realizo;
	private boolean autogol;
	
	public Jugador getAsistio() {
		return asistio;
	}
	public void setAsistio(Jugador asistio) {
		this.asistio = asistio;
	}
	public Jugador getRealizo() {
		return realizo;
	}
	public void setRealizo(Jugador realizo) {
		this.realizo = realizo;
	}
	public boolean isAutogol() {
		return autogol;
	}
	public void setAutogol(boolean autogol) {
		this.autogol = autogol;
	}

}
