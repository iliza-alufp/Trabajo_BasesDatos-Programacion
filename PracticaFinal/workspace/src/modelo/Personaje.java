package modelo;


public class Personaje {
    private int id;
    private String nombre;
    private int vida;
    private int ataque;
    private int coste;
    private int idClase;


    // Constructor vacío
    public Personaje() {

	}

    // Constructor lleno
    public Personaje(int id, String nombre, int vida, int ataque, int coste, int idClase) {
        this.id = id;
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.coste = coste;
        this.idClase = idClase;

    }

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

 

	@Override
    public String toString() {
        return "Personaje [id=" + id + ", nombre=" + nombre + ", vida="
				+ vida + ", ataque=" + ataque + ", coste=" + coste + ", idClase=" + idClase + "]";
    }


	

}
