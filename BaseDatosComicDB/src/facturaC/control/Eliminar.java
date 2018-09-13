package facturaC.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Eliminar {

	public static void anular(Scanner scanner, Conexion conexion) {
		try {
			facturaC.control.Mostrar.mostrar(conexion);
			conexion.consulta("UPDATE FacturaC " + "SET ESTADOVALIDO = 'No Habilitado' " + "WHERE NUMEROCOMPRA = ? ");
			int codigo = InputTypes.readInt("Ingrese el código de compra de la factura a anular: ", scanner);

			conexion.getSentencia().setInt(1, codigo);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
