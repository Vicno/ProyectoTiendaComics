package distribuidora.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {

	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta(
					"INSERT INTO" + " distribuidora (nombreDistribuidora, telefono, pais)"
							+ "  VALUES (?,?,?)");
			String nombre = InputTypes.readString("Ingrese el nombre: ", scanner);
			int telefono = 0;
			
			while (true) {
				telefono = InputTypes.readInt("Ingrese el telefono: ", scanner);
				if (telefono> 100000 && telefono < 1000000000) {
					break;
				}
				else {
					System.out.println("Ingrese un numero de telefono valido");
				}
			}
			String pais = InputTypes.readString("Ingrese el pais: ", scanner);

			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setInt(2, telefono);
			conexion.getSentencia().setString(3, pais);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println("El codigo de distribuidora ingresado ya existe");
		}

	}
}
