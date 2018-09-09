package tipoEspecial.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {

	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta(
					"INSERT INTO" + " tipoespecial (codigoespecial, descripcion)"
							+ "  VALUES (?,?)" + "");
			int codigo = InputTypes.readInt("Ingrese el código: ", scanner);
			String descripcion = InputTypes.readString("Ingrese la descripcion: ", scanner);
			
			conexion.getSentencia().setInt(1, codigo);
			conexion.getSentencia().setString(2,descripcion);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
