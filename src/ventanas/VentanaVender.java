package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import main.BaseDeDatos;
import main.LogController;
import main.Usuarios;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class VentanaVender extends JFrame {

	private JPanel contentPane;
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
					VentanaVender frame = new VentanaVender();
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
	public VentanaVender() {
		
		ConfigureCloseWindow();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 523);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelJugador = new JPanel();
		panelJugador.setBackground(new Color(245, 255, 250));
		panelJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelJugador.setBounds(10, 92, 411, 73);
		contentPane.add(panelJugador);
		panelJugador.setLayout(null);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(0, 0, 46, 73);
		panelJugador.add(lblImagen);
		
		Label labelNomJugador = new Label("Nombre Jugador\r\n");
		labelNomJugador.setBounds(52, 10, 92, 27);
		panelJugador.add(labelNomJugador);
		
		Label label_PrecioJug = new Label("Precio del jugador\r\n\r\n");
		label_PrecioJug.setBounds(52, 41, 92, 22);
		panelJugador.add(label_PrecioJug);
		
		Label label_Puntos = new Label("Puntos\r\n");
		label_Puntos.setBounds(359, 10, 42, 58);
		panelJugador.add(label_Puntos);
		
		JLabel lblNewLabel_1 = new JLabel("Introducir cantidad\r\n");
		lblNewLabel_1.setBounds(211, 48, 141, 14);
		panelJugador.add(lblNewLabel_1);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(222, 10, 89, 23);
		panelJugador.add(btnVender);
		
		JPanel panel_jug2 = new JPanel();
		panel_jug2.setBackground(new Color(245, 255, 250));
		panel_jug2.setLayout(null);
		panel_jug2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_jug2.setBounds(10, 166, 411, 73);
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
		
		Label label_8 = new Label("Puntos\r\n");
		label_8.setBounds(359, 10, 42, 58);
		panel_jug2.add(label_8);
		
		JLabel lblIntroducirCantidad = new JLabel("Introducir cantidad");
		lblIntroducirCantidad.setBounds(212, 41, 141, 14);
		panel_jug2.add(lblIntroducirCantidad);
		
		JButton button = new JButton("Vender");
		button.setBounds(224, 7, 89, 23);
		panel_jug2.add(button);
		
		JPanel panel_jug3 = new JPanel();
		panel_jug3.setBackground(new Color(245, 255, 250));
		panel_jug3.setLayout(null);
		panel_jug3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_jug3.setBounds(10, 241, 411, 73);
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
		
		Label label_13 = new Label("Puntos\r\n");
		label_13.setBounds(359, 10, 42, 53);
		panel_jug3.add(label_13);
		
		JLabel lblIntroducirCantidad_1 = new JLabel("Introducir cantidad\r\n");
		lblIntroducirCantidad_1.setBounds(212, 41, 141, 14);
		panel_jug3.add(lblIntroducirCantidad_1);
		
		JButton button_1 = new JButton("Vender");
		button_1.setBounds(223, 14, 89, 23);
		panel_jug3.add(button_1);
		
		JPanel panel_jug4 = new JPanel();
		panel_jug4.setBackground(new Color(245, 255, 250));
		panel_jug4.setLayout(null);
		panel_jug4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_jug4.setBounds(10, 316, 411, 73);
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
		
		Label label_18 = new Label("Puntos\r\n");
		label_18.setBounds(359, 10, 42, 53);
		panel_jug4.add(label_18);
		
		JLabel lblIntroducirCantidad_2 = new JLabel("Introducir cantidad");
		lblIntroducirCantidad_2.setBounds(214, 41, 141, 14);
		panel_jug4.add(lblIntroducirCantidad_2);
		
		JButton button_2 = new JButton("Vender");
		button_2.setBounds(227, 14, 89, 23);
		panel_jug4.add(button_2);
		
		Panel panel_jug5 = new Panel();
		panel_jug5.setBackground(new Color(230, 230, 250));
		panel_jug5.setBounds(10, 391, 411, 60);
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
		btnAtras.setBounds(15, 16, 115, 22);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMercado nuevaVentana = new VentanaMercado();
				nuevaVentana.setVisible(true);
				VentanaVender.this.dispose();
				
			}
			
		});
		contentPane.setLayout(null);
		contentPane.add(btnAtras);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(15, 41, 115, 22);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMenu nuevaVentana = new VentanaMenu();
				nuevaVentana.setVisible(true);
				VentanaVender.this.dispose();
			}
			
		});
		contentPane.add(btnMenu);
		
		JLabel lblNewLabel = new JLabel("                                                                 VENDER");
		lblNewLabel.setBounds(0, 61, 438, 20);
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setBackground(Color.BLACK);
		contentPane.add(lblNewLabel);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("Imagenes/2-24410_kyrie-andrew-irving-fondos-de-pantalla-nba-2018.jpg"));
		label_3.setBounds(-21, -93, 521, 645);
		contentPane.add(label_3);
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
	
	private int cargarPlantilla() {
		
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
			
			}
	
}
}