package restaurant;

public class Mastercard extends TarjetaDeCredito {

	public Mastercard(String nombreTitular) {
		super(nombreTitular);
		descuentoBebidas = 0;
		descuentoEnPlatosPrincipales = 2;

	}

}
