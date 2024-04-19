package DAL;

import POJOs.Device;
import Utils.hibernateUtil;
import jakarta.persistence.Query;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM Device WHERE name LIKE :keyword OR id LIKE :keyword";
            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%");
            results = query.getResultList();

            transaction.commit();
        } catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return results;
    }

    // Chọn thiết bị theo năm
    public List<Device> selectDeviceByYear(int year) {
        List<Device> result = new ArrayList<>();
        int lastTwoDigits = year % 100;
        List<Device> listDevices = baseDAL.selectAll();
        for (Device d : listDevices)
        {
            int id = d.getId();
            int lastTwoDigitsId = (id % 1000) / 10;
            if (lastTwoDigits == lastTwoDigitsId)
            {
                result.add(d);
            }
        }
        return result;
    }

    // Xóa thiết bị theo năm
    public int deleteDeviceByYear(int year) {
        List<Device> listDevice = selectDeviceByYear(year);
        for (Device d : listDevice)
        {
            baseDAL.delete(d);
        }
        return listDevice.size();
    }

    public List<Device> statisticBorrowedDevice(Timestamp startDate, Timestamp endDate) {
        List<Device> results = new ArrayList<>();
        try (Session session = sessionFactory.openSession())
        {
            Transaction transaction = session.beginTransaction();
            
            Map<String, Object> params = new HashMap<>();
            // Sử dụng truy vấn HQL để đếm số lượng
            String hql = "FROM Device d JOIN Usage u ON d.id = u.device WHERE u.paidTime IS NOT NULL";

            if (startDate != null)
            {
                hql += " AND u.borrowedTime >= :startDate";
                params.put("startDate", startDate);
            }
            if (endDate != null)
            {
                hql += " AND u.paidTime <= :endDate";
                params.put("endDate", endDate);
            }

            Query query = session.createQuery(hql, Long.class);
            for (Map.Entry<String, Object> entry : params.entrySet())
            {
                query.setParameter(entry.getKey(), entry.getValue());
            }

            // Sử dụng uniqueResult() để lấy kết quả duy nhất
             results = query.getResultList();

            // Hoàn thành giao dịch
            transaction.commit();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return results;
    }

    public List<Device> statisticBorrowingDevice(Timestamp startDate, Timestamp endDate) {
         List<Device> results = new ArrayList<>();
        try (Session session = sessionFactory.openSession())
        {
            Transaction transaction = session.beginTransaction();
            
            Map<String, Object> params = new HashMap<>();
            // Sử dụng truy vấn HQL để đếm số lượng
            String hql = "FROM Device d JOIN Usage u ON d.id = u.device WHERE u.paidTime IS NULL";

            if (startDate != null)
            {
                hql += " AND u.borrowedTime >= :startDate";
                params.put("startDate", startDate);
            }
            if (endDate != null)
            {
                hql += " AND u.borrowed <= :endDate";
                params.put("endDate", endDate);
            }

            Query query = session.createQuery(hql, Long.class);
            for (Map.Entry<String, Object> entry : params.entrySet())
            {
                query.setParameter(entry.getKey(), entry.getValue());
            }

            // Sử dụng uniqueResult() để lấy kết quả duy nhất
            results = query.getResultList();

            // Hoàn thành giao dịch
            transaction.commit();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return results;
    }

    public int importExcel(File file) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int importedRecords = 0;

        try
        {
            transaction = session.beginTransaction();
            try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis))
            {
                Sheet sheet = workbook.getSheetAt(0);

                for (int i = 1; i <= sheet.getLastRowNum(); i++)
                {
                    Row row = sheet.getRow(i);
                    if (row == null)
                    {
                        continue;
                    }

                    Device obj = new Device();
                    obj.setId((int) row.getCell(0).getNumericCellValue());
                    obj.setName(row.getCell(1).getStringCellValue());
                    obj.setDescription(row.getCell(2).getStringCellValue());
                    session.save(obj);
                    importedRecords++;
                }

                transaction.commit();
            } catch (IOException e)
            {
                e.printStackTrace();
                if (transaction != null)
                {
                    transaction.rollback();
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            if (transaction != null)
            {
                transaction.rollback();
            }
        } finally
        {
            session.close();
        }

        return importedRecords;
    }

    public Long statisticByName(Device device) {
        Long result = 0L; // Khởi tạo kết quả mặc định là 0
        try (Session session = sessionFactory.openSession())
        {
            Transaction transaction = session.beginTransaction();

            // Sử dụng truy vấn HQL để đếm số lượng
            String hql = "SELECT COUNT(*) FROM Usage u WHERE u.device = :device AND u.paidTime IS NOT NULL";
            org.hibernate.query.Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("device", device);

            // Sử dụng uniqueResult() để lấy kết quả duy nhất
            result = query.uniqueResult();

            // Hoàn thành giao dịch
            transaction.commit();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        // Trả về kết quả đếm
        return result;
    }
}
