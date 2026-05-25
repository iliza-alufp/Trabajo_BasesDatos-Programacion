package ventanaAplicacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import conexionBasesDatos.PersonajeDAO;
import modelo.Personaje;

public class Ventana extends JFrame {

    // Componentes de la interfaz definidos como propiedades (Opción 2, Pág. 7) [cite: 67, 68]
    private JTextField campoNombre, campoVida, campoAtaque, campoCoste, campoBuscar;
    private JTable tablaPersonajes;
    private DefaultTableModel modeloTabla;
    private JLabel labelImagen; // Nombre alineado con la página 29 del PDF [cite: 430]
    private PersonajeDAO personajeDAO;

    public Ventana() {
        // Inicialización oficial usando el constructor super (Pág. 7) [cite: 70]
        super("MarioCartas - App Oficial");
        this.setSize(850, 500);
        this.setLocationRelativeTo(null); // Centramos la ventana en pantalla (Pág. 7) [cite: 73]
        
        // Control de cierre oficial exigido en las páginas 19 y 34 del temario 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        personajeDAO = new PersonajeDAO();

        // Creamos el panel intermedio o lienzo principal (Pág. 3) [cite: 27]
        JPanel jpPrincipal = new JPanel(new BorderLayout(10, 10)); // Usamos BorderLayout (Pág. 11) [cite: 162]
        this.setContentPane(jpPrincipal); // Asociamos el lienzo al marco (Pág. 5 y 7) [cite: 42, 72]

        // --- ZONA NORTE: Formulario de inserción (FlowLayout, Pág. 12) --- [cite: 174]
        JPanel jpFormulario = new JPanel(new FlowLayout());
        jpFormulario.setBorder(BorderFactory.createTitledBorder("Añadir Nueva Carta"));

        jpFormulario.add(new JLabel("Nombre:"));
        campoNombre = new JTextField(8);
        jpFormulario.add(campoNombre);

        jpFormulario.add(new JLabel("Vida:"));
        campoVida = new JTextField(3);
        jpFormulario.add(campoVida);

        jpFormulario.add(new JLabel("Ataque:"));
        campoAtaque = new JTextField(3);
        jpFormulario.add(campoAtaque);

        jpFormulario.add(new JLabel("Coste:"));
        campoCoste = new JTextField(3);
        jpFormulario.add(campoCoste);
        
        JButton btnGuardar = new JButton("GUARDAR"); 
        btnGuardar.setName("btn_guardar"); 
        btnGuardar.addActionListener(new Escuchador(this)); // Añadimos el escuchador externo (Pág. 17) [cite: 264]
        jpFormulario.add(btnGuardar);
        
        jpPrincipal.add(jpFormulario, BorderLayout.NORTH); // Posicionamiento Norte (Pág. 12) [cite: 172, 173]

        // --- ZONA CENTRO: Tabla de visualización de datos ---
        String[] columnas = {"Nombre", "Vida", "Ataque", "Coste"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        
        tablaPersonajes = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaPersonajes); // Contenedor intermedio (Pág. 3) [cite: 27]
        jpPrincipal.add(scrollTabla, BorderLayout.CENTER); // Posicionamiento Centro (Pág. 12) [cite: 172, 176]

        // --- ZONA ESTE: Visor lateral de imágenes (Pág. 29) --- 
        labelImagen = new JLabel("Selecciona fila", SwingConstants.CENTER);
        labelImagen.setPreferredSize(new Dimension(200, 0));
        labelImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        jpPrincipal.add(labelImagen, BorderLayout.EAST); // Posicionamiento Este (Pág. 12) [cite: 172, 177]

        // --- ZONA SUR: Panel inferior de acciones (FlowLayout, Pág. 12) --- [cite: 174]
        JPanel jpAcciones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jpAcciones.setBorder(BorderFactory.createEtchedBorder());
        
        campoBuscar = new JTextField(10); 
        jpAcciones.add(new JLabel("Buscar:")); 
        jpAcciones.add(campoBuscar);
        
        JButton btnBuscar = new JButton("BUSCAR"); 
        btnBuscar.setName("btn_buscar"); 
        btnBuscar.addActionListener(new Escuchador(this)); 
        jpAcciones.add(btnBuscar);
        
        JButton btnEliminar = new JButton("ELIMINAR"); 
        btnEliminar.setName("btn_eliminar"); 
        btnEliminar.addActionListener(new Escuchador(this)); 
        jpAcciones.add(btnEliminar);
        
        JButton btnUsuarios = new JButton("USUARIOS 👥"); 
        btnUsuarios.setName("btn_usuarios"); 
        btnUsuarios.addActionListener(new Escuchador(this)); 
        jpAcciones.add(btnUsuarios);
        
        jpPrincipal.add(jpAcciones, BorderLayout.SOUTH); // Posicionamiento Sur (Pág. 12) [cite: 172, 179]

        // --- MANEJO DE EVENTOS DE SELECCIÓN (Pág. 15) --- [cite: 228, 235]
        tablaPersonajes.getSelectionModel().addListSelectionListener(e -> {
            // Evitamos la doble ejecución del evento al hacer click (ListSelectionEvent) [cite: 235, 236]
            if (!e.getValueIsAdjusting() && tablaPersonajes.getSelectedRow() != -1) {
                String nombre = modeloTabla.getValueAt(tablaPersonajes.getSelectedRow(), 0).toString();
                cargarImagen(nombre);
            }
        });

        // Carga de inicialización
        actualizarTabla("");
        this.setVisible(true); // Visibilidad al final del constructor (Pág. 5 y 7) [cite: 49, 74]
    }

    /**
     * Proyección de imágenes de forma relativa utilizando la sintaxis de la Página 29 
     */
    private void cargarImagen(String nombre) {
        // Buscamos el recurso dentro del árbol del proyecto (Pág. 29) 
        java.net.URL ruta = getClass().getResource("/img/" + nombre + ".png");
        
        if (ruta == null) {
            ruta = getClass().getResource("/img/Cartacaratula.png");
        }
        
        if (ruta != null) {
            // Escalamos el gráfico y lo asociamos mediante setIcon() tal y como indica el PDF 
            Image img = new ImageIcon(ruta).getImage().getScaledInstance(160, 240, Image.SCALE_SMOOTH);
            labelImagen.setIcon(new ImageIcon(img));
            labelImagen.setText("");
        } else {
            labelImagen.setIcon(null);
            labelImagen.setText("Sin foto: " + nombre);
        }
    }

    public void actualizarTabla(String filtro) {
        modeloTabla.setRowCount(0);
        for (Personaje p : personajeDAO.listar(filtro)) {
            Object[] fila = new Object[]{p.getNombre(), p.getVida(), p.getAtaque(), p.getCoste()};
            modeloTabla.addRow(fila);
        }
    }

    // Getters académicos para el Controlador (Arquitectura MVC, Pág. 35) [cite: 496, 497]
    public JTextField getCampoNombre() { return campoNombre; }
    public JTextField getCampoVida() { return campoVida; }
    public JTextField getCampoAtaque() { return campoAtaque; }
    public JTextField getCampoCoste() { return campoCoste; }
    public JTextField getCampoBuscar() { return campoBuscar; }
    public JTable getTablaPersonajes() { return tablaPersonajes; }
}