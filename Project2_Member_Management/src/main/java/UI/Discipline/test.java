/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.Discipline;

import DAL.DisciplineDAL;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Utils.hibernateUtil;
/**
 *
 * @author buing
 */
public class test {
    public static void main(String[] args) {
        
//        java.awt.EventQueue.invokeLater(() -> {
//            try {
//                UIManager.setLookAndFeel(new FlatLightLaf());
//            } catch (UnsupportedLookAndFeelException ex) {
//                System.err.println("Failed to initialize LaF");
//            }
//            
//        });
        DisciplineDAL dal=new DisciplineDAL();
        System.out.println(dal.StatisticsDiscipline());
    }
}
