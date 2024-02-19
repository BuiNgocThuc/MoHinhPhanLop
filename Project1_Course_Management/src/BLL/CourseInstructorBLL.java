package BLL;

import DAL.CourseInstructorDAL;
import DTO.CourseInstructorDTO;
import java.util.List;

public class CourseInstructorBLL {

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
    
    public List<CourseInstructorDTO> getAllCourseInstructor() {
        /**
         * CourseInstructorDTO { personId, courseId }
         */
        List<CourseInstructorDTO> courseInstructorDTOs = null;
        
        new CourseInstructorDAL().populate(courseInstructorDTOs, new String[] {"person"});
        
        return null;
    }
    
    public List<CourseInstructorDTO> getAllCourseInstructorByPersonId() {
        return null;
    }
}
