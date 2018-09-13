package economico.view;

import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Menu {
	
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	    TRANSACCIONES  \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					"\n 1. Compra \n 2. Venta \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
				menu2(scanner, conexion,"Compra");
				break;
			case 2:
				menu2(scanner, conexion,"Venta");
				break;
			case 0:
				System.out.println("Cerrando Sistema ...    ");
				salir = false;
				break;
			default:
				System.out.println("Opción inválida, Intente de nuevo");
			}
		}
	}
	
	public static int getOpcion2(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	    TRANSACCIONES  \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					"\n 1. Modificar \n 2. Añadir  \n 3. Mostrar \n 4. Eliminar \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
			int opcion = InputTypes.readInt("Que desea hacer?: ", scanner);
			System.out.println("\n --------------------------");
			return opcion;
		}
	}

	public static void menu2(Scanner scanner, Conexion conexion, String tipo) {
		boolean salir = true;
		while (salir) {

			switch (getOpcion2(scanner)) {
			case 1:
				economico.view.MenuModificar.menu(scanner, conexion, tipo);
				break;
			case 2:
				economico.view.MenuAñadir.menu(scanner, conexion, tipo);
				break;
			case 3:
				economico.view.MenuMostrar.menu(scanner, conexion, tipo);
				break;
			case 4:
				economico.view.MenuEliminar.menu(scanner, conexion, tipo);
				break;
			case 0:
				System.out.println("Cerrando Sistema ...    ");
				salir = false;
				break;
			default:
				System.out.println("Opción inválida, Intente de nuevo");
			}
		}
	}
}
