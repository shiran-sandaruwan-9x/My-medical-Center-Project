package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.PlaceMedicineDAO;
import dao.custom.PlacePaymentDAO;
import entity.PlaceMedicine;

import java.util.ArrayList;

public class PlaceMedicineDAOImpl implements PlaceMedicineDAO {
    @Override
    public boolean add(PlaceMedicine placeMedicine) throws Exception {
        String sql="insert into place_medicine values(?,?,?,?,?)";
        return CrudUtill.executeUpdate(sql,placeMedicine.getPayId(),placeMedicine.getMid(),placeMedicine.getDname(),placeMedicine.getQty(),placeMedicine.getPrice());
    }

    @Override
    public PlaceMedicine search(String s) throws Exception {
        return null;
    }

    @Override
    public boolean update(PlaceMedicine placeMedicine) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public ArrayList<PlaceMedicine> getAll() throws Exception {
        return null;
    }
}
