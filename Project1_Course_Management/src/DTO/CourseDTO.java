package DTO;

public class CourseDTO {
    private int CourseID;
    private String Title;
    private int Credits, DepartmentID;

    public CourseDTO(int courseID, int departmentID, int credits, String title) {
        CourseID = courseID;
        DepartmentID = departmentID;
        Credits = credits;
        Title = title;
    }

    public CourseDTO() {

    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int credits) {
        Credits = credits;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CourseID=" + CourseID +
                ", DepartmentID=" + DepartmentID +
                ", Credits=" + Credits +
                ", Title='" + Title + '\'' +
                '}';
    }
}
