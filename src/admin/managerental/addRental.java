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
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.Box;

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
    // 4 columns, 16px gap, black background
    clothesPanel = new JPanel(new GridLayout(0, 4, 16, 16));
    clothesPanel.setBackground(Color.BLACK);
    clothesPanel.setOpaque(true);
    clothespanel.setViewportView(clothesPanel);
    clothespanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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
        String query = "SELECT c.clothesid, c.clothname, c.sizes, c.price, c.photo_path, c.category, c.description " +
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
            String description = rs.getString("description");

            // Minimalist card panel
            JPanel itemPanel = new JPanel(new BorderLayout(0, 8));
            itemPanel.setBackground(new Color(40, 40, 40));
            itemPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70, 70, 70), 1, true),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));
            itemPanel.setPreferredSize(new Dimension(160, 280));

            // Image panel
            JPanel imagePanel = new JPanel();
            imagePanel.setBackground(new Color(40, 40, 40));
            imagePanel.setPreferredSize(new Dimension(140, 160));
            JLabel imageLabel = new JLabel();
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            ImageIcon icon = loadImage(imagePath);
            if (icon != null) {
                Image scaled = icon.getImage().getScaledInstance(120, 140, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaled));
            } else {
                imageLabel.setText("No Image");
                imageLabel.setForeground(new Color(120, 120, 120));
                imageLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
            }
            imagePanel.add(imageLabel);

            // Info panel
            JPanel infoPanel = new JPanel();
            infoPanel.setBackground(new Color(40, 40, 40));
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            JLabel nameLabel = new JLabel(name);
            nameLabel.setFont(new Font("Consolas", Font.BOLD, 14));
            nameLabel.setForeground(Color.WHITE);
            nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            JLabel sizeLabel = new JLabel("Size: " + size);
            sizeLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
            sizeLabel.setForeground(new Color(180, 180, 180));
            sizeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            JLabel priceLabel = new JLabel("₱" + String.format("%.2f", rate) + " / day");
            priceLabel.setFont(new Font("Consolas", Font.BOLD, 13));
            priceLabel.setForeground(Color.WHITE);
            priceLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            infoPanel.add(nameLabel);
            infoPanel.add(sizeLabel);
            infoPanel.add(priceLabel);

            // Button panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(new Color(40, 40, 40));
            JButton rentBtn = new JButton("Rent Product");
            rentBtn.setBackground(new Color(40, 40, 40));
            rentBtn.setForeground(Color.WHITE);
            rentBtn.setFocusPainted(false);
            rentBtn.setFont(new Font("Consolas", Font.BOLD, 12));
            rentBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            rentBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
            rentBtn.setContentAreaFilled(false);
            rentBtn.setOpaque(true);
            rentBtn.addActionListener(e -> {
                admin.managerental.ClothSelection.setSelectedCloth(
                    imagePath,
                    name,
                    category,
                    String.valueOf(rate),
                    clothesId
                );
                new RentCloth().setVisible(true);
                dispose();
            });
            rentBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    rentBtn.setBackground(Color.WHITE);
                    rentBtn.setForeground(Color.BLACK);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    rentBtn.setBackground(new Color(40, 40, 40));
                    rentBtn.setForeground(Color.WHITE);
                }
            });
            buttonPanel.add(rentBtn);

            // Add panels to card
            itemPanel.add(imagePanel, BorderLayout.NORTH);
            itemPanel.add(infoPanel, BorderLayout.CENTER);
            itemPanel.add(buttonPanel, BorderLayout.SOUTH);

            // Card hover effect
            itemPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    itemPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE, 2, true),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                    ));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    itemPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(70, 70, 70), 1, true),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                    ));
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
