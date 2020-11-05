package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.AppointmentDAO;
import tm.AppoimentTableTM;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AppointmentDAOImpl implements AppointmentDAO {
    @Override
    public boolean add(AppoimentTableTM appoimentTableTM) throws Exception {
        String sql="insert into appointment values(?,?,?,?,?)";
        return CrudUtill.executeUpdate(sql,appoimentTableTM.getEid(),appoimentTableTM.getDid(),appoimentTableTM.getPid(),appoimentTableTM.getDname(),appoimentTableTM.getAppdate());
    }

    @Override
    public AppoimentTableTM search(String s) throws Exception {
        return null;
    }

    @Override
    public boolean update(AppoimentTableTM appoimentTableTM) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public ArrayList<AppoimentTableTM> getAll() throws Exception {
        return null;
    }


}
