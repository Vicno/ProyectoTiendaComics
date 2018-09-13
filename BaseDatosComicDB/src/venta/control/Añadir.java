package venta.control;


import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {
	
	public static void anadir(Scanner scanner, Conexion conexion) {
		try {
			conexion.consulta(
					"INSERT INTO" + " VENTA (numeroventa, fecha)"
							+ "  VALUES (?,?)" + "");
			int numeroventa = InputTypes.readInt("Ingrese el código: ", scanner);

			String anho;
			String mes;
			String dia;
			while (true) {
				anho = InputTypes.readString("Ingrese el año completo: ", scanner);
				if (anho.length() < 4 || anho.length() > 4 ) {
					System.out.println("Ingrese un año completo, intente de nuevo");
				}
				else {
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
			}
			else {
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
				}
				else {
					break;
				}
				}
			conexion.getSentencia().setInt(1, numeroventa);
			int fecha = Integer.parseInt(anho + mes + dia);
			conexion.getSentencia().setInt(2, fecha);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
