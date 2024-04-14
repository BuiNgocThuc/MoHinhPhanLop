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
    DevicePanel devicePanel;

    public AddDevice(DevicePanel devicePanel) {
        this.devicePanel = devicePanel;
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
                "Device Information", TitledBorder.LEADING, TitledBorder.TOP);
        ((TitledBorder) titledBorder)
                .setTitleFont(((TitledBorder) titledBorder).getTitleFont().deriveFont(Font.BOLD, 14));
        panelCenter.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 50, 10),
                titledBorder));
        txtDeviceID.setText(String.valueOf(device.getId()));
        txtDeviceID.setEditable(false);

        txtDeviceName.setText(device.getName());
        txtDeviceName.setEditable(false);

        txtDescription.setText(device.getDescription());
        txtDescription.setEditable(false);
        initButton(device);
    }

    private void initButton(Device device) {
        btnSave = new Button("Save");
        btnSave.setButton(80, 30, new Color(0, 102, 204));
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Are you sure save this change?", "Confirm",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    device.setName(txtDeviceName.getText());
                    device.setDescription(txtDescription.getText());
                    boolean isSuccess = deviceBLL.updateDevice(device);
                    if (isSuccess) {
                        JOptionPane.showMessageDialog(null, "Edit device information successfully!");
                        txtDeviceName.setEditable(false);
                        txtDescription.setEditable(false);
                        btnEdit.setVisible(true);
                        btnSave.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "An error occurred while adding a device. Please try again later.");
                    }
                }
            }
        });

        btnEdit = new Button("Edit");
        btnEdit.setButton(80, 30, new Color(0, 204, 102));
        btnEdit.addActionListener(editButtonListener);

        btnDelete = new Button("Delete");
        btnDelete.setButton(80, 30, new Color(255, 0, 0));
        btnDelete.addActionListener(deleteButtonListener);

        btnExit = new Button("Exit");
        btnExit.setButton(80, 30, new Color(255, 0, 0));
        btnExit.addActionListener(exitButtonListener);

        jPanelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanelButton.add(btnDelete);
        jPanelButton.add(btnEdit);
        jPanelButton.add(btnSave);
        jPanelButton.add(btnExit);
        btnSave.setVisible(false);

    }

    private void initCenter() {
        panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());
        Border titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY),
                "Add Device", TitledBorder.LEADING, TitledBorder.TOP);
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

        JLabel lblDeviceID = new JLabel("Device ID:");
        contentPanel.add(lblDeviceID, gbc);

        gbc.gridy++;
        txtDeviceID = new JTextField();
        contentPanel.add(txtDeviceID, gbc);

        gbc.gridy++;
        JLabel lblDeviceName = new JLabel("Device Name:");
        contentPanel.add(lblDeviceName, gbc);

        gbc.gridy++;
        txtDeviceName = new JTextField();
        contentPanel.add(txtDeviceName, gbc);

        gbc.gridy++;
        JLabel lblDescription = new JLabel("Description:");
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
        btnExit = new Button("Exit");
        btnExit.setButton(130, 30, new Color(255, 0, 0));
        jPanelButton.add(btnExit);
        btnExit.addActionListener(exitButtonListener);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Are you sure add this device?", "Confirm",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    Device device = new Device();
                    device.setId(Integer.parseInt(txtDeviceID.getText()));
                    device.setName(txtDeviceName.getText());
                    device.setDescription(txtDescription.getText());
                    boolean isSuccess = deviceBLL.insertDevice(device);
                    if (isSuccess) {
                        JOptionPane.showMessageDialog(null, "Device added successfully!");
                        txtDeviceID.setText("");
                        txtDeviceName.setText("");
                        txtDescription.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "An error occurred while adding the device. Please try again later.");
                    }
                }
            }
        });

        contentPanel.add(jPanelButton, gbc);
    }

    private void removePanel() {
        this.setVisible(false);
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
            removePanel();
            devicePanel.upDateContent();
            devicePanel.setVisible(true);
        }
    };

    ActionListener editButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtDeviceName.setEditable(true);
            txtDescription.setEditable(true);
            btnEdit.setVisible(false);
            btnDelete.setVisible(false);
            btnSave.setVisible(true);
        }
    };

    private JPanel panelCenter;
    public JPanel contentPanel;
    private JTextField txtDeviceName;
    private JTextField txtDeviceID;
    private JTextArea txtDescription;
    private JPanel jPanelButton;
    public Button btnSave;
    private Button btnEdit;
    public Button btnDelete;
    public Button btnExit;

}
