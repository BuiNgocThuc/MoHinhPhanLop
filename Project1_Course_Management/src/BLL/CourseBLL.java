/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DTO.CourseDTO;
import java.util.ArrayList;
import java.util.List;
import util.ValidateUtil;

/**
 *
 * @author buing
 */
public class CourseBLL {
    private CourseDAL courseDAL;
    
    public CourseBLL() {
        courseDAL = new CourseDAL();
    }
    
    public List<CourseDTO> selectAllCourse() {
        return courseDAL.selectAll();
    }
    
    public int selectLastID() {
        return courseDAL.selectLastID();
    }
    
    public boolean insertCourse(CourseDTO course) {
        return courseDAL.insertCourse(course);
    }
    
    public boolean updateCourse(CourseDTO course) {
        return courseDAL.updateCourse(course);
    }
    
    public boolean deleteCourse(int CourseID) {
        return courseDAL.deleteCourse(CourseID);
    }
    
    public ArrayList<CourseDTO> getAllist(){
        return courseDAL.getAllList();
    }
    
    public ArrayList<CourseDTO> getAllist(String text){
        return courseDAL.getAllList(text);
    }
    
    public CourseDTO courseDetail(int id){
        return courseDAL.courseDetail(id);
    }
    
    public ArrayList<CourseDTO> findCourses(String text){
        if (ValidateUtil.isInteger(text))
            return courseDAL.findCoursesById(Integer.parseInt(text));
        else 
            return courseDAL.findCoursesByName(text);
    }
}
