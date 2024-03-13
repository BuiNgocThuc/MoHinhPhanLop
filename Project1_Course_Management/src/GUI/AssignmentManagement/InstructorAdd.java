/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.AssignmentManagement;

import BLL.PersonBLL;
import DTO.PersonDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Bao
 */
public class InstructorAdd extends javax.swing.JFrame {

    /**
     * Creates new form InstructorAdd
     */
    public InstructorAdd() {
        initComponents();
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

        lbInstructorAdd = new javax.swing.JLabel();
        pnContainer = new javax.swing.JPanel();
        pnFirstName = new javax.swing.JPanel();
        tfFirstName = new javax.swing.JTextField();
        pnLastName = new javax.swing.JPanel();
        tfLastName = new javax.swing.JTextField();
        pnHireDate = new javax.swing.JPanel();
        dcHireDate = new com.toedter.calendar.JDateChooser();
        btClose = new javax.swing.JButton();
        btSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbInstructorAdd.setText("ADD NEW INSTRUCTOR");

        pnContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Instructor Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        pnFirstName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "First Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        pnFirstName.setPreferredSize(new java.awt.Dimension(64, 22));

        javax.swing.GroupLayout pnFirstNameLayout = new javax.swing.GroupLayout(pnFirstName);
        pnFirstName.setLayout(pnFirstNameLayout);
        pnFirstNameLayout.setHorizontalGroup(
            pnFirstNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFirstNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnFirstNameLayout.setVerticalGroup(
            pnFirstNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFirstNameLayout.createSequentialGroup()
                .addComponent(tfFirstName)
                .addContainerGap())
        );

        pnLastName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        pnLastName.setPreferredSize(new java.awt.Dimension(64, 22));

        javax.swing.GroupLayout pnLastNameLayout = new javax.swing.GroupLayout(pnLastName);
        pnLastName.setLayout(pnLastNameLayout);
        pnLastNameLayout.setHorizontalGroup(
            pnLastNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLastNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnLastNameLayout.setVerticalGroup(
            pnLastNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLastNameLayout.createSequentialGroup()
                .addComponent(tfLastName)
                .addContainerGap())
        );

        pnHireDate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hire date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        pnHireDate.setPreferredSize(new java.awt.Dimension(64, 22));

        javax.swing.GroupLayout pnHireDateLayout = new javax.swing.GroupLayout(pnHireDate);
        pnHireDate.setLayout(pnHireDateLayout);
        pnHireDateLayout.setHorizontalGroup(
            pnHireDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHireDateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dcHireDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnHireDateLayout.setVerticalGroup(
            pnHireDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHireDateLayout.createSequentialGroup()
                .addComponent(dcHireDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnContainerLayout = new javax.swing.GroupLayout(pnContainer);
        pnContainer.setLayout(pnContainerLayout);
        pnContainerLayout.setHorizontalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnContainerLayout.createSequentialGroup()
                        .addComponent(pnFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(pnLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                    .addComponent(pnHireDate, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnContainerLayout.setVerticalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(pnHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btClose.setText("Close");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbInstructorAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSave)
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbInstructorAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btClose)
                    .addComponent(btSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        String firstName = tfFirstName.getText().trim();
        String lastName = tfLastName.getText().trim();
        Date hireDate = dcHireDate.getDate();

        if (firstName.isEmpty() || lastName.isEmpty() || hireDate == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Date currentDate = new Date();
        if (hireDate.after(currentDate)) {
            JOptionPane.showMessageDialog(this, "Ngày thuê không được lớn hơn ngày hiện tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (firstName.matches("\\d+") || lastName.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Tên không được chứa số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PersonDTO newPerson = new PersonDTO();
        newPerson.setFirstName(firstName);
        newPerson.setLastName(lastName);
        newPerson.setHireDate(new java.sql.Timestamp(hireDate.getTime()));

        PersonBLL personBLL = new PersonBLL();
        boolean success = false;
        try {
            success = personBLL.addPerson(newPerson);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (success) {
            JOptionPane.showMessageDialog(this, "Thêm giảng viên mới thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            resetInput();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm giảng viên mới thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void resetInput() {
        tfFirstName.setText("");
        tfLastName.setText("");
        dcHireDate.setDate(null);
    }

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btCloseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InstructorAdd instructorAdd = new InstructorAdd();
                instructorAdd.setLocationRelativeTo(null);
                instructorAdd.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btSave;
    private com.toedter.calendar.JDateChooser dcHireDate;
    private javax.swing.JLabel lbInstructorAdd;
    private javax.swing.JPanel pnContainer;
    private javax.swing.JPanel pnFirstName;
    private javax.swing.JPanel pnHireDate;
    private javax.swing.JPanel pnLastName;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    // End of variables declaration//GEN-END:variables
}
