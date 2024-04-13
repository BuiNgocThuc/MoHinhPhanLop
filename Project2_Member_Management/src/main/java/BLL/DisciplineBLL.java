package BLL;

import POJOs.Discipline;
import DAL.DisciplineDAL;
import DAL.baseDAL;
import POJOs.Member;

import java.util.List;
import org.hibernate.Transaction;

public class DisciplineBLL {

    //private baseDAL<Discipline> baseDiscipline;
    private DisciplineDAL disciplineDAL;

    public DisciplineBLL() {
        this.disciplineDAL = new DisciplineDAL();
        //this.baseDiscipline = new baseDAL<>(Discipline.class);
        
    }
    public Member getMember(String id){
        return disciplineDAL.getMember(id);
    }
    public List<Discipline> selectAll() {
        //return this.baseDiscipline.selectAll();
        return disciplineDAL.selectAll();
    }
    public List<Discipline> search(String text){
        return disciplineDAL.search(text);
    }
    public List<Member> selectMenber() {
        //return this.baseDiscipline.selectAll();
        return disciplineDAL.selectMember();
    }
    public void delete(int id){
        disciplineDAL.delete(id);
    }
    
    public Discipline getDiscipline(int id){
        return disciplineDAL.getDiscipline(id);
    }

//    public Discipline getById(int id) {
//        //return this.baseDiscipline.getById(id);
//    }
//
    public void insertDiscipline(Discipline discipline) throws Exception {
        //this.baseDiscipline.save(discipline);
        disciplineDAL.insertDiscipline(discipline);
    }
//
    public void updateDiscipline(Discipline discipline) {
        //this.baseDiscipline.update(discipline);
        disciplineDAL.update(discipline);
    }
//
//    public void deleteDiscipline(int id) {
//        //this.baseDiscipline.delete(id);
//    }

//    public boolean isWarning(int id) {
//        Discipline discipline = getById(id);
//        if (discipline.getStatus() == 1)
//        {
//            return true;
//        } else
//        {
//            return false;
//        }
//    }
}