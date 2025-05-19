/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.manageclothes;

import config.config;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.DriverManager;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author Administrator
 */
public class UpdateClothes extends javax.swing.JFrame {
    private String clothingId;
    private File selectedClothingImageFile = null;
    config connect = new config();
    
    public UpdateClothes(int clothingId) {
        initComponents();
        this.clothingId = String.valueOf(clothingId);
        setLocationRelativeTo(null);
        fetchClothingDetails();
    }

    private void fetchClothingDetails() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            con = connect.getConnection();
            if (con == null) {
                JOptionPane.showMessageDialog(this, 
                    "Cannot connect to database. Please check your database connection.", 
                    "Connection Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            pst = con.prepareStatement("SELECT * FROM clothes WHERE clothesid = ?");
            pst.setString(1, clothingId);
            rs = pst.executeQuery();

            if (rs.next()) {
                // Set text fields
                clothname.setText(rs.getString("clothname"));
                price.setText(String.valueOf(rs.getDouble("price")));
                category.setText(rs.getString("category"));
                description.setText(rs.getString("description"));
                size.setSelectedItem(rs.getString("sizes"));
                availability.setSelectedItem(rs.getString("availability"));
                color.setText(rs.getString("color"));
                
                // Load and display the image if it exists
                String imagePath = rs.getString("photo_path");
                if (imagePath != null && !imagePath.isEmpty()) {
                    try {
                        // First try loading from resources
                        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/" + imagePath));
                        if (imageIcon.getIconWidth() > 0) {
                            Image image = imageIcon.getImage().getScaledInstance(photo1.getWidth(), photo1.getHeight(), Image.SCALE_SMOOTH);
                            photo1.setIcon(new ImageIcon(image));
                        } else {
                            // If not in resources, try loading from file system
                            File imageFile = new File(imagePath);
                            if (imageFile.exists()) {
                                ImageIcon fileIcon = new ImageIcon(imageFile.getAbsolutePath());
                                Image image = fileIcon.getImage().getScaledInstance(photo1.getWidth(), photo1.getHeight(), Image.SCALE_SMOOTH);
                                photo1.setIcon(new ImageIcon(image));
                            } else {
                                photo1.setIcon(null);
                                photo1.setText("Image not found");
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error loading image: " + e.getMessage());
                        photo1.setIcon(null);
                        photo1.setText("Image Error");
                    }
                } else {
                    photo1.setIcon(null);
                    photo1.setText("No Image");
                }
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Clothing item with ID " + clothingId + " not found in database.", 
                    "Not Found", 
                    JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Database error: " + e.getMessage() + "\nPlease check your database connection and try again.", 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        clothname = new javax.swing.JTextField();
        size = new javax.swing.JComboBox<>();
        category = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        availability = new javax.swing.JComboBox<>();
        update = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        color = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        photo1 = new javax.swing.JLabel();
        updatephoto = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setLayout(new BorderLayout());
        
        // Create a panel for the form fields
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new java.awt.Insets(5, 5, 5, 5);
        
        // Add form fields
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Cloth name"), gbc);
        gbc.gridx = 1;
        formPanel.add(clothname, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Size"), gbc);
        gbc.gridx = 1;
        formPanel.add(size, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Price"), gbc);
        gbc.gridx = 1;
        formPanel.add(price, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Category"), gbc);
        gbc.gridx = 1;
        formPanel.add(category, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Availability"), gbc);
        gbc.gridx = 1;
        formPanel.add(availability, gbc);
        
        gbc.gridx = 0; gbc.gridy = 5;
        formPanel.add(new JLabel("Color"), gbc);
        gbc.gridx = 1;
        formPanel.add(color, gbc);
        
        gbc.gridx = 0; gbc.gridy = 6;
        formPanel.add(new JLabel("Description"), gbc);
        gbc.gridx = 1;
        formPanel.add(description, gbc);
        
        jPanel2.add(formPanel, BorderLayout.CENTER);
        
        // Add update button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(update);
        jPanel2.add(buttonPanel, BorderLayout.SOUTH);
        
        // Add image panel
        JPanel imagePanel = new JPanel();
        imagePanel.add(photo1);
        imagePanel.add(updatephoto);
        jPanel2.add(imagePanel, BorderLayout.WEST);

        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        jLabel2.setText("UPDATE");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cloth name");

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Size");

        jLabel18.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Prize");

        jLabel23.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Category");

        jLabel22.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Description");

        jLabel24.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Availability");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Color");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/e.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void clothnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clothnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clothnameActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

    }//GEN-LAST:event_jLabel2MouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {
        String clothName = clothname.getText().trim();
        String priceText = price.getText().trim();
        String categoryText = category.getText().trim();
        String descriptionText = description.getText().trim();
        String selectedSize = (String) size.getSelectedItem();
        String selectedAvailability = (String) availability.getSelectedItem();
        String colorText = color.getText().trim();

        // Validate all fields
        StringBuilder errorMessage = new StringBuilder();
        if (clothName.isEmpty()) errorMessage.append("Cloth name is required.\n");
        if (priceText.isEmpty()) errorMessage.append("Price is required.\n");
        if (categoryText.isEmpty()) errorMessage.append("Category is required.\n");
        if (descriptionText.isEmpty()) errorMessage.append("Description is required.\n");
        if (colorText.isEmpty()) errorMessage.append("Color is required.\n");

        // Validate price format
        double priceValue = 0.0;
        try {
            priceValue = Double.parseDouble(priceText);
            if (priceValue <= 0) {
                errorMessage.append("Price must be greater than 0.\n");
            }
        } catch (NumberFormatException e) {
            errorMessage.append("Invalid price format.\n");
        }

        if (errorMessage.length() > 0) {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Handle image path
        String imagePath = null;
        if (selectedClothingImageFile != null) {
            // Copy the new image to the project's images directory
            try {
                String targetDir = "src/images/clothes/";
                File targetDirFile = new File(targetDir);
                if (!targetDirFile.exists()) {
                    targetDirFile.mkdirs();
                }

                String fileName = "cloth_" + clothingId + "_" + System.currentTimeMillis() + 
                                selectedClothingImageFile.getName().substring(selectedClothingImageFile.getName().lastIndexOf("."));
                File targetFile = new File(targetDir + fileName);
                
                java.nio.file.Files.copy(
                    selectedClothingImageFile.toPath(),
                    targetFile.toPath(),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING
                );
                
                imagePath = "images/clothes/" + fileName;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error saving image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        try (Connection con = connect.getConnection()) {
            String sql = "UPDATE clothes SET clothname = ?, price = ?, category = ?, description = ?, " +
                        "sizes = ?, availability = ?, color = ?";
            
            if (imagePath != null) {
                sql += ", photo_path = ?";
            }
            
            sql += " WHERE clothesid = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, clothName);
            pst.setDouble(2, priceValue);
            pst.setString(3, categoryText);
            pst.setString(4, descriptionText);
            pst.setString(5, selectedSize);
            pst.setString(6, selectedAvailability);
            pst.setString(7, colorText);
            
            int paramIndex = 8;
            if (imagePath != null) {
                pst.setString(paramIndex++, imagePath);
            }
            pst.setString(paramIndex, clothingId);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Clothing item updated successfully!");
                // Return to the clothes list
                new Clothes().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No changes were made.", "Update Failed", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updatephotoMouseClicked(java.awt.event.MouseEvent evt) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setDialogTitle("Update Photo");

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedClothingImageFile = chooser.getSelectedFile();
            try {
                // Display the selected image
                ImageIcon imageIcon = new ImageIcon(selectedClothingImageFile.getAbsolutePath());
                Image image = imageIcon.getImage().getScaledInstance(photo1.getWidth(), photo1.getHeight(), Image.SCALE_SMOOTH);
                photo1.setIcon(new ImageIcon(image));
                photo1.setText(""); // Clear any text if it was set
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error loading image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       fetchClothingDetails();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(UpdateClothes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateClothes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateClothes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateClothes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateClothes(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> availability;
    private javax.swing.JTextField category;
    private javax.swing.JTextField clothname;
    private javax.swing.JTextField color;
    private javax.swing.JTextField description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel photo1;
    private javax.swing.JTextField price;
    private javax.swing.JComboBox<String> size;
    private javax.swing.JPanel update;
    private javax.swing.JPanel updatephoto;
    // End of variables declaration//GEN-END:variables
}
