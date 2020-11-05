package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.PlacePaymentDAO;
import entity.PatientPayment;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PlacePaymentDAOImpl implements PlacePaymentDAO {
    @Override
    public boolean add(PatientPayment patientPayment) throws Exception {
        String sql="insert into payment values(?,?,?,?)";
        return CrudUtill.executeUpdate(sql,patientPayment.getPayid(),patientPayment.getPid(),patientPayment.getPayType(),patientPayment.getBalance());
    }

    @Override
    public PatientPayment search(String s) throws Exception {
        return null;
    }

    @Override
    public boolean update(PatientPayment patientPayment) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public ArrayList<PatientPayment> getAll() throws Exception {
        return null;
    }

    @Override
    public String getPayId() throws Exception {
        String sql="select payid from payment order by payid desc limit 1";


        ResultSet res=CrudUtill.executeQuery(sql);

        if(res.next()){
        return res.getString(1);
        }
        return null;
    }
}
