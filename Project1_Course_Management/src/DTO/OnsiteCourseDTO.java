/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Time;

/**
 *
 * @author buing
 */
public class OnsiteCourseDTO extends CourseDTO {

    private String Location, Days;
    private Time Time;

    public OnsiteCourseDTO() {
    }

    public OnsiteCourseDTO(String Location, String Days, Time Time, int courseID, int departmentID, int credits, String title) {
        super(courseID, departmentID, credits, title);
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }

    public Time getTime() {
        return Time;
    }

    public void setTime(Time Time) {
        this.Time = Time;
    }

    @Override
    public String toString() {
        return "OnsiteCourseDTO{" + "Location=" + Location + ", Days=" + Days + ", Time=" + Time + '}' + super.toString();
    }

}
