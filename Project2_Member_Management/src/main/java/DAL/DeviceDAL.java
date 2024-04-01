package DAL;

import POJOs.Device;
import Utils.hibernateUtil;
import jakarta.persistence.Query;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeviceDAL {

    private SessionFactory sessionFactory;
    private baseDAL<Device> baseDAL;

    public DeviceDAL() {
        sessionFactory = hibernateUtil.getSessionFactory();
        this.baseDAL = new baseDAL<>(Device.class);
    }

    // Thống kê các thiết bị đã được mượn theo tên, khoảng thời gian

    @SuppressWarnings("unchecked")
    public List<Device> statisticDeviceBorrowed(String name, String startDateStr, String endDateStr)
            throws ParseException {
        Session session;
        String hql = "FROM Device m JOIN Usage u ON m.id = u.device WHERE u.borrowedTime IS NOT NULL AND u.paidTime IS NOT NULL ";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp startTimeStamp = null;
        Timestamp endTimeStamp = null;
        Date startDate = null;
        Date endDate = null;

        try {
            if (startDateStr != null) {
                startDate = dateFormat.parse(startDateStr);
                startTimeStamp = new Timestamp(startDate.getTime());
            }
            if (endDateStr != null) {
                endDate = dateFormat.parse(endDateStr);
                endTimeStamp = new Timestamp(endDate.getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (name != null) {
            hql += "AND m.name LIKE '%" + name + "%'";
        }
        if (startTimeStamp != null) {
            hql += " AND u.borrowedTime >= '" + startTimeStamp + "'";
        }
        if (endTimeStamp != null) {
            hql += " AND u.paidTime <= '" + endTimeStamp + "'";
        }

        List<Device> results = new ArrayList<>();
        try {
            session = sessionFactory.openSession();

            Query query = session.createQuery(hql);
            results = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    // Thống kê thiết bị đang mượn và các thiết bị đang mượn theo khoảng thời gian

    @SuppressWarnings("unchecked")
    public List<Device> statisticDeviceIsBorrowing(String startDateStr, String endDateStr) {
        Session session;
        String hql = "FROM Device m JOIN Usage u ON m.id = u.device WHERE u.device IS NOT NULL AND u.paidTime IS NULL ";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp startTimeStamp = null;
        Date startDate = null;

        try {
            if (startDateStr != null) {
                startDate = dateFormat.parse(startDateStr);
                startTimeStamp = new Timestamp(startDate.getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (startTimeStamp != null) {
            hql += " AND u.borrowedTime >= '" + startTimeStamp + "'";
        }

        System.out.println(hql);
        List<Device> results = new ArrayList<>();
        try {
            session = sessionFactory.openSession();

            @SuppressWarnings("deprecation")
            Query query = session.createQuery(hql);
            results = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

}
