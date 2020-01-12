package ventanas;

import java.awt.EventQueue;
import main.Usuarios;
import main.Jugador;
import main.UsuarioJugadores;
import main.BaseDeDatos;
import main.LogController;
import ventanas.VentanaAdministrador;
import main.variablesGlobales;
import ventanas.VentanaLogin;
import main.azar;

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
import javax.swing.JScrollPane;

public class VentanaEquipo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Statement st=null;
	private ArrayList<Usuarios>lista ;
	
	private static ArrayList<UsuarioJugadores>listaJ;
   // private ArrayList usuario;
    ArrayList<Jugador>listaJugadores;
	ArrayList<UsuarioJugadores>listaUsuarios;
	
	static String idjornada;
	static String puntosjornada2;
	private DefaultListModel modeloequipo;
	private UsuarioJugadores usujugadores;



	/**
	 * Launch the application..
	 */
	
	
	
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
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
		
		JLabel lblAlero = new JLabel("Suplentes");
		lblAlero.setBounds(116, 252, 61, 16);
		contentPane.add(lblAlero);
		
		JLabel lblAlaPivot = new JLabel("Titulares");
		lblAlaPivot.setBounds(116, 52, 84, 16);
		contentPane.add(lblAlaPivot);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 72, 155, 160);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(79, 284, 155, 102);
		contentPane.add(scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JLabel label = new JLabel("");
		label.setBounds(-28, -36, 380, 691);
		contentPane.add(label);
		label.setIcon(new ImageIcon("Imagenes/file-JOpim3qYcQ.png"));
		
		
		
		listaJ=new ArrayList<UsuarioJugadores>();
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
		
		cargarJugadoresPlantilla();
	}
/*	
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
		ResultSet rs=st.executeQuery("select * from usuJugadores");
		
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


private int dameUltimoUsuario() {
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
		azar();
		
		BaseDeDatos.initBD();
		
		try {
			
			//int icon=0;
			
			st=BaseDeDatos.getStatement();
			ResultSet rs=st.executeQuery("select nombre  from jugadores, usuJugadores where jugadores.id = usuJugadores.id and usuJugadores.idUsuario='" + idUsu + "'");
			
			while(rs.next()) {
				
				/*
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

private void azar() {
	
	anyadirJugadoresALista();
	// obtener los cinco numeros al azar
			 int[] arAzar = new int[5];
			 int i =0;
			 boolean bolRepetido = false;
			
			do {
				arAzar[i] = (int) (Math.random()*listaJ.size());
				for(int j=0; j<=i; j++) {
					if(arAzar[i] == arAzar[j]) {
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
				

				usuJugador.setId_usuarios(dameUltimoUsuario());
				
				Statement st = BaseDeDatos.getStatement();
				
				String sentencia="INSERT INTO usujugadores values("idJug;
				sentencia = sentencia + idJug + ","+ dameUltimoUsuario()+")";
				
				System.out.println(sentencia);
				try {
					st.executeUpdate(sentencia);
					
				} catch (SQLException e) {
					LogController.log ( Level.SEVERE, "Error al repartir los jugadores " + (new Date()),e);
					e.printStackTrace();
				}
			}
}
*/
private void cargarJugadoresPlantilla() 
{
	st=BaseDeDatos.getStatement();
	String sentencia="select * from usujugadores,usuarios where usuarios.idUsuario=usujugadores.id_usuarios";
	
	try {
		ResultSet rs=st.executeQuery(sentencia);
		
		while(rs.next())
		{
			UsuarioJugadores usujugadores=new UsuarioJugadores();
			
			usujugadores.setId_jugador(rs.getInt(1));
			usujugadores.setId_usuarios(rs.getInt(2));
			usujugadores.setPuntosTotales(rs.getInt(3));
		
			
			
			
		//modelo.addElement(rs.getString("nombre"));
		
		listaJ.add(usujugadores);
		modeloequipo.addElement(rs.getString("nombre"));
			
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
