package GUI.customerManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCustomer extends JPanel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Customer Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new PanelCustomer(), BorderLayout.CENTER);
            frame.setSize(1100, 700);
            frame.setVisible(true);
        });
    }

    public PanelCustomer() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        initTop();
        initLeft();
        initContent();
    }

    private void initLeft() {
        panelLeft = new JPanel();
//        panelLeft.setBackground(new Color(0, 191, 255));
        panelLeft.setBackground(null);

        menuPanel = new JPanel(new GridBagLayout());
//        menuPanel.setBackground(new Color(0, 191, 255));
        menuPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Thay đổi các giá trị để phù hợp với nhu cầu của bạn

        Button btnMenu1 = new Button("Danh sách khách hàng");
        Button btnMenu2 = new Button("Chi tiết khách hàng");
        Button btnMenu3 = new Button("Thêm Khách hàng");
        Button btnMenu4 = new Button("Thu gọn");
        Button btnMenu5 = new Button("|||");

        btnMenu1.setButton(165, 30, Color.white);
        btnMenu2.setButton(165, 30, Color.white);
        btnMenu3.setButton(165, 30, Color.white);

        btnMenu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Menu 1");
                btnMenu2.setBackground(Color.WHITE);
                btnMenu3.setBackground(Color.WHITE);
            }
        });
        btnMenu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Menu 2");
                btnMenu1.setBackground(Color.WHITE);
                btnMenu3.setBackground(Color.WHITE);
            }
        });
        btnMenu3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Menu 3");
                btnMenu1.setBackground(Color.WHITE);
                btnMenu2.setBackground(Color.WHITE);
            }
        });

        btnMenu4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timer timer = new Timer(30, new ActionListener() { // Tăng thời gian giữa các bước lên 50
                    int width = panelLeft.getWidth(); // Chiều rộng ban đầu của panelLeft

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        width -= 10; // Giảm dần chiều rộng của panelLeft
                        if (width <= 65) { // Nếu chiều rộng đã đạt 0
                            ((Timer) e.getSource()).stop(); // Dừng Timer
                            panelLeft.removeAll(); // Xóa tất cả các thành phần trong panelLeft
                            panelLeft.setBackground(null);
                            panelLeft.add(btnMenu5); // Thêm btnMenu5 vào panelLeft
                            panelLeft.revalidate(); // Yêu cầu panelLeft cập nhật lại layout
                            panelLeft.repaint(); // Vẽ lại panelLeft
                        } else {
                            panelLeft.setPreferredSize(new Dimension(width, panelLeft.getHeight())); // Cập nhật chiều rộng mới cho panelLeft
                            panelLeft.revalidate(); // Yêu cầu panelLeft cập nhật lại layout
                            panelLeft.repaint(); // Vẽ lại panelLeft
                        }
                    }
                });
                timer.start(); // Bắt đầu Timer
            }
        });

        btnMenu5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("nhấn");
                System.out.println(widthLeft);
                Timer timer = new Timer(30, new ActionListener() { // Tăng thời gian giữa các bước lên 50
                    int width = panelLeft.getWidth(); // Chiều rộng ban đầu của panelLeft

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        width += 15; // Tăng dần chiều rộng của panelLeft
                        if (width >= 180) { // Nếu chiều rộng đã đạt đến giá trị ban đầu
                            ((Timer) e.getSource()).stop(); // Dừng Timer
                            panelLeft.removeAll(); // Xóa tất cả các thành phần trong panelLeft
//                            panelLeft.setBackground(new Color(0, 191, 255));
                            panelLeft.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
                            panelLeft.setPreferredSize(new Dimension(width, panelLeft.getHeight()));
                            panelLeft.add(menuPanel); // Thêm menuPanel vào panelLeft
                            panelLeft.revalidate(); // Yêu cầu panelLeft cập nhật lại layout
                            panelLeft.repaint(); // Vẽ lại panelLeft
                        } else {
                            panelLeft.removeAll();
                            panelLeft.setPreferredSize(new Dimension(width, panelLeft.getHeight())); // Cập nhật chiều rộng mới cho panelLeft
                            panelLeft.revalidate(); // Yêu cầu panelLeft cập nhật lại layout
                            panelLeft.repaint(); // Vẽ lại panelLeft
                        }
                    }
                });
                timer.start(); // Bắt đầu Timer
            }
        });

        menuPanel.add(btnMenu1, gbc);
        gbc.gridy++;
        menuPanel.add(btnMenu2, gbc);
        gbc.gridy++;
        menuPanel.add(btnMenu3, gbc);
        gbc.gridy++;
        menuPanel.add(btnMenu4, gbc);
        panelLeft.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        panelLeft.add(menuPanel);
        add(panelLeft, BorderLayout.WEST);
    }

    private void initContent() {
        // Tạo content panel
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        // Thêm nội dung vào content panel
        JPanel panel1 = new ListCustomer();
        JPanel panel2 = new JPanel(); // new panel chi tiết
        panel2.add(new JLabel("Content of Menu 2"));
        JPanel panel3 = new JPanel(); // new panel thêm
        panel3.add(new JLabel("Content of Menu 3"));
        contentPanel.add(panel1, "Menu 1");
        contentPanel.add(panel2, "Menu 2");
        contentPanel.add(panel3, "Menu 3");

        add(contentPanel, BorderLayout.CENTER);
    }

    private void initTop() {
        JPanel panelTop = new JPanel();
        panelTop.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel titleLabel = new JLabel("Quản lý khách hàng");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panelTop.add(titleLabel);
        add(panelTop, BorderLayout.NORTH);
    }

    private CardLayout cardLayout;
    private JPanel menuPanel;
    private JPanel contentPanel;
    private JPanel panelLeft;
    private int widthLeft;

}
