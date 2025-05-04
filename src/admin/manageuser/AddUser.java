

package admin.manageuser;

import admin.manageuser.Users;
import config.CroppingPanel;
import config.config;
import config.session;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class AddUser extends javax.swing.JFrame {

    /** Creates new form Add */
    public AddUser() {
        initComponents();
    }

   private File selectedProfileImageFile = null;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        addn = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        password = new javax.swing.JPasswordField();
        role = new javax.swing.JComboBox<>();
        username = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        photo1 = new javax.swing.JLabel();
        addphoto = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        backg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel18.setText("Email");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 20));

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel15.setText("Lastname");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, 20));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel14.setText("Firstname");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));

        jLabel24.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel24.setText(" Status");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 50, 20));

        jLabel23.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel23.setText("Contact");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, 20));

        jLabel22.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel22.setText("Username");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 50, 20));

        jLabel25.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel25.setText("Password");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 50, 20));

        jLabel21.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel21.setText("Role");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, 20));

        add.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });

        addn.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        addn.setText("ADD");

        javax.swing.GroupLayout addLayout = new javax.swing.GroupLayout(add);
        add.setLayout(addLayout);
        addLayout.setHorizontalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(addn)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        addLayout.setVerticalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(addn))
        );

        jPanel3.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, -1));

        fname.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        fname.setMinimumSize(new java.awt.Dimension(6, 20));
        jPanel3.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 140, 20));

        lname.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        lname.setPreferredSize(new java.awt.Dimension(6, 20));
        jPanel3.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 140, 20));

        email.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        email.setPreferredSize(new java.awt.Dimension(6, 20));
        jPanel3.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 140, 20));

        status.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active" }));
        status.setPreferredSize(new java.awt.Dimension(66, 20));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel3.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 140, 20));

        password.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        password.setMinimumSize(new java.awt.Dimension(6, 20));
        jPanel3.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 130, 20));

        role.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin", " " }));
        role.setPreferredSize(new java.awt.Dimension(54, 20));
        role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleActionPerformed(evt);
            }
        });
        jPanel3.add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 130, 20));

        username.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jPanel3.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 130, 20));

        contact.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        contact.setPreferredSize(new java.awt.Dimension(6, 20));
        jPanel3.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 130, 20));

        photo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-user-male-50.png"))); // NOI18N
        jPanel3.add(photo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 60, 70));

        addphoto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addphoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addphotoMouseClicked(evt);
            }
        });

        jLabel19.setText("add photo");

        javax.swing.GroupLayout addphotoLayout = new javax.swing.GroupLayout(addphoto);
        addphoto.setLayout(addphotoLayout);
        addphotoLayout.setHorizontalGroup(
            addphotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addphotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addphotoLayout.setVerticalGroup(
            addphotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addphotoLayout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(addphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 480, 320));

        backg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Black and White Modern Sign-up and Login Website Page UI Desktop Prototype.png"))); // NOI18N
        jPanel1.add(backg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 0, 800, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_addMouseExited

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_addMouseEntered

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        config connect = new config();

    // Retrieve user input
    String firstNameText = fname.getText().trim();
    String lastNameText = lname.getText().trim();
    String contactNumberText = contact.getText().trim();
    String emailText = email.getText().trim();
    String usernameText = username.getText().trim();
    char[] passwordChars = password.getPassword();
    String selectedRole = (String) role.getSelectedItem();
    String selectedStatus = (String) status.getSelectedItem();

    StringBuilder errorMessage = new StringBuilder();

    // Validation checks
    if (firstNameText.isEmpty() || lastNameText.isEmpty() || contactNumberText.isEmpty() ||
        emailText.isEmpty() || usernameText.isEmpty() || passwordChars.length == 0 ||
        selectedRole == null || selectedStatus == null) {

        errorMessage.append("Please fill out all required fields.\n");

    } else {
        if (!contactNumberText.matches("\\d{11}")) {
            errorMessage.append("Invalid contact number format. Must be 11 digits.\n");
        }
        if (!isValidEmail(emailText)) {
            errorMessage.append("Invalid email format.\n");
        } else if (isEmailTaken(emailText)) {
            errorMessage.append("Email is already taken.\n");
        }
        if (isUsernameTaken(usernameText)) {
            errorMessage.append("Username is already taken.\n");
        }
        if (!validatePassword(this.password)) {
            return;
        }
    }

    if (errorMessage.length() > 0) {
        JOptionPane.showMessageDialog(this, errorMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Hash password
    String passwordText = new String(passwordChars);
    String hashedPassword = hashPassword(passwordText);
    Arrays.fill(passwordChars, '0'); // clear password for security

    // Handle profile image
    String relativeProfilePath = "src/images/prof/default.png"; // default path if no image uploaded
    if (selectedProfileImageFile != null) {
        try {
            BufferedImage image = ImageIO.read(selectedProfileImageFile);
            String fileName = System.currentTimeMillis() + "_" + selectedProfileImageFile.getName(); // unique filename
            File destinationDir = new File("src/images/prof");
            if (!destinationDir.exists()) {
                destinationDir.mkdirs();
            }
            File destinationFile = new File(destinationDir, fileName);
            ImageIO.write(image, fileName.substring(fileName.lastIndexOf('.') + 1), destinationFile);
            relativeProfilePath = "src/images/prof/" + fileName;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to save profile image.\n" + e.getMessage(), "Image Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // SQL to insert user
    String sql = "INSERT INTO user (fname, lname, email, contact, username, password, status, role, profile_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
        pst.setString(1, firstNameText);
        pst.setString(2, lastNameText);
        pst.setString(3, emailText);
        pst.setString(4, contactNumberText);
        pst.setString(5, usernameText);
        pst.setString(6, hashedPassword);
        pst.setString(7, selectedStatus);
        pst.setString(8, selectedRole);
        pst.setString(9, relativeProfilePath); // save image path

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Account Registered Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        new Users().setVisible(true);
        this.dispose();

        // Clear fields
        fname.setText("");
        lname.setText("");
        contact.setText("");
        email.setText("");
        username.setText("");
        password.setText("");
        role.setSelectedIndex(0);
        status.setSelectedIndex(0);
        selectedProfileImageFile = null;

    } catch (SQLException ex) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Database Error: Unable to register account.", "Error", JOptionPane.ERROR_MESSAGE);
    }

        }

        // Check if username is already taken
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

        // Check if email is already taken
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

        // Validate email format
        private boolean isValidEmail(String email) {
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            return email.matches(regex);
        }

        // Validate password strength
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

        }

        private void showError(String message) {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_addMouseClicked

    private void roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void addphotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addphotoMouseClicked
 
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Choose an image");
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));

    int result = fileChooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        try {
            BufferedImage originalImage = ImageIO.read(selectedFile);

            CroppingPanel cropPanel = new CroppingPanel(originalImage);
            int confirm = JOptionPane.showConfirmDialog(null, new JScrollPane(cropPanel), "Crop Image", JOptionPane.OK_CANCEL_OPTION);

            if (confirm == JOptionPane.OK_OPTION) {
                BufferedImage croppedImage = cropPanel.getCroppedImage();

                if (croppedImage != null) {
                    int w1 = photo1.getWidth();
                    int h1 = photo1.getHeight();
                    Image resizedForPhoto1 = croppedImage.getScaledInstance(w1, h1, Image.SCALE_SMOOTH);

                    BufferedImage circleImage = new BufferedImage(w1, h1, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g2 = circleImage.createGraphics();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setClip(new java.awt.geom.Ellipse2D.Float(0, 0, w1, h1));
                    g2.drawImage(resizedForPhoto1, 0, 0, null);
                    g2.dispose();

                    photo1.setIcon(new ImageIcon(circleImage));

                    // ===== Save and update DB =====
                    String fileExtension = selectedFile.getName().substring(selectedFile.getName().lastIndexOf(".") + 1);
                    int targetUserId = getSelectedUserId(); // ✅ SELECTED USER ID, not current session

                    String fileName = "user_" + targetUserId + "." + fileExtension;
                    File destinationDirectory = new File("src/images/prof");
                    if (!destinationDirectory.exists()) {
                        destinationDirectory.mkdirs();
                    }

                    File destinationFile = new File(destinationDirectory, fileName);
                    ImageIO.write(croppedImage, fileExtension, destinationFile);
                    String relativePath = destinationFile.getPath();

                    // ===== Update database =====
                    String sql = "UPDATE mbatelier.user SET profile_image = ? WHERE u_id = ?";
                    config dbConfig = new config();
                    Connection connection = dbConfig.getConnection();

                    if (connection != null) {
                        PreparedStatement pstmt = connection.prepareStatement(sql);
                        pstmt.setString(1, relativePath);
                        pstmt.setInt(2, targetUserId);
                        pstmt.executeUpdate();
                        dbConfig.closeConnection();

                        // ✅ Only update session if this is the current user
                        session userSession = session.getInstance();
                        if (userSession.getUserId() == targetUserId) {
                            userSession.setProfileImage(relativePath);
                        }

                        JOptionPane.showMessageDialog(null, "Profile image updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Database connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading/cropping image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
private int getSelectedUserId() {
   
    return session.getInstance().getUserId(); // For now, fallback to current user
}


        private void displayProfileSection() {
            session userSession = session.getInstance();
            String imagePath = userSession.getProfileImage();

            if (imagePath != null && !imagePath.isEmpty()) {
                try {
                    BufferedImage image = ImageIO.read(new File(imagePath));
                    // Scale and process the image as needed (similar to your upload code)
                    int w1 = photo1.getWidth();
                    int h1 = photo1.getHeight();
                    Image resizedForPhoto1 = image.getScaledInstance(w1, h1, Image.SCALE_SMOOTH);

                    BufferedImage circleImage = new BufferedImage(w1, h1, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g2 = circleImage.createGraphics();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setClip(new java.awt.geom.Ellipse2D.Float(0, 0, w1, h1));
                    g2.drawImage(resizedForPhoto1, 0, 0, null);
                    g2.dispose();

                   

                    photo1.setIcon(new ImageIcon(circleImage));
                   

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error loading image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // ... rest of the code to display the profile section
    }//GEN-LAST:event_addphotoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add;
    private javax.swing.JLabel addn;
    private javax.swing.JPanel addphoto;
    private javax.swing.JLabel backg;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField lname;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel photo1;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
