package BLL;

import DAL.CourseInstructorDAL;
import DAL.CourseDAL;
import DAL.PersonDAL;
import BLL.Entity.CourseEntity;
import BLL.Entity.CourseInstructorEntity;
import BLL.Entity.PersonEntity;
import java.sql.SQLException;
import java.util.List;

import util.ValidateUtil;

public class CourseInstructorBLL {

    private CourseInstructorDAL courseInstructorDAL = new CourseInstructorDAL();
    private CourseDAL courseDAL = new CourseDAL();
    private PersonDAL personDAL = new PersonDAL();

    public List<CourseInstructorEntity> getAllCourseInstructors() throws SQLException {
        return courseInstructorDAL.selectAll();
    }

    public List<CourseInstructorEntity> getListCourseInstructorsByPersonID(int personID) throws SQLException {
        try {
            return courseInstructorDAL.selectByPersonID(personID);
        } catch (SQLException e) {
            // Thông báo lỗi đến lớp gọi
            throw new SQLException("Error retrieving course instructors by person ID", e);
        }
    }

    public List<CourseEntity> getListCourseAssignInstructor() throws SQLException {
        List<CourseEntity> courses = courseDAL.getAllList();
        courseDAL.populateInstructors(courses);
        return courses;

    }

    public List<PersonEntity> getListInstructorAssignCourse() throws SQLException {
        List<PersonEntity> instructors = personDAL.getListInstructor();
        personDAL.populateCourses(instructors);
        return instructors;

    }

    public CourseInstructorEntity getCourseInstructorByID(int courseID, int personID) throws SQLException {
        return courseInstructorDAL.selectByID(courseID, personID);
    }

    public List<CourseEntity> findCourses(String text) throws SQLException {
        List<CourseEntity> courses = null;
        if (ValidateUtil.isInteger(text)) {
            courses = courseDAL.findCoursesByIdAll(Integer.parseInt(text));
        } else {
            courses = courseDAL.findCoursesByNameAll(text);
        }
        courseDAL.populateInstructors(courses);
        return courses;
    }

    public List<PersonEntity> findInstructors(String text) throws SQLException {
        List<PersonEntity> instructors = null;
        if (ValidateUtil.isInteger(text)) {
            instructors = personDAL.findInstructorsById(Integer.parseInt(text));
        } else {
            instructors = personDAL.findInstrutorsByName(text);
        }
        personDAL.populateCourses(instructors);
        return instructors;
    }

    public void insertCourseInstructor(CourseInstructorEntity courseInstructor) throws SQLException {
        courseInstructorDAL.insertCourseInstructor(courseInstructor);
    }

    public boolean updateCourseInstructor(CourseInstructorEntity courseInstructor) throws SQLException {
        return courseInstructorDAL.updateCourseInstructor(courseInstructor);
    }

    public void deleteCourseInstructor(CourseInstructorEntity courseInstructor) throws SQLException {
        courseInstructorDAL.deleteCourseInstructor(courseInstructor);
    }

    public void deleteAllCourseAssignInstructor(int instrutorID) throws SQLException {
        courseInstructorDAL.deleteAllCourseAssignInstructor(instrutorID);
    }

    public void deleteAllInstructorAssignCourse(int courseID) throws SQLException {
        courseInstructorDAL.deleteAllInstructorAssignCourse(courseID);
    }

    public List<CourseInstructorEntity> getListCourseInstructorsByCourseID(int id_Course) throws SQLException {
        try {
            return courseInstructorDAL.selectByCourseID(id_Course);
        } catch (SQLException e) {
            // Thông báo lỗi đến lớp gọi
            throw new SQLException("Error retrieving course instructors by person ID", e);
        }
    }

}
