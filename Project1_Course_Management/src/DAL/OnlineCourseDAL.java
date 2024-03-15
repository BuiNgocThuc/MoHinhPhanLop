/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.ArrayList;
import BLL.Entity.OnlineCourseEntity;
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
    private List<OnlineCourseEntity> listOnlCourses = new ArrayList<>();

    public OnlineCourseDAL() {
        ConnectDB connectDB = new ConnectDB();
        conn = (Connection) connectDB.getConnectDB();
        listOnlCourses = selectAll();
    }

    // xem danh sách
    public List<OnlineCourseEntity> selectAll() {
        List<OnlineCourseEntity> list = new ArrayList<>();
        String query = "SELECT * FROM onlinecourse";
        try
        {
            preStm = conn.prepareStatement(query);
            ResultSet rs = preStm.executeQuery();
            while (rs.next())
            {
                int CourseID = rs.getInt("CourseID");
                String url = rs.getString("url");

                OnlineCourseEntity OnlCourse = new OnlineCourseEntity();
                OnlCourse.setCourseID(CourseID);
                OnlCourse.setUrl(url);

                list.add(OnlCourse);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return list;
    }

    // xem chi tiết
 public OnlineCourseEntity selectByID(int CourseID) {
        OnlineCourseEntity course = null;
        String query = "SELECT * FROM onlinecourse WHERE CourseID = ?";
         try
        {
            preStm = conn.prepareStatement(query);
            preStm.setString(1, String.valueOf(CourseID));

            ResultSet rs = preStm.executeQuery();
            while (rs.next())
            {
                String url = rs.getString("Url");

               course = new OnlineCourseEntity();
               course.setUrl(url);
            }
            
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return course;
    }

    public boolean insertOnlineCourse(OnlineCourseEntity onlCourse) {
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
                 listOnlCourses = selectAll();
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateOnlineCourse(OnlineCourseEntity onlCourse) {
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
                 listOnlCourses = selectAll();
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
                 listOnlCourses = selectAll();
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

//    public List<OnlineCourseDTO> searchOnlineCourse(String sequenceChar) {
//        List<OnlineCourseDTO> listOnlCoursesFiltered = new ArrayList<>();
//        if (sequenceChar == null || sequenceChar.isEmpty())
//        {
//            return listOnlCourses;
//        }
//        for (OnlineCourseEntity onlCourse : listOnlCourses)
//        {
//            if (onlCourse.getTitle().toLowerCase().contains(sequenceChar.toLowerCase()))
//            {
//                listOnlCoursesFiltered.add(onlCourse);
//            }
//        }
//        return listOnlCoursesFiltered;
//    }
}
