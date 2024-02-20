/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.CourseInstructorDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buing
 */
public class CourseInstructorDAL {

    private Connection connection;

    public CourseInstructorDAL(Connection connection) {
        this.connection = connection;
    }

    public List<CourseInstructorDTO> selectAll() throws SQLException {
        List<CourseInstructorDTO> courseInstructors = new ArrayList<>();
        String query = "SELECT * FROM CourseInstructor";
        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                int personID = rs.getInt("PersonID");
                CourseInstructorDTO courseInstructor = new CourseInstructorDTO(courseID, personID);
                courseInstructors.add(courseInstructor);
            }
        } catch (SQLException e) {
            throw e;
        }
        return courseInstructors;
    }

    public CourseInstructorDTO selectByID(int courseID) throws SQLException {
        String query = "SELECT * FROM CourseInstructor WHERE CourseID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, courseID);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int personID = rs.getInt("PersonID");
                    return new CourseInstructorDTO(courseID, personID);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    // Method to insert a new course instructor into the database
    public void insertCourseInstructor(CourseInstructorDTO courseInstructor) throws SQLException {
        String query = "INSERT INTO CourseInstructor (CourseID, PersonID) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
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
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, courseInstructor.getPersonID());
            statement.setInt(2, courseInstructor.getCourseID());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void deleteCourseInstructor(int courseID) throws SQLException {
        String query = "DELETE FROM CourseInstructor WHERE CourseID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, courseID);
            int rowsDeleted = statement.executeUpdate();
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
}
