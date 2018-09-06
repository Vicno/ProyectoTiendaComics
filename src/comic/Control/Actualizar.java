package comic.Control;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;
import view.InputTypes;

public class Actualizar {
	
	public static void actualizar(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta("UPDATE COMIC "
					+ "SET TITULO = ?, "
					+ "PRECIO = ? "
					+ "WHERE COMIC LIKE ? ");
			String comic = InputTypes.readString("Ingrese el nuevo nombre: ", scanner);
			Double precio = InputTypes.readDouble("Ingrese el nuevo precio: ", scanner);
			String comicCondicion = InputTypes.readString("Ingrese la condicion: ", scanner);
			conexion.getSentencia().setString(1, comic);
			conexion.getSentencia().setDouble(2, precio);
			conexion.getSentencia().setString(3, comicCondicion);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
