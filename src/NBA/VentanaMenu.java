package NBA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import NBA.login.VentanaLogin;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public VentanaMenu() {
		setBackground(new Color(105, 105, 105));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 231, 405);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Gurmukhi MN", Font.BOLD, 16));
		lblMenu.setForeground(new Color(248, 248, 255));
		lblMenu.setBounds(82, 24, 142, 47);
		contentPane.add(lblMenu);
		
		JButton btnClasificacion = new JButton("CLASIFICACION");
		btnClasificacion.setBackground(Color.WHITE);
		btnClasificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaClasificacion nuevaVentana = new VentanaClasificacion();
				nuevaVentana.setVisible(true);
				VentanaMenu.this.dispose();

			}
		});
		btnClasificacion.setForeground(Color.BLACK);
		btnClasificacion.setBounds(6, 95, 218, 57);
		contentPane.add(btnClasificacion);
		
		JButton btnEquipo = new JButton("PLANTILLA");
		btnEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaEquipo ventanaQuinteto= new VentanaEquipo();
				ventanaQuinteto.setVisible(true);
				VentanaMenu.this.dispose();
			}
		});
		
		btnEquipo.setBounds(6, 147, 218, 47);
		contentPane.add(btnEquipo);
		
		
		
		
		JButton btnMercado = new JButton("MERCADO");
		btnMercado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMercado nuevaVentana = new VentanaMercado();
				nuevaVentana.setVisible(true);
				VentanaMenu.this.dispose();
			}
				
		});
		btnMercado.setBounds(6, 189, 218, 57);
		contentPane.add(btnMercado);
		
		JButton btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLogin logout= new VentanaLogin();
				logout.setVisible(true);
				VentanaMenu.this.dispose();
			}
		});
		
		btnCerrarSesion.setBounds(38, 291, 142, 42);
		contentPane.add(btnCerrarSesion);
	}

}
