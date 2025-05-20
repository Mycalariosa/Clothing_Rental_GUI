/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.managerental;

import config.config;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Administrator
 */
public class addRental extends javax.swing.JFrame {
    private JScrollPane scrollPane;
    private JPanel clothesPanel;
    private config connect = new config();

    /**
     * Creates new form addRental
     */
    public addRental() {
        initComponents();
        setupClothesPanel();
        loadAvailableClothes();
    }

    private void setupClothesPanel() {
        // Create the panel that will hold the clothes
        clothesPanel = new JPanel();
        clothesPanel.setLayout(new GridLayout(0, 3, 10, 10)); // 3 columns, dynamic rows, 10px gaps
        clothesPanel.setBackground(new Color(0, 0, 0, 80));
        
        // Set the panel as the viewport view of the existing scroll pane
        clothespanel.setViewportView(clothesPanel);
        clothespanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private ImageIcon loadImage(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            return null;
        }

        try {
            // The database stores the path including 'src/', so use it directly
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                return new ImageIcon(imageFile.getAbsolutePath());
            }

            System.out.println("Image not found: " + imagePath);
            return null;
        } catch (Exception e) {
            System.out.println("Error loading image " + imagePath + ": " + e.getMessage());
            return null;
        }
    }

    private void loadAvailableClothes() {
        try {
            Connection conn = connect.getConnection();
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed!");
                return;
            }

            String query = "SELECT * FROM available_items_view";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Create a panel for each clothing item
                JPanel itemPanel = new JPanel();
                itemPanel.setLayout(new BorderLayout(5, 5));
                itemPanel.setBackground(new Color(0, 0, 0, 80));
                itemPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

                // Create and set up the image label
                JLabel imageLabel = new JLabel();
                imageLabel.setPreferredSize(new Dimension(150, 150));
                imageLabel.setHorizontalAlignment(JLabel.CENTER);
                
                // Load and display the image
                String imagePath = rs.getString("image_path");
                ImageIcon imageIcon = loadImage(imagePath);
                
                if (imageIcon != null) {
                    Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(image));
                } else {
                    imageLabel.setText("No Image");
                    imageLabel.setForeground(Color.WHITE);
                }

                // Create and set up the info label
                JLabel infoLabel = new JLabel("<html><center>" + 
                    rs.getString("name") + "<br>" +
                    "Size: " + rs.getString("size") + "<br>" +
                    "Price: $" + rs.getDouble("daily_rate") + "/day</center></html>");
                infoLabel.setForeground(Color.WHITE);
                infoLabel.setHorizontalAlignment(JLabel.CENTER);

                // Add components to the item panel
                itemPanel.add(imageLabel, BorderLayout.CENTER);
                itemPanel.add(infoLabel, BorderLayout.SOUTH);

                // Add the item panel to the clothes panel
                clothesPanel.add(itemPanel);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading clothes: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        clothespanel = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(clothespanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 740, 300));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/a.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(addRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addRental().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane clothespanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
