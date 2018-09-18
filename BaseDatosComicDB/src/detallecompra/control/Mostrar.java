package detallecompra.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try {
			System.out.println("Detalles de Compra: "
					+ "\n  \tC�digo Detalle\t || \tC�digo Comic \t || \tTitulo Comic\t"
			+ " \tCantidad\t || \tN�mero de Compra\t ");
			conexion.consulta("SELECT d.codigodetallecompra, d.codigoComic, c.Titulo, d.cantidad, d.numeroCompra" + 
					"  FROM detallecompra d INNER JOIN comic c ON d.codigoComic = c.codigoComic");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("codigoDETALLEcompra"));
				System.out.print("\t");
				System.out.print(resultSet.getString("CODIGOCOMIC"));
				System.out.print("\t");
				System.out.print(resultSet.getString("titulo"));
				System.out.print("\t");
				System.out.print(resultSet.getString("cantidad"));
				System.out.print("\t");
				System.out.println(resultSet.getString("NUMEROcompra"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
