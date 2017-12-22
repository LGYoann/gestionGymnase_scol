/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Albert
 */
public class fen_modifierAssociation extends javax.swing.JFrame {

    /**
     * Creates new form fen_modifierAssociation
     */
    public fen_modifierAssociation() {
        initComponents();
        this.setDefaultCloseOperation(fen_AjoutAssociation.DISPOSE_ON_CLOSE);
        recupererAssos();
        jTextFieldNewRefAsso.setEnabled(false);
        jTextFieldNewVilleAsso.setEnabled(false);
        jTextFieldNewAdresseAsso.setEnabled(false);
        jTextFieldNewResponsableAsso.setEnabled(false);
        jTextFieldNewRefAsso.setText("");
        
        jTextFieldNewVilleAsso.setText("");
             
        jTextFieldNewAdresseAsso.setText("");
     
        jTextFieldNewResponsableAsso.setText("");
    }
     public void recupererAssos()
    {
        Boolean retour = false;
         Connection conn;
                        Statement stmt;
                        ResultSet rs;
                        String pilote="org.gjt.mm.mysql.Driver";
                        String url = "jdbc:mysql://localhost/gestiongymnase";                        
                        try
                        {
                            Class.forName(pilote);
                            conn = DriverManager.getConnection(url,"root","");
                            stmt = conn.createStatement();
                            rs = stmt.executeQuery("select  * from association");
                            int i = 0;
                            while (rs.next())
                            {                         
                                
                                jComboBoxModifAsso.addItem(rs.getString("refAsso"));
                               
                            }
                            rs.close();
                            stmt.close();
                            conn.close();
                        }
                        catch (SQLException E)
                        {
                            System.out.println("SQLException" + E.getMessage());
                            System.out.println("SQLState" + E.getSQLState());
                            System.out.println("VendorError" + E.getErrorCode());
                        }
                        catch (ClassNotFoundException E)
                        {
                            E.printStackTrace();
                        }
        
    }
     public Boolean checkChoices(){
        String refAssoSelected = jComboBoxModifAsso.getSelectedItem().toString();
        Boolean retour = false;
       
         if (jTextFieldNewVilleAsso.isEnabled())     
         {
            
             String NouvelleVille = jTextFieldNewVilleAsso.getText(); 
               Connection conn;
                        Statement stmt;
                        ResultSet rs;
                        String pilote="org.gjt.mm.mysql.Driver";
                        String url = "jdbc:mysql://localhost/gestiongymnase";                        
                        try
                        {
                            Class.forName(pilote);
                            conn = DriverManager.getConnection(url,"root","");
                            stmt = conn.createStatement();
                            stmt.executeUpdate("UPDATE `association` SET ville='"+NouvelleVille+"' WHERE `refAsso`= '"+refAssoSelected+ "'");
                            retour = true;
                            stmt.close();
                            conn.close();
                        }
                        catch (SQLException E)
                        {
                            System.out.println("SQLException" + E.getMessage());
                            System.out.println("SQLState" + E.getSQLState());
                            System.out.println("VendorError" + E.getErrorCode());
                        }
                        catch (ClassNotFoundException E)
                        {
                            E.printStackTrace();
                        }
                     
        }
        
         if (jTextFieldNewAdresseAsso.isEnabled())     
         {
            
               String NouvelleAdresseAsso = jTextFieldNewAdresseAsso.getText();
                Connection conn;
                        Statement stmt;
                        ResultSet rs;
                        String pilote="org.gjt.mm.mysql.Driver";
                        String url = "jdbc:mysql://localhost/gestiongymnase";                        
                        try
                        {
                            Class.forName(pilote);
                            conn = DriverManager.getConnection(url,"root","");
                            stmt = conn.createStatement();
                            stmt.executeUpdate("UPDATE `association` SET adresse='"+NouvelleAdresseAsso+"' WHERE `refAsso`= '"+refAssoSelected+ "'");
                            stmt.close();
                            conn.close();
                            retour = true;
                        }
                        catch (SQLException E)
                        {
                            System.out.println("SQLException" + E.getMessage());
                            System.out.println("SQLState" + E.getSQLState());
                            System.out.println("VendorError" + E.getErrorCode());
                        }
                        catch (ClassNotFoundException E)
                        {
                            E.printStackTrace();
                        }
        }
         if (jTextFieldNewResponsableAsso.isEnabled())
        {               
           
            String NouveauResponsable = jTextFieldNewResponsableAsso.getText();
             Connection conn;
                        Statement stmt;
                        ResultSet rs;
                        String pilote="org.gjt.mm.mysql.Driver";
                        String url = "jdbc:mysql://localhost/gestiongymnase";                        
                        try
                        {
                            Class.forName(pilote);
                            conn = DriverManager.getConnection(url,"root","");
                            stmt = conn.createStatement();
                             stmt.executeUpdate("UPDATE `association` SET nomResponsable='"+NouveauResponsable+"' WHERE `refAsso`= '"+refAssoSelected+ "'");
                            stmt.close();
                            conn.close();
                            retour = true;
                        }
                        catch (SQLException E)
                        {
                            System.out.println("SQLException" + E.getMessage());
                            System.out.println("SQLState" + E.getSQLState());
                            System.out.println("VendorError" + E.getErrorCode());
                        }
                        catch (ClassNotFoundException E)
                        {
                            E.printStackTrace();
                        }
        }
         if (jTextFieldNewRefAsso.isEnabled())       
        {
            String NouvelleRefAsso = jTextFieldNewRefAsso.getText();
             Connection conn;
                        Statement stmt;
                        ResultSet rs;
                        String pilote="org.gjt.mm.mysql.Driver";
                        String url = "jdbc:mysql://localhost/gestiongymnase";                        
                        try
                        {
                            Class.forName(pilote);
                            conn = DriverManager.getConnection(url,"root","");
                            stmt = conn.createStatement();
                            stmt.executeUpdate("UPDATE `association` SET refAsso='"+NouvelleRefAsso+"' WHERE `refAsso`= '"+refAssoSelected+ "'");
                            stmt.close();
                            conn.close();
                            retour = true;
                        }
                        catch (SQLException E)
                        {
                            System.out.println("SQLException" + E.getMessage());
                            System.out.println("SQLState" + E.getSQLState());
                            System.out.println("VendorError" + E.getErrorCode());
                        }
                        catch (ClassNotFoundException E)
                        {
                            E.printStackTrace();
                        }
                      
        }
         return retour;
         
     }
    public Boolean InsertAssocation(String prefAsso)
    {
                        Boolean retour = false;
                        Connection conn;
                        Statement stmt;
                        ResultSet rs;
                        String pilote="org.gjt.mm.mysql.Driver";
                        String url = new String("jdbc:mysql://localhost/gestiongymnase");
                        
                        String RefAsso = jTextFieldNewRefAsso .getText();
                        String Ville = jTextFieldNewVilleAsso.getText();
                        String Adresse = jTextFieldNewAdresseAsso.getText();
                        String NomResp = jTextFieldNewResponsableAsso.getText();
                        try
                        {
                            Class.forName(pilote);
                            conn = DriverManager.getConnection(url,"root","");
                            stmt = conn.createStatement(); 
                           
                            stmt.executeUpdate("UPDATE association SET refAsso ='"+RefAsso+"' WHERE refAsso ='"+prefAsso+ "'");
                            retour = true;
                            stmt.close();
                            conn.close();
                        }
                        catch (SQLException E)
                        {
                            System.out.println("SQLException" + E.getMessage());
                            System.out.println("SQLState" + E.getSQLState());
                            System.out.println("VendorError" + E.getErrorCode());
                        }
                        catch (ClassNotFoundException E)
                        {
                            E.printStackTrace();
                        }
                        return retour;
            }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxModifAsso = new javax.swing.JComboBox<>();
        jTextFieldNewRefAsso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNewVilleAsso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNewAdresseAsso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNewResponsableAsso = new javax.swing.JTextField();
        jButtonValiderChangements = new javax.swing.JButton();
        jCheckBoxRefAsso = new javax.swing.JCheckBox();
        jCheckBoxVilleAsso = new javax.swing.JCheckBox();
        jCheckBoxRespAsso = new javax.swing.JCheckBox();
        jCheckBoxAdresseAsso = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Selectionnez une association :");

