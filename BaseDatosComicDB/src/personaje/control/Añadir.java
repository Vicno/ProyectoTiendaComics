package personaje.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {

	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta(
					"INSERT INTO" + " personajes (nombrePersonaje)"
							+ "  VALUES (?)" + "");
			String nombre = InputTypes.readString("Ingrese el nombre: ", scanner);
			
			conexion.getSentencia().setString(1, nombre);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
