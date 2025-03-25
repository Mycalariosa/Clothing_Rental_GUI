
package admin;

import clothingrental_gui.Login;
import clothingrental_gui.register;
import config.config;
import config.session;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import user.Startupuser;
import admin.Update;


public class accmanagement extends javax.swing.JFrame {
           
    public accmanagement() {
        
        initComponents();
        loadUsers();
    }

   private void loadUsers() {
    config connect = new config();
    
    // Create a new table model
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("User ID");
    model.addColumn("First Name");
    model.addColumn("Last Name");
    model.addColumn("Role");
    model.addColumn("Username");
    model.addColumn("Status");

    try {
        Connection conn = connect.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed!");
            return;
        }

        String query = "SELECT u_id, fname, lname, role, username, status FROM user"; 
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("u_id"),
                rs.getString("fname"),
                rs.getString("lname"),
                rs.getString("role"),
                rs.getString("username"),
                rs.getString("status")
            });
        }

        admintable.setModel(model);
        model.fireTableDataChanged(); // Ensure table updates

        // Close resources to avoid memory leaks
        rs.close();
        stmt.close();
        conn.close();

    } catch (SQLException ex) {
        System.out.println("Error loading users: " + ex.getMessage());
        ex.printStackTrace();
    }
}


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        Dashboard = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Profile = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        accountmanagement = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Productmanagement = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Rentalmanagement = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Refresh = new javax.swing.JLabel();
        Logout1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Messages = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        settings = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Searchb = new javax.swing.JPanel();
        Search = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        update = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        activate = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        role = new javax.swing.JComboBox<>();
        password = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        admintable = new javax.swing.JTable();
        back = new javax.swing.JLabel();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 150, 20));
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 230, -1));

        Dashboard.setBackground(new java.awt.Color(51, 51, 51));
        Dashboard.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Dashboard.setForeground(new java.awt.Color(204, 204, 204));
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

        accountmanagement.setBackground(new java.awt.Color(102, 102, 102));
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

        Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-refresh-24.png"))); // NOI18N
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefreshMouseClicked(evt);
            }
        });
        jPanel1.add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, -1, -1));

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

        jPanel1.add(Logout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 30, 40));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Logout");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel13.setText("DELETE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jLabel13))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 70, 20));

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

        jLabel11.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("MANAGE");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

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

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel1.setText("Search name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        Searchb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchbMouseClicked(evt);
            }
        });

        Search.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        Search.setText("Search");
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout SearchbLayout = new javax.swing.GroupLayout(Searchb);
        Searchb.setLayout(SearchbLayout);
        SearchbLayout.setHorizontalGroup(
            SearchbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Search)
                .addGap(10, 10, 10))
        );
        SearchbLayout.setVerticalGroup(
            SearchbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchbLayout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(Search))
        );

        jPanel1.add(Searchb, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, 20));

        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel9.setText("ADD");

        javax.swing.GroupLayout addLayout = new javax.swing.GroupLayout(add);
        add.setLayout(addLayout);
        addLayout.setHorizontalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        addLayout.setVerticalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLayout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 70, 20));

        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel12.setText("UPDATE");

        javax.swing.GroupLayout updateLayout = new javax.swing.GroupLayout(update);
        update.setLayout(updateLayout);
        updateLayout.setHorizontalGroup(
            updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel12)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        updateLayout.setVerticalGroup(
            updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateLayout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jLabel12))
        );

        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 70, 20));

        activate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activateMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jLabel10.setText("ACTIVATE");

        javax.swing.GroupLayout activateLayout = new javax.swing.GroupLayout(activate);
        activate.setLayout(activateLayout);
        activateLayout.setHorizontalGroup(
            activateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(activateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        activateLayout.setVerticalGroup(
            activateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, activateLayout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        jPanel1.add(activate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, 70, 20));

        fname.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 140, 20));

        jLabel14.setText("firstname");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        jLabel15.setText("lastname");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 60, 19));

        lname.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 140, 20));

        email.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 140, 20));

        jLabel18.setText("email");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 60, 19));

        jLabel21.setText("Role");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, -1, 19));

        jLabel22.setText("username");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 60, 19));

        jLabel23.setText("contact");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 60, 19));

        contact.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jPanel1.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 130, 20));

        username.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 130, 20));

        jLabel24.setText(" Status");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 60, 19));

        jLabel25.setText("password");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 60, 19));

        status.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 140, -1));

        role.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin", " " }));
        role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleActionPerformed(evt);
            }
        });
        jPanel1.add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 130, -1));

        password.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 130, 20));

        admintable.setBackground(new java.awt.Color(204, 204, 204));
        admintable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        admintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        admintable.setColumnSelectionAllowed(true);
        admintable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(admintable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 520, 180));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png"))); // NOI18N
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        Dashboard.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_DashboardMouseExited

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

    private void accountmanagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountmanagementMouseEntered
        accountmanagement.setOpaque(true);
        accountmanagement.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_accountmanagementMouseEntered

    private void accountmanagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountmanagementMouseExited
        accountmanagement.setOpaque(true);
        accountmanagement.setBackground(new java.awt.Color(102,102,102));
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

    private void MessagesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagesMouseEntered
        Messages.setOpaque(true);
        Messages.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_MessagesMouseEntered

    private void MessagesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagesMouseExited
        Messages.setOpaque(true);
        Messages.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_MessagesMouseExited

    private void settingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseEntered
        settings.setOpaque(true);
        settings.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_settingsMouseEntered

    private void settingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseExited
        settings.setOpaque(true);
        settings.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_settingsMouseExited

    private void DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseClicked
       new admin().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_DashboardMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         session ses = session.getInstance();
    if (ses != null && ses.getUsername() != null) {
        Name.setText("Welcome " + ses.getUsername());
    } else {
        Name.setText("Welcome Guest"); 
    
    }
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

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
      
    }//GEN-LAST:event_SearchMouseClicked

    private void SearchbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbMouseClicked
    

    }//GEN-LAST:event_SearchbMouseClicked

    private void RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseClicked
      
 
    loadUsers();


    }//GEN-LAST:event_RefreshMouseClicked
    private int getSelectedUserId() {
    int selectedRow = admintable.getSelectedRow(); // Assuming userTable is your JTable
    if (selectedRow != -1) { // Check if a row is selected
        return (int) admintable.getValueAt(selectedRow, 0); // Assuming user_id is in column 0
    } else {
        return -1; // No user selected
    }
}

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
        if (!validatePassword(password)) {
            return;
        }
    }

    // Show error message if validation fails
    if (errorMessage.length() > 0) {
        JOptionPane.showMessageDialog(this, errorMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Hash password
    String passwordText = new String(passwordChars);
    String hashedPassword = hashPassword(passwordText);

    // Corrected SQL insert query
    String sql = "INSERT INTO user (fname, lname, email, contact, username, password, status, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
        pst.setString(1, firstNameText);
        pst.setString(2, lastNameText);
        pst.setString(3, emailText);
        pst.setString(4, contactNumberText);
        pst.setString(5, usernameText);
        pst.setString(6, hashedPassword);
        pst.setString(7, selectedStatus);
        pst.setString(8, selectedRole);

        pst.executeUpdate();

        // Success message
        JOptionPane.showMessageDialog(this, "Account Registered Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Clear input fields
        fname.setText("");
        lname.setText("");
        contact.setText("");
        email.setText("");
        username.setText("");
        password.setText("");
        role.setSelectedIndex(0);
        status.setSelectedIndex(0);

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

// Show error messages
private void showError(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);


    }//GEN-LAST:event_addMouseClicked
 
  

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleActionPerformed

    
    private void activateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activateMouseClicked

    int selectedUserId = getSelectedUserId(); // Get the selected user's ID

    if (selectedUserId != -1) {
        try {
            config connect = new config(); // Create an instance of config
            Connection conn = connect.getConnection(); // Get database connection

            String query = "UPDATE user SET status = 'Active' WHERE u_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, selectedUserId);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "User Account Activated Successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Activate User Account.");
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a User to Activate.");
    }
      
    }//GEN-LAST:event_activateMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
      int selectedRow = admintable.getSelectedRow(); // Get selected row

    if (selectedRow == -1) { // No row selected
        JOptionPane.showMessageDialog(this, "Please select a user to update.", "Warning", JOptionPane.WARNING_MESSAGE);
    } else {
        String selectedUsername = admintable.getValueAt(selectedRow, 4).toString(); // Column 4 is username

        // Open Update form with selected username
        new Update(selectedUsername).setVisible(true);
        this.dispose(); // Close current form
    
}   
    }//GEN-LAST:event_updateMouseClicked

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accmanagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel Logout1;
    private javax.swing.JPanel Messages;
    private javax.swing.JLabel Name;
    private javax.swing.JPanel Productmanagement;
    private javax.swing.JPanel Profile;
    private javax.swing.JLabel Refresh;
    private javax.swing.JPanel Rentalmanagement;
    private javax.swing.JLabel Search;
    private javax.swing.JPanel Searchb;
    private javax.swing.JPanel accountmanagement;
    private javax.swing.JPanel activate;
    private javax.swing.JPanel add;
    private javax.swing.JTable admintable;
    private javax.swing.JLabel back;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lname;
    private javax.swing.JPasswordField password;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JTextField search;
    private javax.swing.JPanel settings;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JPanel update;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
