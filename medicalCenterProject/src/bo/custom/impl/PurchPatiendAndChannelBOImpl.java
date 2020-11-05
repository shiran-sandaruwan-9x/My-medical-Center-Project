package bo.custom.impl;

import bo.custom.PurchPatiendAndChannelBO;
import dao.DAOFactory;
import dao.custom.AppointmentDAO;
import dao.custom.ChannelDAO;
import dao.custom.PatientDAO;
import db.DBConnection;
import dto.PatientDTO;
import entity.Patient;
import tm.AppoimentTableTM;

import java.sql.Connection;
import java.util.ArrayList;

public class PurchPatiendAndChannelBOImpl implements PurchPatiendAndChannelBO {
    static ChannelDAO dao= (ChannelDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.CHANNEL);
    static PatientDAO dao1= (PatientDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.PATIENT);
    static AppointmentDAO dao3= (AppointmentDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.APPOIONTMENT);
    @Override
    public String getPatientId() throws Exception {
        return dao.getPatientLastId();
    }

    @Override
    public String getChannelId() throws Exception {
        return dao.getChannelLastId();
    }

    @Override
    public boolean purchPatiendAndChannel(Patient patient, ArrayList<AppoimentTableTM> arrayList) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean res=dao1.add(patient);
        if (res){
            for (AppoimentTableTM tm:arrayList){
               boolean res1= dao3.add(tm);
               if (!res1){
                   connection.rollback();
                   connection.setAutoCommit(true);
                   return false;
               }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;

        }else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
    }
}
