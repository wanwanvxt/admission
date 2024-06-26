package admission.view.management;

import admission.controller.AspirationController;
import admission.controller.CandidateController;
import admission.controller.MajorController;
import admission.controller.ProfileController;
import admission.model.Aspiration;
import admission.model.Candidate;
import admission.model.Major;
import admission.model.Profile;
import admission.model.User;
import admission.util.DialogMessage;
import java.sql.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CandMgmtPanel extends javax.swing.JPanel {

  private CandidateController candidateCtrl;
  private ProfileController profileCtrl;
  private MajorController majorCtrl;
  private AspirationController aspirationCtrl;

  private void refreshData() {
    DefaultTableModel candTableModel = (DefaultTableModel) candTable.getModel();
    candTableModel.setRowCount(0);

    List<Candidate> candidates = candidateCtrl.getAllCandidates();
    for (Candidate candidate : candidates) {
      Profile profile = profileCtrl.getProfileByCandidateId(candidate.getId());
      if (profile == null) {
        profile = new Profile(candidate.getId(), false, false, 0);
      }
      Aspiration aspiration = aspirationCtrl.getAspirationByCandidateId(candidate.getId());
      if (aspiration == null) {
        aspiration = new Aspiration(candidate.getId(), 0, "pending");
      }

      candTableModel.addRow(
              new Object[]{
                candidate.getId(), candidate, candidate.getGender(),
                candidate.getBirthdate(), candidate.getAddress(),
                candidate.getEmail(), candidate.getPhoneNumber(),
                candidate.getCitizenId(), profile.isSchoolReport(),
                profile.isDiploma(), profile,
                aspiration.getMajorId()
              }
      );
    }

    candTable.setModel(candTableModel);

    nameField.setText("");
    maleRadio.setSelected(false);
    femaleRadio.setSelected(false);
    birthdateChooser.setDate(new Date(0));
    addressField.setText("");
    emailField.setText("");
    phoneField.setText("");
    citizenField.setText("");
    schoolReportCheckBox.setSelected(false);
    diplomaCheckBox.setSelected(false);
    scoreSpinner.setValue(0);
  }

  private void setSelectedGender(boolean flag) {
    maleRadio.setSelected(flag);
    femaleRadio.setSelected(!flag);
  }

  private boolean getSelectedGender() {
    if (maleRadio.isSelected() && !femaleRadio.isSelected()) {
      return true;
    } else if (!maleRadio.isSelected() && femaleRadio.isSelected()) {
      return false;
    }

    return false;
  }

  public CandMgmtPanel() {
    initComponents();
    candidateCtrl = new CandidateController();
    profileCtrl = new ProfileController();
    majorCtrl = new MajorController();
    aspirationCtrl = new AspirationController();

    List<Major> majors = majorCtrl.getAllMajors();
    majorComboBox.removeAllItems();
    for (Major major : majors) {
      majorComboBox.addItem(major);
    }

    refreshData();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    genderRadioGroup = new javax.swing.ButtonGroup();
    headerLabel = new javax.swing.JLabel();
    scrollPane = new javax.swing.JScrollPane();
    candTable = new javax.swing.JTable();
    formPanel = new javax.swing.JPanel();
    nameLabel = new javax.swing.JLabel();
    nameField = new javax.swing.JTextField();
    genderLabel = new javax.swing.JLabel();
    maleRadio = new javax.swing.JRadioButton();
    femaleRadio = new javax.swing.JRadioButton();
    birthdateLabel = new javax.swing.JLabel();
    birthdateChooser = new com.toedter.calendar.JDateChooser();
    addressLabel = new javax.swing.JLabel();
    addressScrollPane = new javax.swing.JScrollPane();
    addressField = new javax.swing.JTextArea();
    emailLabel = new javax.swing.JLabel();
    emailField = new javax.swing.JTextField();
    phoneLabel = new javax.swing.JLabel();
    phoneField = new javax.swing.JTextField();
    citizenLabel = new javax.swing.JLabel();
    citizenField = new javax.swing.JTextField();
    addButton = new javax.swing.JButton();
    updateButton = new javax.swing.JButton();
    deleteButton = new javax.swing.JButton();
    schoolReportLabel = new javax.swing.JLabel();
    schoolReportCheckBox = new javax.swing.JCheckBox();
    diplomaLabel = new javax.swing.JLabel();
    diplomaCheckBox = new javax.swing.JCheckBox();
    scoreLabel = new javax.swing.JLabel();
    scoreSpinner = new javax.swing.JSpinner();
    majorLabel = new javax.swing.JLabel();
    majorComboBox = new javax.swing.JComboBox<>();

    java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
    layout.columnWeights = new double[] {1.0, 1.0};
    layout.rowWeights = new double[] {1.0, 10.0};
    setLayout(layout);

    headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    headerLabel.setText("CANDIDATE MANAGEMENT");
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
        "ID", "Name", "Gender", "Birthdate", "Address", "Email", "Phone number", "Citizen ID", "School report", "Diploma", "Score", "Major ID"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false, false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    candTable.getTableHeader().setReorderingAllowed(false);
    candTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(java.awt.event.MouseEvent evt) {
        candTableMousePressed(evt);
      }
    });
    scrollPane.setViewportView(candTable);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(scrollPane, gridBagConstraints);

    java.awt.GridBagLayout formPanelLayout = new java.awt.GridBagLayout();
    formPanelLayout.columnWeights = new double[] {1.0, 1.0, 1.0};
    formPanelLayout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 10.0, 1.0};
    formPanel.setLayout(formPanelLayout);

    nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    nameLabel.setText("Name:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(nameLabel, gridBagConstraints);

    nameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(nameField, gridBagConstraints);

    genderLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    genderLabel.setText("Gender:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(genderLabel, gridBagConstraints);

    genderRadioGroup.add(maleRadio);
    maleRadio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    maleRadio.setText("Male");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
    formPanel.add(maleRadio, gridBagConstraints);

    genderRadioGroup.add(femaleRadio);
    femaleRadio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    femaleRadio.setText("Female");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(femaleRadio, gridBagConstraints);

    birthdateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    birthdateLabel.setText("Birthdate:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(birthdateLabel, gridBagConstraints);

    birthdateChooser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(birthdateChooser, gridBagConstraints);

    addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    addressLabel.setText("Address:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(addressLabel, gridBagConstraints);

    addressScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

    addressField.setColumns(20);
    addressField.setRows(5);
    addressScrollPane.setViewportView(addressField);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(addressScrollPane, gridBagConstraints);

    emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    emailLabel.setText("Email:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(emailLabel, gridBagConstraints);

    emailField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(emailField, gridBagConstraints);

    phoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    phoneLabel.setText("Phone number:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(phoneLabel, gridBagConstraints);

    phoneField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(phoneField, gridBagConstraints);

    citizenLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    citizenLabel.setText("Citizen ID:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(citizenLabel, gridBagConstraints);

    citizenField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(citizenField, gridBagConstraints);

    addButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    addButton.setText("Add");
    addButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 12;
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
    gridBagConstraints.gridy = 12;
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
    gridBagConstraints.gridy = 12;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    formPanel.add(deleteButton, gridBagConstraints);

    schoolReportLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    schoolReportLabel.setText("School report:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 7;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(schoolReportLabel, gridBagConstraints);

    schoolReportCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    schoolReportCheckBox.setText("Submitted");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 7;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(schoolReportCheckBox, gridBagConstraints);

    diplomaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    diplomaLabel.setText("Diploma:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(diplomaLabel, gridBagConstraints);

    diplomaCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    diplomaCheckBox.setText("Submitted");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(diplomaCheckBox, gridBagConstraints);

    scoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    scoreLabel.setText("Score:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 9;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(scoreLabel, gridBagConstraints);

    scoreSpinner.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    scoreSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.01d));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 9;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(scoreSpinner, gridBagConstraints);

    majorLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    majorLabel.setText("Major:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    formPanel.add(majorLabel, gridBagConstraints);

    majorComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
    formPanel.add(majorComboBox, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(formPanel, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

  private void candTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_candTableMousePressed
    int selectedRow = candTable.getSelectedRow();
    if (selectedRow != -1) {
      Candidate candidate = (Candidate) candTable.getValueAt(selectedRow, 1);
      nameField.setText(candidate.getName());
      setSelectedGender(candidate.getGender());
      birthdateChooser.setDate(candidate.getBirthdate());
      addressField.setText(candidate.getAddress());
      emailField.setText(candidate.getEmail());
      phoneField.setText(candidate.getPhoneNumber());
      citizenField.setText(candidate.getCitizenId());
      Profile profile = (Profile) candTable.getValueAt(selectedRow, 10);
      schoolReportCheckBox.setSelected(profile.isSchoolReport());
      diplomaCheckBox.setSelected(profile.isDiploma());
      scoreSpinner.setValue(profile.getScore());
      int majorId = (int) candTable.getValueAt(selectedRow, 11);
      for (int i = 0; i < majorComboBox.getItemCount(); i++) {
        Major major = majorComboBox.getItemAt(i);
        if (major.getId() == majorId) {
          majorComboBox.setSelectedIndex(i);
          break;
        }
      }
    }
  }//GEN-LAST:event_candTableMousePressed

  private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    String name = nameField.getText().trim();
    boolean gender = getSelectedGender();
    Date birthdate = new Date(birthdateChooser.getDate().getTime());
    String address = addressField.getText().trim();
    String email = emailField.getText().trim();
    String phoneNumber = phoneField.getText().trim();
    String citizenId = citizenField.getText().trim();
    boolean schoolReport = schoolReportCheckBox.isSelected();
    boolean diploma = diplomaCheckBox.isSelected();
    double score = (double) scoreSpinner.getValue();
    Major major = (Major) majorComboBox.getSelectedItem();

    if (name.isBlank() || address.isBlank() || email.isBlank() || phoneNumber.isBlank() || citizenId.isBlank()) {
      DialogMessage.showWarning(this, "All fields are required!");
    } else {
      Candidate newCandidate = new Candidate(name, gender, birthdate, address, email, phoneNumber, citizenId);
      int insertedCandidateId = candidateCtrl.addCandidate(newCandidate);
      Profile profile = new Profile(insertedCandidateId, schoolReport, diploma, score);
      Aspiration aspiration = new Aspiration(insertedCandidateId, major.getId(), "pending");

      if (insertedCandidateId > 0) {
        DialogMessage.showInfo(this, "Added candidate information successfully!");

        boolean addProfileSuccess = profileCtrl.addProfile(profile);
        if (addProfileSuccess) {
          DialogMessage.showInfo(this, "Added candidate profile successfully!");

          boolean addAspirationSuccess = aspirationCtrl.addAspiration(aspiration);
          if (addAspirationSuccess) {
            DialogMessage.showInfo(this, "Added candidate aspiration successfully!");
          } else {
            DialogMessage.showError(this, "Failed to add the new candidate aspiration!");
          }
        } else {
          DialogMessage.showError(this, "Failed to add the new candidate profile!");
        }
        refreshData();
      } else {
        DialogMessage.showError(this, "Failed to add the new candidate!");
      }
    }
  }//GEN-LAST:event_addButtonActionPerformed

  private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
    int selectedRow = candTable.getSelectedRow();
    if (selectedRow != -1) {
      int candidateId = (int) candTable.getValueAt(selectedRow, 0);
      String name = nameField.getText().trim();
      boolean gender = getSelectedGender();
      Date birthdate = new Date(birthdateChooser.getDate().getTime());
      String address = addressField.getText().trim();
      String email = emailField.getText().trim();
      String phoneNumber = phoneField.getText().trim();
      String citizenId = citizenField.getText().trim();
      boolean schoolReport = schoolReportCheckBox.isSelected();
      boolean diploma = diplomaCheckBox.isSelected();
      double score = (double) scoreSpinner.getValue();
      Major major = (Major) majorComboBox.getSelectedItem();

      if (name.isBlank() || address.isBlank() || email.isBlank() || phoneNumber.isBlank() || citizenId.isBlank()) {
        DialogMessage.showWarning(this, "All fields are required!");
      } else {
        Candidate newCandidate = new Candidate(candidateId, name, gender, birthdate, address, email, phoneNumber, citizenId);
        Profile profile = new Profile(candidateId, schoolReport, diploma, score);
        Aspiration aspiration = new Aspiration(candidateId, major.getId(), "pending");

        boolean updateCandidateSuccess = candidateCtrl.updateCandidate(newCandidate);
        if (updateCandidateSuccess) {
          DialogMessage.showInfo(this, "Updated candidate successfully!");

          boolean updateProfileSuccess = profileCtrl.addOrUpdateProfile(profile);
          if (updateProfileSuccess) {
            DialogMessage.showInfo(this, "Updated candidate profile successfully!");

            boolean updateAspirationSuccess = aspirationCtrl.addOrUpdateAspiration(aspiration);
            if (updateAspirationSuccess) {
              DialogMessage.showInfo(this, "Updated candidate aspiration successfully!");
            } else {
              DialogMessage.showError(this, "Failed to update this candidate aspiration!");
            }
          } else {
            DialogMessage.showError(this, "Failed to update this candidate profile!");
          }
          refreshData();
        } else {
          DialogMessage.showError(this, "Failed to update this candidate!");
        }
      }
    } else {
      DialogMessage.showWarning(this, "Please select a candidate to update!");
    }
  }//GEN-LAST:event_updateButtonActionPerformed

  private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    int selectedRow = candTable.getSelectedRow();
    if (selectedRow != -1) {
      int id = (int) candTable.getValueAt(selectedRow, 0);

      if (candidateCtrl.deleteCandidate(id)) {
        DialogMessage.showInfo(this, "Deleted successfully!");
        refreshData();
      } else {
        DialogMessage.showError(this, "Failed to delete this candidate!");
      }
    } else {
      DialogMessage.showWarning(this, "Please select a candidate to delete!");
    }
  }//GEN-LAST:event_deleteButtonActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton addButton;
  private javax.swing.JTextArea addressField;
  private javax.swing.JLabel addressLabel;
  private javax.swing.JScrollPane addressScrollPane;
  private com.toedter.calendar.JDateChooser birthdateChooser;
  private javax.swing.JLabel birthdateLabel;
  private javax.swing.JTable candTable;
  private javax.swing.JTextField citizenField;
  private javax.swing.JLabel citizenLabel;
  private javax.swing.JButton deleteButton;
  private javax.swing.JCheckBox diplomaCheckBox;
  private javax.swing.JLabel diplomaLabel;
  private javax.swing.JTextField emailField;
  private javax.swing.JLabel emailLabel;
  private javax.swing.JRadioButton femaleRadio;
  private javax.swing.JPanel formPanel;
  private javax.swing.JLabel genderLabel;
  private javax.swing.ButtonGroup genderRadioGroup;
  private javax.swing.JLabel headerLabel;
  private javax.swing.JComboBox<Major> majorComboBox;
  private javax.swing.JLabel majorLabel;
  private javax.swing.JRadioButton maleRadio;
  private javax.swing.JTextField nameField;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JTextField phoneField;
  private javax.swing.JLabel phoneLabel;
  private javax.swing.JCheckBox schoolReportCheckBox;
  private javax.swing.JLabel schoolReportLabel;
  private javax.swing.JLabel scoreLabel;
  private javax.swing.JSpinner scoreSpinner;
  private javax.swing.JScrollPane scrollPane;
  private javax.swing.JButton updateButton;
  // End of variables declaration//GEN-END:variables
}
