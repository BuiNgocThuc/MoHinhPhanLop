
package DAL;

import POJOs.Device;
import Utils.hibernateUtil;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;


public class DeviceDAL {
    
        private SessionFactory sessionFactory;
        private baseDAL<Device> baseDAL;
        
        public DeviceDAL() {
        sessionFactory = hibernateUtil.getSessionFactory();
        this.baseDAL = new baseDAL<>(Device.class);
        }
    
//        Thống kê thiết bị đã mượn theo tên
        public List<Device> statisticByName(String name) {
        String hql = "FROM Device m\n" +
                "JOIN Usage u\n" +
                "ON m.id = u.device\n" +
                "WHERE u.borrowedTime IS NOT NULL and u.paidTime IS NOT NULL\n" +
                "AND m.name LIKE  :name";
        
        return baseDAL.statistic(hql, "name", "%" + name + "%");
        }   
//        Thống kê thiết bị đã mượn theo thời gian
        public List<Device> timeBasedStatistics(String startDateStr, String endDateStr) throws ParseException{
        String hql = "FROM Device m\n" +
                "JOIN Usage u\n" +
                "ON m.id = u.device\n" +
                "WHERE u.device IS NOT NULL\n" +
                "AND u.borrowedTime >= :startDate\n" +
                "AND u.paidTime <= :endDate";
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(startDateStr);
        Date endDate = dateFormat.parse(endDateStr);

        Timestamp startTimeStamp = new Timestamp(startDate.getTime());
        Timestamp endTimeStamp = new Timestamp(endDate.getTime());
        
        return baseDAL.statistic(hql, "startDate", startTimeStamp, "endDate", endTimeStamp);
        }   
        
//        Thống kê thiết bị đang mượn 
        public List<Device> statisticIsBorrowing() {
        String hql = "FROM Device m\n" +
                "JOIN Usage u\n" +
                "ON m.id = u.device\n" +
                "WHERE u.device IS NOT NULL\n";
        
        return baseDAL.statistic(hql);
        }   
        
//        Thống kê thiết bị đang mượn theo khoảng thời gian
        public List<Device> timeStatisticIsBorrowing(String startDateStr, String endDateStr) throws ParseException{
        String hql = "FROM Device m " +
             "JOIN Usage u " +
             "ON m.id = u.device " +
             "WHERE u.device IS NOT NULL AND u.paidTime IS NULL " +
             "AND (u.borrowedTime >= :startDate OR u.paidTime <= :endDate)";


        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(startDateStr);
        Date endDate = dateFormat.parse(endDateStr);

        Timestamp startTimeStamp = new Timestamp(startDate.getTime());
        Timestamp endTimeStamp = new Timestamp(endDate.getTime());
        
        return baseDAL.statistic(hql, "startDate", startTimeStamp, "endDate", endTimeStamp);
        }   
}
