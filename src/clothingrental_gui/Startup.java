
package clothingrental_gui;

import javax.swing.JOptionPane;

public class Startup extends javax.swing.JFrame {

    
    public Startup() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        startup = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Backgound = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 400));

        Back.setBackground(new java.awt.Color(204, 204, 204));
        Back.setMaximumSize(new java.awt.Dimension(800, 400));
        Back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("EXIT");
        Back.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, -1));

        exit.setBackground(new java.awt.Color(255, 255, 255));
        exit.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-exit-24.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        Back.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 20, 20));

        startup.setBackground(new java.awt.Color(33, 32, 32));
        startup.setPreferredSize(new java.awt.Dimension(100, 15));
        startup.setRequestFocusEnabled(false);
        startup.setVerifyInputWhenFocusTarget(false);
        startup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startupMouseExited(evt);
            }
        });
        startup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lets get started ...");
        startup.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        Back.add(startup, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 210, -1));

        Backgound.setForeground(new java.awt.Color(51, 51, 51));
        Backgound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/startup.png"))); // NOI18N
        Back.add(Backgound, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startupMouseEntered
        startup.setOpaque(true);
   startup.setBackground(new java.awt.Color(102,102,102)); 
    }//GEN-LAST:event_startupMouseEntered

    private void startupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startupMouseExited
        startup.setOpaque(true);
   startup.setBackground(new java.awt.Color(32,32,32)); 
    }//GEN-LAST:event_startupMouseExited

    private void startupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startupMouseClicked
         new Login().setVisible(true);
          this.dispose();
    }//GEN-LAST:event_startupMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
         int a=JOptionPane.showConfirmDialog(null,"Do you really want to Exit?","Select", JOptionPane.YES_NO_OPTION);
      if(a==0)
      {
        System.exit(0);} 
    }//GEN-LAST:event_exitMouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        exit.setOpaque(true);
    exit.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
       exit.setOpaque(true);
    exit.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_exitMouseExited

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
            java.util.logging.Logger.getLogger(Startup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Startup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Startup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Startup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Startup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Back;
    private javax.swing.JLabel Backgound;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel startup;
    // End of variables declaration//GEN-END:variables
}
