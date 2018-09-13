package factura.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Eliminar {

	public static void anular(Scanner scanner, Conexion conexion) {
		try {
			factura.control.Mostrar.mostrar(conexion);
			conexion.consulta("UPDATE Factura " + "SET ESTADOVALIDO = 'No Habilitado' " + "WHERE NUMEROVENTA = ? ");
			int codigo = InputTypes.readInt("Ingrese el código de venta de la factura a anular: ", scanner);
			conexion.getSentencia().setInt(1, codigo);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
