/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.AssignmentManagement;

import BLL.CourseBLL;
import BLL.PersonBLL;
import BLL.Entity.CourseEntity;
import BLL.Entity.PersonEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bao
 */
public class PnCourse extends javax.swing.JPanel {

    /**
     * Creates new form PnC
     */
    CourseBLL courseBLL = new CourseBLL();
    PersonBLL personBLL = new PersonBLL();

    public PnCourse() {
        initComponents();
        updateData();
    }

    private void updateData() {
        updateInstructorList();
        updateCourseList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnSelectedInstructorList = new javax.swing.JPanel();
        spSelectedCourseList = new javax.swing.JScrollPane();
        tableSelectedInstructorList = new javax.swing.JTable();
        btDeleteInstructor = new javax.swing.JButton();
        pnInstructorList = new javax.swing.JPanel();
        spCourseList = new javax.swing.JScrollPane();
        tableInstructorList = new javax.swing.JTable();
        btSelectedInstructor = new javax.swing.JButton();
        btSeeAllInstructorList = new javax.swing.JButton();
        pnCourseList = new javax.swing.JPanel();
        spInstructorList = new javax.swing.JScrollPane();
        tableCourseList = new javax.swing.JTable();
        tfCourseSearch = new javax.swing.JTextField();
        btCourseSearch = new javax.swing.JButton();
        tfInstructorSearch = new javax.swing.JTextField();
        btInstructorSearch = new javax.swing.JButton();
        btSeeAllCourseList = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 650));

        pnSelectedInstructorList.setBackground(new java.awt.Color(255, 255, 255));
        pnSelectedInstructorList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Instructor Choosen List", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        tableSelectedInstructorList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "InstructorID", "Instructor Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSelectedInstructorList.setToolTipText("");
        spSelectedCourseList.setViewportView(tableSelectedInstructorList);

        btDeleteInstructor.setText("Delete");
        btDeleteInstructor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        btDeleteInstructor.setPreferredSize(new java.awt.Dimension(72, 40));
        btDeleteInstructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteInstructorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnSelectedInstructorListLayout = new javax.swing.GroupLayout(pnSelectedInstructorList);
        pnSelectedInstructorList.setLayout(pnSelectedInstructorListLayout);
        pnSelectedInstructorListLayout.setHorizontalGroup(
            pnSelectedInstructorListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSelectedInstructorListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spSelectedCourseList, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDeleteInstructor, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnSelectedInstructorListLayout.setVerticalGroup(
            pnSelectedInstructorListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSelectedInstructorListLayout.createSequentialGroup()
                .addComponent(spSelectedCourseList, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addGap(7, 7, 7))
            .addGroup(pnSelectedInstructorListLayout.createSequentialGroup()
                .addComponent(btDeleteInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnInstructorList.setBackground(new java.awt.Color(255, 255, 255));
        pnInstructorList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Instructors List", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        pnInstructorList.setPreferredSize(new java.awt.Dimension(22, 310));

        tableInstructorList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "InstructorID", "Instructor Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spCourseList.setViewportView(tableInstructorList);

        btSelectedInstructor.setText("Add");
        btSelectedInstructor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        btSelectedInstructor.setPreferredSize(new java.awt.Dimension(72, 40));
        btSelectedInstructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelectedInstructorActionPerformed(evt);
            }
        });

        btSeeAllInstructorList.setText("All List");
        btSeeAllInstructorList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        btSeeAllInstructorList.setPreferredSize(new java.awt.Dimension(86, 40));
        btSeeAllInstructorList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeeAllInstructorListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnInstructorListLayout = new javax.swing.GroupLayout(pnInstructorList);
        pnInstructorList.setLayout(pnInstructorListLayout);
        pnInstructorListLayout.setHorizontalGroup(
            pnInstructorListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInstructorListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spCourseList, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(pnInstructorListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btSeeAllInstructorList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSelectedInstructor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnInstructorListLayout.setVerticalGroup(
            pnInstructorListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInstructorListLayout.createSequentialGroup()
                .addGroup(pnInstructorListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spCourseList, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addGroup(pnInstructorListLayout.createSequentialGroup()
                        .addComponent(btSeeAllInstructorList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSelectedInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnCourseList.setBackground(new java.awt.Color(255, 255, 255));
        pnCourseList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Course List", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        pnCourseList.setPreferredSize(new java.awt.Dimension(22, 100));

        tableCourseList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course ID", "Course Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spInstructorList.setViewportView(tableCourseList);

        javax.swing.GroupLayout pnCourseListLayout = new javax.swing.GroupLayout(pnCourseList);
        pnCourseList.setLayout(pnCourseListLayout);
        pnCourseListLayout.setHorizontalGroup(
            pnCourseListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCourseListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spInstructorList, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnCourseListLayout.setVerticalGroup(
            pnCourseListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCourseListLayout.createSequentialGroup()
                .addComponent(spInstructorList, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        tfCourseSearch.setPreferredSize(new java.awt.Dimension(64, 40));

        btCourseSearch.setText("Search");
        btCourseSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        btCourseSearch.setPreferredSize(new java.awt.Dimension(72, 40));
        btCourseSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCourseSearchActionPerformed(evt);
            }
        });

        tfInstructorSearch.setPreferredSize(new java.awt.Dimension(64, 40));

        btInstructorSearch.setText("Search");
        btInstructorSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        btInstructorSearch.setPreferredSize(new java.awt.Dimension(72, 40));
        btInstructorSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInstructorSearchActionPerformed(evt);
            }
        });

        btSeeAllCourseList.setText("All List");
        btSeeAllCourseList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        btSeeAllCourseList.setPreferredSize(new java.awt.Dimension(86, 40));
        btSeeAllCourseList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeeAllCourseListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfCourseSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCourseSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSeeAllCourseList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnCourseList, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfInstructorSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btInstructorSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnInstructorList, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)))
                    .addComponent(pnSelectedInstructorList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCourseSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btCourseSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btSeeAllCourseList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfInstructorSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btInstructorSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCourseList, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(pnInstructorList, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnSelectedInstructorList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCourseSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCourseSearchActionPerformed
        String idText = tfCourseSearch.getText().trim();

        if (!idText.isEmpty()) {
            try {
                int id = Integer.parseInt(idText);

                CourseEntity courseDTO = courseBLL.courseDetail(id);

                if (courseDTO.getTitle() != null) {
                    System.out.println(courseDTO);
                    DefaultTableModel tableModel = (DefaultTableModel) tableCourseList.getModel();
                    tableModel.setRowCount(0);

                    Object[] rowData = {courseDTO.getCourseID(), courseDTO.getTitle()};
                    tableModel.addRow(rowData);
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy khóa học với ID: " + id);
                }
            } catch (NumberFormatException ex) {
                DefaultTableModel tableModel = (DefaultTableModel) tableCourseList.getModel();
                tableModel.setRowCount(0);
                boolean found = false;
                for (CourseEntity courseDTO : courseBLL.getAllist()) {
                    String title = courseDTO.getTitle().toLowerCase();
                    String searchText = idText.toLowerCase();
                    if (title.contains(searchText)) {
                        found = true;
                        Object[] rowData = {courseDTO.getCourseID(), courseDTO.getTitle()};
                        tableModel.addRow(rowData);
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy khóa học với tên: " + idText);
                    updateCourseList();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID hoặc tên khóa học muốn tìm!");
            updateCourseList();
        }
    }//GEN-LAST:event_btCourseSearchActionPerformed

    private void btSelectedInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelectedInstructorActionPerformed
        int row = tableInstructorList.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một giảng viên để thêm vào danh sách!");
            return;
        }

        int instructorId = (int) tableInstructorList.getValueAt(row, 0);
        String instructorName = tableInstructorList.getValueAt(row, 1).toString();
        PersonEntity personDTO = personBLL.detailsPerson(instructorId);
        DefaultTableModel tableInstructorSelectedListModel = (DefaultTableModel) tableSelectedInstructorList.getModel();

        boolean isDuplicate = false;

        for (int i = 0; i < tableInstructorSelectedListModel.getRowCount(); i++) {
            int selectedCourseId = (int) tableInstructorSelectedListModel.getValueAt(i, 1);
            if (instructorId == selectedCourseId) {
                isDuplicate = true;
                break;
            }
        }

        if (!isDuplicate) {
            int rowCount = tableInstructorSelectedListModel.getRowCount();
            Object[] rowData = {rowCount + 1, personDTO.getPersonID(), personDTO.getFirstName()};
            tableInstructorSelectedListModel.addRow(rowData);
            JOptionPane.showMessageDialog(null, "Đã thêm giảng viên có tên: " + instructorName + " vào danh sách");
        } else {
            JOptionPane.showMessageDialog(null, "Giảng viên đã tồn tại trong danh sách!");
        }
    }//GEN-LAST:event_btSelectedInstructorActionPerformed

    private void btDeleteInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteInstructorActionPerformed
        int a = tableSelectedInstructorList.getRowCount();
        if (a == 0) {
            JOptionPane.showMessageDialog(null, "Chưa có giảng viên nào trong bảng!");
            return;
        }
        int row = tableSelectedInstructorList.getSelectedRow();
        if (row != -1) {
            DefaultTableModel model = (DefaultTableModel) tableSelectedInstructorList.getModel();
            model.removeRow(row);
            JOptionPane.showMessageDialog(null, "Đã xóa giảng viên");
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một giảng viên để xóa!");
        }
    }//GEN-LAST:event_btDeleteInstructorActionPerformed

    private void btInstructorSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInstructorSearchActionPerformed
        String idText = tfInstructorSearch.getText().trim();

        if (!idText.isEmpty()) {
            try {
                int id = Integer.parseInt(idText);
                ArrayList<PersonEntity> instructorList = personBLL.getListInstructor();

                PersonEntity instructor = new PersonEntity();
                for (PersonEntity personDTO : instructorList) {
                    if (id == personDTO.getPersonID()) {
                        instructor = personDTO;
                    }
                }

                if (instructor.getPersonID() != 0) {
                    DefaultTableModel tableModel = (DefaultTableModel) tableInstructorList.getModel();
                    tableModel.setRowCount(0);

                    Object[] rowData = {instructor.getPersonID(), instructor.getFirstName()};
                    tableModel.addRow(rowData);
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy giảng viên với ID: " + id);
                }
            } catch (NumberFormatException ex) {
                DefaultTableModel tableModel = (DefaultTableModel) tableInstructorList.getModel();
                tableModel.setRowCount(0);
                boolean found = false;
                for (PersonEntity personDTO : personBLL.getListInstructor()) {
                    String instructorName = personDTO.getFirstName() + " " + personDTO.getLastName();
                    String searchText = idText.toLowerCase();
                    if (instructorName.toLowerCase().contains(searchText)) {
                        found = true;
                        Object[] rowData = {personDTO.getPersonID(), instructorName};
                        tableModel.addRow(rowData);
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy giảng viên với tên: " + idText);
                    updateInstructorList();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID hoặc tên giảng viên muốn tìm!");
            updateInstructorList();
        }
    }//GEN-LAST:event_btInstructorSearchActionPerformed

    private void btSeeAllCourseListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeeAllCourseListActionPerformed
        updateCourseList();
    }//GEN-LAST:event_btSeeAllCourseListActionPerformed

    private void btSeeAllInstructorListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeeAllInstructorListActionPerformed
        updateInstructorList();
    }//GEN-LAST:event_btSeeAllInstructorListActionPerformed

    private void updateInstructorList() {
        DefaultTableModel tableInstructorListModel = (DefaultTableModel) tableInstructorList.getModel();
        tableInstructorListModel.setRowCount(0);
        for (PersonEntity personDTO : personBLL.getListInstructor()) {
            Object[] rowData = {personDTO.getPersonID(), personDTO.getFirstName()};
            tableInstructorListModel.addRow(rowData);
        }
    }

    private void updateCourseList() {
        DefaultTableModel tableCourseListModel = (DefaultTableModel) tableCourseList.getModel();
        tableCourseListModel.setRowCount(0);
        for (CourseEntity courseDTO : courseBLL.selectAllCourse()) {
            Object[] rowData = {courseDTO.getCourseID(), courseDTO.getTitle()};
            tableCourseListModel.addRow(rowData);
        }
    }

    public List<PersonEntity> getSelectedCourses() {
        List<PersonEntity> selectedInstructors = new ArrayList<>();

        DefaultTableModel tableModel = (DefaultTableModel) tableSelectedInstructorList.getModel();
        int rowCount = tableModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            int instructorId = (int) tableModel.getValueAt(i, 1);
            PersonEntity personDTO = personBLL.detailsPerson(instructorId);
            selectedInstructors.add(personDTO);
        }

        return selectedInstructors;
    }

    public Integer getFirstColumnDataOfSelectedRow() {
        int selectedRow = tableCourseList.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel tableModel = (DefaultTableModel) tableCourseList.getModel();
            Integer rowData = (Integer) tableModel.getValueAt(selectedRow, 0);
            return rowData;
        } else {
            return null;
        }
    }

    public void resetSelectedCourseListTable() {
        DefaultTableModel model = (DefaultTableModel) tableSelectedInstructorList.getModel();
        model.setRowCount(0);
        tableInstructorList.clearSelection();
        tableCourseList.clearSelection();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCourseSearch;
    private javax.swing.JButton btDeleteInstructor;
    private javax.swing.JButton btInstructorSearch;
    private javax.swing.JButton btSeeAllCourseList;
    private javax.swing.JButton btSeeAllInstructorList;
    private javax.swing.JButton btSelectedInstructor;
    private javax.swing.JPanel pnCourseList;
    private javax.swing.JPanel pnInstructorList;
    private javax.swing.JPanel pnSelectedInstructorList;
    private javax.swing.JScrollPane spCourseList;
    private javax.swing.JScrollPane spInstructorList;
    private javax.swing.JScrollPane spSelectedCourseList;
    private javax.swing.JTable tableCourseList;
    private javax.swing.JTable tableInstructorList;
    private javax.swing.JTable tableSelectedInstructorList;
    private javax.swing.JTextField tfCourseSearch;
    private javax.swing.JTextField tfInstructorSearch;
    // End of variables declaration//GEN-END:variables
}
