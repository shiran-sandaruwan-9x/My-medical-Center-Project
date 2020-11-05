package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.DoctorDAO;
import dto.DoctorDetailDTO;
import entity.Doctor;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DoctorDAOImpl implements DoctorDAO {
    @Override
    public boolean add(Doctor doctor) throws Exception {
        String sql="insert into doctor values(?,?,?,?,?,?,?,?,?,?)";
        return CrudUtill.executeUpdate(sql,doctor.getDid(),doctor.getDname(),doctor.getDtype(),doctor.getDindate(),doctor.getDintime(),doctor.getDdob(),doctor.getDtelephone(),doctor.getDqualification(),doctor.getDfee(),doctor.getDemail());
    }

    @Override
    public Doctor search(String s) throws Exception {
        String sql="select * from doctor where Did='"+s+"'";
       return null;
    }

    @Override
    public boolean update(Doctor doctor) throws Exception {
        String sql="update doctor set doctor_name=?,type_ofDoctor=?,doctor_InDay=?,doctor_InTime=?,doctor_dob=?,doctor_tephone=?,doctor_qualification=?,doctor_channel_fee=?,doctor_email=? where Did=?";
        return CrudUtill.executeUpdate(sql,doctor.getDname(),doctor.getDtype(),doctor.getDindate(),doctor.getDintime(),doctor.getDdob(),doctor.getDtelephone(),doctor.getDqualification(),doctor.getDfee(),doctor.getDemail(),doctor.getDid());

    }

    @Override
    public boolean delete(String s) throws Exception {
       String sql="delete from doctor where Did='"+s+"'";
       return CrudUtill.executeUpdate(sql);
    }

    @Override
    public ArrayList<Doctor> getAll() throws Exception {
        String sql="select * from doctor";
        ArrayList<Doctor> arrayList=new ArrayList<>();
        ResultSet res=CrudUtill.executeQuery(sql);
        while (res.next()){
            arrayList.add(new Doctor(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getDouble(9),res.getString(10)));
        }
        return arrayList;
    }

    @Override
    public ArrayList<DoctorDetailDTO> getTableAll() throws Exception {
       String sql="select Did,doctor_name,type_ofDoctor,doctor_InDay,doctor_InTime from doctor";
       ResultSet res=CrudUtill.executeQuery(sql);
       ArrayList<DoctorDetailDTO> arrayList=new ArrayList<>();
       while (res.next()){
           arrayList.add(new DoctorDetailDTO(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)));
       }
       return arrayList;
    }

    @Override
    public ArrayList<Doctor> getDocName() throws Exception {

        return null;
    }

    @Override
    public String getDocCharge(String id) throws Exception {
        String sql="select doctor.doctor_channel_fee from doctor where doctor.doctor_name='"+id+"'";
        ResultSet res=CrudUtill.executeQuery(sql);
        if (res.next()){
            return res.getString(1);
        }
        return null;
    }

    @Override
    public String getDocID() throws Exception {
        String sql="select doctor.Did from doctor order by doctor.Did desc limit 1";
        ResultSet res= CrudUtill.executeQuery(sql);
        if (res.next()){
            return res.getString(1);
        }
        return null;
    }
}
