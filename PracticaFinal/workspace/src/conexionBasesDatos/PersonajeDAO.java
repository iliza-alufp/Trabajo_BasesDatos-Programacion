package conexionBasesDatos;

// Los import para poder utilizar ciertas funciones
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Personaje;


public class PersonajeDAO {
    private MySQLConnection db = new MySQLConnection();

    public boolean insertar(Personaje p) {
        String sql = "{call crear_carta(?, ?, ?, ?, ?)}";
        try (Connection con = db.mySQLConnect(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, p.getNombre());
            cs.setInt(2, p.getVida());
            cs.setInt(3, p.getAtaque());
            cs.setInt(4, p.getCoste());
            cs.setInt(5, p.getIdClase());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
        	return false;
        }
    }

    public List<Personaje> listar(String filtro) {
        List<Personaje> lista = new ArrayList<>();
        String sql = "{call buscar_carta(?)}";
        try (Connection con = db.mySQLConnect(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, filtro.isEmpty() ? "%" : filtro);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                lista.add(new Personaje(0, rs.getString("nombre"), rs.getInt("vida"), rs.getInt("ataque"), rs.getInt("coste"), 1));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return lista;
    }

    public boolean eliminar(String nombre) {
        String sql = "{call eliminar_carta(?)}";
        try (Connection con = db.mySQLConnect(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, nombre);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
        	return false;
        }
    }

    public boolean crearUsuario(String u, String p) {
        String sql = "{call crear_usuario(?, ?)}";
        try (Connection con = db.mySQLConnect(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, u); cs.setString(2, p);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
        	return false;
        }
    }

 // USUARIOS: Modifica el nombre validando primero las credenciales actuales
    public boolean modificarUsuario(String nombreActual, String contrasenya, String nuevoNombre) {
        String sql = "{call modificar_usuario(?, ?, ?)}";
        try (Connection con = db.mySQLConnect(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, nombreActual);
            cs.setString(2, contrasenya);
            cs.setString(3, nuevoNombre);
            
            // Devuelve true si el procedimiento llegó a modificar la fila en MySQL
            return cs.executeUpdate() > 0;
        } catch (SQLException e) { 
            e.printStackTrace();
            return false; 
        }
    }
}