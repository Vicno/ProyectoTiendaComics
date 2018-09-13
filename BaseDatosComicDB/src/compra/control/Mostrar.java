package compra.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			System.out.println("Compras: ");
			conexion.consulta("SELECT * FROM compra");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("NUMEROcompra"));
				System.out.print("\t");
				System.out.print(resultSet.getString("FECHA"));
				System.out.print("\t");
				System.out.println(resultSet.getString("CODIGODISTRIBUIDOR"));
				
				
				
			}
		} catch (SQLException e) {
			System.out.println("n");
		}
	}
}
