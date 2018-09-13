package compra.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {

	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			
			distribuidora.control.Mostrar.mostrar(conexion);
			conexion.consulta(
					"INSERT INTO" + " compra (numerocompra, fecha, codigodistribuidor)" + "  VALUES (?,?, ?)" + "");
			int numeroventa = InputTypes.readInt("Ingrese el código: ", scanner);

			String año;
			String mes;
			String dia;
			while (true) {
				año = InputTypes.readString("Ingrese el año completo: ", scanner);
				if (año.length() !=4) {
					System.out.println("Ingrese un año completo, intente de nuevo");
				} else {
					break;
				}

			}

			while (true) {
				mes = InputTypes.readString("Ingrese el mes: ", scanner);
				int comprovante = Integer.parseInt(mes);
				if (comprovante >= 0 && comprovante < 10) {
					mes = 0 + Integer.toString(comprovante);
				}
				if (comprovante > 12 || comprovante < 0) {
					System.out.println("El numero de mes no existe, intente de nuevo");
				} else {
					break;
				}
			}
			while (true) {
				dia = InputTypes.readString("Ingrese el dia: ", scanner);
				int comprovante2 = Integer.parseInt(dia);
				if (comprovante2 >= 0 && comprovante2 < 10) {
					dia = 0 + Integer.toString(comprovante2);
				}
				if (comprovante2 > 31 || comprovante2 < 0) {
					System.out.println("El numero de dia no existe, intente de nuevo");
				} else {
					break;
				}
			}

			int codigoDistribuidor = InputTypes.readInt("Ingrese el código de la distribuidora: ", scanner);
			conexion.getSentencia().setInt(1, numeroventa);
			int fecha = Integer.parseInt(año + mes + dia);
			conexion.getSentencia().setInt(2, fecha);
			conexion.getSentencia().setInt(3, codigoDistribuidor);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println("El codigo de distribuidora no existe o se repite el codigo de la compra");
		}

	}
}
