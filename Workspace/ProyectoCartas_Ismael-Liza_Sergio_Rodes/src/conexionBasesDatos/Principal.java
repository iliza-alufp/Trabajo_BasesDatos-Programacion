package conexionBasesDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ventanaAplicacion.Ventana;

public class Principal {
	
    // CONSERVADO: Tu método original para comprobar los datos por consola al arrancar
    public static void mostrarPersonajes(Connection conexion) {
        String query = "SELECT * FROM personajes";
		
        try {
            Statement comando = conexion.createStatement();
            ResultSet resultado = comando.executeQuery(query);
			
            System.out.println("=== LOG DE CONTROL: CARTAS EN LA BASE DE DATOS ===");
            while (resultado.next()) {
                // Modificado ligeramente para que use los nombres reales de tus columnas
                System.out.println("ID Carta: " + resultado.getInt("id_personaje")
                        + "\nNombre: " + resultado.getString("nombre")
                        + "\nVida: " + resultado.getInt("vida")
                        + "\nAtaque: " + resultado.getInt("ataque")
                        + "\nCoste: " + resultado.getInt("coste"));

                System.out.println("------------------------------------------");
            }
		
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
		
        // 1. CONSERVADO: Tu lógica de conexión inicial por consola para depuración
        MySQLConnection db = new MySQLConnection();
        Connection conexion = db.mySQLConnect();

        // Mostramos el estado actual en la consola de comandos
        mostrarPersonajes(conexion);
		
        System.out.println("Control de consola finalizado -> Levantando Interfaz Gráfica.");
		
        try {
            if (conexion != null) {
                conexion.close(); // Cerramos esta conexión temporal de consola de forma segura
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // 2. NUEVO/TEMARIO: Lanzamiento controlado del entorno visual Swing (Diapositiva 7)
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Abre tu ventana oficial a mano con layouts y componentes
                new Ventana();
            }
        });
    }
}
