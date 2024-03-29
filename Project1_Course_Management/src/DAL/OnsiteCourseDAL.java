/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.Entity.OnlineCourseEntity;
import BLL.Entity.OnsiteCourseEntity;
import java.sql.Time;
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
public class OnsiteCourseDAL {

    private Connection conn;
    private PreparedStatement preStm;
    private List<OnsiteCourseEntity> listOnsCourses = new ArrayList<>();

    public OnsiteCourseDAL() {
        ConnectDB connectDB = new ConnectDB();
        conn = (Connection) connectDB.getConnectDB();
        listOnsCourses = selectAll();
    }

    public List<OnsiteCourseEntity> selectAll() {
        List<OnsiteCourseEntity> list = new ArrayList<>();
        String query = "SELECT * FROM onsitecourse";
        try
        {
            preStm = conn.prepareStatement(query);
            ResultSet rs = preStm.executeQuery();
            while (rs.next())
            {
                int CourseID = rs.getInt("CourseID");
                String Location = rs.getString("Location");
                String Days = rs.getString("Days");
                Time time = rs.getTime("Time");

                OnsiteCourseEntity OnsCourse = new OnsiteCourseEntity();
                OnsCourse.setCourseID(CourseID);
                OnsCourse.setDays(Days);
                OnsCourse.setLocation(Location);
                OnsCourse.setTime(time);

                list.add(OnsCourse);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return list;
    }
    
    // xem chi tiết
     public OnsiteCourseEntity selectByID(int CourseID) {
        OnsiteCourseEntity course = null;
        String query = "SELECT * FROM onsitecourse WHERE CourseID = ?";
         try
        {
            preStm = conn.prepareStatement(query);
            preStm.setString(1, String.valueOf(CourseID));

            ResultSet rs = preStm.executeQuery();
            while (rs.next())
            {
                String location = rs.getString("Location");
                String days = rs.getString("Days");
                Time time = rs.getTime("Time");

               course = new OnsiteCourseEntity();
               course.setLocation(location);
               course.setDays(days);
               course.setTime(time);

            }
            
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return course;
    }

    public boolean insertOnsiteCourse(OnsiteCourseEntity onsCourse) {
        int result = -1;

        int CourseID = onsCourse.getCourseID();
        String Location = onsCourse.getLocation();
        String Days = onsCourse.getDays();
        Time Time = onsCourse.getTime();

        String query = "INSERT INTO onsitecourse(CourseID, Location, Days, Time) VALUES (?,?,?,?)";
        try
        {
            preStm = conn.prepareStatement(query);
            preStm.setInt(1, CourseID);
            preStm.setString(2, Location);
            preStm.setString(3, Days);
             preStm.setTime(4, Time);

            result = preStm.executeUpdate();
            if (result != 0)
            {
                listOnsCourses = selectAll();
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateOnsiteCourse(OnsiteCourseEntity onsCourse) {
        int result = -1;

        int CourseID = onsCourse.getCourseID();
        String Location = onsCourse.getLocation();
        String Days = onsCourse.getDays();
        Time Time = onsCourse.getTime();

        String query = "UPDATE onsitecourse SET Location = ?, Days = ?, Time = ? WHERE CourseID = ?";
        try
        {
            preStm = conn.prepareStatement(query);
            preStm.setInt(4, CourseID);
            preStm.setString(1, Location);
            preStm.setString(2, Days);
            preStm.setTime(3, Time);

            result = preStm.executeUpdate();
            if (result != 0)
            {
                listOnsCourses = selectAll();
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteOnsiteCourse(int CourseID) {
        int result = -1;

        String query = "DELETE FROM onsitecourse WHERE CourseID = ?";
        try
        {
            preStm = conn.prepareStatement(query);
            preStm.setInt(1, CourseID);

            result = preStm.executeUpdate();
            if (result != 0)
            {
                listOnsCourses = selectAll();
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
//        public List<OnsiteCourseDTO> searchOnsiteCourse(String sequenceChar) {
//        List<OnsiteCourseDTO> listOnlCoursesFiltered = new ArrayList<>();
//        if (sequenceChar == null || sequenceChar.isEmpty())
//        {
//            return listOnsCourses;
//        }
//        for (OnsiteCourseEntity onsCourse : listOnsCourses)
//        {
//            if (onsCourse.getTitle().toLowerCase().contains(sequenceChar.toLowerCase()))
//            {
//                listOnlCoursesFiltered.add(onsCourse);
//            }
//        }
//        return listOnlCoursesFiltered;
//    }
}
