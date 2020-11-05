package dao.custom;

import dao.CrudDAO;
import entity.Channel;

public interface ChannelDAO extends CrudDAO<Channel,String> {
    public String getPatientLastId()throws Exception;
    public String getChannelLastId() throws Exception;
}
