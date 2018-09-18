package consultas.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;

public class MostrarGanancias {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion, String consulta, String c1, String c2, String c3) {
		try {
			System.out.println("  \t"+c1+"\t ||  \t"+c2+"\t || \t"+c3+"\t ||");
			conexion.consulta(consulta);
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString(c1));
				System.out.print("\t");
				System.out.print(resultSet.getString(c2));
				System.out.print("\t");
				System.out.println(resultSet.getString(c3));
				

			}
		} catch (SQLException e) {
			System.out.println("");
		}
	}

	public static void gananciaComic(Conexion conexion, Scanner scanner) {
		String consulta = "SELECT c.codigoComic,c.Titulo, SUM(d1.cantidad*(c.precio-d.precioCompraUnidad))AS Ganancia" + 
				"  FROM comic c" + 
				"  INNER JOIN detallecompra d ON c.codigoComic = d.codigocomic" + 
				"  INNER JOIN detalleventa d1 ON c.codigoComic = d1.codigoComic" + 
				"  GROUP BY c.codigoComic";
		mostrar(conexion, consulta, "codigocomic" , "titulo" , "ganancia");
	}

	public static void gananciaPersonaje(Conexion conexion, Scanner scanner) {
		String consulta = "SELECT p.codigoPersonaje,p.nombrePersonaje, SUM(d1.cantidad*(c1.precio-d.precioCompraUnidad))AS Ganancia" + 
				"  FROM personajes p" + 
				"  INNER JOIN comicpersonajes c ON p.codigoPersonaje = c.códigoPersonaje" + 
				"  INNER JOIN comic c1 ON c.códigoComic = c1.codigoComic" + 
				"  INNER JOIN detallecompra d ON c1.codigoComic = d.codigocomic" + 
				"  INNER JOIN detalleventa d1 ON c1.codigoComic = d1.codigoComic" + 
				"  GROUP BY p.codigoPersonaje";
		mostrar(conexion, consulta, "codigopersonaje" , "nombrepersonaje" , "Ganancia");
	}

	public static void gananciaEscritor(Conexion conexion, Scanner scanner) {
		String consulta = "SELECT  g.codigoGuionista,g.nombreGuionista,SUM(d.cantidad*(c.precio-d1.precioCompraUnidad))AS Ganancia" + 
				"  FROM guionista g" + 
				"  INNER JOIN guionistacomic g1 ON g.codigoGuionista = g1.codigoGuionista" + 
				"  INNER JOIN comic c ON g1.codigoComic = c.codigoComic" + 
				"  INNER JOIN detalleventa d ON c.codigoComic = d.codigoComic" + 
				"  INNER JOIN detallecompra d1 ON c.codigoComic = d1.codigocomic" + 
				"  GROUP BY g.codigoGuionista";
		mostrar(conexion, consulta, "codigoguionista" , "nombreguionista" , "Ganancia");
	}

	public static void gananciaDibujante(Conexion conexion, Scanner scanner) {
		String consulta = "SELECT d.codigodibujante,d.nombredibujante, SUM(d2.cantidad*(c.precio-d3.precioCompraUnidad))AS Ganancia" + 
				"  FROM dibujante d" + 
				"  INNER JOIN dibujantecomic d1 ON d.codigodibujante = d1.codigoDibujante" + 
				"  INNER JOIN comic c ON d1.codigoComic = c.codigoComic" + 
				"  INNER JOIN detalleventa d2 ON c.codigoComic = d2.codigoComic" + 
				"  INNER JOIN detallecompra d3 ON c.codigoComic = d3.codigocomic" + 
				"  GROUP BY d.codigodibujante";
		mostrar(conexion, consulta, "codigodibujante" , "nombredibujante" , "Ganancia");
	}

	/*public static void gananciaEspecial(Conexion conexion, Scanner scanner) {
		String consulta = "SELECT t.codigoEspecial,t.Descripcion, SUM(d1.cantidad*(c1.precio-d.precioCompraUnidad)) AS Ganancia" + 
				"  FROM tipoespecial t" + 
				"  INNER JOIN comicespecial c ON t.codigoEspecial = c.codigoEspecial" + 
				"  INNER JOIN comic c1 ON c.codigocomic = c1.codigoComic" + 
				"  INNER JOIN detallecompra d ON c1.codigoComic = d.codigocomic" + 
				"  INNER JOIN detalleventa d1 ON c1.codigoComic = d1.codigoComic" + 
				"  GROUP BY t.codigoEspecial"
				;
		mostrar(conexion, consulta, "codigoespecial", "descripcion", "Ganancia");
	}*/

}
