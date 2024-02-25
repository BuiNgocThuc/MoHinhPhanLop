package DTO;

import java.sql.Timestamp;

public class PersonDTO {
    private int PersonID;
    private String LastName, FirstName;
    private Timestamp HireDate, EnrollmentDate;
    
    public PersonDTO() {
        
    }

    public PersonDTO(int personID, String firstName, String lastName, Timestamp hireDate, Timestamp enrollmentDate) {
        PersonID = personID;
        FirstName = firstName;
        LastName = lastName;
        HireDate = hireDate;
        EnrollmentDate = enrollmentDate;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Timestamp getHireDate() {
        return HireDate;
    }

    public void setHireDate(Timestamp hireDate) {
        HireDate = hireDate;
    }

    public Timestamp getEnrollmentDate() {
        return EnrollmentDate;
    }

    public void setEnrollmentDate(Timestamp enrollmentDate) {
        EnrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "PersonID=" + PersonID +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", HireDate=" + HireDate +
                ", EnrollmentDate=" + EnrollmentDate +
                '}';
    }
}
