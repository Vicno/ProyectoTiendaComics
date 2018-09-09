package factura.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import entity.Conexion;

public class Mostrar {
	private static ResultSet resultSet;

	public static void mostrar(Conexion conexion) {
		try  {
			conexion.consulta("SELECT * FROM FACTURA");
			resultSet = conexion.resultado();

			while (resultSet.next()) {
				System.out.print(resultSet.getString("NUMEROVENTA"));
				System.out.print("\t");
				System.out.print
				(resultSet.getString("ID"));
				System.out.print("\t");
				System.out.println(resultSet.getString("NOMBRE"));
				
				
				
			}
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			System.out.println("ya existe una factura de esa venta");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
