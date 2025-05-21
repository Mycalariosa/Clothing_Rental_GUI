
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
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Administrator
 */
public class addRental extends javax.swing.JFrame {
       private JPanel clothesPanel;
    private config connect = new config();
   
     public addRental() {
        initComponents();
        setTitle("Add Rental");
        setupClothesPanel();
        loadAvailableClothes();
    }
   private void setupClothesPanel() {
    clothesPanel = new JPanel(new GridLayout(0, 4, 10, 10)); // 4 columns
    clothesPanel.setBackground(Color.DARK_GRAY); // black background
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
        Connection conn = connect.getConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed!");
            return;
        }

        // Modified query to exclude clothes with active rentals
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
            Color defaultColor = new Color(30, 30, 30); // dark gray
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
                    // Set the selected cloth details including ID
                    admin.managerental.ClothSelection.setSelectedCloth(
                        imagePath,
                        name,
                        category,
                        String.valueOf(rate),
                        clothesId // Pass the clothing ID
                    );
                    
                    // Open the RentCloth form
                    new RentCloth().setVisible(true);
                    // Close the current addRental form
                    dispose();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 400));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(clothespanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 750, 300));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
