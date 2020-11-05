package bo.custom.impl;

import bo.custom.DoctorBO;
import dao.CrudUtill;
import dao.DAOFactory;
import dao.custom.DoctorDAO;
import dto.DoctorDTO;
import dto.DoctorDetailDTO;
import entity.Doctor;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DoctorBOImpl implements DoctorBO {
   static DoctorDAO dao= (DoctorDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.DOCTOR);
//    @Override
//    public boolean addDoctor(Doctor doctor) throws Exception {
//        return dao.add(doctor);
//    }
//
//    @Override
//    public boolean deleteDoctor(String id) throws Exception {
//        return dao.delete(id);
//    }
//
//    @Override
//    public boolean updateDoctor(Doctor doctor) throws Exception {
//        return dao.update(doctor);
//    }
//
//    @Override
//    public Doctor searchDoctor(String id) throws Exception {
//        return null;
//    }
//
//    @Override
//    public ArrayList<Doctor> getDoctor() throws Exception {
//        return dao.getAll();
//    }

    @Override
    public boolean addDoctor(DoctorDTO doctor) throws Exception {
        Doctor doctor1=new Doctor(doctor.getDid(),doctor.getDname(),doctor.getDtype(),doctor.getDindate(),doctor.getDintime(),doctor.getDdob(),doctor.getDtelephone(),doctor.getDqualification(),doctor.getDfee(),doctor.getDemail());
        return dao.add(doctor1);
    }

    @Override
    public boolean deleteDoctor(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public boolean updateDoctor(DoctorDTO doctor) throws Exception {
        Doctor doctor1=new Doctor(doctor.getDid(),doctor.getDname(),doctor.getDtype(),doctor.getDindate(),doctor.getDintime(),doctor.getDdob(),doctor.getDtelephone(),doctor.getDqualification(),doctor.getDfee(),doctor.getDemail());
        return dao.update(doctor1);
    }

    @Override
    public DoctorDTO searchDoctor(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<DoctorDTO> getDoctor() throws Exception {
        ArrayList<DoctorDTO> arrayList=new ArrayList<>();
        ArrayList<Doctor> arrayList1=dao.getAll();
        for (Doctor dto:arrayList1){
            arrayList.add(new DoctorDTO(dto.getDid(),dto.getDname(),dto.getDtype(),dto.getDindate(),dto.getDintime(),dto.getDdob(),dto.getDtelephone(),dto.getDqualification(),dto.getDfee(),dto.getDemail()));
        }
        return arrayList;
    }

    @Override
    public ArrayList<DoctorDetailDTO> getTable() throws Exception {
        return dao.getTableAll();
    }

    @Override
    public String getDocFee(String id) throws Exception {
        return dao.getDocCharge(id);
    }

    @Override
    public String getDocId() throws Exception {
        return dao.getDocID();
    }
}
