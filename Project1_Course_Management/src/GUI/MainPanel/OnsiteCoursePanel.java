/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.MainPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.*;

/**
 *
 * @author ASUS
 */
public class OnsiteCoursePanel extends javax.swing.JPanel {

    /**
     * Creates new form CoursesPanel
     */
    private final OnsiteCourseAddForm onsiteCourseAddForm = new OnsiteCourseAddForm();
    
    public OnsiteCoursePanel() {
        initComponents();
    }
    public void setEditOnsiteCoursePane(JPanel editOnsiteCoursePanel) {
        this.editOnsiteCoursePanel = editOnsiteCoursePanel;
    }

    public JPanel getEditOnsiteCoursePanel() {
        return editOnsiteCoursePanel;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        searchOnsiteCourseValue = new javax.swing.JTextField();
        searchOnsiteCourseBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        addCourseBtn = new javax.swing.JButton();
        editCourseBtn = new javax.swing.JButton();
        deleteCourseBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        onsiteCourseTable = new javax.swing.JTable();
        editOnsiteCoursePanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCourseID = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCredit = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtMonday = new javax.swing.JCheckBox();
        txtTuesday = new javax.swing.JCheckBox();
        txtWednesday = new javax.swing.JCheckBox();
        txtThursday = new javax.swing.JCheckBox();
        txtFriday = new javax.swing.JCheckBox();
        txtSaturday = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        timePicker1 = new com.github.lgooddatepicker.components.TimePicker();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("QUẢN LÝ KHÓA HỌC ONSITE");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0);
        flowLayout1.setAlignOnBaseline(true);
        jPanel3.setLayout(flowLayout1);

        searchOnsiteCourseValue.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchOnsiteCourseValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchOnsiteCourseValue.setPreferredSize(new java.awt.Dimension(300, 45));
        jPanel3.add(searchOnsiteCourseValue);

        searchOnsiteCourseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-search-24.png"))); // NOI18N
        searchOnsiteCourseBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchOnsiteCourseBtn.setPreferredSize(new java.awt.Dimension(45, 45));
        searchOnsiteCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchOnsiteCourseBtnActionPerformed(evt);
            }
        });
        jPanel3.add(searchOnsiteCourseBtn);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 62));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout2.setAlignOnBaseline(true);
        jPanel4.setLayout(flowLayout2);

        addCourseBtn.setBackground(new java.awt.Color(155, 207, 83));
        addCourseBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addCourseBtn.setForeground(new java.awt.Color(255, 255, 255));
        addCourseBtn.setText("Thêm");
        addCourseBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(191, 234, 124)));
        addCourseBtn.setPreferredSize(new java.awt.Dimension(100, 45));
        addCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseBtnActionPerformed(evt);
            }
        });
        jPanel4.add(addCourseBtn);

        editCourseBtn.setBackground(new java.awt.Color(64, 162, 227));
        editCourseBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editCourseBtn.setForeground(new java.awt.Color(255, 255, 255));
        editCourseBtn.setText("Sửa");
        editCourseBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 226, 236)));
        editCourseBtn.setPreferredSize(new java.awt.Dimension(100, 45));
        editCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCourseBtnActionPerformed(evt);
            }
        });
        jPanel4.add(editCourseBtn);

        deleteCourseBtn.setBackground(new java.awt.Color(255, 104, 104));
        deleteCourseBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteCourseBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteCourseBtn.setText("Xóa");
        deleteCourseBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 128, 128)));
        deleteCourseBtn.setPreferredSize(new java.awt.Dimension(100, 45));
        deleteCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCourseBtnActionPerformed(evt);
            }
        });
        jPanel4.add(deleteCourseBtn);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(813, 45));
        java.awt.FlowLayout flowLayout3 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 0);
        flowLayout3.setAlignOnBaseline(true);
        jPanel5.setLayout(flowLayout3);
        jPanel4.add(jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        onsiteCourseTable.getTableHeader().setFont(new Font("Segoe UI", 0, 14));
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        onsiteCourseTable.setFont(new Font("Segoe UI", 0, 14));
        leftRenderer.setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer)onsiteCourseTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        // Iterate over each column and set cell renderer and font
        for (int i = 0; i < onsiteCourseTable.getColumnCount(); i++) {
            onsiteCourseTable.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }
        onsiteCourseTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        onsiteCourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1045", "Calculus", "4", "Mathematics", "121 Smith", "MWHF", "15:30:00"},
                {"1046", "Chemistry", "4", "Engineering", "123 Smith", "MTWH", "16:30:00"},
                {"1061", "Physics", "4", "Enginerring", "234 Smith", "TWHF", "13:15:00"},
                {"2042", "Literature", "4", "English", "225 Adams", "MTWH", "11:00:00"},
                {"4022", "Microeconomics", "3", "Economics", "23 Williams", "MWF", "09:00:00"}
            },
            new String [] {
                "CourseID", "CourseName", "Credit", "Department Name", "Location", "Days", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        onsiteCourseTable.setRowHeight(35);
        onsiteCourseTable.getTableHeader().setReorderingAllowed(false);
        onsiteCourseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onsiteCourseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(onsiteCourseTable);
        if (onsiteCourseTable.getColumnModel().getColumnCount() > 0) {
            onsiteCourseTable.getColumnModel().getColumn(0).setMinWidth(70);
            onsiteCourseTable.getColumnModel().getColumn(0).setMaxWidth(70);
            onsiteCourseTable.getColumnModel().getColumn(1).setMinWidth(150);
            onsiteCourseTable.getColumnModel().getColumn(1).setMaxWidth(150);
            onsiteCourseTable.getColumnModel().getColumn(2).setMinWidth(70);
            onsiteCourseTable.getColumnModel().getColumn(2).setMaxWidth(70);
            onsiteCourseTable.getColumnModel().getColumn(4).setMinWidth(100);
            onsiteCourseTable.getColumnModel().getColumn(4).setMaxWidth(100);
            onsiteCourseTable.getColumnModel().getColumn(5).setMinWidth(100);
            onsiteCourseTable.getColumnModel().getColumn(5).setMaxWidth(100);
            onsiteCourseTable.getColumnModel().getColumn(6).setMinWidth(120);
            onsiteCourseTable.getColumnModel().getColumn(6).setMaxWidth(120);
        }

        editOnsiteCoursePanel.setBackground(new java.awt.Color(255, 255, 255));
        editOnsiteCoursePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        editOnsiteCoursePanel.setPreferredSize(new java.awt.Dimension(1035, 183));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout7 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout7.setAlignOnBaseline(true);
        jPanel7.setLayout(flowLayout7);

        jLabel2.setText("ID Khóa học:");
        jLabel2.setPreferredSize(new java.awt.Dimension(75, 45));
        jPanel7.add(jLabel2);

        txtCourseID.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel7.add(txtCourseID);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout11 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout11.setAlignOnBaseline(true);
        jPanel8.setLayout(flowLayout11);

        jLabel3.setText("Tên khóa học:");
        jLabel3.setPreferredSize(new java.awt.Dimension(75, 45));
        jPanel8.add(jLabel3);

        jTextField1.setPreferredSize(new java.awt.Dimension(205, 40));
        jPanel8.add(jTextField1);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(164, 55));
        java.awt.FlowLayout flowLayout10 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout10.setAlignOnBaseline(true);
        jPanel9.setLayout(flowLayout10);

        jLabel4.setText("Tín chỉ:");
        jLabel4.setPreferredSize(new java.awt.Dimension(75, 45));
        jPanel9.add(jLabel4);

        txtCredit.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel9.add(txtCredit);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Tên Khoa:");
        jLabel5.setPreferredSize(new java.awt.Dimension(70, 45));
        jPanel10.add(jLabel5);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        jComboBox1.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel10.add(jComboBox1);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout4 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout4.setAlignOnBaseline(true);
        jPanel11.setLayout(flowLayout4);

        jLabel6.setText("Địa chỉ:");
        jLabel6.setPreferredSize(new java.awt.Dimension(75, 40));
        jPanel11.add(jLabel6);

        jTextField2.setText("jTextField2");
        jTextField2.setPreferredSize(new java.awt.Dimension(200, 40));
        jTextField2.setRequestFocusEnabled(false);
        jPanel11.add(jTextField2);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout5 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout5.setAlignOnBaseline(true);
        jPanel12.setLayout(flowLayout5);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Ngày:");
        jLabel7.setToolTipText("");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel7.setPreferredSize(new java.awt.Dimension(75, 40));
        jPanel12.add(jLabel7);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        jPanel13.setPreferredSize(new java.awt.Dimension(493, 40));
        java.awt.FlowLayout flowLayout6 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout6.setAlignOnBaseline(true);
        jPanel13.setLayout(flowLayout6);

        txtMonday.setText("Thứ 2");
        txtMonday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 15));
        txtMonday.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtMonday.setPreferredSize(new java.awt.Dimension(75, 30));
        jPanel13.add(txtMonday);

        txtTuesday.setText("Thứ 3");
        txtTuesday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 15));
        txtTuesday.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTuesday.setPreferredSize(new java.awt.Dimension(75, 30));
        jPanel13.add(txtTuesday);

        txtWednesday.setText("Thứ 4");
        txtWednesday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 15));
        txtWednesday.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtWednesday.setPreferredSize(new java.awt.Dimension(75, 30));
        jPanel13.add(txtWednesday);

        txtThursday.setText("Thứ 5");
        txtThursday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 15));
        txtThursday.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtThursday.setPreferredSize(new java.awt.Dimension(75, 30));
        jPanel13.add(txtThursday);

        txtFriday.setText("Thứ 6");
        txtFriday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 15));
        txtFriday.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtFriday.setPreferredSize(new java.awt.Dimension(75, 30));
        jPanel13.add(txtFriday);

        txtSaturday.setText("Thứ 7");
        txtSaturday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 15));
        txtSaturday.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtSaturday.setPreferredSize(new java.awt.Dimension(75, 30));
        jPanel13.add(txtSaturday);

        jPanel12.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(100, 50));
        java.awt.FlowLayout flowLayout8 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout8.setAlignOnBaseline(true);
        jPanel14.setLayout(flowLayout8);

        jLabel8.setText("Thời gian:");
        jLabel8.setPreferredSize(new java.awt.Dimension(75, 45));
        jPanel14.add(jLabel8);

        timePicker1.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel14.add(timePicker1);

        jButton1.setText("Lưu");
        jButton1.setBackground(new java.awt.Color(56, 122, 223));
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 196, 237)));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setText("Đóng");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 206, 206)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout editOnsiteCoursePanelLayout = new javax.swing.GroupLayout(editOnsiteCoursePanel);
        editOnsiteCoursePanel.setLayout(editOnsiteCoursePanelLayout);
        editOnsiteCoursePanelLayout.setHorizontalGroup(
            editOnsiteCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        editOnsiteCoursePanelLayout.setVerticalGroup(
            editOnsiteCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editOnsiteCoursePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editOnsiteCoursePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchOnsiteCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchOnsiteCourseBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchOnsiteCourseBtnActionPerformed

    private void addCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseBtnActionPerformed
       onsiteCourseAddForm.setVisible(true);
    }//GEN-LAST:event_addCourseBtnActionPerformed

    private void deleteCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCourseBtnActionPerformed
        int deleteChoice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dòng này không?");
    }//GEN-LAST:event_deleteCourseBtnActionPerformed

    private void editCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCourseBtnActionPerformed
        editOnsiteCoursePanel.setVisible(true);
    }//GEN-LAST:event_editCourseBtnActionPerformed

    private void onsiteCourseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onsiteCourseTableMouseClicked
        
    }//GEN-LAST:event_onsiteCourseTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        editOnsiteCoursePanel.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCourseBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton deleteCourseBtn;
    private javax.swing.JButton editCourseBtn;
    private javax.swing.JPanel editOnsiteCoursePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable onsiteCourseTable;
    private javax.swing.JButton searchOnsiteCourseBtn;
    private javax.swing.JTextField searchOnsiteCourseValue;
    private com.github.lgooddatepicker.components.TimePicker timePicker1;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtCredit;
    private javax.swing.JCheckBox txtFriday;
    private javax.swing.JCheckBox txtMonday;
    private javax.swing.JCheckBox txtSaturday;
    private javax.swing.JCheckBox txtThursday;
    private javax.swing.JCheckBox txtTuesday;
    private javax.swing.JCheckBox txtWednesday;
    // End of variables declaration//GEN-END:variables
}
