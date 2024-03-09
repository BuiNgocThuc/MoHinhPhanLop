package BLL.Entity;

public class CourseInstructorEntity {

    private int CourseID, PersonID;
    public CourseEntity courseDTO;
    public PersonEntity personDTO;

    public CourseInstructorEntity(int courseID, int personID) {
        CourseID = courseID;
        PersonID = personID;
    }

    public CourseInstructorEntity(int CourseID, int PersonID, CourseEntity courseDTO, PersonEntity personDTO) {
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
