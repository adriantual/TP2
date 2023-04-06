package persistenciaRestaurant;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import restaurant.ArchivarTicket;

public class EnBaseDeDatosArchivarTicket implements ArchivarTicket {

	@Override
	public void archivarEnEscritorio(LocalDate fecha, Double monto) {
		String consultaRegistro = "insert into ticket(fecha, precio) values(?,?);";

		try {
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/practica", "root",
					"");
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(consultaRegistro);

			statement.setDate(1, Date.valueOf(fecha));
			statement.setDouble(2, monto);

			int cantidad = statement.executeUpdate();

			if (cantidad == 0) {
				throw new RuntimeException("no se pudo guardar el ticket");
			}

		} catch (SQLException e) {

			System.out.println("Error al procesar consulta");
			e.printStackTrace();

		}

	}

}
