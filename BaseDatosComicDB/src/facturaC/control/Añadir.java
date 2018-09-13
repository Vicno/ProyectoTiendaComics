package facturaC.control;

import java.sql.SQLException;
import java.util.Scanner;

import Excepciones.FacturaRepetida;
import entity.Conexion;
import view.InputTypes;

public class Añadir {

	public static void anadir(Scanner scanner, Conexion conexion) throws FacturaRepetida {
		try {
			conexion.consulta(
					"INSERT INTO" + " FACTURAC (numerocompra, NIT, nombre)"
							+ "  VALUES (?,?,?)" + "");
			int numerocompra = InputTypes.readInt("Ingrese el numero de la compra: ", scanner);
			int ID;
			while (true) {
				ID = InputTypes.readInt("Ingrese el NIT de la empresa: ", scanner);
				
				if(ID > 1000000000 || ID < 100000) {
					System.out.println("Ingrese un NIT valido");
				}
				else {
					break;
				}
			}
			
			String nombre = InputTypes.readString("Ingrese el nombre de la empresa: ", scanner);
			
			conexion.getSentencia().setInt(1, numerocompra);
			conexion.getSentencia().setInt(2, ID);
			conexion.getSentencia().setString(3, nombre);
			conexion.modificacion();
		} catch (SQLException e) {
			throw new FacturaRepetida();
		}

	}
}
