/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.menu.file.jdAuthors;
import view.menu.file.jdBooks;
import view.menu.file.jdGenders;

/**
 *
 * @author Nana
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuFrmPrincipal = new javax.swing.JMenuBar();
        menuFileFrmPrincipal = new javax.swing.JMenu();
        goToWindowBooks = new javax.swing.JMenuItem();
        goToWindowAuthors = new javax.swing.JMenuItem();
        goToWindowGenders = new javax.swing.JMenuItem();
        menuOptionsFrmPrincipal = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuFileFrmPrincipal.setText("Archivo");

        goToWindowBooks.setText("Libros");
        goToWindowBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToWindowBooksActionPerformed(evt);
            }
        });
        menuFileFrmPrincipal.add(goToWindowBooks);

        goToWindowAuthors.setText("Autores");
        goToWindowAuthors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToWindowAuthorsActionPerformed(evt);
            }
        });
        menuFileFrmPrincipal.add(goToWindowAuthors);

        goToWindowGenders.setText("Generos");
        goToWindowGenders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToWindowGendersActionPerformed(evt);
            }
        });
        menuFileFrmPrincipal.add(goToWindowGenders);

        menuFrmPrincipal.add(menuFileFrmPrincipal);

        menuOptionsFrmPrincipal.setText("Opciones");
        menuFrmPrincipal.add(menuOptionsFrmPrincipal);

        setJMenuBar(menuFrmPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goToWindowBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToWindowBooksActionPerformed
         jdBooks dialog = new jdBooks(this,true);
         dialog.setLocationRelativeTo(this);
         dialog.setVisible(true);
    }//GEN-LAST:event_goToWindowBooksActionPerformed

    private void goToWindowAuthorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToWindowAuthorsActionPerformed
         jdAuthors dialog = new jdAuthors(this,true);
         dialog.setLocationRelativeTo(this);
         dialog.setVisible(true);
    }//GEN-LAST:event_goToWindowAuthorsActionPerformed

    private void goToWindowGendersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToWindowGendersActionPerformed
         jdGenders dialog = new jdGenders (this,true);
         dialog.setLocationRelativeTo(this);
         dialog.setVisible(true);
    }//GEN-LAST:event_goToWindowGendersActionPerformed

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
    private javax.swing.JMenuItem goToWindowAuthors;
    private javax.swing.JMenuItem goToWindowBooks;
    private javax.swing.JMenuItem goToWindowGenders;
    private javax.swing.JMenu menuFileFrmPrincipal;
    private javax.swing.JMenuBar menuFrmPrincipal;
    private javax.swing.JMenu menuOptionsFrmPrincipal;
    // End of variables declaration//GEN-END:variables
}
