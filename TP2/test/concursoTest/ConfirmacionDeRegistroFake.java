package concursoTest;

import concurso.ConfirmacionDeRegistro;

public class ConfirmacionDeRegistroFake implements ConfirmacionDeRegistro {

	private String dato;

	@Override
	public void confirmacionDeRegistro(String email) {
		// TODO Auto-generated method stub

		this.dato = "entro";
	}

	public boolean confirmacion(String textoAComparar) {
		if (this.dato == textoAComparar) {
			return true;
		}
		return false;
	}

}
