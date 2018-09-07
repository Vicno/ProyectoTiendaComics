package personaje.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {

	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta(
					"INSERT INTO" + " personajes (codigoPersonaje, nombrePersonaje)"
							+ "  VALUES (?,?)" + "");
			int codigo = InputTypes.readInt("Ingrese el código: ", scanner);
			String nombre = InputTypes.readString("Ingrese el nombre: ", scanner);
			
			conexion.getSentencia().setInt(1, codigo);
			conexion.getSentencia().setString(2, nombre);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
