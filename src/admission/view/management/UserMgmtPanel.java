package admission.view.management;

import admission.controller.UserController;
import admission.model.User;
import admission.util.DialogMessage;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UserMgmtPanel extends javax.swing.JPanel {

  private User currentUser;
  private UserController userCtrl;

  private void refreshData() {
    DefaultTableModel userTableModel = (DefaultTableModel) userTable.getModel();
    userTableModel.setRowCount(0);

    List<User> users = userCtrl.getAllUsers();
    for (User user : users) {
      userTableModel.addRow(new Object[]{user.getId(), user, user.getRole()});
    }

    userTable.setModel(userTableModel);

    usernameField.setText("");
    passwordField.setText("");
  }

  public UserMgmtPanel(User currentUser) {
    initComponents();
    this.currentUser = currentUser;
    userCtrl = new UserController(currentUser);
    refreshData();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    headerLabel = new javax.swing.JLabel();
    scrollPane = new javax.swing.JScrollPane();
    userTable = new javax.swing.JTable();
    formPanel = new javax.swing.JPanel();
    usernameField = new javax.swing.JTextField();
    passwordField = new javax.swing.JPasswordField();
    roleComboBox = new javax.swing.JComboBox<>();
    addButton = new javax.swing.JButton();
    updateButton = new javax.swing.JButton();
    deleteButton = new javax.swing.JButton();
    usernameLabel = new javax.swing.JLabel();
    passwordLabel = new javax.swing.JLabel();
    roleLabel = new javax.swing.JLabel();

    java.awt.GridBagLayout layout1 = new java.awt.GridBagLayout();
    layout1.columnWeights = new double[] {1.0, 1.0};
    layout1.rowWeights = new double[] {1.0, 10.0};
    setLayout(layout1);

    headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    headerLabel.setText("USER MANAGEMENT");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
    add(headerLabel, gridBagConstraints);

    userTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    userTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ID", "Username", "Role"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    userTable.getTableHeader().setReorderingAllowed(false);
    userTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(java.awt.event.MouseEvent evt) {
        userTableMousePressed(evt);
      }
    });
    scrollPane.setViewportView(userTable);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(scrollPane, gridBagConstraints);

    java.awt.GridBagLayout formPanelLayout = new java.awt.GridBagLayout();
    formPanelLayout.columnWeights = new double[] {1.0, 1.0, 1.0};
    formPanelLayout.rowWeights = new double[] {1.0, 1.0, 1.0, 10.0, 1.0};
    formPanel.setLayout(formPanelLayout);

    usernameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(usernameField, gridBagConstraints);

    passwordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(passwordField, gridBagConstraints);

    roleComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mod", "Admin" }));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(roleComboBox, gridBagConstraints);

    addButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    addButton.setText("Add");
    addButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(addButton, gridBagConstraints);

    updateButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    updateButton.setText("Update");
    updateButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        updateButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
    formPanel.add(updateButton, gridBagConstraints);

    deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    deleteButton.setText("Delete");
    deleteButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        deleteButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    formPanel.add(deleteButton, gridBagConstraints);

    usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    usernameLabel.setText("Username:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(usernameLabel, gridBagConstraints);

    passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    passwordLabel.setText("Password:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(passwordLabel, gridBagConstraints);

    roleLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    roleLabel.setText("Role:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(roleLabel, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(formPanel, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

  private void userTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMousePressed
    int selectedRow = userTable.getSelectedRow();
    if (selectedRow != -1) {
      User user = (User) userTable.getValueAt(selectedRow, 1);
      usernameField.setText(user.getUsername());
      passwordField.setText(user.getPassword());
      roleComboBox.setSelectedIndex(user.getRole().equals("admin") ? 1 : 0);
    }
  }//GEN-LAST:event_userTableMousePressed

  private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    String username = usernameField.getText().trim();
    String password = new String(passwordField.getPassword());
    String role = ((String) roleComboBox.getSelectedItem()).toLowerCase();

    if (username.isBlank() || password.isBlank()) {
      DialogMessage.showWarning(this, "All fields are required!");
    } else {
      User newUser = new User(username, password, role);

      boolean success = userCtrl.register(newUser);
      if (success) {
        DialogMessage.showInfo(this, "Added successfully!");
        refreshData();
      } else {
        DialogMessage.showError(this, "Failed to add the new user!");
      }
    }
  }//GEN-LAST:event_addButtonActionPerformed

  private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
    int selectedRow = userTable.getSelectedRow();
    if (selectedRow != -1) {
      int id = (int) userTable.getValueAt(selectedRow, 0);
      String username = usernameField.getText().trim();
      String password = new String(passwordField.getPassword());
      String role = ((String) roleComboBox.getSelectedItem()).toLowerCase();

      if (username.isBlank() || password.isBlank()) {
        DialogMessage.showWarning(this, "All fields are required!");
      } else {
        User user = new User(id, username, password, role);

        boolean success = userCtrl.updateUser(user);
        if (success) {
          DialogMessage.showInfo(this, "Updated successfully!");
          refreshData();
        } else {
          DialogMessage.showError(this, "Failed to update this user!");
        }
      }
    } else {
      DialogMessage.showWarning(this, "Please select a user to update!");
    }
  }//GEN-LAST:event_updateButtonActionPerformed

  private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    int selectedRow = userTable.getSelectedRow();
    if (selectedRow != -1) {
      int id = (int) userTable.getValueAt(selectedRow, 0);

      boolean success = userCtrl.deleteUser(id);
      if (success) {
        DialogMessage.showInfo(this, "Deleted successfully!");
        refreshData();
      } else {
        DialogMessage.showError(this, "Failed to delete this user!");
      }
    } else {
      DialogMessage.showWarning(this, "Please select a user to delete!");
    }
  }//GEN-LAST:event_deleteButtonActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton addButton;
  private javax.swing.JButton deleteButton;
  private javax.swing.JPanel formPanel;
  private javax.swing.JLabel headerLabel;
  private javax.swing.JPasswordField passwordField;
  private javax.swing.JLabel passwordLabel;
  private javax.swing.JComboBox<String> roleComboBox;
  private javax.swing.JLabel roleLabel;
  private javax.swing.JScrollPane scrollPane;
  private javax.swing.JButton updateButton;
  private javax.swing.JTable userTable;
  private javax.swing.JTextField usernameField;
  private javax.swing.JLabel usernameLabel;
  // End of variables declaration//GEN-END:variables
}
