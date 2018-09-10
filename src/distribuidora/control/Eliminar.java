package distribuidora.control;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Eliminar {

	public static void eliminar(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta("Delete from distribuidora "
					+ "WHERE CODIGODistribuidora = ? ");
			int codigo = InputTypes.readInt("Ingrese el código de la distribuidora: ", scanner);
			
			conexion.getSentencia().setInt(1, codigo);
			
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
