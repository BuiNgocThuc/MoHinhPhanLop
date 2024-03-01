/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DepartmentDAL;
import BLL.Entity.DepartmentEntity;
import java.util.List;

/**
 *
 * @author buing
 */
public class DepartmentBLL {
    private DepartmentDAL departmentDAL;
    
    public DepartmentBLL() {
        departmentDAL = new DepartmentDAL();
    }
    
    public List<DepartmentEntity> selectAll() {
        return departmentDAL.selectAll();
    }
    
    public DepartmentEntity selectByID(int departmentID) {
        return departmentDAL.selectByID(departmentID);
    }
}
