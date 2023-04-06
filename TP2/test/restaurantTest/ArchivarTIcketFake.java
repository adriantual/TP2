package restaurantTest;

import java.time.LocalDate;

import restaurant.ArchivarTicket;

public class ArchivarTIcketFake implements ArchivarTicket {

	private String dato;

	@Override
	public void archivarEnEscritorio(LocalDate fecha, Double monto) {
		this.dato = "entro";

	}

	public boolean seArchivo(String textoAComparar) {
		if (this.dato == textoAComparar) {
			return true;
		}
		return false;
	}

}