        jComboBoxModifAsso.setToolTipText("");
        jComboBoxModifAsso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModifAssoActionPerformed(evt);
            }
        });

        jTextFieldNewRefAsso.setText("RefAsso");
        jTextFieldNewRefAsso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNewRefAssoFocusGained(evt);
            }
        });

        jLabel2.setText("Reference de l'association");

        jLabel3.setText("Ville de l'association");

        jTextFieldNewVilleAsso.setText("Ville");
        jTextFieldNewVilleAsso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNewVilleAssoFocusGained(evt);
            }
        });

        jLabel4.setText("Adresse de l'association");

        jTextFieldNewAdresseAsso.setText("adresse");
        jTextFieldNewAdresseAsso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNewAdresseAssoFocusGained(evt);
            }
        });

        jLabel5.setText("Responsable de l'asso");

        jTextFieldNewResponsableAsso.setText("resp");
        jTextFieldNewResponsableAsso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNewResponsableAssoFocusGained(evt);
            }
        });

        jButtonValiderChangements.setText("Valider");
        jButtonValiderChangements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonValiderChangementsMouseClicked(evt);
            }
        });

        jCheckBoxRefAsso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxRefAssoMouseClicked(evt);
            }
        });
        jCheckBoxRefAsso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRefAssoActionPerformed(evt);
            }
        });

        jCheckBoxVilleAsso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxVilleAssoMouseClicked(evt);
            }
        });

        jCheckBoxRespAsso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxRespAssoMouseClicked(evt);
            }
        });

        jCheckBoxAdresseAsso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxAdresseAssoMouseClicked(evt);
            }
        });

        jLabel6.setText("Cochez le ou les champs à modifier :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxRefAsso)
                            .addComponent(jCheckBoxVilleAsso)
                            .addComponent(jCheckBoxRespAsso)
                            .addComponent(jCheckBoxAdresseAsso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonValiderChangements))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNewRefAsso, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNewVilleAsso)
                                    .addComponent(jTextFieldNewAdresseAsso)
                                    .addComponent(jTextFieldNewResponsableAsso)
                                    .addComponent(jComboBoxModifAsso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxModifAsso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNewRefAsso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBoxRefAsso))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNewVilleAsso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxVilleAsso))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNewAdresseAsso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxAdresseAsso))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldNewResponsableAsso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxRespAsso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButtonValiderChangements))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxModifAssoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModifAssoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxModifAssoActionPerformed

    private void jButtonValiderChangementsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonValiderChangementsMouseClicked
        // TODO add your handling code here:
       // String refAsso = jComboBoxModifAsso.getSelectedItem().toString();
       if (checkChoices())
       {
           checkChoices();
           JOptionPane.showMessageDialog(null, "Modification effectuée", " Info", JOptionPane.INFORMATION_MESSAGE); 
           
                 
           Frame[] frames = Frame.getFrames();
           for (Frame unFrame :frames)
           {
               
                   unFrame.dispose();
               
           }
           fen_Admin fenetreAdmin = new fen_Admin();          
          
           fenetreAdmin.setVisible(true);
       }
       else JOptionPane.showMessageDialog(null, "Modification impossible", " Info", JOptionPane.ERROR_MESSAGE);
      
    }//GEN-LAST:event_jButtonValiderChangementsMouseClicked

    private void jTextFieldNewRefAssoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNewRefAssoFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldNewRefAssoFocusGained

    private void jTextFieldNewVilleAssoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNewVilleAssoFocusGained
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextFieldNewVilleAssoFocusGained

    private void jTextFieldNewAdresseAssoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNewAdresseAssoFocusGained
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextFieldNewAdresseAssoFocusGained

    private void jTextFieldNewResponsableAssoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNewResponsableAssoFocusGained
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextFieldNewResponsableAssoFocusGained

    private void jCheckBoxRefAssoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRefAssoActionPerformed
        // TODO add your handling code here:
     
         
    }//GEN-LAST:event_jCheckBoxRefAssoActionPerformed

    private void jCheckBoxRefAssoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxRefAssoMouseClicked
        // TODO add your handling code here:
        boolean chkbox = jCheckBoxRefAsso.isSelected();
           if (chkbox)
        {
            jTextFieldNewRefAsso.setEnabled(true);             
        }
           else 
        {
            jTextFieldNewRefAsso.setEnabled(false);
        }
        
    }//GEN-LAST:event_jCheckBoxRefAssoMouseClicked

    private void jCheckBoxVilleAssoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxVilleAssoMouseClicked
        // TODO add your handling code here:
         boolean chkbox = jCheckBoxVilleAsso.isSelected();
           if (chkbox)
        {
            jTextFieldNewVilleAsso.setEnabled(true);             
        }
           else 
        {
            jTextFieldNewVilleAsso.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxVilleAssoMouseClicked

    private void jCheckBoxAdresseAssoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxAdresseAssoMouseClicked
        // TODO add your handling code here:
            boolean chkbox = jCheckBoxAdresseAsso.isSelected();
           if (chkbox)
        {
            jTextFieldNewAdresseAsso.setEnabled(true);             
        }
           else 
        {
            jTextFieldNewAdresseAsso.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxAdresseAssoMouseClicked

    private void jCheckBoxRespAssoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxRespAssoMouseClicked
        // TODO add your handling code here:
              boolean chkbox = jCheckBoxRespAsso.isSelected();
           if (chkbox)
        {
            jTextFieldNewResponsableAsso.setEnabled(true);             
        }
           else 
        {
            jTextFieldNewResponsableAsso.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxRespAssoMouseClicked

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
            java.util.logging.Logger.getLogger(fen_modifierAssociation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fen_modifierAssociation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fen_modifierAssociation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fen_modifierAssociation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fen_modifierAssociation().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonValiderChangements;
    private javax.swing.JCheckBox jCheckBoxAdresseAsso;
    private javax.swing.JCheckBox jCheckBoxRefAsso;
    private javax.swing.JCheckBox jCheckBoxRespAsso;
    private javax.swing.JCheckBox jCheckBoxVilleAsso;
    private javax.swing.JComboBox<String> jComboBoxModifAsso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldNewAdresseAsso;
    private javax.swing.JTextField jTextFieldNewRefAsso;
    private javax.swing.JTextField jTextFieldNewResponsableAsso;
    private javax.swing.JTextField jTextFieldNewVilleAsso;
    // End of variables declaration//GEN-END:variables
}
