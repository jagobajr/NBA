package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Window.Type;

public class AbrirFicheroTexto extends JFrame {

	private JPanel contentPane;
	TextArea textArea = new TextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbrirFicheroTexto frame = new AbrirFicheroTexto();
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
	public AbrirFicheroTexto() {
		setTitle("POLITICA DE PRIVACIDAD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 796, 573);
		contentPane.add(textArea);
		Leer();
	}
	
	private void Leer() {
		 String aux = "";
  		 String texto = "";
  		 String resultado = "";
  		 try {
  		 File archivo = new File("PoliticaDePrivacidad.txt");
  		 if (archivo != null) {
  		 FileReader archivos = new FileReader(archivo);
  		 BufferedReader leer = new BufferedReader(archivos);
  		 while ((aux = leer.readLine()) != null) {
  		 texto += aux + "\n";
  		 }
  		 leer.close();
  		 }
  		 } catch (IOException ex) {
  		 JOptionPane.showMessageDialog(null, "Error Importando - " + ex);
  		 }
  		 textArea.setText(texto);		
	}

}
