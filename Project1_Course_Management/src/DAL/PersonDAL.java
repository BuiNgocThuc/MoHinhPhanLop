/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.CourseDTO;
import DTO.PersonDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author buing
 */
public class PersonDAL {

    private ConnectDB con = new ConnectDB();

    public ArrayList<PersonDTO> getAllList() {
        ArrayList<PersonDTO> listPerson = new ArrayList<PersonDTO>();
        try {
            String query = "select * from person";
            PreparedStatement pre = con.getConnectDB().prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                PersonDTO person = new PersonDTO();
                person.setPersonID(rs.getInt("PersonID"));
                person.setLastName(rs.getString("Lastname"));
                person.setFirstName(rs.getString("Firstname"));
                person.setHireDate(rs.getTimestamp("HireDate"));
                person.setEnrollmentDate(rs.getTimestamp("EnrollmentDate"));
                listPerson.add(person);
            }
            return listPerson;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PersonDTO detailsPerson(int id) {
        try {
            PersonDTO person = new PersonDTO();
            String query = "select * from person where PersonID=?";
            PreparedStatement pre = con.getConnectDB().prepareStatement(query);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                person.setPersonID(rs.getInt("PersonID"));
                person.setLastName(rs.getString("Lastname"));
                person.setFirstName(rs.getString("Firstname"));
                person.setHireDate(rs.getTimestamp("HireDate"));
                person.setEnrollmentDate(rs.getTimestamp("EnrollmentDate"));
            }
            return person;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<PersonDTO> getListStudent() {
        ArrayList<PersonDTO> listPerson = new ArrayList<PersonDTO>();
        try {
            String query = "SELECT * FROM person WHERE EnrollmentDate IS NOT NULL;";
            PreparedStatement pre = con.getConnectDB().prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                PersonDTO person = new PersonDTO();
                person.setPersonID(rs.getInt("PersonID"));
                person.setLastName(rs.getString("Lastname"));
                person.setFirstName(rs.getString("Firstname"));
                person.setHireDate(rs.getTimestamp("HireDate"));
                person.setEnrollmentDate(rs.getTimestamp("EnrollmentDate"));
                listPerson.add(person);
            }
            return listPerson;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<PersonDTO> getListInstructor() {
        ArrayList<PersonDTO> listPerson = new ArrayList<PersonDTO>();
        try {
            String query = "SELECT * FROM person WHERE HireDate IS NOT NULL";
            PreparedStatement pre = con.getConnectDB().prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                PersonDTO person = new PersonDTO();
                person.setPersonID(rs.getInt("PersonID"));
                person.setLastName(rs.getString("Lastname"));
                person.setFirstName(rs.getString("Firstname"));
                person.setHireDate(rs.getTimestamp("HireDate"));
                person.setEnrollmentDate(rs.getTimestamp("EnrollmentDate"));
                listPerson.add(person);
            }
            return listPerson;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<PersonDTO> findInstructorsById(int s) {
        ArrayList<PersonDTO> instructors = new ArrayList<>();
        try {
            String query = "SELECT * FROM person p "
                    + "WHERE HireDate IS NOT NULL "
                    + "AND p.PersonID LIKE CONCAT('%'," + s + ",'%')";
            PreparedStatement pre = con.getConnectDB().prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int instructorId = rs.getInt("PersonID");
                String firstName = rs.getString("Firstname");
                String lastName = rs.getString("Lastname");
                Timestamp hireDate = rs.getTimestamp("HireDate");
                Timestamp enrollmentDate = rs.getTimestamp("EnrollmentDate");
                // Create instructor DTO
                PersonDTO instructor = new PersonDTO(instructorId, firstName, lastName, hireDate, enrollmentDate);
                instructors.add(instructor);
            }
            return instructors;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<PersonDTO> findInstrutorsByName(String name) {
        ArrayList<PersonDTO> instructors = new ArrayList<>();
        try {
            String query = "SELECT * FROM person p "
                    + "WHERE HireDate IS NOT NULL "
                    + "AND CONCAT(p.LastName,' ',p.FirstName) LIKE CONCAT('%',?,'%')";
            PreparedStatement pre = con.getConnectDB().prepareStatement(query);
            pre.setString(1, name);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int instructorId = rs.getInt("PersonID");
                String firstName = rs.getString("Firstname");
                String lastName = rs.getString("Lastname");
                Timestamp hireDate = rs.getTimestamp("HireDate");
                Timestamp enrollmentDate = rs.getTimestamp("EnrollmentDate");
                // Create instructor DTO
                PersonDTO instructor = new PersonDTO(instructorId, firstName, lastName, hireDate, enrollmentDate);
                instructors.add(instructor);
            }
            return instructors;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void populateCourses(List<PersonDTO> instructors) throws SQLException {
        if (instructors.isEmpty()) {
            return;
        }
        // Collecting instructor IDs
        List<Integer> instructorIds = new ArrayList<>();
        for (PersonDTO instructor : instructors) {
            instructorIds.add(instructor.getPersonID());
        }
        // Mapping instructor IDs to courses
        Map<Integer, List<CourseDTO>> courseInstructorMap = new HashMap<>();
        try {
            List<CourseDTO> courses = new ArrayList<>();
            String query = "select * from course c join courseinstructor ci "
                    + "on c.CourseID = ci.CourseID "
                    + "where ci.PersonID IN (";
            for (int i = 0; i < instructorIds.size(); i++) {
                query += (i == 0 ? "?" : ", ?");
            }
            query += ")";
            PreparedStatement preparedStatement = con.getConnectDB().prepareStatement(query);
            // Set instructor IDs as parameters
            for (int i = 0; i < instructorIds.size(); i++) {
                preparedStatement.setInt(i + 1, instructorIds.get(i));
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int instructorId = rs.getInt("PersonID");
                int courseId = rs.getInt("CourseID");
                String title = rs.getString("Title");
                int credits = rs.getInt("Credits");
                int departmentID = rs.getInt("DepartmentID");
                // Create course DTO
                CourseDTO course = new CourseDTO(courseId, departmentID, credits, title);
                // Add course to the corresponding instructor ID in the map
                if (!courseInstructorMap.containsKey(instructorId)) {
                    courseInstructorMap.put(instructorId, new ArrayList<>());
                }
                courseInstructorMap.get(instructorId).add(course);
            }
            for (PersonDTO instructor : instructors) {
                int instructorId = instructor.getPersonID();
                if (courseInstructorMap.containsKey(instructorId)) {
                    instructor.setCourses(courseInstructorMap.get(instructorId));
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
