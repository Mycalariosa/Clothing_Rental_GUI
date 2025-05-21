package admin.manageclothes;

import admin.Profile;
import admin.managerental.Rental;
import admin.Settings;
import admin.manageuser.Users;
import admin.AdminDash;
import admin.Logs;
import Authentication.Login;
import admin.manageuser.Update;
import config.config;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class Clothes extends javax.swing.JFrame {
    private JTable clothesTable;
    private DefaultTableModel tableModel;
    
    public Clothes() {
        initComponents();
        setupTable();
        loadClothes();
    }
    
    private void setupTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Clothing ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Price");
        tableModel.addColumn("Category");
        tableModel.addColumn("Size");
        tableModel.addColumn("Availability");
        tableModel.addColumn("Color");

        clothesTable = new JTable(tableModel);
        styleTable(clothesTable);
        clothestable.setViewportView(clothesTable);
    }
    
    private void loadClothes() {
        try {
            config connect = new config();
            Connection conn = connect.getConnection();
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed!");
                return;
            }

            String query = "SELECT clothesid, clothname, price, category, sizes, availability, color FROM clothes ORDER BY clothesid ASC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            tableModel.setRowCount(0); // Clear existing rows
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("clothesid"),
                    rs.getString("clothname"),
                    rs.getDouble("price"),
                    rs.getString("category"),
                    rs.getString("sizes"),
                    rs.getString("availability"),
                    rs.getString("color")
                });
            }

            // Adjust columns
            clothesTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            clothesTable.setRowHeight(25);
            clothesTable.getColumnModel().getColumn(0).setPreferredWidth(80);   // Clothing ID
            clothesTable.getColumnModel().getColumn(1).setPreferredWidth(150);  // Name
            clothesTable.getColumnModel().getColumn(2).setPreferredWidth(80);   // Price
            clothesTable.getColumnModel().getColumn(3).setPreferredWidth(100);  // Category
            clothesTable.getColumnModel().getColumn(4).setPreferredWidth(100);  // Size
            clothesTable.getColumnModel().getColumn(5).setPreferredWidth(120);  // Availability
            clothesTable.getColumnModel().getColumn(6).setPreferredWidth(100);  // Color

            clothesTable.setAutoCreateRowSorter(true); // Enable sorting
            clothesTable.clearSelection();

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error loading clothes: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void styleTable(JTable table) {
        // Table header styling
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        header.setForeground(Color.BLACK);  // White text for header
        header.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        header.setReorderingAllowed(false);

        // Table font and grid color
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(25);
        table.setGridColor(Color.DARK_GRAY);
        table.setSelectionBackground(new Color(96, 96, 96));  // Dark gray for selected row
        table.setSelectionForeground(Color.WHITE);  // White text for selected row
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);

        // Alternate row colors
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240)); // Light grey rows
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Rentalmanagement = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Manage = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        clothestable = new javax.swing.JScrollPane();
        settings = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        Messages = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Productmanagement = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        accountmanagement = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Profile = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        update = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        Archieve = new javax.swing.JPanel();
        archieve = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Rentalmanagement.setBackground(new java.awt.Color(51, 51, 51));
        Rentalmanagement.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Rentalmanagement.setForeground(new java.awt.Color(51, 51, 51));
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
        jLabel4.setText("CLOTHES");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clothes.png"))); // NOI18N

        javax.swing.GroupLayout RentalmanagementLayout = new javax.swing.GroupLayout(Rentalmanagement);
        Rentalmanagement.setLayout(RentalmanagementLayout);
        RentalmanagementLayout.setHorizontalGroup(
            RentalmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RentalmanagementLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        RentalmanagementLayout.setVerticalGroup(
            RentalmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RentalmanagementLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4))
            .addGroup(RentalmanagementLayout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        getContentPane().add(Rentalmanagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 30));

        Manage.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        Manage.setForeground(new java.awt.Color(255, 255, 255));
        Manage.setText("MANAGE");
        getContentPane().add(Manage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        Name.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 120, 20));

        clothestable.setBackground(new java.awt.Color(0, 0, 0));
        clothestable.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        getContentPane().add(clothestable, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 510, 260));

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

        getContentPane().add(settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 210, 30));

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
                .addContainerGap(83, Short.MAX_VALUE))
        );
        MessagesLayout.setVerticalGroup(
            MessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MessagesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(MessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel7)))
        );

        getContentPane().add(Messages, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 210, 30));

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

        getContentPane().add(Productmanagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 30));

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

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N

        javax.swing.GroupLayout accountmanagementLayout = new javax.swing.GroupLayout(accountmanagement);
        accountmanagement.setLayout(accountmanagementLayout);
        accountmanagementLayout.setHorizontalGroup(
            accountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountmanagementLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        accountmanagementLayout.setVerticalGroup(
            accountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountmanagementLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(accountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel2)))
        );

        getContentPane().add(accountmanagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 210, 30));

        Profile.setBackground(new java.awt.Color(0, 0, 0));
        Profile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
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

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile.png"))); // NOI18N

        javax.swing.GroupLayout ProfileLayout = new javax.swing.GroupLayout(Profile);
        Profile.setLayout(ProfileLayout);
        ProfileLayout.setHorizontalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(76, 76, 76))
        );
        ProfileLayout.setVerticalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jLabel6))
            .addGroup(ProfileLayout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 30));

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

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(69, 69, 69))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel5)))
        );

        getContentPane().add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 370, 3));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLOTHING LIST");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel9.setText("ADD");

        javax.swing.GroupLayout addLayout = new javax.swing.GroupLayout(add);
        add.setLayout(addLayout);
        addLayout.setHorizontalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        addLayout.setVerticalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 60, 20));

        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel12.setText("UPDATE");

        javax.swing.GroupLayout updateLayout = new javax.swing.GroupLayout(update);
        update.setLayout(updateLayout);
        updateLayout.setHorizontalGroup(
            updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        updateLayout.setVerticalGroup(
            updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel12))
        );

        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 60, 20));

        Archieve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArchieveMouseClicked(evt);
            }
        });

        archieve.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        archieve.setText("DELETE");

        javax.swing.GroupLayout ArchieveLayout = new javax.swing.GroupLayout(Archieve);
        Archieve.setLayout(ArchieveLayout);
        ArchieveLayout.setHorizontalGroup(
            ArchieveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArchieveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(archieve)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        ArchieveLayout.setVerticalGroup(
            ArchieveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArchieveLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(archieve))
        );

        getContentPane().add(Archieve, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 60, 20));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/c.png"))); // NOI18N
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        Profile.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_ProfileMouseExited

    private void ProductmanagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductmanagementMouseClicked
      new Logs().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProductmanagementMouseClicked

    private void settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseClicked
        new Settings().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_settingsMouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        new AddClothes().setVisible(true);
        this.dispose();
        }

        private void showError(String message) {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_addMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = clothesTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a clothing item to update.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int clothingId = (int) tableModel.getValueAt(selectedRow, 0);
        new UpdateClothes(clothingId).setVisible(true);
        this.dispose();
    }

    private void ArchieveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArchieveMouseClicked

    }//GEN-LAST:event_ArchieveMouseClicked

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
            java.util.logging.Logger.getLogger(Clothes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clothes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clothes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clothes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clothes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Archieve;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JLabel Manage;
    private javax.swing.JPanel Messages;
    private javax.swing.JLabel Name;
    private javax.swing.JPanel Productmanagement;
    private javax.swing.JPanel Profile;
    private javax.swing.JPanel Rentalmanagement;
    private javax.swing.JPanel accountmanagement;
    private javax.swing.JPanel add;
    private javax.swing.JLabel archieve;
    private javax.swing.JLabel back;
    private javax.swing.JScrollPane clothestable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel settings;
    private javax.swing.JPanel update;
    // End of variables declaration//GEN-END:variables
}
