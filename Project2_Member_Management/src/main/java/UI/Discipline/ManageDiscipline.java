/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.Discipline;

import BLL.DisciplineBLL;
import POJOs.Discipline;
import POJOs.Member;
import com.mysql.cj.result.Row;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author MSI
 */
public class ManageDiscipline extends javax.swing.JFrame {
    DisciplineBLL disciplineBLL = new DisciplineBLL();

    /**
     * Creates new form ManagerViolate
     */
    public ManageDiscipline() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoadData();
        jBtnSearch.setVisible(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDiscipline = new javax.swing.JTable();
        jSearch = new javax.swing.JTextField();
        jBtnSearch = new javax.swing.JButton();
        jBtnAdd = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnEdit = new javax.swing.JButton();
        jBtnImportExcel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableDiscipline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã xử lý", "Mã thành viên", "Thành viên", "Hình thức xử lý", "Số tiền", "Ngày xử lý", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDiscipline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDisciplineMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDiscipline);
        if (jTableDiscipline.getColumnModel().getColumnCount() > 0) {
            jTableDiscipline.getColumnModel().getColumn(0).setResizable(false);
            jTableDiscipline.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTableDiscipline.getColumnModel().getColumn(1).setResizable(false);
            jTableDiscipline.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTableDiscipline.getColumnModel().getColumn(2).setResizable(false);
            jTableDiscipline.getColumnModel().getColumn(3).setResizable(false);
            jTableDiscipline.getColumnModel().getColumn(4).setResizable(false);
            jTableDiscipline.getColumnModel().getColumn(5).setResizable(false);
            jTableDiscipline.getColumnModel().getColumn(6).setResizable(false);
            jTableDiscipline.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        jBtnSearch.setText("X");
        jBtnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchActionPerformed(evt);
            }
        });

        jBtnAdd.setBackground(new java.awt.Color(0, 143, 143));
        jBtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnAdd.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAdd.setText("+ Add");
        jBtnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnDelete.setBackground(new java.awt.Color(0, 143, 143));
        jBtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnDelete.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDelete.setText("- Delete");
        jBtnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jBtnEdit.setBackground(new java.awt.Color(0, 143, 143));
        jBtnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnEdit.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEdit.setText("! Update");
        jBtnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditActionPerformed(evt);
            }
        });

        jBtnImportExcel.setBackground(new java.awt.Color(0, 143, 143));
        jBtnImportExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnImportExcel.setForeground(new java.awt.Color(255, 255, 255));
        jBtnImportExcel.setText("Import Excel");
        jBtnImportExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnImportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnImportExcelActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("DISCIPLINE MANAGMENT");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 10, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator5)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jBtnEdit)
                            .addGap(18, 18, 18)
                            .addComponent(jBtnDelete)
                            .addGap(18, 18, 18)
                            .addComponent(jBtnImportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnImportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jBtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        // TODO add your handling code here:
        AddDiscipline addDiscipline = new AddDiscipline();
        addDiscipline.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                LoadData();
            }
        });

        addDiscipline.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addDiscipline.setLocationRelativeTo(null);
        addDiscipline.setVisible(true);

        //LoadData();
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        // TODO add your handling code here:
        int n = jTableDiscipline.getSelectedRow();
        if (n != -1) {
            if (jTableDiscipline.getValueAt(n, 6).toString().equals("0")) {
                JOptionPane.showMessageDialog(rootPane, "Has been processed");
            } else {
                EditDiscipline editDiscipline = new EditDiscipline();
                editDiscipline.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        LoadData();
                    }
                });
                editDiscipline.jMaXuLy.setText(jTableDiscipline.getValueAt(n, 0).toString());
                editDiscipline.jMaThanhVien.setText(jTableDiscipline.getValueAt(n, 1).toString() + "-" + jTableDiscipline.getValueAt(n, 2).toString());
                editDiscipline.jNgayXuLy.setText(jTableDiscipline.getValueAt(n, 5).toString());
                Object value = jTableDiscipline.getValueAt(n, 4);
                editDiscipline.jSoTien.setText(value == null ? "" : value + "");
                editDiscipline.jHinhThucXuLy.setSelectedItem(jTableDiscipline.getValueAt(n, 3).toString());
                editDiscipline.jTrangThaiXuLy.setSelectedItem(jTableDiscipline.getValueAt(n, 6).toString());
                editDiscipline.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                editDiscipline.setLocationRelativeTo(null);
                editDiscipline.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please Choose");
        }
    }//GEN-LAST:event_jBtnEditActionPerformed

    public void SearchAll() {
        if (jSearch.getText().toString().isEmpty()) {
            jBtnSearch.setVisible(false);
            LoadData();
        } else {
            jBtnSearch.setVisible(true);
            LoadData(jSearch.getText().toString());
        }
    }
    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        // TODO add your handling code here:
        int choose=jTableDiscipline.getSelectedRow();
        if(choose != -1) {
            int n = JOptionPane.showConfirmDialog(rootPane, "Do you want to delete", "Confirm", JOptionPane.YES_NO_OPTION);
            int maXL=Integer.parseInt(jTableDiscipline.getValueAt(jTableDiscipline.getSelectedRow(),0).toString());
            if (n == JOptionPane.YES_OPTION) {
                try{
                    disciplineBLL.delete(maXL);
                    JOptionPane.showMessageDialog(rootPane, "Delete Success!");
                    LoadData();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane, "Delete Fail!");
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane,"Please Choose");
        }
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnImportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnImportExcelActionPerformed
        String errs = "";// TODO add your handling code here:

        try {
            XSSFWorkbook wb = null;
            FileInputStream fileIn = null;
            JFileChooser choose = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls", "xlsx");
            choose.setFileFilter(filter);
            int excelchoose = choose.showOpenDialog(null);
            if (excelchoose == JFileChooser.APPROVE_OPTION) {
                File fl = choose.getSelectedFile();
                fileIn = new FileInputStream(fl);
                wb = new XSSFWorkbook(fileIn);
                XSSFSheet sheet = wb.getSheetAt(0);
                XSSFRow row;
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    row = sheet.getRow(i);
                    int maXL = (int) row.getCell(0).getNumericCellValue();
                    String formattedNumber = String.format("%.0f", row.getCell(1).getNumericCellValue());
                    String maTV = formattedNumber;
                    String hinhthucXL = row.getCell(2).getStringCellValue().toString();
                    int tmp = (int) row.getCell(3).getNumericCellValue();
                    Integer sotien = tmp == 0 ? null : tmp;
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String dateTime = format.format(row.getCell(4).getDateCellValue());
                    Date date = format.parse(dateTime);
                    long time = date.getTime();
                    Timestamp ngayXL = new Timestamp(time);
                    int trangthaiXL = (int) row.getCell(5).getNumericCellValue();
                    Discipline discipline = new Discipline();
                    discipline.setFine(sotien);
                    discipline.setStatus(trangthaiXL);
                    discipline.setDate(ngayXL);
                    Member member = disciplineBLL.getMember(maTV);
                    discipline.setMemberID(member);
                    discipline.setDescription(hinhthucXL);

                    disciplineBLL.insertDiscipline(discipline);
                }
                JOptionPane.showMessageDialog(null, "Data import Success");
            }
            wb.close();
            LoadData();
        } catch (Exception e) {
            errs += e.getMessage() + '\n';
        }
        if (!errs.equals("")) {
            JOptionPane.showMessageDialog(null, "Data import Fail:" + "\n" + errs);
        }
    }//GEN-LAST:event_jBtnImportExcelActionPerformed

    private void jTableDisciplineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDisciplineMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jTableDisciplineMouseClicked

    private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchActionPerformed
        // TODO add your handling code here:
        jSearch.setText("");
        jBtnSearch.setVisible(false);
    }//GEN-LAST:event_jBtnSearchActionPerformed

    public void LoadData() {
        String columns[] = new String[]{"Mã Xử Lý", "Mã Thành Viên", "Tên Thành Viên", "Hình Thức xử Lý", "Số Tiền", "Ngày Xử Lý", "Trạng Thái Xử Lý"};
        DefaultTableModel model = new DefaultTableModel();
        for (String i : columns) {
            model.addColumn(i);
        }
        for (Discipline i : disciplineBLL.selectAll()) {
            Vector t = new Vector();
            t.add(i.getId());
            t.add(i.getMemberID().getId());
            t.add(i.getMemberID().getName());
            t.add(i.getDescription());
            t.add(i.getFine());
            t.add(i.getDate());
            t.add(i.getStatus() == 0 ? "Đã xử lý" : "Chưa xử lý");
            model.addRow(t);
        }
        jTableDiscipline.setModel(model);
    }
    
    public void LoadData(String text) {
        String columns[] = new String[]{"Mã Xử Lý", "Mã Thành Viên", "Tên Thành Viên", "Hình Thức xử Lý", "Số Tiền", "Ngày Xử Lý", "Trạng Thái Xử Lý"};
        DefaultTableModel model = new DefaultTableModel();
        for (String i : columns) {
            model.addColumn(i);
        }
        for (Discipline i : disciplineBLL.search(text)) {
            Vector t = new Vector();
            t.add(i.getId());
            t.add(i.getMemberID().getId());
            t.add(i.getMemberID().getName());
            t.add(i.getDescription());
            t.add(i.getFine());
            t.add(i.getDate());
            t.add(i.getStatus() == 0 ? "Đã xử lý" : "Chưa xử lý");
            model.addRow(t);
        }
        jTableDiscipline.setModel(model);
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ManagerDiscipline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManagerDiscipline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManagerDiscipline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManagerDiscipline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManagerDiscipline().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JButton jBtnImportExcel;
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSearch;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTableDiscipline;
    // End of variables declaration//GEN-END:variables
}
