package admin;

import Authentication.AdminChangepass;
import admin.managerental.Rental;
import admin.manageuser.Users;
import admin.manageclothes.Clothes;
import config.CroppingPanel;
import Authentication.Login;
import config.config;
import config.session;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;

public class Profile extends javax.swing.JFrame {


    public Profile() {
        initComponents();
        displayProfileSection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Name = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Contact = new javax.swing.JTextField();
        Username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        photo2 = new javax.swing.JLabel();
        changepass = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        upload = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        photo1 = new javax.swing.JLabel();
        Profile = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Manage = new javax.swing.JLabel();
        Name1 = new javax.swing.JLabel();
        settings = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        Messages = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Productmanagement = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Rentalmanagement = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        accountmanagement = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        jLabel14.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("MANAGE");

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Name.setEditable(false);
        Name.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });

        Email.setEditable(false);
        Email.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        Contact.setEditable(false);
        Contact.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactActionPerformed(evt);
            }
        });

        Username.setEditable(false);
        Username.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Basic information");

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Fullname");

        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Email");

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Contact");

        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Username");

        ID.setEditable(false);
        ID.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("ID");

        jPanel4.setBackground(new java.awt.Color(204, 204, 204,80));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        changepass.setBackground(new java.awt.Color(0, 0, 0,80));
        changepass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        changepass.setForeground(new java.awt.Color(0,0,0,80));
        changepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changepassMouseClicked(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("Change Password");

        javax.swing.GroupLayout changepassLayout = new javax.swing.GroupLayout(changepass);
        changepass.setLayout(changepassLayout);
        changepassLayout.setHorizontalGroup(
            changepassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changepassLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        changepassLayout.setVerticalGroup(
            changepassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changepassLayout.createSequentialGroup()
                .addComponent(jLabel22)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photo2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(changepass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photo2, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changepass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        upload.setBackground(new java.awt.Color(0,0,0,80));
        upload.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        upload.setForeground(new java.awt.Color(255, 255, 255));
        upload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadMouseClicked(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Change Photo");

        javax.swing.GroupLayout uploadLayout = new javax.swing.GroupLayout(upload);
        upload.setLayout(uploadLayout);
        uploadLayout.setHorizontalGroup(
            uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        uploadLayout.setVerticalGroup(
            uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, uploadLayout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        photo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-user-male-50.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Contact, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(94, 94, 94)
                                            .addComponent(upload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(photo1)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(18, 18, 18)
                                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(78, 78, 78))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(upload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(photo1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Contact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 490, 310));

        Profile.setBackground(new java.awt.Color(51, 51, 51));
        Profile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Profile.setForeground(new java.awt.Color(51, 51, 51));
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

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile.png"))); // NOI18N

        javax.swing.GroupLayout ProfileLayout = new javax.swing.GroupLayout(Profile);
        Profile.setLayout(ProfileLayout);
        ProfileLayout.setHorizontalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(76, 76, 76))
        );
        ProfileLayout.setVerticalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jLabel6))
            .addGroup(ProfileLayout.createSequentialGroup()
                .addComponent(jLabel23)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 30));

        Manage.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        Manage.setForeground(new java.awt.Color(255, 255, 255));
        Manage.setText("MANAGE");
        jPanel1.add(Manage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        Name1.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        Name1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 120, 20));

        settings.setBackground(new java.awt.Color(0, 0, 0,80));
        settings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        settings.setForeground(new java.awt.Color(102, 102, 102));
        settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsMouseExited(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("SETTINGS");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N

        javax.swing.GroupLayout settingsLayout = new javax.swing.GroupLayout(settings);
        settings.setLayout(settingsLayout);
        settingsLayout.setHorizontalGroup(
            settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29)
                .addGap(78, 78, 78))
        );
        settingsLayout.setVerticalGroup(
            settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel29)))
        );

        jPanel1.add(settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 210, 30));

        Messages.setBackground(new java.awt.Color(0,0,0,80));
        Messages.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Messages.setForeground(new java.awt.Color(51, 51, 51));
        Messages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MessagesMouseClicked(evt);
            }
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
        jLabel7.setText("RENTALS");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rent.png"))); // NOI18N

        javax.swing.GroupLayout MessagesLayout = new javax.swing.GroupLayout(Messages);
        Messages.setLayout(MessagesLayout);
        MessagesLayout.setHorizontalGroup(
            MessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessagesLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MessagesLayout.setVerticalGroup(
            MessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MessagesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(MessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel7)))
        );

        jPanel1.add(Messages, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 210, 30));

        Productmanagement.setBackground(new java.awt.Color(0, 0, 0));
        Productmanagement.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Productmanagement.setForeground(new java.awt.Color(51, 51, 51));
        Productmanagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductmanagementMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProductmanagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProductmanagementMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LOGS");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logs.png"))); // NOI18N

        javax.swing.GroupLayout ProductmanagementLayout = new javax.swing.GroupLayout(Productmanagement);
        Productmanagement.setLayout(ProductmanagementLayout);
        ProductmanagementLayout.setHorizontalGroup(
            ProductmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductmanagementLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        ProductmanagementLayout.setVerticalGroup(
            ProductmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductmanagementLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ProductmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel1.add(Productmanagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 30));

        Rentalmanagement.setBackground(new java.awt.Color(0, 0, 0,80));
        Rentalmanagement.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Rentalmanagement.setForeground(new java.awt.Color(51, 51, 51));
        Rentalmanagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RentalmanagementMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RentalmanagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RentalmanagementMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CLOTHES");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clothes.png"))); // NOI18N

        javax.swing.GroupLayout RentalmanagementLayout = new javax.swing.GroupLayout(Rentalmanagement);
        Rentalmanagement.setLayout(RentalmanagementLayout);
        RentalmanagementLayout.setHorizontalGroup(
            RentalmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RentalmanagementLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        RentalmanagementLayout.setVerticalGroup(
            RentalmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RentalmanagementLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jLabel4))
            .addGroup(RentalmanagementLayout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(Rentalmanagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 30));

        accountmanagement.setBackground(new java.awt.Color(0, 0, 0));
        accountmanagement.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
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

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N

        javax.swing.GroupLayout accountmanagementLayout = new javax.swing.GroupLayout(accountmanagement);
        accountmanagement.setLayout(accountmanagementLayout);
        accountmanagementLayout.setHorizontalGroup(
            accountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountmanagementLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        accountmanagementLayout.setVerticalGroup(
            accountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountmanagementLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(accountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel2)))
        );

        jPanel1.add(accountmanagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 210, 30));

        Dashboard.setBackground(new java.awt.Color(0, 0, 0));
        Dashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMouseClicked(evt);
            }
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

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(69, 69, 69))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel5)))
        );

        jPanel1.add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, 30));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/a.png"))); // NOI18N
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      session ses = session.getInstance();
if (ses != null && ses.getUsername() != null) {
    Name.setText(ses.getFname() + " " + ses.getLname()); 
    Email.setText(ses.getEmail()); 
    Username.setText(ses.getUsername()); 
    ID.setText(String.valueOf(ses.getUserId())); // Assuming ID is an integer
    Contact.setText(ses.getContact());
} else {
    Name.setText("Guest");
    Email.setText("No Email");
    Username.setText("No Username");
    ID.setText("N/A");
    Contact.setText("No Contact");
}
    }//GEN-LAST:event_formWindowActivated

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void uploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadMouseClicked
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Choose an image");
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));

    int result = fileChooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        try {
            BufferedImage originalImage = ImageIO.read(selectedFile);

            // Show cropping UI
            CroppingPanel cropPanel = new CroppingPanel(originalImage);
            int confirm = JOptionPane.showConfirmDialog(null, new JScrollPane(cropPanel), "Crop Image", JOptionPane.OK_CANCEL_OPTION);

            if (confirm == JOptionPane.OK_OPTION) {
                BufferedImage croppedImage = cropPanel.getCroppedImage();

                if (croppedImage != null) {
                    // ===== Create scaled versions of the SAME cropped image =====
                    int w1 = photo1.getWidth();
                    int h1 = photo1.getHeight();
                    Image resizedForPhoto1 = croppedImage.getScaledInstance(w1, h1, Image.SCALE_SMOOTH);

                    BufferedImage circleImage = new BufferedImage(w1, h1, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g2 = circleImage.createGraphics();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setClip(new java.awt.geom.Ellipse2D.Float(0, 0, w1, h1));
                    g2.drawImage(resizedForPhoto1, 0, 0, null);
                    g2.dispose();

                    int w2 = photo2.getWidth();
                    int h2 = photo2.getHeight();
                    Image resizedForPhoto2 = croppedImage.getScaledInstance(w2, h2, Image.SCALE_SMOOTH);
                    BufferedImage balancedImage = new BufferedImage(w2, h2, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g3 = balancedImage.createGraphics();
                    g3.drawImage(resizedForPhoto2, 0, 0, null);
                    g3.dispose();

                    // ===== Set icons =====
                    photo1.setIcon(new ImageIcon(circleImage));
                    photo2.setIcon(new ImageIcon(balancedImage));

                    // ===== Save the cropped image to the specified directory and store the path in the database =====
                    String fileName = selectedFile.getName(); 
                    File destinationDirectory = new File("src/images/prof"); 
                    if (!destinationDirectory.exists()) {
                        destinationDirectory.mkdirs(); 
                    }
                    File destinationFile = new File(destinationDirectory, fileName);

                    try {
                        ImageIO.write(croppedImage, fileName.substring(fileName.lastIndexOf(".") + 1), destinationFile);
                        System.out.println("Image saved to: " + destinationFile.getAbsolutePath());

                        // Get the relative path from the project root (or your desired base path)
                        String relativePath = destinationFile.getPath(); 

                        // ===== Store the relative path in the database =====
                        String sql = "UPDATE mbatelier.user SET profile_image = ? WHERE u_id = ?"; // Use u_id as the primary key

                        config dbConfig = new config();
                        Connection connection = dbConfig.getConnection();

                        if (connection != null) {
                            PreparedStatement pstmt = connection.prepareStatement(sql);
                            pstmt.setString(1, relativePath);

                            session userSession = session.getInstance();
                            int userId = userSession.getUserId();

                            System.out.println("SQL Query: " + sql); 
                            System.out.println("User ID: " + userId); 

                            pstmt.setInt(2, userId); // Assuming u_id is an integer
                            pstmt.executeUpdate();
                            dbConfig.closeConnection();

                            userSession.setProfileImage(relativePath);
                        } else {
                            JOptionPane.showMessageDialog(null, "Database connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error saving image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error updating database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading/cropping image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }}

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

            int w2 = photo2.getWidth();
            int h2 = photo2.getHeight();
            Image resizedForPhoto2 = image.getScaledInstance(w2, h2, Image.SCALE_SMOOTH);
            BufferedImage balancedImage = new BufferedImage(w2, h2, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g3 = balancedImage.createGraphics();
            g3.drawImage(resizedForPhoto2, 0, 0, null);
            g3.dispose();

            photo1.setIcon(new ImageIcon(circleImage));
            photo2.setIcon(new ImageIcon(balancedImage));

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ... rest of the code to display the profile section

    }//GEN-LAST:event_uploadMouseClicked

    private void changepassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMouseClicked
        session userSession = session.getInstance();
        if (userSession != null && userSession.getUsername() != null) {
            int userId = userSession.getUserId();
            new AdminChangepass(userId).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No user session found. Please login again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_changepassMouseClicked

    private void ProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseClicked
        new Profile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProfileMouseClicked

    private void ProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseEntered
        Profile.setOpaque(true);
        Profile.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_ProfileMouseEntered

    private void ProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseExited
        Profile.setOpaque(true);
        Profile.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_ProfileMouseExited

    private void settingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseEntered
        settings.setOpaque(true);
        settings.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_settingsMouseEntered

    private void settingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseExited
        settings.setOpaque(true);
        settings.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_settingsMouseExited

    private void MessagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagesMouseClicked
        new Rental().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MessagesMouseClicked

    private void MessagesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagesMouseEntered
        Messages.setOpaque(true);
        Messages.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_MessagesMouseEntered

    private void MessagesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagesMouseExited
        Messages.setOpaque(true);
        Messages.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_MessagesMouseExited

    private void ProductmanagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductmanagementMouseEntered
        Productmanagement.setOpaque(true);
        Productmanagement.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_ProductmanagementMouseEntered

    private void ProductmanagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductmanagementMouseExited
        Productmanagement.setOpaque(true);
        Productmanagement.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_ProductmanagementMouseExited

    private void RentalmanagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RentalmanagementMouseClicked
        new Clothes().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RentalmanagementMouseClicked

    private void RentalmanagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RentalmanagementMouseEntered
        Rentalmanagement.setOpaque(true);
        Rentalmanagement.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_RentalmanagementMouseEntered

    private void RentalmanagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RentalmanagementMouseExited
        Rentalmanagement.setOpaque(true);
        Rentalmanagement.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_RentalmanagementMouseExited

    private void accountmanagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountmanagementMouseClicked
        new Users().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_accountmanagementMouseClicked

    private void accountmanagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountmanagementMouseEntered
        accountmanagement.setOpaque(true);
        accountmanagement.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_accountmanagementMouseEntered

    private void accountmanagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountmanagementMouseExited
        accountmanagement.setOpaque(true);
        accountmanagement.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_accountmanagementMouseExited

    private void DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseClicked
        new AdminDash().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DashboardMouseClicked

    private void DashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseEntered
        Dashboard.setOpaque(true);
        Dashboard.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_DashboardMouseEntered

    private void DashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseExited
        Dashboard.setOpaque(true);
        Dashboard.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_DashboardMouseExited

    private void ProductmanagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductmanagementMouseClicked
        new Logs().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProductmanagementMouseClicked

    private void settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseClicked
       new Settings().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_settingsMouseClicked

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Contact;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField ID;
    private javax.swing.JLabel Manage;
    private javax.swing.JPanel Messages;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel Name1;
    private javax.swing.JPanel Productmanagement;
    private javax.swing.JPanel Profile;
    private javax.swing.JPanel Rentalmanagement;
    private javax.swing.JTextField Username;
    private javax.swing.JPanel accountmanagement;
    private javax.swing.JLabel back;
    private javax.swing.JPanel changepass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel photo1;
    private javax.swing.JLabel photo2;
    private javax.swing.JPanel settings;
    private javax.swing.JPanel upload;
    // End of variables declaration//GEN-END:variables
}
