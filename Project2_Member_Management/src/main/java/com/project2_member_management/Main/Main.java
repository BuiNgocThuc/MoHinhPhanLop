
package com.project2_member_management.Main;
import BLL.DeviceBLL;
import POJOs.Device;
import UI.Home;
import com.formdev.flatlaf.FlatLightLaf;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String args[]) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
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
