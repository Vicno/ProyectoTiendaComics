package guionista.view;

import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Menu {
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	    GUIONISTA  \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					"\n 1. Actualizar \n 2. Añadir  \n 3. Mostrar \n 4. Eliminar \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
				guionista.control.Actualizar.actualizar(scanner, conexion);
				break;
			case 2:
				guionista.control.Añadir.anadir(scanner, conexion);
				break;
			case 3:
				guionista.control.Mostrar.mostrar(conexion);
				break;
			case 4:
				guionista.control.Eliminar.eliminar(scanner, conexion);
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
