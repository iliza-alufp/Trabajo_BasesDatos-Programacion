package ventanaAplicacion;

import javax.swing.*;
import java.awt.*;

public class VentanaSecundaria extends JDialog {

    public VentanaSecundaria(JFrame ventanaPrincipal, String nombrePersonaje) {
        // Ventana modal dependiente del marco padre principal (Diapositiva 31)
        super(ventanaPrincipal, "Detalles de Soporte - Objeto", true);
        
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout(10, 10));

        String textoInformativo = "<html><body style='text-align: center;'>"
                + "<h3>Módulo de Equipamiento</h3>"
                + "El personaje seleccionado es: <b>" + nombrePersonaje + "</b><br><br>"
                + "Actualmente se encuentra conectado a la tabla <i>objetos</i> "
                + "manteniendo la integridad referencial del juego."
                + "</body></html>";

        JLabel label = new JLabel(textoInformativo, SwingConstants.CENTER);
        jp.add(label, BorderLayout.CENTER);

        JButton btnCerrar = new JButton("Volver");
        btnCerrar.addActionListener(e -> dispose()); // Destruye el diálogo (Diapositiva 35)
        
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(btnCerrar);
        jp.add(panelBoton, BorderLayout.SOUTH);

        this.setContentPane(jp);
        this.setSize(420, 220);
        this.setLocationRelativeTo(ventanaPrincipal);
        this.setVisible(true);
    }
}
