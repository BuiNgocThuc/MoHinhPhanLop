/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import POJOs.Device;
import POJOs.Discipline;
import Utils.hibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author buing
 */
public class DisciplineDAL {
    //private SessionFactory sessionFactory;
    private baseDAL<Discipline> baseDAL;
    private Session session;
    public DisciplineDAL() {
//        sessionFactory = hibernateUtil.getSessionFactory().openSession();
//        this.baseDAL = new baseDAL<>(Discipline.class);
          session=hibernateUtil.getSessionFactory().openSession();
    }
    public List<Discipline> selectAll(){
        List<Discipline> listDiscipline=new ArrayList<>();
        session.getTransaction().begin();
        listDiscipline=session.createQuery("FROM Discipline",Discipline.class).list();
        session.getTransaction().commit();
        return listDiscipline;
    }
}
