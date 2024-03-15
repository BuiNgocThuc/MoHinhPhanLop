/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DAL.OnsiteCourseDAL;
import BLL.Entity.OnsiteCourseEntity;
import java.util.List;

/**
 *
 * @author buing
 */
public class OnsiteCourseBLL {

    private CourseDAL courseDAL;
    private OnsiteCourseDAL onsCourseDAL;

    public OnsiteCourseBLL() {
        courseDAL = new CourseDAL();
        onsCourseDAL = new OnsiteCourseDAL();
    }

    public List<OnsiteCourseEntity> selectAllOnsiteCourse() {
        return courseDAL.selectAllOnsiteCourse();
    }
    
    public OnsiteCourseEntity selectByID(int CourseID) {
        return onsCourseDAL.selectByID(CourseID);
    }

    public boolean insertOnsiteCourse(OnsiteCourseEntity onsCourse) {
        return onsCourseDAL.insertOnsiteCourse(onsCourse);
    }

    public boolean updateOnsiteCourse(OnsiteCourseEntity onsCourse) {
        return onsCourseDAL.updateOnsiteCourse(onsCourse);
    }

    public boolean deleteOnsiteCourse(int CourseID) {
        return onsCourseDAL.deleteOnsiteCourse(CourseID);
    }
}
