/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.MemberManagement;

import BLL.DeviceBLL;
import BLL.UsageBLL;
import POJOs.Device;
import POJOs.Member;
import POJOs.Usage;
import Utils.sharedFunction;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.time.Instant;

/**
 *
 * @author ASUS
 */
public class BorrowNewDeviceFrame extends javax.swing.JFrame {

    private BorrowDeviceFrame bdf;
    private final UsageBLL usageBLL = new UsageBLL();
    private final sharedFunction func = new sharedFunction();
    private final DeviceBLL deviceBLL = new DeviceBLL();

    /**
     * Creates new form BorrowNewDeviceFrame
     */
    public BorrowNewDeviceFrame(BorrowDeviceFrame bdf) {
        this.bdf = bdf;
        initComponents();
        readAvailableDevices();
    }

    private void readAvailableDevices() {
        List<Device> availableDevices = usageBLL.selectAvailableDevices();
        DefaultTableModel model = (DefaultTableModel) tblAvailableDevices.getModel();
        model.setRowCount(0);

        int STT = 1;
        for (Device device : availableDevices)
        {
            int deviceID = device.getId();
            String deviceName = device.getName();
            String deviceDes = device.getDescription();

            Object[] row
                    =
                    {
                        STT++, deviceID, deviceName, deviceDes
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAvailableDevices = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        addDevice = new javax.swing.JButton();
        removeDevice = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSelectedDevices = new javax.swing.JTable();
        saveBorrowedDevices = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Borrow new devices");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("LIST OF AVAILABLE DEVICES");

        tblAvailableDevices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "ID", "Name", "Description"
            }
        ));
        tblAvailableDevices.setRowHeight(30);
        tblAvailableDevices.setShowGrid(true);
        jScrollPane1.setViewportView(tblAvailableDevices);
        if (tblAvailableDevices.getColumnModel().getColumnCount() > 0) {
            tblAvailableDevices.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblAvailableDevices.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblAvailableDevices.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblAvailableDevices.getColumnModel().getColumn(3).setPreferredWidth(220);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        addDevice.setBackground(new java.awt.Color(0, 143, 143));
        addDevice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addDevice.setForeground(new java.awt.Color(255, 255, 255));
        addDevice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chevron-18-down.png"))); // NOI18N
        addDevice.setText("Add ");
        addDevice.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        addDevice.setIconTextGap(10);
        addDevice.setPreferredSize(new java.awt.Dimension(120, 40));
        addDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeviceActionPerformed(evt);
            }
        });
        jPanel2.add(addDevice);

        removeDevice.setBackground(new java.awt.Color(241, 51, 51));
        removeDevice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        removeDevice.setForeground(new java.awt.Color(255, 255, 255));
        removeDevice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chevron-18-up.png"))); // NOI18N
        removeDevice.setText("Delete");
        removeDevice.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        removeDevice.setIconTextGap(10);
        removeDevice.setPreferredSize(new java.awt.Dimension(120, 40));
        removeDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDeviceActionPerformed(evt);
            }
        });
        jPanel2.add(removeDevice);

        tblSelectedDevices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "ID", "Name", "Description"
            }
        ));
        tblSelectedDevices.setRowHeight(30);
        tblSelectedDevices.setShowGrid(true);
        jScrollPane2.setViewportView(tblSelectedDevices);
        if (tblSelectedDevices.getColumnModel().getColumnCount() > 0) {
            tblSelectedDevices.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblSelectedDevices.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblSelectedDevices.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblSelectedDevices.getColumnModel().getColumn(3).setPreferredWidth(220);
        }

        saveBorrowedDevices.setBackground(new java.awt.Color(0, 143, 143));
        saveBorrowedDevices.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveBorrowedDevices.setForeground(new java.awt.Color(255, 255, 255));
        saveBorrowedDevices.setText("Save");
        saveBorrowedDevices.setPreferredSize(new java.awt.Dimension(120, 40));
        saveBorrowedDevices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBorrowedDevicesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(saveBorrowedDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveBorrowedDevices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void addDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDeviceActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAvailableDevices.getSelectedRow();
        if (selectedRow == -1)
        {
            func.displayErrorMessage("Please select a device !!");
        } else
        {
            DefaultTableModel model = (DefaultTableModel) tblSelectedDevices.getModel();
            int STT = model.getRowCount() + 1;

            // get data from selected row
            Object ID = tblAvailableDevices.getValueAt(selectedRow, 1);
            Object Name = tblAvailableDevices.getValueAt(selectedRow, 2);
            Object Description = tblAvailableDevices.getValueAt(selectedRow, 3);

            Object[] selectedData =
            {
                STT, ID, Name, Description
            };

            // check existed
            for (int i = 0; i < model.getRowCount(); i++)
            {
                Object existedID = model.getValueAt(i, 1);
                if (existedID == ID)
                {
                    func.displayErrorMessage("Device has selected");
                    return;
                }
            }

            model.addRow(selectedData);
            model.fireTableDataChanged();
        }
    }//GEN-LAST:event_addDeviceActionPerformed

    private void removeDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDeviceActionPerformed
        // TODO add your handling code here:
        int rowCount = tblSelectedDevices.getRowCount();
        if (rowCount < 1)
        {
            func.displayErrorMessage("Selected device table is empty !!");
            return;
        }
        int selectedRow = tblSelectedDevices.getSelectedRow();
        if (selectedRow == -1)
        {
            func.displayErrorMessage("Please choose a selected device !!");
        } else
        {
            DefaultTableModel model = (DefaultTableModel) tblSelectedDevices.getModel();

            model.removeRow(selectedRow);

            // reset No.
            int STT = 1;
            for (int i = 0; i < model.getRowCount(); i++)
            {
                model.setValueAt(STT++, i, 0);
            }
            model.fireTableDataChanged();

        }
    }//GEN-LAST:event_removeDeviceActionPerformed

    private void saveBorrowedDevicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBorrowedDevicesActionPerformed
        // TODO add your handling code here:
        Member currentMember = bdf.getCurrentMember();

        int totalDevices = tblSelectedDevices.getRowCount();
        if (totalDevices < 1)
        {
            func.displayErrorMessage("Selected device table is empty !!");
            return;
        }

        for (int i = 0; i < totalDevices; i++)
        {
            int devceID = Integer.parseInt(tblSelectedDevices.getValueAt(i, 1).toString());
            Device device = deviceBLL.getDeviceById(devceID);

            Instant nowInstant = Instant.now();

            Timestamp currentTimestamp = Timestamp.from(nowInstant);

            Usage usage = new Usage();
            usage.setMember(currentMember);
            usage.setDevice(device);
            usage.setBorrowedTime(currentTimestamp);

            usageBLL.insert(usage);
        }
        this.dispose();
        bdf.updateTable();
        func.displayConfirmMessage("Device borrowed successfully!!");
    }//GEN-LAST:event_saveBorrowedDevicesActionPerformed

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
            java.util.logging.Logger.getLogger(BorrowNewDeviceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(BorrowNewDeviceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(BorrowNewDeviceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(BorrowNewDeviceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new BorrowNewDeviceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDevice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton removeDevice;
    private javax.swing.JButton saveBorrowedDevices;
    private javax.swing.JTable tblAvailableDevices;
    private javax.swing.JTable tblSelectedDevices;
    // End of variables declaration//GEN-END:variables
}
