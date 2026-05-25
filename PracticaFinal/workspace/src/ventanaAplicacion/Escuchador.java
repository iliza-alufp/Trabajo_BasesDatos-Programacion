package ventanaAplicacion;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Personaje;
import conexionBasesDatos.PersonajeDAO;

// Definimos la clase específica que implementa ActionListener (Pág. 17) [cite: 257]
public class Escuchador implements ActionListener {

    private Ventana ventana;
    private PersonajeDAO personajeDAO;

    public Escuchador(Ventana ventana) {
        this.ventana = ventana;
        this.personajeDAO = new PersonajeDAO();
    }

    // Implementación obligatoria del método de la interfaz (Pág. 16 y 17) [cite: 253, 257]
    @Override
    public void actionPerformed(ActionEvent e) {
        // Uso de getSource() para identificar el objeto origen (Pág. 20 y 21) [cite: 297, 306]
        JButton botonPulsado = (JButton) e.getSource();
        String nombreBoton = botonPulsado.getName().toLowerCase();

        // --- ACCIÓN: GUARDAR CARTA ---
        if (nombreBoton.equals("btn_guardar")) {
            String nombre = ventana.getCampoNombre().getText().trim();
            String vidaStr = ventana.getCampoVida().getText().trim();
            String ataqueStr = ventana.getCampoAtaque().getText().trim();
            String costeStr = ventana.getCampoCoste().getText().trim();
            
            if (nombre.isEmpty() || vidaStr.isEmpty() || ataqueStr.isEmpty() || costeStr.isEmpty()) {
                // Cuadro de aviso (Pág. 26) [cite: 374, 375]
                JOptionPane.showMessageDialog(ventana, "Debe completar todos los datos.", "Atención", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int vida = Integer.parseInt(vidaStr);
                int ataque = Integer.parseInt(ataqueStr);
                int coste = Integer.parseInt(costeStr);

                Personaje nuevoPersonaje = new Personaje(0, nombre, vida, ataque, coste, 1);
                
                if (personajeDAO.insertar(nuevoPersonaje)) {
                    JOptionPane.showMessageDialog(ventana, "¡Carta guardada correctamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    ventana.getCampoNombre().setText("");
                    ventana.getCampoVida().setText("");
                    ventana.getCampoAtaque().setText("");
                    ventana.getCampoCoste().setText("");
                    ventana.actualizarTabla(""); // El modelo cambia y actualiza la vista (MVC, Pág. 38) [cite: 518, 519]
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventana, "Vida, Ataque y Coste deben ser valores numéricos.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            }

        // --- ACCIÓN: BUSCAR CARTAS ---
        } else if (nombreBoton.equals("btn_buscar")) {
            String filtro = ventana.getCampoBuscar().getText().trim();
            ventana.actualizarTabla(filtro);

        // --- ACCIÓN: ELIMINAR CARTA ---
        } else if (nombreBoton.equals("btn_eliminar")) {
            int filaSeleccionada = ventana.getTablaPersonajes().getSelectedRow();
            if (filaSeleccionada != -1) {
                String nombreCarta = ventana.getTablaPersonajes().getValueAt(filaSeleccionada, 0).toString();
                
                // Cuadro de confirmación literal siguiendo los ejemplos de la Página 27 [cite: 389]
                int confirmacion = JOptionPane.showConfirmDialog(ventana, "¿Seguro que desea eliminar a " + nombreCarta + "?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (personajeDAO.eliminar(nombreCarta)) {
                        JOptionPane.showMessageDialog(ventana, "Carta eliminada con éxito.");
                        ventana.actualizarTabla("");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(ventana, "Por favor, seleccione una fila de la tabla.", "Atención", JOptionPane.WARNING_MESSAGE);
            }

        // --- ACCIÓN: ABRIR VENTANA DE USUARIOS ---
        } else if (nombreBoton.equals("btn_usuarios")) {
            abrirVentanaUsuarios();
        }
    }

    /**
     * Creación de una Ventana Secundaria modal (JDialog) admitiendo al padre (Págs. 30, 31 y 33) [cite: 445, 446, 474]
     */
    private void abrirVentanaUsuarios() {
        // JDialog modal oficial: bloquea el marco de atrás (Pág. 30) [cite: 446]
        JDialog dialogoUsuarios = new JDialog(ventana, "Gestión del Sistema de Usuarios", true);
        dialogoUsuarios.setSize(380, 280);
        dialogoUsuarios.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 12)); // Configuración de layout [cite: 163]
        dialogoUsuarios.setLocationRelativeTo(ventana);

        // Componentes específicos para la interacción (Pág. 9) [cite: 83, 84]
        JTextField txtUsuarioNuevo = new JTextField(8);
        JTextField txtPasswordNuevo = new JTextField(8);
        JButton btnCrear = new JButton("Registrar Nuevo");

        JTextField txtUsuarioActual = new JTextField(8);
        JTextField txtPasswordActual = new JTextField(8);
        JTextField txtNuevoNombre = new JTextField(8);
        JButton btnModificar = new JButton("Cambiar Nombre 🔄");

        // Bloque 1: Alta
        JPanel jpCrear = new JPanel(new FlowLayout());
        jpCrear.setBorder(BorderFactory.createTitledBorder("Alta de Usuario"));
        jpCrear.add(new JLabel("User:")); jpCrear.add(txtUsuarioNuevo);
        jpCrear.add(new JLabel("Pass:")); jpCrear.add(txtPasswordNuevo);
        jpCrear.add(btnCrear);
        dialogoUsuarios.add(jpCrear);

        // Bloque 2: Modificación
        JPanel jpModificar = new JPanel(new FlowLayout());
        jpModificar.setBorder(BorderFactory.createTitledBorder("Modificar Nombre de Usuario"));
        jpModificar.add(new JLabel("User actual:")); jpModificar.add(txtUsuarioActual);
        jpModificar.add(new JLabel("Pass:")); jpModificar.add(txtPasswordActual);
        jpModificar.add(new JLabel("Nuevo Nombre:")); jpModificar.add(txtNuevoNombre);
        jpModificar.add(btnModificar);
        dialogoUsuarios.add(jpModificar);

        // Eventos controlados mediante clases internas anónimas abreviadas (Pág. 25) [cite: 361]
        btnCrear.addActionListener(e -> {
            String user = txtUsuarioNuevo.getText().trim();
            String pass = txtPasswordNuevo.getText().trim();
            if (!user.isEmpty() && !pass.isEmpty() && personajeDAO.crearUsuario(user, pass)) {
                JOptionPane.showMessageDialog(dialogoUsuarios, "¡Usuario Registrado!");
                txtUsuarioNuevo.setText(""); txtPasswordNuevo.setText("");
            } else {
                JOptionPane.showMessageDialog(dialogoUsuarios, "Error al procesar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnModificar.addActionListener(e -> {
            String userAct = txtUsuarioActual.getText().trim();
            String passAct = txtPasswordActual.getText().trim();
            String nuevoNom = txtNuevoNombre.getText().trim();

            if (userAct.isEmpty() || passAct.isEmpty() || nuevoNom.isEmpty()) {
                JOptionPane.showMessageDialog(dialogoUsuarios, "Por favor, complete todos los campos.", "Atención", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (personajeDAO.modificarUsuario(userAct, passAct, nuevoNom)) {
                JOptionPane.showMessageDialog(dialogoUsuarios, "¡Nombre actualizado con éxito!");
                txtUsuarioActual.setText(""); txtPasswordActual.setText(""); txtNuevoNombre.setText("");
            } else {
                JOptionPane.showMessageDialog(dialogoUsuarios, "Credenciales incorrectas o usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Hacemos visible al final tal y como muestra el ejemplo de la página 33 [cite: 485]
        dialogoUsuarios.setVisible(true);
    }
}