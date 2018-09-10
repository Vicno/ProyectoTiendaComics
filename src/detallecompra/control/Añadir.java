package detallecompra.control;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {
	
	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta(
					"INSERT INTO" + " DETALLEcompra (codigodetallecompra, codigocomic, numerocompra, cantidad)"
							+ "  VALUES (?,?,?, ?)" + "");
			int codigodetallecompra = InputTypes.readInt("Ingrese el código del Detalle compra: ", scanner);
			BigDecimal codigoComic = InputTypes.readBig("Ingrese el codigo del comic: ", scanner);
			int numeroCompra = InputTypes.readInt("Ingrese el numero de la compra: ", scanner);
			int cantidad  = InputTypes.readInt("Ingrese la cantidad de comics: ", scanner);
			
			conexion.getSentencia().setInt(1, codigodetallecompra);
			conexion.getSentencia().setBigDecimal(2, codigoComic);
			conexion.getSentencia().setInt(3, numeroCompra);
			conexion.getSentencia().setInt(4, cantidad);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println("EL codigo del detalle de compra ya existe");
		}
		

	}
}
