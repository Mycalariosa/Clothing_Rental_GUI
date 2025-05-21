/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.manageclothes;

import config.CroppingPanel;
import config.config;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Administrator
 */
public class UpdateClothes extends javax.swing.JFrame {

    private int clothingId;
    private File selectedClothingImageFile = null;

    /**
     * Creates new form UpdateClothes
     */
    public UpdateClothes(int clothingId) {
        this.clothingId = clothingId;
        initComponents();
        loadClothingDetails();
    }

    private void loadClothingDetails() {
        try {
            config connect = new config();
            Connection con = connect.getConnection();
            PreparedStatement pst = con.prepareStatement(
                "SELECT * FROM clothes WHERE clothesid = ?"
            );
            pst.setInt(1, clothingId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                clothname.setText(rs.getString("clothname"));
                price.setText(String.valueOf(rs.getDouble("price")));
                category.setText(rs.getString("category"));
                description.setText(rs.getString("description"));
                size.setSelectedItem(rs.getString("sizes"));
                availability.setSelectedItem(rs.getString("availability"));
                color.setText(rs.getString("color"));

                // Load and display the image
                String imagePath = rs.getString("photo_path");
                if (imagePath != null && !imagePath.isEmpty()) {
                    try {
                        // Try to load from the full path first
                        File imageFile = new File(imagePath);
                        if (!imageFile.exists()) {
                            // If not found, try with src/ prefix
                            imageFile = new File("src/" + imagePath);
                        }
                        
                        if (imageFile.exists()) {
                            BufferedImage originalImage = ImageIO.read(imageFile);
                            if (originalImage != null) {
                                int w1 = photo1.getWidth();
                                int h1 = photo1.getHeight();
                                
                                // Create a circular mask
                                BufferedImage circleImage = new BufferedImage(w1, h1, BufferedImage.TYPE_INT_ARGB);
                                Graphics2D g2 = circleImage.createGraphics();
                                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                g2.setClip(new Ellipse2D.Float(0, 0, w1, h1));
                                
                                // Scale the image to fit the circle
                                Image scaledImage = originalImage.getScaledInstance(w1, h1, Image.SCALE_SMOOTH);
                                g2.drawImage(scaledImage, 0, 0, null);
                                g2.dispose();
                                
                                photo1.setIcon(new ImageIcon(circleImage));
                                photo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                                photo1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                            } else {
                                System.out.println("Failed to read image: " + imageFile.getAbsolutePath());
                            }
                        } else {
                            System.out.println("Image file not found: " + imageFile.getAbsolutePath());
                        }
                    } catch (IOException e) {
                        System.out.println("Error loading image: " + e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("No image path found for clothing ID: " + clothingId);
                }
            }

            rs.close();
            pst.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading clothing details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        photo1 = new javax.swing.JLabel();
        addphoto = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        clothname = new javax.swing.JTextField();
        size = new javax.swing.JComboBox<>();
        category = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        availability = new javax.swing.JComboBox<>();
        updateclothes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        color = new javax.swing.JTextField();
        backbutton = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photo1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photo1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 160, 210));

        addphoto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addphoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addphotoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addphoto.setBackground(new java.awt.Color(200, 200, 200));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addphoto.setBackground(new java.awt.Color(255, 255, 255));
            }
        });

        jLabel19.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel19.setText("Change Photo");

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

        jPanel2.add(addphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        clothname.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        clothname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clothnameActionPerformed(evt);
            }
        });
        jPanel2.add(clothname, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 150, 20));

        size.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large" }));
        jPanel2.add(size, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 150, -1));

        category.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jPanel2.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 150, -1));

        price.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jPanel2.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 150, -1));

        availability.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        availability.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Unavailable" }));
        jPanel2.add(availability, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 150, -1));

        updateclothes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateclothesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateclothes.setBackground(new java.awt.Color(200, 200, 200));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateclothes.setBackground(new java.awt.Color(255, 255, 255));
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel1.setText("Upddate");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout updateclothesLayout = new javax.swing.GroupLayout(updateclothes);
        updateclothes.setLayout(updateclothesLayout);
        updateclothesLayout.setHorizontalGroup(
            updateclothesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateclothesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        updateclothesLayout.setVerticalGroup(
            updateclothesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateclothesLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel2.add(updateclothes, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 60, 20));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cloth name");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, 20));

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Size");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 50, 20));

        jLabel18.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Prize");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, 20));

        jLabel23.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Category");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, 20));

        jLabel22.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Description");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 80, 20));

        description.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jPanel2.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 150, 50));

        jLabel24.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Availability");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 80, 20));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Color");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        color.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jPanel2.add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 150, -1));

        backbutton.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        backbutton.setForeground(new java.awt.Color(255, 255, 255));
        backbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-logout-24.png"))); // NOI18N
        backbutton.setText("Exit");
        backbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbuttonMouseClicked(evt);
            }
        });
        jPanel2.add(backbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/f.png"))); // NOI18N
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addphotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addphotoMouseClicked

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose an image");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));

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
                        Image resizedForLabel = croppedImage.getScaledInstance(w1, h1, Image.SCALE_SMOOTH);

                        BufferedImage circleImage = new BufferedImage(w1, h1, BufferedImage.TYPE_INT_ARGB);
                        Graphics2D g2 = circleImage.createGraphics();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2.setClip(new Ellipse2D.Float(0, 0, w1, h1));
                        g2.drawImage(resizedForLabel, 0, 0, null);
                        g2.dispose();

                        photo1.setIcon(new ImageIcon(circleImage));

                        // Save cropped image to "src/images/clothes/"
                        String ext = selectedFile.getName().substring(selectedFile.getName().lastIndexOf(".") + 1);
                        String filename = "clothes_" + System.currentTimeMillis() + "." + ext;
                        String relativePath = "src/images/clothes/" + filename;
                        File outputFile = new File(relativePath);
                        ImageIO.write(croppedImage, ext, outputFile);

                        selectedClothingImageFile = outputFile; // Save the file for later use in DB
                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error processing image: " + ex.getMessage(), "Image Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // ... rest of the code to display the profile section
    }//GEN-LAST:event_addphotoMouseClicked

    private void clothnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clothnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clothnameActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void updateclothesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateclothesMouseClicked
        config connect = new config();

        String clothName = clothname.getText().trim();
        String priceText = price.getText().trim();
        String categoryText = category.getText().trim();
        String descriptionText = description.getText().trim();
        String selectedSize = (String) size.getSelectedItem();
        String selectedAvailability = (String) availability.getSelectedItem();
        String colorText = color.getText().trim();

        StringBuilder errorMessage = new StringBuilder();

        if (clothName.isEmpty() || priceText.isEmpty() || categoryText.isEmpty() ||
            descriptionText.isEmpty() || selectedSize == null || selectedAvailability == null || colorText.isEmpty()) {
            errorMessage.append("Please fill in all fields.\n");
        }

        double priceValue = 0.0;
        try {
            priceValue = Double.parseDouble(priceText);
            if (priceValue <= 0) {
                errorMessage.append("Price must be a positive number.\n");
            }
        } catch (NumberFormatException e) {
            errorMessage.append("Invalid price format.\n");
        }

        if (errorMessage.length() > 0) {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Finalize image path
        String imagePath = null;
        if (selectedClothingImageFile != null) {
            imagePath = selectedClothingImageFile.getPath().replace("src/", "").replace("\\", "/");
        }

        try {
            Connection con = connect.getConnection();
            
            // Check for active rentals if trying to set availability to Available
            if (selectedAvailability.equals("Available")) {
                PreparedStatement checkRental = con.prepareStatement(
                    "SELECT COUNT(*) FROM rental WHERE clothesid = ? AND status = 'Rented'"
                );
                checkRental.setInt(1, clothingId);
                ResultSet rs = checkRental.executeQuery();
                
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(this, 
                        "Cannot set availability to Available while item is still rented out.", 
                        "Validation Error", 
                        JOptionPane.ERROR_MESSAGE);
                    checkRental.close();
                    con.close();
                    return;
                }
                checkRental.close();
            }
            
            // Start transaction
            con.setAutoCommit(false);
            
            try {
                StringBuilder query = new StringBuilder(
                    "UPDATE clothes SET clothname = ?, price = ?, category = ?, description = ?, " +
                    "sizes = ?, availability = ?, color = ?"
                );
                
                // Only update photo_path if a new image was selected
                if (imagePath != null) {
                    query.append(", photo_path = ?");
                }
                
                query.append(" WHERE clothesid = ?");
                
                PreparedStatement pst = con.prepareStatement(query.toString());

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
                pst.setInt(paramIndex, clothingId);

                int rows = pst.executeUpdate();
                
                // If availability is changed to "Available", update rental status
                if (selectedAvailability.equals("Available")) {
                    PreparedStatement updateRental = con.prepareStatement(
                        "UPDATE rental SET status = 'Returned' WHERE clothesid = ? AND status = 'Rented'"
                    );
                    updateRental.setInt(1, clothingId);
                    updateRental.executeUpdate();
                    updateRental.close();
                }

                if (rows > 0) {
                    // Commit transaction
                    con.commit();
                    JOptionPane.showMessageDialog(this, "Clothing item updated successfully.");
                    selectedClothingImageFile = null;

                    // Navigate back to Clothes.java
                    new Clothes().setVisible(true);
                    this.dispose();
                } else {
                    // Rollback transaction
                    con.rollback();
                    JOptionPane.showMessageDialog(this, "Failed to update clothing item.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                pst.close();
            } catch (SQLException e) {
                // Rollback transaction on error
                con.rollback();
                throw e;
            } finally {
                // Reset auto-commit
                con.setAutoCommit(true);
                con.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateclothesMouseClicked

    private void backbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbuttonMouseClicked
        new Clothes().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backbuttonMouseClicked

    private void clearForm() {
        clothname.setText("");
        price.setText("");
        category.setText("");
        description.setText("");
        color.setText("");
        size.setSelectedIndex(0);
        availability.setSelectedIndex(0);
        photo1.setIcon(null);
        selectedClothingImageFile = null;
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
                // This form should only be opened from the Clothes class with a valid clothingId
                JOptionPane.showMessageDialog(null, 
                    "This form should be opened from the Clothes list by selecting an item to update.",
                    "Invalid Access",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addphoto;
    private javax.swing.JComboBox<String> availability;
    private javax.swing.JLabel back;
    private javax.swing.JLabel backbutton;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel photo1;
    private javax.swing.JTextField price;
    private javax.swing.JComboBox<String> size;
    private javax.swing.JPanel updateclothes;
    // End of variables declaration//GEN-END:variables
}
