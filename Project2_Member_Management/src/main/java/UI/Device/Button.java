package UI.Device;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Button extends JButton {

    private Color normalColor;
    private Color hoverColor;
    private Color pressedColor;

    private boolean isSelected = false;

    public Button() {
        super();
    }

    public Button(String text) {
        super(text);
        setBorderPainted(false);
        setOpaque(false);
        setBackground(new java.awt.Color(0, 143, 143));
        setFont(new Font("Segoe UI", 1, 13));
        setForeground(new Color(255, 255, 255));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(130, 40));
    }

    public void setButton(int width, int height, Color color) {
        this.normalColor = color;
        setPreferredSize(new Dimension(width, height));
        setBackground(normalColor);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isSelected) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    setForeground(Color.BLUE);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isSelected) {
                    setCursor(Cursor.getDefaultCursor());
                    setForeground(Color.WHITE);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // setBackground(pressedColor); // Đặt màu khi nhấn nút
            }
        });
    }

    public void setIcon(String imagePath) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image img = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(img));
    }

    public void setHoverColor(Color color) {
        this.hoverColor = color;
    }

    public void setPressedColor(Color color) {
        this.pressedColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Gọi lại phương thức paintComponent của lớp cha để vẽ nền của nút

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ hình tròn với góc cong
        int arc = 10; // Độ cong của góc
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc); // Vẽ hình tròn

        // Tính toán vị trí vẽ văn bản và hình ảnh
        Icon icon = getIcon();
        FontMetrics metrics = g2.getFontMetrics(getFont());
        int textWidth = metrics.stringWidth(getText());
        int totalWidth = (icon != null ? icon.getIconWidth() : 0) + textWidth;
        int xStart = (getWidth() - totalWidth) / 2;
        int xIcon = xStart;
        int xText = xIcon + (icon != null ? icon.getIconWidth() : 0);

        // Vẽ hình ảnh (nếu có)
        if (icon != null) {
            int iconHeight = icon.getIconHeight();
            int yIcon = (getHeight() - iconHeight) / 2; // Đưa hình ảnh vào giữa theo chiều dọc
            icon.paintIcon(this, g2, xIcon, yIcon);
        }

        // Vẽ văn bản
        int yText = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g2.setColor(getForeground());
        g2.drawString(getText(), xText, yText);

        g2.dispose();
    }

}
