package BLL;

import DAL.CourseInstructorDAL;
import DAL.CourseDAL;
import DAL.PersonDAL;
import BLL.Entity.CourseEntity;
import BLL.Entity.CourseInstructorEntity;
import BLL.Entity.PersonEntity;
import java.sql.SQLException;
import java.util.List;
import util.Paginate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


import util.ValidateUtil;

public class CourseInstructorBLL {

    private CourseInstructorDAL courseInstructorDAL = new CourseInstructorDAL();
    private CourseDAL courseDAL = new CourseDAL();
    private PersonDAL personDAL = new PersonDAL();

    public CourseInstructorBLL() {

    }

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

    public Paginate<PersonEntity> getListInstructorAssignedCourse(int offset, int limit, String querySearch) throws SQLException {
        Paginate<PersonEntity> paginate = personDAL.getListInstructorAssignedCourse(offset, limit, querySearch);

        personDAL.populateCourses(paginate.getItems());

        return paginate;
    }
    
    public Paginate<CourseEntity> getListCourseAssignedInstructor(int offset, int limit, String querySearch) throws SQLException {
        Paginate<CourseEntity> paginate = courseDAL.getListCourseAssignedInstructor(offset, limit, querySearch);

        courseDAL.populateInstructors(paginate.getItems());

        return paginate;
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

    public void updateCourseInstructors(PersonEntity instructor) throws SQLException {
        deleteAllCourseAssignInstructor(instructor.getPersonID());
        for (CourseEntity course : instructor.getCourses()) {
            CourseInstructorEntity courseInstructor = new CourseInstructorEntity(course.getCourseID(),
                    instructor.getPersonID());
            insertCourseInstructor(courseInstructor);
        }
    }

    public void updateCourseInstructors(CourseEntity course) throws SQLException {
        deleteAllInstructorAssignCourse(course.getCourseID());
        for (PersonEntity person : course.getInstructors()) {
            CourseInstructorEntity courseInstructor = new CourseInstructorEntity(course.getCourseID(), person.getPersonID());
            insertCourseInstructor(courseInstructor);
        }
    }

    public int checkCourseExist(int instructorId,
            List<CourseEntity> selectedCourses) {
        try {
            for (CourseInstructorEntity courseInstructorDTO : getAllCourseInstructors()) {
                for (CourseEntity courseDTO : selectedCourses) {
                    if (courseInstructorDTO.getCourseID() == courseDTO.getCourseID()
                            && instructorId == courseInstructorDTO.getPersonID()) {
                        return courseDTO.getCourseID();
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int checkInstructorExist(int courseId,
            List<PersonEntity> selectedPerson) {
        try {
            for (CourseInstructorEntity courseInstructorDTO : getAllCourseInstructors()) {
                for (PersonEntity personDTO : selectedPerson) {
                    if (courseInstructorDTO.getPersonID() == personDTO.getPersonID()
                            && courseId == courseInstructorDTO.getCourseID()) {
                        return personDTO.getPersonID();
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
