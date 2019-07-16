/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menu.file;

import controller.dao.simpledao.AuthorDao;
import controller.dao.simpledao.SimpleObjDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dto.AuthorDTO;
import view.utils.Utils;

/**
 *
 * @author Nana
 */
public class jdAuthors extends javax.swing.JDialog {
    private SimpleObjDao simpleObjDao;
    private List <AuthorDTO> listAuthor;
    private boolean flagBtnNew;
    private boolean flagBtnEdit;

    /**
     * Creates new form jdAuthors
     * @param parent
     * @param modal
     */
    public jdAuthors(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fillAuthorsBook();
        turnOnOffInitComponent(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstAuthors = new javax.swing.JList<>();
        txtLastnameAuthor = new javax.swing.JTextField();
        txtNameAuthor = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstAuthors.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstAuthors.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAuthorsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstAuthors);

        txtLastnameAuthor.setText("Apellido");

        txtNameAuthor.setText("Nombre");

        btnEdit.setText("Modificar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSend.setText("Aceptar");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtSearch.setText("Buscar ");

        btnSearch.setText("Ir");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSearch)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(8, 8, 8)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEdit)))
                        .addComponent(txtLastnameAuthor))
                    .addComponent(txtNameAuthor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNameAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLastnameAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew)
                            .addComponent(btnEdit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel)
                            .addComponent(btnSend)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstAuthorsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAuthorsValueChanged
        if (lstAuthors.getSelectedIndex() >= 0){
            fillFieldFromJListAuthors(lstAuthors.getSelectedIndex());
        }
    }//GEN-LAST:event_lstAuthorsValueChanged

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        flagBtnNew = true;
        cleanField();
        txtNameAuthor.requestFocus();
        turnOnOffInitComponent(false);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (lstAuthors.getSelectedIndex() >= 0) {
            flagBtnEdit = true;
            txtNameAuthor.requestFocus();
            turnOnOffInitComponent(false);
        } else {
            JOptionPane.showMessageDialog(null, "Necesario seleccionar un autor de la lista");
        } 
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        flagBtnNew = false;
        flagBtnEdit = false;
        turnOnOffInitComponent(true);
        fillFieldFromJListAuthors(lstAuthors.getSelectedIndex());
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if (validateFill()){
        
            simpleObjDao = new AuthorDao();

            String name = txtNameAuthor.getText();
            String lastname = txtLastnameAuthor.getText();

            AuthorDTO author = new AuthorDTO();
            author.setName(name);
            author.setLastname(lastname);
            int result = 0;
            if (flagBtnNew){
                try {
                    result = simpleObjDao.insert(author);
                } catch (SQLException e) {
                     System.out.println("Excepcion en el insert de nuevo autor");
                      e.printStackTrace();
                }
                if (result > 0){
                    JOptionPane.showMessageDialog(null, "Se agrego correctamente el autor "+author.getName()+" "+author.getLastname());
                    fillAuthorsBook();
                }else {
                    JOptionPane.showMessageDialog(null, "No se agrego correctamente el autor");
                }
                flagBtnNew = false;
            } else if (flagBtnEdit) {
                author.setId(listAuthor.get(lstAuthors.getSelectedIndex()).getId());
                try {
                    result = simpleObjDao.update(author);
                } catch (SQLException e) {
                    System.out.println("Excepcion en el update de nuevo autor");
                      e.printStackTrace();
                }
                if (result > 0){
                    JOptionPane.showMessageDialog(null, "Se actualizo correctamente el autor");
                    fillAuthorsBook();
                } else {
                    JOptionPane.showMessageDialog(null, "No se actualizo correctamente el autor");
                }
                flagBtnEdit = false;
            }
            turnOnOffInitComponent(true);
        }  
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        simpleObjDao = new AuthorDao();
       
        try {
            if (!listAuthor.isEmpty()){
            listAuthor.clear();
            }
            listAuthor = simpleObjDao.select_for_name(txtSearch.getText());
            Utils.fillJList(listAuthor, lstAuthors);
        } catch (SQLException ex) {
            Logger.getLogger(jdAuthors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(jdAuthors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdAuthors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdAuthors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdAuthors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdAuthors dialog = new jdAuthors(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void fillAuthorsBook(){
        simpleObjDao = new AuthorDao();
        try {
            listAuthor = simpleObjDao.select();
            Utils.fillJList(listAuthor,lstAuthors);
        } catch (SQLException e) {
            System.out.println("Excepcion en la carga de lista de authors_books");
            e.printStackTrace();
        }     
    }
    
    private void fillFieldFromJListAuthors(int i){
        txtLastnameAuthor.setText(listAuthor.get(i).getLastname());
        txtNameAuthor.setText(listAuthor.get(i).getName());
    }
    
    private void cleanField(){
        txtLastnameAuthor.setText("");
        txtNameAuthor.setText("");
    }
    
    private void turnOnOffInitComponent(boolean x){
        lstAuthors.setEnabled(x);
        txtLastnameAuthor.setEnabled(!x);
        txtNameAuthor.setEnabled(!x);
        btnNew.setEnabled(x);
        btnEdit.setEnabled(x);
        btnSend.setEnabled(!x);
        btnCancel.setEnabled(!x);
    }
    
    private boolean validateFill() {
        boolean validate = true;
        if (txtNameAuthor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "El nombre del autor no puede ser vacío");
            txtNameAuthor.requestFocus();
            validate = false;
            return validate;
        }
        if (txtLastnameAuthor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "El apellido del autor no puede ser vacío");
            txtLastnameAuthor.requestFocus();
            validate = false;
            return validate;
        }
        return validate;
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstAuthors;
    private javax.swing.JTextField txtLastnameAuthor;
    private javax.swing.JTextField txtNameAuthor;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
