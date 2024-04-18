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

        try
        {
            if (startDateStr != null)
            {
                startDate = dateFormat.parse(startDateStr);
                startTimeStamp = new Timestamp(startDate.getTime());
            }
            if (endDateStr != null)
            {
                endDate = dateFormat.parse(endDateStr);
                endTimeStamp = new Timestamp(endDate.getTime());
            }
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        Map<String, Object> params = new HashMap<>();

        if (name != null)
        {
            hql += " AND m.name LIKE :name";
            params.put("name", "%" + name + "%");
        }

        if (startTimeStamp != null)
        {
            hql += " AND u.borrowedTime >= :startTimeStamp";
            params.put("startTimeStamp", startTimeStamp);
        }
        if (endTimeStamp != null)
        {
            hql += " AND u.paidTime <= :endTimeStamp";
            params.put("endTimeStamp", endTimeStamp);
        }

        List<Device> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();

            Query query = session.createQuery(hql);

            for (Map.Entry<String, Object> entry : params.entrySet())
            {
                query.setParameter(entry.getKey(), entry.getValue());
            }

            results = query.getResultList();

        } catch (Exception e)
        {
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

        try
        {
            if (startDateStr != null)
            {
                startDate = dateFormat.parse(startDateStr);
                startTimeStamp = new Timestamp(startDate.getTime());
            }
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        Map<String, Object> params = new HashMap<>();

        if (name != null)
        {
            hql += " AND m.name LIKE :name";
            params.put("name", "%" + name + "%");
        }

        if (startTimeStamp != null)
        {
            hql += " AND u.borrowedTime >= :startTimeStamp";
            params.put("startTimeStamp", startTimeStamp);
        }

        List<Device> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();

            @SuppressWarnings("deprecation")
            Query query = session.createQuery(hql);

            for (Map.Entry<String, Object> entry : params.entrySet())
            {
                query.setParameter(entry.getKey(), entry.getValue());
            }

            results = query.getResultList();

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
            String hql = "SELECT COUNT(*) FROM Usage u WHERE u.device = :device";
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
