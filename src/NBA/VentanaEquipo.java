package NBA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		setBounds(100, 100, 390, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DatosPivot = new JTextField();
		DatosPivot.setBackground(new Color(245, 245, 220));
		DatosPivot.setText("Nombre | Puntos");
		DatosPivot.setBounds(175, 103, 130, 26);
		contentPane.add(DatosPivot);
		DatosPivot.setColumns(10);
		
		DatosAla = new JTextField();
		DatosAla.setBackground(new Color(245, 245, 220));
		DatosAla.setText("Nombre | Puntos");
		DatosAla.setColumns(10);
		DatosAla.setBounds(92, 202, 130, 26);
		contentPane.add(DatosAla);
		
		DatosAlero = new JTextField();
		DatosAlero.setBackground(new Color(245, 245, 220));
		DatosAlero.setText("Nombre | Puntos");
		DatosAlero.setColumns(10);
		DatosAlero.setBounds(254, 202, 130, 26);
		contentPane.add(DatosAlero);
		
		DatosEscolta = new JTextField();
		DatosEscolta.setBackground(new Color(245, 245, 220));
		DatosEscolta.setText("Nombre | Puntos");
		DatosEscolta.setColumns(10);
		DatosEscolta.setBounds(92, 310, 130, 26);
		contentPane.add(DatosEscolta);
		
		DatosBase = new JTextField();
		DatosBase.setBackground(new Color(245, 245, 220));
		DatosBase.setText("Nombre | Puntos");
		DatosBase.setColumns(10);
		DatosBase.setBounds(254, 310, 130, 26);
		contentPane.add(DatosBase);
		
		JLabel lblPivot = new JLabel("Pivot");
		lblPivot.setBounds(218, 25, 61, 16);
		contentPane.add(lblPivot);
		
		JLabel lblBase = new JLabel("Base");
		lblBase.setBounds(293, 240, 61, 16);
		contentPane.add(lblBase);
		
		JLabel lblEscolta = new JLabel("Escolta");
		lblEscolta.setBounds(138, 240, 61, 16);
		contentPane.add(lblEscolta);
		
		JLabel lblAlaPivot = new JLabel("Ala- Pivot");
		lblAlaPivot.setBounds(127, 130, 61, 16);
		contentPane.add(lblAlaPivot);
		
		JLabel lblAlero = new JLabel("Alero");
		lblAlero.setBounds(293, 130, 61, 16);
		contentPane.add(lblAlero);
		
		JLabel FondoDeImagen = new JLabel("New label");
		FondoDeImagen.setIcon(new ImageIcon("/Users/jagoba.jr/Desktop/DEUSTO📚💎/19-20/Programacion/Imagenes para el proyecto/QUINTETO.png"));
		FondoDeImagen.setBounds(70, -16, 320, 507);
		contentPane.add(FondoDeImagen);
		
		JLabel FotoPivot = new JLabel("New label");
		FotoPivot.setBounds(205, 46, 55, 53);
		contentPane.add(FotoPivot);
		
		JLabel FotoAla = new JLabel("New label");
		FotoAla.setBounds(127, 149, 55, 53);
		contentPane.add(FotoAla);
		
		JLabel FotoAlero = new JLabel("New label");
		FotoAlero.setBounds(283, 149, 55, 53);
		contentPane.add(FotoAlero);
		
		JLabel FotoEscolta = new JLabel("New label");
		FotoEscolta.setBounds(127, 256, 55, 53);
		contentPane.add(FotoEscolta);
		
		JLabel FotoBase = new JLabel("New label");
		FotoBase.setBounds(283, 256, 55, 53);
		contentPane.add(FotoBase);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMenu nuevaVentana = new VentanaMenu();
				nuevaVentana.setVisible(true);
				VentanaEquipo.this.dispose();
			}
			
		});
		btnAtras.setBounds(15, 3, 43, 26);
		contentPane.add(btnAtras);
	}
	
}
