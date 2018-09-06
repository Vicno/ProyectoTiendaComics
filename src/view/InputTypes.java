package view;

import java.util.Scanner;

public class InputTypes {
	public static int readInt(String sampleText, Scanner scanner) { // Leer solo numeros del teclado
		int numero;
		while (true) {
			System.out.print(sampleText);
			try {
				numero = scanner.nextInt();
				break;
			} catch (java.util.InputMismatchException e) {
				System.out.println(">>Por favor, ingrese solamente valores enteros.");

			} finally {
				scanner.nextLine();
			}
		}
		return numero;
	}

	public static String readString(String sampleText, Scanner scanner) { // Leer solo numeros del teclado
		String cadena;
		System.out.print(sampleText);
		cadena = scanner.nextLine();
		return cadena;
	}

	public static double readDouble(String sampleText, Scanner scanner) { // Leer solo numeros del teclado
		double numero;
		while (true) {
			System.out.print(sampleText);
			try {
				numero = scanner.nextDouble();
				break;
			} catch (java.util.InputMismatchException e) {
				System.out.println(">>Por favor, ingrese solamente valores enteros.");
			} finally {
				scanner.nextLine();
			}

		}
		return numero;
	}

}