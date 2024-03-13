/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.AssignmentManagement;

import GUI.AssignmentManagement.TableInstructorPanel;
import GUI.AssignmentManagement.TableCoursePanel;
import BLL.CourseInstructorBLL;
import BLL.Entity.CourseEntity;
import BLL.Entity.PersonEntity;
import GUI.AssignmentManagement.CourseInstructorAddFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class CourseInstrutorPanel extends javax.swing.JPanel {

    /**
     * Creates new form CourseInstrutorPanel
     */
    private final CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();

    private TableCoursePanel pnTableCourse = null;
    private TableInstructorPanel pnTableInstructor = null;

    public CourseInstrutorPanel() throws SQLException {
        initComponents();
        pnTableCourse = new TableCoursePanel();
        pnTableInstructor = new TableInstructorPanel();
        pnTable.add(pnTableCourse);
        pnTable.validate();
        pnTable.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        cbPointOfView = new javax.swing.JComboBox<>();
        pnTable = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("COURSE ASSIGNMENT");
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 10, 0));
        jLabel1.setPreferredSize(new java.awt.Dimension(170, 42));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        jPanel5.setLayout(flowLayout1);

        btnAdd.setBackground(new java.awt.Color(155, 207, 83));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(191, 234, 124)));
        btnAdd.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel5.add(btnAdd);

        btnDelete.setBackground(new java.awt.Color(255, 104, 104));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 128, 128)));
        btnDelete.setPreferredSize(new java.awt.Dimension(100, 40));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel5.add(btnDelete);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(755, 40));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 0);
        flowLayout2.setAlignOnBaseline(true);
        jPanel6.setLayout(flowLayout2);

        tfSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tfSearch.setPreferredSize(new java.awt.Dimension(300, 40));
        tfSearch.setToolTipText("ID hoặc tên");
        jPanel6.add(tfSearch);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-search-24.png"))); // NOI18N
        btnSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSearch.setOpaque(true);
        btnSearch.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel6.add(btnSearch);

        jPanel5.add(jPanel6);

        cbPointOfView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "By course", "By instructor" }));
        cbPointOfView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        cbPointOfView.setPreferredSize(new java.awt.Dimension(205, 40));
        cbPointOfView.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPointOfViewItemStateChanged(evt);
            }
        });
        cbPointOfView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPointOfViewActionPerformed(evt);
            }
        });
        jPanel5.add(cbPointOfView);

        pnTable.setBackground(new java.awt.Color(102, 102, 102));
        pnTable.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
            .addComponent(pnTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTable, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbPointOfViewItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPointOfViewItemStateChanged
        if (evt.getStateChange() == 1) {
            switch (cbPointOfView.getSelectedIndex()) {
                case 0 -> {
                    pnTable.removeAll();
                    pnTable.add(pnTableCourse);
                    pnTable.validate();
                    pnTable.repaint();
                }
                case 1 -> {
                    pnTable.removeAll();
                    pnTable.add(pnTableInstructor);
                    pnTable.validate();
                    pnTable.repaint();
                }
                default ->
                    throw new AssertionError();
            }

        }

    }//GEN-LAST:event_cbPointOfViewItemStateChanged

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String deleteType = "";
            switch (cbPointOfView.getSelectedIndex()) {
                case 0 ->
                    deleteType = "các giảng viên đã được phân công của khóa học";
                case 1 ->
                    deleteType = "các môn học đã được phân công của giáo viên";
            }

            int confirmed = JOptionPane.showConfirmDialog(null, "Xác nhận hủy phân công " + deleteType,
                    "Xác nhận", JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                switch (cbPointOfView.getSelectedIndex()) {
                    case 0 ->
                        pnTableCourse.deleteAllInstructorAssignCourse();
                    case 1 ->
                        pnTableInstructor.deleteAllCourseAssignInstructor();
                }

                List<CourseEntity> courses = courseInstructorBLL.getListCourseAssignInstructor();
                pnTableCourse.populateUI();
                
                List<PersonEntity> instructors = courseInstructorBLL.getListInstructorAssignCourse();
                pnTableInstructor.populateUI();

                JOptionPane.showMessageDialog(null, "Đã hủy phân công " + deleteType + " thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi hệ thống");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String text = tfSearch.getText();

            switch (cbPointOfView.getSelectedIndex()) {
                case 0 -> {
                    pnTableCourse.findCourses(text);
                }
                case 1 -> {
                    pnTableInstructor.findInstructors(text);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi hệ thống");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        CourseInstructorAddFrame courseInstructorAddFrame = null;
        try {
            courseInstructorAddFrame = new CourseInstructorAddFrame();
            courseInstructorAddFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    try {
                        List<CourseEntity> courses = courseInstructorBLL.getListCourseAssignInstructor();
                        pnTableCourse.populateUI();
                        List<PersonEntity> instructors = courseInstructorBLL.getListInstructorAssignCourse();
                        pnTableInstructor.populateUI();
                    } catch (SQLException ex) {
                        Logger.getLogger(CourseInstrutorPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstrutorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        courseInstructorAddFrame.setVisible(true);
        courseInstructorAddFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbPointOfViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPointOfViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPointOfViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbPointOfView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnTable;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
