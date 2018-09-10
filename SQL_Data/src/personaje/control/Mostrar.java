package personaje.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			conexion.consulta("SELECT * FROM PERSONAJES");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("CODIGOPERSONAJE"));
				System.out.print("\t");
				System.out.println(resultSet.getString("NOMBREPERSONAJE"));
				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
