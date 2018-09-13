package economico.view;

import java.util.Scanner;

import Excepciones.FacturaRepetida;
import entity.Conexion;
import view.InputTypes;

public class MenuA�adir {
	public static int getOpcion(Scanner scanner, String tipo) {
		while (true) {
			System.out.println(
					"\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	     " + tipo + " - A�ADIR \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
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
					detallecompra.control.A�adir.anadir(scanner, conexion);
					break;
				case 2:
					compra.control.A�adir.anadir(scanner, conexion);
					break;
				case 3:
					try {
						facturaC.control.A�adir.anadir(scanner, conexion);
					} catch (FacturaRepetida e) {
						System.out.println(e.getMessage());
					}
					break;
				case 0:
					System.out.println("Cerrando Sistema ...    ");
					salir = false;
					break;
				default:
					System.out.println("Opci�n inv�lida, Intente de nuevo");
				}
			}
		}else {
			while (salir) {

				switch (getOpcion(scanner, tipo)) {
				case 1:
					detalleventa.control.A�adir.anadir(scanner, conexion);
					break;
				case 2:
					venta.control.A�adir.anadir(scanner, conexion);
					break;
				case 3:
					try {
						factura.control.A�adir.anadir(scanner, conexion);
					} catch (FacturaRepetida e) {
						System.out.println(e.getMessage());
					}
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
}
