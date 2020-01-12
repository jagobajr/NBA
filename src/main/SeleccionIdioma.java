package main;

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

import ventanas.VentanaMenu;
import ventanas.VentanaMercado;


import main.Usuarios;

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
	
	public static void main(String[] args) {
		
		LogController.log ( Level.INFO, "Inicio Registro " + (new Date()),null);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionIdioma frame = new SeleccionIdioma();
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
	
	public SeleccionIdioma() {
		setBounds(new Rectangle(50, 55, 555, 355));
		setResizable(false);
		getContentPane().setName("contentPanel");
		getContentPane().setLayout(null);
	
		((JComponent) getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JRadioButton rdbtnCastellano = new JRadioButton("Castellano");
		JRadioButton rdbtnIngles = new JRadioButton("Ingles");
		JRadioButton rdbtnFrances = new JRadioButton("Frances");
		
		rdbtnCastellano.setBounds(58, 92, 109, 23);
		getContentPane().add(rdbtnCastellano);
		rdbtnCastellano.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				//AbrirFicheroTexto nuevaVentana = new AbrirFicheroTexto();
				//nuevaVentana.setVisible(true);
				rdbtnIngles.setSelected(false);
				rdbtnFrances.setSelected(false);
				
				
				JOptionPane.showMessageDialog(null, "Ha cambiado el idioma correctamente", "Aviso", 1);

			}});
		
		
	//	JOptionPane.showMessageDialog(null, "No se ha podido iniciar sesion", "Error", 0);
   
		
		//JRadioButton rdbtnIngles = new JRadioButton("Ingles");
		rdbtnIngles.setBounds(169, 92, 95, 23);
		getContentPane().add(rdbtnIngles);
		rdbtnIngles.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				//AbrirFicheroTexto nuevaVentana = new AbrirFicheroTexto();
				//nuevaVentana.setVisible(true);
				rdbtnCastellano.setSelected(false);
				rdbtnFrances.setSelected(false);
				
				
				JOptionPane.showMessageDialog(null, "Ha cambiado el idioma correctamente", "Aviso", 1);

			}});
		
		//JRadioButton rdbtnFrances = new JRadioButton("Frances");
		rdbtnFrances.setBounds(266, 92, 124, 23);
		getContentPane().add(rdbtnFrances);
		rdbtnFrances.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				//AbrirFicheroTexto nuevaVentana = new AbrirFicheroTexto();
				//nuevaVentana.setVisible(true);
				rdbtnCastellano.setSelected(false);
				rdbtnFrances.setSelected(false);
				
				
				JOptionPane.showMessageDialog(null, "Ha cambiado el idioma correctamente", "Aviso", 1);

			}});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(new Rectangle(24, 22, 27, 22));
		btnVolver.setBounds(152, 185, 89, 23);
		getContentPane().add(btnVolver);
		
		JLabel lblSeleccioneUnIdoma = new JLabel("Seleccione un idoma");
		lblSeleccioneUnIdoma.setBounds(152, 11, 151, 23);
		getContentPane().add(lblSeleccioneUnIdoma);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLogin nuevaVentana = new VentanaLogin();
				nuevaVentana.setVisible(true);
				SeleccionIdioma.this.dispose();
			}
				
		});
		
	}
}
