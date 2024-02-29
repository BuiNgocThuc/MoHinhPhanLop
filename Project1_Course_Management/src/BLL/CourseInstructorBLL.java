package BLL;

import DAL.CourseInstructorDAL;
import DAL.CourseDAL;
import DAL.PersonDAL;
import DTO.CourseDTO;
import DTO.CourseInstructorDTO;
import DTO.PersonDTO;
import java.sql.SQLException;
import java.util.List;

import util.ValidateUtil;

public class CourseInstructorBLL {

    private CourseInstructorDAL courseInstructorDAL = new CourseInstructorDAL();
    private CourseDAL courseDAL = new CourseDAL();
    private PersonDAL personDAL = new PersonDAL();

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

    public List<CourseDTO> getListCourseAssignInstructor() throws SQLException {
        List<CourseDTO> courses = courseDAL.getAllList();
        courseDAL.populateInstructors(courses);
        return courses;

    }

    public List<PersonDTO> getListInstructorAssignCourse() throws SQLException {
        List<PersonDTO> instructors = personDAL.getListInstructor();
        personDAL.populateCourses(instructors);
        return instructors;

    }

    public CourseInstructorDTO getCourseInstructorByID(int courseID, int personID) throws SQLException {
        return courseInstructorDAL.selectByID(courseID, personID);
    }

    public List<CourseDTO> findCourses(String text) throws SQLException {
        List<CourseDTO> courses = null;
        if (ValidateUtil.isInteger(text)) {
            courses = courseDAL.findCoursesByIdAll(Integer.parseInt(text));
        } else {
            courses = courseDAL.findCoursesByNameAll(text);
        }
        courseDAL.populateInstructors(courses);
        return courses;
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

    public void deleteAllCourseAssignInstructor(int instrutorID) throws SQLException {
        courseInstructorDAL.deleteAllCourseAssignInstructor(instrutorID);
    }

    public void deleteAllInstructorAssignCourse(int courseID) throws SQLException {
        courseInstructorDAL.deleteAllInstructorAssignCourse(courseID);
    }

}
