package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Statement;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ventanas.VentanaLogin;
import ventanas.VentanaMenu;
import ventanas.VentanaMercado;


import main.Usuarios;

import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import java.sql.*;

public class VentanaComprar extends JFrame  {

	private JPanel contentPane;
	private JTextField txtIntroducirCantidad;
	private JTextField txtIntroducirCantidad2;
	private JTextField txtIntroducirCantidad3;
	private JTextField txtIntroducirCantidad4;
	private ArrayList precios;
	private ArrayList mercadoId;
	Statement st=null;
	private ArrayList<Usuarios> dineroUsuarios;
	private Usuarios usuario;
	private DefaultListModel modelo;
	private JList list;
	private JLabel label;
	private JList <DefaultListModel>lista ;
	private JTextField txtId_1;
	private JTextField txtId_2;
	private JTextField txtId_3;
	private JTextField txtId_4;
	private JTextField txtNom1;
	private JTextField txtNom2;
	private JTextField txtNom3;
	private JTextField txtNom4;
	private JTextField txtPre1;
	private JTextField txtPre2;
	private JTextField txtPre3;
	private JTextField txtPre4;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaComprar frame = new VentanaComprar();
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

	/**
	 * Create the frame.
	 */
	public VentanaComprar() {
		
		ConfigureCloseWindow();
		setTitle("COMPRAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombrePuntosPrecio = new JLabel("Nombre  Puntos  Precio  Finaliza en  Media");
		lblNombrePuntosPrecio.setForeground(new Color(240, 248, 255));
		lblNombrePuntosPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePuntosPrecio.setBounds(20, 67, 285, 14);
		contentPane.add(lblNombrePuntosPrecio);
		
		JPanel panelJugador = new JPanel();
		panelJugador.setBackground(new Color(245, 255, 250));
		panelJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelJugador.setBounds(10, 92, 295, 73);
		contentPane.add(panelJugador);
		panelJugador.setLayout(null);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(0, 0, 46, 73);
		panelJugador.add(lblImagen);
		
		Label label_Cont = new Label("Contador\r\n");
		label_Cont.setBounds(302, 15, 52, 22);
		panelJugador.add(label_Cont);
		
		Label label_Puntos = new Label("Puntos\r\n");
		label_Puntos.setBounds(312, 36, 42, 27);
		panelJugador.add(label_Puntos);
		
		JButton btnPujar = new JButton("Pujar");
		btnPujar.setBounds(196, 14, 89, 23);
		panelJugador.add(btnPujar);
		
		txtIntroducirCantidad = new JTextField();
		txtIntroducirCantidad.setText("Introducir cantidad");
		txtIntroducirCantidad.setBounds(180, 41, 102, 20);
		panelJugador.add(txtIntroducirCantidad);
		txtIntroducirCantidad.setColumns(10);
		
		txtId_1 = new JTextField();
		txtId_1.setVisible(false);
		txtId_1.setText("id\r\n");
		txtId_1.setBounds(144, 26, 26, 20);
		panelJugador.add(txtId_1);
		txtId_1.setColumns(10);
		
		txtNom1 = new JTextField();
		txtNom1.setEnabled(false);
		txtNom1.setText("Nombre");
		txtNom1.setBounds(48, 15, 64, 20);
		panelJugador.add(txtNom1);
		txtNom1.setColumns(10);
		
		txtPre1 = new JTextField();
		txtPre1.setEnabled(false);
		txtPre1.setText("Precio");
		txtPre1.setBounds(48, 43, 64, 20);
		panelJugador.add(txtPre1);
		txtPre1.setColumns(10);
		
		JPanel panel_jug2 = new JPanel();
		panel_jug2.setBackground(new Color(245, 255, 250));
		panel_jug2.setLayout(null);
		panel_jug2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_jug2.setBounds(10, 166, 295, 73);
		contentPane.add(panel_jug2);
		
		JLabel label_4 = new JLabel("Imagen");
		label_4.setBounds(0, 0, 46, 73);
		panel_jug2.add(label_4);
		
		Label label_7 = new Label("Contador\r\n");
		label_7.setBounds(302, 15, 52, 22);
		panel_jug2.add(label_7);
		
		Label label_8 = new Label("Puntos\r\n");
		label_8.setBounds(312, 36, 42, 27);
		panel_jug2.add(label_8);
		
		JButton button = new JButton("Pujar");
		button.setBounds(196, 14, 89, 23);
		panel_jug2.add(button);
		
		txtIntroducirCantidad2 = new JTextField();
		txtIntroducirCantidad2.setText("Introducir cantidad");
		txtIntroducirCantidad2.setColumns(10);
		txtIntroducirCantidad2.setBounds(183, 41, 102, 20);
		panel_jug2.add(txtIntroducirCantidad2);
		
		txtId_2 = new JTextField();
		txtId_2.setVisible(false);
		txtId_2.setText("id\r\n");
		txtId_2.setColumns(10);
		txtId_2.setBounds(146, 17, 26, 20);
		panel_jug2.add(txtId_2);
		
		txtNom2 = new JTextField();
		txtNom2.setText("Nombre");
		txtNom2.setEnabled(false);
		txtNom2.setColumns(10);
		txtNom2.setBounds(56, 15, 64, 20);
		panel_jug2.add(txtNom2);
		
		txtPre2 = new JTextField();
		txtPre2.setText("Precio");
		txtPre2.setEnabled(false);
		txtPre2.setColumns(10);
		txtPre2.setBounds(56, 41, 64, 20);
		panel_jug2.add(txtPre2);
		
		JPanel panel_jug3 = new JPanel();
		panel_jug3.setBackground(new Color(245, 255, 250));
		panel_jug3.setLayout(null);
		panel_jug3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_jug3.setBounds(10, 241, 295, 73);
		contentPane.add(panel_jug3);
		
		JLabel label_9 = new JLabel("Imagen");
		label_9.setBounds(0, 0, 46, 73);
		panel_jug3.add(label_9);
		
		Label label_12 = new Label("Contador\r\n");
		label_12.setBounds(302, 15, 52, 22);
		panel_jug3.add(label_12);
		
		Label label_13 = new Label("Puntos\r\n");
		label_13.setBounds(312, 36, 42, 27);
		panel_jug3.add(label_13);
		
		JButton button_1 = new JButton("Pujar");
		button_1.setBounds(196, 14, 89, 23);
		panel_jug3.add(button_1);
		
		txtIntroducirCantidad3 = new JTextField();
		txtIntroducirCantidad3.setText("Introducir cantidad");
		txtIntroducirCantidad3.setColumns(10);
		txtIntroducirCantidad3.setBounds(183, 41, 102, 20);
		panel_jug3.add(txtIntroducirCantidad3);
		
		txtId_3 = new JTextField();
		txtId_3.setVisible(false);
		txtId_3.setText("id\r\n");
		txtId_3.setColumns(10);
		txtId_3.setBounds(144, 10, 26, 20);
		panel_jug3.add(txtId_3);
		
		txtNom3 = new JTextField();
		txtNom3.setText("Nombre");
		txtNom3.setEnabled(false);
		txtNom3.setColumns(10);
		txtNom3.setBounds(56, 15, 64, 20);
		panel_jug3.add(txtNom3);
		
		txtPre3 = new JTextField();
		txtPre3.setText("Precio");
		txtPre3.setEnabled(false);
		txtPre3.setColumns(10);
		txtPre3.setBounds(56, 41, 64, 20);
		panel_jug3.add(txtPre3);
		
		JPanel panel_jug4 = new JPanel();
		panel_jug4.setBackground(new Color(245, 255, 250));
		panel_jug4.setLayout(null);
		panel_jug4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_jug4.setBounds(10, 316, 295, 73);
		contentPane.add(panel_jug4);
		
		JLabel label_14 = new JLabel("Imagen");
		label_14.setBounds(0, 0, 46, 73);
		panel_jug4.add(label_14);
		
		Label label_17 = new Label("Contador\r\n");
		label_17.setBounds(302, 15, 52, 22);
		panel_jug4.add(label_17);
		
		Label label_18 = new Label("Puntos\r\n");
		label_18.setBounds(312, 36, 42, 27);
		panel_jug4.add(label_18);
		
		JButton button_2 = new JButton("Pujar");
		button_2.setBounds(196, 10, 89, 23);
		panel_jug4.add(button_2);
		
		txtIntroducirCantidad4 = new JTextField();
		txtIntroducirCantidad4.setText("Introducir cantidad");
		txtIntroducirCantidad4.setColumns(10);
		txtIntroducirCantidad4.setBounds(183, 41, 102, 20);
		panel_jug4.add(txtIntroducirCantidad4);
		
		txtId_4 = new JTextField();
		txtId_4.setVisible(false);
		txtId_4.setText("id\r\n");
		txtId_4.setColumns(10);
		txtId_4.setBounds(147, 10, 26, 20);
		panel_jug4.add(txtId_4);
		
		txtNom4 = new JTextField();
		txtNom4.setText("Nombre");
		txtNom4.setEnabled(false);
		txtNom4.setColumns(10);
		txtNom4.setBounds(57, 15, 64, 20);
		panel_jug4.add(txtNom4);
		
		txtPre4 = new JTextField();
		txtPre4.setText("Precio");
		txtPre4.setEnabled(false);
		txtPre4.setColumns(10);
		txtPre4.setBounds(56, 41, 64, 20);
		panel_jug4.add(txtPre4);
		
		Panel panel_jug5 = new Panel();
		panel_jug5.setBackground(new Color(230, 230, 250));
		panel_jug5.setBounds(10, 395, 295, 60);
		contentPane.add(panel_jug5);
		panel_jug5.setLayout(null);
		
		Label panel_fondos = new Label("Fondos:");
		panel_fondos.setBounds(10, 10, 47, 22);
		panel_jug5.add(panel_fondos);
		
		Label label_ofertas = new Label("Ofertas:\r\n");
		label_ofertas.setBounds(10, 28, 47, 22);
		panel_jug5.add(label_ofertas);
		
		Label label_dinero = new Label("Dinero\r\n");
		label_dinero.setBounds(57, 10, 53, 22);
		panel_jug5.add(label_dinero);
		
		Label panel_dinero2 = new Label("Dinero\r\n");
		panel_dinero2.setBounds(57, 28, 62, 22);
		panel_jug5.add(panel_dinero2);
		
		Label label_pujaMax = new Label("Puja maxima:\r\n");
		label_pujaMax.setBounds(184, 10, 69, 22);
		panel_jug5.add(label_pujaMax);
		
		Label label_balance = new Label("Balance:");
		label_balance.setBounds(204, 28, 47, 22);
		panel_jug5.add(label_balance);
		
		Label label_dinero3 = new Label("Dinero\r\n");
		label_dinero3.setBounds(252, 10, 53, 22);
		panel_jug5.add(label_dinero3);
		
		Label label_dinero4 = new Label("Dinero\r\n");
		label_dinero4.setBounds(252, 28, 53, 22);
		panel_jug5.add(label_dinero4);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMercado nuevaVentana = new VentanaMercado();
				nuevaVentana.setVisible(true);
				VentanaComprar.this.dispose();
			}
			
		});
		btnAtras.setBounds(10, 6, 115, 22);
		contentPane.add(btnAtras);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMenu nuevaVentana = new VentanaMenu();
				nuevaVentana.setVisible(true);
				VentanaComprar.this.dispose();
			}
			
		});
		btnMenu.setBounds(10, 29, 115, 22);
		contentPane.add(btnMenu);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes/128139.jpg"));
		label.setBounds(-29, -23, 462, 552);
		contentPane.add(label);
		
	}
	
	private int cargarDineroUsuario(String idUsuario)
	{
		
		ArrayList<Usuarios> dineroUsuarios = null;
		Usuarios usuario;
		
	
		String sentencia="select * from usuarios";
		
		java.sql.Statement st=null;
		int dinero=0;
		st=BaseDeDatos.getStatement();
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			
			while(rs.next())
			{
				usuario=new Usuarios();
				
				usuario.setIdUsuario(rs.getString("idUsuario"));
				usuario.setDinero(rs.getInt("Dinero"));
				
				dineroUsuarios.add(usuario);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<dineroUsuarios.size();i++)
		{
			
			if(idUsuario.equalsIgnoreCase(dineroUsuarios.get(i).getIdUsuario()))
			{
				dinero=dineroUsuarios.get(i).getDinero();
			}
		}
		return dinero;
		
	}
		
	private void cargarJugadoresMercado2() 
	{
		
		int icon =0;
		  ArrayList mercado =new ArrayList();
		  DefaultListModel modeloMercado = null;
		  java.sql.Statement st=null;
		st= BaseDeDatos.getStatement();
		String sentencia="select * from mercadoDeFichajes";
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			
			while(rs.next())
			{
				/*modeloMercado.addElement(rs.getString("nombre"));
				mercado.add(rs.getString("idJugador") +" ");*/
				
				switch (icon) {
				case 0:
					txtNom1.setText(rs.getString("Nombre"));
					txtPre1.setText(rs.getString("Precio"));
					txtId_1.setText(rs.getString("idJugador"));
					break;
					
				case 1:
					txtNom2.setText(rs.getString("Nombre"));
					txtPre2.setText(rs.getString("Precio"));
					txtId_2.setText(rs.getString("idJugador"));
					break;
					
				case 2:
					txtNom3.setText(rs.getString("Nombre"));
					txtPre3.setText(rs.getString("Precio"));
					txtId_3.setText(rs.getString("idJugador"));
					break;
					
				case 3:
					txtNom4.setText(rs.getString("Nombre"));
					txtPre4.setText(rs.getString("Precio"));
					txtId_4.setText(rs.getString("idJugador"));
					break;
					
				default:
					
					break;
				} 
				
				icon ++;
			}
			
		} catch (SQLException e) {
			LogController.log ( Level.WARNING, "Error al cargar los jugadores en el mercado " + (new Date()),e);
			e.printStackTrace();
		}
		
		
		
		
	}

		
		
	

	
	public void comprarJugadoresBoton1(String idUsuario) {
		
		BaseDeDatos.initBD();
		
		String sentSQL = "";
	
		
	 variablesGlobales idVg;
		
	 int a = VentanaLogin.getUsuarioId();
		
				
		if(esNumerico(txtIntroducirCantidad.toString())) {
			int valorCompra= Integer.valueOf(txtIntroducirCantidad.toString());
			
			if(valorCompra > Integer.parseInt(txtPre1.getText())){
				//String sentencia="select * from mercadoDeFichajes";
				try {
					sentSQL = "insert into usuJugadores (" + a + "," +txtId_1.getText()+ ")" ;
					
					int val = ((java.sql.Statement) st).executeUpdate( sentSQL );
					log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
					if (val!=1) {  // Se tiene que a�adir 1 - error si no
						log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
					}
					
					sentSQL = "delete from mercadoFichajes where idJugador = " +txtId_1.getText();
					
					int valDel = ((java.sql.Statement) st).executeUpdate( sentSQL );
					log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
					if (valDel!=1) {  // Se tiene que a�adir 1 - error si no
						log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
					}
					
					}catch (SQLException e) {
						log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
						e.printStackTrace();
					}
				
				
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Cantidad incorrecta");
			}
		}else {
			JOptionPane.showMessageDialog(null, "El valor debe ser un numero");
		}

		
			}
	
