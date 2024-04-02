package UI.Device;

import java.awt.Component;
import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class MultiLineTableCellRenderer extends JTextArea implements TableCellRenderer {

    private int targetColumn; // Cột cần kiểm tra và điều chỉnh chiều cao

    public MultiLineTableCellRenderer(int targetColumn) {
        this.targetColumn = targetColumn;
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        setText((value == null) ? "" : value.toString());
        setFont(table.getFont()); // Sử dụng font của table
        setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());

        // Đặt kích thước tối đa để kiểm tra tràn chiều rộng
        setSize(table.getColumnModel().getColumn(column).getWidth(), Integer.MAX_VALUE);

        // Kiểm tra chiều cao mới của JTextArea
        int preferredHeight = getPreferredSize().height;

        // Nếu nội dung tràn chiều rộng của ô hoặc là cột cần kiểm tra
        if (table.getRowHeight(row) < preferredHeight || column == targetColumn) {
            // Đặt chiều cao của hàng để phù hợp với chiều cao mới
            table.setRowHeight(row, preferredHeight);
        }

        // Canh chỉnh văn bản theo chiều dọc bằng cách đặt margin
        setMargin(new Insets((table.getRowHeight(row) - getPreferredSize().height) / 2, 0, 0, 0));

        return this;
    }
}
