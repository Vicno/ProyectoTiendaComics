package detalleventa.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {
	
	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta(
					"INSERT INTO" + " DETALLEVENTA (codigodetalleventa, codigocomic, numeroventa, cantidad)"
							+ "  VALUES (?,?,?, ?)" + "");
			int codigodetalleventa = InputTypes.readInt("Ingrese el código del Detalle venta: ", scanner);
			int codigoComic = InputTypes.readInt("Ingrese el codigo del comic: ", scanner);
			int numeroVenta = InputTypes.readInt("Ingrese el numero de la venta: ", scanner);
			int cantidad  = InputTypes.readInt("Ingrese la cantidad de comics: ", scanner);
			
			conexion.getSentencia().setInt(1, codigodetalleventa);
			conexion.getSentencia().setInt(2, codigoComic);
			conexion.getSentencia().setInt(3, numeroVenta);
			conexion.getSentencia().setInt(4, cantidad);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
