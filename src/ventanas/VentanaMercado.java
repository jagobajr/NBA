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
import main.VentanaComprar;

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMercado frame = new VentanaMercado();
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
	public VentanaMercado() {
		
		ConfigureCloseWindow();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 471);
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
				VentanaComprar nuevaVentana = new VentanaComprar();
				nuevaVentana.setVisible(true);
				VentanaMercado.this.dispose();
			}
			
		});
		btnComprar.setBounds(53, 98, 316, 81);
		contentPane.add(btnComprar);
		
		JButton btnVender = new JButton("VENDER");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaVender nuevaVentana = new VentanaVender();
				nuevaVentana.setVisible(true);
				VentanaMercado.this.dispose();
			}
			
		});
		btnVender.setBounds(53, 175, 316, 89);
		contentPane.add(btnVender);
		
		JButton btnActividad = new JButton("NOTICIAS");
		btnActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalNoticias nuevaVentana = new JInternalNoticias();
				nuevaVentana.setVisible(true);
				VentanaMercado.this.dispose();
			}
			
		});
		btnActividad.setBounds(53, 257, 316, 89);
		contentPane.add(btnActividad);
		
		JLabel lblMercado = new JLabel("MERCADO");
		lblMercado.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMercado.setBounds(150, 29, 134, 37);
		contentPane.add(lblMercado);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes/screen-4.jpg"));
		label.setBounds(0, 0, 446, 523);
		contentPane.add(label);
	}
}
