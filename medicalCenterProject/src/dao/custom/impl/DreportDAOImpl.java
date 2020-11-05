package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.DreportDAO;
import dto.DreportDTO;
import entity.Dreport;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DreportDAOImpl implements DreportDAO {
    @Override
    public String getReportId() throws Exception {
        String sql="select d_BankReport.DRid from d_BankReport order by d_BankReport.DRid desc limit 1";
        ResultSet res= CrudUtill.executeQuery(sql);
        if (res.next()){
            return res.getString(1);
        }
        return null;
    }

    @Override
    public boolean add(Dreport dreport) throws Exception {
        String sql="insert into d_BankReport values(?,?,?,?,?)";
        return CrudUtill.executeUpdate(sql,dreport.getDrid(),dreport.getDname(),dreport.getBname(),dreport.getAccountNo(),dreport.getDate());
    }

    @Override
    public Dreport search(String s) throws Exception {
        return null;
    }

    @Override
    public boolean update(Dreport dreport) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public ArrayList<Dreport> getAll() throws Exception {
        return null;
    }
}
