package UI.Device;

import BLL.*;
import POJOs.Device;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.List;
import java.awt.event.KeyEvent;

public class ListDevice extends JPanel {
    DeviceBLL deviceBLL = new DeviceBLL();
    List<Device> ListDevices = deviceBLL.selectAll();
    DevicePanel devicePanel;

    public ListDevice(DevicePanel devicePanel) {
        this.devicePanel = devicePanel;
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        initTop();
        initCenter();
    }

    private void initTop() {
        btnAdd = new Button("+ Add");
        btnImport = new Button(" Import");
        btnImport.setIcon("/images/icons8-excel-30.png");
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(Color.WHITE);
        JPanel panelSearch = new JPanel();
        panelSearch.setBackground(Color.WHITE);
        panelSearch.setPreferredSize(new Dimension(300, 40));
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelButton.setBackground(Color.WHITE);
        JLabel jLabelSearch = new JLabel();
        txtSearch = new JTextField();
        txtSearch.setBorder(null);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        panelTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelSearch.setLayout(new BorderLayout());
        panelSearch.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        jLabelSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-25.png")));
        jLabelSearch.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        panelSearch.add(jLabelSearch, BorderLayout.WEST);
        panelSearch.add(txtSearch, BorderLayout.CENTER);

        panelButton.add(btnAdd);
        panelButton.add(btnImport);
        panelTop.add(panelSearch, BorderLayout.WEST);
        panelTop.add(panelButton, BorderLayout.EAST);
        add(panelTop, BorderLayout.NORTH);
    }

    public void initCenter() {
        panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());
        panel_Table = new JPanel();
        panel_Table.setLayout(new BorderLayout());
        Border titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY),
                "Danh sách thiết bị", TitledBorder.LEADING, TitledBorder.TOP);
        ((TitledBorder) titledBorder)
                .setTitleFont(((TitledBorder) titledBorder).getTitleFont().deriveFont(Font.BOLD, 14));
        panel_Table.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 10, 50, 10),
                titledBorder));
        modeltable = new DefaultTableModel(
                new Object[][] {},
                new String[] { "STT", "Mã Thiết Bị", "Tên Thiết Bị", "Mô Tả", "" }) {
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
        table.setShowGrid(false);
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
                            "Bạn có chắc chắn muốn xóa thông tin thiết bị này?", "Xác nhận",
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

    private JPanel panelCenter;
    private JPanel panel_Table;
    private DefaultTableModel modeltable;
    private JTable table;
    private JTextField txtSearch;
    public Button btnAdd;
    public Button btnImport;
}
