package admission.view.management;

import admission.controller.FalcultyController;
import admission.controller.MajorController;
import admission.model.Falculty;
import admission.model.Major;
import admission.model.User;
import admission.util.DialogMessage;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MajorMgmtPanel extends javax.swing.JPanel {

  private FalcultyController falcultyCtrl;
  private MajorController majorCtrl;

  private void refreshData() {
    DefaultTableModel falcultyTableModel = (DefaultTableModel) falcultyTable.getModel();
    DefaultTableModel majorTableModel = (DefaultTableModel) majorTable.getModel();
    falcultyTableModel.setRowCount(0);
    majorTableModel.setRowCount(0);

    m_falcultyComboBox.removeAllItems();

    List<Falculty> falculties = falcultyCtrl.getAllFalculties();
    for (Falculty falculty : falculties) {
      falcultyTableModel.addRow(new Object[]{falculty.getId(), falculty, falculty.getDesc()});
      m_falcultyComboBox.addItem(falculty);
    }

    List<Major> majors = majorCtrl.getAllMajors();
    for (Major major : majors) {
      majorTableModel.addRow(new Object[]{major.getId(), major, major.getDesc(), major.getFalcultyId(), major.getQuota()});
    }

    falcultyTable.setModel(falcultyTableModel);
    majorTable.setModel(majorTableModel);

    f_nameField.setText("");
    f_descField.setText("");
    m_nameField.setText("");
    m_descField.setText("");
    m_quotaSpinner.setValue(0);
  }

  public MajorMgmtPanel() {
    initComponents();
    falcultyCtrl = new FalcultyController();
    majorCtrl = new MajorController();
    refreshData();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    headerLabel = new javax.swing.JLabel();
    falcultyPanel = new javax.swing.JPanel();
    f_formPanel = new javax.swing.JPanel();
    f_nameField = new javax.swing.JTextField();
    f_descScrollPane = new javax.swing.JScrollPane();
    f_descField = new javax.swing.JTextArea();
    f_addButton = new javax.swing.JButton();
    f_updateButton = new javax.swing.JButton();
    f_deleteButton = new javax.swing.JButton();
    f_nameLabel = new javax.swing.JLabel();
    f_descLabel = new javax.swing.JLabel();
    f_scrollPane = new javax.swing.JScrollPane();
    falcultyTable = new javax.swing.JTable();
    majorPanel = new javax.swing.JPanel();
    m_formPanel = new javax.swing.JPanel();
    m_nameField = new javax.swing.JTextField();
    m_descScrollPane = new javax.swing.JScrollPane();
    m_descField = new javax.swing.JTextArea();
    m_falcultyComboBox = new javax.swing.JComboBox<>();
    m_quotaSpinner = new javax.swing.JSpinner();
    m_addButton = new javax.swing.JButton();
    m_updateButton = new javax.swing.JButton();
    m_deleteButton = new javax.swing.JButton();
    m_nameLabel = new javax.swing.JLabel();
    m_descLabel = new javax.swing.JLabel();
    m_falcultyLabel = new javax.swing.JLabel();
    m_quotaLabel = new javax.swing.JLabel();
    m_scrollPane = new javax.swing.JScrollPane();
    majorTable = new javax.swing.JTable();

    java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
    layout.columnWeights = new double[] {1.0};
    layout.rowWeights = new double[] {1.0, 8.0, 10.0};
    setLayout(layout);

    headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    headerLabel.setText("MAJOR MANAGEMENT");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
    add(headerLabel, gridBagConstraints);

    falcultyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Falculty", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
    java.awt.GridBagLayout falcultyPanelLayout1 = new java.awt.GridBagLayout();
    falcultyPanelLayout1.columnWeights = new double[] {1.0, 1.0};
    falcultyPanelLayout1.rowWeights = new double[] {1.0, 1.0, 10.0, 1.0};
    falcultyPanel.setLayout(falcultyPanelLayout1);

    java.awt.GridBagLayout falcultyPanelLayout = new java.awt.GridBagLayout();
    falcultyPanelLayout.columnWeights = new double[] {1.0, 1.0, 1.0};
    falcultyPanelLayout.rowWeights = new double[] {1.0, 1.0, 10.0, 1.0};
    f_formPanel.setLayout(falcultyPanelLayout);

    f_nameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    f_formPanel.add(f_nameField, gridBagConstraints);

    f_descField.setColumns(20);
    f_descField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    f_descField.setRows(5);
    f_descScrollPane.setViewportView(f_descField);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    f_formPanel.add(f_descScrollPane, gridBagConstraints);

    f_addButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    f_addButton.setText("Add");
    f_addButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        f_addButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    f_formPanel.add(f_addButton, gridBagConstraints);

    f_updateButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    f_updateButton.setText("Update");
    f_updateButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        f_updateButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
    f_formPanel.add(f_updateButton, gridBagConstraints);

    f_deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    f_deleteButton.setText("Delete");
    f_deleteButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        f_deleteButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    f_formPanel.add(f_deleteButton, gridBagConstraints);

    f_nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    f_nameLabel.setText("Name:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    f_formPanel.add(f_nameLabel, gridBagConstraints);

    f_descLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    f_descLabel.setText("Description:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    f_formPanel.add(f_descLabel, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
    falcultyPanel.add(f_formPanel, gridBagConstraints);

    falcultyTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    falcultyTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ID", "Name", "Description"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    falcultyTable.getTableHeader().setReorderingAllowed(false);
    falcultyTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(java.awt.event.MouseEvent evt) {
        falcultyTableMousePressed(evt);
      }
    });
    f_scrollPane.setViewportView(falcultyTable);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
    falcultyPanel.add(f_scrollPane, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(falcultyPanel, gridBagConstraints);

    majorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Major", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
    java.awt.GridBagLayout majorPanelLayout1 = new java.awt.GridBagLayout();
    majorPanelLayout1.columnWeights = new double[] {1.0, 1.0};
    majorPanelLayout1.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 10.0, 1.0};
    majorPanel.setLayout(majorPanelLayout1);

    java.awt.GridBagLayout majorPanelLayout = new java.awt.GridBagLayout();
    majorPanelLayout.columnWeights = new double[] {1.0, 1.0, 1.0};
    majorPanelLayout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 10.0, 1.0};
    m_formPanel.setLayout(majorPanelLayout);

    m_nameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    m_formPanel.add(m_nameField, gridBagConstraints);

    m_descField.setColumns(20);
    m_descField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    m_descField.setRows(5);
    m_descScrollPane.setViewportView(m_descField);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    m_formPanel.add(m_descScrollPane, gridBagConstraints);

    m_falcultyComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    m_formPanel.add(m_falcultyComboBox, gridBagConstraints);

    m_quotaSpinner.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    m_quotaSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    m_formPanel.add(m_quotaSpinner, gridBagConstraints);

    m_addButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    m_addButton.setText("Add");
    m_addButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        m_addButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    m_formPanel.add(m_addButton, gridBagConstraints);

    m_updateButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    m_updateButton.setText("Update");
    m_updateButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        m_updateButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
    m_formPanel.add(m_updateButton, gridBagConstraints);

    m_deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    m_deleteButton.setText("Delete");
    m_deleteButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        m_deleteButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    m_formPanel.add(m_deleteButton, gridBagConstraints);

    m_nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    m_nameLabel.setText("Name:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    m_formPanel.add(m_nameLabel, gridBagConstraints);

    m_descLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    m_descLabel.setText("Description:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    m_formPanel.add(m_descLabel, gridBagConstraints);

    m_falcultyLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    m_falcultyLabel.setText("Falculty");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    m_formPanel.add(m_falcultyLabel, gridBagConstraints);

    m_quotaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    m_quotaLabel.setText("Quota");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    m_formPanel.add(m_quotaLabel, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
    majorPanel.add(m_formPanel, gridBagConstraints);

    majorTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    majorTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ID", "Name", "Description", "Falculty", "Quota"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    majorTable.getTableHeader().setReorderingAllowed(false);
    majorTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(java.awt.event.MouseEvent evt) {
        majorTableMousePressed(evt);
      }
    });
    m_scrollPane.setViewportView(majorTable);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
    majorPanel.add(m_scrollPane, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(majorPanel, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

  // <editor-fold defaultstate="collapsed" desc="Falculty">
  private void falcultyTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_falcultyTableMousePressed
    int selectedRow = falcultyTable.getSelectedRow();
    if (selectedRow != -1) {
      Falculty falculty = (Falculty) falcultyTable.getValueAt(selectedRow, 1);
      f_nameField.setText(falculty.getName());
      f_descField.setText(falculty.getDesc());
    }
  }//GEN-LAST:event_falcultyTableMousePressed

  private void f_addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_addButtonActionPerformed
    String name = f_nameField.getText().trim();
    String desc = f_descField.getText().trim();

    if (name.isBlank() || desc.isBlank()) {
      DialogMessage.showWarning(this, "All fields are required!");
    } else {
      Falculty newFalculty = new Falculty(name, desc);

      boolean success = falcultyCtrl.addFalculty(newFalculty);
      if (success) {
        DialogMessage.showInfo(this, "Added successfully!");
        refreshData();
      } else {
        DialogMessage.showError(this, "Failed to add the new falculty!");
      }
    }
  }//GEN-LAST:event_f_addButtonActionPerformed

  private void f_updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_updateButtonActionPerformed
    int selectedRow = falcultyTable.getSelectedRow();
    if (selectedRow != -1) {
      int id = (int) falcultyTable.getValueAt(selectedRow, 0);
      String name = f_nameField.getText().trim();
      String desc = f_descField.getText().trim();

      if (name.isBlank() || desc.isBlank()) {
        DialogMessage.showWarning(this, "All fields are required!");
      } else {
        Falculty falculty = new Falculty(id, name, desc);

        boolean success = falcultyCtrl.updateFalculty(falculty);
        if (success) {
          DialogMessage.showInfo(this, "Updated successfully!");
          refreshData();
        } else {
          DialogMessage.showError(this, "Failed to updated this falculty!");
        }
      }
    } else {
      DialogMessage.showWarning(this, "Please select a falculty to update!");
    }
  }//GEN-LAST:event_f_updateButtonActionPerformed

  private void f_deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_deleteButtonActionPerformed
    int selectedRow = falcultyTable.getSelectedRow();
    if (selectedRow != -1) {
      int id = (int) falcultyTable.getValueAt(selectedRow, 0);

      boolean success = falcultyCtrl.deleteFalculty(id);
      if (success) {
        DialogMessage.showInfo(this, "Deleted successfully!");
        refreshData();
      } else {
        DialogMessage.showError(this, "Failed to deleted this falculty!");
      }
    } else {
      DialogMessage.showWarning(this, "Please select a falculty to delete!");
    }
  }//GEN-LAST:event_f_deleteButtonActionPerformed
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Major">
  private void majorTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_majorTableMousePressed
    int selectedRow = majorTable.getSelectedRow();
    if (selectedRow != -1) {
      Major major = (Major) majorTable.getValueAt(selectedRow, 1);
      m_nameField.setText(major.getName());
      m_descField.setText(major.getDesc());
      m_quotaSpinner.setValue(major.getQuota());
      for (int i = 0; i < m_falcultyComboBox.getItemCount(); i++) {
        Falculty falculty = m_falcultyComboBox.getItemAt(i);
        if (falculty.getId() == major.getFalcultyId()) {
          m_falcultyComboBox.setSelectedIndex(i);
          break;
        }
      }
    }
  }//GEN-LAST:event_majorTableMousePressed

  private void m_addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_addButtonActionPerformed
    String name = m_nameField.getText().trim();
    String desc = m_descField.getText().trim();
    Falculty falculty = (Falculty) m_falcultyComboBox.getSelectedItem();
    int quota = (int) m_quotaSpinner.getValue();

    if (name.isBlank() || desc.isBlank()) {
      DialogMessage.showWarning(this, "All fields are required!");
    } else {
      Major newMajor = new Major(name, desc, falculty.getId(), quota);

      boolean success = majorCtrl.addMajor(newMajor);
      if (success) {
        DialogMessage.showInfo(this, "Added successfully!");
        refreshData();
      } else {
        DialogMessage.showError(this, "Failed to add the new major!");
      }
    }
  }//GEN-LAST:event_m_addButtonActionPerformed

  private void m_updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_updateButtonActionPerformed
    int selectedRow = majorTable.getSelectedRow();
    if (selectedRow != -1) {
      int id = (int) majorTable.getValueAt(selectedRow, 0);
      String name = m_nameField.getText().trim();
      String desc = m_descField.getText().trim();
      Falculty falculty = (Falculty) m_falcultyComboBox.getSelectedItem();
      int quota = (int) m_quotaSpinner.getValue();

      if (name.isBlank() || desc.isBlank()) {
        DialogMessage.showWarning(this, "All fields are required!");
      } else {
        Major major = new Major(id, name, desc, falculty.getId(), quota);

        boolean success = majorCtrl.updateMajor(major);
        if (success) {
          DialogMessage.showInfo(this, "Updated successfully!");
          refreshData();
        } else {
          DialogMessage.showError(this, "Failed to update this major!");
        }
      }
    } else {
      DialogMessage.showWarning(this, "Please select a major to update!");
    }
  }//GEN-LAST:event_m_updateButtonActionPerformed

  private void m_deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_deleteButtonActionPerformed
    int selectedRow = majorTable.getSelectedRow();
    if (selectedRow != -1) {
      int id = (int) majorTable.getValueAt(selectedRow, 0);

      boolean success = majorCtrl.deleteMajor(id);
      if (success) {
        DialogMessage.showInfo(this, "Deleted successfully!");
        refreshData();
      } else {
        DialogMessage.showError(this, "Failed to delete this major!");
      }
    } else {
      DialogMessage.showWarning(this, "Please select a major to delete!");
    }
  }//GEN-LAST:event_m_deleteButtonActionPerformed
  // </editor-fold>

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton f_addButton;
  private javax.swing.JButton f_deleteButton;
  private javax.swing.JTextArea f_descField;
  private javax.swing.JLabel f_descLabel;
  private javax.swing.JScrollPane f_descScrollPane;
  private javax.swing.JPanel f_formPanel;
  private javax.swing.JTextField f_nameField;
  private javax.swing.JLabel f_nameLabel;
  private javax.swing.JScrollPane f_scrollPane;
  private javax.swing.JButton f_updateButton;
  private javax.swing.JPanel falcultyPanel;
  private javax.swing.JTable falcultyTable;
  private javax.swing.JLabel headerLabel;
  private javax.swing.JButton m_addButton;
  private javax.swing.JButton m_deleteButton;
  private javax.swing.JTextArea m_descField;
  private javax.swing.JLabel m_descLabel;
  private javax.swing.JScrollPane m_descScrollPane;
  private javax.swing.JComboBox<Falculty> m_falcultyComboBox;
  private javax.swing.JLabel m_falcultyLabel;
  private javax.swing.JPanel m_formPanel;
  private javax.swing.JTextField m_nameField;
  private javax.swing.JLabel m_nameLabel;
  private javax.swing.JLabel m_quotaLabel;
  private javax.swing.JSpinner m_quotaSpinner;
  private javax.swing.JScrollPane m_scrollPane;
  private javax.swing.JButton m_updateButton;
  private javax.swing.JPanel majorPanel;
  private javax.swing.JTable majorTable;
  // End of variables declaration//GEN-END:variables
}
