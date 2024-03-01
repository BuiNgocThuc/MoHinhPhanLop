package util;

import exception.ValidationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidateUtil {

    public static boolean isName(String name) {
        Pattern pattern = Pattern.compile("/^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$/u");
        Matcher matcher = pattern.matcher(name);
        boolean matchFound = matcher.find();

        return matchFound;
    }
    
    public static Timestamp convertStringToTimestamp(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate = dateFormat.parse(dateString);
            return new Timestamp(parsedDate.getTime());
        } 
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getCurrentDate() {
        Date currentDate = new Date();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return dateFormat.format(currentDate);
    }
    
    
    public static boolean isEmpty(String s) {
        return s.trim().equals("");
    }
    
    public static boolean isValidUrl(String url) {
        String regex = "^(https?|ftp)://([A-Za-z0-9.-]+)(:[0-9]+)?(/[A-Za-z0-9_.-]+)*(\\?[A-Za-z0-9_.-]+=[A-Za-z0-9%_.-]+)?(#\\w+)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        
        return matcher.matches();
    }
    
    public static boolean isInteger(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
// Studycase of Try-Catch
//
//    public static void someMethodInBLL(String name) throws ValidationException, Throwable {
//        try {
//            // check validate data
//            if (!isName(name)) {
//                throw new ValidationException("Field name is incorrect!");
//            }
//
//            // Do some stuff 
//            if (Math.random() * 10 > 10) {
//                throw new Exception("Duplicate account");
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
//    public static void someMethodInUI() {
//        String name = "Tuan"; // get from field
//
//        try {
//            someMethodInBLL(name);
//
//            System.out.println("Done!");
//        } catch (ValidationException e) {
//            // Do some stuff with input field
//            System.out.println(e.getMessage());
//        } catch (Exception e) {
//            System.out.println("Something went wrong!");
//        } catch (Throwable ex) {
//            Logger.getLogger(ValidateUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    public static void main(String[] args) throws ValidationException {
//        try {
//            someMethodInUI();
//        } catch (Exception e) {
//            // 
//        }
//    }
}
