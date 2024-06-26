package admission.util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class DialogMessage {

  public static void showInfo(Component parentComp, Object message) {
    show(parentComp, message, "Information", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void showWarning(Component parentComp, Object message) {
    show(parentComp, message, "Warning", JOptionPane.WARNING_MESSAGE);
  }

  public static void showError(Component parentComp, Object message) {
    show(parentComp, message, "Error", JOptionPane.ERROR_MESSAGE);
  }

  private static void show(Component parentComp, Object message, String title, int messageType) {
    JOptionPane.showMessageDialog(parentComp, message, title, messageType);
  }
}
