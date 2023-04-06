package concurso;

import java.time.LocalDate;

public interface RegistroDeInscripcion {
	public void registroInscripcion(LocalDate fecha, int idConcurso, int idParticipante);

}
