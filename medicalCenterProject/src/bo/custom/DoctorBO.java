package bo.custom;

import bo.SuperBO;
import dto.DoctorDTO;
import dto.DoctorDetailDTO;
import entity.Doctor;

import java.util.ArrayList;

public interface DoctorBO extends SuperBO {
    public boolean addDoctor(DoctorDTO doctor) throws Exception;
    public boolean deleteDoctor(String id) throws Exception;
    public boolean updateDoctor(DoctorDTO doctor) throws Exception;
    public DoctorDTO searchDoctor(String id) throws Exception;
    public ArrayList<DoctorDTO> getDoctor() throws Exception;
    public  ArrayList<DoctorDetailDTO> getTable() throws Exception;
    public  String getDocFee(String id)throws Exception;
    public String getDocId()throws Exception;
}
