package concurso;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {

	private String nombre;
	private LocalDate fechaIncio;
	private LocalDate fechaFinalizacion;
	private ArrayList<Participante> participantes;
	private RegistroDeInscripcion archivar; // esto es inyeccion de dependencia
	private int id;
	private ConfirmacionDeRegistro confirmacion;

	public Concurso(String nombre, LocalDate fechaIncio, LocalDate fechaFinalizacion, RegistroDeInscripcion archivar,
			ConfirmacionDeRegistro confirmacion) {
		super();
		this.nombre = nombre;
		this.fechaIncio = fechaIncio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.participantes = new ArrayList<Participante>();
		this.archivar = archivar;
		this.id = 1;
		this.confirmacion = confirmacion;

	}

	private Boolean dentroDelRangoParaInscribirse(LocalDate fecha) {
		if (fecha.isAfter(fechaIncio) || fecha.equals(fechaIncio)) {
			if (fecha.isBefore(fechaFinalizacion) || fecha.equals(fechaFinalizacion)) {
				return true;
			}
		}
		return false;
	}

	public void inscribirParticipante(Participante unParticipante) {

		LocalDate hoy = LocalDate.now();
		if (dentroDelRangoParaInscribirse(hoy)) {

			if (hoy.equals(fechaIncio)) {
				// this.participantes.add(unParticipante);
				unParticipante.asignarPuntos(10);
			}
			this.participantes.add(unParticipante);
			archivar.registroInscripcion(hoy, unParticipante.id(), this.id);
			confirmacion.confirmacionDeRegistro(unParticipante.email());
		}
		// throw new RuntimeException("fuera de fecha");

	}

	public boolean estaInscripto(Participante unParticipante) {

		if (participantes.contains(unParticipante)) {
			return true;
		}
		return false;
	}

	public boolean InscriptoElMismoDia(Participante unParticipante) {

		if (participantes.contains(unParticipante) && (unParticipante.tienePuntos())) {

			return true;
		}
		return false;
	}

	// solo esta puesto para que se salga la advertencia
	public String Nombre() {
		return nombre;
	}

}
