package restaurant;

public class Visa extends TarjetaDeCredito {

	public Visa(String nombreTitular) {
		super(nombreTitular);
		// TODO Auto-generated constructor stub
		descuentoBebidas = 3;
		descuentoEnPlatosPrincipales = 0;
	}

}
