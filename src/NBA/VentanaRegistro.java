package NBA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField datos_usuario;
	private JTextField correo;
	private JTextField contrasenya;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setTitle("REGISTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreApellidos = new JLabel("Nombre - Apellidos:\n");
		lblNombreApellidos.setEnabled(false);
		lblNombreApellidos.setBounds(81, 77, 152, 16);
		contentPane.add(lblNombreApellidos);
		
		datos_usuario = new JTextField();
		datos_usuario.setBounds(79, 105, 130, 26);
		contentPane.add(datos_usuario);
		datos_usuario.setColumns(10);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setEnabled(false);
		lblCorreoElectronico.setBounds(81, 143, 128, 16);
		contentPane.add(lblCorreoElectronico);
		
		correo = new JTextField();
		correo.setBounds(79, 171, 130, 26);
		contentPane.add(correo);
		correo.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setEnabled(false);
		lblContrasea.setBounds(81, 209, 128, 16);
		contentPane.add(lblContrasea);
		
		contrasenya = new JTextField();
		contrasenya.setBounds(79, 237, 130, 26);
		contentPane.add(contrasenya);
		contrasenya.setColumns(10);
		
		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistro.setBackground(new Color(255, 239, 213));
		btnRegistro.setBounds(81, 306, 117, 29);
		contentPane.add(btnRegistro);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/jagoba.jr/Desktop/DEUSTO📚💎/19-20/Programacion/Imagenes para el proyecto/LOGO.png"));
		lblNewLabel.setBounds(183, 237, 236, 214);
		contentPane.add(lblNewLabel);
		
		JLabel lblEdadopcional = new JLabel("Edad: (Opcional)");
		lblEdadopcional.setEnabled(false);
		lblEdadopcional.setBounds(245, 77, 117, 16);
		contentPane.add(lblEdadopcional);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(245, 105, 56, 26);
		contentPane.add(spinner);
	}
}
