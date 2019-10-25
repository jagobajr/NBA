package NBA.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import NBA.VentanaMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtcontraseña;

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
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				SqlUsuarios modSql = new SqlUsuarios();
			    Usuarios mod = new Usuarios();
			        
			    String pass = new String(txtcontraseña.getPassword());
			        
			    if (!txtusuario.getText().equals("") && !pass.equals("")) {
			            
			        String nuevoPass = Hash.sha1(pass);
			            
			        mod.setUsuario(txtusuario.getText());
			        mod.setContraseña(nuevoPass);
			            
			        if (modSql.login(mod)) {
			                
			            VentanaMenu nuevaVentana = new VentanaMenu();
			            nuevaVentana.setVisible(true);
			            VentanaLogin.this.dispose();
			                
			            } else {
			                JOptionPane.showMessageDialog(null, "Datos incorrectos");
			                limpiar();
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
			        }


			}

			private void limpiar() {
				txtusuario.setText("");
		        txtcontraseña.setText("");
				
			}
		});
		btnLogIn.setBackground(UIManager.getColor("PopupMenu.selectionBackground"));
		btnLogIn.setBounds(6, 207, 83, 29);
		contentPane.add(btnLogIn);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(6, 43, 61, 16);
		contentPane.add(lblUsuario);
		
		txtusuario = new JTextField();
		txtusuario.setBackground(UIManager.getColor("PopupMenu.selectionBackground"));
		txtusuario.setBounds(6, 72, 300, 36);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(6, 119, 105, 16);
		contentPane.add(lblContrasea);
		
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
		
		txtcontraseña = new JPasswordField();
		txtcontraseña.setBounds(6, 151, 300, 40);
		contentPane.add(txtcontraseña);
	}
}
