package consultas.view;

import java.util.Scanner;

import entity.Conexion;
import view.InputTypes;

public class MenuGanancias {
	public static int getOpcion(Scanner scanner) {
		while (true) {
			System.out.println("\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n	    CONSULTAS - GANANCIAS  \n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			System.out.println(
					" \n 1. Por Comic  \n 2. Por Dibujante \n 3. Por Guionista \n 4. Por Personaje   \n 0. Salir\n\n ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
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
				consultas.control.MostrarGanancias.gananciaComic(conexion, scanner);
				break;
			case 2:
				consultas.control.MostrarGanancias.gananciaDibujante(conexion, scanner);				
				break;
			case 3:
				consultas.control.MostrarGanancias.gananciaEscritor(conexion, scanner);			
				break;
			case 4:
				consultas.control.MostrarGanancias.gananciaPersonaje(conexion, scanner);			
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