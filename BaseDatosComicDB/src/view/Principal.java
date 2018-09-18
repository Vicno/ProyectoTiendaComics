package view;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;

public class Principal {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Conexion conexion;
		try {
			conexion = new Conexion("root","","tiendacomics");
			view.MenuModo.menu(scanner, conexion);
			scanner.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("No se conectó a la base de datos");
		} 
		
		

	}
}
