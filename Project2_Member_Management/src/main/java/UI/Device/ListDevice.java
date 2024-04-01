package UI.Device;

import BLL.*;
import DAL.*;
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

public class ListDevice extends JPanel {
    DeviceBLL deviceBLL = new DeviceBLL();
    List<Device> ListDevices = deviceBLL.selectAll();

    public ListDevice() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        initTop();
        initCenter();
    }

    private void initTop() {
        JPanel panelTop = new JPanel();
        panelTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelTop.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel titleLabel = new JLabel("Chỗ này làm thanh search");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panelTop.add(titleLabel);
        add(panelTop, BorderLayout.NORTH);
    }

    private void initCenter() {
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
        table = new JTable();
        table = new JTable(modeltable);
        int stt = 1;
        for (Device device : ListDevices) {
            if (device.getStatus() != 0) {
                Object[] rowData = new String[4];
                rowData[0] = String.valueOf(stt++);
                rowData[1] = String.valueOf(device.getId());
                rowData[2] = device.getName();
                rowData[3] = device.getDescription();
                // rowData[4] = device.getStatus();
                // rowData[4] = "/assets/icons8-trash-35.png";
                modeltable.addRow(rowData);
            }
        }

        table.setRowHeight(35);
        setColumnWidth(table, 0, 10);
        setColumnWidth(table, 1, 10);
        setColumnWidth(table, 2, 50);
        setColumnWidth(table, 3, 350);
        setColumnWidth(table, 4, 10);
        table.setModel(modeltable);
        table.setShowGrid(false);
        JScrollPane scrollPane = new JScrollPane(table);
        panel_Table.add(scrollPane, BorderLayout.CENTER);
        panelCenter.add(panel_Table, BorderLayout.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (i != 2 && i != 3) {
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }
        // table.getColumnModel().getColumn(4).setCellRenderer(new ImageRender());
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
                            "Bạn có chắc chắn muốn xóa thông tin thiết bị này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        int row = target.rowAtPoint(e.getPoint());
                        int value = Integer.parseInt((String) target.getValueAt(row, 1));
                        System.out.println(value);
                        deviceBLL.changeStatus(value);
                        removeRowFromTable(modeltable, row);
                    }
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

    public class ImageRender extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            System.out.println((String) value);
            JLabel label = new JLabel();
            if (value instanceof String && (((String) value).endsWith(".png") || ((String) value).endsWith(".jpg"))) {
                ImageIcon originalIcon = new ImageIcon(getClass().getResource((String) value));
                Image originalImage = originalIcon.getImage();
                Image resizedImage = originalImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);
                label.setIcon(resizedIcon);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int choice = JOptionPane.showConfirmDialog(null,
                                "Bạn có chắc chắn muốn lưu thay đổi không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

                        // Xử lý dựa trên sự lựa chọn của người dùng
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Hành động đã được thực hiện!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Hành động đã bị hủy bỏ!");
                        }
                    }
                });
            } else {
                System.out.println("không có");
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
            return label;
        }
    }

    private JPanel panelCenter;
    private JPanel panel_Table;
    private DefaultTableModel modeltable;
    private JTable table;
}
