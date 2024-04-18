/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import POJOs.Device;
import POJOs.Discipline;
import POJOs.Member;
import Utils.hibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        session = hibernateUtil.getSessionFactory().openSession();
    }

    public List<Discipline> selectAll() {
        List<Discipline> listDiscipline = new ArrayList<>();
        session.getTransaction().begin();
        listDiscipline = session.createQuery("FROM Discipline", Discipline.class).list();
        session.getTransaction().commit();
        return listDiscipline;
    }

    public List<Discipline> search(String text) {
        List<Discipline> listDiscipline = new ArrayList<>();
        session.getTransaction().begin();
        listDiscipline = session.createQuery("FROM Discipline WHERE CONCAT(id,description,description,fine,memberID) LIKE :searchText", Discipline.class)
                .setParameter("searchText", "%" + text + "%").list();
        //id + ", description=" + description + ", fine=" + fine + ", date=" + date + ", status=" + status + ", memberID=" + memberID
        session.getTransaction().commit();
        return listDiscipline;
    }

    public Member getMember(String id) {
        Member member = null;
        try {
            Transaction transaction = session.beginTransaction();
            member = session.get(Member.class, id);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error");
        }
        return member;
    }

    public List<Member> selectMember() {
        List<Member> listselectMember = new ArrayList<>();
        session.getTransaction().begin();
        listselectMember = session.createQuery("FROM Member", Member.class).list();
        session.getTransaction().commit();
        return listselectMember;
    }

    public void insertDiscipline(Discipline discipline) throws Exception {
        try {
            Transaction transaction = session.beginTransaction();
            session.save(discipline);
            transaction.commit();
        } catch (Exception e) {
//            System.out.println("Error");
            throw new Exception("Import: " + discipline.toString());
        }
    }
    public void delete(int id){
         try {
            Transaction transaction = session.beginTransaction();
            Discipline discipline=session.get(Discipline.class, id);
            session.remove(discipline);
            transaction.commit();
        } catch (Exception e) {
             System.out.println("Error");
        }
    }

    public void update(Discipline discipline) {
        Transaction transaction = session.beginTransaction();
        try {
            Discipline udiscipline = session.get(Discipline.class, discipline.getId());
            udiscipline.setFine(discipline.getFine());
            udiscipline.setStatus(discipline.getStatus());
            udiscipline.setDescription(discipline.getDescription());
            session.update(udiscipline);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public Discipline getDiscipline(int id) {
        Discipline discipline = null;
        try {
            Transaction transaction = session.beginTransaction();
            discipline = session.get(Discipline.class, id);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error getDiscipline");
        }
        return discipline;
    }
    public String StatisticsDiscipline(){
        List<Discipline> listDiscipline = new ArrayList<>();
        session.getTransaction().begin();
        listDiscipline = session.createQuery("FROM Discipline", Discipline.class).list();
        session.getTransaction().commit();
        int Processed=0;
        int Noprocessed=0;
        int toltalmount=0;
        for(Discipline i:listDiscipline){
            if(i.getStatus()==0){
                Processed+=1;
                toltalmount+=i.getFine()!=null?i.getFine():0;
            }else{
                Noprocessed+=1;
            }
        }
        return Processed+","+Noprocessed+","+toltalmount;
    }
}