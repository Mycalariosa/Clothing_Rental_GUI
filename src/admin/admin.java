
package admin;

import clothingrental_gui.Login;
import config.session;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class admin extends javax.swing.JFrame {

    public admin() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logout1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Logout2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Productmanagement = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        accountmanagement = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Rentalmanagement = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        settings = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Messages = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Profile = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        Logout1.setBackground(new java.awt.Color(51, 51, 51));
        Logout1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Logout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Logout1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Logout1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Logout1MouseExited(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-logout-24.png"))); // NOI18N
        Logout1.add(jLabel20);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Logout");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel1.setText("NUMBER OF PRODUCT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, 20));

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel9.setText("NUMBER OF RENTALS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel10.setText("NUMBER OF USERS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 110, 30));

        jLabel11.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("MANAGE");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        Logout2.setBackground(new java.awt.Color(51, 51, 51));
        Logout2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Logout2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Logout2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Logout2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Logout2MouseExited(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-logout-24.png"))); // NOI18N
        Logout2.add(jLabel21);

        jPanel1.add(Logout2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 30, 40));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Logout");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 10));

        Productmanagement.setBackground(new java.awt.Color(51, 51, 51));
        Productmanagement.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Productmanagement.setForeground(new java.awt.Color(51, 51, 51));
        Productmanagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProductmanagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProductmanagementMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PRODUCT");

        javax.swing.GroupLayout ProductmanagementLayout = new javax.swing.GroupLayout(Productmanagement);
        Productmanagement.setLayout(ProductmanagementLayout);
        ProductmanagementLayout.setHorizontalGroup(
            ProductmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductmanagementLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel3)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        ProductmanagementLayout.setVerticalGroup(
            ProductmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductmanagementLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        jPanel1.add(Productmanagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 30));

        accountmanagement.setBackground(new java.awt.Color(51, 51, 51));
        accountmanagement.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        accountmanagement.setForeground(new java.awt.Color(102, 102, 102));
        accountmanagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountmanagementMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountmanagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountmanagementMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USERS");

        javax.swing.GroupLayout accountmanagementLayout = new javax.swing.GroupLayout(accountmanagement);
        accountmanagement.setLayout(accountmanagementLayout);
        accountmanagementLayout.setHorizontalGroup(
            accountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountmanagementLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel2)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        accountmanagementLayout.setVerticalGroup(
            accountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountmanagementLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        jPanel1.add(accountmanagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 210, 30));

        Rentalmanagement.setBackground(new java.awt.Color(51, 51, 51));
        Rentalmanagement.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Rentalmanagement.setForeground(new java.awt.Color(102, 102, 102));
        Rentalmanagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RentalmanagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RentalmanagementMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("RENTALS");

        javax.swing.GroupLayout RentalmanagementLayout = new javax.swing.GroupLayout(Rentalmanagement);
        Rentalmanagement.setLayout(RentalmanagementLayout);
        RentalmanagementLayout.setHorizontalGroup(
            RentalmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RentalmanagementLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel4)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        RentalmanagementLayout.setVerticalGroup(
            RentalmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RentalmanagementLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        jPanel1.add(Rentalmanagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 30));

        settings.setBackground(new java.awt.Color(51, 51, 51));
        settings.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        settings.setForeground(new java.awt.Color(102, 102, 102));
        settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SETTINGS");

        javax.swing.GroupLayout settingsLayout = new javax.swing.GroupLayout(settings);
        settings.setLayout(settingsLayout);
        settingsLayout.setHorizontalGroup(
            settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(78, 78, 78))
        );
        settingsLayout.setVerticalGroup(
            settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );

        jPanel1.add(settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 210, 30));

        Messages.setBackground(new java.awt.Color(51, 51, 51));
        Messages.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Messages.setForeground(new java.awt.Color(102, 102, 102));
        Messages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MessagesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MessagesMouseExited(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MESSAGES");

        javax.swing.GroupLayout MessagesLayout = new javax.swing.GroupLayout(Messages);
        Messages.setLayout(MessagesLayout);
        MessagesLayout.setHorizontalGroup(
            MessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessagesLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel7)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        MessagesLayout.setVerticalGroup(
            MessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MessagesLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        jPanel1.add(Messages, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 210, 30));

        Profile.setBackground(new java.awt.Color(51, 51, 51));
        Profile.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Profile.setForeground(new java.awt.Color(102, 102, 102));
        Profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProfileMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PROFILE");

        javax.swing.GroupLayout ProfileLayout = new javax.swing.GroupLayout(Profile);
        Profile.setLayout(ProfileLayout);
        ProfileLayout.setHorizontalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileLayout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(76, 76, 76))
        );
        ProfileLayout.setVerticalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        jPanel1.add(Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 30));

        Dashboard.setBackground(new java.awt.Color(102, 102, 102));
        Dashboard.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Dashboard.setForeground(new java.awt.Color(204, 204, 204));
        Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DASHBOARD");

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(69, 69, 69))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );

        jPanel1.add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, 30));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseEntered
         Dashboard.setOpaque(true);
         Dashboard.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_DashboardMouseEntered

    private void DashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseExited
          Dashboard.setOpaque(true);
          Dashboard.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_DashboardMouseExited

    private void accountmanagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountmanagementMouseEntered
         accountmanagement.setOpaque(true);
         accountmanagement.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_accountmanagementMouseEntered

    private void accountmanagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountmanagementMouseExited
          accountmanagement.setOpaque(true);
          accountmanagement.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_accountmanagementMouseExited

    private void ProductmanagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductmanagementMouseEntered
         Productmanagement.setOpaque(true);
         Productmanagement.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_ProductmanagementMouseEntered

    private void ProductmanagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductmanagementMouseExited
          Productmanagement.setOpaque(true);
          Productmanagement.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_ProductmanagementMouseExited

    private void RentalmanagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RentalmanagementMouseEntered
         Rentalmanagement.setOpaque(true);
         Rentalmanagement.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_RentalmanagementMouseEntered

    private void RentalmanagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RentalmanagementMouseExited
          Rentalmanagement.setOpaque(true);
          Rentalmanagement.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_RentalmanagementMouseExited

    private void settingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseEntered
         settings.setOpaque(true);
         settings.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_settingsMouseEntered

    private void settingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseExited
         settings.setOpaque(true);
         settings.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_settingsMouseExited

    private void MessagesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagesMouseEntered
         Messages.setOpaque(true);
         Messages.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_MessagesMouseEntered

    private void MessagesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagesMouseExited
         Messages.setOpaque(true);
         Messages.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_MessagesMouseExited

    private void ProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseEntered
         Profile.setOpaque(true);
         Profile.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_ProfileMouseEntered

    private void ProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseExited
         Profile.setOpaque(true);
         Profile.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_ProfileMouseExited

    private void accountmanagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountmanagementMouseClicked
      new accmanagement().setVisible(true);
          this.dispose();
    }//GEN-LAST:event_accountmanagementMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      session ses = session.getInstance();
              name.setText("Welcome "+ses.getUsername());
    }//GEN-LAST:event_formWindowActivated

    private void ProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseClicked
          new Profile().setVisible(true);
          this.dispose();
    }//GEN-LAST:event_ProfileMouseClicked

    private void Logout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Logout1MouseClicked
        int a=JOptionPane.showConfirmDialog(null,"Do you really want to logout?","Select", JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            setVisible(false);
              new Login().setVisible(true);
            this.dispose();}
    }//GEN-LAST:event_Logout1MouseClicked

    private void Logout1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Logout1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Logout1MouseEntered

    private void Logout1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Logout1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Logout1MouseExited

    private void Logout2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Logout2MouseClicked
        int a=JOptionPane.showConfirmDialog(null,"Do you really want to logout?","Select", JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            setVisible(false);
            new Login().setVisible(true);
            this.dispose();}
    }//GEN-LAST:event_Logout2MouseClicked

    private void Logout2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Logout2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Logout2MouseEntered

    private void Logout2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Logout2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Logout2MouseExited

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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel Logout1;
    private javax.swing.JPanel Logout2;
    private javax.swing.JPanel Messages;
    private javax.swing.JPanel Productmanagement;
    private javax.swing.JPanel Profile;
    private javax.swing.JPanel Rentalmanagement;
    private javax.swing.JPanel accountmanagement;
    private javax.swing.JLabel back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel name;
    private javax.swing.JPanel settings;
    // End of variables declaration//GEN-END:variables
}
