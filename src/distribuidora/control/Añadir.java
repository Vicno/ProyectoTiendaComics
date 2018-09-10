package distribuidora.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {

	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta(
					"INSERT INTO" + " distribuidora (codigoDistribuidora, nombreDistribuidora, telefono, pais)"
							+ "  VALUES (?,?,?,?)");
			int codigo = InputTypes.readInt("Ingrese el código: ", scanner);
			String nombre = InputTypes.readString("Ingrese el nombre: ", scanner);
			int telefono = 0;
			
			while (true) {
				telefono = InputTypes.readInt("Ingrese el telefono: ", scanner);
				if (telefono> 10000000 && telefono < 100000000) {
					break;
				}
				else {
					System.out.println("Ingrese un numero de telefono valido");
				}
			}
			String pais = InputTypes.readString("Ingrese el pais: ", scanner);

			conexion.getSentencia().setInt(1, codigo);
			conexion.getSentencia().setString(2, nombre);
			conexion.getSentencia().setInt(3, telefono);
			conexion.getSentencia().setString(4, pais);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println("El codigo de disrtibuidora ingresado ya existe");
		}

	}
}
