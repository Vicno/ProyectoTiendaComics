package control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {

	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta(
					"INSERT INTO" + " comic (codigoComic, Titulo, numeroComic, añoPublicacion, editorial, precio)"
							+ "  VALUES (?,?, ? , ? , ?, ?)" + "");
			int comicCodigo = InputTypes.readInt("Ingrese el código: ", scanner);
			String comicTitulo = InputTypes.readString("Ingrese el titulo: ", scanner);
			int comicNumero = InputTypes.readInt("Ingrese el numerocomic: ", scanner);
			int comicAño = InputTypes.readInt("Ingrese el año de publicacion: ", scanner);
			String comicEditorial = InputTypes.readString("Ingrese el nombre de editorial: ", scanner);
			Double precio = InputTypes.readDouble("Ingrese el precio: ", scanner);

			conexion.getSentencia().setInt(1, comicCodigo);
			conexion.getSentencia().setString(2, comicTitulo);
			conexion.getSentencia().setInt(3, comicNumero);
			conexion.getSentencia().setInt(4, comicAño);
			conexion.getSentencia().setString(5, comicEditorial);
			conexion.getSentencia().setDouble(6, precio);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
