package Authentication;

import config.config;
import config.EmailSender;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Random;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import admin.changepass;
import javax.mail.MessagingException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class Forgotpass extends javax.swing.JFrame {
    private String generatedOTP;
    private int userId;
    private String userEmail;
    private javax.swing.JLabel timerLabel;
    private javax.swing.Timer timer;
    private int remainingTime = 300; // 5 minutes in seconds

    /**
     * Creates new form Forgotpass
     */
    public Forgotpass() {
        initComponents();
        setLocationRelativeTo(null);
        user.setText("Email");
        npass.setText("Enter OTP sent to your email");
        
        // Disable verify button initially
        verify.setEnabled(false);
        verify.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        
        // Initialize timer label
        timerLabel = new javax.swing.JLabel();
        timerLabel.setFont(new java.awt.Font("Consolas", 0, 10));
        timerLabel.setForeground(new java.awt.Color(102, 102, 102));
        timerLabel.setText(" 05:00");
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setVisible(false); // Make timer initially invisible
        
        // Add timer label to the panel
        con.add(timerLabel);
        timerLabel.setBounds(28, 220, 80, 15);
        
        // Initialize timer
        timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remainingTime--;
                if (remainingTime <= 0) {
                    timer.stop();
                    sendotp.setEnabled(true);
                    sendotp.setBackground(new java.awt.Color(204, 204, 204));
                    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
                    timerLabel.setText("Expired");
                    timerLabel.setVisible(false); // Hide timer when expired
                    // Disable verify button when OTP expires
                    verify.setEnabled(false);
                    verify.setBackground(new java.awt.Color(153, 153, 153));
                    jLabel3.setForeground(new java.awt.Color(102, 102, 102));
                } else {
                    int minutes = remainingTime / 60;
                    int seconds = remainingTime % 60;
                    timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        con = new javax.swing.JPanel();
        Email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        sendotp = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        OTP = new javax.swing.JPasswordField();
        npass = new javax.swing.JLabel();
        verify = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        backbutton = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        con.setBackground(new java.awt.Color(255, 255, 255));
        con.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        con.setForeground(new java.awt.Color(153, 153, 153));

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel1.setText("FORGOT PASSWORD");

        sendotp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        sendotp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendotpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sendotpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sendotpMouseExited(evt);
            }
        });

        jLabel2.setText("Send OTP");

        javax.swing.GroupLayout sendotpLayout = new javax.swing.GroupLayout(sendotp);
        sendotp.setLayout(sendotpLayout);
        sendotpLayout.setHorizontalGroup(
            sendotpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendotpLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        sendotpLayout.setVerticalGroup(
            sendotpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sendotpLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        user.setText("Enter Contact");

        OTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OTPActionPerformed(evt);
            }
        });

        npass.setText("Enter OTP");

        verify.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        verify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verifyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verifyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verifyMouseExited(evt);
            }
        });

        jLabel3.setText("Verify OTP");

        javax.swing.GroupLayout verifyLayout = new javax.swing.GroupLayout(verify);
        verify.setLayout(verifyLayout);
        verifyLayout.setHorizontalGroup(
            verifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verifyLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        verifyLayout.setVerticalGroup(
            verifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, verifyLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

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
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user)
                            .addComponent(npass)
                            .addComponent(OTP, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(conLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(sendotp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        conLayout.setVerticalGroup(
            conLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(npass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(conLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendotp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel2.add(con, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 260, 250));

        backbutton.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        backbutton.setForeground(new java.awt.Color(255, 255, 255));
        backbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-logout-24.png"))); // NOI18N
        backbutton.setText("back");
        backbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbuttonMouseClicked(evt);
            }
        });
        jPanel2.add(backbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forgot pass.png"))); // NOI18N
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed

    }//GEN-LAST:event_EmailActionPerformed

    private void sendotpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendotpMouseClicked
        String email = Email.getText().trim();
        
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your email address", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        config connect = new config();
        try {
            // Check if email exists in database
            String checkSql = "SELECT u_id, email FROM user WHERE email = ?";
            PreparedStatement checkStmt = connect.prepareStatement(checkSql);
            checkStmt.setString(1, email);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                userId = rs.getInt("u_id");
                userEmail = rs.getString("email");
                
                try {
                    // Generate and send OTP via email
                    generatedOTP = EmailSender.sendVerificationPin(userEmail, "User");
                    
                    // Store OTP in database
                    String insertSql = "INSERT INTO forget_pass (u_id, email, otp, expires_at) VALUES (?, ?, ?, ?)";
                    PreparedStatement insertStmt = connect.prepareStatement(insertSql);
                    insertStmt.setInt(1, userId);
                    insertStmt.setString(2, email);
                    insertStmt.setString(3, generatedOTP);
                    insertStmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now().plusMinutes(5)));
                    insertStmt.executeUpdate();

                    // Disable the send OTP button after successful OTP generation
                    sendotp.setEnabled(false);
                    sendotp.setBackground(new java.awt.Color(153, 153, 153));
                    jLabel2.setForeground(new java.awt.Color(102, 102, 102));

                    // Enable verify button after OTP is sent
                    verify.setEnabled(true);
                    verify.setBackground(new java.awt.Color(204, 204, 204));
                    jLabel3.setForeground(new java.awt.Color(0, 0, 0));

                    // Reset and start the timer
                    remainingTime = 300;
                    timer.start();
                    timerLabel.setText("OTP expires in: 05:00");
                    timerLabel.setVisible(true); // Make timer visible when OTP is sent

                    JOptionPane.showMessageDialog(this, "OTP has been sent to your email address", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (MessagingException ex) {
                    JOptionPane.showMessageDialog(this, "Failed to send OTP email: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Email address not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            connect.closeConnection();
        }
    }//GEN-LAST:event_sendotpMouseClicked

    private void sendotpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendotpMouseEntered
        sendotp.setOpaque(true);
        sendotp.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_sendotpMouseEntered

    private void sendotpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendotpMouseExited
        sendotp.setOpaque(true);
        sendotp.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_sendotpMouseExited

    private void OTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OTPActionPerformed

    }//GEN-LAST:event_OTPActionPerformed

    private void backbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbuttonMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backbuttonMouseClicked

    private void verifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifyMouseClicked
     String enteredOTP = new String(OTP.getPassword()).trim();

if (enteredOTP.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please enter the OTP", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

if (userId == 0) {
    JOptionPane.showMessageDialog(this, "Please send OTP first.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

config connect = new config();
try {
    String verifySql = "SELECT * FROM forget_pass WHERE u_id = ? AND otp = ? AND is_used = 0 AND expires_at > NOW()";
    PreparedStatement verifyStmt = connect.prepareStatement(verifySql);
    verifyStmt.setInt(1, userId);
    verifyStmt.setString(2, enteredOTP);
    ResultSet rs = verifyStmt.executeQuery();

    if (rs.next()) {
        // Mark OTP as used
        String updateSql = "UPDATE forget_pass SET is_used = 1 WHERE id = ?";
        PreparedStatement updateStmt = connect.prepareStatement(updateSql);
        updateStmt.setInt(1, rs.getInt("id"));
        updateStmt.executeUpdate();

        // Show success message
        JOptionPane.showMessageDialog(this, "OTP verified successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        // Fetch role from user table
        String roleSql = "SELECT role FROM user WHERE u_id = ?";
        PreparedStatement roleStmt = connect.prepareStatement(roleSql);
        roleStmt.setInt(1, userId);
        ResultSet roleRs = roleStmt.executeQuery();
        
        if (roleRs.next()) {
            String role = roleRs.getString("role");
            if ("admin".equalsIgnoreCase(role)) {
                new AdminChangepass(userId).setVisible(true);
            } else {
                new changepass(userId).setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Could not retrieve user role.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Invalid or expired OTP", "Error", JOptionPane.ERROR_MESSAGE);
    }
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Database error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
} finally {
    connect.closeConnection();
}

    }//GEN-LAST:event_verifyMouseClicked

    private void verifyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifyMouseEntered
        verify.setOpaque(true);
        verify.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_verifyMouseEntered

    private void verifyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifyMouseExited
        verify.setOpaque(true);
        verify.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_verifyMouseExited

    private String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // 6-digit OTP
        return String.valueOf(otp);
    }

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forgotpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Forgotpass().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Email;
    private javax.swing.JPasswordField OTP;
    private javax.swing.JLabel back;
    private javax.swing.JLabel backbutton;
    private javax.swing.JPanel con;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel npass;
    private javax.swing.JPanel sendotp;
    private javax.swing.JLabel user;
    private javax.swing.JPanel verify;
    // End of variables declaration//GEN-END:variables
}
