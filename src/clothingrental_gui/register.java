
package clothingrental_gui;

import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class register extends javax.swing.JFrame {

    
    public register() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        user = new javax.swing.JTextField();
        cont = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        register = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        registerback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        parent.setBackground(new java.awt.Color(204, 204, 204));
        parent.setMaximumSize(new java.awt.Dimension(800, 400));
        parent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Your Account");
        parent.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PASSWORD ");
        jLabel2.setIconTextGap(0);
        parent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        email.setForeground(new java.awt.Color(102, 102, 102));
        email.setCaretColor(new java.awt.Color(102, 102, 102));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        parent.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 220, -1));

        user.setForeground(new java.awt.Color(102, 102, 102));
        user.setCaretColor(new java.awt.Color(102, 102, 102));
        parent.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 220, -1));

        cont.setForeground(new java.awt.Color(102, 102, 102));
        cont.setCaretColor(new java.awt.Color(102, 102, 102));
        parent.add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 220, -1));

        fname.setForeground(new java.awt.Color(102, 102, 102));
        fname.setCaretColor(new java.awt.Color(102, 102, 102));
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        parent.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 220, -1));

        lname.setForeground(new java.awt.Color(102, 102, 102));
        lname.setCaretColor(new java.awt.Color(102, 102, 102));
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        parent.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 220, -1));
        parent.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 220, -1));

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FIRSTNAME");
        parent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("USERNAME");
        parent.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("EMAIL");
        parent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, 10));

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CONTACT");
        parent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 50, -1));

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("LASTNAME");
        jLabel9.setAlignmentY(0.0F);
        jLabel9.setIconTextGap(1);
        parent.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Already have an Account!");
        parent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        login.setBackground(new java.awt.Color(204, 255, 255));
        login.setForeground(new java.awt.Color(153, 255, 255));
        login.setText("LOGIN");
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
        parent.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        register.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel8.setText("REGISTER");

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );

        parent.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 80, 20));

        registerback.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        registerback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/register.png"))); // NOI18N
        parent.add(registerback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
           new Login().setVisible(true);
           this.dispose();
           
    }//GEN-LAST:event_loginMouseClicked

    private void registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseEntered
        register.setOpaque(true);
   register.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_registerMouseEntered

    private void registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseExited
        register.setOpaque(true);
   register.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_registerMouseExited

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
         login.setOpaque(true);
   login.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
        login.setOpaque(true);
   login.setBackground(new java.awt.Color(50,50,50));
    }//GEN-LAST:event_loginMouseExited

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
       
    config connect = new config();

    // Get user inputs
    String firstname = fname.getText().trim();
    String lastname = lname.getText().trim(); // Fixed wrong variable
    String email1 = email.getText().trim();
    String contact = cont.getText().trim();
    String username = user.getText().trim();
    String password = pass.getText().trim();
    String status = "Pending";
    String role = "User";

    // Check if all fields are empty
    if (isAllFieldsEmpty()) {
        showError("Please fill out the registration form");
        return;
    }

    // Individual Field Validations
    if (firstname.isEmpty()) {
        showError("First Name cannot be empty");
        return;
    }

    if (lastname.isEmpty()) {
        showError("Last Name cannot be empty");
        return;
    }

    if (email1.isEmpty()) {
        showError("Email cannot be empty");
        return;
    }

    if (!isValidEmail(email1)) {
        showError("Invalid email format");
        return;
    }

    if (isEmailTaken(email1)) {
        showError("Email is already in use");
        return;
    }

    if (contact.isEmpty()) {
        showError("Contact Number cannot be empty");
        return;
    }

    if (!contact.matches("\\d+")) {
        showError("Contact Number must contain only numbers");
        return;
    }

    if (username.isEmpty()) {
        showError("Username cannot be empty");
        return;
    }

    if (isUsernameTaken(username)) {
        showError("Username is already taken");
        return;
    }

    if (!validatePassword(pass)) {
        return;
    }

    // Hash the password before storing
    String hashedPassword = hashPassword(password);
    if (hashedPassword == null) return;

    // Insert data into database
    String sql = "INSERT INTO user (fname, lname, email, contact, username, password, status, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
        pst.setString(1, firstname);
        pst.setString(2, lastname);
        pst.setString(3, email1);
        pst.setString(4, contact);
        pst.setString(5, username);
        pst.setString(6, hashedPassword);
        pst.setString(7, status);
        pst.setString(8, role);

        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
          new Login().setVisible(true);
          this.dispose();
        clearFields();
    } catch (SQLException ex) {
        ex.printStackTrace();
        showError("Database error occurred during registration.");
    }
    }//GEN-LAST:event_registerMouseClicked

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cont;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lname;
    private javax.swing.JLabel login;
    private javax.swing.JPanel parent;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPanel register;
    private javax.swing.JLabel registerback;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

   private boolean isUsernameTaken(String username) {
    config connect = new config();
    String sql = "SELECT COUNT(*) FROM user WHERE username = ?";
    try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
        pst.setString(1, username);
        try (ResultSet rs = pst.executeQuery()) {
            return rs.next() && rs.getInt(1) > 0;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}

private boolean isEmailTaken(String email) {
    config connect = new config();
    String sql = "SELECT COUNT(*) FROM user WHERE email = ?";
    try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
        pst.setString(1, email);
        try (ResultSet rs = pst.executeQuery()) {
            return rs.next() && rs.getInt(1) > 0;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}

private boolean isValidEmail(String email) {
    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    return email.matches(regex);
}

private boolean isAllFieldsEmpty() {
    return fname.getText().trim().isEmpty() &&
           lname.getText().trim().isEmpty() &&
           email.getText().trim().isEmpty() &&
           cont.getText().trim().isEmpty() &&
           user.getText().trim().isEmpty() &&
           pass.getText().trim().isEmpty();
}

private void showError(String message) {
    JOptionPane.showMessageDialog(this, message, "Validation Error", JOptionPane.ERROR_MESSAGE);
}

private void clearFields() {
    fname.setText("");
    lname.setText("");
    email.setText("");
    cont.setText("");
    user.setText("");
    pass.setText("");
}
private boolean validatePassword(JPasswordField passwordField) {
    String password = new String(passwordField.getPassword());
    StringBuilder errorMessage = new StringBuilder();
    boolean isValid = true;

    if (password.isEmpty()) {
        errorMessage.append("Password cannot be empty.\n");
        isValid = false;
    }
    if (password.length() < 8) {
        errorMessage.append("Password must be at least 8 characters long.\n");
        isValid = false;
    }
    if (!password.matches(".*[A-Z].*")) {
        errorMessage.append("Password must contain at least one uppercase letter.\n");
        isValid = false;
    }
    if (!password.matches(".*[a-z].*")) {
        errorMessage.append("Password must contain at least one lowercase letter.\n");
        isValid = false;
    }
    if (!password.matches(".*\\d.*")) {
        errorMessage.append("Password must contain at least one digit.\n");
        isValid = false;
    }
    if (!password.matches(".*[!@#$%^&*()_+=\\-\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
        errorMessage.append("Password must contain at least one special character.\n");
        isValid = false;
    }

    if (!isValid) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imgs/error.png"));
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Password Validation", JOptionPane.ERROR_MESSAGE, icon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Password Validation", JOptionPane.ERROR_MESSAGE);
        }
    }
    return isValid;

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
        showError("Error while hashing password");
        return null;
    }
}
}