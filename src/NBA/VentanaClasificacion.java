package NBA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class VentanaClasificacion extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nombre;
	private JTextField puntos_1;
	private JTextField txt_nombre2;
	private JTextField txt_nombre3;
	private JTextField txt_nombre4;
	private JTextField txt_nombre5;
	private JTextField txt_nombre6;
	private JTextField txt_nombre7;
	private JTextField txt_nombre8;
	private JTextField txt_nombre9;
	private JTextField txt_nombre10;
	private JTextField puntos_2;
	private JTextField puntos_3;
	private JTextField puntos_4;
	private JTextField puntos_5;
	private JTextField puntos_6;
	private JTextField puntos_7;
	private JTextField puntos_8;
	private JTextField puntos_9;
	private JTextField puntos_10;

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

	/**
	 * Create the frame.
	 */
	public VentanaClasificacion() {
		setTitle("CLASIFICACION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPos = new JLabel("POS");
		lblPos.setBounds(84, 48, 61, 16);
		contentPane.add(lblPos);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(157, 48, 61, 16);
		contentPane.add(lblNombre);
		
		JLabel lblPuntos = new JLabel("PUNTOS");
		lblPuntos.setBounds(262, 48, 61, 16);
		contentPane.add(lblPuntos);
		
		JLabel label = new JLabel("1");
		label.setBounds(84, 88, 61, 16);
		contentPane.add(label);
		
		txt_nombre = new JTextField();
		txt_nombre.setBounds(119, 83, 130, 26);
		contentPane.add(txt_nombre);
		txt_nombre.setColumns(10);
		
		JLabel label_1 = new JLabel("2");
		label_1.setBounds(84, 116, 61, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setBounds(84, 144, 61, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("4");
		label_3.setBounds(84, 172, 61, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("5");
		label_4.setBounds(84, 200, 61, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("6");
		label_5.setBounds(84, 228, 61, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("7");
		label_6.setBounds(84, 256, 61, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("8");
		label_7.setBounds(84, 284, 61, 16);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("9");
		label_8.setBounds(84, 312, 61, 16);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("10");
		label_9.setBounds(84, 340, 61, 16);
		contentPane.add(label_9);
		
		puntos_1 = new JTextField();
		puntos_1.setColumns(10);
		puntos_1.setBounds(262, 83, 51, 26);
		contentPane.add(puntos_1);
		
		txt_nombre2 = new JTextField();
		txt_nombre2.setColumns(10);
		txt_nombre2.setBounds(119, 111, 130, 26);
		contentPane.add(txt_nombre2);
		
		txt_nombre3 = new JTextField();
		txt_nombre3.setColumns(10);
		txt_nombre3.setBounds(119, 139, 130, 26);
		contentPane.add(txt_nombre3);
		
		txt_nombre4 = new JTextField();
		txt_nombre4.setColumns(10);
		txt_nombre4.setBounds(119, 167, 130, 26);
		contentPane.add(txt_nombre4);
		
		txt_nombre5 = new JTextField();
		txt_nombre5.setColumns(10);
		txt_nombre5.setBounds(119, 195, 130, 26);
		contentPane.add(txt_nombre5);
		
		txt_nombre6 = new JTextField();
		txt_nombre6.setColumns(10);
		txt_nombre6.setBounds(119, 223, 130, 26);
		contentPane.add(txt_nombre6);
		
		txt_nombre7 = new JTextField();
		txt_nombre7.setColumns(10);
		txt_nombre7.setBounds(119, 251, 130, 26);
		contentPane.add(txt_nombre7);
		
		txt_nombre8 = new JTextField();
		txt_nombre8.setColumns(10);
		txt_nombre8.setBounds(119, 279, 130, 26);
		contentPane.add(txt_nombre8);
		
		txt_nombre9 = new JTextField();
		txt_nombre9.setColumns(10);
		txt_nombre9.setBounds(119, 307, 130, 26);
		contentPane.add(txt_nombre9);
		
		txt_nombre10 = new JTextField();
		txt_nombre10.setColumns(10);
		txt_nombre10.setBounds(119, 335, 130, 26);
		contentPane.add(txt_nombre10);
		
		puntos_2 = new JTextField();
		puntos_2.setColumns(10);
		puntos_2.setBounds(262, 111, 51, 26);
		contentPane.add(puntos_2);
		
		puntos_3 = new JTextField();
		puntos_3.setColumns(10);
		puntos_3.setBounds(262, 139, 51, 26);
		contentPane.add(puntos_3);
		
		puntos_4 = new JTextField();
		puntos_4.setColumns(10);
		puntos_4.setBounds(262, 167, 51, 26);
		contentPane.add(puntos_4);
		
		puntos_5 = new JTextField();
		puntos_5.setColumns(10);
		puntos_5.setBounds(262, 195, 51, 26);
		contentPane.add(puntos_5);
		
		puntos_6 = new JTextField();
		puntos_6.setColumns(10);
		puntos_6.setBounds(262, 223, 51, 26);
		contentPane.add(puntos_6);
		
		puntos_7 = new JTextField();
		puntos_7.setColumns(10);
		puntos_7.setBounds(262, 251, 51, 26);
		contentPane.add(puntos_7);
		
		puntos_8 = new JTextField();
		puntos_8.setColumns(10);
		puntos_8.setBounds(262, 279, 51, 26);
		contentPane.add(puntos_8);
		
		puntos_9 = new JTextField();
		puntos_9.setColumns(10);
		puntos_9.setBounds(262, 307, 51, 26);
		contentPane.add(puntos_9);
		
		puntos_10 = new JTextField();
		puntos_10.setColumns(10);
		puntos_10.setBounds(262, 335, 51, 26);
		contentPane.add(puntos_10);
	}
}