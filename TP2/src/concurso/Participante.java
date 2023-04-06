package concurso;

import java.util.Objects;

public class Participante {

	private String nombre;
	private String apellido;
	private int documento;
	private int puntos;
	private String email;

	public Participante(String nombre, String apellido, int documento, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.puntos = 0;
		this.email = email;
	}

	public String email() {
		return this.email;
	}

	public int id() {
		return this.documento;
	}

	public int obtenerPuntos() {
		return puntos;
	}

	public boolean tienePuntos() {
		if (puntos > 0) {
			return true;
		}
		return false;
	}

	public void asignarPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, documento, nombre, puntos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		return Objects.equals(apellido, other.apellido) && documento == other.documento
				&& Objects.equals(nombre, other.nombre) && puntos == other.puntos;
	}

}
