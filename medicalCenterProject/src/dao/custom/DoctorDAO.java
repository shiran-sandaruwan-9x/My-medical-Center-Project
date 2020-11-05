package dao.custom;

import dao.CrudDAO;
import dto.DoctorDetailDTO;
import entity.Doctor;

import java.util.ArrayList;

public interface DoctorDAO extends CrudDAO<Doctor,String> {
    public ArrayList<DoctorDetailDTO> getTableAll() throws Exception;
    public ArrayList<Doctor> getDocName()throws Exception;
    public String getDocCharge(String id)throws Exception;
    public String getDocID()throws Exception;
}
