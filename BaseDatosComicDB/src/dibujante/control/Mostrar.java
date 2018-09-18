package dibujante.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			System.out.println("Dibujantes: \n  \tCódigo\t || \tNombre");
			conexion.consulta("SELECT * FROM DIBUJANTE");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("CODIGODIBUJANTE"));
				System.out.print("\t || ");
				System.out.println(resultSet.getString("NOMBREDIBUJANTE"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void mostrarCliente(Conexion conexion) {
		
		try {
			System.out.println("Dibujantes: \n  \tNombre\t || \tTrabajos ");
			conexion.consulta("SELECT d.nombredibujante, GROUP_CONCAT(DISTINCT c.Titulo SEPARATOR ' ,' ) AS trabajos" + 
					"  FROM dibujante d" + 
					"  INNER JOIN dibujantecomic d1 ON d.codigodibujante = d1.codigoDibujante" + 
					"  INNER JOIN comic c ON d1.codigoComic = c.codigoComic" + 
					"  GROUP BY d.codigodibujante");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("nombreDIBUJANTE"));
				System.out.print("\t || ");
				System.out.println(resultSet.getString("trabajos"));	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
