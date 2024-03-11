/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.Entity.CourseEntity;
import BLL.Entity.PersonEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Paginate;

/**
 *
 * @author buing
 */
public class PersonDAL {

    private ConnectDB con = new ConnectDB();

    public ArrayList<PersonEntity> getAllList() {
        ArrayList<PersonEntity> listPerson = new ArrayList<PersonEntity>();
        try {
            String query = "select * from person";
            PreparedStatement pre = con.getConnectDB().prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                PersonEntity person = new PersonEntity();
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

    public PersonEntity detailsPerson(int id) {
        try {
            PersonEntity person = new PersonEntity();
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

    public ArrayList<PersonEntity> getListStudent() {
        ArrayList<PersonEntity> listPerson = new ArrayList<PersonEntity>();
        try {
            String query = "SELECT * FROM person WHERE EnrollmentDate IS NOT NULL;";
            PreparedStatement pre = con.getConnectDB().prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                PersonEntity person = new PersonEntity();
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

    public ArrayList<PersonEntity> getListInstructor() {
        ArrayList<PersonEntity> listPerson = new ArrayList<PersonEntity>();
        try {
            String query = "SELECT * FROM person WHERE HireDate IS NOT NULL";
            PreparedStatement pre = con.getConnectDB().prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                PersonEntity person = new PersonEntity();
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

    public Paginate<PersonEntity> getListInstructorAssignedCourse(int offset, int limit, String querySearch) {
        List<PersonEntity> listPerson = new ArrayList<>();
        try {
            String baseQuery = "SELECT * FROM person WHERE HireDate IS NOT NULL ";

            if (querySearch != null && !querySearch.isEmpty()) {
                baseQuery += "AND (FirstName LIKE ? OR LastName LIKE ?)";
            }

            String countQuery = "SELECT COUNT(*) AS total FROM (" + baseQuery + ") AS subquery";

            baseQuery += " LIMIT ? OFFSET ?";

            PreparedStatement countPre = con.getConnectDB().prepareStatement(countQuery);
            PreparedStatement pre = con.getConnectDB().prepareStatement(baseQuery);

            // Set search parameters if provided for both queries
            int paramIndex = 1;
            if (querySearch != null && !querySearch.isEmpty()) {
                countPre.setString(paramIndex, "%" + querySearch + "%");
                pre.setString(paramIndex++, "%" + querySearch + "%");
                countPre.setString(paramIndex, "%" + querySearch + "%");
                pre.setString(paramIndex++, "%" + querySearch + "%");
            }

            ResultSet countRs = countPre.executeQuery();
            int totalItems = 0;
            if (countRs.next()) {
                totalItems = countRs.getInt("total");
            }

            pre.setInt(paramIndex++, limit);
            pre.setInt(paramIndex, offset);

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                PersonEntity person = new PersonEntity();
                person.setPersonID(rs.getInt("PersonID"));
                person.setLastName(rs.getString("Lastname"));
                person.setFirstName(rs.getString("Firstname"));
                person.setHireDate(rs.getTimestamp("HireDate"));
                person.setEnrollmentDate(rs.getTimestamp("EnrollmentDate"));
                listPerson.add(person);
            }

            // Calculate total pages
            int totalPages = (int) Math.ceil((double) totalItems / limit);

            // Create Paginate object
            Paginate<PersonEntity> paginate = new Paginate<>(offset, totalItems, 1, totalPages, listPerson);

            return paginate;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<PersonEntity> findInstructorsById(int s) {
        ArrayList<PersonEntity> instructors = new ArrayList<>();
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
                PersonEntity instructor = new PersonEntity(instructorId, firstName, lastName, hireDate, enrollmentDate);
                instructors.add(instructor);
            }
            return instructors;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<PersonEntity> findInstrutorsByName(String name) {
        ArrayList<PersonEntity> instructors = new ArrayList<>();
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
                PersonEntity instructor = new PersonEntity(instructorId, firstName, lastName, hireDate, enrollmentDate);
                instructors.add(instructor);
            }
            return instructors;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

        public void populateCourses(List<PersonEntity> instructors) throws SQLException {
            if (instructors.isEmpty()) {
                return;
            }
            // Collecting instructor IDs
            List<Integer> instructorIds = new ArrayList<>();
            for (PersonEntity instructor : instructors) {
                instructorIds.add(instructor.getPersonID());
            }
            // Mapping instructor IDs to courses
            Map<Integer, List<CourseEntity>> courseInstructorMap = new HashMap<>();
            try {
                List<CourseEntity> courses = new ArrayList<>();
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
                    CourseEntity course = new CourseEntity(courseId, departmentID, credits, title);
                    // Add course to the corresponding instructor ID in the map
                    if (!courseInstructorMap.containsKey(instructorId)) {
                        courseInstructorMap.put(instructorId, new ArrayList<>());
                    }
                    courseInstructorMap.get(instructorId).add(course);
                }
                for (PersonEntity instructor : instructors) {
                    int instructorId = instructor.getPersonID();
                    if (courseInstructorMap.containsKey(instructorId)) {
                        instructor.setCourses(courseInstructorMap.get(instructorId));
                    }
                }
            } catch (SQLException e) {
                throw e;
            }
        }

    public boolean addPerson(PersonEntity person) throws SQLException {
        try {
            String query = "INSERT INTO person (Lastname, Firstname, HireDate, EnrollmentDate) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.getConnectDB().prepareStatement(query);
            preparedStatement.setString(1, person.getLastName());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setTimestamp(3, person.getHireDate());
            preparedStatement.setTimestamp(4, person.getEnrollmentDate());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    public boolean insertPerson(PersonEntity personDTO) {
        int result = -1;

        int personID = personDTO.getPersonID();
        String lastName = personDTO.getLastName();
        String firstName = personDTO.getFirstName();
        Timestamp hireDate = personDTO.getHireDate();
        Timestamp enrollmentDate = personDTO.getEnrollmentDate();

        String query = "INSERT INTO person(PersonID, LastName, FirstName, HireDate, EnrollmentDate) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preStm = con.getConnectDB().prepareStatement(query);
            preStm.setInt(1, personID);
            preStm.setString(2, lastName);
            preStm.setString(3, firstName);
            preStm.setTimestamp(4, hireDate);
            preStm.setTimestamp(5, enrollmentDate);

            result = preStm.executeUpdate();
            if (result != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getAutoIncrement() {
        int result = -1;
        try {
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'school' AND   TABLE_NAME   = 'person'";
            PreparedStatement pst = con.getConnectDB().prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs2.next()) {
                    result = rs2.getInt("AUTO_INCREMENT");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
