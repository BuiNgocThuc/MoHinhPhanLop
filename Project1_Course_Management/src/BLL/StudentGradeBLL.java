/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.StudentGradeDAL;
import DTO.StudentGradeDTO;
import java.util.ArrayList;

/**
 *
 * @author buing
 */
public class StudentGradeBLL {
    StudentGradeDAL studentGradeDAL=new StudentGradeDAL();
    public ArrayList<StudentGradeDTO> getAllList(int CourseID){
        return studentGradeDAL.getAllList(CourseID);
    }
    
    public int getEnrollment(int CourseID,int StudentID){
        return studentGradeDAL.getEnrollment(CourseID, StudentID);
    }
    
    public boolean insertStudent(StudentGradeDTO student) {
        return studentGradeDAL.insertStudentGrade(student);
    }
    
    public boolean updateGrade(StudentGradeDTO student){
        return studentGradeDAL.updateGrade(student);
    }
    
    public  boolean deleteGrade(int id){
        return studentGradeDAL.deleteGrade(id);
    }
    public  ArrayList<StudentGradeDTO> serchAllStudentGrade(int CourseID,String text){
        return studentGradeDAL.serchAllStudentGrade(CourseID, text);
    }
    public  ArrayList<StudentGradeDTO> Statistical(int CourseID,String text){
        return studentGradeDAL.Statistical(CourseID, text);
    }
}
