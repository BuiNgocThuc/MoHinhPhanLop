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

public class AddDevice extends JPanel {
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
        panelCenter.setBackground(Color.RED);
        panelCenter.setLayout(new BorderLayout());
        contentPanel = new JPanel();
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        Border titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY),
                "Thêm Thiết Bị", TitledBorder.LEADING, TitledBorder.TOP);
        ((TitledBorder) titledBorder)
                .setTitleFont(((TitledBorder) titledBorder).getTitleFont().deriveFont(Font.BOLD, 14));
        contentPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 50, 10),
                titledBorder));
        JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        panelCenter.add(contentPanel, BorderLayout.CENTER);
        add(panelCenter);
    }

    private JPanel panelCenter;
    private JPanel contentPanel;
}
