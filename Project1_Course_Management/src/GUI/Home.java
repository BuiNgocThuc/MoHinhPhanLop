/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUi;


import GUI.AssignmentManagement.CourseInstrutorPanel;
import GUI.CourseInfo.CoursePanel;
import GUI.CourseInfo.CourseResultsPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private final Color yellow = new Color(255, 188, 0);
    private final Color lightBlue = new Color(0, 158, 248);
    private final Color darkBlue = new Color(0, 158, 248);

    private final Color lightGray = new Color(242, 242, 242);
//    private final OnsiteCoursePanel onsiteCoursePanel = new OnsiteCoursePanel();
//    private final OnlineCoursePanel onlineCoursePanel = new OnlineCoursePanel();
    private CourseInstrutorPanel courseInstrutorPanel = null;
    ;
    private final CoursePanel coursePanel = new CoursePanel();
    private final CourseResultsPanel courseResultPanel = new CourseResultsPanel();

    private boolean dropdownToggle = false;
    private JButton currentBtn = null;
    private final ArrayList<JButton> allBtnLeftBar = new ArrayList<>();
    private final ArrayList<JButton> allBtnLeftSubBar = new ArrayList<>();
    

    public Home() {
        try {
            this.courseInstrutorPanel = new CourseInstrutorPanel();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi hệ thống");
        }

        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/icons8-graduate-60.png")));
        allBtnLeftBar.addAll(Arrays.asList(courseBtn, scheduleBtn, resultBtn));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebarMenu = new javax.swing.JPanel();
        courseBtn = new javax.swing.JButton();
        scheduleBtn = new javax.swing.JButton();
        resultBtn = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        startPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Course Management");

        sidebarMenu.setPreferredSize(new java.awt.Dimension(250, 653));
        sidebarMenu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        courseBtn.setBackground(new java.awt.Color(242, 242, 242));
        courseBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        courseBtn.setText("Course Management");
        courseBtn.setToolTipText("");
        courseBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 15));
        courseBtn.setBorderPainted(false);
        courseBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        courseBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        courseBtn.setIconTextGap(110);
        courseBtn.setOpaque(true);
        courseBtn.setPreferredSize(new java.awt.Dimension(250, 56));
        courseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseBtnActionPerformed(evt);
            }
        });
        sidebarMenu.add(courseBtn);

        scheduleBtn.setBackground(new java.awt.Color(242, 242, 242));
        scheduleBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        scheduleBtn.setText("Assignment Management");
        scheduleBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 15));
        scheduleBtn.setBorderPainted(false);
        scheduleBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        scheduleBtn.setPreferredSize(new java.awt.Dimension(250, 56));
        scheduleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleBtnActionPerformed(evt);
            }
        });
        sidebarMenu.add(scheduleBtn);

        resultBtn.setBackground(new java.awt.Color(242, 242, 242));
        resultBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resultBtn.setText("Course Result Management");
        resultBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 15));
        resultBtn.setBorderPainted(false);
        resultBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        resultBtn.setPreferredSize(new java.awt.Dimension(250, 56));
        resultBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultBtnActionPerformed(evt);
            }
        });
        sidebarMenu.add(resultBtn);

        getContentPane().add(sidebarMenu, java.awt.BorderLayout.LINE_START);

        cardPanel.setLayout(new java.awt.CardLayout());
        startPanel.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/banner (2).png"))); // NOI18N
        javax.swing.GroupLayout startPanelLayout = new javax.swing.GroupLayout(startPanel);
        startPanel.setLayout(startPanelLayout);
        startPanelLayout.setHorizontalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))

        );
        startPanelLayout.setVerticalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        cardPanel.add(startPanel, "card4");

        getContentPane().add(cardPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void courseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseBtnActionPerformed
        cardPanel.removeAll();
        cardPanel.add(coursePanel);
        cardPanel.repaint();
        cardPanel.revalidate();
        coursePanel.getDetailCoursePanel().setVisible(false);
        setBackgroundDefaultAllButton();
        courseBtn.setBackground(lightBlue);
    }//GEN-LAST:event_courseBtnActionPerformed

    private void scheduleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleBtnActionPerformed

        cardPanel.removeAll();
        cardPanel.add(courseInstrutorPanel);
        cardPanel.repaint();
        cardPanel.revalidate();
        setBackgroundDefaultAllButton();
        scheduleBtn.setBackground(lightBlue);
//        switchPanel(schedulePanel,scheduleBtn);

    }//GEN-LAST:event_scheduleBtnActionPerformed

    private void resultBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultBtnActionPerformed
        cardPanel.removeAll();
        cardPanel.add(courseResultPanel);
        cardPanel.repaint();
        cardPanel.revalidate();
        setBackgroundDefaultAllButton();
        resultBtn.setBackground(lightBlue);
    }//GEN-LAST:event_resultBtnActionPerformed

    public void setBackgroundDefaultAllButton() {
        for (JButton btn : allBtnLeftBar) {
            btn.setBackground(lightGray);
        }
        for (JButton btn : allBtnLeftSubBar) {
            btn.setBackground(Color.BLACK);
        }
    }

    private void switchPanel(Component panel, JButton btn) {
        cardPanel.removeAll();
        cardPanel.add(panel);
        cardPanel.repaint();
        cardPanel.revalidate();
        setBackgroundDefaultAllButton();
        btn.setBackground(lightBlue);
        courseBtn.setIcon(new ImageIcon(getClass().getResource("/assets/icons8-arrow-down-20.png")));
        dropdownToggle = false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton courseBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton resultBtn;
    private javax.swing.JButton scheduleBtn;
    private javax.swing.JPanel schedulePanel;
    private javax.swing.JPanel sidebarMenu;
    private javax.swing.JPanel startPanel;
    // End of variables declaration//GEN-END:variables
}
