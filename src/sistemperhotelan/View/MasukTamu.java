/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemperhotelan.View;
import sistemperhotelan.model.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author bijak
 */
public class MasukTamu extends javax.swing.JFrame {
    MasukAdmin a;
    static final String DB_URL = "jdbc:mysql://localhost/tubespbo";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
//    DashboardAdmin b;
    /**
     * Creates new form UI
     */
    public MasukTamu() {
        initComponents();
        a = new MasukAdmin();
        a.setVisible(false);
        
    }
    
    public void SaveTamu(User DBtamu,String ID){
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `tamu` WHERE `id_tamu` = '"+ID+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                DBtamu.setTamu(new Tamu(rs.getString("id_tamu"),rs.getString("nama"),rs.getString("no_hp")));
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MasukAdmin = new javax.swing.JLabel();
        Login_Tamu01 = new javax.swing.JTextField();
        Login_Tamu02 = new javax.swing.JTextField();
        ID_Tamu = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        MasukTamu = new javax.swing.JLabel();
        Login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MasukAdmin.setText("<html>\n<u>Masuk Sebagai Admin</u>\n</html>\n");
        MasukAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MasukAdminMouseClicked(evt);
            }
        });

        Login_Tamu01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_Tamu01ActionPerformed(evt);
            }
        });

        Login_Tamu02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_Tamu02ActionPerformed(evt);
            }
        });

        ID_Tamu.setText("ID Tamu");

        Password.setText("Password");

        MasukTamu.setText("<html> <h1>Masuk Tamu</h1> </html> ");

        Login.setText("Masuk");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(MasukTamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MasukAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(Login))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Password)
                            .addComponent(ID_Tamu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Login_Tamu01)
                            .addComponent(Login_Tamu02, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(MasukTamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login_Tamu01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID_Tamu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login_Tamu02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Password))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MasukAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Login))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Login_Tamu01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_Tamu01ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Login_Tamu01ActionPerformed

    private void Login_Tamu02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_Tamu02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Login_Tamu02ActionPerformed

    private void MasukAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MasukAdminMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        a.setVisible(true);
        
    }//GEN-LAST:event_MasukAdminMouseClicked

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        String id_tamu = Login_Tamu01.getText();
        String pass = Login_Tamu02.getText();
        System.out.println("Input : "+id_tamu+" "+pass);
        String DBid_tamu = "";
        User DBtamu = new User("");
        
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM user WHERE id_tamu='" + id_tamu + "' && password='" + pass+ "'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("id_tamu")+" "+ rs.getString("password"));
                DBid_tamu = rs.getString("id_tamu");
                DBtamu.setPassword(rs.getString("password"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        if (id_tamu.equals(DBid_tamu) && pass.equals(DBtamu.getPassword()) && (!id_tamu.isEmpty() && !DBtamu.getPassword().isEmpty())){
            System.out.print("Masuk");
            SaveTamu(DBtamu,DBid_tamu);
            System.out.print(DBtamu.getTamu().getNama()+" "+DBtamu.getPassword());
//            b = new Dashboard();
//            b.worker = DBadmin.getKaryawan();
//            b.HaloAdmin1.setText("<html><h3>Halo, "+b.worker.getNama()+"</h3></html>");
//            b.HaloAdmin2.setText("<html><h3>ID Karyawan: "+b.worker.getID()+"| Posisi: "+b.worker.getPosisi()+"</h3></html>");
//            this.setVisible(false);
//            b.setVisible(true);
            
        } else {
            System.out.print("Gagal");
            JOptionPane.showMessageDialog(this, "Gagal Login, Tolong Periksa Email Dan Password","Peringatan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginActionPerformed

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
            java.util.logging.Logger.getLogger(MasukTamu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasukTamu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasukTamu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasukTamu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasukTamu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID_Tamu;
    private javax.swing.JButton Login;
    private javax.swing.JTextField Login_Tamu01;
    private javax.swing.JTextField Login_Tamu02;
    private javax.swing.JLabel MasukAdmin;
    private javax.swing.JLabel MasukTamu;
    private javax.swing.JLabel Password;
    // End of variables declaration//GEN-END:variables
}
