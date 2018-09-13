package consultas.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class MostrarGanancias {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion, String consulta, String raiz, String tipoCons) {
		try {
			conexion.consulta(consulta);
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString(raiz));
				System.out.print("\t");
				System.out.print(resultSet.getString(tipoCons));
				
				
				
			}
		} catch (SQLException e) {
			System.out.println("n");
		}
	}

	public static void gananciasComic(Conexion conexion) {
		String consulta = "SELECT c.Titulo , SUM(c.precio-d1.precioCompraUnidad) AS Ganancia "+
		 " FROM comic c "+
		 " INNER JOIN detalleventa d ON c.codigoComic = d.codigoComic"+
		 " INNER JOIN detallecompra d1 ON c.codigoComic = d1.codigocomic";
		  mostrar(conexion, consulta, "titulo", "ganancia");
	}


	public static void gananciasEditorial(Conexion conexion) {
		String consulta =" SELECT c.editorial, SUM(c.precio-d1.precioCompraUnidad) AS Ganancia" + 
				"  FROM comic c" + 
				"  INNER JOIN detalleventa d ON c.codigoComic = d.codigoComic" + 
				"  INNER JOIN detallecompra d1 ON c.codigoComic = d1.codigocomic";
		mostrar(conexion, consulta, "editorial", "ganancia");
	}

	public static void gananciasEscritor(Conexion conexion) {
		String consulta = "SELECT g1.nombreGuionista, SUM(c.precio-d1.precioCompraUnidad) AS Ganancia" + 
				"  FROM comic c " + 
				"INNER JOIN guionistacomic g ON c.codigoComic = g.codigoComic" + 
				"  INNER JOIN guionista g1 ON g.codigoGuionista = g1.codigoGuionista" + 
				"  INNER JOIN detalleventa d ON c.codigoComic = d.codigoComic" + 
				"  INNER JOIN detallecompra d1 ON c.codigoComic = d1.codigocomic";
		
		
		mostrar(conexion, consulta, "nombreescritor", "ganancia");
	}

	public static void gananciasDibujante(Conexion conexion) {
		String consulta = "SELECT d3.nombredibujante, SUM(c.precio-d1.precioCompraUnidad) AS Ganancia" + 
				"  FROM comic c " + 
				" INNER JOIN dibujantecomic d2 ON c.codigoComic = d2.codigoComic" + 
				"  INNER JOIN dibujante d3 ON d2.codigoDibujante = d3.codigodibujante" + 
				"  INNER JOIN detalleventa d ON c.codigoComic = d.codigoComic" + 
				"  INNER JOIN detallecompra d1 ON c.codigoComic = d1.codigocomic";
		mostrar(conexion, consulta, "nombredibujante", "ganancia");
	}
	
	public static void gananciasTotal (Conexion conexion) {
		try {
			conexion.consulta("SELECT SUM(c.precio-d1.precioCompraUnidad) AS Ganancia" + 
					"  FROM comic c " +  
					"  INNER JOIN detalleventa d ON c.codigoComic = d.codigoComic" + 
					"  INNER JOIN detallecompra d1 ON c.codigoComic = d1.codigocomic");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("Ganancias"));
				
				
				
				
			}
		} catch (SQLException e) {
			System.out.println("n");
		}
		
	}

}
