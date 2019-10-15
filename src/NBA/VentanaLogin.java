package NBA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBackground(UIManager.getColor("PopupMenu.selectionBackground"));
		btnLogIn.setBounds(31, 195, 83, 29);
		contentPane.add(btnLogIn);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(31, 43, 61, 16);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBackground(UIManager.getColor("PopupMenu.selectionBackground"));
		textField.setBounds(31, 72, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(31, 110, 105, 16);
		contentPane.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("PopupMenu.selectionBackground"));
		textField_1.setBounds(31, 138, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(287, 77, 61, 16);
		contentPane.add(label);
	}
}
