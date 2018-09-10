package guionista.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			conexion.consulta("SELECT * FROM GUIONISTA");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("CODIGOGUIONISTA"));
				System.out.print("\t");
				System.out.println(resultSet.getString("NOMBREGUIONISTA"));
				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
