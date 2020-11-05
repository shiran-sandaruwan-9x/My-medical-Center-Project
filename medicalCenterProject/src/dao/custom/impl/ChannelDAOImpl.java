package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.ChannelDAO;
import entity.Channel;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ChannelDAOImpl implements ChannelDAO {
    @Override
    public boolean add(Channel channel) throws Exception {
        return false;
    }

    @Override
    public Channel search(String s) throws Exception {
        return null;
    }

    @Override
    public boolean update(Channel channel) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public ArrayList<Channel> getAll() throws Exception {
        return null;
    }

    @Override
    public String getPatientLastId() throws Exception {
        String sql="select Pid from patient order by Pid desc limit 1";
        ResultSet res= CrudUtill.executeQuery(sql);
        if(res.next()){
            return res.getString(1);
        }
        return null;
    }

    @Override
    public String getChannelLastId() throws Exception {
        String sql="select Eid from appointment order by Eid desc limit 1";
        ResultSet res=CrudUtill.executeQuery(sql);
        if (res.next()){
            return res.getString(1);
        }
        return null;
    }
}
