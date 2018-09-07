package comic.control;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class A�adir {

	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta("INSERT INTO"
					+ " comic (codigoComic, Titulo, numeroComic, a�oPublicacion, editorial, descripcion, precio)"
					+ "  VALUES (?,?, ?,?, ? , ?, ?)" + "");
			BigDecimal comicCodigo = InputTypes.readBig("Ingrese el c�digo: ", scanner);
			String comicTitulo = InputTypes.readString("Ingrese el titulo: ", scanner);
			int comicNumero = InputTypes.readInt("Ingrese el n�mero de comic: ", scanner);
			int comicA�o = InputTypes.readInt("Ingrese el a�o de publicacion: ", scanner);
			String descripcion = InputTypes.readString("Ingrese la descripcion: ", scanner);
			String comicEditorial = InputTypes.readString("Ingrese el nombre de editorial: ", scanner);
			Double precio = InputTypes.readDouble("Ingrese el precio: ", scanner);

			conexion.getSentencia().setBigDecimal(1, comicCodigo);
			conexion.getSentencia().setString(2, comicTitulo);
			conexion.getSentencia().setInt(3, comicNumero);
			conexion.getSentencia().setInt(4, comicA�o);
			conexion.getSentencia().setString(5, comicEditorial);
			conexion.getSentencia().setString(6, descripcion);
			conexion.getSentencia().setDouble(7, precio);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
