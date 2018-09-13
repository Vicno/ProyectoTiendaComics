package economico.view;

import java.util.Scanner;

import Excepciones.FacturaRepetida;
import entity.Conexion;
import view.InputTypes;

public class MenuAñadir {
	public static int getOpcion(Scanner scanner, String tipo) {
		while (true) {
			System.out.println(
					"\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	     " + tipo + " - AÑADIR \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out
					.println("\n 1. Detalles \n 2. "+tipo+" \n 3. Factura \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
			int opcion = InputTypes.readInt("Que desea hacer?: ", scanner);
			System.out.println("\n --------------------------");
			return opcion;
		}
	}

	public static void menu(Scanner scanner, Conexion conexion, String tipo) {
		boolean salir = true;

		if (tipo == "Compra") {

			while (salir) {

				switch (getOpcion(scanner, tipo)) {
				case 1:
					detallecompra.control.Añadir.anadir(scanner, conexion);
					break;
				case 2:
					compra.control.Añadir.anadir(scanner, conexion);
					break;
				case 3:
					try {
						facturaC.control.Añadir.anadir(scanner, conexion);
					} catch (FacturaRepetida e) {
						System.out.println(e.getMessage());
					}
					break;
				case 0:
					System.out.println("Cerrando Sistema ...    ");
					salir = false;
					break;
				default:
					System.out.println("Opción inválida, Intente de nuevo");
				}
			}
		}else {
			while (salir) {

				switch (getOpcion(scanner, tipo)) {
				case 1:
					detalleventa.control.Añadir.anadir(scanner, conexion);
					break;
				case 2:
					venta.control.Añadir.anadir(scanner, conexion);
					break;
				case 3:
					try {
						factura.control.Añadir.anadir(scanner, conexion);
					} catch (FacturaRepetida e) {
						System.out.println(e.getMessage());
					}
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
}
