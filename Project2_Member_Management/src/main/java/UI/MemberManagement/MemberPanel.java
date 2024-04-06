/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.MemberManagement;

import java.util.List;
import POJOs.Member;
import BLL.MemberBLL;
import Utils.sharedFunction;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class MemberPanel extends javax.swing.JPanel {

    /**
     * Creates new form MemberPanel
     */
    private final BorrowDeviceFrame borrowDeviceFrame = new BorrowDeviceFrame();
    private final MemberForm memberForm = new MemberForm();
    private MemberBLL memberBLL = new MemberBLL();
    sharedFunction func = new sharedFunction();

    public MemberPanel() {
        initComponents();
        readMembers(); // load data to table members
    }

    public void readMembers() {
        List<Member> memberList = memberBLL.selectAll();

        DefaultTableModel model = (DefaultTableModel) tblMember.getModel();
        model.setRowCount(0);
        
        int STT = 1;
        for (Member member : memberList)
        {
            int status = member.getStatus();
            if (status == 0)
            {
                continue;
            }
            String ID = member.getId();
            String name = member.getName();
            String department = member.getDepartment();
            String major = member.getMajor();
            String email = member.getEmail();

            Object[] row
                    =
                    {
                        STT++, ID, name, department, major, email
                    };
            model.addRow(row);
        }
        model.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        searchValue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        addMemberBtn = new javax.swing.JButton();
        editMemberBtn = new javax.swing.JButton();
        deleteMemberBtn = new javax.swing.JButton();
        deviceFrameBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMember = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("MEMBER MANAGEMENT");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(601, 50));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 40));

        searchValue.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        searchValue.setText("search");
        searchValue.setBorder(null);
        searchValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchValueActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-25.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(searchValue, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(searchValue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 40));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0);
        flowLayout1.setAlignOnBaseline(true);
        jPanel3.setLayout(flowLayout1);

        addMemberBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        addMemberBtn.setForeground(new java.awt.Color(0, 143, 143));
        addMemberBtn.setText("+ Add");
        addMemberBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 143, 143), 1, true));
        addMemberBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMemberBtn.setPreferredSize(new java.awt.Dimension(80, 40));
        addMemberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberBtnActionPerformed(evt);
            }
        });
        jPanel3.add(addMemberBtn);

        editMemberBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        editMemberBtn.setForeground(new java.awt.Color(0, 143, 143));
        editMemberBtn.setText("! Edit");
        editMemberBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 143, 143), 1, true));
        editMemberBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editMemberBtn.setPreferredSize(new java.awt.Dimension(80, 40));
        editMemberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMemberBtnActionPerformed(evt);
            }
        });
        jPanel3.add(editMemberBtn);

        deleteMemberBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        deleteMemberBtn.setForeground(new java.awt.Color(0, 143, 143));
        deleteMemberBtn.setText("- Delete");
        deleteMemberBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 143, 143), 1, true));
        deleteMemberBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteMemberBtn.setPreferredSize(new java.awt.Dimension(80, 40));
        deleteMemberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMemberBtnActionPerformed(evt);
            }
        });
        jPanel3.add(deleteMemberBtn);

        deviceFrameBtn.setBackground(new java.awt.Color(0, 143, 143));
        deviceFrameBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        deviceFrameBtn.setForeground(new java.awt.Color(255, 255, 255));
        deviceFrameBtn.setText("Borrow/Return Device");
        deviceFrameBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 143, 143), 1, true));
        deviceFrameBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deviceFrameBtn.setPreferredSize(new java.awt.Dimension(160, 40));
        deviceFrameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deviceFrameBtnActionPerformed(evt);
            }
        });
        jPanel3.add(deviceFrameBtn);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblMember.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "ID", "Name", "Department", "Major", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMember.setGridColor(new java.awt.Color(242, 242, 242));
        tblMember.setRowHeight(30);
        tblMember.setShowGrid(true);
        tblMember.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblMember);
        if (tblMember.getColumnModel().getColumnCount() > 0) {
            tblMember.getColumnModel().getColumn(0).setResizable(false);
            tblMember.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblMember.getColumnModel().getColumn(1).setResizable(false);
            tblMember.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblMember.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblMember.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblMember.getColumnModel().getColumn(4).setResizable(false);
            tblMember.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblMember.getColumnModel().getColumn(5).setResizable(false);
            tblMember.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deviceFrameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deviceFrameBtnActionPerformed
        borrowDeviceFrame.setVisible(true);
    }//GEN-LAST:event_deviceFrameBtnActionPerformed

    private void addMemberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberBtnActionPerformed
        // TODO add your handling code here:
        memberForm.setVisible(true);
    }//GEN-LAST:event_addMemberBtnActionPerformed

    private void editMemberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMemberBtnActionPerformed
        // TODO add your handling code here:
        memberForm.setVisible(true);
    }//GEN-LAST:event_editMemberBtnActionPerformed

    private void searchValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchValueActionPerformed
    private void deleteMemberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMemberBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMember.getSelectedRow();
        if(selectedRow != -1) {
            String memberId = tblMember.getValueAt(selectedRow, 1).toString();
            memberBLL.deleteMember(memberId);
            readMembers();
            func.displayConfirmMessage("Delete Successfully !!");
        } else {
            func.displayErrorMessage("Please choose a record !!");
        }
    }//GEN-LAST:event_deleteMemberBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMemberBtn;
    private javax.swing.JButton deleteMemberBtn;
    private javax.swing.JButton deviceFrameBtn;
    private javax.swing.JButton editMemberBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField searchValue;
    private javax.swing.JTable tblMember;
    // End of variables declaration//GEN-END:variables
}
