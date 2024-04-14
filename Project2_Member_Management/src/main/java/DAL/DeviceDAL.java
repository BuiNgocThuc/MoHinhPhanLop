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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DeviceDAL {

    private SessionFactory sessionFactory;
    private baseDAL<Device> baseDAL;

    public DeviceDAL() {
        sessionFactory = hibernateUtil.getSessionFactory();
        this.baseDAL = new baseDAL<>(Device.class);
    }

    public List<Device> searchDevice(String keyword) {
        Transaction transaction = null;
        Session session;
        List<Device> results = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM Device WHERE name LIKE :keyword OR id LIKE :keyword";
            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%");
            results = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return results;
    }

    // Chọn thiết bị theo năm
    public List<Device> selectDeviecByYear(int year) {
        List<Device> result = new ArrayList<>();
        int lastTwoDigits = year % 100;
        List<Device> listDevices = baseDAL.selectAll();
        for (Device d : listDevices) {
            int id = d.getId();
            int lastTwoDigitsId = (id % 1000) / 10;
            if (lastTwoDigits == lastTwoDigitsId) {
                result.add(d);
            }
        }
        return result;
    }
    // Xóa thiết bị theo năm
    public void deleteDeviceByYear(int year){
        List<Device> listDevice = selectDeviecByYear(year);
        for (Device d : listDevice) {
            baseDAL.delete(d);
        }
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

        Map<String, Object> params = new HashMap<>();

        if (name != null) {
            hql += " AND m.name LIKE :name";
            params.put("name", "%" + name + "%");
        }

        if (startTimeStamp != null) {
            hql += " AND u.borrowedTime >= :startTimeStamp";
            params.put("startTimeStamp", startTimeStamp);
        }
        if (endTimeStamp != null) {
            hql += " AND u.paidTime <= :endTimeStamp";
            params.put("endTimeStamp", endTimeStamp);
        }

        List<Device> results = new ArrayList<>();
        try {
            session = sessionFactory.openSession();

            Query query = session.createQuery(hql);

            for (Map.Entry<String, Object> entry : params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }

            results = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    // Thống kê thiết bị đang mượn và các thiết bị đang mượn theo khoảng thời gian

    @SuppressWarnings("unchecked")
    public List<Device> statisticDeviceIsBorrowing(String name, String startDateStr, String endDateStr) {
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

        Map<String, Object> params = new HashMap<>();

        if (name != null) {
            hql += " AND m.name LIKE :name";
            params.put("name", "%" + name + "%");
        }

        if (startTimeStamp != null) {
            hql += " AND u.borrowedTime >= :startTimeStamp";
            params.put("startTimeStamp", startTimeStamp);
        }

        List<Device> results = new ArrayList<>();
        try {
            session = sessionFactory.openSession();

            @SuppressWarnings("deprecation")
            Query query = session.createQuery(hql);

            for (Map.Entry<String, Object> entry : params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }

            results = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

}
