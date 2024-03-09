/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.CourseInfo;

import BLL.CourseBLL;
import DTO.CourseDTO;
import GUI.CourseResultJFrame.JFrameManageCourseResults;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author MSI
 */
public class CourseResultsPanel extends javax.swing.JPanel {
    CourseBLL courseBLL=new CourseBLL();
    /**
     * Creates new form PanelKhoaHocOnline
     */
    public CourseResultsPanel() {
        initComponents();
        LoadData();
        LoadDataCourse();
        jButtonClearSearch.setVisible(false);
        jSearch.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
              SearchAll();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
              SearchAll();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
       
        }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonClearSearch1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCourse = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxCourse = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jButtonClearSearch = new javax.swing.JButton();
        jSearch = new javax.swing.JTextField();
        jButtonIcon = new javax.swing.JButton();

        jButtonClearSearch1.setText("X");
        jButtonClearSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearSearch1ActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new java.awt.Dimension(1007, 607));

        jTableCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CourseID", "Title"
            }
        ));
        jTableCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCourseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCourse);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("QUẢN LÝ KẾT QUẢ SINH VIÊN");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 10, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout2.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        jPanel3.setLayout(flowLayout1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Course");
        jPanel3.add(jLabel1);

        jComboBoxCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCourse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        jComboBoxCourse.setPreferredSize(new java.awt.Dimension(200, 40));
        jComboBoxCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxCourseMouseClicked(evt);
            }
        });
        jComboBoxCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCourseActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxCourse);

        jPanel1.add(jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(705, 50));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButtonClearSearch.setText("X");
        jButtonClearSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonClearSearch.setPreferredSize(new java.awt.Dimension(40, 40));
        jButtonClearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearSearchActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonClearSearch);

        jSearch.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSearch.setPreferredSize(new java.awt.Dimension(300, 40));
        jSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchActionPerformed(evt);
            }
        });
        jPanel2.add(jSearch);

        jButtonIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-search-24.png"))); // NOI18N
        jButtonIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonIcon.setMargin(new java.awt.Insets(2, 20, 3, 0));
        jButtonIcon.setPreferredSize(new java.awt.Dimension(40, 40));
        jButtonIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIconActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonIcon);

        jPanel1.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(712, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCourseMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() > 1) {
            int n=jTableCourse.getSelectedRow();
            JFrameManageCourseResults onlineCourse=new JFrameManageCourseResults(Integer.parseInt(jTableCourse.getValueAt(n,0).toString()),jTableCourse.getValueAt(n,1).toString());
            onlineCourse.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            onlineCourse.setLocationRelativeTo(null);
            onlineCourse.setVisible(true);
            jTableCourse.clearSelection();
        }
    }//GEN-LAST:event_jTableCourseMouseClicked

    private void jComboBoxCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxCourseMouseClicked
        // TODO add your handling code here:
//        if(jComboBoxCourse.getSelectedItem().toString().equals("All")){
//            LoadData();
//        }else if(jComboBoxCourse.getSelectedItem().toString().equals("Online")){
//            LoadData("Online");
//        }else{
//            LoadData("Onsite");
//        }
    }//GEN-LAST:event_jComboBoxCourseMouseClicked

    private void jComboBoxCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCourseActionPerformed
        // TODO add your handling code here:
        if(jComboBoxCourse.getSelectedItem().toString().equals("All")){
            LoadData();
        }else if(jComboBoxCourse.getSelectedItem().toString().equals("Online")){
            LoadData("Online");
        }else{
            LoadData("Onsite");
        }
    }//GEN-LAST:event_jComboBoxCourseActionPerformed

    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSearchActionPerformed

    private void jButtonClearSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearSearch1ActionPerformed
        // TODO add your handling code here:
        jSearch.setText("");
        LoadData();
    }//GEN-LAST:event_jButtonClearSearch1ActionPerformed

    private void jButtonClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearSearchActionPerformed
        // TODO add your handling code here:
        jSearch.setText("");
        LoadData();
    }//GEN-LAST:event_jButtonClearSearchActionPerformed

    private void jButtonIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonIconActionPerformed

    public void SearchTable(String text){
         DefaultTableModel model=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String columns[]=new String[]{"CourseID","CourseName"};
        for(String i:columns){
            model.addColumn(i);
        }
        for(CourseDTO i:courseBLL.searchAllCourse(text)){
            Vector t=new Vector<>();
            t.add(i.getCourseID());
            t.add(i.getTitle());
            model.addRow(t);
        }
        jTableCourse.setModel(model);
    }
    public void SearchAll(){
        if(jSearch.getText().isEmpty()) {
            jButtonClearSearch.setVisible(false);
            jTableCourse.setRowSorter(null);
            LoadData();
        }
        else {
            SearchTable(jSearch.getText().toString());
            jButtonClearSearch.setVisible(true);
        }
    }
    public void LoadData(){
        jComboBoxCourse.setSelectedIndex(0);
        DefaultTableModel model=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String columns[]=new String[]{"CourseID","CourseName"};
        for(String i:columns){
            model.addColumn(i);
        }
        for(CourseDTO i:courseBLL.getAllist()){
            Vector t=new Vector<>();
            t.add(i.getCourseID());
            t.add(i.getTitle());
            model.addRow(t);
        }
        jTableCourse.setModel(model);
    }
    // choose course online or offline
    public void LoadData(String text){
        DefaultTableModel model=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String columns[]=new String[]{"CourseID","CourseName"};
        for(String i:columns){
            model.addColumn(i);
        }
        for(CourseDTO i:courseBLL.getAllist(text)){
            Vector t=new Vector<>();
            t.add(i.getCourseID());
            t.add(i.getTitle());
            model.addRow(t);
        }
        jTableCourse.setModel(model);
    }
    public void LoadDataCourse(){
        DefaultComboBoxModel model=new DefaultComboBoxModel<>();
        model.addElement("All");
        model.addElement("Online");
        model.addElement("Onsite");
        jComboBoxCourse.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClearSearch;
    private javax.swing.JButton jButtonClearSearch1;
    private javax.swing.JButton jButtonIcon;
    private javax.swing.JComboBox<String> jComboBoxCourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSearch;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableCourse;
    // End of variables declaration//GEN-END:variables
}
