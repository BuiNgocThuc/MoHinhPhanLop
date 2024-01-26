/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author buing
 */
public class OnlineCourseDTO extends CourseDTO {
    private String Url;

    public OnlineCourseDTO(String Url, int courseID, int departmentID, int credits, String title) {
        super(courseID, departmentID, credits, title);
        this.Url = Url;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    @Override
    public String toString() {
        return "OnlineCourseDTO{" + "Url=" + Url + '}';
    }
}
