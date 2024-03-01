/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import BLL.Entity.CourseEntity;
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

    public List<CourseEntity> selectAllCourse() {
        return courseDAL.selectAll();
    }

    public int selectLastID() {
        return courseDAL.selectLastID();
    }

    public boolean insertCourse(CourseEntity course) {
        return courseDAL.insertCourse(course);
    }

    public boolean updateCourse(CourseEntity course) {
        return courseDAL.updateCourse(course);
    }

    public boolean deleteCourse(int CourseID) {
        return courseDAL.deleteCourse(CourseID);
    }

    public ArrayList<CourseEntity> getAllist() {
        return courseDAL.getAllList();
    }

    public ArrayList<CourseEntity> getAllist(String text) {
        return courseDAL.getAllList(text);
    }

    public CourseEntity courseDetail(int id) {
        return courseDAL.courseDetail(id);
    }

    public boolean checkCourseEmpty(int CourseID) {
        return courseDAL.checkCourseEmpty(CourseID);
    }
    
    public List<CourseEntity> selectOnsiteAllCourse() {
        return courseDAL.selectOnsiteAll();
    }
    
    public List<CourseEntity> selectOnlineAllCourse() {
        return courseDAL.selectOnlineAll();
    }
    
    public ArrayList<CourseEntity> findCoursesAll(String text) {
        if (ValidateUtil.isInteger(text)) {
            return courseDAL.findCoursesByIdAll(Integer.parseInt(text));
        } else {
            return courseDAL.findCoursesByNameAll(text);
        }
    }

    public ArrayList<CourseEntity> findCoursesOnsite(String text) {
        if (ValidateUtil.isInteger(text)) {
            return courseDAL.findCoursesByIdOnsite(Integer.parseInt(text));
        } else {
            return courseDAL.findCoursesByNameOnsite(text);
        }
    }

    public ArrayList<CourseEntity> findCoursesOnline(String text) {
        if (ValidateUtil.isInteger(text)) {
            return courseDAL.findCoursesByIdOnline(Integer.parseInt(text));
        } else {
            return courseDAL.findCoursesByNameOnline(text);
        }
    }
}
