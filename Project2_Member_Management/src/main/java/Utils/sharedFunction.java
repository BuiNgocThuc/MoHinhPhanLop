/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author buing
 */
public class sharedFunction {

    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displayConfirmMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Notification", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean displayConfirmQuestion(String question) {
        int dialogResult = JOptionPane.showConfirmDialog(null, question, "Confirm", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    public Timestamp transTimestamp(LocalDate date) {

        // Chuyển đổi LocalDate thành LocalDateTime (thêm thời gian là 00:00)
        LocalDateTime localDateTime = date.atStartOfDay();

        // Chuyển đổi LocalDateTime thành Timestamp
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        // In ra kết quả
        System.out.println("Timestamp: " + timestamp);
        
        return timestamp;
    }
    
//    public static void main(String[] args) {
//        sharedFunction func = new sharedFunction();
//        
//        func.transTimestamp("2024-04-16");
//    }
}