public void comprarJugadoresBoton2(String idUsuario) {
		
		BaseDeDatos.initBD();
		
		String sentSQL = "";
		

int a = VentanaLogin.getUsuarioId();
		
				
		if(esNumerico(txtIntroducirCantidad2.toString())) {
			int valorCompra= Integer.valueOf(txtIntroducirCantidad2.toString());
			
			if(valorCompra > Integer.parseInt(txtPre2.getText())){
				//String sentencia="select * from mercadoDeFichajes";
				try {
					sentSQL = "insert into usuJugadores (" +a + "," +txtId_2.getText()+ ")" ;
					
					int val = ((java.sql.Statement) st).executeUpdate( sentSQL );
					log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
					if (val!=1) {  // Se tiene que a�adir 1 - error si no
						log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
					}
					
					sentSQL = "delete from mercadoFichajes where idJugador = " +txtId_2.getText();
					
					int valDel = ((java.sql.Statement) st).executeUpdate( sentSQL );
					log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
					if (valDel!=1) {  // Se tiene que a�adir 1 - error si no
						log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
					}
					
					}catch (SQLException e) {
						log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
						e.printStackTrace();
					}
				
				
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Cantidad incorrecta");
			}
		}else {
			JOptionPane.showMessageDialog(null, "El valor debe ser un numero");
		}

		
			}
	
	
	
