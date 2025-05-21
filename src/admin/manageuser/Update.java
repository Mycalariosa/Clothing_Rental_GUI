
package admin.manageuser;

import config.config;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import admin.manageuser.Users;
import Authentication.Login;

/**
 *
 * @author Administrator
 */
public class Update extends javax.swing.JFrame {

   private config connect = new config();
    private String username;

    
public Update(String username) {
    initComponents();
   this.username = username;
        fetchUserDetails();
        user.setEditable(false); // Prevent editing of username
    }

    private Update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void fetchUserDetails() {
        String sql = "SELECT fname, lname, email, contact, status, role FROM user WHERE username = ?";
        System.out.println("Fetching details for username: " + username);
        try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("ResultSet has next: true"); // User found
                fname.setText(rs.getString("fname"));
                lname.setText(rs.getString("lname"));
                email.setText(rs.getString("email"));
                cont.setText(rs.getString("contact"));
                status.setSelectedItem(rs.getString("status"));
                role.setSelectedItem(rs.getString("role"));
                user.setText(username);
            } else {
                System.out.println("ResultSet has next: false"); // User not found
                JOptionPane.showMessageDialog(this, "No user found with the username: " + username, "Error", JOptionPane.ERROR_MESSAGE);
                // Optionally, you might want to close this update form or navigate back
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: Unable to fetch user details.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        cont = new javax.swing.JTextField();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        status = new javax.swing.JComboBox<>();
        role = new javax.swing.JComboBox<>();
        updatepanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fname.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        fname.setForeground(new java.awt.Color(102, 102, 102));
        fname.setCaretColor(new java.awt.Color(102, 102, 102));
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        getContentPane().add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 220, -1));

        lname.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        lname.setForeground(new java.awt.Color(102, 102, 102));
        lname.setCaretColor(new java.awt.Color(102, 102, 102));
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        getContentPane().add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 220, -1));

        email.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        email.setForeground(new java.awt.Color(102, 102, 102));
        email.setCaretColor(new java.awt.Color(102, 102, 102));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 220, -1));

        cont.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        cont.setForeground(new java.awt.Color(102, 102, 102));
        cont.setCaretColor(new java.awt.Color(102, 102, 102));
        getContentPane().add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 220, -1));

        user.setEditable(false);
        user.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        user.setForeground(new java.awt.Color(102, 102, 102));
        user.setCaretColor(new java.awt.Color(102, 102, 102));
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 220, -1));

        pass.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 220, 20));

        status.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 220, -1));

        role.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleActionPerformed(evt);
            }
        });
        getContentPane().add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 220, -1));

        updatepanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updatepanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatepanelMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel10.setText("Update");

        javax.swing.GroupLayout updatepanel2Layout = new javax.swing.GroupLayout(updatepanel2);
        updatepanel2.setLayout(updatepanel2Layout);
        updatepanel2Layout.setHorizontalGroup(
            updatepanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatepanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel10)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        updatepanel2Layout.setVerticalGroup(
            updatepanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatepanel2Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        getContentPane().add(updatepanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        jLabel21.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Role");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, 20));

        jLabel24.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText(" Status");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 50, 20));

        jLabel25.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Password");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 50, 20));

        jLabel22.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Username");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 50, 20));

        jLabel23.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Contact");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, 20));

        jLabel18.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Email");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, 20));

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Lastname");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 50, 20));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Firstname");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, 20));

        back.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/e.png"))); // NOI18N
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 560, 420));

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
 

    
    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        fetchUserDetails();
        
    }//GEN-LAST:event_formWindowActivated

    private void updatepanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatepanelMouseClicked
        if (!validateInput())
            return;

        String firstname = fname.getText().trim();
        String lastname = lname.getText().trim();
        String email1 = email.getText().trim();
        String contact = cont.getText().trim();
        String newUsername = user.getText().trim(); // Should match original
        String password = new String(pass.getPassword()).trim(); // Get password from JPasswordField
        String selectedStatus = (String) status.getSelectedItem();
        String selectedRole = (String) role.getSelectedItem();

        String hashedPassword = password.isEmpty() ? null : hashPassword(password);

        String sql;
        if (hashedPassword == null) {
            sql = "UPDATE user SET fname = ?, lname = ?, email = ?, contact = ?, username = ?, status = ?, role = ? WHERE username = ?";
        } else {
            sql = "UPDATE user SET fname = ?, lname = ?, email = ?, contact = ?, password = ?, username = ?, status = ?, role = ? WHERE username = ?";
        }

        try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
            pst.setString(1, firstname);
            pst.setString(2, lastname);
            pst.setString(3, email1);
            pst.setString(4, contact);

            if (hashedPassword == null) {
                pst.setString(5, newUsername);
                pst.setString(6, selectedStatus);
                pst.setString(7, selectedRole);
                pst.setString(8, this.username); // original username from constructor
            } else {
                pst.setString(5, hashedPassword);
                pst.setString(6, newUsername);
                pst.setString(7, selectedStatus);
                pst.setString(8, selectedRole);
                pst.setString(9, this.username); // original username
            }

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "User updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new Users().setVisible(true); // Assuming 'Users' is the form to navigate back to
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No user found with the provided username.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: Unable to update account.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }                                        

    private void enableEditing() {
        fname.setEditable(true);
        lname.setEditable(true);
        email.setEditable(true);
        cont.setEditable(true);
        user.setEditable(false); // Do not allow username to be changed
        pass.setEditable(true);
        status.setEnabled(true);
        role.setEnabled(true);
    }

    private boolean validateInput() {
        if (fname.getText().isEmpty() || lname.getText().isEmpty() || email.getText().isEmpty()
                || cont.getText().isEmpty() || user.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields except password must be filled.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!isValidEmail(email.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Invalid email format.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }

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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JTextField lname;
    private javax.swing.JPasswordField pass;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JPanel updatepanel2;
    public javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
