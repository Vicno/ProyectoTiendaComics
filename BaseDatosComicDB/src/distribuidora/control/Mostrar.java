package distribuidora.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			System.out.println("Distribuidoras: ");
			conexion.consulta("SELECT * FROM DISTRIBUIDORA");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("CODIGOdistribuidora"));
				System.out.print("\t");
				System.out.print(resultSet.getString("nombredistribuidora"));
				System.out.print("\t");
				System.out.print(resultSet.getString("telefono"));
				System.out.print("\t");
				System.out.println(resultSet.getString("pais"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
