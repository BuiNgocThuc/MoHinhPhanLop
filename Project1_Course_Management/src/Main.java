import GUi.Home;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.err.println("Failed to initialize LaF");
            }
            new Home().setVisible(true);
        });
    }
}
