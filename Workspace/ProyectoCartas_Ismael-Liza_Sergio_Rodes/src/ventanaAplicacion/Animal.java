package ventanaAplicacion;

import java.util.ArrayList;

public class Animal {

	private String nombre;
	private String raza;
	private int edad;

	private static ArrayList<Animal> listaAnimales = new ArrayList<Animal>();

	/**
	 * @param nombre
	 * @param raza
	 * @param edad
	 */
	public Animal(String nombre, String raza, int edad) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
	}

	/**
	 *
	 */
	public Animal() {
		super();
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the raza
	 */
	public String getRaza() {
		return raza;
	}

	/**
	 * @param raza the raza to set
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the listaAnimales
	 */
	public static ArrayList<Animal> getListaAnimales() {
		return listaAnimales;
	}

	/**
	 * @param listaAnimales the listaAnimales to set
	 */
	public static void setListaAnimales(ArrayList<Animal> listaAnimales) {
		Animal.listaAnimales = listaAnimales;
	}

	@Override
	public String toString() {
		return "Nombre = " + nombre + "\nRaza = " + raza + "\nEdad = " + edad + " años";
	}

}
