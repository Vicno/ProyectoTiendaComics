package view;

import java.util.Scanner;

import entity.Conexion;

public class MenuModo {
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	    MODO  \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					"\n 1. Cliente \n 2. Administrador  \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
				inventario.view.MenuMostrarCliente.menu(scanner, conexion);
				break;
			case 2:
				view.Menu.menu(scanner, conexion);
				break;
			case 0:
				System.out.println("Cerrando Sistema ...    ");
				salir=false;
				break;
			
			default:
				System.out.println("Opción inválida, Intente de nuevo");
			}
		}
	}
}
