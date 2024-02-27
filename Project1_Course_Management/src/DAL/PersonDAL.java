/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.PersonDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
            String query="SELECT * FROM person WHERE EnrollmentDate IS NOT NULL;";
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
    
     public ArrayList<PersonDTO> getListInstructor(){
        ArrayList<PersonDTO> listPerson=new ArrayList<PersonDTO>();
        try{
            String query="SELECT * FROM person WHERE HireDate IS NOT NULL";
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
}
