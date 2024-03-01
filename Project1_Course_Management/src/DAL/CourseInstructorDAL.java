/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.Entity.CourseInstructorEntity;
import BLL.Entity.PersonEntity;
import BLL.Entity.CourseEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

/**
 *
 * @author buing
 */
public class CourseInstructorDAL {

    private Connection conn;

    public CourseInstructorDAL() {
        ConnectDB connectDB = new ConnectDB();
        conn = (Connection) connectDB.getConnectDB();
    }

//    public List<CourseInstructorDTO> selectAll() throws SQLException {
//        List<CourseInstructorDTO> courseInstructors = new ArrayList<>();
//        String query = "SELECT * FROM courseinstructor ";
//        try (PreparedStatement statement = conn.prepareStatement(query); ResultSet rs = statement.executeQuery()) {
//            while (rs.next()) {
//                int courseID = rs.getInt("CourseID");
//                int personID = rs.getInt("PersonID");
//                CourseInstructorEntity courseInstructor = new CourseInstructorEntity(courseID, personID);
//                courseInstructors.add(courseInstructor);
//            }
//        } catch (SQLException e) {
//            throw e;
//        }
//        return courseInstructors;
//    }
    // use this before complete populate function 
    public List<CourseInstructorEntity> selectAll() throws SQLException {
        List<CourseInstructorEntity> courseInstructors = new ArrayList<>();
        String query = "SELECT * FROM courseinstructor ci "
                + "JOIN person p on ci.PersonID = p.PersonID JOIN course c on ci.CourseID = c.CourseID";
        try (PreparedStatement statement = conn.prepareStatement(query); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                int personID = rs.getInt("PersonID");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                Timestamp hireDate = rs.getTimestamp("HireDate");
                Timestamp enrollmentDate = rs.getTimestamp("EnrollmentDate");
                PersonEntity person = new PersonEntity(personID, firstName, lastName, hireDate, enrollmentDate);
                int courseID = rs.getInt("CourseID");
                int departmentID = rs.getInt("DepartmentID");
                int credits = rs.getInt("Credits");
                String title = rs.getString("Title");
                CourseEntity course = new CourseEntity(courseID, departmentID, credits, title);
                CourseInstructorEntity courseInstructor = new CourseInstructorEntity(courseID, personID, course, person);
                courseInstructors.add(courseInstructor);
            }
        } catch (SQLException e) {
            throw e;
        }
        return courseInstructors;
    }

    public CourseInstructorEntity selectByID(int courseID, int personID) throws SQLException {
        String query = "SELECT * FROM courseinstructor ci "
                + "JOIN person p on ci.PersonID = p.PersonID JOIN course c on ci.CourseID = c.CourseID "
                + "WHERE ci.CourseID = ? AND ci.PersonID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, courseID);
            statement.setInt(2, personID);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String lastName = rs.getString("LastName");
                    String firstName = rs.getString("FirstName");
                    Timestamp hireDate = rs.getTimestamp("HireDate");
                    Timestamp enrollmentDate = rs.getTimestamp("EnrollmentDate");
                    PersonEntity person = new PersonEntity(personID, firstName, lastName, hireDate, enrollmentDate);
                    int departmentID = rs.getInt("DepartmentID");
                    int credits = rs.getInt("Credits");
                    String title = rs.getString("Title");
                    CourseEntity course = new CourseEntity(courseID, departmentID, credits, title);
                    return new CourseInstructorEntity(courseID, personID, course, person);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public List<CourseInstructorEntity> selectByPersonID(int personID) throws SQLException {
        List<CourseInstructorEntity> courseInstructors = new ArrayList<>();
        String query = "SELECT * FROM courseinstructor ci "
                + "JOIN person p on ci.PersonID = p.PersonID JOIN course c on ci.CourseID = c.CourseID "
                + "WHERE ci.PersonID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, personID);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    int courseID = rs.getInt("CourseID");
                    String lastName = rs.getString("LastName");
                    String firstName = rs.getString("FirstName");
                    Timestamp hireDate = rs.getTimestamp("HireDate");
                    Timestamp enrollmentDate = rs.getTimestamp("EnrollmentDate");
                    PersonEntity person = new PersonEntity(personID, firstName, lastName, hireDate, enrollmentDate);
                    int departmentID = rs.getInt("DepartmentID");
                    int credits = rs.getInt("Credits");
                    String title = rs.getString("Title");
                    CourseEntity course = new CourseEntity(courseID, departmentID, credits, title);
                    CourseInstructorEntity courseInstructor = new CourseInstructorEntity(courseID, personID, course, person);
                    courseInstructors.add(courseInstructor);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return courseInstructors;
    }

    public static void main(String[] args) throws SQLException {
        CourseInstructorDAL ciDAL = new CourseInstructorDAL();
        List<CourseInstructorEntity> courseInstructors = ciDAL.selectAll();
        for (CourseInstructorEntity ci : courseInstructors) {
            System.out.println(ci);
        }

    }

    // Method to insert a new course instructor into the database
    public void insertCourseInstructor(CourseInstructorEntity courseInstructor) throws SQLException {
        String query = "INSERT INTO courseinstructor (CourseID, PersonID) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, courseInstructor.getCourseID());
            statement.setInt(2, courseInstructor.getPersonID());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    // Method to update a course instructor in the database
    public boolean updateCourseInstructor(CourseInstructorEntity courseInstructor) throws SQLException {
        String query = "UPDATE courseinstructor SET PersonID = ? WHERE CourseID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, courseInstructor.getPersonID());
            statement.setInt(2, courseInstructor.getCourseID());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void deleteAllCourseAssignInstructor(int instrutorID) throws SQLException {
        String query = "DELETE FROM courseinstructor WHERE PersonID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, instrutorID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void deleteAllInstructorAssignCourse(int courseID) throws SQLException {
        String query = "DELETE FROM courseinstructor WHERE CourseID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, courseID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void populate(CourseInstructorEntity courseInstructorDTO, String[] fields) {

        // create SQL query and map result to object
        for (String field : fields) {
            // Mapping data
        }
    }

    public void populate(List<CourseInstructorEntity> courseInstructorDTOs, String[] fields) {
        // get list ids

        // create query with ids
        // mapping all elements
    }

    public void deleteCourseInstructor(CourseInstructorEntity courseInstructor) throws SQLException {
        String query = "DELETE FROM courseinstructor WHERE CourseID = ? AND PersonID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, courseInstructor.getCourseID());
            statement.setInt(2, courseInstructor.getPersonID());
            int rowsDeleted = statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<CourseInstructorEntity> selectByCourseID(int id_Course) throws SQLException {
        List<CourseInstructorEntity> courseInstructors = new ArrayList<>();
        String query = "SELECT * FROM CourseInstructor ci "
                + "JOIN person p ON ci.PersonID = p.PersonID "
                + "JOIN course c ON ci.CourseID = c.CourseID "
                + "WHERE ci.CourseID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id_Course);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    int courseID = rs.getInt("CourseID");
                    int personID = rs.getInt("PersonID");
                    String lastName = rs.getString("LastName");
                    String firstName = rs.getString("FirstName");
                    Timestamp hireDate = rs.getTimestamp("HireDate");
                    Timestamp enrollmentDate = rs.getTimestamp("EnrollmentDate");
                    PersonEntity person = new PersonEntity(personID, firstName, lastName, hireDate, enrollmentDate);
                    int departmentID = rs.getInt("DepartmentID");
                    int credits = rs.getInt("Credits");
                    String title = rs.getString("Title");
                    CourseEntity course = new CourseEntity(courseID, departmentID, credits, title);
                    CourseInstructorEntity courseInstructor = new CourseInstructorEntity(courseID, personID, course, person);
                    courseInstructors.add(courseInstructor);
                }
            }
        }
        return courseInstructors;
    }

}
