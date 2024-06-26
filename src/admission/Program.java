package admission;

import admission.util.LogException;
import admission.view.LoginFrame;

public class Program {
  
  public static void main(String args[]) {
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    try {
//      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//        if ("Windows".equals(info.getName())) {
//          javax.swing.UIManager.setLookAndFeel(info.getClassName());
//          break;
//        }
//      }
      javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.themes.FlatMacDarkLaf());
    } catch (javax.swing.UnsupportedLookAndFeelException e) {
      LogException.log(Program.class.getName(), e);
    }
    //</editor-fold>

    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new LoginFrame().setVisible(true);
      }
    });
  }
}
