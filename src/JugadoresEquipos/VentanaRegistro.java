package JugadoresEquipos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import NBA.VentanaMenu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		
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

			                       mod.setId(modSql.dameUltimoRegistro());
			                        mod.setUsuario(datos_usuario.getText());
			                        mod.setContra(nuevoPass);
			                        mod.setCorreo(correo.getText());

			                        if (modSql.registrar(mod)) {
			                            JOptionPane.showMessageDialog(null, "Registro Guardado");
			                            VentanaMenu nuevaVentana = new VentanaMenu();
			    			            nuevaVentana.setVisible(true);
			    			            VentanaRegistro.this.dispose();
			                            limpiar();
			                        } else {
			                            JOptionPane.showMessageDialog(null, "Error al Guardar");
			                            limpiar();
			                        }
			                    } else {
			                        JOptionPane.showMessageDialog(null, "El email es incorrecto");
			                    }
			                } else {
			                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
			                }

				}else {
					JOptionPane.showMessageDialog(null,"Las contrase�as no coinciden");
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
		label.setIcon(new ImageIcon("/Users/jagoba.jr/Downloads/thumb-1920-467394.jpg"));
		label.setBounds(-336, 0, 716, 400);
		contentPane.add(label);
		
		
		BaseDeDatos.crearTablaUsuarios();
		BaseDeDatos.crearTablaBasesSalidos();
		BaseDeDatos.crearTablaEscoltasSalidos();
		BaseDeDatos.crearTablaAlerosSalidos();
		BaseDeDatos.crearTablaAlapivotSalidos();
		BaseDeDatos.crearTablaPivotSalidos();

	
		//cargarJugadoresPosicion();
	}
	
	public void asignarjugadores(String ID) {
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
		}while(chequearPortero(base.get(posicionBase))==false);
		
		
		if(chequearPortero(base.get(posicionBase))==true)
			{
				System.out.println("Base: "+base.get(posicionBase).getNombre());
				
				String sentencia2="insert into usuarioJugadores values ('"+ID+"', '"+base.get(posicionBase).getId()+"')";
				
				String sentencia="insert into porterosSalidos values"
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			
		
			
		
		
		for(int i=0;i<4;i++)
		{
			posicionEscolta=rnd.nextInt(escolta.size()-1);
			posicionEscolta=rnd.nextInt(alero.size()-1);
			
			System.out.println("medios: "+escolta.get(posicionEscolta).getNombre());
			
			
			do{
				
				posicionEscolta=rnd.nextInt(escolta.size()-1);
				
			}while(chequearMedios(escolta.get(posicionEscolta))==false);
			
			if(chequearMedios(escolta.get(posicionEscolta))==true)
			{
				String sentencia="insert into mediosSalidos values"
						+ "('"+escolta.get(posicionEscolta).getId()
						+"', '"+escolta.get(posicionEscolta).getNombre()
						+"', '"+escolta.get(posicionEscolta).getEquipo()
						+"', '"+escolta.get(posicionEscolta).getPosicion()
						+"', '"+escolta.get(posicionEscolta).getPuntosJornada()
						+"', '"+escolta.get(posicionEscolta).getPuntosTotales()
						+"', '"+escolta.get(posicionEscolta).getPrecio()
						+"')";	
				String sentencia2="insert into usuarioJugadores values ('"+ID+"', '"+medios.get(posMedio).getId()+"')";
				System.out.println(sentencia);
				System.out.println(sentencia2);
				
				try {
					st.executeUpdate(sentencia);
					st.executeUpdate(sentencia2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
				
			
			
			
			System.out.println("defensas: "+alero.get(posicionAlero).getNombre());
			
			
			do{
			
				posicionAlero=rnd.nextInt(alero.size()-1);
			
			}while(chequearDefensas(alero.get(posicionAlero))==false);
			
			if(chequearDefensas(alero.get(posicionAlero))==true)
			{

				String sentencia="insert into defensasSalidos values"
						+ "('"+alero.get(posicionAlero).getId()
						+"', '"+alero.get(posicionAlero).getNombre()
						+"', '"+alero.get(posicionAlero).getEquipo()
						+"', '"+alero.get(posicionAlero).getPosicion()
						+"', '"+alero.get(posicionAlero).getPuntosJornada()
						+"', '"+alero.get(posicionAlero).getPuntosTotales()
						+"', '"+alero.get(posicionAlero).getPrecio()
						+"')";	
				System.out.println(sentencia);
				String sentencia3="insert into usuarioJugadores values ('"+ID+"', '"+defensas.get(posDefensa).getId()+"')";
				System.out.println(sentencia3);
				
				try {
					st.executeUpdate(sentencia);
					st.executeUpdate(sentencia3);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		for(int i=0;i<2;i++)
		{
			posDelantero=rnd.nextInt(delanteros.size()-1);
			System.out.println("delanteros: "+delanteros.get(posDelantero).getNombre());
			
			do
			{
				posDelantero=rnd.nextInt(delanteros.size()-1);
			}while(chequearDelantero(delanteros.get(posDelantero))==false);
			
		
			
			if(chequearDelantero(delanteros.get(posDelantero))==true)
			{

				String sentencia="insert into delanterosSalidos values"
						+ "('"+delanteros.get(posDelantero).getId()
						+"', '"+delanteros.get(posDelantero).getNombre()
						+"', '"+delanteros.get(posDelantero).getEquipo()
						+"', '"+delanteros.get(posDelantero).getPosicion()
						+"', '"+delanteros.get(posDelantero).getEdad()
						+"', '"+delanteros.get(posDelantero).getPuntosJornada()
						+"', '"+delanteros.get(posDelantero).getPuntosTotales()
						+"')";	
				System.out.println(sentencia);
				String sentencia2="insert into usuarioJugadores values ('"+ID+"', '"+delanteros.get(posDelantero).getId()+"')";
				try {
					st.executeUpdate(sentencia);
					st.executeUpdate(sentencia2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			}
					
		}
		
}
