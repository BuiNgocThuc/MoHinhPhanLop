/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.MainPanel;

import BLL.CourseInstructorBLL;
import DTO.CourseDTO;
import DTO.PersonDTO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class PnTableCourse extends javax.swing.JPanel {

    /**
     * Creates new form pnTableCourse
     */
    private final CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();

    public PnTableCourse() throws SQLException {
        initComponents();
        List<CourseDTO> courses = courseInstructorBLL.getListCourseAssignInstructor();
        loadData(courses);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spCourse = new javax.swing.JScrollPane();
        tblCourse = new javax.swing.JTable();

        tblCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Tên khóa học", "Giảng viên dạy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spCourse.setViewportView(tblCourse);
        if (tblCourse.getColumnModel().getColumnCount() > 0) {
            tblCourse.getColumnModel().getColumn(0).setMinWidth(50);
            tblCourse.getColumnModel().getColumn(0).setMaxWidth(50);
            tblCourse.getColumnModel().getColumn(1).setMinWidth(50);
            tblCourse.getColumnModel().getColumn(1).setMaxWidth(50);
            tblCourse.getColumnModel().getColumn(2).setMinWidth(200);
            tblCourse.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(spCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane spCourse;
    private javax.swing.JTable tblCourse;
    // End of variables declaration//GEN-END:variables

    public void loadData(List<CourseDTO> courses) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblCourse.getModel();
        model.setRowCount(0);
        int no = 1;
        for (CourseDTO course : courses) {
            int courseID = course.getCourseID();
            String title = course.getTitle();
            String instructorInfos = "-------";

            List<PersonDTO> instructors = course.getInstructors();
            if (instructors != null) {
                instructorInfos = "";
                for (int i = 0; i < instructors.size() - 1; i++) {
                    instructorInfos += String.format("%d-%s %s, ",
                            instructors.get(i).getPersonID(),
                            instructors.get(i).getLastName(),
                            instructors.get(i).getFirstName());
                }
                instructorInfos += String.format("%d-%s %s",
                        instructors.get(instructors.size() - 1).getPersonID(),
                        instructors.get(instructors.size() - 1).getLastName(),
                        instructors.get(instructors.size() - 1).getFirstName());
            }
            Object[] row
                    = {
                        no++, courseID, title, instructorInfos
                    };
            model.addRow(row);
        }
    }

    public void deleteAllInstructorAssignCourse() throws SQLException {
        int seletedRow = tblCourse.getSelectedRow();
        if (seletedRow != -1) {
            int courseID = (int) tblCourse.getValueAt(seletedRow, 1);
            courseInstructorBLL.deleteAllInstructorAssignCourse(courseID);
        }
    }

    public void findCourses(String text) throws SQLException {
        System.out.println(text + "]");
        List<CourseDTO> courses = courseInstructorBLL.findCourses(text);
        if (courses.size() == 0) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy");
        } else {
            loadData(courses);
        }
    }
}
