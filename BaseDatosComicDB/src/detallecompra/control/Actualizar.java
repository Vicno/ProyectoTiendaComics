package detallecompra.control;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Actualizar {

	public static void actualizar(Scanner scanner, Conexion conexion) {
		try {
			detallecompra.control.Mostrar.mostrar(conexion);
			conexion.consulta("UPDATE detallecompra "
					+ "SET codigoComic = ? "
					+ "SET cantidad = ? "
					+ "SET numerocompra = ? "
					+ "SET preciocompraunidad = ? "
					+ "WHERE codigodetalleventa = ? ");
			int codigo = InputTypes.readInt("Ingrese el código de detalle de compra a modificar: ", scanner);
			
			BigDecimal codComic = InputTypes.readBig("Ingrese el código del comic: ", scanner);
			int cantidad = InputTypes.readInt("Ingrese la cantidad: ", scanner);
			
			int precio = InputTypes.readInt("Ingrese el precio de compra por unidad: ", scanner);
			int numerocompra = InputTypes.readInt("Ingrese el numero de compra: ", scanner);
			conexion.getSentencia().setBigDecimal(1, codComic);
			conexion.getSentencia().setInt(2, cantidad);
			conexion.getSentencia().setInt(3, numerocompra);
			conexion.getSentencia().setInt(4, precio);
			conexion.getSentencia().setInt(5, codigo);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
