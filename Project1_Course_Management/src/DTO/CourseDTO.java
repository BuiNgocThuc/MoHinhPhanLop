package DTO;

import java.util.List;

public class CourseDTO {

    private int CourseID;
    private String Title;
    private int Credits, DepartmentID;
    private String course_type;
    private List<PersonDTO> instructors;

    public List<PersonDTO> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<PersonDTO> instructors) {
        this.instructors = instructors;
    }

    public CourseDTO(int courseID, int departmentID, int credits, String title) {
        this.CourseID = courseID;
        this.DepartmentID = departmentID;
        this.Credits = credits;
        this.Title = title;
    }

    public CourseDTO(int CourseID, String Title, int Credits, int DepartmentID, String course_type) {
        this.CourseID = CourseID;
        this.Title = Title;
        this.Credits = Credits;
        this.DepartmentID = DepartmentID;
        this.course_type = course_type;
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

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    @Override
    public String toString() {
        return "Course{"
                + "CourseID=" + CourseID
                + ", DepartmentID=" + DepartmentID
                + ", Credits=" + Credits
                + ", Title='" + Title + '\''
                + '}';
    }
}
