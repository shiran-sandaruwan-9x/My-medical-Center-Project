package dao.custom.impl;

import bo.BOFactory;
import bo.custom.CashierBO;
import dao.CrudUtill;
import dao.DAOFactory;
import dao.custom.CashierDAO;
import entity.Cashier;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CashierDAOImpl implements CashierDAO {

    @Override
    public boolean add(Cashier cashier) throws Exception {
        String sql="insert into cashier values(?,?,?,?)";
        return CrudUtill.executeUpdate(sql,cashier.getId(),cashier.getName(),cashier.getAddress(),cashier.getTelephone());
    }

    @Override
    public Cashier search(String s) throws Exception {
        return null;
    }

    @Override
    public boolean update(Cashier cashier) throws Exception {
        String sql="update cashier set cashier_name=?,cashier_address=?,cashier_telephone=? where Eid=?";
        return CrudUtill.executeUpdate(sql,cashier.getName(),cashier.getAddress(),cashier.getTelephone(),cashier.getId());
    }

    @Override
    public boolean delete(String s) throws Exception {
        String sql="delete from cashier where Eid='"+s+"'";
        return CrudUtill.executeUpdate(sql);
    }

    @Override
    public ArrayList<Cashier> getAll() throws Exception {
        String sql="select * from cashier";
        ResultSet res=CrudUtill.executeQuery(sql);
        ArrayList<Cashier> arrayList=new ArrayList<>();
        while (res.next()){
            arrayList.add(new Cashier(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
        }
        return arrayList;
    }
}
