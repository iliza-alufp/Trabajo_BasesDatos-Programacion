package conexionBasesDatos;

import ventanaAplicacion.Ventana;

public class Principal {
    public static void main(String[] args) {
        // Lanzamiento seguro de la interfaz gráfica
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana(); // Abre la ventana con la tabla y el visor
            }
        }
      );
    }
}
