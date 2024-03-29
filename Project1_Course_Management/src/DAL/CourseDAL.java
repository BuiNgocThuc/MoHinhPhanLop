/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.Entity.CourseEntity;
import BLL.Entity.OnlineCourseEntity;
import BLL.Entity.OnsiteCourseEntity;
import BLL.Entity.PersonEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import util.Paginate;

public class CourseDAL {

    private Connection conn;
    private PreparedStatement preStm;
    private OnlineCourseDAL onlCourseDAL = new OnlineCourseDAL();
    private OnsiteCourseDAL onsCourseDAL = new OnsiteCourseDAL();
    private List<CourseEntity> listCourses;

    public CourseDAL() {
        ConnectDB connectDB = new ConnectDB();
        conn = (Connection) connectDB.getConnectDB();
    }

    public List<CourseEntity> selectAll() {
        listCourses = new ArrayList<>();
        String query = "SELECT \n"
                + "    course.*,\n"
                + "    CASE \n"
                + "        WHEN onlinecourse.CourseID IS NOT NULL THEN 'Online'\n"
                + "        WHEN onsitecourse.CourseID IS NOT NULL THEN 'Onsite'\n"
                + "    END AS course_type\n"
                + "FROM course\n"
                + "LEFT JOIN onlinecourse ON course.CourseID = onlinecourse.CourseID\n"
                + "LEFT JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID;";
        try {
            preStm = conn.prepareStatement(query);
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {
                int CourseID = rs.getInt("CourseID");
                String Title = rs.getString("Title");
                int Credits = rs.getInt("Credits");
                int DepartmentID = rs.getInt("DepartmentID");
                String course_type = rs.getString("course_type");

                CourseEntity course = new CourseEntity(CourseID, Title, Credits, DepartmentID, course_type);

                listCourses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listCourses;
    }

    public CourseEntity selectCourseByID(int CourseID) {
        CourseEntity course = null;
        String query = "SELECT * FROM course WHERE CourseID = ?";
        try {
            preStm = conn.prepareStatement(query);
            preStm.setString(1, String.valueOf(CourseID));

            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {
                String Title = rs.getString("Title");
                int Credits = rs.getInt("Credits");
                int DepartmentID = rs.getInt("DepartmentID");

                course = new CourseEntity(CourseID, DepartmentID, Credits, Title);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    public List<OnlineCourseEntity> selectAllOnlineCourse() {
        List<OnlineCourseEntity> listOnlCourses = onlCourseDAL.selectAll();

        listCourses = selectAll();
        for (OnlineCourseEntity onlCourse : listOnlCourses) {
            int CourseID = onlCourse.getCourseID();
            CourseEntity course = selectCourseByID(CourseID);

            String Title = course.getTitle();
            int DepartmentID = course.getDepartmentID();
            int Credits = course.getCredits();

            onlCourse.setCredits(Credits);
            onlCourse.setDepartmentID(DepartmentID);
            onlCourse.setTitle(Title);
        }

        return listOnlCourses;
    }

    public List<OnsiteCourseEntity> selectAllOnsiteCourse() {
        List<OnsiteCourseEntity> listOnsCourses = onsCourseDAL.selectAll();

        listCourses = selectAll();
        for (OnsiteCourseEntity onsCourse : listOnsCourses) {
            int CourseID = onsCourse.getCourseID();
            CourseEntity course = selectCourseByID(CourseID);

            String Title = course.getTitle();
            int DepartmentID = course.getDepartmentID();
            int Credits = course.getCredits();

            onsCourse.setCredits(Credits);
            onsCourse.setDepartmentID(DepartmentID);
            onsCourse.setTitle(Title);
        }

        return listOnsCourses;
    }

    public int selectLastID() {
        int MaxID = Integer.MIN_VALUE;
        for (CourseEntity course : listCourses) {
            MaxID = course.getCourseID() > MaxID ? course.getCourseID() : MaxID;
        }
        return MaxID;
    }

    public boolean insertCourse(CourseEntity course) {
        int result = -1;

        int CourseID = course.getCourseID();
        String Title = course.getTitle();
        int Credits = course.getCredits();
        int DepartmentID = course.getDepartmentID();

        String query = "INSERT INTO course(Title, Credits, DepartmentID) VALUES (?,?,?)";
        try {
            preStm = conn.prepareStatement(query);
            preStm.setString(1, Title);
            preStm.setInt(2, Credits);
            preStm.setInt(3, DepartmentID);

            result = preStm.executeUpdate();
            if (result != 0) {
                listCourses = selectAll();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCourse(CourseEntity course) {
        int result = -1;

        int CourseID = course.getCourseID();
        String Title = course.getTitle();
        int Credits = course.getCredits();
        int DepartmentID = course.getDepartmentID();

        String query = "UPDATE course SET Title = ?, Credits = ?, DepartmentID = ? WHERE CourseID = ?";
        try {
            preStm = conn.prepareStatement(query);
            preStm.setInt(4, CourseID);
            preStm.setString(1, Title);
            preStm.setInt(2, Credits);
            preStm.setInt(3, DepartmentID);

            result = preStm.executeUpdate();
            if (result != 0) {
                listCourses = selectAll();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isCourseInOnlineCourse(int courseID) {
        String queryCheckOnline = "SELECT COUNT(*) FROM onlinecourse WHERE CourseID = ?";
        try {
            // Check if CourseID exists in onlinecourse
            preStm = conn.prepareStatement(queryCheckOnline);
            preStm.setInt(1, courseID);
            ResultSet rsOnline = preStm.executeQuery();
            rsOnline.next();
            int onlineCount = rsOnline.getInt(1);

            // If the CourseID exists in onlinecourse, return true
            if (onlineCount > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCourse(int courseID) {
        boolean flag = isCourseInOnlineCourse(courseID);

        if (flag) {
            // If the course is in the onlinecourse table, delete it from there
            deleteCourseFromOnlineCourse(courseID);
        } else {
            // If the course is not in the onlinecourse table, delete it from onsitecourse
            deleteCourseFromOnsiteCourse(courseID);
        }

        // Delete the course from the course table
        return deleteCourseFromCourseTable(courseID);
    }

    private void deleteCourseFromOnlineCourse(int courseID) {
        String query = "DELETE FROM onlinecourse WHERE CourseID = ?";
        try {
            preStm = conn.prepareStatement(query);
            preStm.setInt(1, courseID);
            preStm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteCourseFromOnsiteCourse(int courseID) {
        String query = "DELETE FROM onsitecourse WHERE CourseID = ?";
        try {
            preStm = conn.prepareStatement(query);
            preStm.setInt(1, courseID);
            preStm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean deleteCourseFromCourseTable(int courseID) {
        int result = -1;
        String query = "DELETE FROM course WHERE CourseID = ?";
        try {
            preStm = conn.prepareStatement(query);
            preStm.setInt(1, courseID);
            result = preStm.executeUpdate();

            if (result != 0) {
                listCourses = selectAll(); // Refresh list of courses
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkCourseEmpty(int CourseID) {
        String query = "SELECT\n"
                + "    (SELECT COUNT(*) FROM courseinstructor WHERE CourseID =" + CourseID
                + ") AS NumCourseInstructors,\n"
                + "    (SELECT COUNT(*) FROM studentgrade WHERE CourseID = " + CourseID + ") AS NumStudentsEnrolled;";
        try {
            preStm = conn.prepareStatement(query);
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {
                int numCourseInstructors = rs.getInt("NumCourseInstructors");
                int numStudentsEnrolled = rs.getInt("NumStudentsEnrolled");

                return !(numCourseInstructors > 0 || numStudentsEnrolled > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    // public List<CourseDTO> searchCourse(String sequenceChar) {
    // List<CourseDTO> listCourseFiltered = new ArrayList<>();
    // if (sequenceChar == null || sequenceChar.isEmpty() || sequenceChar.isBlank())
    // {
    // return listCourses;
    // }
    // for (CourseEntity course : listCourses)
    // {
    // if (course.getTitle().toLowerCase().contains(sequenceChar.toLowerCase()) ||
    // String.valueOf(course.getCourseID()).contains(sequenceChar))
    // {
    // listCourseFiltered.add(course);
    // }
    // }
    // return listCourseFiltered;
    // }

    public ArrayList<CourseEntity> getAllList() {
        ArrayList<CourseEntity> listCourse = new ArrayList<CourseEntity>();
        try {
            String query = "select * from course";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseEntity course = new CourseEntity();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                listCourse.add(course);
            }
            return listCourse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public CourseEntity courseDetail(int id) {
        try {
            String query = "select * from course where CourseID=?";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            CourseEntity course = new CourseEntity();
            if (rs.next()) {

                course.setCourseID(id);
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                course.setTitle(rs.getString("Title"));
            }
            return course;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CourseEntity> getAllList(String text) {
        ArrayList<CourseEntity> listCourse = new ArrayList<CourseEntity>();
        try {
            String query = "";
            if (text.equals("Online")) {
                query = "select * from course where CourseID not in (select CourseID from onsitecourse)";
            } else {
                query = "select * from course where CourseID not in (select CourseID from onlinecourse)";
            }
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseEntity course = new CourseEntity();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                listCourse.add(course);
            }
            return listCourse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CourseEntity> findCoursesByNameAll(String s) {
        ArrayList<CourseEntity> listCourse = new ArrayList<CourseEntity>();
        try {
            String query = "SELECT \n"
                    + "    course.*,\n"
                    + "    CASE \n"
                    + "        WHEN onlinecourse.CourseID IS NOT NULL THEN 'Online'\n"
                    + "        WHEN onsitecourse.CourseID IS NOT NULL THEN 'Onsite'\n"
                    + "    END AS course_type\n"
                    + "FROM course\n"
                    + "LEFT JOIN onlinecourse ON course.CourseID = onlinecourse.CourseID\n"
                    + "LEFT JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID\n"
                    + "where course.Title LIKE " + "'%" + s + "%'";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseEntity course = new CourseEntity();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                course.setCourse_type(rs.getString("course_type"));
                listCourse.add(course);
            }
            return listCourse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CourseEntity> searchAllCourse(String text) {
        ArrayList<CourseEntity> searchAllCourse = new ArrayList<CourseEntity>();
        try {
            String query = "select * from course where UPPER(CONCAT(course.CourseID,course.Title)) like '%" + text + "%'";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseEntity course = new CourseEntity();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                searchAllCourse.add(course);
            }
            return searchAllCourse;
        } catch (Exception ex) {
        }
        return null;
    }

    public List<CourseEntity> selectOnsiteAll() {
        listCourses = new ArrayList<>();
        String query = "SELECT \n"
                + "    course.*, 'Onsite' as course_type\n"
                + "FROM onsitecourse\n"
                + "LEFT JOIN course ON course.CourseID = onsitecourse.CourseID;";
        try {
            preStm = conn.prepareStatement(query);
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {
                int CourseID = rs.getInt("CourseID");
                String Title = rs.getString("Title");
                int Credits = rs.getInt("Credits");
                int DepartmentID = rs.getInt("DepartmentID");
                String course_type = rs.getString("course_type");

                CourseEntity course = new CourseEntity(CourseID, Title, Credits, DepartmentID, course_type);

                listCourses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listCourses;
    }

    public List<CourseEntity> selectOnlineAll() {
        listCourses = new ArrayList<>();
        String query = "SELECT \n"
                + "    course.*, 'Online' as course_type\n"
                + "FROM onlinecourse\n"
                + "LEFT JOIN course ON course.CourseID = onlinecourse.CourseID;";
        try {
            preStm = conn.prepareStatement(query);
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {
                int CourseID = rs.getInt("CourseID");
                String Title = rs.getString("Title");
                int Credits = rs.getInt("Credits");
                int DepartmentID = rs.getInt("DepartmentID");
                String course_type = rs.getString("course_type");

                CourseEntity course = new CourseEntity(CourseID, Title, Credits, DepartmentID, course_type);

                listCourses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listCourses;
    }

    public ArrayList<CourseEntity> findCoursesByNameOnsite(String s) {
        ArrayList<CourseEntity> listCourse = new ArrayList<CourseEntity>();
        try {
            String query = "SELECT \n"
                    + "    course.*, 'Onsite' as course_type\n"
                    + "FROM course\n"
                    + "LEFT JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID\n"
                    + "where course.Title LIKE " + "'%" + s + "%'";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseEntity course = new CourseEntity();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                course.setCourse_type(rs.getString("course_type"));
                listCourse.add(course);
            }
            return listCourse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CourseEntity> findCoursesByNameOnline(String s) {
        ArrayList<CourseEntity> listCourse = new ArrayList<CourseEntity>();
        try {
            String query = "SELECT \n"
                    + "    course.*, 'Online' as course_type\n"
                    + "FROM course\n"
                    + "LEFT JOIN onlinecourse ON course.CourseID = onlinecourse.CourseID\n"
                    + "where course.Title LIKE " + "'%" + s + "%'";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseEntity course = new CourseEntity();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                course.setCourse_type(rs.getString("course_type"));
                listCourse.add(course);
            }
            return listCourse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CourseEntity> findCoursesByIdAll(int s) {
        ArrayList<CourseEntity> listCourse = new ArrayList<CourseEntity>();
        try {
            String query = "SELECT \n"
                    + "    course.*,\n"
                    + "    CASE \n"
                    + "        WHEN onlinecourse.CourseID IS NOT NULL THEN 'Online'\n"
                    + "        WHEN onsitecourse.CourseID IS NOT NULL THEN 'Onsite'\n"
                    + "    END AS course_type\n"
                    + "FROM course\n"
                    + "LEFT JOIN onlinecourse ON course.CourseID = onlinecourse.CourseID\n"
                    + "LEFT JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID\n"
                    + "where course.CourseID LIKE CONCAT('%'," + s + ",'%')";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseEntity course = new CourseEntity();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                course.setCourse_type(rs.getString("course_type"));
                listCourse.add(course);
            }
            return listCourse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CourseEntity> findCoursesByIdOnsite(int s) {
        ArrayList<CourseEntity> listCourse = new ArrayList<CourseEntity>();
        try {
            String query = "SELECT *\n"
                    + "FROM (\n"
                    + "    SELECT course.*, 'Onsite' as course_type \n"
                    + "    FROM course \n"
                    + "    JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID\n"
                    + ") AS subquery\n"
                    + "WHERE CourseID LIKE CONCAT('%'," + s + ",'%')";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseEntity course = new CourseEntity();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                course.setCourse_type(rs.getString("course_type"));
                listCourse.add(course);
            }
            return listCourse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CourseEntity> findCoursesByIdOnline(int s) {
        ArrayList<CourseEntity> listCourse = new ArrayList<>();
        try {
            String query = "SELECT *\n"
                    + "FROM (\n"
                    + "    SELECT course.*, 'Online' as course_type \n"
                    + "    FROM course \n"
                    + "    JOIN onlinecourse ON course.CourseID = onlinecourse.CourseID\n"
                    + ") AS subquery\n"
                    + "WHERE CourseID LIKE CONCAT('%'," + s + ",'%')";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseEntity course = new CourseEntity();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                course.setCourse_type(rs.getString("course_type"));
                listCourse.add(course);
            }
            return listCourse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void populateInstructors(List<CourseEntity> courses) throws SQLException {
        if (courses.isEmpty()) {
            return;
        }
        // Collecting course IDs
        List<Integer> courseIds = new ArrayList<>();
        for (CourseEntity course : courses) {
            courseIds.add(course.getCourseID());
        }
        // Mapping course IDs to instructors
        Map<Integer, List<PersonEntity>> courseInstructorMap = new HashMap<>();
        try {
            List<PersonEntity> instructors = new ArrayList<>();
            String query = "select * from person p join courseinstructor ci "
                    + "on p.PersonID = ci.PersonID "
                    + "where p.HireDate is not null and "
                    + "ci.CourseID IN (";
            for (int i = 0; i < courseIds.size(); i++) {
                query += (i == 0 ? "?" : ", ?");
            }
            query += ")";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            // Set course IDs as parameters
            for (int i = 0; i < courseIds.size(); i++) {
                preparedStatement.setInt(i + 1, courseIds.get(i));
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int instructorId = rs.getInt("PersonID");
                int courseId = rs.getInt("CourseID");
                String firstName = rs.getString("Firstname");
                String lastName = rs.getString("Lastname");
                Timestamp hireDate = rs.getTimestamp("HireDate");
                Timestamp enrollmentDate = rs.getTimestamp("EnrollmentDate");
                // Create instructor DTO
                PersonEntity instructor = new PersonEntity(instructorId, firstName, lastName, hireDate, enrollmentDate);
                // Add instructor to the corresponding course ID in the map
                if (!courseInstructorMap.containsKey(courseId)) {
                    courseInstructorMap.put(courseId, new ArrayList<>());
                }
                courseInstructorMap.get(courseId).add(instructor);
            }
            for (CourseEntity course : courses) {
                int courseId = course.getCourseID();
                if (courseInstructorMap.containsKey(courseId)) {
                    course.setInstructors(courseInstructorMap.get(courseId));
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public Paginate<CourseEntity> getListCourseAssignedInstructor(int offset, int limit, String querySearch) {
        ArrayList<CourseEntity> listCourse = new ArrayList<>();
        try {
            String baseQuery = "SELECT * FROM course";
            if (querySearch != null && !querySearch.isEmpty()) {
                baseQuery += " WHERE Title LIKE ?";
            }
            String countQuery = "SELECT COUNT(*) AS total FROM (" + baseQuery + ") AS subquery";
            baseQuery += " LIMIT ? OFFSET ?";
            PreparedStatement countPre = conn.prepareStatement(countQuery);
            PreparedStatement pre = conn.prepareStatement(baseQuery);
            int paramIndex = 1;
            if (querySearch != null && !querySearch.isEmpty()) {
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
                CourseEntity course = new CourseEntity();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                listCourse.add(course);
            }
            int totalPages = (int) Math.ceil((double) totalItems / limit);
            Paginate<CourseEntity> paginate = new Paginate<>(offset, totalItems, 1, totalPages, listCourse);
            return paginate;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }
}
