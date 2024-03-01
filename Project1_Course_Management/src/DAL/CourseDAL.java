/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.CourseDTO;
import DTO.OnlineCourseDTO;
import DTO.OnsiteCourseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAL {

    private Connection conn;
    private PreparedStatement preStm;
    private OnlineCourseDAL onlCourseDAL = new OnlineCourseDAL();
    private OnsiteCourseDAL onsCourseDAL = new OnsiteCourseDAL();
    private List<CourseDTO> listCourses;

    public CourseDAL() {
        ConnectDB connectDB = new ConnectDB();
        conn = (Connection) connectDB.getConnectDB();
    }

    public List<CourseDTO> selectAll() {
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

                CourseDTO course = new CourseDTO(CourseID, Title, Credits, DepartmentID, course_type);

                listCourses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listCourses;
    }

    public CourseDTO selectCourseByID(int CourseID) {
        CourseDTO course = null;
        String query = "SELECT * FROM course WHERE CourseID = ?";
        try {
            preStm = conn.prepareStatement(query);
            preStm.setString(1, String.valueOf(CourseID));

            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {
                String Title = rs.getString("Title");
                int Credits = rs.getInt("Credits");
                int DepartmentID = rs.getInt("DepartmentID");

                course = new CourseDTO(CourseID, DepartmentID, Credits, Title);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    public List<OnlineCourseDTO> selectAllOnlineCourse() {
        List<OnlineCourseDTO> listOnlCourses = onlCourseDAL.selectAll();

        listCourses = selectAll();
        for (OnlineCourseDTO onlCourse : listOnlCourses) {
            int CourseID = onlCourse.getCourseID();
            CourseDTO course = selectCourseByID(CourseID);

            String Title = course.getTitle();
            int DepartmentID = course.getDepartmentID();
            int Credits = course.getCredits();

            onlCourse.setCredits(Credits);
            onlCourse.setDepartmentID(DepartmentID);
            onlCourse.setTitle(Title);
        }

        return listOnlCourses;
    }

    public List<OnsiteCourseDTO> selectAllOnsiteCourse() {
        List<OnsiteCourseDTO> listOnsCourses = onsCourseDAL.selectAll();

        listCourses = selectAll();
        for (OnsiteCourseDTO onsCourse : listOnsCourses) {
            int CourseID = onsCourse.getCourseID();
            CourseDTO course = selectCourseByID(CourseID);

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
        for (CourseDTO course : listCourses) {
            MaxID = course.getCourseID() > MaxID ? course.getCourseID() : MaxID;
        }
        return MaxID;
    }

    public boolean insertCourse(CourseDTO course) {
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

    public boolean updateCourse(CourseDTO course) {
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

    public boolean deleteCourse(int CourseID) {
        int result = -1;

        String query = "DELETE FROM course WHERE CourseID = ?";
        try {
            preStm = conn.prepareStatement(query);
            preStm.setInt(1, CourseID);

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

    public boolean checkCourseEmpty(int CourseID) {
        String query = "SELECT\n"
                + "    (SELECT COUNT(*) FROM courseinstructor WHERE CourseID =" + CourseID + ") AS NumCourseInstructors,\n"
                + "    (SELECT COUNT(*) FROM studentgrade WHERE CourseID = " + CourseID + ") AS NumStudentsEnrolled;";
        try {
            preStm = conn.prepareStatement(query);
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {
                int numCourseInstructors = rs.getInt("NumCourseInstructors");
                int numStudentsEnrolled = rs.getInt("NumStudentsEnrolled");

                if (numCourseInstructors > 0 || numStudentsEnrolled > 0) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    //    public List<CourseDTO> searchCourse(String sequenceChar) {
    //        List<CourseDTO> listCourseFiltered = new ArrayList<>();
    //        if (sequenceChar == null || sequenceChar.isEmpty() || sequenceChar.isBlank())
    //        {
    //            return listCourses;
    //        }
    //        for (CourseDTO course : listCourses)
    //        {
    //            if (course.getTitle().toLowerCase().contains(sequenceChar.toLowerCase()) || String.valueOf(course.getCourseID()).contains(sequenceChar))
    //            {
    //                listCourseFiltered.add(course);
    //            }
    //        }
    //        return listCourseFiltered;
    //    }

    public ArrayList<CourseDTO> getAllList() {
        ArrayList<CourseDTO> listCourse = new ArrayList<CourseDTO>();
        try {
            String query = "select * from course";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseDTO course = new CourseDTO();
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

    public CourseDTO courseDetail(int id) {
        try {
            String query = "select * from course where CourseID=?";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            CourseDTO course = new CourseDTO();
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

    public ArrayList<CourseDTO> getAllList(String text) {
        ArrayList<CourseDTO> listCourse = new ArrayList<CourseDTO>();
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
                CourseDTO course = new CourseDTO();
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

    public ArrayList<CourseDTO> findCoursesByNameAll(String s) {
        ArrayList<CourseDTO> listCourse = new ArrayList<CourseDTO>();
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
                CourseDTO course = new CourseDTO();
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

    public ArrayList<CourseDTO> findCoursesByNameOnsite(String s) {
        ArrayList<CourseDTO> listCourse = new ArrayList<CourseDTO>();
        try {
            String query = "SELECT \n"
                    + "    course.*, 'Onsite' as course_type\n"
                    + "FROM course\n"
                    + "LEFT JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID\n"
                    + "where course.Title LIKE " + "'%" + s + "%'";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseDTO course = new CourseDTO();
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

    public ArrayList<CourseDTO> findCoursesByNameOnline(String s) {
        ArrayList<CourseDTO> listCourse = new ArrayList<CourseDTO>();
        try {
            String query = "SELECT \n"
                    + "    course.*, 'Online' as course_type\n"
                    + "FROM course\n"
                    + "LEFT JOIN onlinecourse ON course.CourseID = onlinecourse.CourseID\n"
                    + "where course.Title LIKE " + "'%" + s + "%'";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseDTO course = new CourseDTO();
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

    public ArrayList<CourseDTO> findCoursesByIdAll(int s) {
        ArrayList<CourseDTO> listCourse = new ArrayList<CourseDTO>();
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
                CourseDTO course = new CourseDTO();
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

    public ArrayList<CourseDTO> findCoursesByIdOnsite(int s) {
        ArrayList<CourseDTO> listCourse = new ArrayList<CourseDTO>();
        try {
            String query = "SELECT *\n" +
                            "FROM (\n" +
                            "    SELECT course.*, 'Onsite' as course_type \n" +
                            "    FROM course \n" +
                            "    JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID\n" +
                            ") AS subquery\n" +
                            "WHERE CourseID LIKE CONCAT('%'," + s + ",'%');";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseDTO course = new CourseDTO();
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

    public ArrayList<CourseDTO> findCoursesByIdOnline(int s) {
        ArrayList<CourseDTO> listCourse = new ArrayList<CourseDTO>();
        try {
            String query = "SELECT *\n" +
                            "FROM (\n" +
                            "    SELECT course.*, 'Online' as course_type \n" +
                            "    FROM course \n" +
                            "    JOIN onlinecourse ON course.CourseID = onlinecourse.CourseID\n" +
                            ") AS subquery\n" +
                            "WHERE CourseID LIKE CONCAT('%'," + s + ",'%');";
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CourseDTO course = new CourseDTO();
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
}
