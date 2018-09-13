package consultas.control;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;

public class MostrarVentas {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion, String consulta, String c1, String c2, String c3, String c4) {
		try {
			conexion.consulta(consulta);
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString(c1));
				System.out.print("\t");
				System.out.print(resultSet.getString(c2));
				System.out.print("\t");
				System.out.print(resultSet.getString(c3));
				System.out.print("\t");
				System.out.print(resultSet.getString(c4));
				System.out.print("\t");
				System.out.print(resultSet.getString("Total"));

			}
		} catch (SQLException e) {
			System.out.println("n");
		}
	}

	public static void ventasComic(Conexion conexion, Scanner scanner) {
		comic.control.Mostrar.mostrar(conexion);
		BigDecimal codigo = view.InputTypes.readBig("Ingrese el código de comic a consultar: ", scanner);
		String consulta = "SELECT c.codigoComic,c.Titulo, d.cantidad , c.precio ,(c.precio*d.cantidad) AS Total  "
				+ "				  FROM comic c INNER JOIN detalleventa d ON c.codigoComic = d.codigoComic   "
				+ "				  INNER JOIN venta v ON d.numeroVenta = v.numeroVenta"
				+ "  WHERE c.codigoComic = "+codigo+" ";
		mostrar(conexion, consulta, "codigocomic" , "titulo" , "cantidad","precio");
	}

	public static void ventasPersonaje(Conexion conexion, Scanner scanner) {
		personaje.control.Mostrar.mostrar(conexion);
		int codigo = view.InputTypes.readInt("Ingrese el código de personaje a consultar: ", scanner);
		String consulta = "SELECT c.codigoComic,c.Titulo, d.cantidad , c.precio ,(c.precio*d.cantidad) AS Total  "
				+ "				  FROM comic c INNER JOIN detalleventa d ON c.codigoComic = d.codigoComic   "
				+ "				  INNER JOIN venta v ON d.numeroVenta = v.numeroVenta"
				+ "  WHERE c.codigoComic = "+codigo+" ";
		mostrar(conexion, consulta, "codigocomic" , "titulo" , "cantidad","precio");
	}

	public static void ventasEscritor(Conexion conexion, Scanner scanner) {
		BigDecimal codigo = view.InputTypes.readBig("Ingrese el código de comic a consultar: ", scanner);
		String consulta = "SELECT c.codigoComic,c.Titulo, d.cantidad , c.precio ,(c.precio*d.cantidad) AS Total  "
				+ "				  FROM comic c INNER JOIN detalleventa d ON c.codigoComic = d.codigoComic   "
				+ "				  INNER JOIN venta v ON d.numeroVenta = v.numeroVenta"
				+ "  WHERE c.codigoComic = "+codigo+" ";
		mostrar(conexion, consulta, "codigocomic" , "titulo" , "cantidad","precio");
	}

	public static void ventasDibujante(Conexion conexion, Scanner scanner) {
		BigDecimal codigo = view.InputTypes.readBig("Ingrese el código de comic a consultar: ", scanner);
		String consulta = "SELECT c.codigoComic,c.Titulo, d.cantidad , c.precio ,(c.precio*d.cantidad) AS Total  "
				+ "				  FROM comic c INNER JOIN detalleventa d ON c.codigoComic = d.codigoComic   "
				+ "				  INNER JOIN venta v ON d.numeroVenta = v.numeroVenta"
				+ "  WHERE c.codigoComic = "+codigo+" ";
		mostrar(conexion, consulta, "codigocomic" , "titulo" , "cantidad","precio");
	}

}
