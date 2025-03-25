
package clothingrental_gui;

import admin.admin;
import config.config;
import config.session;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import user.Startupuser;




public class Login extends javax.swing.JFrame {

 
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parent = new javax.swing.JPanel();
        user2 = new javax.swing.JLabel();
        iusername = new javax.swing.JTextField();
        pass = new javax.swing.JLabel();
        ipassword = new javax.swing.JPasswordField();
        ForgotPassword = new javax.swing.JCheckBox();
        login = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        donthaveacc = new javax.swing.JLabel();
        Register = new javax.swing.JLabel();
        loginback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 400));

        parent.setMaximumSize(new java.awt.Dimension(800, 400));
        parent.setMinimumSize(new java.awt.Dimension(800, 400));
        parent.setPreferredSize(new java.awt.Dimension(800, 400));
        parent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user2.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        user2.setText("USERNAME");
        parent.add(user2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        iusername.setPreferredSize(new java.awt.Dimension(59, 24));
        iusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iusernameActionPerformed(evt);
            }
        });
        parent.add(iusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 220, 24));

        pass.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        pass.setText("PASSWORD");
        parent.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));
        parent.add(ipassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 220, -1));

        ForgotPassword.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        ForgotPassword.setText("Forgot password");
        ForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ForgotPasswordMouseClicked(evt);
            }
        });
        ForgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgotPasswordActionPerformed(evt);
            }
        });
        parent.add(ForgotPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, -1, -1));

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel1.setText("LOGIN");

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        parent.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 90, 20));

        donthaveacc.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        donthaveacc.setText("Don't have an account?");
        parent.add(donthaveacc, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, 10));

        Register.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        Register.setForeground(new java.awt.Color(0, 51, 51));
        Register.setText("Register");
        Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegisterMouseExited(evt);
            }
        });
        parent.add(Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, 20));

        loginback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        loginback.setText("jLabel1");
        parent.add(loginback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
      login.setOpaque(true);
    login.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
       
     login.setOpaque(true);
     login.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_loginMouseExited

    private void iusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iusernameActionPerformed

    private void ForgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgotPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ForgotPasswordActionPerformed

    private void RegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterMouseClicked
       new register().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_RegisterMouseClicked

    private void RegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterMouseEntered
        Register.setOpaque(true);
   Register.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_RegisterMouseEntered

    private void RegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterMouseExited
      Register.setOpaque(true);
   Register.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_RegisterMouseExited

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
     String username = iusername.getText().trim();
        String password = new String(ipassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       try {
    config dbConfig = new config();
    String sql = "SELECT * FROM user WHERE username = ?";
    
    try (PreparedStatement pst = dbConfig.getConnection().prepareStatement(sql)) {
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String dbPassword = rs.getString("password");
            String dbStatus = rs.getString("status");
            String dbRole = rs.getString("role");

            if (!hashPassword(password).equals(dbPassword)) {
                JOptionPane.showMessageDialog(this, "Incorrect password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!dbStatus.equalsIgnoreCase("Active")) {
                JOptionPane.showMessageDialog(this, "Your account is still pending approval.", "Login Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Corrected setUser call with all required parameters
            session sess = session.getInstance();
            sess.setUser(
                rs.getInt("u_id"), 
                rs.getString("fname"), 
                rs.getString("lname"), 
                rs.getString("contact"), 
                rs.getString("username"), 
                rs.getString("email")
            );

            sess.setStatus(dbStatus);
            sess.setUserType(dbRole);

            JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Redirect user based on role
            if (dbRole.equalsIgnoreCase("Admin")) {
                new admin().setVisible(true);
            } else {
                new Startupuser().setVisible(true);
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(this, "Password hashing failed.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    
   

    }//GEN-LAST:event_loginMouseClicked

    private void ForgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForgotPasswordMouseClicked
          new ForgotPassword().setVisible(true);
          this.dispose();
    }//GEN-LAST:event_ForgotPasswordMouseClicked


    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ForgotPassword;
    private javax.swing.JLabel Register;
    private javax.swing.JLabel donthaveacc;
    private javax.swing.JPasswordField ipassword;
    private javax.swing.JTextField iusername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel login;
    private javax.swing.JLabel loginback;
    private javax.swing.JPanel parent;
    private javax.swing.JLabel pass;
    private javax.swing.JLabel user2;
    // End of variables declaration//GEN-END:variables

    
}
