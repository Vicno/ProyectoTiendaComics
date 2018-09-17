package consultas.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Conexion;

public class MostrarCompras {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion, String consulta, String c1, String c2, String c3, String c4, String c5) {
		try {
			conexion.consulta(consulta);
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString(c1));
				System.out.print("\t");
				System.out.print(resultSet.getString(c2));
				System.out.print("\t");
				System.out.print(resultSet.getString(c3));
				System.out.print("\t");
				System.out.print(resultSet.getString(c4));
				System.out.print("\t");
				System.out.print(resultSet.getString(c5));

			}
		} catch (SQLException e) {
			System.out.println("");
		}
	}

	public static void comprasComic(Conexion conexion, Scanner scanner) {
		String consulta = "SELECT c.codigoComic,c.Titulo, d.cantidad , d.precioCompraUnidad ,SUM(d.precioCompraUnidad*d.cantidad) AS Total  " + 
				"					  FROM comic c" + 
				"  INNER JOIN detallecompra d ON c.codigoComic = d.codigocomic" + 
				"  INNER JOIN compra c1 ON d.numerocompra = c1.numerocompra" + 
				"  GROUP BY c.codigoComic";
		mostrar(conexion, consulta, "codigocomic" , "titulo" , "cantidad","preciocompraunidad", "Total");
	}

	public static void comprasPersonaje(Conexion conexion, Scanner scanner) {
		String consulta = "SELECT p.codigoPersonaje,p.nombrePersonaje,SUM(c1.precio*d.cantidad) AS Total " + 
				"					FROM personajes p" + 
				"				 INNER JOIN comicpersonajes c ON p.codigoPersonaje = c.códigoPersonaje" + 
				"				 INNER JOIN comic c1 ON c.códigoComic = c1.codigoComic" + 
				"				 INNER JOIN detallecompra d ON c1.codigoComic = d.codigoComic" + 
				"				 INNER JOIN compra c2 ON d.numeroCompra = c2.numeroCompra" + 
				"				GROUP BY p.codigoPersonaje";
		mostrar(conexion, consulta, "codigopersonaje" , "nombrepersonaje" , "Total","","");
	}

	public static void comprasEscritor(Conexion conexion, Scanner scanner) {
		String consulta = "SELECT g.codigoGuionista,g.nombreGuionista, SUM(d.precioCompraUnidad*d.cantidad) AS Total" + 
				"  FROM guionista g" + 
				"  INNER JOIN guionistacomic g1 ON g.codigoGuionista = g1.codigoGuionista" + 
				"  INNER JOIN comic c ON g1.codigoComic = c.codigoComic" + 
				"  INNER JOIN detallecompra d ON c.codigoComic = d.codigocomic" + 
				"  INNER JOIN compra c1 ON d.numerocompra = c1.numerocompra" +
				"  GROUP BY g.codigoGuionista";
		mostrar(conexion, consulta, "codigoguionista" , "nombreguionista" , "Total", "","");
	}

	public static void comprasDibujante(Conexion conexion, Scanner scanner) {
		String consulta = "SELECT d.codigodibujante,d.nombredibujante, SUM(d2.precioCompraUnidad*d2.cantidad) AS Total" + 
				"  FROM dibujante d" + 
				"  INNER JOIN dibujantecomic d1 ON d.codigodibujante = d1.codigoDibujante" + 
				"  INNER JOIN comic c ON d1.codigoComic = c.codigoComic" + 
				"  INNER JOIN detallecompra d2 ON c.codigoComic = d2.codigocomic" + 
				"  INNER JOIN compra c1 ON d2.numerocompra = c1.numerocompra" + 
				"  GROUP BY d.codigodibujante";
		mostrar(conexion, consulta, "codigodibujante" , "nombredibujante" , "Total","","");
	}

	/*public static void comprasEspecial(Conexion conexion, Scanner scanner) {
		String consulta = "SELECT t.codigoEspecial,t.Descripcion, SUM(d.precioCompraUnidad*d.cantidad) AS Total" + 
				"  FROM tipoespecial t" + 
				"  INNER JOIN comicespecial c ON t.codigoEspecial = c.codigoEspecial" + 
				"  INNER JOIN comic c1 ON c.codigocomic = c1.codigoComic" + 
				"  INNER JOIN detallecompra d ON c1.codigoComic = d.codigocomic" + 
				"  INNER JOIN compra c2 ON d.numerocompra = c2.numerocompra" + 
				"  GROUP BY t.codigoEspecial"
				;
		mostrar(conexion, consulta, "codigoespecial", "descripcion", "Total", "","");
	}*/
}
