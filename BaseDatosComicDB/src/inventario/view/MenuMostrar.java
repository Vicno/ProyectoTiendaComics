package inventario.view;

import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class MenuMostrar {
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	     INVENTARIO - MOSTRAR \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					"\n 1. Comic \n 2. Variaciones Comic \n 3. Tipos Variaciones \n 4. Dibujante  \n 5. Guionista \n 6. Personaje \n 7. Distribuidora\n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
				comic.control.Mostrar.mostrar(conexion);
				break;
			case 2:
				comic.control.MostrarDetalles.mostrar(conexion);
				break;
			case 3:
				tipoEspecial.control.Mostrar.mostrar(conexion);
				break;
			case 4:
				dibujante.control.Mostrar.mostrar(conexion);
				break;
			case 5:
				guionista.control.Mostrar.mostrar(conexion);
				break;
			case 6:
				personaje.control.Mostrar.mostrar(conexion);
				break;
			case 7:
				distribuidora.control.Mostrar.mostrar(conexion);
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
