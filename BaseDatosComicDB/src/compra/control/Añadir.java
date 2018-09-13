package compra.control;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class A�adir {

	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			
			distribuidora.control.Mostrar.mostrar(conexion);
			conexion.consulta(
					"INSERT INTO" + " compra (numerocompra, fecha, codigodistribuidor)" + "  VALUES (?,?, ?)" + "");
			int numeroventa = InputTypes.readInt("Ingrese el c�digo: ", scanner);

			String a�o;
			String mes;
			String dia;
			while (true) {
				a�o = InputTypes.readString("Ingrese el a�o completo: ", scanner);
				if (a�o.length() !=4) {
					System.out.println("Ingrese un a�o completo, intente de nuevo");
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

			int codigoDistribuidor = InputTypes.readInt("Ingrese el c�digo de la distribuidora: ", scanner);
			conexion.getSentencia().setInt(1, numeroventa);
			int fecha = Integer.parseInt(a�o + mes + dia);
			conexion.getSentencia().setInt(2, fecha);
			conexion.getSentencia().setInt(3, codigoDistribuidor);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println("El codigo de distribuidora no existe o se repite el codigo de la compra");
		}

	}
}
