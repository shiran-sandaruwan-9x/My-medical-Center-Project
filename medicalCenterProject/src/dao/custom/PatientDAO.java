package dao.custom;

import dao.CrudDAO;
import dto.PatientDTO;
import entity.Patient;

import java.util.ArrayList;

public interface PatientDAO extends CrudDAO<Patient,String> {
    public ArrayList<PatientDTO> getPatientId() throws Exception;
}
