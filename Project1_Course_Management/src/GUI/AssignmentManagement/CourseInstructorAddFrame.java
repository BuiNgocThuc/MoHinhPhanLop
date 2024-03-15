/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.AssignmentManagement;

import BLL.CourseBLL;
import BLL.CourseInstructorBLL;
import BLL.PersonBLL;
import BLL.Entity.CourseEntity;
import BLL.Entity.CourseInstructorEntity;
import BLL.Entity.PersonEntity;
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
public class CourseInstructorAddFrame extends javax.swing.JFrame {

    /**
     * Creates new form AssignmentList
     */
    private PnInstructor pnInstructor;
    private PnCourse pnCourse;
    private CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();
    private CourseBLL courseBLL = new CourseBLL();
    private PersonBLL personBLL = new PersonBLL();
    private final List<CourseInstructorEntity> courseInstructorList;

    public CourseInstructorAddFrame() throws SQLException {
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContainer = new javax.swing.JPanel();
        pnContainerChange = new javax.swing.JPanel();
        pnContainerCloseSave = new javax.swing.JPanel();
        btClose = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbView = new javax.swing.JComboBox<>();
        btInstructorAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnContainer.setBackground(new java.awt.Color(255, 255, 255));

        pnContainerChange.setBackground(new java.awt.Color(255, 255, 255));
        pnContainerChange.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        pnContainerChange.setLayout(new java.awt.CardLayout(5, 5));

        pnContainerCloseSave.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT);
        flowLayout1.setAlignOnBaseline(true);
        pnContainerCloseSave.setLayout(flowLayout1);

        btClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btClose.setText("Close");
        btClose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btClose.setPreferredSize(new java.awt.Dimension(100, 40));
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });
        pnContainerCloseSave.add(btClose);

        btSave.setBackground(new java.awt.Color(56, 122, 223));
        btSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSave.setForeground(new java.awt.Color(255, 255, 255));
        btSave.setText("Save");
        btSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 196, 237)));
        btSave.setPreferredSize(new java.awt.Dimension(100, 40));
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        pnContainerCloseSave.add(btSave);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout2.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout2);

        cbView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "By instructor", "By course" }));
        cbView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        cbView.setPreferredSize(new java.awt.Dimension(200, 40));
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
        jPanel1.add(cbView);

        btInstructorAdd.setBackground(new java.awt.Color(155, 207, 83));
        btInstructorAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btInstructorAdd.setForeground(new java.awt.Color(255, 255, 255));
        btInstructorAdd.setText("Add");
        btInstructorAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(191, 234, 124)));
        btInstructorAdd.setPreferredSize(new java.awt.Dimension(100, 40));
        btInstructorAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInstructorAddActionPerformed(evt);
            }
        });
        jPanel1.add(btInstructorAdd);

        javax.swing.GroupLayout pnContainerLayout = new javax.swing.GroupLayout(pnContainer);
        pnContainer.setLayout(pnContainerLayout);
        pnContainerLayout.setHorizontalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnContainerCloseSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .addComponent(pnContainerChange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnContainerLayout.setVerticalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnContainerChange, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnContainerCloseSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbViewItemStateChanged(java.awt.event.ItemEvent evt) {
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
    }

    private void cbViewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbViewActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbViewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {

        if (cbView.getSelectedItem().toString().equals("Theo giảng viên")) {
            List<CourseEntity> selectedCourses = (List<CourseEntity>) pnInstructor.getSelectedCourses();
            Integer idInstructor = pnInstructor.getFirstColumnDataOfSelectedRow();
            if (idInstructor != null) {
                if (!selectedCourses.isEmpty()) {
                    int idCourse = courseInstructorBLL.checkCourseExist(idInstructor, selectedCourses);
                    if (idCourse != 0) {
                        CourseEntity courseDTO = courseBLL.courseDetail(idCourse);
                        JOptionPane.showMessageDialog(null, "Khóa học " + courseDTO.getTitle() + " đã được phân công!");
                    } else {
                        int confirmationResult = JOptionPane.showConfirmDialog(null,
                                "Bạn có muốn thêm giảng viên được phân công với các khóa học này không?", "Xác nhận",
                                JOptionPane.YES_NO_OPTION);
                        if (confirmationResult == JOptionPane.YES_OPTION) {
                            for (CourseEntity courseDTO : selectedCourses) {
                                CourseInstructorEntity courseInstructorDTO = new CourseInstructorEntity(
                                        courseDTO.getCourseID(), idInstructor);
                                try {
                                    courseInstructorBLL.insertCourseInstructor(courseInstructorDTO);
                                } catch (SQLException ex) {
                                    Logger.getLogger(CourseInstructorAddFrame.class.getName()).log(Level.SEVERE, null,
                                            ex);
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
            List<PersonEntity> selectedInstructors = (List<PersonEntity>) pnCourse.getSelectedCourses();
            Integer idCourse = pnCourse.getFirstColumnDataOfSelectedRow();
            if (idCourse != null) {
                if (!selectedInstructors.isEmpty()) {
                    int idInstructor = courseInstructorBLL.checkInstructorExist(idCourse, selectedInstructors);
                    if (idInstructor != 0) {
                        PersonEntity personDTO = personBLL.detailsPerson(idInstructor);
                        JOptionPane.showMessageDialog(null,
                                "Giảng viên " + personDTO.getFirstName() + " đã được phân công!");
                    } else {
                        int confirmationResult = JOptionPane.showConfirmDialog(null,
                                "Bạn có muốn thêm giảng viên được phân công với các khóa học này không?", "Xác nhận",
                                JOptionPane.YES_NO_OPTION);
                        if (confirmationResult == JOptionPane.YES_OPTION) {
                            for (PersonEntity personDTO : selectedInstructors) {
                                CourseInstructorEntity courseInstructorDTO = new CourseInstructorEntity(idCourse,
                                        personDTO.getPersonID());
                                try {
                                    courseInstructorBLL.insertCourseInstructor(courseInstructorDTO);
                                } catch (SQLException ex) {
                                    Logger.getLogger(CourseInstructorAddFrame.class.getName()).log(Level.SEVERE, null,
                                            ex);
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
    }// GEN-LAST:event_btSaveActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btCloseActionPerformed
        dispose();
    }// GEN-LAST:event_btCloseActionPerformed

    private void btInstructorAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btInstructorAddActionPerformed
        InstructorAdd instructorAdd = new InstructorAdd();
        instructorAdd.setVisible(true);
        instructorAdd.setLocationRelativeTo(this);
    }// GEN-LAST:event_btInstructorAddActionPerformed

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
                CourseInstructorAddFrame assignmentAdd = new CourseInstructorAddFrame();
                assignmentAdd.setVisible(true);
                assignmentAdd.setLocationRelativeTo(null);
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorAddFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btInstructorAdd;
    private javax.swing.JButton btSave;
    private javax.swing.JComboBox<String> cbView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnContainer;
    private javax.swing.JPanel pnContainerChange;
    private javax.swing.JPanel pnContainerCloseSave;
    // End of variables declaration//GEN-END:variables
}
