/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.OnsiteCourseDTO;
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

    public OnsiteCourseDAL() {
        ConnectDB connectDB = new ConnectDB();
        conn = (Connection) connectDB.getConnectDB();
    }

    public List<OnsiteCourseDTO> selectAll() {
        List<OnsiteCourseDTO> listOnsCourses = new ArrayList<>();
        String query = "SELECT * FROM onlinecourse";
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

                OnsiteCourseDTO OnsCourse = new OnsiteCourseDTO();
                OnsCourse.setCourseID(CourseID);
                OnsCourse.setDays(Days);
                OnsCourse.setLocation(Location);
                OnsCourse.setTime(time);

                listOnsCourses.add(OnsCourse);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listOnsCourses;
    }

    public boolean insertOnsiteCourse(OnsiteCourseDTO onsCourse) {
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
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateOnsiteCourse(OnsiteCourseDTO onsCourse) {
        int result = -1;

        int CourseID = onsCourse.getCourseID();
        String Location = onsCourse.getLocation();
        String Days = onsCourse.getDays();
        Time Time = onsCourse.getTime();

        String query = "UPDATE onlinecourse SET Location = ?, Days = ?, Time = ? WHERE CourseID = ?";
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
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
