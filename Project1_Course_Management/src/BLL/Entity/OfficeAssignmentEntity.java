package BLL.Entity;

import java.sql.Time;
import java.sql.Timestamp;

public class OfficeAssignmentEntity {
    private int InstructorID;
    private String Location;
    private Timestamp Timestamp;

    public OfficeAssignmentEntity(int instructorID, String location, Timestamp timestamp) {
        InstructorID = instructorID;
        Location = location;
        Timestamp = timestamp;
    }

    public int getInstructorID() {
        return InstructorID;
    }

    public void setInstructorID(int instructorID) {
        InstructorID = instructorID;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Timestamp getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        Timestamp = timestamp;
    }
}
