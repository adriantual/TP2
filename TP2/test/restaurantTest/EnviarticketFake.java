package restaurantTest;

import java.time.LocalDate;

import restaurant.EnviarTIcket;

public class EnviarticketFake implements EnviarTIcket {

	private String dato;

	@Override
	public void envairTicket(String email, LocalDate fecha, Double monto) {
		this.dato = "entro";

	}

	public boolean seEnvio(String textoAComparar) {
		if (this.dato == textoAComparar) {
			return true;
		}
		return false;
	}

}
