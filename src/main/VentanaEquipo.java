package main;

import ventanas.VentanaMenu;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Color;

public class VentanaEquipo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField DatosPivot;
	private JTextField DatosAla;
	private JTextField DatosAlero;
	private JTextField DatosEscolta;
	private JTextField DatosBase;
	Statement st=null;
	private ArrayList<Usuarios>lista ;
	private DefaultListModel modelo;
	private DefaultListModel modeloUsuarios;
    private DefaultListModel modeloMercado;
	private static ArrayList<Jugador>listaJ;
    private ArrayList usuario;
    ArrayList<Jugador>listaJugadores;
	ArrayList<UsuarioJugadores>listaUsuarios;
	//JList <DefaultListModel>lista ;
	//DefaultListModel modelo;
	static String idjornada;
	static String puntosjornada2;



	/**
	 * Launch the application..
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 VentanaEquipo frame = new VentanaEquipo();
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
	public VentanaEquipo() {
		BaseDeDatos.initBD();
		
		
		ConfigureCloseWindow();
		setTitle("EQUIPO");
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Imagenes/128139.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setSelectedIcon(null);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMenu nuevaVentana = new VentanaMenu();
				nuevaVentana.setVisible(true);
				VentanaEquipo.this.dispose();
			}
			
		});
		btnAtras.setBounds(6, 0, 47, 88);
		contentPane.add(btnAtras);
		
		DatosPivot = new JTextField();
		DatosPivot.setBackground(new Color(245, 245, 220));
		DatosPivot.setBounds(102, 87, 130, 26);
		contentPane.add(DatosPivot);
		DatosPivot.setColumns(10);
		
		DatosAla = new JTextField();
		DatosAla.setBackground(new Color(245, 245, 220));
		DatosAla.setColumns(10);
		DatosAla.setBounds(6, 213, 130, 26);
		contentPane.add(DatosAla);
		
		DatosAlero = new JTextField();
		DatosAlero.setBackground(new Color(245, 245, 220));
		DatosAlero.setColumns(10);
		DatosAlero.setBounds(192, 213, 130, 26);
		contentPane.add(DatosAlero);
		
		DatosEscolta = new JTextField();
		DatosEscolta.setBackground(new Color(245, 245, 220));
		DatosEscolta.setColumns(10);
		DatosEscolta.setBounds(24, 352, 130, 26);
		contentPane.add(DatosEscolta);
		
		DatosBase = new JTextField();
		DatosBase.setBackground(new Color(245, 245, 220));
		DatosBase.setColumns(10);
		DatosBase.setBounds(192, 352, 130, 26);
		contentPane.add(DatosBase);
		
		JLabel lblPivot = new JLabel("Pivot");
		lblPivot.setBounds(202, 35, 61, 16);
		contentPane.add(lblPivot);
		
		JLabel lblAlero = new JLabel("Alero");
		lblAlero.setBounds(166, 160, 61, 16);
		contentPane.add(lblAlero);
		
		JLabel lblBase = new JLabel("Base");
		lblBase.setBounds(171, 297, 61, 16);
		contentPane.add(lblBase);
		
		JLabel lblEscolta = new JLabel("Escolta");
		lblEscolta.setBounds(90, 297, 61, 16);
		contentPane.add(lblEscolta);
		
		JLabel lblAlaPivot = new JLabel("Ala- Pivot");
		lblAlaPivot.setBounds(90, 160, 84, 16);
		contentPane.add(lblAlaPivot);
		
		JLabel fondodeimagen = new JLabel("");
		fondodeimagen.setVisible(true);
		fondodeimagen.setIcon(new ImageIcon("Imagenes/cancha.jpg"));
		fondodeimagen.setBounds(16, 24, 306, 396);
		contentPane.add(fondodeimagen);
		
		

		listaJ=new ArrayList<Jugador>();
		lista=new ArrayList<Usuarios>();
		
		//JList<DefaultListModel> listo=new JList<DefaultListModel>();
		
		/*
		listo.addListSelectionListener(new ListSelectionListener()
		{

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int pos=0;
				if(e.getValueIsAdjusting()==false)
				{
					
					anyadirJugadoresALista();
					//cargarJugadoresEnLista();
					pos=listo.getSelectedIndex();

					DatosAla.setText(""+listaJ.get(pos).getNombre());
					DatosPivot.setText(""+listaJ.get(pos).getNombre());
					DatosAlero.setText(""+listaJ.get(pos).getNombre());
					DatosEscolta.setText(""+listaJ.get(pos).getNombre());
					DatosBase.setText(""+listaJ.get(pos).getNombre());
					
					
					repaint();}}});
		
		*/
		mostarMiEquipo();
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
private void anyadirUsuariosaLista() {
	 
	lista.clear();
	BaseDeDatos.initBD();
	try {
		st=BaseDeDatos.getStatement();
		ResultSet rs=st.executeQuery("select * from usuarios");
		
		Usuarios usuario=new Usuarios();
		while(rs.next())
		{
			
			usuario=new Usuarios();
			

			usuario.setUsuario(rs.getString(3));
			usuario.setContra(rs.getString(4));
			usuario.setDinero(rs.getInt(6));
			usuario.setCorreo(rs.getString(5));
			usuario.setIdTipo(rs.getString(2));
			usuario.setIdUsuario(rs.getString(1));
			
			
			lista.add(usuario);
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
/*
private  void jugadoresAzar() {
	// obtener los cinco numeros al azar
			 int[] arAzar = new int[5];
			 int i =0;
			 boolean bolRepetido = false;
			ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
			do {
				arAzar[i] = (int) (Math.random()*jugadores.size());
				for(int j=0; j<=i; j++) {
					if(arAzar[i-1] == arAzar[j]) {
						bolRepetido = true;
						break;
					}
				}
				if(!bolRepetido) {
					i++;
				}
				
				bolRepetido = false;
			}while(i<5);
			
			// obtener los cinco jugadores 
			
				UsuarioJugadores usuJugador = new UsuarioJugadores();
			
			for (int h=0; h<5; h++){
				usuJugador.setId_jugador(arAzar[h]);

				int idJug = usuJugador.getId_jugador();
				//usuJugador.setId_usuarios

				//usuJugador.setId_usuarios(dameUltimoUsuario());
				
				Statement st = BaseDeDatos.getStatement();
				
				String sentencia="INSERT INTO usuJugador values(";
				sentencia = sentencia + idJug + ","+ dameUltimoUsuario()+")";
				
				System.out.println(sentencia);
				try {
					st.executeUpdate(sentencia);
					
				} catch (SQLException e) {
					LogController.log ( Level.SEVERE, "Error al repartir los jugadores " + (new Date()),e);
					e.printStackTrace();
				}
				
				
	
				//usuJugador.setId_usuarios(id_usuarios);
				//falta id usuario que hay que crearlo con la funcion dameUltimoRegistro 
				// inserta registro en bd 
				//hay crear el nueva intancia el usuJugadores
			}
					
			
			System.out.println(jugadores.size());
		
}
*/
public static int dameUltimoUsuario() {
	BaseDeDatos.initBD();
	try {
		Statement st = BaseDeDatos.getStatement();
		ResultSet rs=st.executeQuery("select max(id_usuario) from usuarios");
		
		
		if(rs.getRow()>0) {
			return rs.getInt(1);
		}else {
			return 1;
		}
		
		
		
		
	} catch (SQLException e) {
		LogController.log ( Level.WARNING, "Error al obtener el ultimo usuario " + (new Date()),e);
		e.printStackTrace();
		
	}
	
	
	return 1;
	
}

private void mostarMiEquipo() {
	
		
		Usuarios mod = new Usuarios();
		
		String idUsu =mod.getIdUsuario();
		
		BaseDeDatos.initBD();
		
		try {
			
			int icon=0;
			
			st=BaseDeDatos.getStatement();
			ResultSet rs=st.executeQuery("select nombre  from jugadores, usuJugadores where jugadores.id = usuJugadores.id and usuJugadores.idUsuario='" + idUsu + "'");
			
			while(rs.next()) {
				
				switch (icon) {
				
				case 0:
					DatosPivot.setText(rs.getString(1)); 
					break;
					
				case 1:
					DatosAla.setText(rs.getString(1)); 
					break;
					
				case 2:
					DatosAlero.setText(rs.getString(1)); 
					break;
					
				case 3:
					DatosEscolta.setText(rs.getString(1)); 
					break;
					
				case 4:
					DatosBase.setText(rs.getString(1));
					break;
					
				}
				
				icon++;
				}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	
	
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
