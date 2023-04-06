package restaurant;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
	private ArrayList<Bebida> bebidas;
	private ArrayList<PlatoPrincipal> platosPrincipales;
	private boolean pagado;
	private ArchivarTicket archivar;
	private EnviarTIcket enviarTicket;

	public Pedido(ArchivarTicket archivar, EnviarTIcket enviarTicket) {
		super();
		this.bebidas = new ArrayList<Bebida>();
		this.platosPrincipales = new ArrayList<PlatoPrincipal>();
		this.pagado = false;
		this.archivar = archivar;
		this.enviarTicket = enviarTicket;
	}

	public void añadirUnPlato(PlatoPrincipal unPlato) {
		this.platosPrincipales.add(unPlato);
	}

	public void AñadirUnaBebida(Bebida unaBebida) {
		this.bebidas.add(unaBebida);
	}

	public double total(int descuentoPlatosPrincipales, int descuentoBebidas, int propina) {
		double total = 0;
		LocalDate hoy = LocalDate.now();
		for (PlatoPrincipal plato : platosPrincipales) {
			total = total + plato.precio(descuentoPlatosPrincipales);
		}
		for (Bebida bebida : bebidas) {
			total = total + bebida.precio(descuentoBebidas);
		}
		total = total * (1 + (propina / 100));
		enviarTicket.envairTicket("adri.antual.10@gmail.com", hoy, total);
		archivar.archivarEnEscritorio(hoy, total);
		return total;

	}

	public void pagado() {
		this.pagado = true;
	}

	public boolean isPagado() {
		return pagado;
	}

}
