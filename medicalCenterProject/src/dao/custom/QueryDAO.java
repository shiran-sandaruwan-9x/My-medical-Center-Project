package dao.custom;

import dao.SuperDAO;
import dto.BankTableDTO;
import dto.PatientAndAppoimentDTO;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
public ArrayList<PatientAndAppoimentDTO> getAllPatientAndAppoinment() throws Exception;
    public int gettodayNoOfappoinment(String date)throws Exception;
    public ArrayList<BankTableDTO> getBankAll() throws Exception;
}
