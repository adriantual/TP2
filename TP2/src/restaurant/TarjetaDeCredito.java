package restaurant;

public abstract class TarjetaDeCredito {

	public String titular;
	public static int descuentoBebidas = 0;
	public static int descuentoEnPlatosPrincipales = 0;

	public TarjetaDeCredito(String nombreTitular) {
		super();
		this.titular = nombreTitular;
	}

	public double pagar(Pedido unPedido, int propina) {

		return unPedido.total(descuentoEnPlatosPrincipales, descuentoBebidas, propina);

	}

	public String getTitular() {
		return titular;
	}

}
