package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import main.BaseDeDatos;
import main.LogController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaClasificacion extends JFrame {

	private JPanel contentPane;
	private JLabel label_10;
    private JTable table;
 
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaClasificacion frame = new VentanaClasificacion();
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
	public VentanaClasificacion() {
		

		
		ConfigureCloseWindow();
		setTitle("CLASIFICACION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPos = new JLabel("POS");
		lblPos.setBounds(15, 48, 61, 16);
		contentPane.add(lblPos);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(90, 48, 61, 16);
		contentPane.add(lblNombre);
		
		JLabel lblPuntos = new JLabel("PUNTOS");
		lblPuntos.setBounds(191, 48, 61, 16);
		contentPane.add(lblPuntos);
		
		JLabel label = new JLabel("1");
		label.setBounds(15, 88, 61, 16);
		contentPane.add(label);
		
		/*txt_nombre1 = new JTextField();
		txt_nombre1.setBounds(58, 83, 130, 26);
		contentPane.add(txt_nombre1);
		txt_nombre1.setColumns(10);
		*/
		JLabel label_1 = new JLabel("2");
		label_1.setBounds(15, 116, 61, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setBounds(15, 144, 61, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("4");
		label_3.setBounds(15, 172, 61, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("5");
		label_4.setBounds(15, 200, 61, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("6");
		label_5.setBounds(15, 228, 61, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("7");
		label_6.setBounds(15, 256, 61, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("8");
		label_7.setBounds(15, 284, 61, 16);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("9");
		label_8.setBounds(15, 312, 61, 16);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("10");
		label_9.setBounds(15, 340, 61, 16);
		contentPane.add(label_9);
		
		
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 18));
        table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usuario", "Puntos"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		table.setBounds(65, 80, 209, 287);
		contentPane.add(table);

		
		         try {
		            DefaultTableModel modelo = new DefaultTableModel() {
		            	 @Override
		            	    public boolean isCellEditable(int row, int column) {
		            	       //all cells false
		            	       return false;
		            	    }
		            	};
		            
		            table.setModel(modelo);

		            PreparedStatement ps = null;
		            ResultSet rs = null;
		            Connection con = BaseDeDatos.initBD();

		            String sql = "SELECT Usuario, Puntos FROM usuarios order by puntos desc";
		            ps = con.prepareStatement(sql);
		            rs = ps.executeQuery();

		            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
		            int cantidadColumnas = 2;

		            modelo.addColumn("Usuario");
		            modelo.addColumn("Puntos");
		            
		           

		            

		            while (rs.next()) {
		                Object[] filas = new Object[cantidadColumnas];
		                for (int i = 0; i < cantidadColumnas; i++) {
		                    filas[i] = rs.getObject(i + 1);
		                    

		                }
			          

		                modelo.addRow(filas);
		                
		            }
		            table.setRowHeight(0, 28);
		            table.setRowHeight(1, 28);
		            table.setRowHeight(2, 28);
		            table.setRowHeight(3, 28);
		            table.setRowHeight(4, 28);
		            table.setRowHeight(5, 28);
		            table.setRowHeight(6, 28);
		            table.setRowHeight(7, 28);
		            table.setRowHeight(8, 28);
		            table.setRowHeight(9, 28);
		            


		        } catch (SQLException ex) {
		            System.err.println(ex.toString());
		        }
		    

		
	
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMenu nuevaVentana = new VentanaMenu();
				nuevaVentana.setVisible(true);
				VentanaClasificacion.this.dispose();
			}
			
		});
		btnAtras.setBounds(6, 7, 94, 29);
		contentPane.add(btnAtras);
		
		
		label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("Imagenes/graffiti-usa-nba-basketball-lebron-james-kobe-bryant-kevin-durant-team-usa-dream-team-wallpaper-508379.jpg"));
		label_10.setBounds(-267, 0, 749, 478);
		contentPane.add(label_10);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon("Imagenes/graffiti-usa-nba-basketball-lebron-james-kobe-bryant-kevin-durant-team-usa-dream-team-wallpaper-508379.jpg"));
		label_12.setBounds(65, 82, 209, 287);
		contentPane.add(label_12);
		
		
		
		
	}
}
