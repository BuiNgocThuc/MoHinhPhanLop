/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUi;

import GUI.MainPanel.CoursePanel;
import GUI.MainPanel.CourseResultsPanel;
import GUI.MainPanel.OnlineCoursePanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;
import GUI.MainPanel.OnsiteCoursePanel;
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
    private final Color lightGray = new Color(242,242,242);
    private final OnsiteCoursePanel onsiteCoursePanel = new OnsiteCoursePanel();
    private final OnlineCoursePanel onlineCoursePanel = new OnlineCoursePanel();
    private final CoursePanel coursePanel = new CoursePanel();
    private final CourseResultsPanel courseResultPanel = new CourseResultsPanel();
    private boolean dropdownToggle = false;
    private JButton currentBtn = null;
    private final ArrayList<JButton> allBtnLeftBar = new ArrayList<>();
    private final ArrayList<JButton> allBtnLeftSubBar = new ArrayList<>();

    public Home() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/icons8-graduate-60.png")));
        allBtnLeftBar.addAll(Arrays.asList(courseBtn, scheduleBtn, resultBtn));
        allBtnLeftSubBar.addAll(Arrays.asList(onlineCourseBtn, onsiteCourseBtn));
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
        dropdownCourses = new javax.swing.JPanel();
        onsiteCourseBtn = new javax.swing.JButton();
        onlineCourseBtn = new javax.swing.JButton();
        scheduleBtn = new javax.swing.JButton();
        resultBtn = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        schedulePanel = new javax.swing.JPanel();
        resultPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Course Management");

        sidebarMenu.setPreferredSize(new java.awt.Dimension(250, 653));
        sidebarMenu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        courseBtn.setBackground(new java.awt.Color(242, 242, 242));
        courseBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        courseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-arrow-down-20.png"))); // NOI18N
        courseBtn.setText("Các khóa học");
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

        dropdownCourses.setBackground(new java.awt.Color(0, 0, 0));
        dropdownCourses.setOpaque(false);
        dropdownCourses.setPreferredSize(new java.awt.Dimension(0, 0));
        dropdownCourses.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        onsiteCourseBtn.setBackground(new java.awt.Color(0, 0, 0));
        onsiteCourseBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        onsiteCourseBtn.setForeground(new java.awt.Color(255, 255, 255));
        onsiteCourseBtn.setText("Khóa học onsite");
        onsiteCourseBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 15));
        onsiteCourseBtn.setBorderPainted(false);
        onsiteCourseBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        onsiteCourseBtn.setOpaque(true);
        onsiteCourseBtn.setPreferredSize(new java.awt.Dimension(250, 56));
        onsiteCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onsiteCourseBtnActionPerformed(evt);
            }
        });
        dropdownCourses.add(onsiteCourseBtn);

        onlineCourseBtn.setBackground(new java.awt.Color(0, 0, 0));
        onlineCourseBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        onlineCourseBtn.setForeground(new java.awt.Color(255, 255, 255));
        onlineCourseBtn.setText("Khóa học online");
        onlineCourseBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 15));
        onlineCourseBtn.setBorderPainted(false);
        onlineCourseBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        onlineCourseBtn.setOpaque(true);
        onlineCourseBtn.setPreferredSize(new java.awt.Dimension(250, 56));
        onlineCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlineCourseBtnActionPerformed(evt);
            }
        });
        dropdownCourses.add(onlineCourseBtn);

        sidebarMenu.add(dropdownCourses);

        scheduleBtn.setBackground(new java.awt.Color(242, 242, 242));
        scheduleBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        scheduleBtn.setText("Lịch phân công");
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
        resultBtn.setText("Kết quả khóa học");
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

        schedulePanel.setBackground(new java.awt.Color(51, 204, 255));

        javax.swing.GroupLayout schedulePanelLayout = new javax.swing.GroupLayout(schedulePanel);
        schedulePanel.setLayout(schedulePanelLayout);
        schedulePanelLayout.setHorizontalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        schedulePanelLayout.setVerticalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        cardPanel.add(schedulePanel, "card5");

        resultPanel.setBackground(new java.awt.Color(0, 255, 153));

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        cardPanel.add(resultPanel, "card4");

        getContentPane().add(cardPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void courseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseBtnActionPerformed
        toggleDropdown();
        cardPanel.removeAll();
        cardPanel.add(coursePanel);
        cardPanel.repaint();
        cardPanel.revalidate();
        setBackgroundDefaultAllButton();
        courseBtn.setBackground(lightBlue);
    }//GEN-LAST:event_courseBtnActionPerformed

    private void scheduleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleBtnActionPerformed

        switchPanel(schedulePanel,scheduleBtn);

    }//GEN-LAST:event_scheduleBtnActionPerformed

    private void resultBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultBtnActionPerformed
        cardPanel.removeAll();
        cardPanel.add(courseResultPanel);
        cardPanel.repaint();
        cardPanel.revalidate();
        setBackgroundDefaultAllButton();
        resultBtn.setBackground(lightBlue);
    }//GEN-LAST:event_resultBtnActionPerformed

    private void onsiteCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onsiteCourseBtnActionPerformed
        // TODO add your handling code here:
        cardPanel.removeAll();
        cardPanel.add(onsiteCoursePanel);
        cardPanel.repaint();
        cardPanel.revalidate();
        onsiteCoursePanel.getEditOnsiteCoursePanel().setVisible(false);
        setBackgroundDefaultAllButton();
        onsiteCourseBtn.setBackground(lightBlue);
    }//GEN-LAST:event_onsiteCourseBtnActionPerformed

    private void onlineCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlineCourseBtnActionPerformed
        // TODO add your handling code here:
        cardPanel.removeAll();
        cardPanel.add(onlineCoursePanel);
        onlineCoursePanel.getEditOnsiteCoursePanel().setVisible(false);
        cardPanel.repaint();
        cardPanel.revalidate();
        setBackgroundDefaultAllButton();
        onlineCourseBtn.setBackground(lightBlue);
    }//GEN-LAST:event_onlineCourseBtnActionPerformed

    public void openMenu() {
        int initialHeight = dropdownCourses.getPreferredSize().height; // Change to height
        int steps = 100 / 10; // 10 ms interval between each step
        int stepHeight = 250 / steps; // Change to height

        Timer timer = new Timer(10, new ActionListener() {
            int currentHeight = initialHeight; // Change to height

            @Override
            public void actionPerformed(ActionEvent e) {
                currentHeight += stepHeight; // Change to height
                if (currentHeight >= 112) {
                    currentHeight = 112;
                    ((Timer) e.getSource()).stop();
                }
                Dimension newPreferredSize = new Dimension(250, currentHeight); // Change to height
                dropdownCourses.setPreferredSize(newPreferredSize);
                dropdownCourses.revalidate();
            }
        });
        timer.start();
    }

    public void closeMenu() {
        int initialHeight = dropdownCourses.getPreferredSize().height;
        int steps = 100 / 10; // 10 ms interval between each step
        int stepWidth = initialHeight / steps;

        Timer timer = new Timer(10, new ActionListener() {
            int currentHeight = initialHeight;

            @Override
            public void actionPerformed(ActionEvent e) {
                currentHeight -= stepWidth;
                if (currentHeight <= 0) {
                    currentHeight = 0;
                    ((Timer) e.getSource()).stop();
                }
                Dimension newPreferredSize = new Dimension(250, currentHeight);
                dropdownCourses.setPreferredSize(newPreferredSize);
                dropdownCourses.revalidate();
            }
        });
        timer.start();
    }

    public void setBackgroundDefaultAllButton() {
        for (JButton btn : allBtnLeftBar) {
            btn.setBackground(lightGray);
        }
        for (JButton btn : allBtnLeftSubBar) {
            btn.setBackground(Color.BLACK);
        }
    }

    private void toggleDropdown() {
    dropdownToggle = !dropdownToggle;
    if (dropdownToggle) {
        courseBtn.setIcon(new ImageIcon(getClass().getResource("/assets/icons8-arrow-up-20.png")));
        openMenu();
    } else {
        courseBtn.setIcon(new ImageIcon(getClass().getResource("/assets/icons8-arrow-down-20.png")));
        closeMenu();
    }
}
    
    private void switchPanel(Component panel,JButton btn) {
        cardPanel.removeAll();
        cardPanel.add(panel);
        cardPanel.repaint();
        cardPanel.revalidate();
        setBackgroundDefaultAllButton();
        btn.setBackground(lightBlue);
        courseBtn.setIcon(new ImageIcon(getClass().getResource("/assets/icons8-arrow-down-20.png")));
        dropdownToggle = false;
        closeMenu();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton courseBtn;
    private javax.swing.JPanel dropdownCourses;
    private javax.swing.JButton onlineCourseBtn;
    private javax.swing.JButton onsiteCourseBtn;
    private javax.swing.JButton resultBtn;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JButton scheduleBtn;
    private javax.swing.JPanel schedulePanel;
    private javax.swing.JPanel sidebarMenu;
    // End of variables declaration//GEN-END:variables
}
