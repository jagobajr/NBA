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

//import ud.prog3.Comunio.BasesDeDatos;
import ventanas.VentanaMenu;
import ventanas.VentanaMercado;

import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class VentanaComprar extends JFrame  {

	private JPanel contentPane;
	private JTextField txtIntroducirCantidad;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	ArrayList precios;
	ArrayList mercadoId;
	Statement st=null;
	ArrayList<Usuarios> dineroUsuarios;
	Usuarios usuario;
	DefaultListModel modelo;
	JList list;
	JLabel label;
	
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
		
		Label labelNomJugador = new Label("Nombre Jugador\r\n");
		labelNomJugador.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 12));
		labelNomJugador.setForeground(Color.BLACK);
		labelNomJugador.setBounds(52, 10, 92, 27);
		panelJugador.add(labelNomJugador);
		
		Label label_PrecioJug = new Label("Precio del jugador\r\n\r\n");
		label_PrecioJug.setBounds(52, 41, 92, 22);
		panelJugador.add(label_PrecioJug);
		
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
		
		JPanel panel_jug2 = new JPanel();
		panel_jug2.setBackground(new Color(245, 255, 250));
		panel_jug2.setLayout(null);
		panel_jug2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_jug2.setBounds(10, 166, 295, 73);
		contentPane.add(panel_jug2);
		
		JLabel label_4 = new JLabel("Imagen");
		label_4.setBounds(0, 0, 46, 73);
		panel_jug2.add(label_4);
		
		Label label_5 = new Label("Nombre Jugador\r\n");
		label_5.setBounds(52, 10, 92, 27);
		panel_jug2.add(label_5);
		
		Label label_6 = new Label("Precio del jugador\r\n\r\n");
		label_6.setBounds(52, 41, 92, 22);
		panel_jug2.add(label_6);
		
		Label label_7 = new Label("Contador\r\n");
		label_7.setBounds(302, 15, 52, 22);
		panel_jug2.add(label_7);
		
		Label label_8 = new Label("Puntos\r\n");
		label_8.setBounds(312, 36, 42, 27);
		panel_jug2.add(label_8);
		
		JButton button = new JButton("Pujar");
		button.setBounds(196, 14, 89, 23);
		panel_jug2.add(button);
		
		textField_2 = new JTextField();
		textField_2.setText("Introducir cantidad");
		textField_2.setColumns(10);
		textField_2.setBounds(183, 41, 102, 20);
		panel_jug2.add(textField_2);
		
		JPanel panel_jug3 = new JPanel();
		panel_jug3.setBackground(new Color(245, 255, 250));
		panel_jug3.setLayout(null);
		panel_jug3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_jug3.setBounds(10, 241, 295, 73);
		contentPane.add(panel_jug3);
		
		JLabel label_9 = new JLabel("Imagen");
		label_9.setBounds(0, 0, 46, 73);
		panel_jug3.add(label_9);
		
		Label label_10 = new Label("Nombre Jugador\r\n");
		label_10.setBounds(52, 10, 92, 27);
		panel_jug3.add(label_10);
		
		Label label_11 = new Label("Precio del jugador\r\n\r\n");
		label_11.setBounds(52, 41, 92, 22);
		panel_jug3.add(label_11);
		
		Label label_12 = new Label("Contador\r\n");
		label_12.setBounds(302, 15, 52, 22);
		panel_jug3.add(label_12);
		
		Label label_13 = new Label("Puntos\r\n");
		label_13.setBounds(312, 36, 42, 27);
		panel_jug3.add(label_13);
		
		JButton button_1 = new JButton("Pujar");
		button_1.setBounds(196, 14, 89, 23);
		panel_jug3.add(button_1);
		
		textField_3 = new JTextField();
		textField_3.setText("Introducir cantidad");
		textField_3.setColumns(10);
		textField_3.setBounds(183, 41, 102, 20);
		panel_jug3.add(textField_3);
		
		JPanel panel_jug4 = new JPanel();
		panel_jug4.setBackground(new Color(245, 255, 250));
		panel_jug4.setLayout(null);
		panel_jug4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_jug4.setBounds(10, 316, 295, 73);
		contentPane.add(panel_jug4);
		
		JLabel label_14 = new JLabel("Imagen");
		label_14.setBounds(0, 0, 46, 73);
		panel_jug4.add(label_14);
		
		Label label_15 = new Label("Nombre Jugador\r\n");
		label_15.setBounds(52, 10, 92, 27);
		panel_jug4.add(label_15);
		
		Label label_16 = new Label("Precio del jugador\r\n\r\n");
		label_16.setBounds(52, 41, 92, 22);
		panel_jug4.add(label_16);
		
		Label label_17 = new Label("Contador\r\n");
		label_17.setBounds(302, 15, 52, 22);
		panel_jug4.add(label_17);
		
		Label label_18 = new Label("Puntos\r\n");
		label_18.setBounds(312, 36, 42, 27);
		panel_jug4.add(label_18);
		
		JButton button_2 = new JButton("Pujar");
		button_2.setBounds(196, 10, 89, 23);
		panel_jug4.add(button_2);
		
		textField_4 = new JTextField();
		textField_4.setText("Introducir cantidad");
		textField_4.setColumns(10);
		textField_4.setBounds(183, 41, 102, 20);
		panel_jug4.add(textField_4);
		
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
		
		ArrayList<Usuarios> dineroUsuarios;
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
				
				usuario.setId(rs.getString("id"));
				usuario.setDinero(rs.getInt("dinero"));
				
				dineroUsuarios.add(usuario);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<dineroUsuarios.size();i++)
		{
			
			if(idUsuario.equalsIgnoreCase(dineroUsuarios.get(i).getId()))
			{
				dinero=dineroUsuarios.get(i).getDinero();
			}
		}
		return dinero;
		
	}
		
		private void cargarMercadoDeFichajes() 
		{
			st=(Statement) BaseDeDatos.getStatement();
			modelo.clear();
			precios.clear();
			mercadoId.clear();
			
			String sentencia="select * from mercadodefichajes";
			
			try {
				ResultSet rs=st.executeQuery(sentencia);
				
				while(rs.next())
				{
					modelo.addElement(rs.getString("nombre"));
					precios.add(rs.getInt("precio"));
					mercadoId.add(rs.getString("idJugador"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
			
		}

		
		
	

	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
		case "pujar":
			
			try
			{
				
				
				
				int p1=Integer.parseInt(txtIntroducirCantidad.getText());
				int p2=Integer.parseInt(textField_2.getText());
				int p3=Integer.parseInt(textField_3.getText());
				int p4=Integer.parseInt(textField_4.getText());
			
		
			if(p2<cargarDinero((String)label.getText()))
			{
				
			
			
			if(p1>p2)
			{
				JOptionPane.showMessageDialog(null, "El jugador NO ha aceptado la oferta, es demasiado baja");
			}
			if(p1<=p2)
			{
				JOptionPane.showMessageDialog(null, "el usuario "+label.getText()+" ha fichado a "+modelo.getElementAt(list.getSelectedIndex()));
			
			 st = (Statement) BaseDeDatos.getStatement();
			
			String sentencia="insert into usuariojugadores values('"+label.getText()+"', '"+mercadoId.get(list.getSelectedIndex())+"')";
			String sentencia2="delete from mercadodefichajes where idJugador = '"+mercadoId.get(list.getSelectedIndex())+"'";
			
			int dinero=cargarDineroUsuario((String)label.getText());
			int dinero2=dinero-p2;
			
			String sentencia3="update usuarios set dinero ='"+dinero2+"' where id ='"+label.getText()+"'";
			

			
				st.executeUpdate(sentencia);
				st.executeUpdate(sentencia2);
				st.executeUpdate(sentencia3);
				dispose();
				
			}
			}
			
			else
			{
				JOptionPane.showMessageDialog(null,"el usuario no tiene tanto dinero para fichar");
				
			}
			}
				
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(NumberFormatException n)
			{
				JOptionPane.showMessageDialog(null, "inserta numeros lógicos por favor, puede que haya introducido una cantidad muy elevada, o puede que haya introducido texto,en vez de cifras");
			}
			
			}
			
			
		
		}
}
 