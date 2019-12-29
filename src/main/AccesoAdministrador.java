package main;

import javax.swing.JFrame;


import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.logging.Level;





public class AccesoAdministrador extends JFrame implements ActionListener{
	
	private JTextField textFieldId;
	private JPasswordField passwordField;
	JLabel lblIntroduceElId;
	JLabel lblContrasea;
	JProgressBar progressBar;
	JButton btnAcceder;
	JButton btnCancelar;
	Runnable r;
	Thread miHilo;
	int contador=0;
	boolean hilo=true;
	
	
    public static void main(String[] args) {
		
		LogController.log ( Level.INFO, "Inicio de acceso de Admin " + (new Date()),null);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccesoAdministrador frame = new AccesoAdministrador();
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
	
	
	
	
	public AccesoAdministrador() {
		
		ConfigureCloseWindow();
		setBounds(400,400,600,300);
		setTitle("LOG IN Administrador");
		getContentPane().setLayout(null);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(254, 60, 86, 20);
		getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 118, 86, 20);
		getContentPane().add(passwordField);
		
		lblIntroduceElId = new JLabel("Introduce el ID administrador");
		lblIntroduceElId.setBounds(22, 63, 183, 14);
		getContentPane().add(lblIntroduceElId);
		
		lblContrasea = new JLabel("Password");
		lblContrasea.setBounds(22, 121, 91, 14);
		getContentPane().add(lblContrasea);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(205, 191, 146, 14);
		getContentPane().add(progressBar);
		
		btnAcceder = new JButton("ACCEDER");
		btnAcceder.setBounds(430, 59, 101, 23);
		getContentPane().add(btnAcceder);
		btnAcceder.addActionListener(this);
		btnAcceder.setActionCommand("acceder");
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(430, 117, 101, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("Cancelar");
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 16, 91, 29);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLogin nuevaVentana = new VentanaLogin();
				nuevaVentana.setVisible(true);
				AccesoAdministrador.this.dispose();
			}
				
		});
	}





	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		switch(arg0.getActionCommand())
		{
		
		case "acceder":
			
			if(textFieldId.getText().equals("admin")&& passwordField.getText().equals("admin"))
			{
				r=new Runnable()
				{

					@Override
					public void run() 
					{
						try {
							while(hilo)
							{
							Thread.sleep(10);
							contador++;
							progressBar.setValue(contador);
							progressBar.setStringPainted(true);
							if(contador==100)
							{
								hilo=false;
								miHilo.interrupt();
								JOptionPane.showMessageDialog(null, "Bienvenido Administrador");
								dispose();
								VentanaAdministrador admin=new VentanaAdministrador();
								admin.setVisible(true);
								
							}}
							
						} catch (InterruptedException e) 
						{
							e.getStackTrace();
						}
						
					}
					
				};
				miHilo=new Thread(r);
				miHilo.start();
			
				break;
			}
			else
			{
				JOptionPane.showMessageDialog(this, "El id o password introducidos son incorrectos");
				break;
			}
			
			
		case "Cancelar":
			
			
			
			textFieldId.setText("");
			 passwordField.setText("");
			 break;
			
		
		}
		
		
	}
}

