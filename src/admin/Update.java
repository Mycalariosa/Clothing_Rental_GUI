/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.config;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import admin.accmanagement;
import clothingrental_gui.Login;

/**
 *
 * @author Administrator
 */
public class Update extends javax.swing.JFrame {

     config connect = new config(); // Database connection
     private String username; // Store the username

    public Update(String username) {
        initComponents(); // Initialize UI components
        this.username = username;
        fetchUserDetails(); // Fetch user details and populate fields
    }

    private Update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Fetch and display user details
    private void fetchUserDetails() {
        config connect = new config();
        String sql = "SELECT fname, lname, email, contact, status, role FROM user WHERE username = ?";

        try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                fname.setText(rs.getString("fname"));
                lname.setText(rs.getString("lname"));
                email.setText(rs.getString("email"));
                cont.setText(rs.getString("contact"));
                status.setSelectedItem(rs.getString("status"));
                role.setSelectedItem(rs.getString("role"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: Unable to fetch user details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cont = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        updatepanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        role = new javax.swing.JComboBox<>();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fname.setForeground(new java.awt.Color(102, 102, 102));
        fname.setCaretColor(new java.awt.Color(102, 102, 102));
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        getContentPane().add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 220, -1));

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("FIRSTNAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("LASTNAME");
        jLabel9.setAlignmentY(0.0F);
        jLabel9.setIconTextGap(1);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        lname.setForeground(new java.awt.Color(102, 102, 102));
        lname.setCaretColor(new java.awt.Color(102, 102, 102));
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        getContentPane().add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 220, -1));

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("EMAIL");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, 10));

        email.setForeground(new java.awt.Color(102, 102, 102));
        email.setCaretColor(new java.awt.Color(102, 102, 102));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 220, -1));

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("CONTACT");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 50, -1));

        cont.setForeground(new java.awt.Color(102, 102, 102));
        cont.setCaretColor(new java.awt.Color(102, 102, 102));
        getContentPane().add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 220, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("USERNAME");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        user.setForeground(new java.awt.Color(102, 102, 102));
        user.setCaretColor(new java.awt.Color(102, 102, 102));
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 220, -1));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("PASSWORD ");
        jLabel2.setIconTextGap(0);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 220, 20));

        updatepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatepanelMouseClicked(evt);
            }
        });

        jLabel1.setText("update");

        javax.swing.GroupLayout updatepanelLayout = new javax.swing.GroupLayout(updatepanel);
        updatepanel.setLayout(updatepanelLayout);
        updatepanelLayout.setHorizontalGroup(
            updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatepanelLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(36, 36, 36))
        );
        updatepanelLayout.setVerticalGroup(
            updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatepanelLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        getContentPane().add(updatepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 110, 20));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 220, -1));

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleActionPerformed(evt);
            }
        });
        getContentPane().add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 220, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Black and White Modern Sign-up and Login Website Page UI Desktop Prototype.png"))); // NOI18N
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(-280, -10, 660, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed
    

    // Validate input fields
    private boolean validateInput() {
        String emailText = email.getText().trim();
        String contactNumberText = cont.getText().trim();

        if (fname.getText().trim().isEmpty() || lname.getText().trim().isEmpty() || 
            emailText.isEmpty() || contactNumberText.isEmpty() || user.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!contactNumberText.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(this, "Invalid contact number. Must be 11 digits.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!isValidEmail(emailText)) {
            JOptionPane.showMessageDialog(this, "Invalid email format!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private void updatepanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatepanelMouseClicked
                                           
   config connect = new config();
    if (!validateInput()) return;

    // Get user inputs
    String firstname = fname.getText().trim();
    String lastname = lname.getText().trim();
    String email1 = email.getText().trim();
    String contact = cont.getText().trim();
    String username = user.getText().trim();
    String password = pass.getText().trim();
    String status = "Pending";
    String role = "User";
    
    String hashedPassword = password.isEmpty() ? null : hashPassword(password);

     String sql;
    if (hashedPassword == null) {
        sql = "UPDATE user SET fname = ?, lname = ?, email = ?, contact = ?, status = ?, role = ? WHERE username = ?";
    } else {
        sql = "UPDATE user SET fname = ?, lname = ?, email = ?, contact = ?, password = ?, status = ?, role = ? WHERE username = ?";
    }

    try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
        pst.setString(1, firstname);
        pst.setString(2, lastname);
        pst.setString(3, email1);
        pst.setString(4, contact);

        if (hashedPassword == null) {
            pst.setString(5, status);
            pst.setString(6, role);
            pst.setString(7, username);
        } else {
            pst.setString(5, hashedPassword);
            pst.setString(6, status);
            pst.setString(7, role);
            pst.setString(8, username);
        }

        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "User updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            new accmanagement().setVisible(true); // Redirect to account management
            this.dispose(); // Close current form
        } else {
            JOptionPane.showMessageDialog(this, "No user found with the provided username.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database Error: Unable to update account.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Fetch updated user details and display them
private void fetchUpdatedUserDetails(String username) {
    config connect = new config();
     String sql = "SELECT fname, lname, email, contact, status, role FROM user WHERE username = ?"; 

        try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                fname.setText(rs.getString("fname"));
                lname.setText(rs.getString("lname"));
                email.setText(rs.getString("email"));
                cont.setText(rs.getString("contact"));
                status.setSelectedItem(rs.getString("status")); // Dropdown
                role.setSelectedItem(rs.getString("role"));     // Dropdown
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: Unable to fetch user details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Ensure text fields are editable
    private void enableEditing() {
        fname.setEditable(true);
        lname.setEditable(true);
        email.setEditable(true);
        cont.setEditable(true);
        status.setEnabled(true); // Enable dropdowns
        role.setEnabled(true);
    }

// Email validation method
private boolean isValidEmail(String email) {
    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    return email.matches(regex);
}
private void clearFields() {
    fname.setText("");
    lname.setText("");
    email.setText("");
    cont.setText("");
    user.setText("");
    pass.setText("");
    status.setSelectedIndex(0); // Reset dropdown to default
    role.setSelectedIndex(0);   // Reset dropdown to default
}
// Hash password using SHA-256
private String hashPassword(String password) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashed = md.digest(password.getBytes());
        StringBuilder hex = new StringBuilder();
        for (byte b : hashed) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    } catch (NoSuchAlgorithmException e) {
        JOptionPane.showMessageDialog(this, "Error while hashing password", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    } 

    }//GEN-LAST:event_updatepanelMouseClicked

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        fetchUserDetails();
    }//GEN-LAST:event_formWindowActivated

    
    

    public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JTextField cont;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lname;
    private javax.swing.JPasswordField pass;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JPanel updatepanel;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
