/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.AssignmentManagement;

import BLL.CourseInstructorBLL;
import DTO.CourseDTO;
import DTO.CourseInstructorDTO;
import DTO.PersonDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Bao
 */
public class AssignmentAdd extends javax.swing.JFrame {

    /**
     * Creates new form AssignmentList
     */
    private PnInstructor pnInstructor;
    private PnCourse pnCourse;
    private CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();
    private final List<CourseInstructorDTO> courseInstructorList;

    public AssignmentAdd() throws SQLException {
        initComponents();
        this.courseInstructorList = courseInstructorBLL.getAllCourseInstructors();
        pnInstructor = new PnInstructor();
        pnCourse = new PnCourse();
        pnContainerChange.add(pnInstructor);
        pnContainerChange.validate();
        pnContainerChange.repaint();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContainer = new javax.swing.JPanel();
        pnContainerChange = new javax.swing.JPanel();
        cbView = new javax.swing.JComboBox<>();
        btInstructorAdd = new javax.swing.JButton();
        pnContainerCloseSave = new javax.swing.JPanel();
        btClose = new javax.swing.JButton();
        btSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnContainerChange.setLayout(new java.awt.CardLayout());

        cbView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo giảng viên", "Theo khóa học" }));
        cbView.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbViewItemStateChanged(evt);
            }
        });
        cbView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbViewActionPerformed(evt);
            }
        });

        btInstructorAdd.setText("Thêm");
        btInstructorAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInstructorAddActionPerformed(evt);
            }
        });

        btClose.setText("Đóng");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });
        pnContainerCloseSave.add(btClose);

        btSave.setText("Lưu");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        pnContainerCloseSave.add(btSave);

        javax.swing.GroupLayout pnContainerLayout = new javax.swing.GroupLayout(pnContainer);
        pnContainer.setLayout(pnContainerLayout);
        pnContainerLayout.setHorizontalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnContainerLayout.createSequentialGroup()
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnContainerLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnContainerCloseSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnContainerLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnContainerLayout.createSequentialGroup()
                                .addComponent(cbView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btInstructorAdd))
                            .addComponent(pnContainerChange, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE))))
                .addGap(62, 62, 62))
        );
        pnContainerLayout.setVerticalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btInstructorAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnContainerChange, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(pnContainerCloseSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbViewItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbViewItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            switch (cbView.getSelectedItem().toString()) {
                case "Theo khóa học" -> {
                    pnContainerChange.removeAll();
                    pnContainerChange.add(pnCourse);
                    pnContainerChange.revalidate();
                    pnContainerChange.repaint();
                }
                case "Theo giảng viên" -> {
                    pnContainerChange.removeAll();
                    pnContainerChange.add(pnInstructor);
                    pnContainerChange.revalidate();
                    pnContainerChange.repaint();
                }
                default ->
                    throw new AssertionError();
            }
        }
    }//GEN-LAST:event_cbViewItemStateChanged

    private void cbViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbViewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed

        if (cbView.getSelectedItem().toString().equals("Theo giảng viên")) {
            List<CourseDTO> selectedCourses = (List<CourseDTO>) pnInstructor.getSelectedCourses();
            Integer idInstructor = pnInstructor.getFirstColumnDataOfSelectedRow();
            if (idInstructor != null) {
                if (!selectedCourses.isEmpty()) {
                    boolean checkCourseInstructorExist = false;
                    for (CourseInstructorDTO courseInstructorDTO : courseInstructorList) {
                        for (CourseDTO courseDTO : selectedCourses) {
                            if (courseDTO.getCourseID() == courseInstructorDTO.getCourseID() && idInstructor == courseInstructorDTO.getPersonID()) {
                                checkCourseInstructorExist = true;
                                JOptionPane.showMessageDialog(null, "Khóa học " + courseDTO.getTitle() + " đã được phân công!");
                                break;
                            }
                        }
                    }
                    if (!checkCourseInstructorExist) {
                        int confirmationResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm giảng viên được phân công với các khóa học này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                        if (confirmationResult == JOptionPane.YES_OPTION) {
                            for (CourseDTO courseDTO : selectedCourses) {
                                CourseInstructorDTO courseInstructorDTO = new CourseInstructorDTO(courseDTO.getCourseID(), idInstructor);
                                try {
                                    courseInstructorBLL.insertCourseInstructor(courseInstructorDTO);
                                } catch (SQLException ex) {
                                    Logger.getLogger(AssignmentAdd.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Phân công các khóa học cho giảng viên thành công");
                            pnInstructor.resetSelectedCourseListTable();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa có môn học nào được chọn!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn giảng viên nào!");
            }
        } else {
            List<PersonDTO> selectedInstructors = (List<PersonDTO>) pnCourse.getSelectedCourses();
            Integer idCourse = pnCourse.getFirstColumnDataOfSelectedRow();
            if (idCourse != null) {
                if (!selectedInstructors.isEmpty()) {
                    boolean checkCourseInstructorExist = false;
                    for (CourseInstructorDTO courseInstructorDTO : courseInstructorList) {
                        for (PersonDTO personDTO : selectedInstructors) {
                            if (personDTO.getPersonID() == courseInstructorDTO.getPersonID() && idCourse == courseInstructorDTO.getCourseID()) {
                                checkCourseInstructorExist = true;
                                JOptionPane.showMessageDialog(null, "Giảng viên " + personDTO.getFirstName() + " đã được phân công!");
                                break;
                            }
                        }
                    }
                    if (!checkCourseInstructorExist) {
                        int confirmationResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm giảng viên được phân công với các khóa học này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                        if (confirmationResult == JOptionPane.YES_OPTION) {
                            for (PersonDTO personDTO : selectedInstructors) {
                                CourseInstructorDTO courseInstructorDTO = new CourseInstructorDTO(idCourse, personDTO.getPersonID());
                                try {
                                    courseInstructorBLL.insertCourseInstructor(courseInstructorDTO);
                                } catch (SQLException ex) {
                                    Logger.getLogger(AssignmentAdd.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Phân công các giảng viên cho khóa học thành công");
                            pnCourse.resetSelectedCourseListTable();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa có giảng viên nào được chọn!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn môn học nào!");
            }
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btCloseActionPerformed

    private void btInstructorAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInstructorAddActionPerformed
        InstructorAdd instructorAdd = new InstructorAdd();
        instructorAdd.setVisible(true);
        instructorAdd.setLocationRelativeTo(this);
    }//GEN-LAST:event_btInstructorAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.err.println("Failed to initialize LaF");
            }
            try {
                AssignmentAdd assignmentAdd = new AssignmentAdd();
                assignmentAdd.setVisible(true);
                assignmentAdd.setLocationRelativeTo(null);
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btInstructorAdd;
    private javax.swing.JButton btSave;
    private javax.swing.JComboBox<String> cbView;
    private javax.swing.JPanel pnContainer;
    private javax.swing.JPanel pnContainerChange;
    private javax.swing.JPanel pnContainerCloseSave;
    // End of variables declaration//GEN-END:variables
}
