package main;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;

import main.BaseDeDatos;
import main.VentanaAdministrador;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RepartoDinero extends JFrame implements ActionListener, ListSelectionListener{
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 RepartoDinero frame = new RepartoDinero();
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
	
	JLabel lblReparteElCapital;
	JScrollPane scrollPane;
	JList list;
	DefaultListModel modelo;
	JLabel lblDineroActualDe;
	JLabel lblcuantoDineroLe;
	JButton btnGuardar;
	Statement st=null;
	JTextField textField;
	JTextField textField_1;
	HashMap<Integer,String> map;
	ArrayList usuarios;
	
	public RepartoDinero() {
		
		ConfigureCloseWindow();
		
	
		setBounds(300,300,600,400);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RepartoDinero.class.getResource("")));
		getContentPane().setLayout(null);
		
		lblReparteElCapital = new JLabel("REPARTE EL CAPITAL ");
		lblReparteElCapital.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 18));
		lblReparteElCapital.setBounds(23, 22, 240, 14);
		getContentPane().add(lblReparteElCapital);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 55, 135, 306);
		getContentPane().add(scrollPane);
		
		list = new JList();
		modelo=new DefaultListModel();
		list.setModel(modelo);
		list.addListSelectionListener(this);
		scrollPane.setViewportView(list);
		
		lblDineroActualDe = new JLabel("DINERO ACTUAL DE ESTE USUARIO");
		lblDineroActualDe.setBounds(217, 69, 250, 14);
		getContentPane().add(lblDineroActualDe);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(227, 98, 142, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblcuantoDineroLe = new JLabel("\u00BFCUANTO DINERO LE DAMOS?");
		lblcuantoDineroLe.setBounds(217, 162, 261, 14);
		getContentPane().add(lblcuantoDineroLe);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(227, 201, 142, 29);
		getContentPane().add(textField_1);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(241, 296, 105, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("guardar");
		
		btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAdministrador nuevaVentana = new VentanaAdministrador();
				nuevaVentana.setVisible(true);
				RepartoDinero.this.dispose();
			}
				
		});
		btnAtras.setBounds(350, 293, 117, 29);
		getContentPane().add(btnAtras);
		
		usuarios=new ArrayList();
		map= new HashMap<Integer,String>();
		anyadirUsuariosALista();
		
	}


	private void anyadirUsuariosALista() {
		BaseDeDatos.initBD();
		st=BaseDeDatos.getStatement();
		modelo.clear();
		map.clear();
		usuarios.clear();
		
		
		String sentencia="select * from usuarios";
		
		ResultSet rs;
		try {
			rs = st.executeQuery(sentencia);
			while(rs.next())
			{
				modelo.addElement(rs.getString("Usuario"));
				usuarios.add(rs.getInt("Dinero"));
				map.put(rs.getInt("Dinero"), rs.getString("Usuario"));
				
			}
		} catch (SQLException e) {
			LogController.log ( Level.WARNING, "Error al a�adir jugadores a la lista " + (new Date()),e);
			e.printStackTrace();
		}
		
		
		repaint();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnAtras;
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(arg0.getActionCommand())
		{
		case "guardar":
			
			
			try {
				st=BaseDeDatos.getStatement();
				int index=list.getSelectedIndex()+1;
				int dineroTotal=Integer.parseInt(textField_1.getText())+Integer.parseInt(textField.getText());
				String sentencia="update usuarios set dinero = '"+dineroTotal+"' where idUsuario = '"+index+"'";
				System.out.println(sentencia);
				st.executeUpdate(sentencia);
				JOptionPane.showMessageDialog(null, "El usuario ahora tiene "+textField_1.getText()+" euros");
				
				dispose();
			
			}
			catch(NumberFormatException n){
				LogController.log ( Level.WARNING, "Solo son validos los numeros " + (new Date()),n);
				JOptionPane.showMessageDialog(null, "introduce numeros de verdad, por favor");
				
			}
			catch (SQLException e) {
				LogController.log ( Level.WARNING, "Error al actualizar el dinero " + (new Date()),e);
				e.printStackTrace();
			}
		}
		repaint();
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
		if(arg0.getValueIsAdjusting()==true)
		{
			textField.setText(buscarDineroUsuario(list.getSelectedIndex())+"");
			repaint();
		}
		
		
	}

	private int buscarDineroUsuario(int index) {
		int dinero=0;
		
		
		dinero=(int)usuarios.get(index);
		
	
		return dinero;
		
		
		
	}

}


