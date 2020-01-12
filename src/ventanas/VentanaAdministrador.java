package ventanas;

import javax.swing.JFrame;
import main.Usuarios;
import main.Jugador;
import main.UsuarioJugadores;
import main.BaseDeDatos;
import main.LogController;
import ventanas.VentanaAdministrador;
import main.variablesGlobales;
import ventanas.VentanaLogin;
import main.azar;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Rectangle;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JSpinner;

import javax.swing.border.EmptyBorder;

public class VentanaAdministrador extends JFrame implements ActionListener{

/**
 * 
 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textFieldNombre;
    private JTextField textFieldEquipo;
    private JTextField textFieldPosicion;
    private JTextField textFieldPuntosJornada;
    private JTextField textFieldPuntosTotales;
    private JList <DefaultListModel>lista ;
    private DefaultListModel modelo;
    private DefaultListModel modeloUsuarios;
    private DefaultListModel modeloMercado;
    private JLabel lblNombre_1;
    private JLabel lblEquipo_1;
    private JLabel lblPosicion_1;
    private JLabel labelAnyadir;
    private Statement st=null;
    private JSpinner spinner;
    private ArrayList<Jugador>listaJ;
    private ArrayList mercado;
    private ArrayList usuarios;
    private ArrayList puntosJornada;
    private Jugador jugador;

    private JTextField textFieldNNombre;
    private JTextField TextFieldNEquipo;
    private JTextField textFieldNPosicion;
    private JTextField textFieldEdad;
    private JTextField textFieldPrecio;
    private JLabel lblPrecio;
    private JList listMercado;
    private JList listUsuarios;
    private JLabel lblJugadoresEnMercado;
    private JScrollPane scrollPane_2;
    private JButton btnPuntuar;
    private JButton btnAadir;
    private JButton btnEliminarMercado;
    private  JButton btnEliminarUsuarios;
    private JButton btnAtras;

   
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 VentanaAdministrador frame = new VentanaAdministrador();
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
				LogController.log ( Level.INFO, "Fin de sesion de administrador " + (new Date()),null);

	        }
	    });
		}

    /**
	 * Create the frame.
	 */
	public VentanaAdministrador() {
		
		BaseDeDatos.initBD();
		BaseDeDatos.crearTablaMercadoDeFichajes();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setBounds(new Rectangle(0, 0, 2147483647, 2147483647));
		setTitle("ADMINISTRADOR DE LA COMUNIDAD ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAdministrador.class.getResource("")));
		setBackground(new Color(0,128,0));
		contentPane.setLayout(null);
		
		listaJ=new ArrayList<Jugador>();
		
		anyadirJugadoresALista();
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 11, 316, 631);
		contentPane.add(scrollPane);
		
		
		lista = new JList<DefaultListModel>();
		
		modelo= new DefaultListModel();
		modeloUsuarios= new DefaultListModel();
		modeloMercado= new DefaultListModel();
		
		lista.setModel(modelo);
		
		
		scrollPane.setViewportView(lista);
		
		lista.addListSelectionListener(new ListSelectionListener()
		{

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int pos=0;
				if(e.getValueIsAdjusting()==true)
				{
					
					anyadirJugadoresALista();
					//cargarJugadoresEnLista();
					pos=lista.getSelectedIndex();

					textFieldNombre.setText(""+listaJ.get(pos).getNombre());
					textFieldEquipo.setText(""+listaJ.get(pos).getEquipo());
					textFieldPosicion.setText(""+listaJ.get(pos).getPosicion());
					textFieldPuntosJornada.setText(""+listaJ.get(pos).getPuntosJornada());
					textFieldPuntosTotales.setText(""+listaJ.get(pos).getPuntosTotales());
					textFieldEdad.setText(""+listaJ.get(pos).getPrecio());
					
					repaint();
					
				}
				
			}
			
		});
		JLabel lblEstosSonLos = new JLabel("Estos son los jugadores que hay");
		lblEstosSonLos.setBounds(378, 13, 217, 14);
		contentPane.add(lblEstosSonLos);
		
