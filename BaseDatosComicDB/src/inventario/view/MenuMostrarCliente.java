package inventario.view;

import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class MenuMostrarCliente {
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	     CLIENTE - MOSTRAR \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					"\n 1. Comic \n 2. Variaciones Comic \n 3. Dibujante  \n 4. Guionista \n 5. Personaje \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
				comic.control.Mostrar.mostrarCliente(conexion);
				break;
			case 2:
				comic.control.MostrarDetalles.mostrarCliente(conexion);
				break;
			case 3:
				dibujante.control.Mostrar.mostrarCliente(conexion);
				break;
			case 4:
				guionista.control.Mostrar.mostrarCliente(conexion);
				break;
			case 5:
				personaje.control.Mostrar.mostrarCliente(conexion);
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
