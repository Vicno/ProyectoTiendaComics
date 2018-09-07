package comic.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			conexion.consulta("SELECT c.codigoComic, c.Titulo, c.numeroComic,c.añoPublicacion,c.editorial,c.descripcion,g1.nombreGuionista,d1.nombredibujante,c.precio\r\n" + 
					"FROM comic c INNER JOIN guionistacomic g ON c.codigoComic = g.codigoComic\r\n" + 
					"  INNER JOIN guionista g1 ON g.codigoGuionista = g1.codigoGuionista \r\n" + 
					"  INNER JOIN dibujantecomic d ON c.codigoComic = d.codigoComic\r\n" + 
					"  INNER JOIN dibujante d1 ON d.codigoDibujante = d1.codigodibujante");
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
				System.out.print(resultSet.getString("DESCRIPCION"));
				System.out.print("\t");
				System.out.print(resultSet.getString("NOMBREGUIONISTA"));
				System.out.print("\t");
				System.out.print(resultSet.getString("NOMBREDIBUJANTE"));
				System.out.print("\t");
				System.out.println(resultSet.getString("PRECIO"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
