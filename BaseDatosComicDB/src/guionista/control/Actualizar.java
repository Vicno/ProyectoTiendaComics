package guionista.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Actualizar {
	
	public static void actualizar(Scanner scanner, Conexion conexion) {
		try {
			guionista.control.Mostrar.mostrar(conexion);
			conexion.consulta("UPDATE GUIONISTA "
					+ "SET NOMBREGUIONISTA = ? "
					+ "WHERE CODIGOGUIONISTA = ? ");
			int codigo = InputTypes.readInt("Ingrese el código de guionista a modificar: ", scanner);
			String nombre = InputTypes.readString("Ingrese el nuevo nombre: ", scanner);
			
			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setInt(2, codigo);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
