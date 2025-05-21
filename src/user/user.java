/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import admin.managerental.RentCloth;
import config.config;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
public class user extends javax.swing.JFrame {


    private JPanel clothesPanel;
   
    private config connect = new config();
    
    public user() {
        initComponents();
         setupClothesPanel();
        loadAvailableClothes();
    }

    
    private void setupClothesPanel() {
        clothesPanel = new JPanel(new GridLayout(0, 4, 10, 10));
        clothesPanel.setBackground(Color.DARK_GRAY);
        clothesPanel.setOpaque(true);
        clothespanel.setViewportView(clothesPanel);
    }

    private ImageIcon loadImage(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) return null;
        try {
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                return new ImageIcon(imageFile.getAbsolutePath());
            } else {
                System.out.println("Image not found: " + imagePath);
            }
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
        return null;
    }

    private void loadAvailableClothes() {
        try {
            Connection conn = connect.getConnection(); // your DB connector
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed!");
                return;
            }

            String query = "SELECT c.clothesid, c.clothname, c.sizes, c.price, c.photo_path, c.category " +
                           "FROM clothes c " +
                           "LEFT JOIN rentals r ON c.clothesid = r.clothesid AND r.status = 'active' " +
                           "WHERE c.availability = 'available' AND r.rental_id IS NULL " +
                           "ORDER BY c.clothesid ASC";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            clothesPanel.removeAll();

            while (rs.next()) {
                int clothesId = rs.getInt("clothesid");
                String name = rs.getString("clothname");
                String size = rs.getString("sizes");
                double rate = rs.getDouble("price");
                String imagePath = rs.getString("photo_path");
                String category = rs.getString("category");

                JPanel itemPanel = new JPanel(new BorderLayout(5, 5));
                Color defaultColor = new Color(30, 30, 30);
                Color hoverColor = new Color(70, 70, 70);

                itemPanel.setBackground(defaultColor);
                itemPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

                JLabel imageLabel = new JLabel();
                imageLabel.setPreferredSize(new Dimension(150, 150));
                imageLabel.setHorizontalAlignment(JLabel.CENTER);

                ImageIcon icon = loadImage(imagePath);
                if (icon != null) {
                    Image scaled = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(scaled));
                } else {
                    imageLabel.setText("No Image");
                    imageLabel.setForeground(Color.WHITE);
                    imageLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
                }

                JLabel infoLabel = new JLabel("<html><center>" +
                        name + "<br>" +
                        "Size: " + size + "<br>" +
                        "₱" + rate + "/day</center></html>");
                infoLabel.setForeground(Color.WHITE);
                infoLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
                infoLabel.setHorizontalAlignment(JLabel.CENTER);

                itemPanel.add(imageLabel, BorderLayout.CENTER);
                itemPanel.add(infoLabel, BorderLayout.SOUTH);

                itemPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                itemPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        printClothingSlip(clothesId, name);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        itemPanel.setBackground(hoverColor);
                        itemPanel.repaint();
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        itemPanel.setBackground(defaultColor);
                        itemPanel.repaint();
                    }
                });

                clothesPanel.add(itemPanel);
            }

            clothesPanel.revalidate();
            clothesPanel.repaint();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading clothes: " + e.getMessage());
        }
    }
private void printClothingSlip(int clothesId, String clothName) {
    JTextArea textArea = new JTextArea();
    textArea.setText(
        "=============================\n" +
        "     CLOTHING RENTAL SLIP\n" +
        "=============================\n" +
        "Clothing ID: " + clothesId + "\n" +
        "Clothing Name: " + clothName + "\n\n" +
        "Status: Please go to the owner\n" +
        "to proceed with the rental.\n" +
        "=============================\n" +
        "Date: " + java.time.LocalDate.now() + "\n"
    );

    textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

    try {
        boolean printed = textArea.print(); // opens system print dialog
        if (!printed) {
            JOptionPane.showMessageDialog(this, "Print job canceled.");
        }
    } catch (PrinterException e) {
        JOptionPane.showMessageDialog(this, "Print failed: " + e.getMessage());
    }

    // Dispose the current window regardless of print result
    this.dispose();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        clothespanel = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 400));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-user-48.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 750, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));
        jPanel1.add(clothespanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 750, 300));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new userprofile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane clothespanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
