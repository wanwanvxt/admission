package admission.view.management;

import admission.controller.AspirationController;
import admission.controller.CandidateController;
import admission.controller.MajorController;
import admission.controller.ProfileController;
import admission.model.Aspiration;
import admission.model.Candidate;
import admission.model.Major;
import admission.model.Profile;
import admission.util.DialogMessage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ApprovalMgmtPanel extends javax.swing.JPanel {

  private MajorController majorCtrl;
  private AspirationController aspirationCtrl;
  private CandidateController candidateCtrl;
  private ProfileController profileCtrl;
  private List<Aspiration> aspirations;

  private void refreshData() {
    DefaultTableModel candTableModel = (DefaultTableModel) candTable.getModel();
    candTableModel.setRowCount(0);

    Major major = (Major) majorComboBox.getSelectedItem();
    aspirations = aspirationCtrl.getAspirationsByMajorId(major.getId());
    for (Aspiration aspiration : aspirations) {
      Candidate candidate = candidateCtrl.getCandidateById(aspiration.getCandidateId());
      Profile profile = profileCtrl.getProfileByCandidateId(aspiration.getCandidateId());
      if (candidate == null || profile == null) {
        continue;
      }
      candTableModel.addRow(new Object[]{candidate.getId(), candidate, profile, aspiration});
    }

    baseScoreSpinner.setValue(major.getBaseScore());
    quotatField.setText(Integer.toString(major.getQuota()));
    totalField1.setText(Integer.toString(aspirations.size()));
    totalField2.setText(Integer.toString(aspirations.size()));
  }

  public ApprovalMgmtPanel() {
    initComponents();
    majorCtrl = new MajorController();
    aspirationCtrl = new AspirationController();
    candidateCtrl = new CandidateController();
    profileCtrl = new ProfileController();
    aspirations = new ArrayList<>();

    List<Major> majors = majorCtrl.getAllMajors();
    majorComboBox.removeAllItems();
    for (Major major : majors) {
      majorComboBox.addItem(major);
    }
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    headerLabel = new javax.swing.JLabel();
    scrollPane = new javax.swing.JScrollPane();
    candTable = new javax.swing.JTable();
    formPanel = new javax.swing.JPanel();
    majorLabel = new javax.swing.JLabel();
    majorComboBox = new javax.swing.JComboBox<>();
    baseScoreLabel = new javax.swing.JLabel();
    baseScoreSpinner = new javax.swing.JSpinner();
    approveButton = new javax.swing.JButton();
    passedLabel = new javax.swing.JLabel();
    passedPanel = new javax.swing.JPanel();
    passedField = new javax.swing.JTextField();
    splitLabel1 = new javax.swing.JLabel();
    totalField1 = new javax.swing.JTextField();
    failedLabel = new javax.swing.JLabel();
    failedPanel = new javax.swing.JPanel();
    failedField = new javax.swing.JTextField();
    splitLabel2 = new javax.swing.JLabel();
    totalField2 = new javax.swing.JTextField();
    quotaLabel = new javax.swing.JLabel();
    quotatField = new javax.swing.JTextField();

    java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
    layout.columnWeights = new double[] {1.0, 1.0};
    layout.rowWeights = new double[] {1.0, 10.0};
    setLayout(layout);

    headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    headerLabel.setText("APPROVAL MANAGEMENT");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
    add(headerLabel, gridBagConstraints);

    candTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    candTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ID", "Name", "Score", "Status"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    candTable.getTableHeader().setReorderingAllowed(false);
    scrollPane.setViewportView(candTable);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(scrollPane, gridBagConstraints);

    java.awt.GridBagLayout formPanelLayout = new java.awt.GridBagLayout();
    formPanelLayout.columnWeights = new double[] {1.0, 1.0};
    formPanelLayout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 10.0, 1.0};
    formPanel.setLayout(formPanelLayout);

    majorLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    majorLabel.setText("Major:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(majorLabel, gridBagConstraints);

    majorComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    majorComboBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        majorComboBoxActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(majorComboBox, gridBagConstraints);

    baseScoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    baseScoreLabel.setText("Base score:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(baseScoreLabel, gridBagConstraints);

    baseScoreSpinner.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    baseScoreSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.01d));
    baseScoreSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        baseScoreSpinnerStateChanged(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(baseScoreSpinner, gridBagConstraints);

    approveButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    approveButton.setText("Approve");
    approveButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        approveButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    formPanel.add(approveButton, gridBagConstraints);

    passedLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    passedLabel.setText("<html>\nNumber of passed candidate:\n<br/>\n(passed candidate / total)\n<html>");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(passedLabel, gridBagConstraints);

    java.awt.GridBagLayout passedPanelLayout = new java.awt.GridBagLayout();
    passedPanelLayout.columnWeights = new double[] {1.0, 1.0, 1.0};
    passedPanelLayout.rowWeights = new double[] {1.0};
    passedPanel.setLayout(passedPanelLayout);

    passedField.setEditable(false);
    passedField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    passedPanel.add(passedField, gridBagConstraints);

    splitLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    splitLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    splitLabel1.setText("/");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    passedPanel.add(splitLabel1, gridBagConstraints);

    totalField1.setEditable(false);
    totalField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    passedPanel.add(totalField1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(passedPanel, gridBagConstraints);

    failedLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    failedLabel.setText("<html>\nNumber of failed candidate:\n<br/>\n(failed candidate / total)\n<html>");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(failedLabel, gridBagConstraints);

    java.awt.GridBagLayout failedPanelLayout = new java.awt.GridBagLayout();
    failedPanelLayout.columnWeights = new double[] {1.0, 1.0, 1.0};
    failedPanelLayout.rowWeights = new double[] {1.0};
    failedPanel.setLayout(failedPanelLayout);

    failedField.setEditable(false);
    failedField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    failedPanel.add(failedField, gridBagConstraints);

    splitLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    splitLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    splitLabel2.setText("/");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    failedPanel.add(splitLabel2, gridBagConstraints);

    totalField2.setEditable(false);
    totalField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    failedPanel.add(totalField2, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(failedPanel, gridBagConstraints);

    quotaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    quotaLabel.setText("Quota:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(quotaLabel, gridBagConstraints);

    quotatField.setEditable(false);
    quotatField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(quotatField, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(formPanel, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

  private void majorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_majorComboBoxActionPerformed
    refreshData();
  }//GEN-LAST:event_majorComboBoxActionPerformed

  private void baseScoreSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_baseScoreSpinnerStateChanged
    int passedCandidateCount = 0;
    int failedCandidateCount = 0;
    double baseScore = (double) baseScoreSpinner.getValue();

    for (Aspiration aspiration : aspirations) {
      Profile profile = profileCtrl.getProfileByCandidateId(aspiration.getCandidateId());
      if (profile == null) {
        continue;
      }
      if (profile.getScore() >= baseScore) {
        passedCandidateCount++;
      } else {
        failedCandidateCount++;
      }
    }

    passedField.setText(Integer.toString(passedCandidateCount));
    failedField.setText(Integer.toString(failedCandidateCount));
  }//GEN-LAST:event_baseScoreSpinnerStateChanged

  private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
    double baseScore = (double) baseScoreSpinner.getValue();
    Major major = (Major) majorComboBox.getSelectedItem();
    major.setBaseScore(baseScore);

    boolean updateBaseScoreSuccess = majorCtrl.updateMajor(major);
    if (updateBaseScoreSuccess) {
      for (Aspiration aspiration : aspirations) {
        Profile profile = profileCtrl.getProfileByCandidateId(aspiration.getCandidateId());
        if (profile == null) {
          continue;
        }
        if (profile.getScore() >= baseScore) {
          aspiration.setStatus("pass");
        } else {
          aspiration.setStatus("fail");
        }

        boolean updateAspirationSuccess = aspirationCtrl.updateAspiration(aspiration);
        if (updateAspirationSuccess) {
          DialogMessage.showInfo(this, "Approved successfully!");
          refreshData();
        } else {
          DialogMessage.showError(this, "Failed to approve!");
        }
      }
    } else {
      DialogMessage.showError(this, "Failed to update the base score!");
    }
  }//GEN-LAST:event_approveButtonActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton approveButton;
  private javax.swing.JLabel baseScoreLabel;
  private javax.swing.JSpinner baseScoreSpinner;
  private javax.swing.JTable candTable;
  private javax.swing.JTextField failedField;
  private javax.swing.JLabel failedLabel;
  private javax.swing.JPanel failedPanel;
  private javax.swing.JPanel formPanel;
  private javax.swing.JLabel headerLabel;
  private javax.swing.JComboBox<Major> majorComboBox;
  private javax.swing.JLabel majorLabel;
  private javax.swing.JTextField passedField;
  private javax.swing.JLabel passedLabel;
  private javax.swing.JPanel passedPanel;
  private javax.swing.JLabel quotaLabel;
  private javax.swing.JTextField quotatField;
  private javax.swing.JScrollPane scrollPane;
  private javax.swing.JLabel splitLabel1;
  private javax.swing.JLabel splitLabel2;
  private javax.swing.JTextField totalField1;
  private javax.swing.JTextField totalField2;
  // End of variables declaration//GEN-END:variables
}
