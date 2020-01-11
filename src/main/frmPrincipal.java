package main;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class frmPrincipal extends javax.swing.JFrame {

    public frmPrincipal() {
        initComponents();
        
        cambiarIdioma("Espanol");
    }
    
    public void cambiarIdioma(String nombreIdioma){
        
        idioma=new Idioma(nombreIdioma);
        
        btnCambio.setText(idioma.getProperty("cambio"));
        this.setTitle(idioma.getProperty("titulo"));
        lblHola.setText(idioma.getProperty("saludo"));
        
        cmbIdiomas.removeAllItems();
        
        String idiomas[]={
                          idioma.getProperty("espanol"),
                          idioma.getProperty("ingles"),
                          idioma.getProperty("frances")
                          };
        
        for(int i=0;i<idiomas.length;i++){
            cmbIdiomas.addItem(idiomas[i]);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCambio = new javax.swing.JButton();
        lblHola = new javax.swing.JLabel();
        cmbIdiomas = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCambio.setText("Cambiar");
        btnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioActionPerformed(evt);
            }
        });

        lblHola.setText("jLabel1");

        cmbIdiomas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Español", "Ingles", "Frances" }));
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLogin nuevaVentana = new VentanaLogin();
				nuevaVentana.setVisible(true);
				frmPrincipal.this.dispose();
			}
				
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(111, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lblHola, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        				.addComponent(cmbIdiomas, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(75))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(145)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(btnVolver, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btnCambio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(35)
        			.addComponent(lblHola, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        			.addGap(44)
        			.addComponent(cmbIdiomas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(35)
        			.addComponent(btnCambio)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnVolver)
        			.addContainerGap(38, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
        
        switch(cmbIdiomas.getSelectedIndex()){

            case 0:
                cambiarIdioma("Español");
                break;
            case 1:
                cambiarIdioma("Ingles");
                break;
            case 2:
                cambiarIdioma("Frances");
                break;

        }
        
    }//GEN-LAST:event_btnCambioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambio;
    private javax.swing.JComboBox cmbIdiomas;
    private javax.swing.JLabel lblHola;
    // End of variables declaration//GEN-END:variables
    private Idioma idioma;
}
