package bo.custom.impl;

import bo.custom.PatientAndAppoinmentDetailBO;
import dao.DAOFactory;
import dao.custom.QueryDAO;
import dto.PatientAndAppoimentDTO;

import java.util.ArrayList;

public class PatientAndAppoinmentDetailImpl implements PatientAndAppoinmentDetailBO {
    static QueryDAO dao= (QueryDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.QUERDAO);
    @Override
    public ArrayList<PatientAndAppoimentDTO> getPatientAndAppoinment() throws Exception {
        return dao.getAllPatientAndAppoinment();
    }

    @Override
    public int todayNoOfappoinment(String date) throws Exception {
       return dao.gettodayNoOfappoinment(date);
    }
}
