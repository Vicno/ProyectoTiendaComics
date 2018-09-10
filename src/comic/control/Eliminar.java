package comic.control;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Eliminar {

	public static void eliminar(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta("Delete from COMIC "
					+ "WHERE CODIGOCOMIC = ? ");
			BigDecimal codigo = InputTypes.readBig("Ingrese el código de comic a eliminar: ", scanner);
			
			conexion.getSentencia().setBigDecimal(1, codigo);
			
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
