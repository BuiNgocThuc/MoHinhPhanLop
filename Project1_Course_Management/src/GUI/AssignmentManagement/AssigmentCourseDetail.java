package GUI.AssignmentManagement;

import BLL.CourseBLL;
import BLL.CourseInstructorBLL;
import BLL.DepartmentBLL;
import BLL.PersonBLL;
import BLL.Entity.CourseEntity;
import BLL.Entity.CourseInstructorEntity;
import BLL.Entity.DepartmentEntity;
import BLL.Entity.PersonEntity;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class AssigmentCourseDetail extends JFrame {

    private int id_Course;
    private PersonBLL personBLL = new PersonBLL();
    private CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();
    private List<PersonEntity> listPersonDTO = personBLL.getListInstructor();
    private List<CourseInstructorEntity> listCourseInstructor;

    public AssigmentCourseDetail(int id_Course) throws SQLException {
        this.id_Course = id_Course;
        listCourseInstructor = courseInstructorBLL.getListCourseInstructorsByCourseID(id_Course);
        initComponents();
        setPreferredSize(new Dimension(1200, 800));
        setBackground(Color.WHITE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        initPanelTop();
        add(panelTop, BorderLayout.NORTH);
        initPanelCenter();
        add(panelCenter, BorderLayout.CENTER);
        initPanelBelow();
        add(panelBelow, BorderLayout.SOUTH);
        panelBelow.setVisible(false);
    }

    private void initPanelTop() {
        panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(1200, 80));
        panelTop.setLayout(new BorderLayout());
        panelTop.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel titleLabel = new JLabel("Course Detail");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        panelTop.add(titleLabel, BorderLayout.WEST);

        JPanel panelInfor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel jLabelId = new JLabel("ID");
        JLabel jLabelFn = new JLabel("Tilte");
        jLabelFn.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        JLabel jLabelLn = new JLabel("Credits");
        jLabelLn.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        JLabel jLabelHd = new JLabel("Department");
        jLabelHd.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        jLabelId.setFont(labelFont);
        jLabelFn.setFont(labelFont);
        jLabelLn.setFont(labelFont);
        jLabelHd.setFont(labelFont);

        JLabel valueId = new JLabel(String.valueOf(id_Course));
        JLabel valueTilte = new JLabel();
        JLabel valueCredits = new JLabel();
        JLabel valueDepart = new JLabel();

        CourseBLL courseBLL = new CourseBLL();
        CourseEntity courseDTO = courseBLL.courseDetail(id_Course);
        valueTilte.setText(courseDTO.getTitle());
        valueCredits.setText(String.valueOf(courseDTO.getCredits()));
        DepartmentBLL departmentBLL = new DepartmentBLL();
        DepartmentEntity departmentDTO = departmentBLL.selectByID(courseDTO.getDepartmentID());
        valueDepart.setText(departmentDTO.getName());

        Font valueFont = new Font("Arial", Font.PLAIN, 18);
        valueId.setFont(valueFont);
        valueTilte.setFont(valueFont);
        valueCredits.setFont(valueFont);
        valueDepart.setFont(valueFont);

        panelInfor.add(jLabelId);
        panelInfor.add(valueId);
        panelInfor.add(jLabelFn);
        panelInfor.add(valueTilte);
        panelInfor.add(jLabelLn);
        panelInfor.add(valueCredits);
        panelInfor.add(jLabelHd);
        panelInfor.add(valueDepart);

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
                        "Instructor Choosen List", TitledBorder.LEADING, TitledBorder.TOP)));
        modeltable = new DefaultTableModel(
                new Object[][]{},
                new String[]{"STT", "ID", "First Name", "Last Name", "HireDate", ""}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ngăn chặn việc chỉnh sửa ô
            }
        };
        table = new JTable();
        table = new JTable(modeltable);
        int stt = 1;
        for (CourseInstructorEntity dto : listCourseInstructor) {
            Object[] rowData = new String[6]; // 5 là số cột của bảng
            rowData[0] = String.valueOf(stt++);
            rowData[1] = String.valueOf(dto.getPersonID());
            for (PersonEntity personDTO : listPersonDTO) {
                if (personDTO.getPersonID() == dto.getPersonID()) {
                    rowData[2] = personDTO.getFirstName();
                    rowData[3] = personDTO.getLastName();
                    rowData[4] = String.valueOf(personDTO.getHireDate());
                    rowData[5] = "/assets/icons8-trash-35.png";
                    break;
                }
            }
            modeltable.addRow(rowData);
        }

        table.setRowHeight(35);
        table.setModel(modeltable);
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
        table.getColumnModel().getColumn(5).setCellRenderer(new ImageRender());
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                int row = target.rowAtPoint(e.getPoint());
                int column = target.columnAtPoint(e.getPoint());

                if (row >= 0 && row < target.getRowCount() && column == 5) {
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
                if (column == 5) {
                    int row = target.rowAtPoint(e.getPoint());
                    removeRowFromTable(modeltable, row);

                }
            }
        });

        JPanel panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelRight.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        btnSave = new JButton("Lưu");
        btnSave.addActionListener((ActionEvent e) -> {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to save the change?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                CourseEntity course = new CourseEntity();
                List<PersonEntity> instructors = new ArrayList<>();
                for (int i = 0; i < table.getRowCount(); i++) {
                    int personID = Integer.parseInt(table.getValueAt(i, 1).toString());
                    PersonEntity personDTO = new PersonEntity();
                    personDTO.setPersonID(personID);
                    instructors.add(personDTO);
                }
                course.setCourseID(id_Course);
                course.setInstructors(instructors);
                try {
                    courseInstructorBLL.updateCourseInstructors(course);
                } catch (SQLException ex) {
                    Logger.getLogger(AssigmentDetailGV.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "Save changes success", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnAddMon = new JButton("Add");
        btnAddMon.addActionListener((ActionEvent e) -> {
            panel.setVisible(false);
            panelBelow.setVisible(true);
        });

        btnCloseFrame = new JButton("Close");
        btnCloseFrame.addActionListener((e) -> {
            this.dispose();
        });

        panelRight.add(btnAddMon);
        panelRight.add(btnSave);
        panelRight.add(btnCloseFrame);
        panelCenter.add(panelRight, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setPreferredSize(
                new Dimension(1200, 450));
        panelCenter.add(panel, BorderLayout.SOUTH);
    }

    private void initPanelBelow() {
        panelBelow = new JPanel();
        panelBelow.setLayout(new BorderLayout());
        panelBelow.setBackground(Color.GRAY);
        panelBelow.setPreferredSize(new Dimension(1200, 450));
        panel_Table1 = new JPanel();
        panel_Table1.setLayout(new BorderLayout());
        panel_Table1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 10, 10, 10),
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY),
                        "Instructor List", TitledBorder.LEADING, TitledBorder.TOP)));

        modeltable1 = new DefaultTableModel(
                new Object[][]{},
                new String[]{"No", "ID", "First Name", "Last Name", "HireDate", ""}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ngăn chặn việc chỉnh sửa ô
            }
        };

        JTable table1 = new JTable();
        table1 = new JTable(modeltable1);
        int stt = 1;
        for (PersonEntity dto : listPersonDTO) {
            Object[] rowData = new String[6]; // 5 là số cột của bảng
            rowData[0] = String.valueOf(stt++);
            rowData[1] = String.valueOf(dto.getPersonID());
            rowData[2] = dto.getFirstName();
            rowData[3] = dto.getLastName();
            rowData[4] = String.valueOf(dto.getHireDate());;
            rowData[5] = "/assets/icons8-add-48.png";
            modeltable1.addRow(rowData);
        }
        table1.setRowHeight(35);
        table1.setModel(modeltable1);
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

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                int row = target.rowAtPoint(e.getPoint());
                int column = target.columnAtPoint(e.getPoint());

                if (row >= 0 && row < target.getRowCount() && column == 5) {
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
                if (column == 5) {
                    int row = target.rowAtPoint(e.getPoint());
                    Object value = target.getValueAt(row, 1);
                    addRowToTable(modeltable, Integer.parseInt(value.toString()), listPersonDTO);
                }
            }
        });
        JPanel panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
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
        JButton btnClose = new JButton("Close");
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

    public void addRowToTable(DefaultTableModel model, int personID, List<PersonEntity> listPersonDTO) {
        // Kiểm tra xem courseID đã tồn tại trong cột row1 chưa
        for (int i = 0; i < model.getRowCount(); i++) {
            int existingCourseID = Integer.parseInt((String) model.getValueAt(i, 1));
            if (existingCourseID == personID) {
                JOptionPane.showMessageDialog(null, "Instructor added successfully!", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        Object[] rowData = new Object[6];
        rowData[0] = String.valueOf(model.getRowCount() + 1);
        rowData[1] = String.valueOf(personID);
        for (PersonEntity personDTO : listPersonDTO) {
            if (personDTO.getPersonID() == personID) {
                rowData[2] = personDTO.getFirstName();
                rowData[3] = personDTO.getLastName();
                rowData[4] = personDTO.getHireDate();
                rowData[5] = "/assets/icons8-trash-35.png";
                break;
            }
        }
        model.addRow(rowData);
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
            JLabel label = new JLabel();
            if (value instanceof String && (((String) value).endsWith(".png") || ((String) value).endsWith(".jpg"))) {
                ImageIcon originalIcon = new ImageIcon(getClass().getResource((String) value));
                Image originalImage = originalIcon.getImage();
                Image resizedImage = originalImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);
                label.setIcon(resizedIcon);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
            } else {
                label.setText("Add  ");
                System.out.println("không có");
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
    private JButton btnAddMon;
    private JButton btnSave;
    private JButton btnCloseFrame;
    private JTextField searchValue;
    private JButton btnSearch;
    private JPanel panel;
    private JTable table;
    private DefaultTableModel modeltable;
    private DefaultTableModel modeltable1;
}
