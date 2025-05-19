package user;

import config.config;
import config.session;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import Authentication.Login;

public class changepass extends javax.swing.JFrame {

    private int userId; // Added field to store user ID

    public changepass() {
        initComponents();
        setLocationRelativeTo(null);
        users.setEditable(false); // Make username field read-only
        // Username will be fetched based on userId in a new method or updated formWindowActivated
    }

    // New constructor to accept userId from Forgotpass
    public changepass(int userId) {
        this(); // Call the default constructor to initialize components
        this.userId = userId;
        fetchUsername(userId); // Fetch and display username based on ID
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        con = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        users = new javax.swing.JTextField();
        npass = new javax.swing.JLabel();
        newpass = new javax.swing.JPasswordField();
        cpass = new javax.swing.JLabel();
        confirmpass = new javax.swing.JPasswordField();
        reset = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new BorderLayout());

        con.setBackground(new java.awt.Color(255, 255, 255));
        con.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        con.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new java.awt.Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 18));
        jLabel1.setText("CHANGE PASSWORD");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        con.add(jLabel1, gbc);

        user.setText("Username");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        con.add(user, gbc);

        gbc.gridx = 1;
        con.add(users, gbc);

        npass.setText("New Password");
        gbc.gridx = 0;
        gbc.gridy = 2;
        con.add(npass, gbc);

        gbc.gridx = 1;
        con.add(newpass, gbc);

        cpass.setText("Confirm Password");
        gbc.gridx = 0;
        gbc.gridy = 3;
        con.add(cpass, gbc);

        gbc.gridx = 1;
        con.add(confirmpass, gbc);

        reset.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
        });

        jLabel2.setText("Reset");
        reset.add(jLabel2);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        con.add(reset, gbc);

        jPanel1.add(con, BorderLayout.CENTER);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forgot pass.png")));
        jPanel1.add(back, BorderLayout.CENTER);

        getContentPane().add(jPanel1);

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

        // Use the userId passed from Forgotpass
        if (this.userId == 0) { // Check if userId was set
             JOptionPane.showMessageDialog(this, "User ID not set.", "Error", JOptionPane.ERROR_MESSAGE);
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

        config connect = new config();
        PreparedStatement updateStmt = null;

        try {
            // Update password
            String hashedPassword = hashPassword(newPassword);
            if (hashedPassword == null) {
                return; // Stop if hashing fails
            }

            String updateSql = "UPDATE user SET password = ? WHERE u_id = ?";
            updateStmt = connect.prepareStatement(updateSql);
            updateStmt.setString(1, hashedPassword);
            updateStmt.setInt(2, this.userId); // Use the stored userId

            int rowsUpdated = updateStmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Password has been successfully updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Clear fields after success
                newpass.setText("");
                confirmpass.setText("");
                
                // Assuming we don't need session user type after password reset in this flow
                // If navigation back to profile needs user type, you might need to pass it or re-fetch
                // For now, assuming simple navigation or login after password reset in forgot password flow
                 new Login().setVisible(true); // Navigate back to Login or a success screen
                
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update password.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (updateStmt != null) updateStmt.close();
                // Keep connection open if reused, otherwise close. Let's close for safety here.
                 connect.closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
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
        // This method might not be needed if username is fetched in the new constructor
        // Based on previous state, keeping it but it might be redundant
        // session ses = session.getInstance();
        // if (ses != null && ses.getUsername() != null) {
        //     users.setText(ses.getUsername()); 
        // } else {
        // users.setText("No Username");}
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
    }

    // Method to fetch username based on userId
    private void fetchUsername(int userId) {
        config connect = new config();
        try {
            String sql = "SELECT username FROM user WHERE u_id = ?";
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                users.setText(rs.getString("username"));
            } else {
                users.setText("User Not Found");
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            users.setText("Error fetching username");
        } finally {
            connect.closeConnection();
        }
    }
}
