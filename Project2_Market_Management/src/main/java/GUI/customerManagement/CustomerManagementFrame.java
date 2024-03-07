package GUI.customerManagement;

import javax.swing.*;
import java.awt.*;

public class CustomerManagementFrame extends JFrame {
    public CustomerManagementFrame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Customer Management");

        CustomerAdd customerAddPanel = new CustomerAdd();

        getContentPane().add(customerAddPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CustomerManagementFrame().setVisible(true);
        });
    }
}
