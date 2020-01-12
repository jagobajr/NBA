package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Statement;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.Usuarios;
import main.LogController;

import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import java.sql.*;
import javax.swing.JRadioButton;
import java.awt.Rectangle;


public class SeleccionIdioma extends JFrame  {
	
	
	
	private  void ConfigureCloseWindow(){
	    this.addWindowListener( new WindowAdapter() {

	        @Override
	        public void windowClosing(WindowEvent e) {
				LogController.log ( Level.INFO, "Fin de ventana de idioma " + (new Date()),null);

	        }
	    });
		}
	
	public SeleccionIdioma() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(50, 55, 555, 355));
		setResizable(false);
		getContentPane().setName("contentPanel");
		getContentPane().setLayout(null);
	
		((JComponent) getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JRadioButton rdbtnCastellano = new JRadioButton("Castellano");
		JRadioButton rdbtnIngles = new JRadioButton("Ingles");
		JRadioButton rdbtnFrances = new JRadioButton("Franc\u00E9s");

		
		rdbtnCastellano.setBounds(172, 143, 109, 23);
		getContentPane().add(rdbtnCastellano);
		rdbtnCastellano.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				//AbrirFicheroTexto nuevaVentana = new AbrirFicheroTexto();
				//nuevaVentana.setVisible(true);
				rdbtnIngles.setSelected(false);
				rdbtnFrances.setSelected(false);
				
				
				JOptionPane.showMessageDialog(null, "Ha cambiado el idioma correctamente", "Aviso", 1);

			}});
		
		rdbtnIngles.setBounds(302, 143, 89, 23);
		getContentPane().add(rdbtnIngles);
		rdbtnIngles.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				//AbrirFicheroTexto nuevaVentana = new AbrirFicheroTexto();
				//nuevaVentana.setVisible(true);
				rdbtnCastellano.setSelected(false);
				rdbtnFrances.setSelected(false);
				
				
				JOptionPane.showMessageDialog(null, "You have changed the language correctly", "Warning", 1);

			}});
		
		rdbtnFrances.setBounds(409, 140, 89, 29);
		getContentPane().add(rdbtnFrances);
		rdbtnFrances.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				//AbrirFicheroTexto nuevaVentana = new AbrirFicheroTexto();
				//nuevaVentana.setVisible(true);
				rdbtnCastellano.setSelected(false);
				rdbtnIngles.setSelected(false);
				
				
				JOptionPane.showMessageDialog(null, "Vous avez correctement changé la langue", "Parqueser", 1);

			}});
		
		
		
		
		JLabel lblSeleccioneUnIdoma = new JLabel("Seleccione un idoma");
		lblSeleccioneUnIdoma.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSeleccioneUnIdoma.setBounds(170, 92, 250, 50);
		getContentPane().add(lblSeleccioneUnIdoma);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes/logotipos-de-los-equipos-de-nba-78105095.jpg"));
		label.setBounds(-54, -142, 609, 527);
		getContentPane().add(label);
		
		
	}
}
