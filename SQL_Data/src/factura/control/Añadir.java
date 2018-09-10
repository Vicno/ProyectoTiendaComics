package factura.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {

	/*********************************************************************************************
	 *                          Existe un error de excepcion que no pude manejar, java.sql.SQLIntegrityConstraintViolationException, 
	 *                          el cual en teoria, ya esta tratado, pero aun asi da error
	 * @param scanner
	 * @param conexion
	 * @throws java.sql.SQLIntegrityConstraintViolationException
	 */
	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta(
					"INSERT INTO" + " FACTURA (numeroventa, ID, nombre)"
							+ "  VALUES (?,?,?)" + "");
			int numeroventa = InputTypes.readInt("Ingrese el numero de la venta: ", scanner);
			int ID;
			while (true) {
				ID = InputTypes.readInt("Ingrese el ID del cliente: ", scanner);
				
				if(ID > 9999999 || ID < 100000) {
					System.out.println("Ingrese un numero ID valido");
				}
				else {
					break;
				}
			}
			
			String nombre = InputTypes.readString("Ingrese el nombre del cliente: ", scanner);
			
			conexion.getSentencia().setInt(1, numeroventa);
			conexion.getSentencia().setInt(2, ID);
			conexion.getSentencia().setString(3, nombre);
			conexion.modificacion();
		} catch (Throwable e) {
			System.out.println("agarro xdxd;lol6");
			e.printStackTrace();
		}

	}
}
