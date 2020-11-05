package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.MedicineDAO;
import entity.Medicine;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MedicineDAOImpl implements MedicineDAO {
    @Override
    public boolean add(Medicine medicine) throws Exception {
        String sql="insert into medicine values(?,?,?,?,?)";
        return CrudUtill.executeUpdate(sql,medicine.getId(),medicine.getDrugName(),medicine.getDrugDetail(),medicine.getQty(),medicine.getDrugPrice());
    }

    @Override
    public Medicine search(String s) throws Exception {
        return null;
    }

    @Override
    public boolean update(Medicine medicine) throws Exception {
        String sql="update medicine set drug_name=?,drug_details=?,drug_qty=?,drug_unitPrice=? where Mid=?";
        return CrudUtill.executeUpdate(sql,medicine.getDrugName(),medicine.getDrugDetail(),medicine.getQty(),medicine.getDrugPrice(),medicine.getId());
    }

    @Override
    public boolean delete(String s) throws Exception {
        String sql="delete from medicine where Mid='"+s+"'";
       return CrudUtill.executeUpdate(sql);
    }

    @Override
    public ArrayList<Medicine> getAll() throws Exception {
        String sql="select * from medicine";
        ResultSet res=CrudUtill.executeQuery(sql);
        ArrayList<Medicine> arrayList=new ArrayList<>();

        while (res.next()){
            arrayList.add(new Medicine(res.getString(1),res.getString(2),res.getString(3),res.getInt(4),res.getDouble(5)));

        }
        return arrayList;
    }
}
