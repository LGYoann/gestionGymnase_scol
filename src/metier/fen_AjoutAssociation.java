/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author C103-image
 */
public class fen_AjoutAssociation extends javax.swing.JFrame {

    /**
     * Creates new form fen_AjoutAssociation
     */
    public fen_AjoutAssociation() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_RefAssoc = new javax.swing.JLabel();
        txt_RefAssoc = new javax.swing.JTextField();
        lbl_ville = new javax.swing.JLabel();
        lbl_adresse = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_Ville = new javax.swing.JTextField();
        txt_Adresse = new javax.swing.JTextField();
        txt_NomResp = new javax.swing.JTextField();
        btn_Envoyer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_RefAssoc.setText("Référence de l'association :");

        lbl_ville.setText("Ville :");

        lbl_adresse.setText("Adresse:");

        jLabel1.setText("Nom du responsable :");

        btn_Envoyer.setText("Envoyer");
        btn_Envoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EnvoyerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lbl_adresse)
                    .addComponent(lbl_RefAssoc)
                    .addComponent(lbl_ville))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_RefAssoc)
                    .addComponent(txt_Ville)
                    .addComponent(txt_Adresse)
                    .addComponent(txt_NomResp, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addContainerGap(180, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Envoyer)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_RefAssoc)
                    .addComponent(txt_RefAssoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ville)
                    .addComponent(txt_Ville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_adresse)
                    .addComponent(txt_Adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_NomResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btn_Envoyer)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EnvoyerActionPerformed
         InsertAssocation();
         this.dispose();
    }//GEN-LAST:event_btn_EnvoyerActionPerformed

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
            java.util.logging.Logger.getLogger(fen_AjoutAssociation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fen_AjoutAssociation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fen_AjoutAssociation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fen_AjoutAssociation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fen_AjoutAssociation().setVisible(true);
            }
        });
    }
    
    public void InsertAssocation()
    {
                        Connection conn;
                        Statement stmt;
                        ResultSet rs;
                        String pilote="org.gjt.mm.mysql.Driver";
                        String url = new String("jdbc:mysql://localhost/gymnase");
                        
                        String RefAsso = txt_RefAssoc.getText();
                        String Ville = txt_Ville.getText();
                        String Adresse = txt_Adresse.getText();
                        String NomResp = txt_NomResp.getText();
                        try
                        {
                            Class.forName(pilote);
                            conn = DriverManager.getConnection(url,"root","");
                            stmt = conn.createStatement();                           
                            stmt.executeUpdate("INSERT INTO association VALUES(" +"\"" + RefAsso +"\"" +"," +"\"" +Ville+"\"" +"," +"\"" + Adresse +"\"" +"," +"\""+NomResp +"\"" +")");
                            
                            System.out.println("Ajout effectué");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Envoyer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_RefAssoc;
    private javax.swing.JLabel lbl_adresse;
    private javax.swing.JLabel lbl_ville;
    private javax.swing.JTextField txt_Adresse;
    private javax.swing.JTextField txt_NomResp;
    private javax.swing.JTextField txt_RefAssoc;
    private javax.swing.JTextField txt_Ville;
    // End of variables declaration//GEN-END:variables
}
