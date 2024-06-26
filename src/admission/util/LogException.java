package admission.util;

public class LogException {

  public static void log(String cls, Exception e) {
    java.util.logging.Logger.getLogger(cls).log(java.util.logging.Level.SEVERE, null, e);
  }
}
