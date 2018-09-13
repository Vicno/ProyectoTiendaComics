package personaje.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Actualizar {
	
	public static void actualizar(Scanner scanner, Conexion conexion) {
		try {
			personaje.control.Mostrar.mostrar(conexion);
			conexion.consulta("UPDATE PERSONAJES "
					+ "SET NOMBREPERSONAJE = ? "
					+ "WHERE CODIGOPERSONAJE = ? ");
			int codigo = InputTypes.readInt("Ingrese el código de personaje a modificar: ", scanner);
			String nombre = InputTypes.readString("Ingrese el nuevo nombre: ", scanner);
			
			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setInt(2, codigo);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
