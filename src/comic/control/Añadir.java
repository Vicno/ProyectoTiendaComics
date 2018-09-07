package comic.control;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class A�adir {

	public static void anadir(Scanner scanner, Conexion conexion) {
		BigDecimal comicCodigo = null;
		while (true) {
			try {

				conexion.consulta("INSERT INTO"
						+ " comic (codigoComic, Titulo, numeroComic, a�oPublicacion, editorial, descripcion, precio)"
						+ "  VALUES (?,?, ?,?, ? , ?, ?)" + "");
				comicCodigo = InputTypes.readBig("Ingrese el c�digo: ", scanner);
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
				break;

			} catch (SQLException e) {
				System.out.println("C�mic no pudo ser ingresado, c�digo Ya existe! ");
			}

		}

		// Iniciar Relacion con Guionista
		while (true) {
			while (true) {
				try {

					conexion.consulta(
							"INSERT INTO" + " guionistacomic (codigoGuionista, codigoComic)" + "  VALUES (?,?)");

					int codigoguion = InputTypes.readInt("Ingrese el c�digo del guionista: ", scanner);
					conexion.getSentencia().setInt(1, codigoguion);
					conexion.getSentencia().setBigDecimal(2, comicCodigo);
					conexion.modificacion();
					break;
				} catch (SQLException e) {
					System.out.println("Error, guionista no se encuentra en la base de datos! ");
				}

			}
			String opt = InputTypes.readString("Hay m�s Guionistas?: (Y/N) ", scanner);
			if ( opt == "N" || opt == "n") {
				break;
			}
		}

		// Iniciar Relacion con Dibujante

		while (true) {
			while (true) {
				try {
					conexion.consulta(
							"INSERT INTO" + " dibujantecomic (codigoComic, codigoDibujante)" + "  VALUES (?,?)");
					int codigodibujo = InputTypes.readInt("Ingrese el c�digo del dibujante: ", scanner);
					conexion.getSentencia().setBigDecimal(1, comicCodigo);
					conexion.getSentencia().setInt(2, codigodibujo);
					conexion.modificacion();
					break;
				} catch (SQLException e) {
					System.out.println("Error, dibujante no se encuentra en la base de datos! ");
				}
			}
			String opt = InputTypes.readString("Hay m�s Dibujantes?: (Y/N) ", scanner);
			if ( opt == "N"|| opt == "n") {
				break;
			}
		}

		// Iniciar Relacion con Personajes

		while (true) {
			while (true) {
				try {

					conexion.consulta(
							"INSERT INTO" + " comicpersonajes (c�digoComic, c�digoPersonaje)" + "  VALUES (?,?)");
					int codigoPersonaje = InputTypes.readInt("Ingrese el c�digo del dibujante: ", scanner);
					conexion.getSentencia().setBigDecimal(1, comicCodigo);
					conexion.getSentencia().setInt(2, codigoPersonaje);
					conexion.modificacion();
					break;
				} catch (SQLException e) {
					System.out.println("Error, Personaje no se encuentra en la base de datos! ");
				}

			}
			String opt = InputTypes.readString("Hay m�s Personajes?: (Y/N) ", scanner);
			if ( opt == "N" || opt == "n") {
				break;
			}
		}

	}
}
