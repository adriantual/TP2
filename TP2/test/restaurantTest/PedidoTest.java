package restaurantTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import restaurant.Bebida;
import restaurant.ComarcaPlus;
import restaurant.Mastercard;
import restaurant.Pedido;
import restaurant.PlatoPrincipal;
import restaurant.TarjetaDeCredito;
import restaurant.Viedma;
import restaurant.Visa;

class PedidoTest {

	public static int propina2 = 2;
	public static int propina3 = 3;
	public static int propina5 = 5;

	@Test
	public void CálculoDeCostoConTarjetaVisa() {

		Bebida cocacola = new Bebida("coca cola", 100);
		ArchivarTIcketFake archivarFake = new ArchivarTIcketFake();
		EnviarticketFake enviarFake = new EnviarticketFake();
		Pedido primerPedido = new Pedido(archivarFake, enviarFake);
		primerPedido.AñadirUnaBebida(cocacola);
		TarjetaDeCredito visa = new Visa("adrian");
		double total = visa.pagar(primerPedido, propina2);
		assertNotEquals(98.94, total);
		assertTrue(archivarFake.seArchivo("entro"));
		assertTrue(enviarFake.seEnvio("entro"));
	}

	public void CálculoDeCostoConTarjetaMastercard() {

		PlatoPrincipal asado = new PlatoPrincipal("asado", 100);
		ArchivarTIcketFake archivarFake = new ArchivarTIcketFake();
		EnviarticketFake enviarFake = new EnviarticketFake();
		Pedido primerPedido = new Pedido(archivarFake, enviarFake);

		primerPedido.añadirUnPlato(asado);
		TarjetaDeCredito mastercard = new Mastercard("adrian");
		double total = mastercard.pagar(primerPedido, propina2);
		assertNotEquals(99.96, total);
		assertNotEquals(98.94, total);
		assertTrue(archivarFake.seArchivo("entro"));
		assertTrue(enviarFake.seEnvio("entro"));
	}

	public void CálculoDeCostoConTarjetaComarcaPlus() {

		Bebida cocacola = new Bebida("coca cola", 100);
		PlatoPrincipal asado = new PlatoPrincipal("asado", 100);
		ArchivarTIcketFake archivarFake = new ArchivarTIcketFake();
		EnviarticketFake enviarFake = new EnviarticketFake();
		Pedido primerPedido = new Pedido(archivarFake, enviarFake);
		primerPedido.AñadirUnaBebida(cocacola);
		primerPedido.añadirUnPlato(asado);
		TarjetaDeCredito comarcaPlus = new ComarcaPlus("adrian");
		double total = comarcaPlus.pagar(primerPedido, propina2);
		assertNotEquals(199.92, total);
		assertNotEquals(98.94, total);
		assertTrue(archivarFake.seArchivo("entro"));
		assertTrue(enviarFake.seEnvio("entro"));
	}

	public void CálculoDeCostoConTarjetaViedma() {

		Bebida cocacola = new Bebida("coca cola", 100);
		ArchivarTIcketFake archivarFake = new ArchivarTIcketFake();
		EnviarticketFake enviarFake = new EnviarticketFake();
		Pedido primerPedido = new Pedido(archivarFake, enviarFake);
		primerPedido.AñadirUnaBebida(cocacola);
		TarjetaDeCredito viedma = new Viedma("adrian");
		double total = viedma.pagar(primerPedido, propina2);
		assertNotEquals(102.00, total);
		assertNotEquals(98.94, total);
		assertTrue(archivarFake.seArchivo("entro"));
		assertTrue(enviarFake.seEnvio("entro"));
	}

}