		btnPuntuar = new JButton("PUNTUAR");
		btnPuntuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				Statement st=null;
				st=BaseDeDatos.getStatement();
				
				int puntosEstaJornada=0;
				
				
				anyadirJugadoresALista();
				//cargarJugadoresEnLista();
				
				
				for(int i=1;i<listaJ.size();i++)
				{
					Random puntos;
					puntos=new Random();
					
					String sentencia="update jugadores set puntosJornada='"+puntos.nextInt(15)+"' where id='"+i+"'";
					
					try {
						st.executeUpdate(sentencia);
						LogController.log ( Level.INFO, "Puntos de jornada actualizados " + (new Date()),null);


						}
						
				 catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				JOptionPane.showMessageDialog(null, "Los puntos para esta jornada se han calculado");
				
			}
			
		});
		
		btnPuntuar.setBounds(378, 80, 89, 23);
		contentPane.add(btnPuntuar);
		
		labelAnyadir = new JLabel("");
		
		labelAnyadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{

				
				Statement st=null;
				st=BaseDeDatos.getStatement();				
				
				
				anyadirJugadoresALista();
				
				
				
				for(int i=1;i<listaJ.size();i++)
				{
					int puntos=listaJ.get(i).getPuntosTotales()+listaJ.get(i).getPuntosJornada();
					
					listaJ.get(i).setPuntosTotales(puntos);
					try {
						st.executeUpdate("update Jugadores set puntosTotales = '"+listaJ.get(i).getPuntosTotales()+"' where id = '"+i+"'");
						st.executeUpdate("update Jugadores set puntosJornada = '"+0+"' where id = '"+i+"'");
					
					} catch (SQLException e) {
						LogController.log ( Level.WARNING, "Error al actualizar los puntos " + (new Date()),e);
						e.printStackTrace();
					}
					
					
				}
			
				JOptionPane.showMessageDialog(null, "Los puntos de esta jornada ya se han actualizado en los puntos totales de cada jugador");
				
				dispose();
				
			}
		});
		
		labelAnyadir.setBounds(378, 171, 60, 30);
		contentPane.add(labelAnyadir);
		
		JLabel lblProximaJornada = new JLabel("2) PASAR A LA SIGUIENTE JORNADA");
		lblProximaJornada.setBounds(383, 135, 238, 14);
		contentPane.add(lblProximaJornada);
		
		JLabel lblEstosSonLos_1 = new JLabel("Estos son los datos del jugador que has seleccionado");
		lblEstosSonLos_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEstosSonLos_1.setBounds(394, 424, 406, 14);
		contentPane.add(lblEstosSonLos_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(394, 472, 60, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(614, 472, 46, 14);
		contentPane.add(lblEquipo);
		
		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setBounds(800, 472, 60, 14);
		contentPane.add(lblPosicion);
		
		JLabel lblPuntosDeEsta = new JLabel("Puntos de esta Jornada");
		lblPuntosDeEsta.setBounds(1047, 472, 149, 14);
		contentPane.add(lblPuntosDeEsta);
		
		JLabel lblPuntosTotales = new JLabel("Puntos Totales");
		lblPuntosTotales.setBounds(1225, 472, 95, 14);
		contentPane.add(lblPuntosTotales);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(378, 515, 141, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		
		textFieldEquipo = new JTextField();
		textFieldEquipo.setEditable(false);
		textFieldEquipo.setColumns(10);
		textFieldEquipo.setBounds(545, 515, 190, 20);
		contentPane.add(textFieldEquipo);
		
		textFieldPosicion = new JTextField();
		textFieldPosicion.setEditable(false);
		textFieldPosicion.setColumns(10);
		textFieldPosicion.setBounds(774, 515, 103, 20);
		contentPane.add(textFieldPosicion);
		
		textFieldPuntosJornada = new JTextField();
		textFieldPuntosJornada.setEditable(false);
		textFieldPuntosJornada.setColumns(10);
		textFieldPuntosJornada.setBounds(1083, 515, 86, 20);
		contentPane.add(textFieldPuntosJornada);
		
		textFieldPuntosTotales = new JTextField();
		textFieldPuntosTotales.setEditable(false);
		textFieldPuntosTotales.setColumns(10);
		textFieldPuntosTotales.setBounds(1219, 515, 86, 20);
		contentPane.add(textFieldPuntosTotales);
		
		JLabel lblquieresAadirUn = new JLabel("\u00BFQuieres a\u00F1adir un jugador?");
		lblquieresAadirUn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblquieresAadirUn.setBounds(378, 212, 239, 14);
		contentPane.add(lblquieresAadirUn);
		
		lblNombre_1 = new JLabel("Nombre ");
		lblNombre_1.setBounds(495, 247, 61, 14);
		contentPane.add(lblNombre_1);
		lblNombre_1.setVisible(true);
		
		lblEquipo_1 = new JLabel("Equipo");
		lblEquipo_1.setBounds(495, 290, 61, 14);
		contentPane.add(lblEquipo_1);
		lblEquipo_1.setVisible(true);
		
		lblPosicion_1 = new JLabel("Posicion");
		lblPosicion_1.setBounds(495, 333, 61, 14);
		contentPane.add(lblPosicion_1);
		lblPosicion_1.setVisible(true);
		
		textFieldNNombre = new JTextField();
		textFieldNNombre.setBounds(590, 243, 177, 23);
		contentPane.add(textFieldNNombre);
		textFieldNNombre.setColumns(10);
		textFieldNNombre.setVisible(true);
		
		TextFieldNEquipo = new JTextField();
		TextFieldNEquipo.setColumns(10);
		TextFieldNEquipo.setBounds(590, 281, 177, 23);
		contentPane.add(TextFieldNEquipo);
		TextFieldNEquipo.setVisible(true);
		
		textFieldNPosicion = new JTextField();
		textFieldNPosicion.setColumns(10);
		textFieldNPosicion.setBounds(590, 324, 177, 23);
		contentPane.add(textFieldNPosicion);
		textFieldNPosicion.setVisible(true);
		
		btnAadir = new JButton("A\u00D1ADIR");
		btnAadir.setBounds(590, 205, 160, 30);
		contentPane.add(btnAadir);
		btnAadir.addActionListener(this);
		btnAadir.setActionCommand("anyadir");
		btnAadir.setVisible(true);
		
		
		
		
		
		
		textFieldEdad = new JTextField();
		textFieldEdad.setEditable(false);
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(912, 515, 103, 20);
		contentPane.add(textFieldEdad);
		
		JButton btnNewButton = new JButton("A\u00D1ADIR A MERCADO DE FICHAJES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldNombre.getText().isEmpty()==true)
				{
					JOptionPane.showMessageDialog(null , "Por favor, selecciona un jugador para anyadir al mercado de fichajes");
					return;
				}
				
				else
				{
					
					if(textFieldPrecio.isVisible()==false)
					{
						JOptionPane.showMessageDialog(null, "Introduce el precio de este jugador");
					textFieldPrecio.setVisible(true);
					lblPrecio.setVisible(true);
					return;
					}
					else
					{
					
					
					
						st=BaseDeDatos.getStatement();					
					
					
					
					
					String sentencia="insert into mercadoDeFichajes values('"+checkearIdMercado(textFieldNombre.getText())+"' ,'"+textFieldNombre.getText()+"', '"+textFieldPrecio.getText()+"', '"+textFieldPuntosTotales.getText()+"')";
					
					 try {
						 
							st.executeUpdate( sentencia );
							JOptionPane.showMessageDialog(null, textFieldNombre.getText()+" anyadido correctamente en el mercado de fichajes" );
							 
							textFieldPrecio.setVisible(true);
							lblPrecio.setVisible(true);
							textFieldPrecio.setText("");
							textFieldNombre.setText("");
							
							modeloMercado.clear();
							cargarJugadoresMercado();
							LogController.log ( Level.INFO, "Jugador a�adido al mercado de fichajes " + (new Date()),null);

							
							
						} catch (SQLException e1) {
							LogController.log ( Level.WARNING, "Error al a�adir jugador a la base de datos " + (new Date()),e1);
							e1.printStackTrace();
						}
				}
					
				
				
				}
				}

			
		});
		btnNewButton.setBounds(1025, 565, 280, 23);
		contentPane.add(btnNewButton);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(803, 565, 177, 23);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(715, 565, 66, 23);
		contentPane.add(lblPrecio);
		
		JLabel lblPulsaEsteBoton = new JLabel("1) PULSA ESTE BOTON PARA PUNTUAR A LOS JUGADORES");
		lblPulsaEsteBoton.setBounds(378, 48, 323, 14);
		contentPane.add(lblPulsaEsteBoton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(784, 65, 149, 286);
		contentPane.add(scrollPane_1);
		
		listUsuarios = new JList();
		
		/**
		 * evento de la lista de usuarios. Creoque no es necesaria
		 */
		
		scrollPane_1.setViewportView(listUsuarios);
		listUsuarios.setModel(modeloUsuarios);
		cargarUsuariosRegistrados();
		
		
		JLabel lblListaDeUsuarios = new JLabel("Lista de USUARIOS REGISTRADOS");
		lblListaDeUsuarios.setBounds(784, 27, 215, 14);
		contentPane.add(lblListaDeUsuarios);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(1067, 65, 177, 286);
		contentPane.add(scrollPane_2);
		
		listMercado = new JList();
		scrollPane_2.setViewportView(listMercado);
		listMercado.setModel(modeloMercado);
		
		cargarJugadoresMercado();
		
		lblJugadoresEnMercado = new JLabel("Jugadores en MERCADO ");
		lblJugadoresEnMercado.setBounds(1089, 27, 190, 14);
		contentPane.add(lblJugadoresEnMercado);
		
		btnEliminarUsuarios = new JButton("ELIMINAR ");
		btnEliminarUsuarios.setBounds(943, 93, 95, 23);
		contentPane.add(btnEliminarUsuarios);
		btnEliminarUsuarios.addActionListener(this);
		btnEliminarUsuarios.setActionCommand("eliminarUsuarios");
		
		btnEliminarMercado = new JButton("ELIMINAR ");
		btnEliminarMercado.setBounds(1265, 93, 95, 23);
		contentPane.add(btnEliminarMercado);
		btnEliminarMercado.addActionListener(this);
		btnEliminarMercado.setActionCommand("eliminarMercado");
		
		
		JButton btnNewButton_1= new JButton("Reparto de dinero");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RepartoDinero nuevaVentana = new RepartoDinero();
				nuevaVentana.setVisible(true);
				VentanaAdministrador.this.dispose();
			}
				
		});
		btnNewButton_1.setBounds(364, 578, 217, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnAadirUnaNueva = new JButton("AÑADIR UNA NUEVA NOTICIA");
		btnAadirUnaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaNuevaNoticia nuevaVentana = new VentanaNuevaNoticia();
				nuevaVentana.setVisible(true);
				VentanaAdministrador.this.dispose();
			}
				
		});
		btnAadirUnaNueva.setBounds(364, 613, 217, 29);
		contentPane.add(btnAadirUnaNueva);
		
		btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLogin nuevaVentana = new VentanaLogin();
				nuevaVentana.setVisible(true);
				VentanaAdministrador.this.dispose();
			}
				
		});
		btnAtras.setBounds(44, 713, 117, 29);
		contentPane.add(btnAtras);
		
		lblPrecio.setVisible(true);
		
		cargarJugadoresEnLista();
	
	}
	

	private void cargarJugadoresEnLista() 
	{
			st=BaseDeDatos.getStatement();			
			String jugadores;
			try {
				jugadores="select * from jugadores";
				ResultSet rs=st.executeQuery(jugadores);
				
				
				
				//ResultSetMetaData rsmd = rs.getMetaData();
				//int columnCount = rsmd.getColumnCount();
				while(rs.next())
				{
					Jugador jugador=new Jugador();
					
					//jugador.setNombre(rs.getString("nombre"));
					//jugador.setPrecio(rs.getInt("precio"));
					//jugador.setEquipo(rs.getString("equipo"));
					//jugador.setId(rs.getString("id"));
					//jugador.setPuntosJornada(rs.getInt("puntosJornada"));
					//jugador.setPuntosTotales(rs.getInt("puntosTotales"));
					//jugador.setPosicion(rs.getString("posicion"));
					
					
					
					jugador.setNombre(rs.getString(2));
					jugador.setPrecio(rs.getInt(5));
					jugador.setEquipo(rs.getString(3));
					jugador.setId(rs.getString(1));
					jugador.setPuntosJornada(rs.getInt(6));
					jugador.setPuntosTotales(rs.getInt(7));
					jugador.setPosicion(rs.getString(4));
					
					
					
				//modelo.addElement(rs.getString("nombre"));
				
				listaJ.add(jugador);
				modelo.addElement(rs.getString("nombre"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
	}


	


	private void cargarUsuariosRegistrados()
	{
		st=BaseDeDatos.getStatement();
		usuarios=new ArrayList();
		
		String sentencia="select * from usuarios";
		
		try
		{
			ResultSet rs=st.executeQuery(sentencia);
			
			while(rs.next())
			{
				modeloUsuarios.addElement(rs.getString("usuario"));
				LogController.log ( Level.INFO, "Usuarios cargados " + (new Date()),null);

			}
			
		} catch (SQLException e) {
			LogController.log ( Level.WARNING, "Error al cargar los jugadores " + (new Date()),e);
			e.printStackTrace();
		}
		
		
	}

	private void cargarJugadoresMercado() 
	{
		mercado=new ArrayList();
		st=BaseDeDatos.getStatement();
		String sentencia="select * from mercadodefichajes";
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			
			while(rs.next())
			{
				modeloMercado.addElement(rs.getString("nombre"));
				mercado.add(rs.getString("IdJugador") +" ");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}





	
	public int testJugadoresEnBaseDatos(ArrayList <Jugador>lista,Statement st)
	{
		st=BaseDeDatos.getStatement();
		lista.clear();
		
		try {
			ResultSet rs=st.executeQuery("select * from Jugadores");
			
			Jugador jugador=new Jugador();
			while(rs.next())
			{
				
				jugador=new Jugador();
				

				jugador.setNombre(rs.getString(2));
				jugador.setPrecio(rs.getInt(7));
				jugador.setEquipo(rs.getString(4));
				jugador.setId(rs.getString(1));
				jugador.setPuntosJornada(rs.getInt(5));
				jugador.setPuntosTotales(rs.getInt(6));
				jugador.setPosicion(rs.getString(3));
				
				lista.add(jugador);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista.size();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
		case "anyadir":
			
			String jugadores="select * from jugadores";
			
			st=BaseDeDatos.getStatement();
			String sentencia;
			sentencia="insert into jugadores values("+checkearId() +", '"+textFieldNNombre.getText()+"', '"+TextFieldNEquipo.getText()+"', '"+textFieldNPosicion.getText()+"', '"+(int)spinner.getValue()+"', '0', '0')";
			 
			try {
				st.executeUpdate(sentencia);
				ResultSet rs=st.executeQuery(jugadores);
				
				
				modelo.addElement(textFieldNNombre.getText());
				
				
			}
				 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		JOptionPane.showMessageDialog(this, "Jugador "+textFieldNNombre.getText()+" anyadido correctamente");
		
		textFieldNombre.setText("");
		textFieldEquipo.setText("");
		textFieldPosicion.setText("");
		textFieldPuntosJornada.setText("");
		textFieldPuntosTotales.setText("");
		textFieldEdad.setText("");
			
		repaint();
		break;
		
		case "eliminarUsuarios":
			
			if(listUsuarios.isSelectionEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, selecciona un Usuario de la lista para poder eliminarlo");
				break;
			}
			else
			{
				if(listUsuarios.isSelectionEmpty()==false)
				{
					String value=listUsuarios.getSelectedValue()+"";
					eliminarUsuario(value, listUsuarios.getSelectedIndex());
					
				}
			}
			
			repaint();
			break;
			
		case "eliminarMercado":
		
			if(listMercado.isSelectionEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, selecciona un jugador de la lista para poder eliminarlo del mercado");
				break;
			}
			else
			{
				if(listMercado.isSelectionEmpty()==false)
				{
					String valor=(String) listMercado.getSelectedValue();
					eliminarMercado(valor, listMercado.getSelectedIndex());
					
				}
			}
			
			repaint();
			break;
	
		}
		
	}


	private void eliminarMercado(String valor, int selectedIndex)
	{
		st=BaseDeDatos.getStatement();
		
		String sentencia="DELETE FROM mercadodefichajes WHERE nombre = '"+valor+"'";
		System.out.println(sentencia);
		try {
			st.executeUpdate(sentencia);
			modeloMercado.remove(selectedIndex);
			LogController.log ( Level.INFO, "Jugador eleminado del mercado de fichajes " + (new Date()),null);

		} catch (SQLException e) {
			LogController.log ( Level.WARNING, "Error al eliminar un jugador del mercado de fichajes " + (new Date()),e);
			e.printStackTrace();
		}
		
		repaint();
	}

	private void eliminarUsuario(String value, int i)
	{
		st=BaseDeDatos.getStatement();
		
		String sentencia="DELETE FROM usuarios WHERE usuario = '"+value+"'";
		
		System.out.println(sentencia);
		try {
			
			st.executeUpdate(sentencia);
			modeloUsuarios.remove(i);
			LogController.log ( Level.INFO, "Usuario eliminado " + (new Date()),null);

			
		} catch (SQLException e) {
			LogController.log ( Level.WARNING, "Error al eliminar usuario " + (new Date()),e);
			e.printStackTrace();
		}
		
		
		repaint();
	}

	private int checkearId()
	{
		anyadirJugadoresALista();
		return listaJ.size();
	}
	
	private String checkearIdMercado(String nombre)
	{
		String id="";
		anyadirJugadoresALista();
		
		for(int i=0;i<listaJ.size();i++)
		{
			if(nombre.equals(listaJ.get(i).getNombre()))
			{
				id=listaJ.get(i).getId();
				break;
				
			}
		}
		
		return id;
		
	}
	


	private void anyadirJugadoresALista() {
		
		listaJ.clear();
		BaseDeDatos.initBD();
		try {
			st=BaseDeDatos.getStatement();
			ResultSet rs=st.executeQuery("select * from jugadores");
			
			Jugador jugador=new Jugador();
			while(rs.next())
			{
				
				jugador=new Jugador();
				

				jugador.setNombre(rs.getString(2));
				jugador.setPrecio(rs.getInt(7));
				jugador.setEquipo(rs.getString(4));
				jugador.setId(rs.getString(1));
				jugador.setPuntosJornada(rs.getInt(5));
				jugador.setPuntosTotales(rs.getInt(6));
				jugador.setPosicion(rs.getString(3));
				
				listaJ.add(jugador);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
