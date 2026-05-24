package ventanaAplicacion;

import java.net.URL;

import modelo.Personaje;
import conexionBasesDatos.PersonajeDAO;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ventana extends JFrame {

	private JTextField campoNombre;
	private JTextField campoRaza;
	private JTextField campoEdad;

	public Ventana() {

		super("Animales");

		JPanel jp = new JPanel();
		this.setContentPane(jp);

		this.setSize(230, 200);

		this.setLocationRelativeTo(null);

		JLabel txtNombre = new JLabel("Nombre: ");
		jp.add(txtNombre);

		campoNombre = new JTextField(15);
		jp.add(campoNombre);

		JLabel txtRaza = new JLabel("Raza: ");
		jp.add(txtRaza);

		campoRaza = new JTextField(15);
		jp.add(campoRaza);

		JLabel txtEdad = new JLabel("Edad: ");
		jp.add(txtEdad);

		campoEdad = new JTextField(15);
		jp.add(campoEdad);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setName("btn_guardar");
		btnGuardar.addActionListener(new Escuchador(this));
		jp.add(btnGuardar);

		// Añadir otro botón “Solicitar” que al ser pulsado muestre un cuadro de dialogo
		// (JOptionPane) solicitando un nombre de animal y busque ese animal en la lista
		// de animales insertados. Si lo encuentra, debe pintar en una ventana
		// secundaria el nombre, raza y edad de dicho animal.
		// Si no lo encuentra debe mostrar un texto indicando que no existe el animal
		// indicado.
		JButton btnSolicitar = new JButton("SOLICITAR");
		btnSolicitar.setName("btn_solicitar");
		btnSolicitar.addActionListener(new Escuchador());
		jp.add(btnSolicitar);
		
		JButton btnSimular = new JButton("SIMULAR");
		btnSimular.setName("btn_simular");
		btnSimular.addActionListener(new Escuchador());
		jp.add(btnSimular);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	/**
	 * @return the campoNombre
	 */
	public JTextField getCampoNombre() {
		return campoNombre;
	}

	/**
	 * @param campoNombre the campoNombre to set
	 */
	public void setCampoNombre(JTextField campoNombre) {
		this.campoNombre = campoNombre;
	}

	/**
	 * @return the campoRaza
	 */
	public JTextField getCampoRaza() {
		return campoRaza;
	}

	/**
	 * @param campoRaza the campoRaza to set
	 */
	public void setCampoRaza(JTextField campoRaza) {
		this.campoRaza = campoRaza;
	}

	/**
	 * @return the campoEdad
	 */
	public JTextField getCampoEdad() {
		return campoEdad;
	}

	/**
	 * @param campoEdad the campoEdad to set
	 */
	public void setCampoEdad(JTextField campoEdad) {
		this.campoEdad = campoEdad;
	}

}
