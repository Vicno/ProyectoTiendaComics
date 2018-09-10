package dibujante.control;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Eliminar {

	public static void eliminar(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta("Delete from DIBUJANTE "
					+ "WHERE CODIGODIBUJANTE = ? ");
			int codigo = InputTypes.readInt("Ingrese el código del dibujante a eliminar: ", scanner);
			
			conexion.getSentencia().setInt(1, codigo);
			
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
