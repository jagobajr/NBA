package NBA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;

public class VentanaVender extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVender frame = new VentanaVender();
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
	public VentanaVender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 523);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 16, 115, 22);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMercado nuevaVentana = new VentanaMercado();
				nuevaVentana.setVisible(true);
				VentanaVender.this.dispose();
				
			}
			
		});
		contentPane.setLayout(null);
		contentPane.add(btnAtras);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(15, 41, 115, 22);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMenu nuevaVentana = new VentanaMenu();
				nuevaVentana.setVisible(true);
				VentanaVender.this.dispose();
			}
			
		});
		contentPane.add(btnMenu);
		
		JLabel lblNewLabel = new JLabel("                                       VENDER");
		lblNewLabel.setBounds(0, 79, 438, 20);
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLACK);
		contentPane.add(lblNewLabel);
	}
}
