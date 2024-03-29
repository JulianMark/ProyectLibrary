/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menu.file;

import controller.dao.simpledao.GenderDao;
import controller.dao.simpledao.SimpleObjDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dto.GenderDTO;
import view.utils.Utils;

/**
 *
 * @author Nana
 */
public class jdGenders extends javax.swing.JDialog {
    private SimpleObjDao simpleObjDao ;
    private List <GenderDTO> listGender;
    private boolean flagBtnNew;
    private boolean flagBtnEdit;

    /**
     * Creates new form jdGenders
     * @param parent
     * @param modal
     */
    public jdGenders(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fillGendersBook();
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
        lstGenders = new javax.swing.JList<>();
        btnSearch = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstGenders.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstGenders.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstGendersValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstGenders);

        btnSearch.setText("Ir");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnEdit.setText("Modificar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSend.setText("Aceptar");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtSearch.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancel)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(txtDescription)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew)
                            .addComponent(btnEdit))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSend)
                            .addComponent(btnCancel))
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstGendersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstGendersValueChanged
        if (lstGenders.getSelectedIndex() >= 0){
            fillFieldFromJlistGender(lstGenders.getSelectedIndex());
        }
    }//GEN-LAST:event_lstGendersValueChanged

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        flagBtnNew = true;
        cleanField();
        txtDescription.requestFocus();
        turnOnOffInitComponent(false);    
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (lstGenders.getSelectedIndex() >= 0){
            flagBtnEdit = true;
            txtDescription.requestFocus();
            turnOnOffInitComponent(false);    
        } else {
            JOptionPane.showMessageDialog(null,"Necesario seleccionar un genero de la lista");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        flagBtnNew = false;
        flagBtnEdit = false;
        turnOnOffInitComponent(true);
        fillFieldFromJlistGender(lstGenders.getSelectedIndex());
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if (validateFill()){
            
            simpleObjDao = new GenderDao();
            
            String description = txtDescription.getText();
            
            GenderDTO gender = new GenderDTO();
            gender.setDescription(description);
            int result = 0;
            if (flagBtnNew) {
                try {
                    result = simpleObjDao.insert(gender);    
                } catch (Exception e) {
                    System.out.println("Excepcion en el insert de nuevo genero");
                      e.printStackTrace();
                }
                if (result > 0){
                    JOptionPane.showMessageDialog(null, "Se agrego correctamente el genero "+gender.getDescription());
                    fillGendersBook();
                } else{
                    JOptionPane.showMessageDialog(null, "No se agrego correctamente el genero");
                }
                flagBtnNew = false;
            } else if (flagBtnEdit) {
                gender.setId(listGender.get(lstGenders.getSelectedIndex()).getId());
                try {
                    result = simpleObjDao.update(gender);
                } catch (Exception e) {
                    System.out.println("Excepcion en el update de nuevo genero");
                      e.printStackTrace();
                }
                if (result > 0){
                    JOptionPane.showMessageDialog(null, "Se actualizo correctamente el genero");
                    fillGendersBook();
                } else {
                    JOptionPane.showMessageDialog(null, "No se actualizo correctamente el genero");
                } 
                flagBtnEdit = false;
            } 
            turnOnOffInitComponent(true);
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        simpleObjDao = new GenderDao();
       
        try {
            if (!listGender.isEmpty()){
                listGender.clear();
            }
            listGender = simpleObjDao.select_for_name(txtSearch.getText());
            Utils.fillJList(listGender, lstGenders);
        } catch (SQLException ex) {
            Logger.getLogger(jdAuthors.class.getName()).log(Level.SEVERE, null, ex);
        }
        cleanField();
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
            java.util.logging.Logger.getLogger(jdGenders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdGenders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdGenders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdGenders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdGenders dialog = new jdGenders(new javax.swing.JFrame(), true);
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
    
    private void fillGendersBook(){
        simpleObjDao = new GenderDao();
        
        try {
            listGender = simpleObjDao.select();
            Utils.fillJList(listGender, lstGenders);
        } catch (Exception e) {
            System.out.println("Excepcion en la carga de lista de genders");
            e.printStackTrace();
        }
    }

    private void fillFieldFromJlistGender(int i){
        txtDescription.setText(listGender.get(i).getDescription());
    }
    
    private void cleanField(){
        txtDescription.setText("");
    }
    
    private void turnOnOffInitComponent(boolean x){
        lstGenders.setEnabled(x);
        txtDescription.setEnabled(!x);
        btnNew.setEnabled(x);
        btnEdit.setEnabled(x);
        btnSend.setEnabled(!x);
        btnCancel.setEnabled(!x);
    }
    
    private boolean validateFill() {
        boolean validate = true;
        if (txtDescription.getText().equals("")){
            JOptionPane.showMessageDialog(null, "El nombre del genero no puede ser vacío");
            txtDescription.requestFocus();
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
    private javax.swing.JList<String> lstGenders;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
