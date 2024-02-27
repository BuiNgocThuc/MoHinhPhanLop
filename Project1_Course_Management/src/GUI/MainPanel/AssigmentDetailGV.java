package GUI.MainPanel;

import BLL.CourseBLL;
import BLL.CourseInstructorBLL;
import BLL.PersonBLL;
import DTO.CourseDTO;
import DTO.CourseInstructorDTO;
import DTO.PersonDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class AssigmentDetailGV extends JPanel {

    private CourseBLL courseBLL = new CourseBLL();
    private CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();
    private List<CourseDTO> listCourseDTO = courseBLL.getAllist();
    private List<CourseInstructorDTO> listCourseDTOOfPersonId;

    public AssigmentDetailGV(int id_GV) throws SQLException {
        listCourseDTOOfPersonId = courseInstructorBLL.getListCourseInstructorsByPersonID(id_GV);
        initComponents(id_GV);
        setPreferredSize(new Dimension(1200, 600));
        setBackground(Color.WHITE);
    }

    private void initComponents(int id_GV) {
        setLayout(new BorderLayout());
        initPanelTop(id_GV);
        add(panelTop, BorderLayout.NORTH);
        initPanelCenter();
        add(panelCenter, BorderLayout.CENTER);
        initPanelBelow();
        add(panelBelow, BorderLayout.SOUTH);
        panelBelow.setVisible(false);
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

            AssigmentDetailGV panelAction = null;
            try {
                panelAction = new AssigmentDetailGV(1);
            } catch (SQLException ex) {
                Logger.getLogger(AssigmentDetailGV.class.getName()).log(Level.SEVERE, null, ex);
            }
            frame.getContentPane().add(panelAction);

            frame.pack();
            frame.setVisible(true);
        });
    }

    private void initPanelTop(int id_GV) {
        panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(1200, 80));
        panelTop.setLayout(new BorderLayout());
        panelTop.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY), // MatteBorder
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // EmptyBorder
        ));

        JLabel titleLabel = new JLabel("Chi tiết phân công của giảng viên");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        panelTop.add(titleLabel, BorderLayout.WEST);

        JPanel panelInfor = new JPanel(new FlowLayout(FlowLayout.LEFT)); // thông tin của giảng viên 
        JLabel jLabelId = new JLabel("ID");
        JLabel jLabelFn = new JLabel("Firstname");
        jLabelFn.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        JLabel jLabelLn = new JLabel("Lastname");
        jLabelLn.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        JLabel jLabelHd = new JLabel("Hiredate");
        jLabelHd.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        Font labelFont = new Font("Arial", Font.BOLD, 18); // Thiết lập font với kích thước 14 và kiểu Plain
        jLabelId.setFont(labelFont);
        jLabelFn.setFont(labelFont);
        jLabelLn.setFont(labelFont);
        jLabelHd.setFont(labelFont);

        JLabel valueId = new JLabel(String.valueOf(id_GV));
        JLabel valueFn = new JLabel();
        JLabel valueLn = new JLabel();
        JLabel valueHd = new JLabel();

        PersonBLL personBLL = new PersonBLL();
        PersonDTO personDTO = personBLL.detailsPerson(id_GV);
        valueFn.setText(personDTO.getFirstName());
        valueLn.setText(personDTO.getLastName());
        valueHd.setText(String.valueOf(personDTO.getHireDate()));

        Font valueFont = new Font("Arial", Font.PLAIN, 18); // Thiết lập font với kích thước 14 và kiểu Bold
        valueId.setFont(valueFont);
        valueFn.setFont(valueFont);
        valueLn.setFont(valueFont);
        valueHd.setFont(valueFont);

        panelInfor.add(jLabelId);
        panelInfor.add(valueId);
        panelInfor.add(jLabelFn);
        panelInfor.add(valueFn);
        panelInfor.add(jLabelLn);
        panelInfor.add(valueLn);
        panelInfor.add(jLabelHd);
        panelInfor.add(valueHd);

        panelTop.add(panelInfor, BorderLayout.SOUTH);

    }

    private void initPanelCenter() {
        panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());
        panel_Table = new JPanel();
        panel_Table.setLayout(new BorderLayout());
        panel_Table.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 10, 10, 10),
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY),
                        "Danh sách các môn được phân công", TitledBorder.LEADING, TitledBorder.TOP)));

        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"STT", "ID", "Tên Môn", "Số Tín Chỉ", "Khoa", ""}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ngăn chặn việc chỉnh sửa ô
            }
        };
        JTable table = new JTable();
        table = new JTable(model);
        int stt = 1;
        for (CourseInstructorDTO dto : listCourseDTOOfPersonId) {
            Object[] rowData = new String[6]; // 5 là số cột của bảng
            rowData[0] = String.valueOf(stt++);
            rowData[1] = String.valueOf(dto.getCourseID());
            for (CourseDTO courseDTO : listCourseDTO) {
                if (courseDTO.getCourseID() == dto.getCourseID()) {
                    rowData[2] = courseDTO.getTitle();
                    rowData[3] = String.valueOf(courseDTO.getCredits());
                }
            }
            rowData[4] = "";
//            rowData[5] = "/assets/icons8-search-24.png";
            model.addRow(rowData);
        }
        table.setModel(model);
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

        JPanel panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelRight.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        btnSave = new JButton("Lưu");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Nút Lưu được nhấn");
            }
        });
        btnAddMon = new JButton("thêm");
        btnAddMon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panelBelow.setVisible(true);
            }
        });

        panelRight.add(btnAddMon);
        panelRight.add(btnSave);
        panelCenter.add(panelRight, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(1200, 150));
        panelCenter.add(panel, BorderLayout.SOUTH);
    }

    private void initPanelBelow() {
        panelBelow = new JPanel();
        panelBelow.setLayout(new BorderLayout());
        panelBelow.setBackground(Color.GRAY);
        panelBelow.setPreferredSize(new Dimension(1200, 250));
        panel_Table1 = new JPanel();
        panel_Table1.setLayout(new BorderLayout());
        panel_Table1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 10, 10, 10),
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY),
                        "Danh sách các môn", TitledBorder.LEADING, TitledBorder.TOP)));

        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"STT", "ID", "Tên Môn", "Số Tín Chỉ", "Khoa", ""}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ngăn chặn việc chỉnh sửa ô
            }
        };

        JTable table1 = new JTable();
        table1 = new JTable(model);
        int stt = 1;
        for (CourseDTO dto : listCourseDTO) {
            Object[] rowData = new String[6]; // 5 là số cột của bảng
            rowData[0] = String.valueOf(stt++);
            rowData[1] = String.valueOf(dto.getCourseID());
            rowData[2] = dto.getTitle();
            rowData[3] = String.valueOf(dto.getCredits());
            rowData[4] = "";
            rowData[5] = "/assets/icons8-add-48.png";
            model.addRow(rowData);
        }
        table1.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table1);
        panel_Table1.add(scrollPane, BorderLayout.CENTER);
        panelBelow.add(panel_Table1, BorderLayout.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table1.getColumnCount(); i++) {
            if (i != 2) {
                table1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }
        table1.getColumnModel().getColumn(5).setCellRenderer(new ImageRender());

        JPanel panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // code thanh searh va button vao day
        panelRight.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        searchValue = new JTextField();
        searchValue.setPreferredSize(new Dimension(200, 30));
        searchValue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnSearch = new JButton("Lọc");
        panelRight.add(searchValue);
        panelRight.add(btnSearch);
        panelBelow.add(panelRight, BorderLayout.NORTH);
        JPanel panelRight1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelRight1.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        JButton btnClose = new JButton("Đóng");
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBelow.setVisible(false);
                panel.setVisible(true);
            }
        });
        panelRight1.add(btnClose);
        panelBelow.add(panelRight1, BorderLayout.SOUTH);
    }

    public class ImageRender extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            JLabel label = new JLabel();

            if (value instanceof String && (((String) value).endsWith(".png") || ((String) value).endsWith(".jpg"))) {
                System.out.println("hi");
                // Tạo hình ảnh từ chuỗi string
                ImageIcon originalIcon = new ImageIcon((String) value);

                // Thay đổi kích thước của Image thành 50x50 pixels
                Image originalImage = originalIcon.getImage();
                Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

                // Tạo ImageIcon mới với kích thước 50x50
                ImageIcon resizedIcon = new ImageIcon(resizedImage);

                // Đặt alignment để căn giữa biểu tượng trong Jlabel
                label.setIcon(resizedIcon);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);

                // Loại bỏ văn bản
            } else {
                System.out.println("không có");
                // Nếu không phải biểu tượng thì sử dụng giá trị mặc định
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }

            return label;
        }
    }

    private JPanel panelTop;
    private JPanel panelCenter;
    private JPanel panelBelow;
    private JPanel panel_Table;
    private JPanel panel_Table1;
    private JButton btnAddMon; // button để chọn thêm môn cho giảng viên đó
    private JButton btnSave;
    private JTextField searchValue;
    private JButton btnSearch;
    private JPanel panel;
}
