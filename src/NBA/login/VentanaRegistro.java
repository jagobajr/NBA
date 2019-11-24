package NBA.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import NBA.VentanaMenu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField datos_usuario;
	private JTextField correo;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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
		
		JLabel lblNombreApellidos = new JLabel("Usuario:");
		lblNombreApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreApellidos.setBounds(37, 48, 152, 16);
		contentPane.add(lblNombreApellidos);
		
		datos_usuario = new JTextField();
		datos_usuario.setBounds(181, 43, 130, 26);
		contentPane.add(datos_usuario);
		datos_usuario.setColumns(10);
		
		JLabel lblCorreoElectronico = new JLabel("Correo \r\nelectronico:");
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreoElectronico.setBounds(37, 219, 140, 16);
		contentPane.add(lblCorreoElectronico);
		
		correo = new JTextField();
		correo.setBounds(181, 214, 130, 26);
		contentPane.add(correo);
		correo.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(37, 97, 106, 16);
		contentPane.add(lblContrasea);
		
		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SqlUsuarios modSql =  new SqlUsuarios();
				Usuarios mod = new Usuarios();
				
				String pass = new String (passwordField.getPassword());
				String conpass = new String (passwordField_1.getPassword());
				
				  if (datos_usuario.getText().equals("") || pass.equals("") || conpass.equals("") ||  correo.getText().equals("")) {
			            JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los datos");
			        } else {

			            if (pass.equals(conpass)) {

			                if (modSql.existeUsuario(datos_usuario.getText()) == 0) {

			                    if (modSql.esEmail(correo.getText())) {

			                        String nuevoPass = Hash.sha1(pass);

			                       mod.setId(modSql.dameUltimoRegistro());
			                        mod.setUsuario(datos_usuario.getText());
			                        mod.setContra(nuevoPass);
			                        mod.setCorreo(correo.getText());

			                        if (modSql.registrar(mod)) {
			                            JOptionPane.showMessageDialog(null, "Registro Guardado");
			                            VentanaMenu nuevaVentana = new VentanaMenu();
			    			            nuevaVentana.setVisible(true);
			    			            VentanaRegistro.this.dispose();
			                            limpiar();
			                        } else {
			                            JOptionPane.showMessageDialog(null, "Error al Guardar");
			                            limpiar();
			                        }
			                    } else {
			                        JOptionPane.showMessageDialog(null, "El email es incorrecto");
			                    }
			                } else {
			                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
			                }

				}else {
					JOptionPane.showMessageDialog(null,"Las contrase�as no coinciden");
				}
				
				
			        }	}

			private void limpiar() {
				datos_usuario.setText("");
				passwordField.setText("");
				correo.setText("");

				
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 92, 130, 26);
		contentPane.add(passwordField);
		
		JLabel lblConfirmarContrasea = new JLabel("<html>Confirmar Contrase\u00F1a:</html>");
		lblConfirmarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmarContrasea.setBounds(37, 155, 85, 34);
		contentPane.add(lblConfirmarContrasea);
		btnRegistro.setBackground(new Color(255, 239, 213));
		btnRegistro.setBounds(81, 306, 117, 29);
		contentPane.add(btnRegistro);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(181, 152, 130, 26);
		contentPane.add(passwordField_1);
	}
}
