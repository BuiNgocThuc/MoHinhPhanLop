package BLL;

import DAL.CourseInstructorDAL;
import DAL.CourseDAL;
import DTO.CourseDTO;
import DTO.CourseInstructorDTO;
import java.sql.SQLException;
import java.util.List;

public class CourseInstructorBLL {

    private CourseInstructorDAL courseInstructorDAL = new CourseInstructorDAL();
    private CourseDAL courseDAL = new CourseDAL();

    public List<CourseInstructorDTO> getAllCourseInstructors() throws SQLException {
        return courseInstructorDAL.selectAll();
    }

    public List<CourseInstructorDTO> getListCourseInstructorsByPersonID(int personID) throws SQLException {
        try {
            return courseInstructorDAL.selectByPersonID(personID);
        } catch (SQLException e) {
            // Thông báo lỗi đến lớp gọi
            throw new SQLException("Error retrieving course instructors by person ID", e);
        }
    }

    public static void main(String[] args) throws SQLException {
        new CourseInstructorBLL().getListCourseAssignInstructor();
    }

    public List<CourseDTO> getListCourseAssignInstructor() throws SQLException {
        List<CourseDTO> courses = courseDAL.getAllList();
        System.out.println(courses.get(0).getInstructors());
        courseDAL.populateInstructors(courses);
        System.out.println(courses.get(0).getInstructors());
        return courses;

    }

    public CourseInstructorDTO getCourseInstructorByID(int courseID, int personID) throws SQLException {
        return courseInstructorDAL.selectByID(courseID, personID);
    }

    public void insertCourseInstructor(CourseInstructorDTO courseInstructor) throws SQLException {
        courseInstructorDAL.insertCourseInstructor(courseInstructor);
    }

    public boolean updateCourseInstructor(CourseInstructorDTO courseInstructor) throws SQLException {
        return courseInstructorDAL.updateCourseInstructor(courseInstructor);
    }

    public void deleteCourseInstructor(CourseInstructorDTO courseInstructor) throws SQLException {
        courseInstructorDAL.deleteCourseInstructor(courseInstructor);
    }
    
    public void deleteALLCourseInstructor(int courseID) throws SQLException {
        courseInstructorDAL.deleteAllCourseInstructor(courseID);
    }

//    public static void main(String[] args) throws SQLException {
//        CourseInstructorBLL ciBLL = new CourseInstructorBLL();
//
//        for (CourseInstructorDTO ci : ciBLL.getAllCourseInstructors()) {
//            System.out.println(ci);
//        }
//
//        CourseInstructorDTO ci = ciBLL.getCourseInstructorByID(1045, 5);
//        System.out.println(ci);
//
//    }
}
