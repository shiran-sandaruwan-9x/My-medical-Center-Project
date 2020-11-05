package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.DpaymentDAO;
import entity.DPayment;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DpaymentDAOImpl implements DpaymentDAO {
    @Override
    public boolean add(DPayment dPayment) throws Exception {
        String sql="insert into doctor_payment values(?,?,?,?)";
        return CrudUtill.executeUpdate(sql,dPayment.getPayid(),dPayment.getDid(),dPayment.getQty(),dPayment.getFee());
    }

    @Override
    public DPayment search(String s) throws Exception {
        return null;
    }

    @Override
    public boolean update(DPayment dPayment) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public ArrayList<DPayment> getAll() throws Exception {
        String sql="select * from doctor_payment";
        ResultSet res= CrudUtill.executeQuery(sql);
        ArrayList<DPayment> arrayList=new ArrayList<>();
        while (res.next()){
            arrayList.add(new DPayment(res.getString(1),res.getString(2),res.getInt(3),res.getDouble(4)));
        }
        return arrayList;
    }
}
