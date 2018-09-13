package detalleventa.control;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Actualizar {

	public static void actualizar(Scanner scanner, Conexion conexion) {
		try {
			System.out.println("Detalles de Venta: ");
			detalleventa.control.Mostrar.mostrar(conexion);
			System.out.println("Comics: ");
			comic.control.Mostrar.mostrar(conexion);
			conexion.consulta("UPDATE detalleventa "
					+ "SET codigoComic = ? "
					+ "SET cantidad = ? "
					+ "SET numeroventa = ? "
					+ "WHERE codigodetalleventa = ? ");
			int codigo = InputTypes.readInt("Ingrese el código de detalle de venta a modificar: ", scanner);
			
			BigDecimal codComic = InputTypes.readBig("Ingrese el código del comic: ", scanner);
			int cantidad = InputTypes.readInt("Ingrese la cantidad: ", scanner);
			int numeroventa = InputTypes.readInt("Ingrese el numero de venta: ", scanner);
			
			conexion.getSentencia().setBigDecimal(1, codComic);
			conexion.getSentencia().setInt(2, cantidad);
			conexion.getSentencia().setInt(3, numeroventa);
			conexion.getSentencia().setInt(4, codigo);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
