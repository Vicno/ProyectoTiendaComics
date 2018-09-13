package consultas.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class MostrarCompras {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion, String consulta, String tipoCons, String raiz) {
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

	public static void ganancias(Conexion conexion) {
		
	}

	public static void ventasComic(Conexion conexion) {
		String consulta = "SELECT c.Titulo, (c.precio*d.cantidad) AS Ventas " + 
				"  FROM comic c INNER JOIN detalleventa d ON c.codigoComic = d.codigoComic " + 
				"  INNER JOIN venta v ON d.numeroVenta = v.numeroVenta";
		mostrar(conexion, consulta, "Ventas", "Titulo");
	}

	public static void ventasEditorial(Conexion conexion) {
		
	}

	public static void ventasEscritor(Conexion conexion) {
		
	}

	public static void ventasDibujante(Conexion conexion) {
		
	}

	public static void comprasComic(Conexion conexion) {
		
	}

	public static void comprasEditorial(Conexion conexion) {
		
	}

	public static void comprasDibujante(Conexion conexion) {
		
	}

	public static void comprasEscritor(Conexion conexion) {
		
	}
}
