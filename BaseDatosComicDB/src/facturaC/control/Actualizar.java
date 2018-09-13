package facturaC.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Actualizar {

	public static void actualizar(Scanner scanner, Conexion conexion) {
		try {
			facturaC.control.Mostrar.mostrar(conexion);
			conexion.consulta("UPDATE FacturaC "
					+ "SET NIT = ? "
					+ "SET Nombre = ? "
					+ "WHERE NUMEROCOMPRA = ? ");
			int codigo = InputTypes.readInt("Ingrese el código de compra de la factura a modificar: ", scanner);
			
			int ID = InputTypes.readInt("Ingrese el nuevo NIT: ", scanner);
			String nombre = InputTypes.readString("Ingrese el nuevo nombre: ", scanner);
			
			conexion.getSentencia().setInt(1, ID);
			conexion.getSentencia().setString(2, nombre);
			conexion.getSentencia().setInt(3, codigo);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
