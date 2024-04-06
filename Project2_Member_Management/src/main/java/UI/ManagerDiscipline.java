/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import BLL.DisciplineBLL;
import POJOs.Discipline;
import POJOs.Member;
import com.mysql.cj.result.Row;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
public class ManagerDiscipline extends javax.swing.JFrame {
    DisciplineBLL disciplineBLL=new DisciplineBLL();
    /**
     * Creates new form ManagerViolate
     */
    public ManagerDiscipline() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableDiscipline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Xử Lý", "Mã Thành Viên", "Thành Viên", "Hình Thức Xử Lý", "Số Tiền", "Ngày Xử Lý", "Trạng Thái Xử Lý"
            }
        ));
        jTableDiscipline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDisciplineMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDiscipline);

        jBtnSearch.setText("X");
        jBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchActionPerformed(evt);
            }
        });

        jBtnAdd.setText("Add");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnDelete.setText("Delete");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jBtnEdit.setText("Edit");
        jBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditActionPerformed(evt);
            }
        });

        jBtnImportExcel.setText("Import Excel");
        jBtnImportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnImportExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 250, Short.MAX_VALUE)
                .addComponent(jBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnImportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
            .addGroup(layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jBtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnImportExcel)
                    .addComponent(jBtnDelete)
                    .addComponent(jBtnAdd)
                    .addComponent(jBtnEdit))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        // TODO add your handling code here:
        AddDiscipline addDiscipline=new AddDiscipline();
        addDiscipline.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
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
        int n=jTableDiscipline.getSelectedRow();
        if(n!=-1){
            if(jTableDiscipline.getValueAt(n,6).toString().equals("0")){
            JOptionPane.showMessageDialog(rootPane,"Has been processed");
            }else{
                    EditDiscipline editDiscipline=new EditDiscipline();
                    editDiscipline.addWindowListener(new WindowAdapter(){
                        @Override
                        public void windowClosing(WindowEvent e){
                            LoadData();
                        }
                    });
                    editDiscipline.jMaXuLy.setText(jTableDiscipline.getValueAt(n,0).toString());
                    editDiscipline.jMaThanhVien.setText(jTableDiscipline.getValueAt(n,1).toString()+"-"+jTableDiscipline.getValueAt(n,2).toString());
                    editDiscipline.jNgayXuLy.setText(jTableDiscipline.getValueAt(n,5).toString());
                    Object value = jTableDiscipline.getValueAt(n, 4);
                    editDiscipline.jSoTien.setText(value==null?"":value+"");
                    editDiscipline.jHinhThucXuLy.setSelectedItem(jTableDiscipline.getValueAt(n,3).toString());
                    editDiscipline.jTrangThaiXuLy.setSelectedItem(jTableDiscipline.getValueAt(n,6).toString());
                    editDiscipline.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    editDiscipline.setLocationRelativeTo(null);
                    editDiscipline.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane,"Please Choose");
        }
    }//GEN-LAST:event_jBtnEditActionPerformed

    public void SearchAll(){
        if(jSearch.getText().toString().isEmpty()){
            LoadData();
        }else{
            jBtnSearch.setVisible(true);
            LoadData(jSearch.getText().toString());
        }
    }
    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        // TODO add your handling code here:
        if(jTableDiscipline.getValueAt(jTableDiscipline.getSelectedRow(),6).toString().equals("1")){
            
        }else{
            JOptionPane.showMessageDialog(rootPane,"Not processed yet!");
        }
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnImportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnImportExcelActionPerformed
        // TODO add your handling code here:
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
                          int maXL=(int)row.getCell(0).getNumericCellValue();
                          String formattedNumber = String.format("%.0f", row.getCell(1).getNumericCellValue());
                          String maTV=formattedNumber;
                          String hinhthucXL=row.getCell(2).getStringCellValue().toString();
                          int tmp=(int)row.getCell(3).getNumericCellValue();
                          Integer sotien=tmp==0?null:tmp;
                          SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                          String dateTime=format.format(row.getCell(4).getDateCellValue());
                          Date date=format.parse(dateTime);
                          long time=date.getTime();
                          Timestamp ngayXL=new Timestamp(time);
                          int trangthaiXL=(int)row.getCell(5).getNumericCellValue();
                          Discipline discipline=new Discipline();
                          discipline.setFine(sotien);
                          discipline.setStatus(trangthaiXL);
                          discipline.setDate(ngayXL);
                          Member member=new Member();
                          member.setId(maTV);
                          discipline.setMemberID(member);
                          discipline.setDescription(hinhthucXL);
                          disciplineBLL.insertDiscipline(discipline);
                          LoadData();
                    }
                }
                //formklp.LoadDataLopHoc(formklp.getTblophoc());
                JOptionPane.showMessageDialog(null, "Data import Success");
                wb.close();
                //LoadData();
            } catch (Exception u) {
                u.printStackTrace();
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

    public void LoadData(){ 
        String columns[]=new String[]{"Mã Xử Lý","Mã Thành Viên","Tên Thành Viên","Hình Thức xử Lý","Số Tiền","Ngày Xử Lý","Trạng Thái Xử Lý"};
        DefaultTableModel model=new DefaultTableModel();
        for(String i:columns){
            model.addColumn(i);
        }
        for(Discipline i:disciplineBLL.selectAll()){
            Vector t=new Vector();
            t.add(i.getId());
            t.add(i.getMemberID().getId());
            t.add(i.getMemberID().getName());
            t.add(i.getDescription());
            t.add(i.getFine());
            t.add(i.getDate());
            t.add(i.getStatus());
            model.addRow(t);
        }
        jTableDiscipline.setModel(model);
    }
    public void LoadData(String text){ 
        String columns[]=new String[]{"Mã Xử Lý","Mã Thành Viên","Tên Thành Viên","Hình Thức xử Lý","Số Tiền","Ngày Xử Lý","Trạng Thái Xử Lý"};
        DefaultTableModel model=new DefaultTableModel();
        for(String i:columns){
            model.addColumn(i);
        }
        for(Discipline i:disciplineBLL.search(text)){
            Vector t=new Vector();
            t.add(i.getId());
            t.add(i.getMemberID().getId());
            t.add(i.getMemberID().getName());
            t.add(i.getDescription());
            t.add(i.getFine());
            t.add(i.getDate());
            t.add(i.getStatus());
            model.addRow(t);
        }
        jTableDiscipline.setModel(model);
    }
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerDiscipline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerDiscipline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerDiscipline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerDiscipline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerDiscipline().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JButton jBtnImportExcel;
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSearch;
    private javax.swing.JTable jTableDiscipline;
    // End of variables declaration//GEN-END:variables
}
