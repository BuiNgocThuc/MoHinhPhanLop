/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import BLL.Entity.PersonEntity;
import DAL.PersonDAL;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author buing
 */
public class PersonBLL {
    PersonDAL personDAL = new PersonDAL();

    public ArrayList<PersonEntity> getAllList() {
        return personDAL.getAllList();
    }

    public PersonEntity detailsPerson(int id) {
        return personDAL.detailsPerson(id);
    }

    public boolean addPerson(PersonEntity person) throws SQLException {
        return personDAL.addPerson(person);
    }

    public ArrayList<PersonEntity> getListStudent() {
        return personDAL.getListStudent();
    }

    public ArrayList<PersonEntity> getListInstructor() {
        return personDAL.getListInstructor();
    }
}
