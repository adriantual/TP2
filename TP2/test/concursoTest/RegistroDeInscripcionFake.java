package concursoTest;

import java.time.LocalDate;

import concurso.RegistroDeInscripcion;

public class RegistroDeInscripcionFake implements RegistroDeInscripcion {

	private String datos;

	@Override
	public void registroInscripcion(LocalDate fecha, int idConcurso, int idParticipante) {
		this.datos = "se llamo";

	}

	public boolean registro(String valor) {
		return this.datos.equals(valor);
	}

}
