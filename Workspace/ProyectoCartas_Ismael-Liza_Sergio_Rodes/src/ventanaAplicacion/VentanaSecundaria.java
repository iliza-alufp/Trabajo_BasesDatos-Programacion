package ventanaAplicacion;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VentanaSecundaria extends JDialog {

	public VentanaSecundaria(Animal a) {
		// hacemos esto para que cuando se abra esta ventana no deje hacer nada con el
		// resto de ventanas hasta que no se cierre esta
		this.setModal(true);

		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());

		JTextArea campoTexto = new JTextArea(a.toString());
		// Editable false para que no se pueda modificar el contenido de campoTexto
		campoTexto.setEditable(false);

		jp.add(campoTexto, BorderLayout.CENTER);

		this.setContentPane(jp);
		this.setSize(200, 100);
		this.setTitle("Ventana Resultado");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		
	}

}
