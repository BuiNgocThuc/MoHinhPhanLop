/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import UI.Device.DevicePanel;
import UI.Discipline.ManageDiscipline;
import UI.MemberManagement.MemberPanel;
import UI.StatisticsManagement.StatisticsPanel;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ASUS
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private final Color darkGreen = new Color(0, 143, 143);
    private final ArrayList<JButton> allBtnLeftBar = new ArrayList<>();
    private final ArrayList<JButton> allBtnLeftSubBar = new ArrayList<>();
    private final MemberPanel memberPanel = new MemberPanel();
    private final StatisticsPanel statisticsPanel = new StatisticsPanel();
    private final DevicePanel devicePanel = new DevicePanel();
    private final ManageDiscipline disciplinePanel = new ManageDiscipline();
    private final int heightBar = 150;

    public Home() {
        initComponents();
        allBtnLeftBar.addAll(Arrays.asList(memberBtn, deviceBtn, punishBtn, statisticsBtn));
        switchPanel(memberPanel, memberBtn);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        container = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        memberBtn = new javax.swing.JButton();
        deviceBtn = new javax.swing.JButton();
        punishBtn = new javax.swing.JButton();
        statisticsBtn = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        devicePnl = new javax.swing.JPanel();
        punishPnl = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Member App");
        setBackground(new java.awt.Color(255, 255, 255));

        container.setBackground(new java.awt.Color(255, 255, 255));

        sideBar.setBackground(new java.awt.Color(255, 255, 255));
        sideBar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(204, 204, 204)));
        sideBar.setPreferredSize(new java.awt.Dimension(220, 693));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0);
        flowLayout1.setAlignOnBaseline(true);
        sideBar.setLayout(flowLayout1);

        memberBtn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        memberBtn.setText("Member Management");
        memberBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 0));
        memberBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        memberBtn.setOpaque(true);
        memberBtn.setPreferredSize(new java.awt.Dimension(219, 50));
        memberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberBtnActionPerformed(evt);
            }
        });
        sideBar.add(memberBtn);

        deviceBtn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        deviceBtn.setText("Device Management");
        deviceBtn.setToolTipText("");
        deviceBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 0));
        deviceBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        deviceBtn.setIconTextGap(12);
        deviceBtn.setOpaque(true);
        deviceBtn.setPreferredSize(new java.awt.Dimension(219, 50));
        deviceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deviceBtnActionPerformed(evt);
            }
        });
        sideBar.add(deviceBtn);

        punishBtn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        punishBtn.setText("Punish Management");
        punishBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 0));
        punishBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        punishBtn.setOpaque(true);
        punishBtn.setPreferredSize(new java.awt.Dimension(219, 50));
        punishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                punishBtnActionPerformed(evt);
            }
        });
        sideBar.add(punishBtn);

        statisticsBtn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        statisticsBtn.setText("Statistics Management");
        statisticsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 0));
        statisticsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statisticsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        statisticsBtn.setIconTextGap(50);
        statisticsBtn.setOpaque(true);
        statisticsBtn.setPreferredSize(new java.awt.Dimension(219, 50));
        statisticsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsBtnActionPerformed(evt);
            }
        });
        sideBar.add(statisticsBtn);

        cardPanel.setLayout(new java.awt.CardLayout());

        devicePnl.setBackground(new java.awt.Color(255, 102, 255));

        javax.swing.GroupLayout devicePnlLayout = new javax.swing.GroupLayout(devicePnl);
        devicePnl.setLayout(devicePnlLayout);
        devicePnlLayout.setHorizontalGroup(
            devicePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 866, Short.MAX_VALUE)
        );
        devicePnlLayout.setVerticalGroup(
            devicePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );

        cardPanel.add(devicePnl, "card3");

        punishPnl.setBackground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout punishPnlLayout = new javax.swing.GroupLayout(punishPnl);
        punishPnl.setLayout(punishPnlLayout);
        punishPnlLayout.setHorizontalGroup(
            punishPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 866, Short.MAX_VALUE)
        );
        punishPnlLayout.setVerticalGroup(
            punishPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );

        cardPanel.add(punishPnl, "card4");

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deviceBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deviceBtnActionPerformed
        switchPanel(devicePanel, deviceBtn);

    }// GEN-LAST:event_deviceBtnActionPerformed

    private void statisticsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsBtnActionPerformed
        switchPanel(statisticsPanel, statisticsBtn);
    }//GEN-LAST:event_statisticsBtnActionPerformed
    private void memberBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_memberBtnActionPerformed
        switchPanel(memberPanel, memberBtn);
    }// GEN-LAST:event_memberBtnActionPerformed
    private void punishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_punishBtnActionPerformed
        switchPanel(punishPnl, punishBtn);
    }//GEN-LAST:event_punishBtnActionPerformed
