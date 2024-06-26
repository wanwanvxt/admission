package admission.view;

import admission.controller.UserController;
import admission.model.User;
import admission.util.DialogMessage;

public class LoginFrame extends javax.swing.JFrame {

  private UserController userCtrl;

  public LoginFrame() {
    initComponents();
    userCtrl = new UserController();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    headerLabel1 = new javax.swing.JLabel();
    headerLabel2 = new javax.swing.JLabel();
    usernameLabel = new javax.swing.JLabel();
    usernameField = new javax.swing.JTextField();
    passwordLabel = new javax.swing.JLabel();
    passwordField = new javax.swing.JPasswordField();
    loginButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("LOGIN");
    setPreferredSize(new java.awt.Dimension(400, 300));
    setSize(new java.awt.Dimension(400, 300));
    java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
    layout.columnWeights = new double[] {1.0, 4.0, 1.0};
    getContentPane().setLayout(layout);

    headerLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    headerLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    headerLabel1.setText("ADMISSION MANAGEMENT");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
    getContentPane().add(headerLabel1, gridBagConstraints);

    headerLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    headerLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    headerLabel2.setText("- LOGIN -");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 40, 0);
    getContentPane().add(headerLabel2, gridBagConstraints);

    usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    usernameLabel.setText("Username:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
    getContentPane().add(usernameLabel, gridBagConstraints);

    usernameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
    getContentPane().add(usernameField, gridBagConstraints);

    passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    passwordLabel.setText("Password:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
    getContentPane().add(passwordLabel, gridBagConstraints);

    passwordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
    getContentPane().add(passwordField, gridBagConstraints);

    loginButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    loginButton.setText("Login");
    loginButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        loginButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
    getContentPane().add(loginButton, gridBagConstraints);

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
//    String username = usernameField.getText();
//    String password = new String(passwordField.getPassword());
    String username = "admin123";
    String password = "admin";

    if (username.isBlank() || password.isBlank()) {
      DialogMessage.showWarning(this, "All fields are required!");
    } else {
      User currentUser = userCtrl.login(username, password);
      if (currentUser != null) {
        dispose();
        ManagementFrame mgmtFrame = new ManagementFrame(currentUser);
        mgmtFrame.setVisible(true);
      } else {
        DialogMessage.showError(this, "Failed to login!");
      }
    }
  }//GEN-LAST:event_loginButtonActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel headerLabel1;
  private javax.swing.JLabel headerLabel2;
  private javax.swing.JButton loginButton;
  private javax.swing.JPasswordField passwordField;
  private javax.swing.JLabel passwordLabel;
  private javax.swing.JTextField usernameField;
  private javax.swing.JLabel usernameLabel;
  // End of variables declaration//GEN-END:variables
}
