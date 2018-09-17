package consultas.view;

import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class MenuCompras {
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	    CONSULTAS - COMPRAS  \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					" \n 1. Por Comic  \n 2. Por Dibujante \n 3. Por Guionista \n 4. Por Personaje  \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
				consultas.control.MostrarCompras.comprasComic(conexion, scanner);
				break;
			case 2:
				consultas.control.MostrarCompras.comprasDibujante(conexion, scanner);
				break;
			case 3:
				consultas.control.MostrarCompras.comprasEscritor(conexion, scanner);
				break;
			case 4:
				consultas.control.MostrarCompras.comprasPersonaje(conexion, scanner);
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