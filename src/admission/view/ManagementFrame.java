package admission.view;

import admission.controller.MajorController;
import admission.model.User;
import admission.util.DialogMessage;
import admission.view.management.ApprovalMgmtPanel;
import admission.view.management.CandMgmtPanel;
import admission.view.management.MajorMgmtPanel;
import admission.view.management.UserMgmtPanel;
import admission.view.management.WelcomePanel;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class ManagementFrame extends javax.swing.JFrame {

  private User currentUser;
  private MajorController majorCtrl;

  private void loadPanel(JPanel panel) {
    showPanel.removeAll();
    showPanel.revalidate();
    showPanel.repaint();
    showPanel.setLayout(new BorderLayout());
    showPanel.add(panel, BorderLayout.CENTER);
  }

  public ManagementFrame(User currentUser) {
    initComponents();
    this.currentUser = currentUser;
    majorCtrl = new MajorController();
    loadPanel(new WelcomePanel(currentUser));
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    navPanel = new javax.swing.JPanel();
    candMgmtButton = new javax.swing.JButton();
    logoutButton = new javax.swing.JButton();
    approvalMgmtButton = new javax.swing.JButton();
    majorMgmtButton = new javax.swing.JButton();
    userMgmtButton = new javax.swing.JButton();
    headerLabel = new javax.swing.JLabel();
    showPanel = new javax.swing.JPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("ADMISSION MANAGEMENT");
    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    setPreferredSize(new java.awt.Dimension(900, 600));
    setSize(new java.awt.Dimension(900, 600));
    java.awt.GridBagLayout layout1 = new java.awt.GridBagLayout();
    layout1.columnWeights = new double[] {1.0, 10.0};
    layout1.rowWeights = new double[] {1.0};
    getContentPane().setLayout(layout1);

    navPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(102, 102, 102)));
    java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
    jPanel1Layout.columnWeights = new double[] {1.0};
    jPanel1Layout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 10.0, 1.0};
    navPanel.setLayout(jPanel1Layout);

    candMgmtButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    candMgmtButton.setText("Candidates");
    candMgmtButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        candMgmtButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
    navPanel.add(candMgmtButton, gridBagConstraints);

    logoutButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    logoutButton.setText("Logout");
    logoutButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        logoutButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
    navPanel.add(logoutButton, gridBagConstraints);

    approvalMgmtButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    approvalMgmtButton.setText("Approval");
    approvalMgmtButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        approvalMgmtButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
    navPanel.add(approvalMgmtButton, gridBagConstraints);

    majorMgmtButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    majorMgmtButton.setText("Majors");
    majorMgmtButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        majorMgmtButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
    navPanel.add(majorMgmtButton, gridBagConstraints);

    userMgmtButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    userMgmtButton.setText("Users");
    userMgmtButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        userMgmtButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
    navPanel.add(userMgmtButton, gridBagConstraints);

    headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    headerLabel.setText("<html>\nADMISSION\n<br>\nMANAGEMENT\n</html>");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
    navPanel.add(headerLabel, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    getContentPane().add(navPanel, gridBagConstraints);

    showPanel.setLayout(new java.awt.BorderLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    getContentPane().add(showPanel, gridBagConstraints);

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
    dispose();
    LoginFrame loginFrame = new LoginFrame();
    loginFrame.setVisible(true);
  }//GEN-LAST:event_logoutButtonActionPerformed

  private void userMgmtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMgmtButtonActionPerformed
    if (currentUser.getRole().equals("admin")) {
      loadPanel(new UserMgmtPanel(currentUser));
    } else {
      DialogMessage.showWarning(this, "You do not have permission to access this feature!");
    }
  }//GEN-LAST:event_userMgmtButtonActionPerformed

  private void majorMgmtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_majorMgmtButtonActionPerformed
    loadPanel(new MajorMgmtPanel());
  }//GEN-LAST:event_majorMgmtButtonActionPerformed

  private void candMgmtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_candMgmtButtonActionPerformed
    int majorCount = majorCtrl.getMajorCount();
    if (majorCount > 0) {
      loadPanel(new CandMgmtPanel());
    } else {
      DialogMessage.showWarning(this, "You must add majors before accessing this feature!");
    }
  }//GEN-LAST:event_candMgmtButtonActionPerformed

  private void approvalMgmtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approvalMgmtButtonActionPerformed
    int majorCount = majorCtrl.getMajorCount();
    if (majorCount > 0) {
      loadPanel(new ApprovalMgmtPanel());
    } else {
      DialogMessage.showWarning(this, "You must add majors before accessing this feature!");
    }
  }//GEN-LAST:event_approvalMgmtButtonActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton approvalMgmtButton;
  private javax.swing.JButton candMgmtButton;
  private javax.swing.JLabel headerLabel;
  private javax.swing.JButton logoutButton;
  private javax.swing.JButton majorMgmtButton;
  private javax.swing.JPanel navPanel;
  private javax.swing.JPanel showPanel;
  private javax.swing.JButton userMgmtButton;
  // End of variables declaration//GEN-END:variables
}