//    private void punishBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_punishBtnActionPerformed
//        switchPanel(disciplinePanel, punishBtn);
//    }// GEN-LAST:event_punishBtnActionPerformed

    public void setBackgroundDefaultAllButton() {
        for (JButton btn : allBtnLeftBar) {
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.BLACK);
        }
        for (JButton btn : allBtnLeftSubBar) {
            btn.setBackground(Color.BLACK);
            btn.setForeground(Color.BLACK);
        }
    }

    private void switchPanel(Component panel, JButton btn) {
        cardPanel.removeAll();
        cardPanel.add(panel);
        cardPanel.repaint();
        cardPanel.revalidate();
        setBackgroundDefaultAllButton();
        btn.setBackground(darkGreen);
        btn.setForeground(Color.WHITE);

    }

//    private void toggleDropdown() {
//        dropdownToggle = !dropdownToggle;
//        if (dropdownToggle) {
//            statisticsBtn.setIcon(new ImageIcon(getClass().getResource("/images/icons8-arrow-up-20.png")));
//            openMenu();
//        } else {
//            statisticsBtn.setIcon(new ImageIcon(getClass().getResource("/images/icons8-arrow-down-20.png")));
//            closeMenu();
//        }
//    }
//    public void openMenu() {
//        int initialHeight = subBarStat.getPreferredSize().height;
//        int steps = 100 / 10; // 10 ms interval between each step
//        int stepHeight = heightBar / steps;
//
//        Timer timer = new Timer(10, new ActionListener() {
//            int currentHeight = initialHeight;
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                currentHeight += stepHeight;
//                if (currentHeight >= heightBar) {
//                    currentHeight = heightBar;
//                    ((Timer) e.getSource()).stop();
//                }
//                Dimension newPreferredSize = new Dimension(220, currentHeight);
//                subBarStat.setPreferredSize(newPreferredSize);
//                subBarStat.revalidate();
//            }
//        });
//        timer.start();
//    }
//    public void closeMenu() {
//        int initialHeight = subBarStat.getPreferredSize().height;
//        int steps = 100 / 10; // 10 ms interval between each step
//        int stepHeight = initialHeight / steps;
//
//        Timer timer = new Timer(10, new ActionListener() {
//            int currentHeight = initialHeight;
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                currentHeight -= stepHeight;
//                if (currentHeight <= 0) {
//                    currentHeight = 0;
//                    ((Timer) e.getSource()).stop();
//                }
//                Dimension newPreferredSize = new Dimension(220, currentHeight);
//                subBarStat.setPreferredSize(newPreferredSize);
//                subBarStat.revalidate();
//            }
//        });
//        timer.start();
//    }
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
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel container;
    private javax.swing.JButton deviceBtn;
    private javax.swing.JPanel devicePnl;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton memberBtn;
    private javax.swing.JButton punishBtn;
    private javax.swing.JPanel punishPnl;
    private javax.swing.JPanel sideBar;
    private javax.swing.JButton statisticsBtn;
    // End of variables declaration//GEN-END:variables
}
