package tipoEspecial.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Actualizar {
	
	public static void actualizar(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta("UPDATE TIPOESPECIAL "
					+ "SET descripcion = ? "
					+ "WHERE CODIGOespecial = ? ");
			int codigo = InputTypes.readInt("Ingrese el código de tipo especial a modificar: ", scanner);
			String descripcion = InputTypes.readString("Ingrese la nueva descripcion: ", scanner);
			
			conexion.getSentencia().setString(1, descripcion);
			conexion.getSentencia().setInt(2, codigo);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
