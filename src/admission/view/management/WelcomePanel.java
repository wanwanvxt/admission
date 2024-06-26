package admission.view.management;

import admission.model.User;

public class WelcomePanel extends javax.swing.JPanel {

  private User currentUser;

  public WelcomePanel(User currentUser) {
    initComponents();
    this.currentUser = currentUser;

    headerLabel.setText(String.format("WELCOME, %s!", currentUser.getUsername()));
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    headerLabel = new javax.swing.JLabel();
    bgLabel = new javax.swing.JLabel();

    java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
    layout.columnWeights = new double[] {1.0};
    layout.rowWeights = new double[] {1.0, 5.0};
    setLayout(layout);

    headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    headerLabel.setText("WELCOME, __!");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
    add(headerLabel, gridBagConstraints);

    bgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admission/bg.png"))); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    add(bgLabel, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel bgLabel;
  private javax.swing.JLabel headerLabel;
  // End of variables declaration//GEN-END:variables
}
