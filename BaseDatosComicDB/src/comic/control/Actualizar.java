package comic.control;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Actualizar {
	
	public static void actualizar(Scanner scanner, Conexion conexion) {
		try {
			System.out.println("Comics: ");
			comic.control.Mostrar.mostrar(conexion);
			conexion.consulta("UPDATE COMIC "
					+ "SET TITULO = ?, "
					+ "NUMEROCOMIC = ?, "
					+ "AÑOPUBLICACION = ?, "
					+ "EDITORIAL = ?, "
					+ "DESCRIPCION = ?, "
					+ "PRECIO = ? "
					+ "WHERE CODIGOCOMIC = ? ");
			BigDecimal codigo = InputTypes.readBig(" \nIngrese el código de comic a modificar: ", scanner);
			String nombre = InputTypes.readString("Ingrese el nuevo nombre: ", scanner);
			int numero = InputTypes.readInt("Ingrese el nuevo número: ", scanner);
			int year = InputTypes.readInt("Ingrese el año: ", scanner);
			String editorial = InputTypes.readString("Ingrese la nueva editorial: ", scanner);
			String descripcion = InputTypes.readString("Ingrese la nueva descripcion: ", scanner);
			Double precio = InputTypes.readDouble("Ingrese el nuevo precio: ", scanner);
			
			
			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setInt(2, numero);
			conexion.getSentencia().setInt(3, year);
			conexion.getSentencia().setString(4, editorial);
			conexion.getSentencia().setString(5, descripcion);
			conexion.getSentencia().setDouble(6, precio);
			conexion.getSentencia().setBigDecimal(7, codigo);
			
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
