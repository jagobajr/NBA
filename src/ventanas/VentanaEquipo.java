package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.UsuarioJugadores;

import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Color;

public class VentanaEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField DatosPivot;
	private JTextField DatosAla;
	private JTextField DatosAlero;
	private JTextField DatosEscolta;
	private JTextField DatosBase;

	/**
	 * Launch the application..
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEquipo frame = new VentanaEquipo();
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
	public VentanaEquipo() {
		setTitle("EQUIPO");
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/jagoba.jr/Desktop/DEUSTO📚💎/19-20/Programacion/Imagenes para el proyecto/QUINTETO.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setSelectedIcon(null);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMenu nuevaVentana = new VentanaMenu();
				nuevaVentana.setVisible(true);
				VentanaEquipo.this.dispose();
			}
			
		});
		btnAtras.setBounds(6, 0, 47, 88);
		contentPane.add(btnAtras);
		
		DatosPivot = new JTextField();
		DatosPivot.setBackground(new Color(245, 245, 220));
		DatosPivot.setText("Nombre | Puntos");
		DatosPivot.setBounds(102, 87, 130, 26);
		contentPane.add(DatosPivot);
		DatosPivot.setColumns(10);
		
		DatosAla = new JTextField();
		DatosAla.setBackground(new Color(245, 245, 220));
		DatosAla.setText("Nombre | Puntos");
		DatosAla.setColumns(10);
		DatosAla.setBounds(6, 213, 130, 26);
		contentPane.add(DatosAla);
		
		DatosAlero = new JTextField();
		DatosAlero.setBackground(new Color(245, 245, 220));
		DatosAlero.setText("Nombre | Puntos");
		DatosAlero.setColumns(10);
		DatosAlero.setBounds(192, 213, 130, 26);
		contentPane.add(DatosAlero);
		
		DatosEscolta = new JTextField();
		DatosEscolta.setBackground(new Color(245, 245, 220));
		DatosEscolta.setText("Nombre | Puntos");
		DatosEscolta.setColumns(10);
		DatosEscolta.setBounds(24, 352, 130, 26);
		contentPane.add(DatosEscolta);
		
		DatosBase = new JTextField();
		DatosBase.setBackground(new Color(245, 245, 220));
		DatosBase.setText("Nombre | Puntos");
		DatosBase.setColumns(10);
		DatosBase.setBounds(192, 352, 130, 26);
		contentPane.add(DatosBase);
		
		JLabel lblPivot = new JLabel("Pivot");
		lblPivot.setBounds(202, 35, 61, 16);
		contentPane.add(lblPivot);
		
		JLabel lblBase = new JLabel("Base");
		lblBase.setBounds(171, 297, 61, 16);
		contentPane.add(lblBase);
		
		JLabel lblEscolta = new JLabel("Escolta");
		lblEscolta.setBounds(90, 297, 61, 16);
		contentPane.add(lblEscolta);
		
		JLabel lblAlaPivot = new JLabel("Ala- Pivot");
		lblAlaPivot.setBounds(90, 160, 84, 16);
		contentPane.add(lblAlaPivot);
		
		JLabel lblAlero = new JLabel("Alero");
		lblAlero.setBounds(166, 160, 61, 16);
		contentPane.add(lblAlero);
		
		JLabel FondoDeImagen = new JLabel();
		FondoDeImagen.setIcon(new ImageIcon("Imagenes/file-JOpim3qYcQ.png"));
		FondoDeImagen.setBounds(-50, 0, 395, 525);
		contentPane.add(FondoDeImagen);
	}
	
}
