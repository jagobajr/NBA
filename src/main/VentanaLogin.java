package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ventanas.VentanaMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtcontra;

	
	
	public static void main(String[] args) {
		LogController.log ( Level.INFO, "Inicio aplicacion " + (new Date()),null);
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
	
	private  void ConfigureCloseWindow(){
	    this.addWindowListener( new WindowAdapter() {

	        @Override
	        public void windowClosing(WindowEvent e) {
				LogController.log ( Level.INFO, "Fin de programa " + (new Date()),null);

	        }
	    });
		}

	
	
	public VentanaLogin() {
		
		ConfigureCloseWindow();
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Imagenes/thumb-1920-467394.jpg"));
		setTitle("LOG IN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 422);
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
			        
			    String pass = new String(txtcontra.getPassword());
			        
			    if (!txtusuario.getText().equals("") && !pass.equals("")) {
			            
			        String nuevoPass = Hash.sha1(pass);
			            
			        mod.setUsuario(txtusuario.getText());
			        mod.setContra(nuevoPass);
			            
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
		        txtcontra.setText("");
				
			}
		});
		btnLogIn.setBackground(UIManager.getColor("PopupMenu.selectionBackground"));
		btnLogIn.setBounds(6, 207, 83, 29);
		contentPane.add(btnLogIn);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(6, 43, 61, 16);
		contentPane.add(lblUsuario);
		
		txtusuario = new JTextField();
		txtusuario.setForeground(Color.GREEN);
		txtusuario.setBackground(Color.WHITE);
		txtusuario.setBounds(6, 82, 300, 36);
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
		btnAqui.setBackground(UIManager.getColor("Button.background"));
		btnAqui.setBounds(219, 296, 72, 29);
		contentPane.add(btnAqui);
		
		JLabel lblNoTienesUna = new JLabel("No tienes una cuenta? \nRegistrate");
		lblNoTienesUna.setBackground(new Color(255, 255, 255));
		lblNoTienesUna.setForeground(new Color(255, 255, 255));
		lblNoTienesUna.setBounds(6, 299, 227, 20);
		contentPane.add(lblNoTienesUna);
		
		txtcontra= new JPasswordField();
		txtcontra.setBackground(new Color(255, 255, 255));
		txtcontra.setBounds(6, 151, 300, 40);
		contentPane.add(txtcontra);
		
		
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				AccesoAdministrador nuevaVentana = new AccesoAdministrador();
				nuevaVentana.setVisible(true);
				VentanaLogin.this.dispose();
			}});
		btnAdmin.setBounds(6, 331, 83, 29);
		contentPane.add(btnAdmin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes/thumb-1920-467394.jpg"));
		label.setBounds(0, 0, 380, 406);
		contentPane.add(label);
		
		
	
}}