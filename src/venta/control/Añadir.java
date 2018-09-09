package venta.control;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Añadir {
	private static ResultSet resultSet;
	
	public static void anadir(Scanner scanner, Conexion conexion) {
		int comics = 0;
		try {
			conexion.consulta(
					"INSERT INTO" + " VENTA (numeroventa, fecha, cantidad)"
							+ "  VALUES (?,?, ?)" + "");
			int numeroventa = InputTypes.readInt("Ingrese el código: ", scanner);
			ArrayList<Integer> cantidades = new ArrayList();
			
			conexion.getSentencia().setInt(1, numeroventa);
			
			
			String anho;
			String mes;
			String dia;
			while (true) {
				anho = InputTypes.readString("Ingrese el anho completo: ", scanner);
				if (anho.length() < 4 || anho.length() > 4 ) {
					System.out.println("Ingrese un anho completo, intente de nuevo");
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
			
			int fecha = Integer.parseInt(anho + mes + dia);
			conexion.getSentencia().setInt(2, fecha);
			
			while (true) {
				while (true) {
					try {

						conexion.consulta(" SELECT * " +
								" FROM comic c ");
						resultSet = conexion.resultado();
						System.out.println();
						while (resultSet.next()) {
							System.out.print(resultSet.getString("CODIGOCOMIC"));
							System.out.print("\t");
							System.out.print(resultSet.getString("TITULO"));
							System.out.print("\t");
							System.out.print(resultSet.getString("NUMEROCOMIC"));
							System.out.print("\t");
							System.out.print(resultSet.getString("AÑOPUBLICACION"));
							System.out.print("\t");
							System.out.print(resultSet.getString("EDITORIAL"));
							System.out.print("\t");
							System.out.print(resultSet.getString("DESCRIPCION"));
							System.out.print("\t");
							System.out.print("\t");
							System.out.println(resultSet.getString("PRECIO"));
						}
						
						conexion.consulta(" SELECT * " +
								" FROM venta v ");
						resultSet = conexion.resultado();

						while (resultSet.next()) {
							System.out.println("numero venta");
							System.out.println(resultSet.getString("numeroventa"));
						}
						conexion.consulta(
								"INSERT INTO" + " detalleventa (codigocomic, numeroventa)" + "  VALUES (?,?)");

						
						BigDecimal codigocomic = InputTypes.readBig("Ingrese el código del comic: ", scanner);
						conexion.getSentencia().setBigDecimal(1, codigocomic);
						conexion.getSentencia().setInt(2, numeroventa);
						conexion.modificacion();
						int numero = InputTypes.readInt("Ingrese el numero de comics a comprar: ", scanner);

						comics++;
						cantidades.add(numero);
						break;
						
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("Error, Comic no se encuentra en la base de datos! ");
					}

				}
				int opt = InputTypes.readInt("Hay más Comics?: (Yes: 1/No: 2) ", scanner);
				
				//System.out.println("tdo bien");
				if (opt == 2) {
					break;
				}
			}
			 
			
			int cantidad = 0;
			for (int i = 0; i <  cantidades.size(); i++) {
				cantidad = cantidades.get(i);
			}
			
			
			
			
			conexion.getSentencia().setInt(3, cantidad);
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
