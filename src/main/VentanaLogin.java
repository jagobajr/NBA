package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ventanas.VentanaMenu;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

import main.variablesGlobales;
import main.Usuarios;
import main.Idioma;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtcontra;
	JButton btnCambio;


	//public variablesGlobales varId;
public static int idUsuario;
	
	
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
			    variablesGlobales vg = new variablesGlobales();
			    String pass = new String(txtcontra.getPassword());
			        
			    if (!txtusuario.getText().equals("") && !pass.equals("")) {
			            
			        String nuevoPass = Hash.sha1(pass);
			            
			        mod.setUsuario(txtusuario.getText());
			        
			       // mod.setIdUsuario(txtusuario.getText());
			       // vg.setIdUsu(Integer.parseInt(txtusuario.getText()));
			       //falta guardar la id del usuario que va aqui aqui
			        mod.setIdUsuario(txtusuario.getText());
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
		btnLogIn.setBounds(6, 199, 83, 29);
		contentPane.add(btnLogIn);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(6, 43, 61, 16);
		contentPane.add(lblUsuario);
		
		txtusuario = new JTextField();
		txtusuario.setForeground(Color.GREEN);
		txtusuario.setBackground(Color.WHITE);
		txtusuario.setBounds(6, 70, 300, 36);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(6, 122, 105, 16);
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
		txtcontra.setBounds(6, 143, 300, 40);
		contentPane.add(txtcontra);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				AccesoAdministrador nuevaVentana = new AccesoAdministrador();
				nuevaVentana.setVisible(true);
				VentanaLogin.this.dispose();
			}}); 
		
		JButton btnConsulta = new JButton("Consulta nuestra politica de privacidad");
		btnConsulta.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				AbrirFicheroTexto nuevaVentana = new AbrirFicheroTexto();
				nuevaVentana.setVisible(true);

			}});
		
		btnAdmin.setBounds(6, 331, 83, 29);
		contentPane.add(btnAdmin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes/thumb-1920-467394.jpg"));
		label.setBounds(0, 0, 380, 406);
		contentPane.add(label);
		
		btnConsulta.setBounds(6, 244, 271, 29);
		contentPane.add(btnConsulta);
		
		JButton btnCambioDeIdioma = new JButton("Cambio de Idioma");
		btnCambioDeIdioma.setBounds(202, 16, 141, 29);
		contentPane.add(btnCambioDeIdioma);
		


	}

	public static int getUsuarioId() {
        return idUsuario;
	}
	
	public  void  setUsuarioId(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	 public void VentanaLogin1() {
	        initComponents();
	 
	        cambiarIdioma("Espanol");
	    }
	 
	   public void cambiarIdioma(String nombreIdioma){
	 
	        Idioma idioma=new Idioma(nombreIdioma);
	 
	        btnCambio.setText(idioma.getProperty("cambio"));
	        this.setTitle(idioma.getProperty("titulo"));
	        lblHola.setText(idioma.getProperty("saludo"));
	 
	        cmbIdiomas.removeAllItems();
	 
	        String idiomas[]={
	                          idioma.getProperties("espanol"),
	                          idioma.getProperty("ingles"),
	                          idioma.getProperty("frances")
	                          };
	 
	        for(int i=0;i<idiomas.length;i++){
	            cmbIdiomas.addItem(idiomas[i]);
	        }
	 
	    }
	 
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">
	    private void initComponents() {
	 
	        JButton btnCambio = new javax.swing.JButton();
	        JLabel lblHola = new javax.swing.JLabel();
	        JComboBox cmbIdiomas = new javax.swing.JComboBox();
	 
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	 
	        btnCambio.setText("jButton1");
	        btnCambio.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                actionPerformed(evt);
	            }
	        });
	 
	        lblHola.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        lblHola.setText("jLabel1");
	 
	        cmbIdiomas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Español", "Ingles", "Frances" }));
	 
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(145, 145, 145)
	                .addComponent(btnCambio)
	                .addContainerGap(120, Short.MAX_VALUE))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(lblHola, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
	                    .addComponent(cmbIdiomas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addGap(75, 75, 75))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGap(35, 35, 35)
	                .addComponent(lblHola, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(44, 44, 44)
	                .addComponent(cmbIdiomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(35, 35, 35)
	                .addComponent(btnCambio)
	                .addContainerGap(67, Short.MAX_VALUE))
	        );
	 
	        pack();
	    }// </editor-fold>                        
	 
	    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {                                          
	 
	        switch(cmbIdiomas.getSelectedIndex()){
	 
	            case 0:
	                cambiarIdioma("Español");
	                break;
	            case 1:
	                cambiarIdioma("Ingles");
	                break;
	            case 2:
	                cambiarIdioma("Frances");
	                break;
	 
	        }
	 
	    }                                         
	 
	    /**
	     * @param args the command line arguments
	     */
	    public static void main1(String args[]) {
	        /* Set the Nimbus look and feel */
	        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	         For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
	         
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>
	 
	        /* Create and display the form 
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new VentanaLogin().setVisible(true);
	            }
	        });
	    }
	 
	    // Variables declaration - do not modify
	    private javax.swing.JButton btnCambio;
	    private javax.swing.JComboBox cmbIdiomas;
	    private javax.swing.JLabel lblHola;
	    // End of variables declaration
	    private Idioma idioma; */
	

}
}


