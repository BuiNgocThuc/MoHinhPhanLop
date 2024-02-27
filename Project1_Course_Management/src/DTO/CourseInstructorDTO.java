package DTO;

public class CourseInstructorDTO {

    private int CourseID, PersonID;
    public CourseDTO courseDTO;
    public PersonDTO personDTO;

    public CourseInstructorDTO(int courseID, int personID) {
        CourseID = courseID;
        PersonID = personID;
    }

    public CourseInstructorDTO(int CourseID, int PersonID, CourseDTO courseDTO, PersonDTO personDTO) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
        this.courseDTO = courseDTO;
        this.personDTO = personDTO;
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

    @Override
    public String toString() {
        return "CourseInstructorDTO{" + "CourseID=" + CourseID + ", PersonID=" + PersonID + ", courseDTO=" + courseDTO + ", personDTO=" + personDTO + '}';
    }

}
