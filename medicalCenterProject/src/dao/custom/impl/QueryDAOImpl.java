package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.QueryDAO;
import dto.BankTableDTO;
import dto.PatientAndAppoimentDTO;

import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {


    @Override
    public ArrayList<PatientAndAppoimentDTO> getAllPatientAndAppoinment() throws Exception {
        String sql="select * from patient cross join appointment on patient.Pid=appointment.Pid";
        ArrayList<PatientAndAppoimentDTO> arrayList=new ArrayList<>();
        ResultSet res= CrudUtill.executeQuery(sql);
        while (res.next()){
            arrayList.add(new PatientAndAppoimentDTO(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10)));
        }
        return arrayList;

    }
    @Override
    public int gettodayNoOfappoinment(String date) throws Exception {
        String sql="select count(appointment_date) from appointment where appointment_date='"+date+"'";
        ResultSet resultSet=CrudUtill.executeQuery(sql);
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return 0;

    }

    @Override
    public ArrayList<BankTableDTO> getBankAll() throws Exception {
        String sql="select * from d_BankReport cross join doctor_payment where d_BankReport.DRid=doctor_payment.DRid order by doctor_payment.doctor_charge desc";
        ResultSet res= CrudUtill.executeQuery(sql);
        ArrayList<BankTableDTO> arrayList=new ArrayList<>();
        while (res.next()){
            arrayList.add(new BankTableDTO(res.getString(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5),res.getString(6),res.getString(7),res.getInt(8),res.getDouble(9)));
        }
        return arrayList;

    }

}
