package tipoEspecial.control;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class AñadirRelacion {

	public static void anadir(Scanner scanner, Conexion conexion) {
		while (true) {
			try {
				comic.control.MostrarDetalles.mostrar(conexion);
				tipoEspecial.control.Mostrar.mostrar(conexion);
				BigDecimal comicCodigo = InputTypes.readBig("Ingrese el código: ", scanner);
				conexion.consulta(
						"INSERT INTO comicespecial (\ncodigocomic, codigoEspecial) VALUES (?,?) ");
				int especial = InputTypes.readInt("Ingrese el código de atributo especial: ", scanner);
				conexion.getSentencia().setBigDecimal(1, comicCodigo);
				conexion.getSentencia().setInt(2, especial);
				conexion.modificacion();
				break;
			} catch (SQLException e) {
				System.out.println("Error, TipoEspecial no se encuentra en la base de datos! ");
				e.printStackTrace();
			}

		}
		
	}

}
