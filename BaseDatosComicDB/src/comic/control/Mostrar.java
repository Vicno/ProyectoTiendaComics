package comic.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			System.out.println("Comics: ");
			conexion.consulta(
					" SELECT c.codigoComic, c.Titulo, c.precio, c.numeroComic, YEAR(c.añoPublicacion) AS AÑO,c.editorial,c.descripcion,g1.nombreGuionista,d1.nombredibujante "/*,GROUP_CONCAT(DISTINCT p.nombrePersonaje ORDER BY p.nombrePersonaje SEPARATOR ', ') AS Personajes "*/
							+ "	FROM comic c INNER JOIN guionistacomic g ON c.codigoComic = g.codigoComic "
							+ "	INNER JOIN guionista g1 ON g.codigoGuionista = g1.codigoGuionista  "
							+ "	INNER JOIN dibujantecomic d ON c.codigoComic = d.codigoComic "
							+ "	INNER JOIN dibujante d1 ON d.codigoDibujante = d1.codigodibujante "
							/*+ " INNER JOIN comicpersonajes c1 ON c.codigoComic = c1.códigoComic INNER JOIN personajes p ON c1.códigoPersonaje = p.codigoPersonaje"*/);
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("CODIGOCOMIC"));
				System.out.print("\t");
				System.out.print(resultSet.getString("TITULO"));
				System.out.print("\t");
				System.out.print(resultSet.getString("PRECIO"));
				System.out.print("\t");
				System.out.print(resultSet.getString("NUMEROCOMIC"));
				System.out.print("\t");
				System.out.print(resultSet.getString("AÑO"));
				System.out.print("\t");
				System.out.print(resultSet.getString("EDITORIAL"));
				System.out.print("\t");
				System.out.print(resultSet.getString("NOMBREGUIONISTA"));
				System.out.print("\t");
				System.out.print(resultSet.getString("NOMBREDIBUJANTE"));
				System.out.print("\t");
				//System.out.print(resultSet.getString("PERSONAJES"));
				//System.out.print("\t");
				System.out.println(resultSet.getString("DESCRIPCION"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
