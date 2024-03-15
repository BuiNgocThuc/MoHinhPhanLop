/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.Entity.CourseEntity;
import BLL.Entity.DepartmentEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buing
 */
public class DepartmentDAL {

    private Connection conn;
    private PreparedStatement preStm;
    private List<DepartmentEntity> listDepartment = new ArrayList<>();

    public DepartmentDAL() {
        ConnectDB connectDB = new ConnectDB();
        conn = (Connection) connectDB.getConnectDB();
    }

    public List<DepartmentEntity> selectAll() {
        String query = "SELECT * FROM department";
        try
        {
            preStm = conn.prepareStatement(query);
            ResultSet rs = preStm.executeQuery();
            while (rs.next())
            {
                int departmentID = rs.getInt(1);
                String name = rs.getString(2);
                double budget = rs.getDouble(3);
                Timestamp startDate = rs.getTimestamp(4);
                int admin = rs.getInt(5);

                DepartmentEntity department = new DepartmentEntity(departmentID, budget, name, admin, startDate);
                
                listDepartment.add(department);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listDepartment;
    }
    
    public DepartmentEntity selectByID(int departmentID) {
        listDepartment = selectAll();
        for(DepartmentEntity department : listDepartment) {
            if(department.getDepartmentID() == departmentID) {
                return department;
            }
        }
        return null;
    }
}
