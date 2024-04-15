package UI.Device;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BLL.DeviceBLL;
import POJOs.Device;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevicePanel extends JPanel {

    public DevicePanel() {
        removeAll();
        setLayout(new BorderLayout());
        initComponents();
        revalidate();
        repaint();
        this.setVisible(true);
    }

    public void initComponents() {
        initTop();
        initContent();
    }

    public void initContent() {
        // Tạo content panel
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        // Thêm nội dung vào content panel
        panel1 = new ListDevice(this);
        panel1.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Menu 2");
            }
        });
        panel2 = new AddDevice(this);
        contentPanel.add(panel1, "Menu 1");
        contentPanel.add(panel2, "Menu 2");

        add(contentPanel, BorderLayout.CENTER);
    }

    public void initTop() {
        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTop.setBackground(Color.WHITE);
        panelTop.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        JLabel titleLabel = new JLabel("MEMBER MANAGEMENT");
        titleLabel.setFont(new Font("Segoe UI", 1, 16));
        panelTop.add(titleLabel);
        add(panelTop, BorderLayout.NORTH);
    }

    public void inforDevicePanel(int valueID, DefaultTableModel model, int row) {
        AddDevice panel3 = new AddDevice(this);
        DeviceBLL deviceBLL = new DeviceBLL();
        Device device = deviceBLL.getDeviceById(valueID);
        panel3.setInforDevice(device);
        contentPanel.add(panel3, "Menu 3");
        cardLayout.show(contentPanel, "Menu 3");
        panel3.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc chắn muốn xóa thông tin thiết bị này?", "Xác nhận",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    deviceBLL.deleteDevice(valueID);
                    panel1.removeRowFromTable(model, row);
                    cardLayout.show(contentPanel, "Menu 1");
                }
            }
        });
    }

    public void upDateContent() {
        remove(contentPanel);
        initContent();
        revalidate();
        repaint();
    }

    private CardLayout cardLayout;
    private JPanel contentPanel;
    private ListDevice panel1;
    private AddDevice panel2;

}
