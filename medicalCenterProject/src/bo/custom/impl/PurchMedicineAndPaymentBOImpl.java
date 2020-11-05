package bo.custom.impl;

import bo.custom.PurchMedicineAndPaymentBO;
import dao.DAOFactory;
import dao.custom.PatientDAO;
import dao.custom.PlaceMedicineDAO;
import dao.custom.PlacePaymentDAO;
import db.DBConnection;
import dto.PatientDTO;
import entity.Patient;
import entity.PatientPayment;
import entity.PlaceMedicine;

import java.sql.Connection;
import java.util.ArrayList;

public class PurchMedicineAndPaymentBOImpl implements PurchMedicineAndPaymentBO {
    static PlacePaymentDAO dao= (PlacePaymentDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.PATIENTPAYMENT);
    static PatientDAO dao1= (PatientDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.PATIENT);
    static PlaceMedicineDAO dao2= (PlaceMedicineDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.PLACEMEDICINE);


    @Override
    public boolean PurchPaymentPatient(PatientPayment patient, ArrayList<PlaceMedicine> arrayList) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean res = dao.add(patient);
        if (res){

            for (PlaceMedicine medicine:arrayList){
                boolean res1 = dao2.add(medicine);
                if (!res){
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

    @Override
    public String getPayID() throws Exception {
    return dao.getPayId();
    }

    @Override
    public ArrayList<PatientDTO> getPatientId() throws Exception {
        return dao1.getPatientId();
    }
}
