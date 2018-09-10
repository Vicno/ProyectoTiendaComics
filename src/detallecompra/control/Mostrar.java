package detallecompra.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			conexion.consulta("SELECT * FROM DetalleCompra");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("codigoDETALLEcompra"));
				System.out.print("\t");
				System.out.print(resultSet.getString("CODIGOCOMIC"));
				System.out.print("\t");
				System.out.print(resultSet.getString("NUMEROcompra"));
				System.out.print("\t");
				System.out.println(resultSet.getString("CANTIDAD"));
				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
