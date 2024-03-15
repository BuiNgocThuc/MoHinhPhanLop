/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.AssignmentManagement;

import GUI.AssignmentManagement.AssigmentDetailGV;
import BLL.CourseInstructorBLL;
import BLL.Entity.CourseEntity;
import BLL.Entity.PersonEntity;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import util.Paginate;

public class TableInstructorPanel extends javax.swing.JPanel {

    /**
     * Creates new form pnTableInstructor
     */
    JPanel cardPanel = null;
    private final CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();

    private Paginate<PersonEntity> instructorsPaginate;

    private int itemPerPage = 25;
    private String query = "";
    private int currentPage = 1;

    public TableInstructorPanel() throws SQLException {
        initComponents();

        updateData();
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
        nextPageButton = new javax.swing.JButton();
        detailPageLabel = new javax.swing.JLabel();
        previousPageButton = new javax.swing.JButton();
        titlePaginationLabel = new javax.swing.JLabel();
        detailItemPerPageLabel = new javax.swing.JLabel();
        itemPerPageSpinner = new javax.swing.JSpinner();
        currentPageSpinner = new javax.swing.JSpinner();

        tblInstructor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ID", "First Name", "Last Name", "Course"
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

        nextPageButton.setText(">>");
        nextPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPageButtonActionPerformed(evt);
            }
        });

        detailPageLabel.setText("of 30");

        previousPageButton.setText("<<");
        previousPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousPageButtonActionPerformed(evt);
            }
        });

        titlePaginationLabel.setText("Items per page");

        detailItemPerPageLabel.setText("1-25 of 300 items");

        itemPerPageSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                itemPerPageSpinnerStateChanged(evt);
            }
        });

        currentPageSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                currentPageSpinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePaginationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemPerPageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailItemPerPageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(previousPageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentPageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailPageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextPageButton)
                .addContainerGap())
            .addComponent(spInstructor, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spInstructor, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextPageButton)
                    .addComponent(detailPageLabel)
                    .addComponent(previousPageButton)
                    .addComponent(detailItemPerPageLabel)
                    .addComponent(titlePaginationLabel)
                    .addComponent(itemPerPageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentPageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblInstructorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInstructorMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblInstructor.getSelectedRow();
            int instructorID = (int) tblInstructor.getValueAt(row, 1);
            System.out.println(instructorID);
            try {
                JFrame assigmentDetailGV = new AssigmentDetailGV(instructorID);
                assigmentDetailGV.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        updateData();
                    }
                });
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi hệ thống");
            }
        }
    }//GEN-LAST:event_tblInstructorMouseClicked

    private void previousPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousPageButtonActionPerformed
        currentPage = 0;

        currentPageSpinner.setValue(currentPage);
        updateData();
    }//GEN-LAST:event_previousPageButtonActionPerformed

    private void itemPerPageSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_itemPerPageSpinnerStateChanged
        itemPerPage = Integer.valueOf(itemPerPageSpinner.getValue().toString());

        updateData();
    }//GEN-LAST:event_itemPerPageSpinnerStateChanged

    private void currentPageSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_currentPageSpinnerStateChanged
        currentPage = Integer.valueOf(currentPageSpinner.getValue().toString());

        updateData();
    }//GEN-LAST:event_currentPageSpinnerStateChanged

    private void nextPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPageButtonActionPerformed
        currentPage = instructorsPaginate.getTotalPages();
        currentPageSpinner.setValue(currentPage);
        updateData();
    }//GEN-LAST:event_nextPageButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner currentPageSpinner;
    private javax.swing.JLabel detailItemPerPageLabel;
    private javax.swing.JLabel detailPageLabel;
    private javax.swing.JSpinner itemPerPageSpinner;
    private javax.swing.JButton nextPageButton;
    private javax.swing.JButton previousPageButton;
    private javax.swing.JScrollPane spInstructor;
    private javax.swing.JTable tblInstructor;
    private javax.swing.JLabel titlePaginationLabel;
    // End of variables declaration//GEN-END:variables

    public void deleteAllCourseAssignInstructor() throws SQLException {
        int seletedRow = tblInstructor.getSelectedRow();
        if (seletedRow != -1) {
            int instructorId = (int) tblInstructor.getValueAt(seletedRow, 1);
            courseInstructorBLL.deleteAllCourseAssignInstructor(instructorId);
        }
    }

    public void findInstructors(String text) throws SQLException {
        List<PersonEntity> instructors = courseInstructorBLL.findInstructors(text);
        if (instructors.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy");
        } else {
            instructorsPaginate = new Paginate<>(25, instructors.size(), 1, 0, instructors);
            populateUI();
        }
    }

    public JTable getTblInstructor() {
        return tblInstructor;
    }

    public void updateData() {
        try {
            if (instructorsPaginate == null) {
                instructorsPaginate = new Paginate<>(20, 0, 1, 0, null);
            }
            int limit = itemPerPage;
            int offset = itemPerPage * (currentPage - 1);
            System.out.println(limit);
            System.out.println(offset);
            instructorsPaginate = courseInstructorBLL.getListInstructorAssignedCourse(offset, limit, query);
            System.out.println(instructorsPaginate);
            populateUI();
        } catch (SQLException ex) {
            Logger.getLogger(TableInstructorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void populateUI() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblInstructor.getModel();
        model.setRowCount(0);
        int no = 1;
        for (PersonEntity instructor : instructorsPaginate.getItems()) {
            int instructorID = instructor.getPersonID();
            String firstName = instructor.getFirstName();
            String lastName = instructor.getLastName();
            String courseInfos = "-------";
            List<CourseEntity> courses = instructor.getCourses();
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
        int totalItems = instructorsPaginate.getTotalItems();
        int totalPages = 1;
        if (instructorsPaginate.getTotalPages() > 0) {
            totalPages = instructorsPaginate.getTotalPages();
        }

        SpinnerNumberModel itemPerPageModel = new SpinnerNumberModel(itemPerPage, 1, 25, 1);
        itemPerPageSpinner.setModel(itemPerPageModel);
        detailItemPerPageLabel.setText("1-25 of " + totalItems + " items");
        detailPageLabel.setText("of " + totalPages);
        SpinnerNumberModel currentPageModel = new SpinnerNumberModel(currentPage, 1, totalPages, 1);
        currentPageSpinner.setModel(currentPageModel);
    }
}
