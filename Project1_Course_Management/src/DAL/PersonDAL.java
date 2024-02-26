/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.PersonDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author buing
 */
public class PersonDAL {
    private ConnectDB con=new ConnectDB();
    public ArrayList<PersonDTO> getAllList(){
        ArrayList<PersonDTO> listPerson=new ArrayList<PersonDTO>();
        try{
            String query="select * from person";
            PreparedStatement pre=con.getConnectDB().prepareStatement(query);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                PersonDTO person=new PersonDTO();
                person.setPersonID(rs.getInt("PersonID"));
                person.setLastName(rs.getString("Lastname"));
                person.setFirstName(rs.getString("Firstname"));
                person.setHireDate(rs.getTimestamp("HireDate"));
                person.setEnrollmentDate(rs.getTimestamp("EnrollmentDate"));
                listPerson.add(person);
            }
            return listPerson;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public PersonDTO detailsPerson(int id){
        try{
            PersonDTO person=new PersonDTO();
            String query="select * from person where PersonID=?";
            PreparedStatement pre=con.getConnectDB().prepareStatement(query);
            pre.setInt(1,id);
            ResultSet rs=pre.executeQuery();
            if(rs.next()){
                person.setPersonID(rs.getInt("PersonID"));
                person.setLastName(rs.getString("Lastname"));
                person.setFirstName(rs.getString("Firstname"));
                person.setHireDate(rs.getTimestamp("HireDate"));
                person.setEnrollmentDate(rs.getTimestamp("EnrollmentDate"));
            }
            return person;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<PersonDTO> getListStudent(){
        ArrayList<PersonDTO> listPerson=new ArrayList<PersonDTO>();
        try{
            String query="SELECT *\n" +
                        "FROM person\n" +
                        "WHERE PersonID NOT IN (\n" +
                        "    SELECT PersonID\n" +
                        "    FROM courseinstructor\n" +
                        ");";
            PreparedStatement pre=con.getConnectDB().prepareStatement(query);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                PersonDTO person=new PersonDTO();
                person.setPersonID(rs.getInt("PersonID"));
                person.setLastName(rs.getString("Lastname"));
                person.setFirstName(rs.getString("Firstname"));
                person.setHireDate(rs.getTimestamp("HireDate"));
                person.setEnrollmentDate(rs.getTimestamp("EnrollmentDate"));
                listPerson.add(person);
            }
            return listPerson;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean insertPerson(PersonDTO personDTO) {
        int result = -1;
        
        int personID = personDTO.getPersonID();
        String lastName = personDTO.getLastName();
        String firstName = personDTO.getFirstName();
        Timestamp hireDate = personDTO.getHireDate();
        Timestamp enrollmentDate = personDTO.getEnrollmentDate();
        
        String query = "INSERT INTO person(PersonID, LastName, FirstName, HireDate, EnrollmentDate) VALUES (?,?,?,?,?)";
        try
        {
            PreparedStatement preStm = con.getConnectDB().prepareStatement(query);
            preStm.setInt(1, personID);
            preStm.setString(2, lastName);
            preStm.setString(3, firstName);
            preStm.setTimestamp(4, hireDate);
            preStm.setTimestamp(5, enrollmentDate);
            
            result = preStm.executeUpdate();
            if (result != 0)
            {
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    public int getAutoIncrement() {
        int result = -1;
        try {
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'school' AND   TABLE_NAME   = 'person'";
            PreparedStatement pst = con.getConnectDB().prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst() ) {
                System.out.println("No data");
            } else {
                while ( rs2.next() ) {
                    result = rs2.getInt("AUTO_INCREMENT");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
