package guionista.control;

import java.sql.SQLException;
import java.util.Scanner;
import entity.Conexion;
import view.InputTypes;

public class Eliminar {

	public static void eliminar(Scanner scanner, Conexion conexion) {
		try {
			guionista.control.Mostrar.mostrar(conexion);
			conexion.consulta("Delete from guionista "
					+ "WHERE CODIGOguionista = ? ");
			int codigo = InputTypes.readInt("Ingrese el c�digo del guionista a eliminar: ", scanner);
			
			conexion.getSentencia().setInt(1, codigo);
			
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
