package ventanaAplicacion;

import conexionBasesDatos.PersonajeDAO;
import modelo.Personaje;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ventana extends JFrame {

    // Componentes del formulario de MarioCartas
    private JTextField campoNombre, campoVida, campoAtaque, campoCoste, campoBuscar;
    private JButton btnGuardar, btnBuscar, btnEliminar, btnVerObjeto;
    private JTable tablaPersonajes;
    private DefaultTableModel modeloTabla;
    private JLabel lblImagenCarta;

    // Conector con la capa de datos (Modelo-Vista-Controlador)
    private PersonajeDAO personajeDAO;

    public Ventana() {
        // Opción 2 del temario: Configuración del marco por super()
        super("MarioCartas - Panel de Control Oficial");
        this.setSize(850, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        personajeDAO = new PersonajeDAO();

        // Creamos el lienzo principal (JPanel)
        JPanel jp = new JPanel(new BorderLayout(10, 10));
        this.setContentPane(jp); // Asociamos el lienzo al marco

        // Inicializamos las tres regiones del BorderLayout
        initZonaNorteFormulario(jp);
        initZonaCentroTablaYVisor(jp);
        initZonaSurAcciones(jp);

        // Cargamos los datos iniciales de la BBDD en el JTable
        recargarTabla();

        this.setVisible(true);
    }

    private void initZonaNorteFormulario(JPanel lienzo) {
        // Formulario ordenado en rejilla: 2 filas x 5 columnas
        JPanel panelForm = new JPanel(new GridLayout(2, 5, 5, 5));
        panelForm.setBorder(BorderFactory.createTitledBorder("Añadir Nueva Carta"));

        campoNombre = new JTextField();
        campoVida = new JTextField();
        campoAtaque = new JTextField();
        campoCoste = new JTextField();
        btnGuardar = new JButton("GUARDAR");

        panelForm.add(new JLabel("Nombre del Personaje:"));
        panelForm.add(new JLabel("Puntos de Vida:"));
        panelForm.add(new JLabel("Puntos de Ataque:"));
        panelForm.add(new JLabel("Coste de Energía:"));
        panelForm.add(new JLabel("")); // Espacio libre

        panelForm.add(campoNombre);
        panelForm.add(campoVida);
        panelForm.add(campoAtaque);
        panelForm.add(campoCoste);
        panelForm.add(btnGuardar);

        // Registro del evento mediante Clase Anónima (Página 26 del PDF)
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionGuardar();
            }
        });

        lienzo.add(panelForm, BorderLayout.NORTH);
    }

    private void initZonaCentroTablaYVisor(JPanel lienzo) {
        JPanel panelCentral = new JPanel(new BorderLayout(5, 5));

        // Estructura de la Tabla de datos
        String[] columnas = {"Nombre", "Vida", "Ataque", "Coste"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tablaPersonajes = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaPersonajes);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Inventario de Cartas"));
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        // Visor de imágenes derecho (Página 29 del PDF)
        JPanel panelVisor = new JPanel(new BorderLayout());
        panelVisor.setBorder(BorderFactory.createTitledBorder("Carta Seleccionada"));
        panelVisor.setPreferredSize(new Dimension(220, 0));

        lblImagenCarta = new JLabel("Seleccione una fila", SwingConstants.CENTER);
        lblImagenCarta.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelVisor.add(lblImagenCarta, BorderLayout.CENTER);
        panelCentral.add(panelVisor, BorderLayout.EAST);

        // Escuchador de selección para refrescar la foto al pulsar una fila
        tablaPersonajes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = tablaPersonajes.getSelectedRow();
                if (fila != -1) {
                    String nombre = modeloTabla.getValueAt(fila, 0).toString();
                    actualizarImagen(nombre);
                }
            }
        });

        lienzo.add(panelCentral, BorderLayout.CENTER);
    }

    private void initZonaSurAcciones(JPanel lienzo) {
        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        panelAcciones.setBorder(BorderFactory.createEtchedBorder());

        campoBuscar = new JTextField(12);
        btnBuscar = new JButton("BUSCAR");
        btnEliminar = new JButton("ELIMINAR CARTA");
        btnEliminar.setBackground(new Color(220, 53, 69));
        btnEliminar.setForeground(Color.WHITE);
        
        btnVerObjeto = new JButton("VER OBJETO EQUIPADO 🎒");
        btnVerObjeto.setBackground(new Color(40, 167, 69));
        btnVerObjeto.setForeground(Color.WHITE);

        panelAcciones.add(new JLabel("Nombre a Buscar:"));
        panelAcciones.add(campoBuscar);
        panelAcciones.add(btnBuscar);
        panelAcciones.add(Box.createHorizontalStrut(30));
        panelAcciones.add(btnEliminar);
        panelAcciones.add(btnVerObjeto);

        // Escuchadores anónimos para las acciones inferiores
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBuscar();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionEliminar();
            }
        });

        btnVerObjeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = tablaPersonajes.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(Ventana.this, "Seleccione un personaje en la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String nombreCarta = modeloTabla.getValueAt(fila, 0).toString();
                // Abre la ventana secundaria (Páginas 31-33)
                new VentanaSecundaria(Ventana.this, nombreCarta);
            }
        });

        lienzo.add(panelAcciones, BorderLayout.SOUTH);
    }

    private void recargarTabla() {
        modeloTabla.setRowCount(0);
        List<Personaje> lista = personajeDAO.buscarPorNombre("");
        for (Personaje p : lista) {
            modeloTabla.addRow(new Object[]{p.getNombre(), p.getVida(), p.getAtaque(), p.getCoste()});
        }
    }

    private void actualizarImagen(String nombreCarta) {
        try {
            // Carga obligatoria por recursos internos mediante getClass().getResource() (Pág. 29)
            lblImagenCarta.setIcon(new ImageIcon(getClass().getResource("/img/" + nombreCarta + ".jpg")));
            lblImagenCarta.setText("");
        } catch (Exception e) {
            lblImagenCarta.setIcon(null);
            lblImagenCarta.setText("Sin imagen (" + nombreCarta + ".jpg)");
        }
    }

    private void accionGuardar() {
        try {
            if (campoNombre.getText().trim().isEmpty() || campoVida.getText().isEmpty() || 
                campoAtaque.getText().isEmpty() || campoCoste.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos del formulario.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String nombre = campoNombre.getText().trim();
            int vida = Integer.parseInt(campoVida.getText().trim());
            int ataque = Integer.parseInt(campoAtaque.getText().trim());
            int coste = Integer.parseInt(campoCoste.getText().trim());

            // Instancia del modelo asignándole por defecto la clase Humano (ID 1)
            Personaje nuevo = new Personaje(0, nombre, vida, ataque, coste, 1, null);

            if (personajeDAO.insertar(nuevo)) {
                JOptionPane.showMessageDialog(this, "¡Personaje guardado!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                recargarTabla();
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(this, "Error de base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Los valores numéricos introducidos no son correctos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void accionBuscar() {
        String criterio = campoBuscar.getText().trim();
        modeloTabla.setRowCount(0);
        List<Personaje> lista = personajeDAO.buscarPorNombre(criterio);
        for (Personaje p : lista) {
            modeloTabla.addRow(new Object[]{p.getNombre(), p.getVida(), p.getAtaque(), p.getCoste()});
        }
    }

    private void accionEliminar() {
        int fila = tablaPersonajes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila en la tabla.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombreCarta = modeloTabla.getValueAt(fila, 0).toString();
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Borrar permanentemente a " + nombreCarta + "?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            if (personajeDAO.eliminar(nombreCarta)) {
                JOptionPane.showMessageDialog(this, "Registro eliminado.");
                recargarTabla();
                lblImagenCarta.setIcon(null);
                lblImagenCarta.setText("Seleccione una fila");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el personaje.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void limpiarFormulario() {
        campoNombre.setText("");
        campoVida.setText("");
        campoAtaque.setText("");
        campoCoste.setText("");
    }
}
