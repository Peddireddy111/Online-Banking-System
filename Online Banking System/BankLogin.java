
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class BankLogin {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String pin = JOptionPane.showInputDialog(null, "Enter 4-digit PIN:");
            if ("1234".equals(pin)) {
                new OnlineBankingAppGUI().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "❌ Incorrect PIN. Access Denied.");
            }
        });
    }
}
