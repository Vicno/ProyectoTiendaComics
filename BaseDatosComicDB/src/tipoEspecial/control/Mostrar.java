package tipoEspecial.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			System.out.println("Tipos de Variaciones:"
					+ "\n  \tCódigo\t || \tDescripcion\t ");
			conexion.consulta("SELECT * FROM tipoespecial");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("CODIGOespecial"));
				System.out.print("\t");
				System.out.println(resultSet.getString("descripcion"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
