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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author buing
 */
public class CourseDAL {

    private Connection conn;
    private PreparedStatement preStm;
    private OnlineCourseDAL onlCourseDAL = new OnlineCourseDAL();
    private OnsiteCourseDAL onsCourseDAL = new OnsiteCourseDAL();

    public CourseDAL() {
        ConnectDB connectDB = new ConnectDB();
        conn = (Connection) connectDB.getConnectDB();
    }

    public CourseDTO selectCourseByID(int CourseID) {
        String query = "SELECT * FROM course WHERE CourseID = ?";

        try
        {
            preStm = conn.prepareStatement(query);
            preStm.setInt(1, CourseID);

            ResultSet rs = preStm.executeQuery();
            while (rs.next())
            {
                String Title = rs.getString("Title");
                int Credits = rs.getInt("Credits");
                int DepartmentID = rs.getInt("DepartmentID");

                CourseDTO course = new CourseDTO(CourseID, DepartmentID, Credits, Title);

                return course;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<OnlineCourseDTO> selectAllOnlineCourse() {
        List<OnlineCourseDTO> listOnlCourses = onlCourseDAL.selectAll();

        for (OnlineCourseDTO onlCourse : listOnlCourses)
        {
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

        for (OnsiteCourseDTO onsCourse : listOnsCourses)
        {
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

    public boolean insertCourse(CourseDTO course) {
        int result = -1;
        
        int CourseID = course.getCourseID();
        String Title = course.getTitle();
        int Credits = course.getCredits();
        int DepartmentID = course.getDepartmentID();

        String query = "INSERT INTO course(CourseID, Title, Credits, DepartmentID) VALUES (?,?,?,?)";
        try
        {
            preStm = conn.prepareStatement(query);
            preStm.setInt(1, CourseID);
            preStm.setString(2, Title);
            preStm.setInt(3, Credits);
            preStm.setInt(4, DepartmentID);
            
            result = preStm.executeUpdate();
            if (result != 0)
            {
                return true;
            }
        } catch (SQLException e)
        {
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
        try
        {
            preStm = conn.prepareStatement(query);
            preStm.setInt(4, CourseID);
            preStm.setString(1, Title);
            preStm.setInt(2, Credits);
            preStm.setInt(3, DepartmentID);
            
            result = preStm.executeUpdate();
            if (result != 0)
            {
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteCourse(int CourseID) {
         int result = -1;

        String query = "DELETE FROM course WHERE CourseID = ?";
        try
        {
            preStm = conn.prepareStatement(query);
            preStm.setInt(1, CourseID);
            
            result = preStm.executeUpdate();
            if (result != 0)
            {
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
