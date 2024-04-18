package UI.Device;

import BLL.*;
import POJOs.Device;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ListDevice extends JPanel {

    DeviceBLL deviceBLL = new DeviceBLL();
    List<Device> ListDevices = deviceBLL.selectAll();
    DevicePanel devicePanel;

    public ListDevice(DevicePanel devicePanel) {
        this.devicePanel = devicePanel;
        this.setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        initTop();
        initCenter();
    }

    private void initTop() {
        btnAdd = new Button("+ Add");
        btnAdd.setButton(130, 40, new Color(0, 143, 143));
        btnImport = new Button(" Import");
        btnImport.setButton(130, 40, new Color(0, 143, 143));
        btnImport.setIcon("/images/icons8-excel-30.png");
        btnImport.addActionListener(btnImportListener);
        btnMultiDelete = new Button("- Multi Delete");
        btnMultiDelete.setButton(130, 40, new Color(0, 143, 143));
        btnMultiDelete.addActionListener(multiDeleteListener);
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(Color.WHITE);
        JPanel panelSearch = new JPanel();
        JPanel panelSearchWrapper = new JPanel();
        panelSearchWrapper.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        panelSearchWrapper.setBackground(Color.WHITE);
        panelSearch.setBackground(Color.WHITE);
        panelSearch.setPreferredSize(new Dimension(300, 40));
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelButton.setBackground(Color.WHITE);
        JLabel jLabelSearch = new JLabel();
        txtSearch = new JTextField();
        txtSearch.setBorder(null);
        txtSearch.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        panelTop.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));
        panelSearch.setLayout(new BorderLayout());
        panelSearch.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        jLabelSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-25.png")));
        // jLabelSearch.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        panelSearch.add(jLabelSearch, BorderLayout.WEST);
        panelSearch.add(txtSearch, BorderLayout.CENTER);
        panelButton.add(btnAdd);
        panelButton.add(btnMultiDelete);
        panelButton.add(btnImport);
        panelSearchWrapper.add(panelSearch);
        panelTop.add(panelSearchWrapper, BorderLayout.WEST);
        panelTop.add(panelButton, BorderLayout.EAST);
        add(panelTop, BorderLayout.NORTH);
    }

    public void initCenter() {
        panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());
        panel_Table = new JPanel();
        panel_Table.setLayout(new BorderLayout());
        Border titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.WHITE, Color.GRAY),
                "Device List", TitledBorder.LEADING, TitledBorder.TOP);
        ((TitledBorder) titledBorder)
                .setTitleFont(((TitledBorder) titledBorder).getTitleFont().deriveFont(Font.BOLD, 14));
        panel_Table.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 10, 10, 10), titledBorder));
        modeltable = new DefaultTableModel(
                new Object[][] {},
                new String[] { "STT", "Device ID", "Device Name", "Description", "Action" }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ngăn chặn việc chỉnh sửa ô
            }
        };
        table = new JTable(modeltable);
        int stt = 1;
        for (Device device : ListDevices) {
            Object[] rowData = new String[5];
            rowData[0] = String.valueOf(stt++);
            rowData[1] = String.valueOf(device.getId());
            rowData[2] = device.getName();
            rowData[3] = device.getDescription();
            rowData[4] = "/images/icons8-trash-35.png";
            modeltable.addRow(rowData);
        }

        table.setRowHeight(30);
        setColumnWidth(table, 0, 10);
        setColumnWidth(table, 1, 50);
        setColumnWidth(table, 2, 100);
        setColumnWidth(table, 3, 250);
        setColumnWidth(table, 4, 10);
        table.setModel(modeltable);
        table.setIntercellSpacing(new Dimension(1, 1));
        table.setShowGrid(true);
        JScrollPane scrollPane = new JScrollPane(table);
        panel_Table.add(scrollPane, BorderLayout.CENTER);
        panelCenter.add(panel_Table, BorderLayout.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (i != 2) {
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }
        table.getColumnModel().getColumn(2).setCellRenderer(new MultiLineTableCellRenderer(3));
        table.getColumnModel().getColumn(3).setCellRenderer(new MultiLineTableCellRenderer(3));
        table.getColumnModel().getColumn(3).setCellRenderer(new MultiLineTableCellRenderer(4));
        table.getColumnModel().getColumn(4).setCellRenderer(new ImageRender());
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                int row = target.rowAtPoint(e.getPoint());
                int column = target.columnAtPoint(e.getPoint());

                if (row >= 0 && row < target.getRowCount() && column == 4) {
                    target.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                target.setCursor(Cursor.getDefaultCursor());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                int column = target.columnAtPoint(e.getPoint());
                if (column == 4) {
                    int choice = JOptionPane.showConfirmDialog(null,
                            "Are you sure delete this device information?", "Confirm",
                            JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        int row = target.rowAtPoint(e.getPoint());
                        int valueID = Integer.parseInt((String) target.getValueAt(row, 1));
                        deviceBLL.deleteDevice(valueID);
                        removeRowFromTable(modeltable, row);
                    }
                } else {
                    int row = target.rowAtPoint(e.getPoint());
                    int valueID = Integer.parseInt((String) target.getValueAt(row, 1));
                    devicePanel.inforDevicePanel(valueID, modeltable, row);
                }
            }
        });

        add(panelCenter);
    }

    public static void setColumnWidth(JTable table, int columnIndex, int width) {
        TableColumn column = table.getColumnModel().getColumn(columnIndex);
        column.setPreferredWidth(width);
    }

    public void removeRowFromTable(DefaultTableModel model, int rowIndex) {
        if (rowIndex >= 0 && rowIndex < model.getRowCount()) {
            model.removeRow(rowIndex);
            for (int i = rowIndex; i < model.getRowCount(); i++) {
                model.setValueAt(String.valueOf(i + 1), i, 0);
            }
        } else {
            System.out.println("Invalid row index: " + rowIndex);
        }
    }

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String keyword = txtSearch.getText();
            if (keyword == null || keyword.isEmpty() || keyword.isBlank()) {
                System.out.println("enter");
                List<Device> ListDevices = deviceBLL.selectAll();
                updateTable(ListDevices, modeltable);
                return;
            } else {
                List<Device> results = deviceBLL.searchDevice(keyword);

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                int stt = 1;
                for (Device device : results) {
                    Object[] rowData = new Object[5];
                    rowData[0] = String.valueOf(stt++);
                    rowData[1] = String.valueOf(device.getId());
                    rowData[2] = device.getName();
                    rowData[3] = device.getDescription();
                    rowData[4] = "/images/icons8-trash-35.png";
                    model.addRow(rowData);
                }
                model.fireTableDataChanged();
            }
        }
    }

    public void updateTable(List<Device> devices, DefaultTableModel model) {
        model.setRowCount(0);
        int stt = 1;
        for (Device device : devices) {
            Object[] rowData = new Object[5];
            rowData[0] = String.valueOf(stt++);
            rowData[1] = String.valueOf(device.getId());
            rowData[2] = device.getName();
            rowData[3] = device.getDescription();
            rowData[4] = "/images/icons8-trash-35.png";
            model.addRow(rowData);
        }
    }

    ActionListener multiDeleteListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            boolean validInput = false;
            int year = 0;
            while (!validInput) {
                String input = JOptionPane.showInputDialog(null, "Enter the year to delete:");
                if (input != null) {
                    if (!input.isEmpty()) {
                        try {
                            year = Integer.parseInt(input);
                            if (year > 0) {
                                validInput = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Please enter a valid year (greater than 0)!",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid year!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter the year to delete!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    return;
                }
            }
            int deletecount = deviceBLL.deleteDeviecByYear(year);
            if (deletecount != 0) {
                JOptionPane.showMessageDialog(null,
                        "Successfully deleted " + deletecount + " devices",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                devicePanel.upDateContent();
            } else {
                JOptionPane.showMessageDialog(null,
                        "An error occurred while deleting devices.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    };

    ActionListener btnImportListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select Excel file to import");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls", "xlsx");
            fileChooser.setFileFilter(filter);
            int userSelection = fileChooser.showOpenDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToImport = fileChooser.getSelectedFile();
                int importedCount = deviceBLL.importExcel(fileToImport);
                if (importedCount != 0) {
                    JOptionPane.showMessageDialog(null,
                            "Successfully imported " + importedCount + " devices from Excel file.",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    devicePanel.upDateContent();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "An error occurred while importing from Excel file.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    };
    private JPanel panelCenter;
    private JPanel panel_Table;
    private DefaultTableModel modeltable;
    private JTable table;
    private JTextField txtSearch;
    public Button btnAdd;
    public Button btnImport;
    public Button btnMultiDelete;
}
