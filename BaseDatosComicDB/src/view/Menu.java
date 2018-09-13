package view;

import java.util.Scanner;

import entity.Conexion;

public class Menu {
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	    MENU  \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					"\n 1. Financieras \n 2. Administracion  \n 3. Consultas \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
			int opcion = InputTypes.readInt("Que desea hacer?: ", scanner);
			System.out.println("\n --------------------------");
			return opcion;
		}
	}

	public static void menu(Scanner scanner, Conexion conexion) {
		boolean salir = true;
		while (salir) {

			switch (getOpcion(scanner)) {
			case 1:
				economico.view.Menu.menu(scanner, conexion);
				break;
			case 2:
				inventario.view.Menu.menu(scanner, conexion);
				break;
			case 3:
				consultas.view.Menu.menu(scanner, conexion);
				break;
			default:
				System.out.println("Opción inválida, Intente de nuevo");
			}
		}
	}
}
