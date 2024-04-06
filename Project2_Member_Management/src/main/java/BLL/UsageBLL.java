package BLL;

import DAL.UsageDAL;
import DAL.baseDAL;
import POJOs.Usage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsageBLL {

    private baseDAL<Usage> baseUsageDAL;
    private UsageDAL usageDAL;

    public UsageBLL() {
        this.usageDAL = new UsageDAL();
        this.baseUsageDAL = new baseDAL<>(Usage.class);
    }

    public List<Usage> selectAll() {
        return baseUsageDAL.selectAll();
    }

    public Usage getById(int id) {
        return baseUsageDAL.getById(id);
    }

    public void insert(Usage usage) {
        baseUsageDAL.save(usage);
    }

    public void update(Usage usage) {
        baseUsageDAL.update(usage);
    }

    public <Integer>  void delete(int id) {
        baseUsageDAL.delete(id);
    }
}
