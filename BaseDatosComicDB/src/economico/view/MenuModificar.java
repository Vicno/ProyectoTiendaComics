package economico.view;

import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class MenuModificar {
	public static int getOpcion(Scanner scanner, String tipo) {
		while (true) {
			System.out.println(
					"\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	     " + tipo + " - MODIFICAR \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out
					.println("\n 1. Detalles \n 2. Factura \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
					detallecompra.control.Actualizar.actualizar(scanner, conexion);
					break;
				case 2:
					facturaC.control.Actualizar.actualizar(scanner, conexion);
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
					detalleventa.control.Actualizar.actualizar(scanner, conexion);
					break;
				case 2:
					factura.control.Actualizar.actualizar(scanner, conexion);
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
