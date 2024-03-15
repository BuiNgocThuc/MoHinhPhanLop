/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DAL.OnlineCourseDAL;
import BLL.Entity.OnlineCourseEntity;
import java.util.List;

/**
 *
 * @author buing
 */
public class OnlineCourseBLL {

    private CourseDAL courseDAL;
    private OnlineCourseDAL onlCourseDAL;
    private CourseBLL courseBLL = new CourseBLL();

    public OnlineCourseBLL() {
        courseDAL = new CourseDAL();
        onlCourseDAL = new OnlineCourseDAL();
    }

    public List<OnlineCourseEntity> selectAllOnlineCourse() {
        return courseDAL.selectAllOnlineCourse();
    }

    public boolean insertOnlineCourse(OnlineCourseEntity onlCourse) {
        return onlCourseDAL.insertOnlineCourse(onlCourse);
    }

    public OnlineCourseEntity selectByID(int CourseID) {
        return onlCourseDAL.selectByID(CourseID);
    }

    public boolean updateOnlineCourse(OnlineCourseEntity onlCourse) {
        return onlCourseDAL.updateOnlineCourse(onlCourse);

    }

    public boolean deleteOnlineCourse(int CourseID) {
        boolean success = onlCourseDAL.deleteOnlineCourse(CourseID);
        if (success)
        {
            return courseBLL.deleteCourse(CourseID);
        } else
        {
            System.out.println("Xoa khoa hoc online that bai");
        }
        return false;
    }
}
