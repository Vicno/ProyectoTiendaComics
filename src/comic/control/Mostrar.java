package comic.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			conexion.consulta("SELECT * FROM COMIC");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("CODIGOCOMIC"));
				System.out.print("\t");
				System.out.print(resultSet.getString("TITULO"));
				System.out.print("\t");
				System.out.print(resultSet.getString("NUMEROCOMIC"));
				System.out.print("\t");
				System.out.print(resultSet.getString("AÑOPUBLICACION"));
				System.out.print("\t");
				System.out.print(resultSet.getString("EDITORIAL"));
				System.out.print("\t");
				System.out.println(resultSet.getString("PRECIO"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
