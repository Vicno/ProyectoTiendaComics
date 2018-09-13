package factura.control;

import java.sql.SQLException;
import java.util.Scanner;

import Excepciones.FacturaRepetida;
import entity.Conexion;
import view.InputTypes;

public class Añadir {

	public static void anadir(Scanner scanner, Conexion conexion) throws FacturaRepetida {
		try {
			conexion.consulta("INSERT INTO" + " FACTURA (numeroventa, ID, nombre)" + "  VALUES (?,?,?)" + "");
			int numeroventa = InputTypes.readInt("Ingrese el numero de la venta: ", scanner);
			int ID = InputTypes.readInt("Ingrese el ID del cliente: ", scanner);
			

			String nombre = InputTypes.readString("Ingrese el nombre del cliente: ", scanner);

			conexion.getSentencia().setInt(1, numeroventa);
			conexion.getSentencia().setInt(2, ID);
			conexion.getSentencia().setString(3, nombre);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new FacturaRepetida();
		}

	}
}
