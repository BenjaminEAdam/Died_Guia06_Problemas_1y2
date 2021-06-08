package problemaNro1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Registro {
	
private final String FILE_PATH = "registro.log";
	
	public void registrar(Curso c,String operacion,String detalle) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
		writer.append("["+LocalDateTime.now().toString()+"]se registro la operacion: "
		+ operacion+" en el curso"+ c.toString());
		writer.append("Detalle"+ detalle);
		writer.close();
	}

}
