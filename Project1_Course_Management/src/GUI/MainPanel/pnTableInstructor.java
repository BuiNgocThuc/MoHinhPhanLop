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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class PnTableInstructor extends javax.swing.JPanel {

    /**
     * Creates new form pnTableInstructor
     */
    JPanel cardPanel = null;
    private final CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();

    public PnTableInstructor() throws SQLException {
        initComponents();
        List<PersonDTO> instructors = courseInstructorBLL.getListInstructorAssignCourse();

        loadData(instructors);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spInstructor = new javax.swing.JScrollPane();
        tblInstructor = new javax.swing.JTable();

        tblInstructor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Họ", "Tên", "Môn dạy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInstructor.setRowHeight(35);
        tblInstructor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInstructorMouseClicked(evt);
            }
        });
        spInstructor.setViewportView(tblInstructor);
        if (tblInstructor.getColumnModel().getColumnCount() > 0) {
            tblInstructor.getColumnModel().getColumn(0).setMinWidth(50);
            tblInstructor.getColumnModel().getColumn(0).setMaxWidth(50);
            tblInstructor.getColumnModel().getColumn(1).setMinWidth(50);
            tblInstructor.getColumnModel().getColumn(1).setMaxWidth(50);
            tblInstructor.getColumnModel().getColumn(2).setMinWidth(150);
            tblInstructor.getColumnModel().getColumn(2).setMaxWidth(150);
            tblInstructor.getColumnModel().getColumn(3).setMinWidth(150);
            tblInstructor.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(spInstructor, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(spInstructor, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblInstructorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInstructorMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblInstructor.getSelectedRow();
            int instructorID = (int) tblInstructor.getValueAt(row, 1);
            System.out.println(instructorID);
            try {
                new AssigmentDetailGV(instructorID);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi hệ thống");
            }
        }
    }//GEN-LAST:event_tblInstructorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane spInstructor;
    private javax.swing.JTable tblInstructor;
    // End of variables declaration//GEN-END:variables
    public void loadData(List<PersonDTO> instructors) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblInstructor.getModel();
        model.setRowCount(0);
        int no = 1;
        for (PersonDTO instructor : instructors) {
            int instructorID = instructor.getPersonID();
            String firstName = instructor.getFirstName();
            String lastName = instructor.getLastName();

            String courseInfos = "-------";
            List<CourseDTO> courses = instructor.getCourses();
            if (courses != null) {
                courseInfos = "";
                for (int i = 0; i < courses.size() - 1; i++) {
                    courseInfos += String.format("%d-%s, ",
                            courses.get(i).getCourseID(),
                            courses.get(i).getTitle());
                }
                courseInfos += String.format("%d-%s",
                        courses.get(courses.size() - 1).getCourseID(),
                        courses.get(courses.size() - 1).getTitle());
            }

            Object[] row
                    = {
                        no++, instructorID, lastName, firstName, courseInfos
                    };
            model.addRow(row);
        }
    }

    public void deleteAllCourseAssignInstructor() throws SQLException {
        int seletedRow = tblInstructor.getSelectedRow();
        if (seletedRow != -1) {
            int instructorId = (int) tblInstructor.getValueAt(seletedRow, 1);
            courseInstructorBLL.deleteAllCourseAssignInstructor(instructorId);
        }
    }

    public void findInstructors(String text) throws SQLException {
        List<PersonDTO> instructors = courseInstructorBLL.findInstructors(text);
        if (instructors.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy");
        } else {
            loadData(instructors);
        }
    }

    ;
    public JTable getTblInstructor() {
        return tblInstructor;
    }

}
