package UI.Device;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ImageRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        label = new JLabel();
        if (value instanceof String && (((String) value).endsWith(".png") || ((String) value).endsWith(".jpg"))) {
            ImageIcon originalIcon = new ImageIcon(getClass().getResource((String) value));
            Image originalImage = originalIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            label.setIcon(resizedIcon);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
        } else {
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
        return label;
    }

    private JLabel label;
}
