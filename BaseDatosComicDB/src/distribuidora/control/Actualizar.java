package distribuidora.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Actualizar {
	
	public static void actualizar(Scanner scanner, Conexion conexion) {
		try {
			distribuidora.control.Mostrar.mostrar(conexion);
			conexion.consulta("UPDATE distribuidora "
					+ "SET nombreDistribuidora = ?, "
					+ " telefono = ?, "
					+ " pais = ? "
					+ "WHERE codigodistribuidora = ? ");
			int codigo = InputTypes.readInt("Ingrese el código de la distribuidora a modificar: ", scanner);
			String nombre = InputTypes.readString("Ingrese el nuevo nombre: ", scanner);
			int telefono;
			while (true) {
				telefono = InputTypes.readInt("Ingrese el nuevo telefono: ", scanner);
				if (telefono> 100000 && telefono < 1000000000) {
					break;
				}
				else {
					System.out.println("Ingrese un numero de telefono valido");
				}
			}
			
			String pais = InputTypes.readString("Ingrese el nuevo pais: ", scanner);
			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setInt(2, telefono);
			conexion.getSentencia().setString(3, pais);
			conexion.getSentencia().setInt(4, codigo);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println("No existe una distribuidora con ese codigo");
		}
}
}
