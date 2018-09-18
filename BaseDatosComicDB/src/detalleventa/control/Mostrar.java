package detalleventa.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			System.out.println("Detalles de venta: "
			+ "\n  \tC�digo Detalle\t || \tC�digo Comic\t || \tCantidad\t || \tN�mero de Compra");
			conexion.consulta("SELECT d.codigodetallecompra, d.codigoComic, c.Titulo, d.cantidad, d.numerocompra"
					+ "  FROM detallecompra d INNER JOIN comic c ON d.codigoComic = c.codigoComic");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("codigoDETALLECompra"));
				System.out.print("\t");
				System.out.print(resultSet.getString("CODIGOCOMIC"));
				System.out.print("\t");
				System.out.print(resultSet.getString("CANTIDAD"));
				System.out.print("\t");
				System.out.println(resultSet.getString("NUMEROcompra"));
				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
