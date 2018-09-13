package comic.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class MostrarDetalles {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			System.out.println("Variaciones Comics: ");
			conexion.consulta(
					" SELECT c.codigoComic, c.Titulo, t.Descripcion AS ESPECIAL" + 
					" FROM comic c " + 
					"  INNER JOIN comicespecial c1 ON c.codigoComic = c1.codigocomic" + 
					"  INNER JOIN tipoespecial t ON c1.codigoEspecial = t.codigoEspecial");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("CODIGOCOMIC"));
				System.out.print("\t");
				System.out.print(resultSet.getString("TITULO"));
				System.out.print("\t");
				System.out.println(resultSet.getString("ESPECIAL"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
