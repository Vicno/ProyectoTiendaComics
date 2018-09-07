package dibujante.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			conexion.consulta("SELECT * FROM DIBUJANTE");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("CODIGODIBUJANTE"));
				System.out.print("\t");
				System.out.println(resultSet.getString("NOMBREDIBUJANTE"));
			
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
