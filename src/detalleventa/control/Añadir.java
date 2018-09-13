package detalleventa.control;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {
	
	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			
			comic.control.Mostrar.mostrar(conexion);
			
			conexion.consulta(
					"INSERT INTO" + " DETALLEVENTA (codigodetalleventa, codigocomic, numeroventa, cantidad)"
							+ "  VALUES (?,?,?, ?)" + "");
			int codigodetalleventa = InputTypes.readInt("Ingrese el código del Detalle venta: ", scanner);
			BigDecimal codigoComic = InputTypes.readBig("Ingrese el codigo del comic: ", scanner);
			int numeroVenta = InputTypes.readInt("Ingrese el numero de la venta: ", scanner);
			int cantidad  = InputTypes.readInt("Ingrese la cantidad de comics: ", scanner);
			
			conexion.getSentencia().setInt(1, codigodetalleventa);
			conexion.getSentencia().setBigDecimal(2, codigoComic);
			conexion.getSentencia().setInt(3, numeroVenta);
			conexion.getSentencia().setInt(4, cantidad);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println("EL codigo del detalle de venta ya existe");
		}
		

	}
}
