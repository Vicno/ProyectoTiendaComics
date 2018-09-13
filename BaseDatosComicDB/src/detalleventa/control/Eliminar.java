package detalleventa.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Eliminar {

	public static void eliminar(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta("DELETE detalleventa " + "WHERE CODIGODETALLEventa = ? ");
			int codigo = InputTypes.readInt("Ingrese el código de detalle venta a anular: ", scanner);
			conexion.getSentencia().setInt(1, codigo);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
