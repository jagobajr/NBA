package main;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import main.Usuarios;
import ventanas.VentanaMercado;

public class ventanDeCompra extends JFrame implements ActionListener {
	
	
	
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
    private Statement st=null;
    private JSpinner spinner;
    private ArrayList<Jugador>listaJ;
    private ArrayList mercado;
    private ArrayList usuarios;
    private ArrayList puntosJornada;
    private Jugador jugador;
    private JTextField textFieldEdad;
    private JTextField textFieldPrecio;
    private JLabel lblPrecio;
    private JButton btnComprar;
    private Usuarios usu;
    private JTextField textField;
    private ArrayList mercadoId;
    private JLabel lblNewLabel;
    private JTextField ids;
    private JLabel label;
    
   
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 ventanDeCompra frame = new ventanDeCompra();
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
	public ventanDeCompra()  {
		
		BaseDeDatos.initBD();
		BaseDeDatos.crearTablaMercadoDeFichajes();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1392, 828);
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
					
					ids.setText(""+listaJ.get(pos).getId());
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
		
		JLabel lblEstosSonLos_1 = new JLabel("Estos son los datos del jugador que has seleccionado");
		lblEstosSonLos_1.setForeground(Color.WHITE);
		lblEstosSonLos_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEstosSonLos_1.setBounds(394, 424, 406, 14);
		contentPane.add(lblEstosSonLos_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(394, 472, 60, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setForeground(Color.WHITE);
		lblEquipo.setBounds(614, 472, 46, 14);
		contentPane.add(lblEquipo);
		
		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setForeground(Color.WHITE);
		lblPosicion.setBounds(800, 472, 60, 14);
		contentPane.add(lblPosicion);
		
		JLabel lblPuntosDeEsta = new JLabel("Precio");
		lblPuntosDeEsta.setForeground(Color.WHITE);
		lblPuntosDeEsta.setBounds(909, 472, 103, 14);
		contentPane.add(lblPuntosDeEsta);
		
		JLabel lblPuntosTotales = new JLabel("Puntos Totales");
		lblPuntosTotales.setForeground(Color.WHITE);
		lblPuntosTotales.setBounds(1083, 472, 95, 14);
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
		
		
		
		
		
		
		textFieldEdad = new JTextField();
		textFieldEdad.setEditable(false);
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(912, 515, 103, 20);
		contentPane.add(textFieldEdad);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(803, 565, 177, 23);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		lblPrecio = new JLabel("INTRODUCE CANTIDAD ");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setBounds(617, 565, 164, 23);
		contentPane.add(lblPrecio);
		lblPrecio.setVisible(true);
		
		btnComprar = new JButton("COMPRAR");
		btnComprar.setBounds(1025, 564, 117, 29);
		contentPane.add(btnComprar);
		
		textField = new JTextField();
		textField.setBounds(803, 637, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		//EL PROBLEMA ES QUE NO VA EL BOTON DE COMPRAR YA QUE CUANDO PONES EL CODIGO DE ABAJO NO FUNCIONA LA VENTANA Y SUPONGO QUE ENTONCES HABRA ALGO MAL EN EL METODO
		//cargarDineroUsuario(usu.getIdUsuario());

		
		cargarJugadoresMercado();
		
		
		
		cargarJugadoresEnLista();
		//comprar(variablesGlobales.getIdUsu());
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					comprar(variablesGlobales.getIdUsu());
			}
				
		});
		//btnComprar.setActionCommand("comprar");
		
		lblNewLabel = new JLabel("Tu dinero:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(701, 642, 80, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMercado nuevaVentana = new VentanaMercado();
				nuevaVentana.setVisible(true);
				ventanDeCompra.this.dispose();
			}
				
		});
		btnAtras.setBounds(49, 676, 117, 29);
		contentPane.add(btnAtras);
		
		ids = new JTextField();
		ids.setBounds(378, 564, 130, 26);
		contentPane.add(ids);
		ids.setColumns(10);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes/screen-10.jpg"));
		label.setBounds(6, -54, 1633, 1272);
		contentPane.add(label);
		
		
		
	
	}
	

	private void cargarJugadoresEnLista() 
	{
			st=BaseDeDatos.getStatement();			
			String jugadores;
			try {
				jugadores="select * from mercadoDeFichajes";
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
					jugador.setPrecio(rs.getInt(3));
					jugador.setId(rs.getString(1));
					jugador.setPuntosTotales(rs.getInt(4));
					
					
					
				//modelo.addElement(rs.getString("nombre"));
				
				listaJ.add(jugador);
				modelo.addElement(rs.getString("nombre"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
	
public void comprar(String idUsuario) {
		
		BaseDeDatos.initBD();
		
		String sentSQL = "";
	
		
	 variablesGlobales idVg;
		
	 int a = VentanaLogin.getUsuarioId();
		
				
		//if(esNumerico(textFieldPrecio.toString())) {
			int valorCompra= Integer.valueOf(textFieldPrecio.toString());
			
			if(valorCompra > Integer.parseInt(textFieldEdad.getText())){
				//String sentencia="select * from mercadoDeFichajes";
				try {
					sentSQL = "insert into usuJugadores (" + a + "," +ids.getText()+ ","+textFieldNombre.getText()+","+textFieldPuntosTotales.getText()+")" ;
					
					int val = ((java.sql.Statement) st).executeUpdate( sentSQL );
					log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
					if (val!=1) {  // Se tiene que a�adir 1 - error si no
						log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
					}
					
					sentSQL = "delete from mercadoFichajes where nombre = " +textFieldNombre.getText();
					
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
		//}else {
		//	JOptionPane.showMessageDialog(null, "El valor debe ser un numero");
		//}

		
			}

private void log(Level info, String string, Object object) {
	// TODO Auto-generated method stub
	
}


/*
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

*/

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

	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
		case "comprar":
			
			try
			{
				
				
				
				int p1=Integer.parseInt(textFieldPrecio.getText());
				
			
				//ESTO ESTA PUESTO PUES PARA HABER SI IBA LO DE ABAJO ES LO TUYO PERO ME DA ERROR
			if(p1>5)
			//if(p1<cargarDineroUsuario((String)label.getText()))
			{
				
			
			
				//ESTO ESTA PUESTO PUES PARA HABER SI IBA LO DE ABAJO ES LO TUYO PERO ME DA ERROR
			if(p1>=1000)
			//if(p1<=p2)
			{
				JOptionPane.showMessageDialog(null, " has fichado a "+modelo.getElementAt(lista.getSelectedIndex()));
			
			 st = (Statement) BaseDeDatos.getStatement();
			
			String sentencia="insert into usujugadores values('"+textField.getText()+"', '"+mercadoId.get(lista.getSelectedIndex())+"')";
			String sentencia2="delete from mercadodefichajes where idJugador = '"+mercadoId.get(lista.getSelectedIndex())+"'";
			
			int dinero=cargarDineroUsuario(usu.getIdUsuario());
			int dinero2=dinero-p1;
			
			String sentencia3="update usuarios set dinero ='"+dinero2+"' where id ='"+textField.getText()+"'";
			

			
				((java.sql.Statement) st).executeUpdate(sentencia);
				((java.sql.Statement) st).executeUpdate(sentencia2);
				((java.sql.Statement) st).executeUpdate(sentencia3);
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
				JOptionPane.showMessageDialog(null, "inserta numeros l�gicos por favor, puede que haya introducido una cantidad muy elevada, o puede que haya introducido texto,en vez de cifras");
			}
			
			}
			
		
		
			
		
		}
}
