package consultas.view;

import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class Menu {
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	    CONSULTAS  \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					" \n 1. Ventas Realizadas  \n 2. Compras Realizadas \n 3. Ganancias \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
				menuVentas(scanner, conexion);
				break;
			case 2:
				menuCompras(scanner, conexion);
				break;
			case 3:
				consultas.control.Mostrar.ganancias(conexion);
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


public static int getOpcionVentas(Scanner scanner) {
	while (true) {
		System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	    CONSULTA VENTAS  \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
		System.out.println(
				" \n 1. Ventas por Comic  \n 2. Ventas por Editorial \n 3. Ventas por Escritor \n 4. Ventas por Dibujante \n 5. Ventas por ??? \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
		int opcion = InputTypes.readInt("Que desea hacer?: ", scanner);
		System.out.println("\n --------------------------");
		return opcion;
	}
}

public static void menuVentas(Scanner scanner, Conexion conexion) {
	boolean salir = true;
	while (salir) {

		switch (getOpcionVentas(scanner)) {
		case 1:
			consultas.control.Mostrar.ventasComic(conexion);
			break;
		case 2:
			consultas.control.Mostrar.ventasEditorial(conexion);
			break;
		case 3:
			consultas.control.Mostrar.ventasEscritor(conexion);
			break;
		case 4:
			consultas.control.Mostrar.ventasDibujante(conexion);
			break;
		case 0:
			System.out.println("Cerrando Sistema ...    ");
			salir = false;
			break;
		default:
			System.out.println("Opción inválida, Intente de nuevo");
		}
	}
	public static int getOpcionCompras(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	    CONSULTA COMPRAS \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					" \n 1. Compras por Comic  \n 2. Compras por Editorial \n 3. Compras por Escritor \n 4. Compras por Dibujante \n 5. Compras por ??? \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
			int opcion = InputTypes.readInt("Que desea hacer?: ", scanner);
			System.out.println("\n --------------------------");
			return opcion;
		}
	}

	public static void menuCompras(Scanner scanner, Conexion conexion) {
		boolean salir = true;
		while (salir) {

			switch (getOpcionVentas(scanner)) {
			case 1:
				consultas.control.Mostrar.comprasComic(conexion);
				break;
			case 2:
				consultas.control.Mostrar.comprasEditorial(conexion);
				break;
			case 3:
				consultas.control.Mostrar.comprasEscritor(conexion);
				break;
			case 4:
				consultas.control.Mostrar.comprasDibujante(conexion);
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