public void comprarJugadoresBoton3(String idUsuario) {
	
	BaseDeDatos.initBD();
	
	String sentSQL = "";
	
	int a = VentanaLogin.getUsuarioId();

			
	if(esNumerico(txtIntroducirCantidad3.toString())) {
		int valorCompra= Integer.valueOf(txtIntroducirCantidad3.toString());
		
		if(valorCompra > Integer.parseInt(txtPre3.getText())){
			//String sentencia="select * from mercadoDeFichajes";
			try {
				sentSQL = "insert into usuJugadores (" + a + "," +txtId_3.getText()+ ")" ;
				
				int val = ((java.sql.Statement) st).executeUpdate( sentSQL );
				log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
				if (val!=1) {  // Se tiene que a�adir 1 - error si no
					log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				}
				
				sentSQL = "delete from mercadoFichajes where idJugador = " +txtId_3.getText();
				
				int valDel = ((java.sql.Statement) st).executeUpdate( sentSQL );
				log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
				if (valDel!=1) {  // Se tiene que a�adir 1 - error si no
					log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				}
				
				}catch (SQLException e) {
					log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
					e.printStackTrace();
				}
			
			
			
			
		}else {
			JOptionPane.showMessageDialog(null, "Cantidad incorrecta");
		}
	}else {
		JOptionPane.showMessageDialog(null, "El valor debe ser un numero");
	}

	
		}


