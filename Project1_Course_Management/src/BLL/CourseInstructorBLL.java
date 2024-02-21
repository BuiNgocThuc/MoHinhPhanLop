package BLL;

import DAL.CourseInstructorDAL;
import DTO.CourseInstructorDTO;
import java.util.List;
import DTO.CourseInstructorDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CourseInstructorBLL {

    private CourseInstructorDAL courseInstructorDAL;

    public CourseInstructorBLL(Connection connection) {
        this.courseInstructorDAL = new CourseInstructorDAL(connection);
    }

   public List<CourseInstructorDTO> getAllCourseInstructors() {
    try {
        return courseInstructorDAL.selectAll();
    } catch (SQLException e) {
        // Xử lý ngoại lệ, ví dụ: in ra thông báo hoặc ghi log
        e.printStackTrace();
        return null;
    }
}


    public CourseInstructorDTO getCourseInstructorByID(int courseID) throws SQLException {
        return courseInstructorDAL.selectByID(courseID);
    }

    public void insertCourseInstructor(CourseInstructorDTO courseInstructor) throws SQLException {
        courseInstructorDAL.insertCourseInstructor(courseInstructor);
    }

    public boolean updateCourseInstructor(CourseInstructorDTO courseInstructor) throws SQLException {
        return courseInstructorDAL.updateCourseInstructor(courseInstructor);
    }

    public void deleteCourseInstructor(int courseID) throws SQLException {
        courseInstructorDAL.deleteCourseInstructor(courseID);
    }
}
