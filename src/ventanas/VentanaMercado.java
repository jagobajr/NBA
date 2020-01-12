package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.JInternalNoticias;
import main.LogController;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VentanaMercado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
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
	public VentanaMercado() {
		
		ConfigureCloseWindow();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 638);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMenu nuevaVentana = new VentanaMenu();
				nuevaVentana.setVisible(true);
				VentanaMercado.this.dispose();
			}
			
		});
		btnMenu.setBounds(0, 0, 115, 29);
		contentPane.add(btnMenu);
		
		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanDeCompra nuevaVentana = new ventanDeCompra();
				nuevaVentana.setVisible(true);
				VentanaMercado.this.dispose();
			}
			
		});
		btnComprar.setBounds(53, 130, 316, 81);
		contentPane.add(btnComprar);
		
		JButton btnActividad = new JButton("NOTICIAS");
		btnActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalNoticias nuevaVentana = new JInternalNoticias();
				nuevaVentana.setVisible(true);
				VentanaMercado.this.dispose();
			}
			
		});
		btnActividad.setBounds(53, 304, 316, 89);
		contentPane.add(btnActividad);
		
		JLabel lblMercado = new JLabel("MERCADO");
		lblMercado.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMercado.setBounds(168, 29, 134, 37);
		contentPane.add(lblMercado);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes/screen-4.jpg"));
		label.setBounds(0, 0, 461, 582);
		contentPane.add(label);
	}
}