public void comprarJugadoresBoton4(String idUsuario) {
	
	BaseDeDatos.initBD();
	
	String sentSQL = "";
	
	int idJug=0;
	
	int a = VentanaLogin.getUsuarioId();
			
	if(esNumerico(txtIntroducirCantidad4.toString())) {
		int valorCompra= Integer.valueOf(txtIntroducirCantidad4.toString());
		
		if(valorCompra > Integer.parseInt(txtPre4.getText())){
			//String sentencia="select * from mercadoDeFichajes";
			try {
				sentSQL = "insert into usuJugadores (" + a + "," +txtId_4.getText()+ ")" ;
				
				int val = ((java.sql.Statement) st).executeUpdate( sentSQL );
				log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
				if (val!=1) {  // Se tiene que a�adir 1 - error si no
					log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				}
				
				sentSQL = "delete from mercadoFichajes where idJugador = " +txtId_4.getText();
				
				int valDel = ((java.sql.Statement) st).executeUpdate( sentSQL );
				log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
				if (valDel!=1) {  // Se tiene que a�adir 1 - error si no
					log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				}
				
				}catch (SQLException e) {
					log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
					e.printStackTrace();
				}
			
			
			
			
		}else {
			JOptionPane.showMessageDialog(null, "Cantidad incorrecta");
		}
	}else {
		JOptionPane.showMessageDialog(null, "El valor debe ser un numero");
	}

	
		}


		
		


	private void log(Level info, String string, Object object) {
		// TODO Auto-generated method stub
		
	}

	public static boolean esNumerico(String valor){     
	    try{
	        if(valor!= null){
	            Integer.parseInt(valor);
	        }
	    }catch(NumberFormatException nfe){
			LogController.log ( Level.WARNING, "El valor introducido no es un numero" + (new Date()),nfe);
	         return false; 
	    }
	    return false;
	}
	}

	
 