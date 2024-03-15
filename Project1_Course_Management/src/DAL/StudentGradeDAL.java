/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import DAL.ConnectDB;
import BLL.Entity.StudentGradeEntity;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author buing
 */
public class StudentGradeDAL {
    ConnectDB con=new ConnectDB();
    public  ArrayList<StudentGradeEntity> getAllList(int CourseID){
        ArrayList<StudentGradeEntity> listStudentGrade=new ArrayList<StudentGradeEntity>();
        try{
            String query="select * from studentgrade where CourseID=?";
            PreparedStatement pre=con.getConnectDB().prepareStatement(query);
            pre.setInt(1, CourseID);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                StudentGradeEntity studentGrade=new StudentGradeEntity();
                studentGrade.setEnrollmentID(rs.getInt("EnrollmentID"));
                studentGrade.setCourseID(rs.getInt("CourseID"));
                studentGrade.setStudentID(rs.getInt("StudentID"));
                studentGrade.setGrade(rs.getDouble("Grade"));
                Double grade=rs.getDouble("Grade");
                if(rs.wasNull()){
                    studentGrade.setGrade(null);
                }else{
                    studentGrade.setGrade(grade);
                }
                
                listStudentGrade.add(studentGrade);
            }
            return listStudentGrade;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public  ArrayList<StudentGradeEntity> getAllListR(int CourseID,String text){
        ArrayList<StudentGradeEntity> listStudentGrade=new ArrayList<StudentGradeEntity>();
        try{
            String query;
            if(text.equals("Đậu")){
                query="select * from studentgrade where CourseID=? and Grade>=5";
            }else{
                query="select * from studentgrade where CourseID=? and Grade<5";
            }
            PreparedStatement pre=con.getConnectDB().prepareStatement(query);
            pre.setInt(1, CourseID);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                StudentGradeEntity studentGrade=new StudentGradeEntity();
                studentGrade.setEnrollmentID(rs.getInt("EnrollmentID"));
                studentGrade.setCourseID(rs.getInt("CourseID"));
                studentGrade.setStudentID(rs.getInt("StudentID"));
                studentGrade.setGrade(rs.getDouble("Grade"));
                listStudentGrade.add(studentGrade);
            }
            return listStudentGrade;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean updateGrade(StudentGradeEntity student){
        try{
            StudentGradeEntity studentGradeDTO=new StudentGradeEntity();
            String query="update studentgrade set CourseID=?,Grade=? where EnrollmentID=?";
            PreparedStatement pre=con.getConnectDB().prepareStatement(query);
            pre.setInt(1, student.getCourseID());
            pre.setDouble(2,student.getGrade());
            pre.setInt(3, student.getEnrollmentID());
            int n=pre.executeUpdate();
            return n>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public  boolean deleteGrade(int id){
        try{
            String query="delete from studentgrade where EnrollmentID=?";
            PreparedStatement pre=con.getConnectDB().prepareStatement(query);
            pre.setInt(1, id);
            int n=pre.executeUpdate();
            return n>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public int getEnrollment(int CourseID,int StudentID){
        try{
            String sql="select EnrollmentID from studentgrade where CourseID=? and StudentID=?";
            PreparedStatement pre=con.getConnectDB().prepareStatement(sql);
            pre.setInt(1, CourseID);
            pre.setInt(2, StudentID);
            ResultSet rs=pre.executeQuery();
            int EnrollmentID=0;
            if(rs.next()){
                EnrollmentID=rs.getInt("EnrollmentID");
            }
            return EnrollmentID;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public boolean insertStudentGrade(StudentGradeEntity studentGradeDTO) {
        int result = -1;
        
        int EnrollmentID = studentGradeDTO.getEnrollmentID();
        int CourseID = studentGradeDTO.getCourseID();
        int StudentID = studentGradeDTO.getStudentID();
        Double Grade = studentGradeDTO.getGrade();

        String query = "INSERT INTO studentgrade(CourseID, StudentID, Grade) VALUES (?,?,?)";
        try
        {
            PreparedStatement preStm = con.getConnectDB().prepareStatement(query);
            preStm.setInt(1, CourseID);
            preStm.setInt(2, StudentID);
            if(Grade!=null){
                preStm.setDouble(3,Grade);
            }else{
                preStm.setNull(3,java.sql.Types.DOUBLE);
            }
            
            result = preStm.executeUpdate();
            if (result != 0)
            {
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public  ArrayList<StudentGradeEntity> serchAllStudentGrade(int CourseID,String text){
        ArrayList<StudentGradeEntity> listStudentGrade=new ArrayList<StudentGradeEntity>();
        try{
            String query="select studentgrade.EnrollmentID,studentgrade.CourseID,"
                    + "studentgrade.StudentID,studentgrade.Grade "
                    + "from studentgrade "
                    + "join course on studentgrade.CourseID=course.CourseID "
                    + "join person on person.PersonID=studentgrade.StudentID "
                    + "where UPPER(CONCAT(person.PersonID,person.Firstname,person.Lastname,studentgrade.Grade)) "
                    + "like '%"+text+"%' and studentgrade.CourseID="+CourseID;
            PreparedStatement pre=con.getConnectDB().prepareStatement(query);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                StudentGradeEntity studentGrade=new StudentGradeEntity();
                studentGrade.setEnrollmentID(rs.getInt("studentgrade.EnrollmentID"));
                studentGrade.setCourseID(rs.getInt("studentgrade.CourseID"));
                studentGrade.setStudentID(rs.getInt("studentgrade.StudentID"));
                studentGrade.setGrade(rs.getDouble("studentgrade.Grade"));
                listStudentGrade.add(studentGrade);
            }
            return listStudentGrade;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public  ArrayList<StudentGradeEntity> Statistical(int CourseID,String text){
        ArrayList<StudentGradeEntity> listStatistical=new ArrayList<>();
        try{
            String query;
            if(text.equals("Passing")){
                query="select * from studentgrade where CourseID=? and Grade>=5";
            }else{
                query="select * from studentgrade where CourseID=? and Grade<5";
            }
            PreparedStatement pre=con.getConnectDB().prepareStatement(query);
            pre.setInt(1, CourseID);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                StudentGradeEntity studentGrade=new StudentGradeEntity();
                studentGrade.setEnrollmentID(rs.getInt("EnrollmentID"));
                studentGrade.setCourseID(rs.getInt("CourseID"));
                studentGrade.setStudentID(rs.getInt("StudentID"));
                studentGrade.setGrade(rs.getDouble("Grade"));
                listStatistical.add(studentGrade);
            }
            return listStatistical;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
//    public int checkCourse(int CourseID,int StudentID){
//        try{
//            String sql="select EnrollmentID from studentgrade where CourseID=? and StudentID=?";
//            PreparedStatement pre=con.getConnectDB().prepareStatement(sql);
//            pre.setInt(1, CourseID);
//            pre.setInt(2, StudentID);
//            ResultSet rs=pre.executeQuery();
//            int EnrollmentID=0;
//            if(rs.next()){
//                EnrollmentID=rs.getInt("EnrollmentID");
//            }
//            return EnrollmentID;
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return 0;
//    } 
}
