package persistenciaRestaurant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import restaurant.ArchivarTicket;

public class EnDiscoArchivarTicket implements ArchivarTicket {
	private String ruta;

	public EnDiscoArchivarTicket(String ruta) {
		super();
		this.ruta = ruta;
	}

	@Override
	public void archivarEnEscritorio(LocalDate fecha, Double monto) {
		String datos = fecha.toString() + " " + "//" + " " + String.valueOf(monto) + "\n";
		try {
			Files.write(Paths.get(this.ruta), datos.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
