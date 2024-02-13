/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.ArrayList;
import DTO.OnlineCourseDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author buing
 */
public class OnlineCourseDAL {

    private Connection conn;
    private PreparedStatement preStm;

    public OnlineCourseDAL() {
        ConnectDB connectDB = new ConnectDB();
        conn = (Connection) connectDB.getConnectDB();
    }

    public List<OnlineCourseDTO> selectAll() {
        List<OnlineCourseDTO> listOnlCourses = new ArrayList<>();
        String query = "SELECT * FROM onlinecourse";
        try
        {
            preStm = conn.prepareStatement(query);
            ResultSet rs = preStm.executeQuery();
            while (rs.next())
            {
                int CourseID = rs.getInt("CourseID");
                String url = rs.getString("url");

                OnlineCourseDTO OnlCourse = new OnlineCourseDTO();
                OnlCourse.setCourseID(CourseID);
                OnlCourse.setUrl(url);

                listOnlCourses.add(OnlCourse);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listOnlCourses;
    }
    
    public boolean insertOnlineCourse(OnlineCourseDTO onlCourse) {
        int result = -1;
        
        int CourseID = onlCourse.getCourseID();
        String url = onlCourse.getUrl();

        String query = "INSERT INTO onlinecourse(CourseID, url) VALUES (?,?)";
        try
        {
            preStm = conn.prepareStatement(query);
            preStm.setInt(1, CourseID);
            preStm.setString(2, url);

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
    
    public boolean updateOnlineCourse(OnlineCourseDTO onlCourse) {
         int result = -1;
        
        int CourseID = onlCourse.getCourseID();
        String url = onlCourse.getUrl();

        String query = "UPDATE onlinecourse SET url = ? WHERE CourseID = ?";
        try
        {
            preStm = conn.prepareStatement(query);
            preStm.setInt(4, CourseID);
            preStm.setString(1, url);
            
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
    
    public boolean deleteOnlineCourse(int CourseID) {
         int result = -1;

        String query = "DELETE FROM onlinecourse WHERE CourseID = ?";
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
