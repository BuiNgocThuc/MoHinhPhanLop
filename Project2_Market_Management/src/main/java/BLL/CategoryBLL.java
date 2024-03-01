
package BLL;

import DAL.Category;
import DAL.CategoryDAL;
import java.util.List;

public class CategoryBLL {
    private CategoryDAL cateDAL;
    
    public CategoryBLL()
    {
        cateDAL = new CategoryDAL();
    }
    
    public List loadCategory()
    {
        List list;
        list = cateDAL.loadCategory();
        
        return list;
    }
    
    public Object[][] convertList(List<Category> list)
    {
        int rows = list.size();
        int cols = 3;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            obj[i][0] = list.get(i).getId();
            obj[i][1] = list.get(i).getName();
            obj[i][2] = list.get(i).getDescription();
        }
        return obj;
    }
    
    public Category getCategory(int CategoryID)
    {
        Category c = cateDAL.getCategory(CategoryID);
        return c;
    }
    
    public void newCategory(Category c)
    {
        cateDAL.addCategory(c);
    }
    public void updateCategory(Category c)
    {
        cateDAL.updateCategory(c);
    }
    public void deleteCategory(int id)
    {
        cateDAL.deleteCategory(id);
    }
}
