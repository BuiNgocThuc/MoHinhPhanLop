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
    private List<CourseDTO> listCourses = new ArrayList<>();

    public CourseDAL() {
        ConnectDB connectDB = new ConnectDB();
        conn = (Connection) connectDB.getConnectDB();
    }
    
    public List<CourseDTO> selectAll() {
         String query = "SELECT * FROM course";
        try
        {
            preStm = conn.prepareStatement(query);
            ResultSet rs = preStm.executeQuery();
            while (rs.next())
            {
                int CourseID = rs.getInt("CourseID");
                String Title = rs.getString("Title");
                int Credits = rs.getInt("Credits");
                int DepartmentID = rs.getInt("DepartmentID");

                CourseDTO course = new CourseDTO(CourseID, DepartmentID, Credits, Title);
                
                listCourses.add(course);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listCourses;
    }

    public CourseDTO selectCourseByID(int CourseID) {
        for(CourseDTO course : listCourses) {
            if(course.getCourseID() == CourseID) {
                return course;
            }
        }
        return null;
    }

    public List<OnlineCourseDTO> selectAllOnlineCourse() {
        List<OnlineCourseDTO> listOnlCourses = onlCourseDAL.selectAll();

        listCourses = selectAll();
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

        listCourses = selectAll();
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
    
    public ArrayList<CourseDTO> getAllList(){
        ArrayList<CourseDTO> listCourse=new ArrayList<CourseDTO>();
        try{
            String query="select * from course";
            PreparedStatement pre=conn.prepareStatement(query);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                CourseDTO course=new CourseDTO();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                listCourse.add(course);
            }
            return listCourse;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public CourseDTO courseDetail(int id){
        try{
            String query="select * from course where CourseID=?";
            PreparedStatement pre=conn.prepareStatement(query);
            pre.setInt(1, id);
            ResultSet rs=pre.executeQuery();
            CourseDTO course=new CourseDTO();
            if(rs.next()){
                
                course.setCourseID(id);
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                course.setTitle(rs.getString("Title"));
            }
            return course;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<CourseDTO> getAllList(String text){
        ArrayList<CourseDTO> listCourse=new ArrayList<CourseDTO>();
        try{
            String query="";
            if(text.equals("Online")){
                query="select * from course where CourseID not in (select CourseID from onsitecourse)";
            }else{
                query="select * from course where CourseID not in (select CourseID from onlinecourse)";
            }
            PreparedStatement pre=conn.prepareStatement(query);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                CourseDTO course=new CourseDTO();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                listCourse.add(course);
            }
            return listCourse;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    } 
   
}
