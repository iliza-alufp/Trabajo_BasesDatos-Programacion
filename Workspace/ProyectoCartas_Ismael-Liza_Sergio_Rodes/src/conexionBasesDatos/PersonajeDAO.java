package conexionBasesDatos;

import modelo.Personaje;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class PersonajeDAO {

    private MySQLConnection db = new MySQLConnection();

    // INSERTAR CARTA (Llamando al procedimiento crear_carta)
    public boolean insertar(Personaje p) {
        String sql = "{call crear_carta(?, ?, ?, ?, ?, ?)}";
        try (Connection con = db.mySQLConnect();
             CallableStatement cs = con.prepareCall(sql)) {
            
            cs.setString(1, p.getNombre());
            cs.setInt(2, p.getVida());
            cs.setInt(3, p.getAtaque());
            cs.setInt(4, p.getCoste());
            cs.setInt(5, p.getIdClase());
            
            if (p.getIdObjeto() == null) {
                cs.setNull(6, Types.INTEGER);
            } else {
                cs.setInt(6, p.getIdObjeto());
            }
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ELIMINAR CARTA (Llamando al procedimiento eliminar_carta)
    public boolean eliminar(String nombre) {
        String sql = "{call eliminar_carta(?)}";
        try (Connection con = db.mySQLConnect();
             CallableStatement cs = con.prepareCall(sql)) {
            
            cs.setString(1, nombre);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // CONSULTA: Buscar cartas (Llamando al procedimiento buscar_carta de tu SQL)
    public List<Personaje> buscarPorNombre(String nombreBuscar) {
        List<Personaje> lista = new ArrayList<>();
        // Unificado con el nombre exacto de tu script SQL
        String sql = "{call buscar_carta(?)}"; 
        try (Connection con = db.mySQLConnect();
             CallableStatement cs = con.prepareCall(sql)) {
            
            cs.setString(1, nombreBuscar);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Personaje p = new Personaje();
                p.setNombre(rs.getString("nombre"));
                p.setVida(rs.getInt("vida"));
                p.setAtaque(rs.getInt("ataque"));
                p.setCoste(rs.getInt("coste"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
