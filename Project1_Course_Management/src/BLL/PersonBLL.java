/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.PersonDTO;
import DAL.PersonDAL;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author buing
 */
public class PersonBLL {
    PersonDAL personDAL = new PersonDAL();

    public ArrayList<PersonDTO> getAllList() {
        return personDAL.getAllList();
    }

    public PersonDTO detailsPerson(int id) {
        return personDAL.detailsPerson(id);
    }

    public boolean addPerson(PersonDTO person) throws SQLException {
        return personDAL.addPerson(person);
    }

    public ArrayList<PersonDTO> getListStudent() {
        return personDAL.getListStudent();
    }

    public ArrayList<PersonDTO> getListInstructor() {
        return personDAL.getListInstructor();
    }
}
