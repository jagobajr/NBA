package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.LogController;
import main.VentanaEquipo;
import main.VentanaLogin;
import main.VentanaAlineacion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
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
	
	public VentanaMenu() {
		
		ConfigureCloseWindow();
		setBackground(new Color(105, 105, 105));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Gurmukhi MN", Font.BOLD, 16));
		lblMenu.setForeground(Color.BLACK);
		lblMenu.setBounds(41, 45, 142, 47);
		contentPane.add(lblMenu);
		
		JButton btnClasificacion = new JButton("CLASIFICACION");
		btnClasificacion.setBackground(UIManager.getColor("Button.background"));
		btnClasificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaClasificacion nuevaVentana = new VentanaClasificacion();
				nuevaVentana.setVisible(true);
				VentanaMenu.this.dispose();

			}
		});
		btnClasificacion.setForeground(Color.BLACK);
		btnClasificacion.setBounds(41, 190, 218, 57);
		contentPane.add(btnClasificacion);
		
		JButton btnEquipo = new JButton("PLANTILLA");
		btnEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//VentanaEquipo ventanaQuinteto= new VentanaEquipo();
				VentanaAlineacion ventanaQuinteto= new VentanaAlineacion();
				ventanaQuinteto.setVisible(true);
				VentanaMenu.this.dispose();
			}
		});
		
		btnEquipo.setBounds(41, 259, 218, 47);
		contentPane.add(btnEquipo);
		
		
		
		
		JButton btnMercado = new JButton("MERCADO");
		btnMercado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMercado nuevaVentana = new VentanaMercado();
				nuevaVentana.setVisible(true);
				VentanaMenu.this.dispose();
			}
				
		});
		btnMercado.setBounds(41, 318, 218, 57);
		contentPane.add(btnMercado);
		
		JButton btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLogin logout= new VentanaLogin();
				logout.setVisible(true);
				VentanaMenu.this.dispose();
			}
		});
		
		btnCerrarSesion.setBounds(6, 415, 142, 42);
		contentPane.add(btnCerrarSesion);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes/lebron-james-1024x768-basketball-player-artwork-hd-5k-14460.jpg"));
		label.setBounds(-332, 0, 656, 624);
		contentPane.add(label);
		
		
	}

}
