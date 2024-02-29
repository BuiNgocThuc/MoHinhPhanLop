/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.CourseInstructorDTO;
import DTO.PersonDTO;
import DTO.CourseDTO;
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
//        String query = "SELECT * FROM CourseInstructor ";
//        try (PreparedStatement statement = conn.prepareStatement(query); ResultSet rs = statement.executeQuery()) {
//            while (rs.next()) {
//                int courseID = rs.getInt("CourseID");
//                int personID = rs.getInt("PersonID");
//                CourseInstructorDTO courseInstructor = new CourseInstructorDTO(courseID, personID);
//                courseInstructors.add(courseInstructor);
//            }
//        } catch (SQLException e) {
//            throw e;
//        }
//        return courseInstructors;
//    }
    // use this before complete populate function 
    public List<CourseInstructorDTO> selectAll() throws SQLException {
        List<CourseInstructorDTO> courseInstructors = new ArrayList<>();
        String query = "SELECT * FROM courseinstructor ci "
                + "JOIN person p on ci.PersonID = p.PersonID JOIN course c on ci.CourseID = c.CourseID";
        try (PreparedStatement statement = conn.prepareStatement(query); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                int personID = rs.getInt("PersonID");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                Timestamp hireDate = rs.getTimestamp("HireDate");
                Timestamp enrollmentDate = rs.getTimestamp("EnrollmentDate");
                PersonDTO person = new PersonDTO(personID, firstName, lastName, hireDate, enrollmentDate);
                int courseID = rs.getInt("CourseID");
                int departmentID = rs.getInt("DepartmentID");
                int credits = rs.getInt("Credits");
                String title = rs.getString("Title");
                CourseDTO course = new CourseDTO(courseID, departmentID, courseID, title);
                CourseInstructorDTO courseInstructor = new CourseInstructorDTO(courseID, personID, course, person);
                courseInstructors.add(courseInstructor);
            }
        } catch (SQLException e) {
            throw e;
        }
        return courseInstructors;
    }

    public CourseInstructorDTO selectByID(int courseID, int personID) throws SQLException {
        String query = "SELECT * FROM CourseInstructor ci "
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
                    PersonDTO person = new PersonDTO(personID, firstName, lastName, hireDate, enrollmentDate);
                    int departmentID = rs.getInt("DepartmentID");
                    int credits = rs.getInt("Credits");
                    String title = rs.getString("Title");
                    CourseDTO course = new CourseDTO(courseID, departmentID, courseID, title);
                    return new CourseInstructorDTO(courseID, personID, course, person);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public List<CourseInstructorDTO> selectByPersonID(int personID) throws SQLException {
        List<CourseInstructorDTO> courseInstructors = new ArrayList<>();
        String query = "SELECT * FROM CourseInstructor ci "
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
                    PersonDTO person = new PersonDTO(personID, firstName, lastName, hireDate, enrollmentDate);
                    int departmentID = rs.getInt("DepartmentID");
                    int credits = rs.getInt("Credits");
                    String title = rs.getString("Title");
                    CourseDTO course = new CourseDTO(courseID, departmentID, courseID, title);
                    CourseInstructorDTO courseInstructor = new CourseInstructorDTO(courseID, personID, course, person);
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
        List<CourseInstructorDTO> courseInstructors = ciDAL.selectAll();
        for (CourseInstructorDTO ci : courseInstructors) {
            System.out.println(ci);
        }

    }

    // Method to insert a new course instructor into the database
    public void insertCourseInstructor(CourseInstructorDTO courseInstructor) throws SQLException {
        String query = "INSERT INTO CourseInstructor (CourseID, PersonID) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, courseInstructor.getCourseID());
            statement.setInt(2, courseInstructor.getPersonID());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    // Method to update a course instructor in the database
    public boolean updateCourseInstructor(CourseInstructorDTO courseInstructor) throws SQLException {
        String query = "UPDATE CourseInstructor SET PersonID = ? WHERE CourseID = ?";
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
        String query = "DELETE FROM CourseInstructor WHERE PersonID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, instrutorID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
    public void deleteAllInstructorAssignCourse(int courseID) throws SQLException {
        String query = "DELETE FROM CourseInstructor WHERE CourseID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, courseID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void populate(CourseInstructorDTO courseInstructorDTO, String[] fields) {

        // create SQL query and map result to object
        for (String field : fields) {
            // Mapping data
        }
    }

    public void populate(List<CourseInstructorDTO> courseInstructorDTOs, String[] fields) {
        // get list ids

        // create query with ids
        // mapping all elements
    }

    public void deleteCourseInstructor(CourseInstructorDTO courseInstructor) throws SQLException {
        String query = "DELETE FROM CourseInstructor WHERE CourseID = ? AND PersonID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, courseInstructor.getCourseID());
            statement.setInt(2, courseInstructor.getPersonID());
            int rowsDeleted = statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
}
