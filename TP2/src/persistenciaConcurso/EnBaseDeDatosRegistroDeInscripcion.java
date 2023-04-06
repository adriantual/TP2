package persistenciaConcurso;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import concurso.RegistroDeInscripcion;

public class EnBaseDeDatosRegistroDeInscripcion implements RegistroDeInscripcion {

	@Override
	public void registroInscripcion(LocalDate fecha, int idConcurso, int idParticipante) {

		String consultaRegistro = "insert into registro(fecha, id_concurso, id_persona) values(?,?,?);";

		try {
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/practica", "root",
					"");
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(consultaRegistro);

			statement.setDate(1, Date.valueOf(fecha));
			statement.setLong(2, idConcurso);
			statement.setLong(3, idParticipante);

			int cantidad = statement.executeUpdate();

			if (cantidad == 0) {
				throw new RuntimeException("no se pudo registrar la inscripcion");
			}

		} catch (SQLException e) {

			System.out.println("Error al procesar consulta");
			e.printStackTrace();

		}
	}
}
