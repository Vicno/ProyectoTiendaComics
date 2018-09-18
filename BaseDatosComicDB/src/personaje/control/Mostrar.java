package personaje.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			System.out.println("Personajes: "
			+ "\n  \tCódigo\t || \tNombre\t");
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
	public static void mostrarCliente(Conexion conexion) {
		try {
			System.out.println("Personajes: "
			+ "\n  \tNombre\t || \tAparece en\t");
			conexion.consulta("SELECT p.nombrePersonaje, GROUP_CONCAT(DISTINCT c1.Titulo SEPARATOR ' ,' ) AS comic" + 
					"  FROM personajes p" + 
					"  INNER JOIN comicpersonajes c ON p.codigoPersonaje = c.códigoPersonaje" + 
					"  INNER JOIN comic c1 ON c.códigoComic = c1.codigoComic" + 
					"  GROUP BY p.codigoPersonaje");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("nombrePERSONAJE"));
				System.out.print("\t");
				System.out.println(resultSet.getString("comic"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
