package factura.view;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import Excepciones.FacturaRepetida;
import entity.Conexion;
import view.InputTypes;

public class Menu {
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	  Factura  Venta  \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					" \n 1. Añadir  \n 2. Mostrar \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
				
				try {
					factura.control.Añadir.anadir(scanner, conexion);
				} catch (FacturaRepetida e) {
					System.out.println("EL codigo de venta ingresado ya tiene una factura a su nombre");
				}
				
				break;
			case 2:
				factura.control.Mostrar.mostrar(conexion);
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
