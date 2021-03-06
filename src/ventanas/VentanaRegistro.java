package ventanas;

import java.awt.EventQueue;

import main.Usuarios;
import main.Jugador;
import main.BaseDeDatos;
import main.LogController;
import main.SqlUsuarios;
import main.Hash;
import main.variablesGlobales;
import ventanas.VentanaLogin;
import main.azar;
import ventanas.VentanaMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class VentanaRegistro extends JFrame {

	

	private JPanel contentPane;
	private JTextField datos_usuario;
	private JTextField correo;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	ArrayList Usuarios;
	ArrayList <Jugador>base;
	ArrayList <Jugador>escolta;
	ArrayList <Jugador>alero;
	ArrayList <Jugador>alapivot;	
	ArrayList <Jugador>pivot;
	ArrayList <Jugador>todosJugadores;
    ArrayList <Jugador>baseRepetidos;
	ArrayList <Jugador>escoltaRepetidos;
    ArrayList <Jugador>aleroRepetidos;
	ArrayList <Jugador>alapivotRepetidos;
	ArrayList <Jugador>pivotRepetidos;
    Jugador jugador;
    Random random;
    
	static Statement st=null;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		LogController.log ( Level.INFO, "Inicio Registro " + (new Date()),null);
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
	public VentanaRegistro() {
		
		ConfigureCloseWindow();
		
		escolta=new ArrayList<Jugador>();
		alero=new ArrayList<Jugador>();
		alapivot=new ArrayList<Jugador>();
		pivot=new ArrayList<Jugador>();
		base=new ArrayList<Jugador>();
		escoltaRepetidos=new ArrayList<Jugador>();
		aleroRepetidos=new ArrayList<Jugador>();
		alapivotRepetidos=new ArrayList<Jugador>();
		pivotRepetidos=new ArrayList<Jugador>();
		baseRepetidos=new ArrayList<Jugador>();
		
		todosJugadores=new ArrayList<Jugador>();
		jugador=new Jugador();
		
		
		
		
		setTitle("REGISTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 422);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreApellidos = new JLabel("Usuario:");
		lblNombreApellidos.setEnabled(false);
		lblNombreApellidos.setForeground(Color.WHITE);
		lblNombreApellidos.setBackground(Color.WHITE);
		lblNombreApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreApellidos.setBounds(120, 48, 152, 16);
		contentPane.add(lblNombreApellidos);
		
		datos_usuario = new JTextField();
		datos_usuario.setBounds(197, 44, 130, 26);
		contentPane.add(datos_usuario);
		datos_usuario.setColumns(10);
		
		JLabel lblCorreoElectronico = new JLabel("Correo \r\nelectronico:");
		lblCorreoElectronico.setEnabled(false);
		lblCorreoElectronico.setBackground(Color.WHITE);
		lblCorreoElectronico.setForeground(Color.WHITE);
		lblCorreoElectronico.setFont(new Font("STIXIntegralsUpSm", Font.BOLD, 16));
		lblCorreoElectronico.setBounds(6, 219, 171, 16);
		contentPane.add(lblCorreoElectronico);
		
		correo = new JTextField();
		correo.setBounds(197, 214, 130, 26);
		contentPane.add(correo);
		correo.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setEnabled(false);
		lblContrasea.setBackground(Color.WHITE);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("STIXIntegralsUpSm", Font.BOLD, 16));
		lblContrasea.setBounds(81, 97, 106, 16);
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


			                        mod.setUsuario(datos_usuario.getText());
			                        mod.setContra(nuevoPass);
			                        mod.setCorreo(correo.getText());
			                        mod.setDinero(200000000);

			                        if (modSql.registrar(mod)) {
			                            JOptionPane.showMessageDialog(null, "Registro Guardado");
			                            VentanaMenu nuevaVentana = new VentanaMenu();
			    			            nuevaVentana.setVisible(true);
			    			            VentanaRegistro.this.dispose();
			                            limpiar();
			                        } else {
			                            JOptionPane.showMessageDialog(null, "Error al Guardar");
				                        LogController.log ( Level.WARNING, "Error al guardar " + (new Date()),null);
			                            limpiar();
			                        }
			                    } else {
			                        JOptionPane.showMessageDialog(null, "El email es incorrecto");
			                        LogController.log ( Level.WARNING, "El mail es incorrecto " + (new Date()),null);
			                    }
			                } else {
			                   JOptionPane.showMessageDialog(null, "El usuario ya existe");
			                   LogController.log ( Level.WARNING, "El usuario ya existe " + (new Date()),null);

			                }

				}else {
					JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
					 LogController.log ( Level.INFO, "Las contraseñas no coinciden " + (new Date()),null);

				}
				
				
			        }	}

			private void limpiar() {
				datos_usuario.setText("");
				passwordField.setText("");
				correo.setText("");

				
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(197, 92, 130, 26);
		contentPane.add(passwordField);
		btnRegistro.setBackground(new Color(255, 239, 213));
		btnRegistro.setBounds(81, 306, 117, 29);
		contentPane.add(btnRegistro);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(197, 154, 130, 26);
		contentPane.add(passwordField_1);
		
		JLabel lblConfirmar = new JLabel("Confirmar contraseña:");
		lblConfirmar.setForeground(Color.WHITE);
		lblConfirmar.setFont(new Font("STIXIntegralsUpSm", Font.BOLD, 16));
		lblConfirmar.setEnabled(false);
		lblConfirmar.setBackground(Color.WHITE);
		lblConfirmar.setBounds(6, 157, 193, 21);
		contentPane.add(lblConfirmar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes/thumb-1920-467394.jpg"));
		label.setBounds(-336, 0, 716, 400);
		contentPane.add(label);
		
		//BaseDeDatos.initBD();
		
	/*	BaseDeDatos.crearTablaBasesSalidos();
		BaseDeDatos.crearTablaEscoltasSalidos();
		BaseDeDatos.crearTablaAlerosSalidos();
		BaseDeDatos.crearTablaAlapivotSalidos();
		BaseDeDatos.crearTablaPivotSalidos();
*/
	
	}
	
	
	
	
	//No hemos conseguido asignar los jugadores mediante este metod�
	

/*
	 public void asignarjugadores(int IdUsuario)  {
		Statement st=null;
		BaseDeDatos.crearTablaUsuarioJugadores();
		st=BaseDeDatos.getStatement();
		
		int posicionBase;
		int posicionEscolta;
		int posicionAlero;
		int posicionAlapivot;
		int posicionPivot;
		
		Random rnd=new Random();
		posicionBase=rnd.nextInt(base.size()-1);
		
		do
		{
			posicionBase=rnd.nextInt(base.size()-1);
		}while(comprobarBase(base.get(posicionBase))==false);
		
		
		if(comprobarBase(base.get(posicionBase))==true)
			{
				System.out.println("Base: "+base.get(posicionBase).getNombre());
				
				String sentencia2="insert into usuarioJugadores values ('"+IdUsuario+"', '"+base.get(posicionBase).getId()+"')";
				
				String sentencia="insert into basesSalidos values"
						+ "('"+base.get(posicionBase).getId()
						+"', '"+base.get(posicionBase).getNombre()
						+"', '"+base.get(posicionBase).getEquipo()
						+"', '"+base.get(posicionBase).getPosicion()
						+"', '"+base.get(posicionBase).getPuntosJornada()
						+"', '"+base.get(posicionBase).getPuntosTotales()
						+"', '"+base.get(posicionBase).getPrecio()

						+"')";	
				System.out.println(sentencia);
				System.out.println(sentencia2);
				
				try {
					st.executeUpdate(sentencia);
					st.executeUpdate(sentencia2);
				} catch (SQLException e) {
					LogController.log( Level.WARNING, "Error al asignar base " , e );

					e.printStackTrace();
				}
				
				}
			
		
		
			posicionEscolta=rnd.nextInt(escolta.size()-1);
			
			System.out.println("medios: "+escolta.get(posicionEscolta).getNombre());
			
			
			do{
				
				posicionEscolta=rnd.nextInt(escolta.size()-1);
				
			}while(comprobarEscolta(escolta.get(posicionEscolta))==false);
			
			if(comprobarEscolta(escolta.get(posicionEscolta))==true)
			{
				String sentencia="insert into escoltasSalidos values"
						+ "('"+escolta.get(posicionEscolta).getId()
						+"', '"+escolta.get(posicionEscolta).getNombre()
						+"', '"+escolta.get(posicionEscolta).getEquipo()
						+"', '"+escolta.get(posicionEscolta).getPosicion()
						+"', '"+escolta.get(posicionEscolta).getPuntosJornada()
						+"', '"+escolta.get(posicionEscolta).getPuntosTotales()
						+"', '"+escolta.get(posicionEscolta).getPrecio()
						+"')";	
				String sentencia2="insert into usuarioJugadores values ('"+IdUsuario+"', '"+escolta.get(posicionEscolta).getId()+"')";
				System.out.println(sentencia);
				System.out.println(sentencia2);
				
				try {
					st.executeUpdate(sentencia);
					st.executeUpdate(sentencia2);
				} catch (SQLException e) {
					LogController.log( Level.WARNING, "Error al asignar escolta " , e );
					e.printStackTrace();
				}
				
				
			}
			
				
			
			
			posicionAlero=rnd.nextInt(alero.size()-1);
			System.out.println("alero: "+alero.get(posicionAlero).getNombre());
			
			
			do{
			
				posicionAlero=rnd.nextInt(alero.size()-1);
			
			}while(comprobarAlero(alero.get(posicionAlero))==false);
			
			if(comprobarAlero(alero.get(posicionAlero))==true)
			{

				String sentencia="insert into alerosSalidos values"
						+ "('"+alero.get(posicionAlero).getId()
						+"', '"+alero.get(posicionAlero).getNombre()
						+"', '"+alero.get(posicionAlero).getEquipo()
						+"', '"+alero.get(posicionAlero).getPosicion()
						+"', '"+alero.get(posicionAlero).getPuntosJornada()
						+"', '"+alero.get(posicionAlero).getPuntosTotales()
						+"', '"+alero.get(posicionAlero).getPrecio()
						+"')";	
				System.out.println(sentencia);
				String sentencia3="insert into usuarioJugadores values ('"+IdUsuario+"', '"+alero.get(posicionAlero).getId()+"')";
				System.out.println(sentencia3);
				
				try {
					st.executeUpdate(sentencia);
					st.executeUpdate(sentencia3);
				} catch (SQLException e) {
					LogController.log( Level.WARNING, "Error al asignar alero " , e );
					e.printStackTrace();
				}
				
			}
		
		
			posicionAlapivot=rnd.nextInt(alapivot.size()-1);
			System.out.println("delanteros: "+alapivot.get(posicionAlapivot).getNombre());
			
			do
			{
				posicionAlapivot=rnd.nextInt(alapivot.size()-1);
			}while(comprobarAlapivot(alapivot.get(posicionAlapivot))==false);
			
		
			
			if(comprobarAlapivot(alapivot.get(posicionAlapivot))==true)
			{

				String sentencia="insert into alapivotSalidos values"
						+ "('"+alapivot.get(posicionAlapivot).getId()
						+"', '"+alapivot.get(posicionAlapivot).getNombre()
						+"', '"+alapivot.get(posicionAlapivot).getEquipo()
						+"', '"+alapivot.get(posicionAlapivot).getPosicion()
						+"', '"+alapivot.get(posicionAlapivot).getPuntosJornada()
						+"', '"+alapivot.get(posicionAlapivot).getPuntosTotales()
						+"', '"+alapivot.get(posicionAlapivot).getPrecio()
						+"')";	
				System.out.println(sentencia);
				String sentencia2="insert into usuarioJugadores values ('"+IdUsuario+"', '"+alapivot.get(posicionAlapivot).getId()+"')";
				try {
					st.executeUpdate(sentencia);
					st.executeUpdate(sentencia2);
				} catch (SQLException e) {
					LogController.log( Level.WARNING, "Error al asignar ala pivot " , e );
					e.printStackTrace();
				}
				
			}
			
			do
			{
				posicionPivot=rnd.nextInt(pivot.size()-1);
			}while(comprobarPivot(pivot.get(posicionPivot))==false);
			
		
			
			if(comprobarPivot(pivot.get(posicionPivot))==true)
			{

				String sentencia="insert into pivotSalidos values"
						+ "('"+pivot.get(posicionPivot).getId()
						+"', '"+pivot.get(posicionPivot).getNombre()
						+"', '"+pivot.get(posicionPivot).getEquipo()
						+"', '"+pivot.get(posicionPivot).getPosicion()
						+"', '"+pivot.get(posicionPivot).getPuntosJornada()
						+"', '"+pivot.get(posicionPivot).getPuntosTotales()
						+"', '"+pivot.get(posicionPivot).getPrecio()
						+"')";	
				System.out.println(sentencia);
				String sentencia2="insert into usuarioJugadores values ('"+IdUsuario+"', '"+pivot.get(posicionPivot).getId()+"')";
				try {
					st.executeUpdate(sentencia);
					st.executeUpdate(sentencia2);
				} catch (SQLException e) {
					LogController.log( Level.WARNING, "Error al asignar pivot " , e );
					e.printStackTrace();
				}
				
			}
		}	
					
	
	private boolean comprobarAlapivot(Jugador jugador2)	{
		String sentencia="select * from alapivotSalidos";
		alapivotRepetidos.clear();
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			if(rs.first()==false)
			{
				return true;
			}
			else
			{
				while(rs.next())
					{
				jugador=new Jugador();
				
				jugador.setId(rs.getString("id"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEquipo(rs.getString("equipo"));
				jugador.setPosicion(rs.getString("posicion"));
				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				jugador.setPrecio(rs.getInt("precio"));

				alapivotRepetidos.add(jugador);
					
			} 
			}
		}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				for(int i=0;i<alapivotRepetidos.size();i++)
				{
					if(jugador2.getId().equalsIgnoreCase(alapivotRepetidos.get(i).getId()))
					{
				
						return false;
						
					}
				}
				
				
			
			
			return true;
		
		




	}


	private boolean comprobarAlero(Jugador jugador2)
	{
		
		st=BaseDeDatos.getStatement();
		String sentencia="select * from defensasSalidos";
		aleroRepetidos.clear();
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			if(rs.isFirst()==false)
			{
				return true;
			}
			else
			{
				while(rs.next())
					{
				jugador=new Jugador();
				
				jugador.setId(rs.getString("id"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEquipo(rs.getString("equipo"));
				jugador.setPosicion(rs.getString("posicion"));
				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				jugador.setPrecio(rs.getInt("precio"));
				
				aleroRepetidos.add(jugador);
					
			} 
			}
		}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				for(int i=0;i<aleroRepetidos.size();i++)
				{
					if(jugador2.getId().equalsIgnoreCase(aleroRepetidos.get(i).getId()))
					{
				
						return false;
						
					}
				}
				
				
			
			
			return true;
		
		




	}


	private boolean comprobarEscolta(Jugador jugador2)
	{

		st=BaseDeDatos.getStatement();
		String sentencia="select * from escoltasSalidos";
		escoltaRepetidos.clear();
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			if(rs.isFirst()==false)
			{
				return true;
			}
			else
			{
				while(rs.next())
					{
				jugador=new Jugador();
				
				jugador.setId(rs.getString("id"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEquipo(rs.getString("equipo"));
				jugador.setPosicion(rs.getString("posicion"));
				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				jugador.setPrecio(rs.getInt("precio"));

				escoltaRepetidos.add(jugador);
					
			} 
			}
		}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				for(int i=0;i<escoltaRepetidos.size();i++)
				{
					if(jugador2.getId().equalsIgnoreCase(escoltaRepetidos.get(i).getId()))
					{
				
						return false;
						
					}
				}
				
				
			
			
			return true;
		
		






	}

	private boolean comprobarBase(Jugador jugador2) {
		
		
		st=BaseDeDatos.getStatement();
		String sentencia="select * from basesSalidos";
		baseRepetidos.clear();
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			if(rs.isFirst()==false)
			{
				return true;
			}
			else
			{
				while(rs.next())
					{
				jugador=new Jugador();
				
				jugador.setId(rs.getString("id"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEquipo(rs.getString("equipo"));
				jugador.setPosicion(rs.getString("posicion"));
				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				
				baseRepetidos.add(jugador);
					
			} 
			}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				for(int i=0;i<baseRepetidos.size();i++)
				{
					if(jugador2.getId().equalsIgnoreCase(baseRepetidos.get(i).getId()))
					{
				
						return false;
						
					}
				}
				
				
			
			
			return true;
		
		
	}
	
	private boolean comprobarPivot(Jugador jugador2)
	{
		st=BaseDeDatos.getStatement();
		String sentencia="select * from pivotSalidos";
		pivotRepetidos.clear();
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			if(rs.first()==false)
			{
				return true;
			}
			else
			{
				while(rs.next())
					{
				jugador=new Jugador();
				
				jugador.setId(rs.getString("id"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEquipo(rs.getString("equipo"));
				jugador.setPosicion(rs.getString("posicion"));
				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				jugador.setPrecio(rs.getInt("precio"));

				pivotRepetidos.add(jugador);
					
			} 
			}
		}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				for(int i=0;i<pivotRepetidos.size();i++)
				{
					if(jugador2.getId().equalsIgnoreCase(pivotRepetidos.get(i).getId()))
					{
				
						return false;
						
					}
				}
				
				
			
			
			return true;
		
		
	}

	
	
		public  void cargarJugadoresPosicion() {
		st=BaseDeDatos.getStatement();
		String sentencia="select * from jugadores";
		todosJugadores=new ArrayList<Jugador>();
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			while(rs.next())
			{
				jugador=new Jugador();
				
				jugador.setId(rs.getString("id"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEquipo(rs.getString("equipo"));
				jugador.setPosicion(rs.getString("posicion"));
				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				jugador.setPrecio(rs.getInt("precio"));

				todosJugadores.add(jugador);
				
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i=0;i<todosJugadores.size();i++){
			if(todosJugadores.get(i).getPosicion().equalsIgnoreCase("BA"))	{
				base.add(todosJugadores.get(i));
			}else{
				if(todosJugadores.get(i).getPosicion().equalsIgnoreCase("ES"))	{
					escolta.add(todosJugadores.get(i));	
					}else{
					if(todosJugadores.get(i).getPosicion().equalsIgnoreCase("AL"))	{
						alero.add(todosJugadores.get(i));	
						}else{
						if(todosJugadores.get(i).getPosicion().equalsIgnoreCase("AP")){
						alapivot.add(todosJugadores.get(i));}
					    else
						pivot.add(todosJugadores.get(i));
					    }
				    }
				System.out.println(todosJugadores.get(i).getPosicion());
			}
		}
		
		
	}*/



		
}
