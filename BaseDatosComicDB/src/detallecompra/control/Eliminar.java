package detallecompra.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Eliminar {

	public static void eliminar(Scanner scanner, Conexion conexion) {
		try {
			detallecompra.control.Mostrar.mostrar(conexion);
			conexion.consulta("DELETE detallecompra " + "WHERE CODIGODETALLECOMPRA = ? ");
			int codigo = InputTypes.readInt("Ingrese el código de detalle compra a anular: ", scanner);
			conexion.getSentencia().setInt(1, codigo);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
