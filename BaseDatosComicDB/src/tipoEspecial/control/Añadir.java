package tipoEspecial.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {

	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta(
					"INSERT INTO" + " tipoespecial (descripcion)"
							+ "  VALUES (?)");
			String descripcion = InputTypes.readString("Ingrese la descripcion: ", scanner);
			
			conexion.getSentencia().setString(1,descripcion);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
