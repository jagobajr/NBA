package NBA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.Color;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		setTitle("LOG IN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 405);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBackground(UIManager.getColor("PopupMenu.selectionBackground"));
		btnLogIn.setBounds(6, 207, 83, 29);
		contentPane.add(btnLogIn);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(6, 43, 61, 16);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBackground(UIManager.getColor("PopupMenu.selectionBackground"));
		textField.setBounds(6, 72, 300, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(6, 119, 105, 16);
		contentPane.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("PopupMenu.selectionBackground"));
		textField_1.setBounds(6, 150, 300, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAqui = new JButton("Aqui");
		btnAqui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistro nuevaVentana = new VentanaRegistro();
				nuevaVentana.setVisible(true);
				VentanaLogin.this.dispose();
			}
				
		});
		btnAqui.setBackground(Color.WHITE);
		btnAqui.setBounds(220, 278, 72, 29);
		contentPane.add(btnAqui);
		
		JLabel lblNoTienesUna = new JLabel("No tienes una cuenta? Registrate");
		lblNoTienesUna.setBounds(15, 282, 207, 20);
		contentPane.add(lblNoTienesUna);
	}
}
