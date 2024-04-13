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
        initCenter();
    }

    public void setInforDevice(Device device) {
        jPanelButton.removeAll();
        jPanelButton.revalidate();
        jPanelButton.repaint();
        Border titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY),
                "Thông tin thiết bị", TitledBorder.LEADING, TitledBorder.TOP);
        ((TitledBorder) titledBorder)
                .setTitleFont(((TitledBorder) titledBorder).getTitleFont().deriveFont(Font.BOLD, 14));
        panelCenter.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 50, 10),
                titledBorder));
        txtDeviceName.setText(String.valueOf(device.getId()));
        txtDeviceName.setEditable(false);

        txtDeviceID.setText(device.getName());
        txtDeviceID.setEditable(false);

        txtDescription.setText(device.getDescription());
        txtDescription.setEditable(false);
        initButton();
    }

    private void initButton() {
        btnSave = new Button("Lưu");
        btnSave.setButton(80, 30, new Color(0, 102, 204));
        btnSave.addActionListener(saveButtonListener);

        btnEdit = new Button("Sửa");
        btnEdit.setButton(80, 30, new Color(0, 204, 102));
        btnEdit.addActionListener(editButtonListener);

        btnDelete = new Button("Xóa");
        btnDelete.setButton(80, 30, new Color(255, 0, 0));
        btnDelete.addActionListener(deleteButtonListener);

        btnExit = new Button("Thoát");
        btnExit.setButton(80, 30, new Color(255, 255, 0));

        jPanelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanelButton.add(btnEdit);
        jPanelButton.add(btnDelete);
        jPanelButton.add(btnSave);
        jPanelButton.add(btnExit);
        btnSave.setVisible(false);

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

        JLabel lblDeviceID = new JLabel("Mã Thiết Bị:");
        contentPanel.add(lblDeviceID, gbc);

        gbc.gridy++;
        txtDeviceID = new JTextField();
        contentPanel.add(txtDeviceID, gbc);

        gbc.gridy++;
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
        jPanelButton = new JPanel();
        btnSave = new Button("Save");
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
                    device.setId(Integer.parseInt(txtDeviceID.getText()));
                    device.setName(txtDeviceName.getText());
                    device.setDescription(txtDescription.getText());
                    boolean isSuccess = deviceBLL.insertDevice(device);
                    if (isSuccess) {
                        JOptionPane.showMessageDialog(null, "Thêm thiết bị thành công!");
                        txtDeviceID.setText("");
                        txtDeviceName.setText("");
                        txtDescription.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi thêm thiết bị. Vui lòng thử lại sau.");
                    }
                }
            }
        });

        contentPanel.add(jPanelButton, gbc);
    }

    ActionListener deleteButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Xử lý hành động khi nút "Xóa" được nhấn
            // Viết mã xử lý xóa ở đây
        }
    };

    ActionListener exitButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Xử lý hành động khi nút "Xóa" được nhấn
            // Viết mã xử lý xóa ở đây
        }
    };

    ActionListener editButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtDeviceName.setEditable(true);
            txtDeviceID.setEditable(true);
            txtDescription.setEditable(true);
            btnEdit.setVisible(false);
            btnSave.setVisible(true);
        }
    };

    ActionListener saveButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Xử lý hành động khi nút "Xóa" được nhấn
            // Viết mã xử lý xóa ở đây
        }
    };

    private JPanel panelCenter;
    private JPanel contentPanel;
    private JTextField txtDeviceName;
    private JTextField txtDeviceID;
    private JTextArea txtDescription;
    private JPanel jPanelButton;
    private Button btnSave;
    private Button btnEdit;
    public Button btnDelete;
    public Button btnExit;

}
