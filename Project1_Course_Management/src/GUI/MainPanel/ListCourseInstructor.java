package GUI.MainPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.util.List;
import java.util.ArrayList;
import BLL.CourseInstructorBLL;
import DAL.ConnectDB;
import DTO.CourseInstructorDTO;
import com.formdev.flatlaf.FlatLightLaf;
import static java.awt.FlowLayout.LEFT;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;
import java.sql.Connection;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.border.MatteBorder;

public class ListCourseInstructor extends JPanel {

    private ConnectDB connectDB = new ConnectDB();
    Connection connection = connectDB.getConnectDB();
    private CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL(connection);
    private List<CourseInstructorDTO> listCourseInstructorDTO = courseInstructorBLL.getAllCourseInstructors();

    public ListCourseInstructor() {
        initComponents();
        setPreferredSize(new Dimension(1200, 600));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        add(panel_Table);
        add(topPanel, BorderLayout.NORTH);
    }

    private void initComponents() {
        initTopPanel();
        initTable();
    }

    private void initTopPanel() {
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1000, 100));
        topPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
        topPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel titleLabel = new JLabel("  Quản lý phân công");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        topPanel.add(titleLabel);

        JPanel panelAction = new JPanel();
        panelAction.setPreferredSize(new Dimension(20, 20));
        // panelAction.setBackground(new Color(0, 38, 77));
        FlowLayout flowLayout = new FlowLayout(LEFT);
        flowLayout.setAlignOnBaseline(true);
        panelAction.setLayout(flowLayout);

        JButton addButton = new JButton();
        addButton.setBackground(new java.awt.Color(155, 207, 83));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Thêm");
        addButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(191, 234, 124)));
        addButton.setPreferredSize(new java.awt.Dimension(100, 45));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // gọi form thêm
            }
        });
        panelAction.add(addButton);

        JButton editButton = new JButton();
        editButton.setBackground(new java.awt.Color(64, 162, 227));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Sửa");
        editButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 226, 236)));
        editButton.setPreferredSize(new java.awt.Dimension(100, 45));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // gọi form sửa
            }
        });
        panelAction.add(editButton);

        JButton deleteButton = new JButton();
        deleteButton.setBackground(new java.awt.Color(255, 104, 104));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Xóa");
        deleteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 128, 128)));
        deleteButton.setPreferredSize(new java.awt.Dimension(100, 45));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // hành động xóa
            }
        });
        panelAction.add(deleteButton);

        JPanel searchPanel = new JPanel();
        JTextField searchValue = new JTextField();
        JButton searchButton = new JButton();

        searchPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        FlowLayout flowLayout1 = new FlowLayout(RIGHT);
        flowLayout.setAlignOnBaseline(true);
        searchPanel.setLayout(flowLayout1);

        searchValue.setPreferredSize(new Dimension(200, 40));
        searchValue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        searchValue.setText("Nhập thông tin cần tìm");
        searchValue.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchValue.getText().equals("Nhập thông tin cần tìm")) {
                    searchValue.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchValue.getText().isEmpty()) {
                    searchValue.setText("Nhập thông tin cần tìm");
                }
            }
        });
        searchPanel.add(searchValue);
        searchButton.setBorder(null);
        searchButton.setIcon(new ImageIcon(getClass().getResource("/assets/icons8-search-24.png")));
        searchButton.setBackground(Color.WHITE);
        searchPanel.add(searchButton);

        topPanel.add(searchPanel);
        topPanel.add(panelAction);
    }

    private void initTable() {
        panel_Table = new JPanel();
        panel_Table.setForeground(new Color(0, 128, 128));
        panel_Table.setBackground(new Color(0, 128, 128));
        panel_Table.setBorder(
                new TitledBorder(
                        new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                        "Danh sách phân công", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
        panel_Table.setLayout(new BorderLayout(0, 0));

        table = new JTable();
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"STT", "Mã GV", "Tên GV", "Tên Lớp", "Mã Lớp"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Ngăn chặn việc chỉnh sửa ô
                return false;
            }
        };

        table = new JTable(model);
        int stt = 1;
        for (CourseInstructorDTO dto : listCourseInstructorDTO) {
            String[] rowData = new String[5]; // 5 là số cột của bảng
            rowData[0] = String.valueOf(stt++);
            rowData[1] = String.valueOf(dto.getPersonID());
            // rowData[2] = dto.getTeacherName();
            // rowData[3] = dto.getClassName();
            rowData[4] = String.valueOf(dto.getCourseID());
            model.addRow(rowData);
        }

        table.setModel(model);
        scrollPane = new JScrollPane(table);
        table.getTableHeader().setReorderingAllowed(false);

        JTableHeader header = table.getTableHeader();
        DefaultTableCellRenderer centerHeaderRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        centerHeaderRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // set width
        table.setRowHeight(50);
        TableColumn nameCourseColumn = table.getColumnModel().getColumn(3);
        nameCourseColumn.setPreferredWidth(200);

        panel_Table.add(scrollPane);
        add(panel_Table);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("List Course Instructor");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ListCourseInstructor panelAction = new ListCourseInstructor();
            frame.getContentPane().add(panelAction);

            frame.pack();
            frame.setVisible(true);
        });
    }

    private JPanel panel_Table;
    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;

}
