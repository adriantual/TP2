package concursoTest;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import concurso.Concurso;
import concurso.Participante;

class ConcursoTest {

	@Test
	public void unParticipanteSeInscribeEnUnConcursotest() {

		LocalDate fechaInicio = LocalDate.now().plusDays(-10);
		LocalDate fechaFinalizacion = LocalDate.now().plusDays(30);
		var registrofake = new RegistroDeInscripcionFake();
		var confirmacionfake = new ConfirmacionDeRegistroFake();
		Concurso primerConcurso = new Concurso("ejemplo", fechaInicio, fechaFinalizacion, registrofake,
				confirmacionfake);
		Participante unParticipante = new Participante("Adrian", "Antual", 25896325, "adri.antual.10@gmail.com");

		primerConcurso.inscribirParticipante(unParticipante);

		assertTrue(primerConcurso.estaInscripto(unParticipante));
		assertTrue(registrofake.registro("se llamo"));
		assertTrue(confirmacionfake.confirmacion("entro"));

	}

	public void unParticipanteSeInscribeEnUnConcursoElPrimerDíaDeAbiertaLaInscripción() {
		LocalDate fechaInicio = LocalDate.now();
		LocalDate fechaFinalizacion = LocalDate.now().plusDays(30);
		var registrofake = new RegistroDeInscripcionFake();
		var confirmacionfake = new ConfirmacionDeRegistroFake();
		Concurso primerConcurso = new Concurso("ejemplo", fechaInicio, fechaFinalizacion, registrofake,
				confirmacionfake);
		Participante unParticipante = new Participante("Adrian", "Antual", 25896325, "adri.antual.10@gmail.com");

		primerConcurso.inscribirParticipante(unParticipante);

		assertTrue(primerConcurso.InscriptoElMismoDia(unParticipante));
		assertTrue(registrofake.registro("se llamo"));
		assertTrue(confirmacionfake.confirmacion("entro"));
	}

}