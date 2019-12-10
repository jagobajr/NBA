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
import java.awt.Font;
import javax.swing.ImageIcon;

public class VentanaComprar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaComprar frame = new VentanaComprar();
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
	public VentanaComprar() {
		setTitle("COMPRAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombrePuntosPrecio = new JLabel("Nombre  Puntos  Precio  Finaliza en  Media");
		lblNombrePuntosPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePuntosPrecio.setBounds(20, 67, 285, 14);
		contentPane.add(lblNombrePuntosPrecio);
		
		JPanel panelJugador = new JPanel();
		panelJugador.setBackground(new Color(245, 255, 250));
		panelJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelJugador.setBounds(10, 92, 295, 73);
		contentPane.add(panelJugador);
		panelJugador.setLayout(null);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(0, 0, 46, 73);
		panelJugador.add(lblImagen);
		
		Label labelNomJugador = new Label("Nombre Jugador\r\n");
		labelNomJugador.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 12));
		labelNomJugador.setForeground(Color.BLACK);
		labelNomJugador.setBounds(52, 10, 92, 27);
		panelJugador.add(labelNomJugador);
		
		Label label_PrecioJug = new Label("Precio del jugador\r\n\r\n");
		label_PrecioJug.setBounds(52, 41, 92, 22);
		panelJugador.add(label_PrecioJug);
		
		Label label_Cont = new Label("Contador\r\n");
		label_Cont.setBounds(302, 15, 52, 22);
		panelJugador.add(label_Cont);
		
		Label label_Puntos = new Label("Puntos\r\n");
		label_Puntos.setBounds(312, 36, 42, 27);
		panelJugador.add(label_Puntos);
		
		JPanel panel_jug2 = new JPanel();
		panel_jug2.setBackground(new Color(245, 255, 250));
		panel_jug2.setLayout(null);
		panel_jug2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_jug2.setBounds(10, 166, 295, 73);
		contentPane.add(panel_jug2);
		
		JLabel label_4 = new JLabel("Imagen");
		label_4.setBounds(0, 0, 46, 73);
		panel_jug2.add(label_4);
		
		Label label_5 = new Label("Nombre Jugador\r\n");
		label_5.setBounds(52, 10, 92, 27);
		panel_jug2.add(label_5);
		
		Label label_6 = new Label("Precio del jugador\r\n\r\n");
		label_6.setBounds(52, 41, 92, 22);
		panel_jug2.add(label_6);
		
		Label label_7 = new Label("Contador\r\n");
		label_7.setBounds(302, 15, 52, 22);
		panel_jug2.add(label_7);
		
		Label label_8 = new Label("Puntos\r\n");
		label_8.setBounds(312, 36, 42, 27);
		panel_jug2.add(label_8);
		
		JPanel panel_jug3 = new JPanel();
		panel_jug3.setBackground(new Color(245, 255, 250));
		panel_jug3.setLayout(null);
		panel_jug3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_jug3.setBounds(10, 241, 295, 73);
		contentPane.add(panel_jug3);
		
		JLabel label_9 = new JLabel("Imagen");
		label_9.setBounds(0, 0, 46, 73);
		panel_jug3.add(label_9);
		
		Label label_10 = new Label("Nombre Jugador\r\n");
		label_10.setBounds(52, 10, 92, 27);
		panel_jug3.add(label_10);
		
		Label label_11 = new Label("Precio del jugador\r\n\r\n");
		label_11.setBounds(52, 41, 92, 22);
		panel_jug3.add(label_11);
		
		Label label_12 = new Label("Contador\r\n");
		label_12.setBounds(302, 15, 52, 22);
		panel_jug3.add(label_12);
		
		Label label_13 = new Label("Puntos\r\n");
		label_13.setBounds(312, 36, 42, 27);
		panel_jug3.add(label_13);
		
		JPanel panel_jug4 = new JPanel();
		panel_jug4.setBackground(new Color(245, 255, 250));
		panel_jug4.setLayout(null);
		panel_jug4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_jug4.setBounds(10, 316, 295, 73);
		contentPane.add(panel_jug4);
		
		JLabel label_14 = new JLabel("Imagen");
		label_14.setBounds(0, 0, 46, 73);
		panel_jug4.add(label_14);
		
		Label label_15 = new Label("Nombre Jugador\r\n");
		label_15.setBounds(52, 10, 92, 27);
		panel_jug4.add(label_15);
		
		Label label_16 = new Label("Precio del jugador\r\n\r\n");
		label_16.setBounds(52, 41, 92, 22);
		panel_jug4.add(label_16);
		
		Label label_17 = new Label("Contador\r\n");
		label_17.setBounds(302, 15, 52, 22);
		panel_jug4.add(label_17);
		
		Label label_18 = new Label("Puntos\r\n");
		label_18.setBounds(312, 36, 42, 27);
		panel_jug4.add(label_18);
		
		Panel panel_jug5 = new Panel();
		panel_jug5.setBackground(new Color(230, 230, 250));
		panel_jug5.setBounds(10, 395, 295, 60);
		contentPane.add(panel_jug5);
		panel_jug5.setLayout(null);
		
		Label panel_fondos = new Label("Fondos:");
		panel_fondos.setBounds(10, 10, 47, 22);
		panel_jug5.add(panel_fondos);
		
		Label label_ofertas = new Label("Ofertas:\r\n");
		label_ofertas.setBounds(10, 28, 47, 22);
		panel_jug5.add(label_ofertas);
		
		Label label_dinero = new Label("Dinero\r\n");
		label_dinero.setBounds(57, 10, 53, 22);
		panel_jug5.add(label_dinero);
		
		Label panel_dinero2 = new Label("Dinero\r\n");
		panel_dinero2.setBounds(57, 28, 62, 22);
		panel_jug5.add(panel_dinero2);
		
		Label label_pujaMax = new Label("Puja maxima:\r\n");
		label_pujaMax.setBounds(184, 10, 69, 22);
		panel_jug5.add(label_pujaMax);
		
		Label label_balance = new Label("Balance:");
		label_balance.setBounds(204, 28, 47, 22);
		panel_jug5.add(label_balance);
		
		Label label_dinero3 = new Label("Dinero\r\n");
		label_dinero3.setBounds(252, 10, 53, 22);
		panel_jug5.add(label_dinero3);
		
		Label label_dinero4 = new Label("Dinero\r\n");
		label_dinero4.setBounds(252, 28, 53, 22);
		panel_jug5.add(label_dinero4);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMercado nuevaVentana = new VentanaMercado();
				nuevaVentana.setVisible(true);
				VentanaComprar.this.dispose();
			}
			
		});
		btnAtras.setBounds(10, 6, 115, 22);
		contentPane.add(btnAtras);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMenu nuevaVentana = new VentanaMenu();
				nuevaVentana.setVisible(true);
				VentanaComprar.this.dispose();
			}
			
		});
		btnMenu.setBounds(10, 29, 115, 22);
		contentPane.add(btnMenu);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/Users/jagoba.jr/Downloads/thumb2-damian-lillard-nba-white-uniform-portland-trail-blazers-basketball-stars.jpg.png"));
		label.setBounds(-186, -73, 510, 628);
		contentPane.add(label);
	}
}
 