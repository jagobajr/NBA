package NBA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;

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

	/**
	 * Create the frame.
	 */
	public VentanaMercado() {
		setTitle("MERCADO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(10, 24, 170, 23);
		contentPane.add(btnComprar);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(176, 24, 188, 23);
		contentPane.add(btnVender);
		
		JLabel lblComprar = new JLabel("Comprar");
		lblComprar.setBounds(158, 46, 46, 14);
		contentPane.add(lblComprar);
		
		JLabel lblNombrePuntosPrecio = new JLabel("Nombre  Puntos  Precio  Finaliza en  Media");
		lblNombrePuntosPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePuntosPrecio.setBounds(20, 67, 354, 14);
		contentPane.add(lblNombrePuntosPrecio);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 92, 364, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(0, 0, 46, 73);
		panel.add(lblImagen);
		
		Label label = new Label("Nombre Jugador\r\n");
		label.setBounds(52, 10, 92, 27);
		panel.add(label);
		
		Label label_1 = new Label("Precio del jugador\r\n\r\n");
		label_1.setBounds(52, 41, 92, 22);
		panel.add(label_1);
		
		Label label_2 = new Label("Contador\r\n");
		label_2.setBounds(302, 15, 52, 22);
		panel.add(label_2);
		
		Label label_3 = new Label("Puntos\r\n");
		label_3.setBounds(312, 36, 42, 27);
		panel.add(label_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 166, 364, 73);
		contentPane.add(panel_1);
		
		JLabel label_4 = new JLabel("Imagen");
		label_4.setBounds(0, 0, 46, 73);
		panel_1.add(label_4);
		
		Label label_5 = new Label("Nombre Jugador\r\n");
		label_5.setBounds(52, 10, 92, 27);
		panel_1.add(label_5);
		
		Label label_6 = new Label("Precio del jugador\r\n\r\n");
		label_6.setBounds(52, 41, 92, 22);
		panel_1.add(label_6);
		
		Label label_7 = new Label("Contador\r\n");
		label_7.setBounds(302, 15, 52, 22);
		panel_1.add(label_7);
		
		Label label_8 = new Label("Puntos\r\n");
		label_8.setBounds(312, 36, 42, 27);
		panel_1.add(label_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 241, 364, 73);
		contentPane.add(panel_2);
		
		JLabel label_9 = new JLabel("Imagen");
		label_9.setBounds(0, 0, 46, 73);
		panel_2.add(label_9);
		
		Label label_10 = new Label("Nombre Jugador\r\n");
		label_10.setBounds(52, 10, 92, 27);
		panel_2.add(label_10);
		
		Label label_11 = new Label("Precio del jugador\r\n\r\n");
		label_11.setBounds(52, 41, 92, 22);
		panel_2.add(label_11);
		
		Label label_12 = new Label("Contador\r\n");
		label_12.setBounds(302, 15, 52, 22);
		panel_2.add(label_12);
		
		Label label_13 = new Label("Puntos\r\n");
		label_13.setBounds(312, 36, 42, 27);
		panel_2.add(label_13);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 316, 364, 73);
		contentPane.add(panel_3);
		
		JLabel label_14 = new JLabel("Imagen");
		label_14.setBounds(0, 0, 46, 73);
		panel_3.add(label_14);
		
		Label label_15 = new Label("Nombre Jugador\r\n");
		label_15.setBounds(52, 10, 92, 27);
		panel_3.add(label_15);
		
		Label label_16 = new Label("Precio del jugador\r\n\r\n");
		label_16.setBounds(52, 41, 92, 22);
		panel_3.add(label_16);
		
		Label label_17 = new Label("Contador\r\n");
		label_17.setBounds(302, 15, 52, 22);
		panel_3.add(label_17);
		
		Label label_18 = new Label("Puntos\r\n");
		label_18.setBounds(312, 36, 42, 27);
		panel_3.add(label_18);
		
		Panel panel_4 = new Panel();
		panel_4.setBounds(10, 391, 364, 60);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		Label label_19 = new Label("Fondos:");
		label_19.setBounds(10, 10, 47, 22);
		panel_4.add(label_19);
		
		Label label_20 = new Label("Ofertas:\r\n");
		label_20.setBounds(10, 28, 47, 22);
		panel_4.add(label_20);
		
		Label label_21 = new Label("Dinero\r\n");
		label_21.setBounds(57, 10, 53, 22);
		panel_4.add(label_21);
		
		Label label_22 = new Label("Dinero\r\n");
		label_22.setBounds(57, 28, 62, 22);
		panel_4.add(label_22);
		
		Label label_23 = new Label("Puja maxima:\r\n");
		label_23.setBounds(184, 10, 69, 22);
		panel_4.add(label_23);
		
		Label label_24 = new Label("Balance:");
		label_24.setBounds(204, 28, 47, 22);
		panel_4.add(label_24);
		
		Label label_25 = new Label("Dinero\r\n");
		label_25.setBounds(252, 10, 53, 22);
		panel_4.add(label_25);
		
		Label label_26 = new Label("Dinero\r\n");
		label_26.setBounds(252, 28, 53, 22);
		panel_4.add(label_26);
	}
}
 