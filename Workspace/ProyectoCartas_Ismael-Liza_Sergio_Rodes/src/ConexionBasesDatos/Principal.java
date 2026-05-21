package ConexionBasesDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
	
	public static void mostrarPersonajes(Connection conexion) {
		
		String query = "SELECT * FROM personajes";
		
		try {
			Statement comando = conexion.createStatement();

			ResultSet resultado = comando.executeQuery(query);
			
			/* Se imprimen los registros que estén guardados en la base de datos */
			while (resultado.next()) {
				System.out.println("id: " + resultado.getInt(1)
						+ "\nVida: " + resultado.getString(2)
						+ "\nAtaque: " + resultado.getString(3)
						+ "\nCoste: " + resultado.getString(4));

				System.out.println("------------------------------------------");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] MySQLConnection) {
		
		MySQLConnection db = new MySQLConnection();
		Connection conexion = db.mySQLConnect();

		mostrarPersonajes(conexion);
		
		System.out.println("Fin - Cerramos conexión");
		
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}

