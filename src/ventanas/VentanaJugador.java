package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;

public class VentanaJugador extends JFrame {

	private JPanel contentPane;
	private JTextField DatosJugador;
	private JTextField PuntosJugador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJugador frame = new VentanaJugador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaJugador() {
		setTitle("JUGADOR");
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre - Apellidos:");
		lblNombre.setBounds(106, 164, 130, 16);
		contentPane.add(lblNombre);
		
		DatosJugador = new JTextField();
		DatosJugador.setBounds(106, 192, 130, 26);
		contentPane.add(DatosJugador);
		DatosJugador.setColumns(10);
		
		JLabel lblPosicion = new JLabel("Posicion:");
		lblPosicion.setBounds(106, 230, 61, 16);
		contentPane.add(lblPosicion);
		
		JCheckBox chckbxBase = new JCheckBox("Base");
		chckbxBase.setBackground(new Color(238, 238, 238));
		chckbxBase.setBounds(108, 258, 68, 23);
		contentPane.add(chckbxBase);
		
		JCheckBox chckbxEscolta = new JCheckBox("Escolta");
		chckbxEscolta.setBounds(108, 279, 77, 23);
		contentPane.add(chckbxEscolta);
		
		JCheckBox chckbxPvot = new JCheckBox("Pivot:");
		chckbxPvot.setBounds(188, 258, 128, 23);
		contentPane.add(chckbxPvot);
		
		JCheckBox chckbxAlaPivot = new JCheckBox("Ala Pivot");
		chckbxAlaPivot.setBounds(188, 279, 128, 23);
		contentPane.add(chckbxAlaPivot);
		
		JCheckBox chckbxAlero = new JCheckBox("Alero");
		chckbxAlero.setBounds(108, 301, 128, 23);
		contentPane.add(chckbxAlero);
		
		JLabel FotoJugador = new JLabel("Photo");
		FotoJugador.setBackground(Color.LIGHT_GRAY);
		FotoJugador.setBounds(110, 64, 104, 87);
		contentPane.add(FotoJugador);
		
		JLabel lblPuntos = new JLabel("Puntos:");
		lblPuntos.setBounds(106, 336, 61, 16);
		contentPane.add(lblPuntos);
		
		PuntosJugador = new JTextField();
		PuntosJugador.setBounds(106, 360, 130, 26);
		contentPane.add(PuntosJugador);
		PuntosJugador.setColumns(10);
	}
}
