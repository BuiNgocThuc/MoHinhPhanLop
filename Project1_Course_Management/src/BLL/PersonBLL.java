/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.CourseInstructorDTO;
/**
 *
 * @author buing
 */
public class PersonBLL {
    
    public void addCourse(CourseInstructorDTO courseInstructorDTO) throws Exception{
        try {
            // Validation data
            // throw if incorrect
            
            // Call to CourseInstructorBLL to check exist relationship
            // if exist throw Exception;
            
            // insert relationship -> call to CourseInstrcutorDAL
            // if error, throw SQLException;

            // Done
        } catch (Exception e) {
            throw e;
        }
    }
}
