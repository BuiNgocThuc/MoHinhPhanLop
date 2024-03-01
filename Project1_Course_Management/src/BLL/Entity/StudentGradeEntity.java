package BLL.Entity;

public class StudentGradeEntity {
    private int EnrollmentID, StudentID, CourseID;
    private double Grade;
    
    public StudentGradeEntity() {
        
    }

    public StudentGradeEntity(int enrollmentID, int studentID, int courseID, double grade) {
        EnrollmentID = enrollmentID;
        StudentID = studentID;
        CourseID = courseID;
        Grade = grade;
    }

    public int getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        EnrollmentID = enrollmentID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public double getGrade() {
        return Grade;
    }

    public void setGrade(double grade) {
        Grade = grade;
    }
}
