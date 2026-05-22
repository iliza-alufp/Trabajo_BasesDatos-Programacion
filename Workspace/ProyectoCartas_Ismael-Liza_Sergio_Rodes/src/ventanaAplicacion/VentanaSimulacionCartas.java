package ventanaAplicacion;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class VentanaSimulacionCartas extends JDialog{

	public void ManoJugador(JPanel jp) {
		
		JLabel cartaJugador;
		cartaJugador=new JLabel();
		cartaJugador.setBounds(300,530,200,330);
		cartaJugador.setIcon(new ImageIcon(getClass().getResource("/imagenes/Cartacaratula.png")));
		jp.add(cartaJugador); 
		
		JLabel cartaJugador2;
		cartaJugador2=new JLabel();
		cartaJugador2.setBounds(600,530,200,330);
		cartaJugador2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Cartacaratula.png")));
		jp.add(cartaJugador2); 
		
		JLabel cartaJugador3;
		cartaJugador3=new JLabel();
		cartaJugador3.setBounds(900,530,200,330);
		cartaJugador3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Cartacaratula.png")));
		jp.add(cartaJugador3); 
		
	}
	
	
	public void ManoRival(JPanel jp) {
		
		JLabel cartaRival;
		cartaRival=new JLabel();
		cartaRival.setBounds(300,-100,200,330);
		cartaRival.setIcon(new ImageIcon(getClass().getResource("/imagenes/Cartacaratula.png")));
		jp.add(cartaRival); 
		
		JLabel cartaRival2;
		cartaRival2=new JLabel();
		cartaRival2.setBounds(600,-100,200,330);
		cartaRival2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Cartacaratula.png")));
		jp.add(cartaRival2); 
		
		JLabel cartaRival3;
		cartaRival3=new JLabel();
		cartaRival3.setBounds(900,-100,200,330);
		cartaRival3.setIcon(new ImageIcon(getClass().getResource("/imagenes/Cartacaratula.png")));
		jp.add(cartaRival3); 
		
	}
	
	
	
	public VentanaSimulacionCartas() {

		
		
		this.setModal(true);

		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());


		this.setContentPane(jp);
		this.setSize(1400, 800);
		this.setTitle("Ventana Resultado");
		this.setLayout(null);

				
		ManoJugador(jp);
		ManoRival(jp);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.setVisible(true);
	}
	
	
}
