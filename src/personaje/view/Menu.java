package personaje.view;

import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Menu {
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	    PERSONAJE  \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					"\n 1. Actualizar \n 2. A�adir  \n 3. Mostrar \n 4. Eliminar \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
				personaje.control.Actualizar.actualizar(scanner, conexion);
				break;
			case 2:
				personaje.control.A�adir.anadir(scanner, conexion);
				break;
			case 3:
				personaje.control.Mostrar.mostrar(conexion);
				break;
			case 4:
				personaje.control.Eliminar.eliminar(scanner, conexion);
				break;
			case 0:
				System.out.println("Cerrando Sistema ...    ");
				salir = false;
				break;
			default:
				System.out.println("Opci�n inv�lida, Intente de nuevo");
			}
		}
	}
}
