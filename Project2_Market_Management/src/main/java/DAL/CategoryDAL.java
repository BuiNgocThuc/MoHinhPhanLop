
package DAL;

import java.util.List;
import org.hibernate.Session;

public class CategoryDAL {
    Session session;
     
    public CategoryDAL(){
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public List loadCategory() {
        List<Category> category;
        session.beginTransaction();
        category = session.createQuery("FROM Category", Category.class).list();
        session.getTransaction().commit();
        return category;
    }
    public Category getCategory(int CategoryID)
    {
        Category c = session.get(Category.class, CategoryID);
        return c;
    }
    public void addCategory(Category c)
    {
       
        session.save(c);
        
    }
    public void updateCategory(Category c)
    {
        Category categoryToUpdate = session.get(Category.class, c.getId());
        if (categoryToUpdate != null) {
            categoryToUpdate.setName(c.getName());
            categoryToUpdate.setDescripton(c.getDescription());
            
            session.beginTransaction();
            session.update(categoryToUpdate);
            session.getTransaction().commit();
        }
        
    }
    public void deleteCategory(int id)
    {   
        Category categoryToDelete = session.get(Category.class, id);
        if (categoryToDelete != null) {
            session.beginTransaction();
            session.delete(categoryToDelete);
            session.getTransaction().commit();
        }
    }
}
