/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DAL.OnlineCourseDAL;
import DTO.OnlineCourseDTO;
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

    public List<OnlineCourseDTO> selectAllOnlineCourse() {
        return courseDAL.selectAllOnlineCourse();
    }

    public boolean insertOnlineCourse(OnlineCourseDTO onlCourse) {
        return onlCourseDAL.insertOnlineCourse(onlCourse);
    }

    public OnlineCourseDTO selectByID(int CourseID) {
        return onlCourseDAL.selectByID(CourseID);
    }

    public boolean updateOnlineCourse(OnlineCourseDTO onlCourse) {
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
