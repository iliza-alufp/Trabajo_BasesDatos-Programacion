package ventanaAplicacion;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    private JTextField campoNombre;
    private JTextField campoVida;
    private JTextField campoAtaque;
    private JTextField campoCoste;

    public Ventana() {
        // Opción 2 de tus apuntes: herencia y super()
        super("MarioCartas - Gestión de Cartas");

        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout()); // Esquema simple FlowLayout de tus apuntes
        this.setContentPane(jp);

        this.setSize(250, 300);
        this.setLocationRelativeTo(null);

        // Componentes del formulario adaptados a tu base de datos
        jp.add(new JLabel("Nombre: "));
        campoNombre = new JTextField(15);
        jp.add(campoNombre);

        jp.add(new JLabel("Vida: "));
        campoVida = new JTextField(15);
        jp.add(campoVida);

        jp.add(new JLabel("Ataque: "));
        campoAtaque = new JTextField(15);
        jp.add(campoAtaque);

        jp.add(new JLabel("Coste: "));
        campoCoste = new JTextField(15);
        jp.add(campoCoste);

        // Botón Guardar conectado con tu clase Escuchador
        JButton btnGuardar = new JButton("GUARDAR CARTA");
        btnGuardar.setName("btn_guardar");
        btnGuardar.addActionListener(new Escuchador(this));
        jp.add(btnGuardar);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Métodos Getters para que el Escuchador pueda leer los cuadros de texto
    public JTextField getCampoNombre() { return campoNombre; }
    public JTextField getCampoVida() { return campoVida; }
    public JTextField getCampoAtaque() { return campoAtaque; }
    public JTextField getCampoCoste() { return campoCoste; }
}
