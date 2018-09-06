package comic.Control;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;
import view.InputTypes;

public class Eliminar {

	public static void eliminar(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta("DELETE COMIC "
					+ "WHERE COMIC LIKE ? ");
			String comicCondicion = InputTypes.readString("Ingrese la condicion: ", scanner);
			conexion.getSentencia().setString(1, comicCondicion);
			conexion.modificacion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
