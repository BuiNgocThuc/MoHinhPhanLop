/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.MemberManagement;

import BLL.MemberBLL;
import POJOs.Member;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class MemberForm extends javax.swing.JFrame {

    private MemberBLL memberBLL = new MemberBLL();
    private Member member;
    /**
     * Creates new form MemberForm
     * @param member
     */
    public MemberForm(Member member) {
        this.member = member;
        initComponents();
        readMember(member);
       
    }
    
    public MemberForm() {
         initComponents();
         readDepartments();
    }
    
    private void readMember(Member member) {
        readDepartments();
        txtFullName.setText(member.getName());
        txtPhone.setText(member.getPhone());
        cbDepartment.setSelectedItem(member.getDepartment());
        cbMajor.setSelectedItem(member.getMajor());
//        txtID.setText(member.getId());
//        txtEmail.setText(member.getEmail());
    }
    
    

    private void readDepartments() {
        List<String> departments = memberBLL.queryDepartment();
        departments.forEach(deparment -> cbDepartment.addItem(deparment));
    }

    private void readMajors(String department) {
        List<String> majors = memberBLL.queryMajor(department);
        cbMajor.removeAllItems();
        majors.forEach(major -> cbMajor.addItem(major));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        idPnl = new javax.swing.JPanel();
        lblFullName = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        dmPnl = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lblDepartment = new javax.swing.JLabel();
        cbDepartment = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        lblMajor = new javax.swing.JLabel();
        cbMajor = new javax.swing.JComboBox<>();
        phonePnl = new javax.swing.JPanel();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        fullNamePnl = new javax.swing.JPanel();
        lblFullName1 = new javax.swing.JLabel();
        txtFullName1 = new javax.swing.JTextField();
        emailPnl = new javax.swing.JPanel();
        lblFullName2 = new javax.swing.JLabel();
        txtFullName2 = new javax.swing.JTextField();
        buttonPnl = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Member Form");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("ADD/EDIT MEMBER INFORMATION");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        idPnl.setBackground(new java.awt.Color(255, 255, 255));

        lblFullName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFullName.setText("ID:");

        txtFullName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout idPnlLayout = new javax.swing.GroupLayout(idPnl);
        idPnl.setLayout(idPnlLayout);
        idPnlLayout.setHorizontalGroup(
            idPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idPnlLayout.createSequentialGroup()
                .addComponent(lblFullName)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtFullName)
        );
        idPnlLayout.setVerticalGroup(
            idPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idPnlLayout.createSequentialGroup()
                .addComponent(lblFullName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFullName, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        dmPnl.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0);
        flowLayout1.setAlignOnBaseline(true);
        dmPnl.setLayout(flowLayout1);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));

        lblDepartment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDepartment.setText("Department:");

        cbDepartment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDepartmentItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(lblDepartment)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(cbDepartment, 0, 289, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(lblDepartment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        dmPnl.add(jPanel9);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        lblMajor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMajor.setText("Major:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(lblMajor)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(cbMajor, 0, 305, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(lblMajor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMajor, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        dmPnl.add(jPanel8);

        phonePnl.setBackground(new java.awt.Color(255, 255, 255));

        lblPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhone.setText("Phone number:");

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout phonePnlLayout = new javax.swing.GroupLayout(phonePnl);
        phonePnl.setLayout(phonePnlLayout);
        phonePnlLayout.setHorizontalGroup(
            phonePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phonePnlLayout.createSequentialGroup()
                .addComponent(lblPhone)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtPhone)
        );
        phonePnlLayout.setVerticalGroup(
            phonePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phonePnlLayout.createSequentialGroup()
                .addComponent(lblPhone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        fullNamePnl.setBackground(new java.awt.Color(255, 255, 255));

        lblFullName1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFullName1.setText("Full Name:");

        txtFullName1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout fullNamePnlLayout = new javax.swing.GroupLayout(fullNamePnl);
        fullNamePnl.setLayout(fullNamePnlLayout);
        fullNamePnlLayout.setHorizontalGroup(
            fullNamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fullNamePnlLayout.createSequentialGroup()
                .addComponent(lblFullName1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtFullName1)
        );
        fullNamePnlLayout.setVerticalGroup(
            fullNamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fullNamePnlLayout.createSequentialGroup()
                .addComponent(lblFullName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFullName1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        emailPnl.setBackground(new java.awt.Color(255, 255, 255));

        lblFullName2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFullName2.setText("Email:");

        txtFullName2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout emailPnlLayout = new javax.swing.GroupLayout(emailPnl);
        emailPnl.setLayout(emailPnlLayout);
        emailPnlLayout.setHorizontalGroup(
            emailPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailPnlLayout.createSequentialGroup()
                .addComponent(lblFullName2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtFullName2)
        );
        emailPnlLayout.setVerticalGroup(
            emailPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailPnlLayout.createSequentialGroup()
                .addComponent(lblFullName2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFullName2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        buttonPnl.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setForeground(new java.awt.Color(0, 143, 143));
        jButton1.setText("Cancel");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 143, 143), 1, true));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 143, 143));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Save");
        jButton2.setPreferredSize(new java.awt.Dimension(100, 40));

        javax.swing.GroupLayout buttonPnlLayout = new javax.swing.GroupLayout(buttonPnl);
        buttonPnl.setLayout(buttonPnlLayout);
        buttonPnlLayout.setHorizontalGroup(
            buttonPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        buttonPnlLayout.setVerticalGroup(
            buttonPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPnlLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(buttonPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dmPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phonePnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fullNamePnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(buttonPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(idPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(fullNamePnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(emailPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dmPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(phonePnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbDepartmentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDepartmentItemStateChanged
        // TODO add your handling code here:
        String department = cbDepartment.getSelectedItem().toString();
        readMajors(department);
    }//GEN-LAST:event_cbDepartmentItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MemberForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MemberForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MemberForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MemberForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new MemberForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPnl;
    private javax.swing.JComboBox<String> cbDepartment;
    private javax.swing.JComboBox<String> cbMajor;
    private javax.swing.JPanel dmPnl;
    private javax.swing.JPanel emailPnl;
    private javax.swing.JPanel fullNamePnl;
    private javax.swing.JPanel idPnl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblFullName1;
    private javax.swing.JLabel lblFullName2;
    private javax.swing.JLabel lblMajor;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JPanel phonePnl;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtFullName1;
    private javax.swing.JTextField txtFullName2;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}