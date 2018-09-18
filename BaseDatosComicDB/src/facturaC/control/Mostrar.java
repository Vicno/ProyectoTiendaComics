package facturaC.control;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try  {
			System.out.println("Facturas Compras: "
			+ "\n  \tNúmero de Compra\t || \tNIT\t || \tNombre\t || \tEstado");
			conexion.consulta("SELECT * FROM FACTURAC");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("NUMEROcompra"));
				System.out.print("\t");
				System.out.print
				(resultSet.getString("NIT"));
				System.out.print("\t");
				System.out.println(resultSet.getString("NOMBRE"));
				System.out.print("\t");
				System.out.println(resultSet.getString("estadoValido"));
				
				
			}
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			System.out.println("ya existe una factura de esa compra");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
