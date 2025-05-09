
package user;

import clothingrental_gui.*;
import config.config;
import config.session;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class changepass extends javax.swing.JFrame {

    
    public changepass() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backbutton = new javax.swing.JLabel();
        con = new javax.swing.JPanel();
        users = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        reset = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        newpass = new javax.swing.JPasswordField();
        confirmpass = new javax.swing.JPasswordField();
        npass = new javax.swing.JLabel();
        cpass = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backbutton.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        backbutton.setForeground(new java.awt.Color(255, 255, 255));
        backbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-logout-24.png"))); // NOI18N
        backbutton.setText("back");
        backbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbuttonMouseClicked(evt);
            }
        });
        jPanel1.add(backbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        con.setBackground(new java.awt.Color(0, 0, 0,80));
        con.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        con.setForeground(new java.awt.Color(204, 204, 204));

        users.setEditable(false);
        users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel1.setText("CHANGE PASSWORD");

        reset.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetMouseExited(evt);
            }
        });

        jLabel2.setText("RESET");

        javax.swing.GroupLayout resetLayout = new javax.swing.GroupLayout(reset);
        reset.setLayout(resetLayout);
        resetLayout.setHorizontalGroup(
            resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resetLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        resetLayout.setVerticalGroup(
            resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resetLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        user.setText("username");

        newpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpassActionPerformed(evt);
            }
        });

        npass.setText("New Password");

        cpass.setText("Confirm Password");

        javax.swing.GroupLayout conLayout = new javax.swing.GroupLayout(con);
        con.setLayout(conLayout);
        conLayout.setHorizontalGroup(
            conLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conLayout.createSequentialGroup()
                .addGroup(conLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(conLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1))
                    .addGroup(conLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(conLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(users, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user)
                            .addComponent(npass)
                            .addGroup(conLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(newpass)
                                .addComponent(confirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cpass))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        conLayout.setVerticalGroup(
            conLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(users, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(npass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel1.add(con, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 260, 290));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forgot pass.png"))); // NOI18N
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersActionPerformed
  
    }//GEN-LAST:event_usersActionPerformed

    private void newpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpassActionPerformed
      
    }//GEN-LAST:event_newpassActionPerformed

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
    String newPassword = new String(newpass.getPassword()).trim();
    String confirmPassword = new String(confirmpass.getPassword()).trim();

   
    session ses = session.getInstance();
    String username = (ses != null) ? ses.getUsername() : null;

    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No user is logged in.", "Authentication Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (!newPassword.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(this, "New password and confirm password do not match.", "Password Mismatch", JOptionPane.ERROR_MESSAGE);
        return;
    }

    config connect = new config(); // Create DB connection instance
    PreparedStatement checkUserStmt = null;
    PreparedStatement updateStmt = null;
    ResultSet rs = null;

    try {
        // Check if user exists
        String checkUserSql = "SELECT * FROM user WHERE username = ?";
        checkUserStmt = connect.prepareStatement(checkUserSql);
        checkUserStmt.setString(1, username);
        rs = checkUserStmt.executeQuery();

        if (rs.next()) {
            // User exists, proceed to update password
            String hashedPassword = hashPassword(newPassword);
            if (hashedPassword == null) {
                return; // Stop if hashing fails
            }

            String updateSql = "UPDATE user SET password = ? WHERE username = ?";
            updateStmt = connect.prepareStatement(updateSql);
            updateStmt.setString(1, hashedPassword);
            updateStmt.setString(2, username);

            int rowsUpdated = updateStmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Password has been successfully updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Clear fields after success
                newpass.setText("");
                confirmpass.setText("");
                  new userprofile().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "User not found. Cannot change password.", "User Not Found", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error occurred.", "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Close resources properly
        try {
            if (rs != null) rs.close();
            if (checkUserStmt != null) checkUserStmt.close();
            if (updateStmt != null) updateStmt.close();
            connect.closeConnection(); // Close connection properly
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }//GEN-LAST:event_resetMouseClicked

    private void backbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbuttonMouseClicked
          new userprofile().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_backbuttonMouseClicked

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
         reset.setOpaque(true);
         reset.setBackground(new java.awt.Color(102,102,102)); 
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
         reset.setOpaque(true);
         reset.setBackground(new java.awt.Color(204,204,204)); 
    }//GEN-LAST:event_resetMouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         session ses = session.getInstance();
    
    if (ses != null && ses.getUsername() != null) {
        users.setText(ses.getUsername()); 
    } else {
        users.setText("No Username");}
    }//GEN-LAST:event_formWindowActivated

   
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changepass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel backbutton;
    private javax.swing.JPanel con;
    private javax.swing.JPasswordField confirmpass;
    private javax.swing.JLabel cpass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JLabel npass;
    private javax.swing.JPanel reset;
    private javax.swing.JLabel user;
    private javax.swing.JTextField users;
    // End of variables declaration//GEN-END:variables

    private String hashPassword(String newPassword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
