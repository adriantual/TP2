package persistenciaConcurso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import concurso.RegistroDeInscripcion;

public class EnDiscoRegistroDeInscripcion implements RegistroDeInscripcion {

	private String ruta;

	public EnDiscoRegistroDeInscripcion(String ruta) {

		this.ruta = ruta;
	}

	@Override
	public void registroInscripcion(LocalDate fecha, int idConcurso, int idParticipante) {
		String datos = fecha.toString() + " " + "//" + " " + Integer.toString(idConcurso) + " " + "//" + " "
				+ Integer.toString(idParticipante) + "\n";
		try {
			Files.write(Paths.get(this.ruta), datos.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
