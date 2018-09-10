package venta.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			conexion.consulta("SELECT * FROM Venta");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("NUMEROVENTA"));
				System.out.print("\t");
				System.out.println(resultSet.getString("FECHA"));
				
				
				
			}
		} catch (SQLException e) {
			System.out.println("n");;
		}
	}
}
