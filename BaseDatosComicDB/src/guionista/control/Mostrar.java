package guionista.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			System.out.println("Guionista: "
					+ "\n  \tCódigo\t || \tNombre\t ");
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
	
	public static void mostrarCliente(Conexion conexion) {
		try {
			System.out.println("Guionista: "
					+ "\n  \tNombre\t || \tTrabajos\t ");
			conexion.consulta("SELECT g.nombreGuionista, GROUP_CONCAT(DISTINCT c.Titulo SEPARATOR ' ,' ) AS trabajos" + 
					"  FROM guionista g" + 
					"  INNER JOIN guionistacomic g1 ON g.codigoGuionista = g1.codigoGuionista" + 
					"  INNER JOIN comic c ON g1.codigoComic = c.codigoComic" + 
					" GROUP BY g.codigoGuionista");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("nombreGUIONISTA"));
				System.out.print("\t");
				System.out.println(resultSet.getString("Trabajos"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
