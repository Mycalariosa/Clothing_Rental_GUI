
package admin.manageuser;

import admin.Profile;
import admin.managerental.Rental;
import admin.Settings;
import admin.manageclothes.Clothes;
import Authentication.Login;
import Authentication.register;
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
import admin.AdminDash;
import admin.Logs;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.DriverManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;


public class Users extends javax.swing.JFrame {
           
    public Users() {
        
        initComponents();
        loadUsers();
    }

  private void loadUsers() {


    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("User ID");
    model.addColumn("Full Name");
    model.addColumn("Role");
    model.addColumn("Username");
    model.addColumn("Status");

    // Create table with the model
    JTable table = new JTable(model);

    try {
        config connect = new config();
        Connection conn = connect.getConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed!");
            return;
        }

        String query = "SELECT u_id, fname, lname, role, username, status FROM user ORDER BY u_id ASC";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String fullName = rs.getString("fname") + " " + rs.getString("lname");
            model.addRow(new Object[]{
                rs.getInt("u_id"),
                fullName,
                rs.getString("role"),
                rs.getString("username"),
                rs.getString("status")
            });
        }

        // Apply modern styling
        styleTable(table);

        // Set column widths
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowHeight(25); // Set row height for better visibility
        table.getColumnModel().getColumn(0).setPreferredWidth(80);  // User ID
        table.getColumnModel().getColumn(1).setPreferredWidth(200); // Full Name
        table.getColumnModel().getColumn(2).setPreferredWidth(100); // Role
        table.getColumnModel().getColumn(3).setPreferredWidth(150); // Username
        table.getColumnModel().getColumn(4).setPreferredWidth(100); // Status

        // Enable sorting
        table.setAutoCreateRowSorter(true);

        // Display the table in the scroll pane
        admintable.setViewportView(table);

        // Optional: clear selection
        table.clearSelection();

        rs.close();
        stmt.close();
        conn.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error loading users: " + ex.getMessage());
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

        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        Refresh = new javax.swing.JLabel();
        Archieve = new javax.swing.JPanel();
        archieve = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Searchb = new javax.swing.JPanel();
        Search = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        update = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        activate = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        accountmanagement = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Manage = new javax.swing.JLabel();
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
        Profile = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        admintable = new javax.swing.JScrollPane();
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Name.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 120, 20));

        search.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        search.setForeground(new java.awt.Color(51, 51, 51));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 270, -1));

        Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-refresh-24.png"))); // NOI18N
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefreshMouseClicked(evt);
            }
        });
        jPanel1.add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, -1, -1));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArchieveLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(archieve)
                .addContainerGap())
        );
        ArchieveLayout.setVerticalGroup(
            ArchieveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArchieveLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(archieve))
        );

        jPanel1.add(Archieve, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 60, 20));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel1.setText("Search name:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 10));

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

        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 60, 20));

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

        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 60, 20));

        activate.setForeground(new java.awt.Color(0,0,0,80));
        activate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activateMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel10.setText("ACTIVATE");

        javax.swing.GroupLayout activateLayout = new javax.swing.GroupLayout(activate);
        activate.setLayout(activateLayout);
        activateLayout.setHorizontalGroup(
            activateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, activateLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        activateLayout.setVerticalGroup(
            activateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, activateLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        jPanel1.add(activate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 60, 20));

        accountmanagement.setBackground(new java.awt.Color(51, 51, 51));
        accountmanagement.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        accountmanagement.setForeground(new java.awt.Color(51, 51, 51));
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
                .addGap(50, 50, 50)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        accountmanagementLayout.setVerticalGroup(
            accountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountmanagementLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(accountmanagementLayout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel1.add(accountmanagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 210, 30));

        Manage.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        Manage.setForeground(new java.awt.Color(255, 255, 255));
        Manage.setText("MANAGE");
        jPanel1.add(Manage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

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

        Profile.setBackground(new java.awt.Color(0, 0, 0));
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
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(88, 88, 88))
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

        jLabel8.setText("Search name:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));
        jPanel1.add(admintable, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 480, 260));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/c.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         session ses = session.getInstance();
    if (ses != null && ses.getUsername() != null) {
        Name.setText("Welcome " + ses.getUsername());
    } else {
        Name.setText("Welcome Guest"); 
    
    }
    }//GEN-LAST:event_formWindowActivated

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
      
    }//GEN-LAST:event_SearchMouseClicked

    private void SearchbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbMouseClicked
    

    }//GEN-LAST:event_SearchbMouseClicked

    private void RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseClicked
      
    loadUsers();
    }//GEN-LAST:event_RefreshMouseClicked
    private int getSelectedUserId() {
     JTable table = (JTable) admintable.getViewport().getView();
    int selectedRow = table.getSelectedRow();

    if (selectedRow != -1) {
        Object value = table.getValueAt(selectedRow, 0); // User ID is in column 0
        if (value != null) {
            return Integer.parseInt(value.toString());
        }
    }
    return -1; // Nothing selected
}

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
         new AddUser().setVisible(true);
         this.dispose();
    }

private void showError(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);


    }//GEN-LAST:event_addMouseClicked
 
  

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    
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
    
    // Get the table from the JScrollPane
    JTable table = (JTable) admintable.getViewport().getView();
    int selectedRow = table.getSelectedRow();

    if (selectedRow == -1) {
        // No row selected
        JOptionPane.showMessageDialog(this, "Please select a user to update.", "Warning", JOptionPane.WARNING_MESSAGE);
    } else {
        // Get the selected username from column 4
        String selectedUsername = table.getValueAt(selectedRow, 3).toString();

        // Open the Update form
        Update updateForm = new Update(selectedUsername); // Ensure this constructor exists in Update.java
        updateForm.setLocationRelativeTo(this); // Optional: center the window relative to current frame
        updateForm.setVisible(true);

        // Close the current window (optional)
        this.dispose();
    }

    }//GEN-LAST:event_updateMouseClicked

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
        accountmanagement.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_accountmanagementMouseExited

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

    private void ArchieveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArchieveMouseClicked
        
    }//GEN-LAST:event_ArchieveMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users().setVisible(true);
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
    private javax.swing.JLabel Refresh;
    private javax.swing.JPanel Rentalmanagement;
    private javax.swing.JLabel Search;
    private javax.swing.JPanel Searchb;
    private javax.swing.JPanel accountmanagement;
    private javax.swing.JPanel activate;
    private javax.swing.JPanel add;
    private javax.swing.JScrollPane admintable;
    private javax.swing.JLabel archieve;
    private javax.swing.JLabel back;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField search;
    private javax.swing.JPanel settings;
    private javax.swing.JPanel update;
    // End of variables declaration//GEN-END:variables

}
