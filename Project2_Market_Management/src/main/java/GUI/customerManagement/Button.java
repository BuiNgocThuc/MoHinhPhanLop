package GUI.customerManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Button extends JButton {

    private Color normalColor;
    private Color hoverColor;
    private Color pressedColor;

    private boolean isSelected = false;

    public Button(String text) {
        super(text);
        setBorderPainted(false);
        setOpaque(false);
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
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setPressedColor(new Color(0, 102, 204));
                setBackground(pressedColor); // Đặt màu khi nhấn nút
            }
        });
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

        // Vẽ văn bản ở giữa nút
        FontMetrics metrics = g2.getFontMetrics(getFont());
        int x = (getWidth() - metrics.stringWidth(getText())) / 2;
        int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g2.setColor(getForeground());
        g2.drawString(getText(), x, y);

        g2.dispose();
    }
}
