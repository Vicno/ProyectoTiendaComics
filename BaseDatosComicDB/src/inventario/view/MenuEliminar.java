package inventario.view;

import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class MenuEliminar {
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	     INVENTARIO - ELIMINAR \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					"\n 1. Comic \n 2. Tipo Comic \n 3. Dibujante  \n 4. Guionista \n 5. Personaje \n 6. Distribuidora\n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
				comic.control.Eliminar.eliminar(scanner, conexion);
				break;
			case 2:
				tipoEspecial.control.Eliminar.eliminar(scanner, conexion);
				break;
			case 3:
				dibujante.control.Eliminar.eliminar(scanner, conexion);
				break;
			case 4:
				guionista.control.Eliminar.eliminar(scanner, conexion);
				break;
			case 5:
				personaje.control.Eliminar.eliminar(scanner, conexion);
				break;
			case 6:
				distribuidora.control.Eliminar.eliminar(scanner, conexion);
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
