package view;

import java.util.Scanner;

import entity.Conexion;

public class Menu {
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	    MENU  \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					"\n 1. Comic \n 2. Dibujante  \n 3. Guionista \n 4. Personaje \n 5. Venta \n 6. Factura Venta"
					+ " \n 7. Tipo Especial \n 8. Detalle Venta \n 9. Distribuidora  \n 10. Detalle compra  "
					+ " \n 11. Compra \n 12. Factura compra \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
				comic.view.Menu.menu(scanner, conexion);
				break;
			case 2:
				dibujante.view.Menu.menu(scanner, conexion);
				break;
			case 3:
				guionista.view.Menu.menu(scanner, conexion);
				break;
			case 4:
				personaje.view.Menu.menu(scanner, conexion);
				break;
			case 5:
				venta.view.Menu.menu(scanner, conexion);
				break;
			case 6:
				factura.view.Menu.menu(scanner, conexion);
				break;
			case 7:
				tipoEspecial.view.Menu.menu(scanner, conexion);
				break;
			case 8:
				detalleventa.view.Menu.menu(scanner, conexion);
				break;
			case 9:
				distribuidora.view.Menu.menu(scanner, conexion);
				break;
			case 10:
				detallecompra.view.Menu.menu(scanner, conexion);
				break;
			case 11:
				compra.view.Menu.menu(scanner, conexion);
				break;
			case 12:
				facturaC.view.Menu.menu(scanner, conexion);
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
