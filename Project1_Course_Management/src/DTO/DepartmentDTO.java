package DTO;

import java.sql.Timestamp;

public class DepartmentDTO {
    private int DepartmentID, Administrator;
    private double Budget;
    private String Name;
    private Timestamp StartDate;

    public DepartmentDTO(int departmentID, double budget, String name, int administrator, Timestamp startDate) {
        DepartmentID = departmentID;
        Budget = budget;
        Name = name;
        Administrator = administrator;
        StartDate = startDate;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }

    public double getBudget() {
        return Budget;
    }

    public void setBudget(double budget) {
        Budget = budget;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAdministrator() {
        return Administrator;
    }

    public void setAdministrator(int administrator) {
        Administrator = administrator;
    }

    public Timestamp getStartDate() {
        return StartDate;
    }

    public void setStartDate(Timestamp startDate) {
        StartDate = startDate;
    }
}
