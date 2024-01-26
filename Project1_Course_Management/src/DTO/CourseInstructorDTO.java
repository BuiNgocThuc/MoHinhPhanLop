package DTO;

public class CourseInstructorDTO {
    private int CourseID, PersonID;

    public CourseInstructorDTO(int courseID, int personID) {
        CourseID = courseID;
        PersonID = personID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }
}
