/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.MainPanel;

/**
 *
 * @author Bao
 */
import javax.swing.*;
import java.awt.*;

public class AssigmentDetail extends JFrame {

    private JPanel assignmentInfoPanel;
    private JLabel classIdLabel;
    private JLabel classNameLabel;
    private JButton closeButton;
    private JPanel containerPanel;
    private JLabel courseIdLabel;
    private JLabel courseNameLabel;
    private JPanel infoPanel;
    private JSeparator jSeparator1;
    private JLabel lecturersIdLabel;
    private JLabel lecturersNameLabel;
    private JLabel titleLabel;
    private JPanel titlePanel;

    /**
     * Creates new form AssigmentDetail
     */
    public AssigmentDetail() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerPanel = new JPanel();
        assignmentInfoPanel = new JPanel();
        titlePanel = new JPanel();
        titleLabel = new JLabel();
        jSeparator1 = new JSeparator();
        infoPanel = new JPanel();
        lecturersIdLabel = new JLabel();
        lecturersNameLabel = new JLabel();
        courseIdLabel = new JLabel();
        courseNameLabel = new JLabel();
        classIdLabel = new JLabel();
        classNameLabel = new JLabel();
        closeButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        containerPanel.setBackground(new Color(255, 255, 255));
        containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        assignmentInfoPanel.setBackground(new Color(255, 255, 255));

        titlePanel.setBackground(new Color(255, 255, 255));

        titleLabel.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
        titleLabel.setText("CHI TIẾT PHÂN CÔNG");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

        GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(titlePanelLayout.createSequentialGroup()
                                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(211, Short.MAX_VALUE)));
        titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE));

        infoPanel.setBackground(new Color(255, 255, 255));
        infoPanel.setBorder(BorderFactory.createLineBorder(new Color(206, 206, 206)));
        infoPanel.setPreferredSize(new Dimension(0, 62));

        lecturersIdLabel.setText("Mã Giảng Viên");

        lecturersNameLabel.setText("Tên Giảng Viên");

        courseIdLabel.setText("Mã Môn Học");

        courseNameLabel.setText("Tên Môn Học");

        classIdLabel.setText("Mã Lớp");

        classNameLabel.setText("Tên Lớp");

        GroupLayout infoPanelLayout = new GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
                infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lecturersIdLabel, GroupLayout.PREFERRED_SIZE, 200,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courseNameLabel, GroupLayout.PREFERRED_SIZE, 200,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courseIdLabel, GroupLayout.PREFERRED_SIZE, 200,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lecturersNameLabel, GroupLayout.PREFERRED_SIZE, 200,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(classIdLabel, GroupLayout.PREFERRED_SIZE, 200,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(classNameLabel, GroupLayout.PREFERRED_SIZE, 200,
                                                GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        infoPanelLayout.setVerticalGroup(
                infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(lecturersIdLabel, GroupLayout.PREFERRED_SIZE, 30,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lecturersNameLabel, GroupLayout.PREFERRED_SIZE, 30,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(courseIdLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(courseNameLabel, GroupLayout.PREFERRED_SIZE, 30,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(classIdLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(classNameLabel, GroupLayout.PREFERRED_SIZE, 30,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(71, Short.MAX_VALUE)));

        GroupLayout assignmentInfoPanelLayout = new GroupLayout(assignmentInfoPanel);
        assignmentInfoPanel.setLayout(assignmentInfoPanelLayout);
        assignmentInfoPanelLayout.setHorizontalGroup(
                assignmentInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                        .addComponent(jSeparator1));
        assignmentInfoPanelLayout.setVerticalGroup(
                assignmentInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(assignmentInfoPanelLayout.createSequentialGroup()
                                .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        closeButton.setText("Đóng");

        GroupLayout containerPanelLayout = new GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
                containerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(assignmentInfoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(containerPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(closeButton)));
        containerPanelLayout.setVerticalGroup(
                containerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, containerPanelLayout.createSequentialGroup()
                                .addComponent(assignmentInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(closeButton)
                                .addContainerGap(19, Short.MAX_VALUE)));

        getContentPane().add(containerPanel, BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AssigmentDetail.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssigmentDetail.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssigmentDetail.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssigmentDetail.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssigmentDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables

    // End of variables declaration//GEN-END:variables
}
