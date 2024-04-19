package BLL;

import DAL.UsageDAL;
import DAL.baseDAL;
import POJOs.Usage;
import POJOs.Member;
import POJOs.Device;
import java.sql.Timestamp;
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

    public <Integer> Usage getById(int id) {
        return baseUsageDAL.getById(id);
    }

    public void insert(Usage usage) {
        baseUsageDAL.save(usage);
    }

    public void update(Usage usage) {
        baseUsageDAL.update(usage);
    }

    public void delete(int id) {
        Usage usage = getById(id);
        baseUsageDAL.delete(usage);
    }
    
    public List<Usage> selectByMemberID(Member member) {
        return usageDAL.selectByMemberID(member);
    }
    
    public List<Device> selectAvailableDevices() {
        return usageDAL.selectAvailableDevices();
    }
    
    public void updateByBorrowedTime(Timestamp borrowedTime, Timestamp paidTime, Device device) {
         usageDAL.updateByBorrowedTime(borrowedTime, paidTime, device);
    }
}
