package bo.custom;

import bo.SuperBO;
import dto.PatientAndAppoimentDTO;

import java.util.ArrayList;

public interface PatientAndAppoinmentDetailBO extends SuperBO {
    public ArrayList<PatientAndAppoimentDTO> getPatientAndAppoinment() throws Exception;
    public int todayNoOfappoinment(String date)throws Exception;
}
