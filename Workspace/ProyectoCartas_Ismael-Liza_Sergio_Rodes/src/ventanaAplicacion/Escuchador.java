package ventanaAplicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Personaje;
import conexionBasesDatos.PersonajeDAO;

public class Escuchador implements ActionListener {

    private Ventana v;
    private PersonajeDAO personajeDAO;

    public Escuchador() {
        super();
        this.personajeDAO = new PersonajeDAO();
    }

    public Escuchador(Ventana v) {
        super();
        this.v = v;
        this.personajeDAO = new PersonajeDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        if (boton.getName().equalsIgnoreCase("btn_guardar")) {
            guardar();
        }
    }

    public void vaciar() {
        v.getCampoNombre().setText("");
        v.getCampoVida().setText("");
        v.getCampoAtaque().setText("");
        v.getCampoCoste().setText("");
    }

    public void guardar() {
        String nombre = v.getCampoNombre().getText().trim();
        String vidaStr = v.getCampoVida().getText().trim();
        String ataqueStr = v.getCampoAtaque().getText().trim();
        String costeStr = v.getCampoCoste().getText().trim();

        // Validación de campos vacíos (Requisito de la práctica)
        if (nombre.isEmpty() || vidaStr.isEmpty() || ataqueStr.isEmpty() || costeStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos del personaje", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Convertimos los textos en números enteros
            int vida = Integer.parseInt(vidaStr);
            int ataque = Integer.parseInt(ataqueStr);
            int coste = Integer.parseInt(costeStr);
            int idClase = 1; // Le asignamos la clase 'Humano' por defecto para empezar

            // Creamos el objeto con tus datos de MarioCartas
            Personaje p = new Personaje(0, nombre, vida, ataque, coste, idClase, null);

            // Lo mandamos a la base de datos a través de tu DAO
            if (personajeDAO.insertar(p)) {
                JOptionPane.showMessageDialog(null, "¡Carta de personaje añadida correctamente!");
                vaciar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Vida, Ataque y Coste deben ser números enteros", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}
