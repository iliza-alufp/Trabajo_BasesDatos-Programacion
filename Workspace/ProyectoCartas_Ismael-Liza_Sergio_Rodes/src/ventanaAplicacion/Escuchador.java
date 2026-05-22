package ventanaAplicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Escuchador implements ActionListener {

	private Ventana v;

	/**
	 * Constructor por defecto
	 */
	public Escuchador() {
		super();
	}

	/**
	 * Constructor que le pasa por parámetro un objeto Ventana
	 * 
	 * @param v
	 */
	public Escuchador(Ventana v) {
		super();
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton boton = (JButton) e.getSource();

		if (boton.getName().equalsIgnoreCase("btn_guardar")) {

			guardar();

		} else if (boton.getName().equalsIgnoreCase("btn_solicitar")) {
			String nombreBusquedad = JOptionPane.showInputDialog("Introduzca el nombre de animal que desea buscar: ");
			boolean encontrado = false;

			for (Animal a : Animal.getListaAnimales()) {
				if (a.getNombre().equalsIgnoreCase(nombreBusquedad)) {
					new VentanaSecundaria(a);
					encontrado = true;
				}
			}

			if (!encontrado) {
				JOptionPane.showMessageDialog(null, "NO se ha encontrado el animal con nombre " + nombreBusquedad,
						"Resultado Busqueda", JOptionPane.ERROR_MESSAGE);
			}
		} else if(boton.getName().equalsIgnoreCase("btn_simular")) {
			
			new VentanaSimulacionCartas();
			
		}

	}

	public void vaciar() {
		v.getCampoNombre().setText("");
		v.getCampoRaza().setText("");
		v.getCampoEdad().setText("");
	}

	public void guardar() {
		String nombre = v.getCampoNombre().getText();
		String raza = v.getCampoRaza().getText();

		if (nombre.trim().isEmpty() || raza.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe rellenar el campo nombre y raza", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			String edad = v.getCampoEdad().getText();
			int numEdad;

			try {

				numEdad = Integer.parseInt(edad);

				Animal a = new Animal(nombre, raza, numEdad);

				Animal.getListaAnimales().add(a);

				vaciar();

				JOptionPane.showMessageDialog(null, "Animal Añadido correctamente");

				System.out.println(Animal.getListaAnimales());

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Edad incorrecta", "Error edad", JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Edad incorrecta", "Error general", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
