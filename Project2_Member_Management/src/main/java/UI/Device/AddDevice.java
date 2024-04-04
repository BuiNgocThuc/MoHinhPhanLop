package UI.Device;

import BLL.*;
import POJOs.Device;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class AddDevice extends JPanel {
    DeviceBLL deviceBLL = new DeviceBLL();

    public AddDevice() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        // initTop();
        initCenter();
    }

    private void initTop() {
        JPanel panelTop = new JPanel();
        panelTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelTop.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel titleLabel = new JLabel("Thêm Thiết Bị");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panelTop.add(titleLabel);
        add(panelTop, BorderLayout.NORTH);
    }

    private void initCenter() {
        panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());
        Border titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY),
                "Thêm Thiết Bị", TitledBorder.LEADING, TitledBorder.TOP);
        ((TitledBorder) titledBorder)
                .setTitleFont(((TitledBorder) titledBorder).getTitleFont().deriveFont(Font.BOLD, 14));
        panelCenter.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 50, 10),
                titledBorder));
        initContent();
        panelCenter.add(contentPanel, BorderLayout.NORTH);
        JPanel jPanel = new JPanel();
        panelCenter.add(jPanel, BorderLayout.CENTER);

        txtDescription.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (txtDescription.getRows() == 10) {
                    panelCenter.add(contentPanel, BorderLayout.NORTH);
                    panelCenter.add(jPanel, BorderLayout.CENTER);

                }
            }
        });

        jPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (jPanel.getHeight() <= 0) {
                    panelCenter.add(contentPanel, BorderLayout.CENTER);
                }
            }
        });

        add(panelCenter);
    }

    private void initContent() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 50, 5, 50);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; // Đặt trọng số cho chiều ngang

        JLabel lblDeviceName = new JLabel("Tên Thiết Bị:");
        contentPanel.add(lblDeviceName, gbc);

        gbc.gridy++;
        txtDeviceName = new JTextField();
        contentPanel.add(txtDeviceName, gbc);

        gbc.gridy++;
        JLabel lblDescription = new JLabel("Mô Tả:");
        contentPanel.add(lblDescription, gbc);

        gbc.gridy++;
        txtDescription = new JTextArea(10, 20);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtDescription);
        contentPanel.add(scrollPane, gbc);

        gbc.gridy++;
        Button btnSave = new Button("Save");
        JPanel jPanelButton = new JPanel();
        btnSave.setButton(130, 30, new Color(0, 102, 204));
        jPanelButton.add(btnSave);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc chắn muốn thêm thiết bị này?", "Xác nhận",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    Device device = new Device();
                    device.setName(txtDeviceName.getText());
                    device.setDescription(txtDescription.getText());
                    device.setStatus(1);
                    deviceBLL.insertDevice(device);
                }
            }
        });

        contentPanel.add(jPanelButton, gbc);
    }

    private JPanel panelCenter;
    private JPanel contentPanel;
    private JTextField txtDeviceName;
    private JTextArea txtDescription;
}
