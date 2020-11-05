package dao.custom.impl;

import dao.CrudUtill;
import dao.custom.PatientDAO;
import dto.PatientDTO;
import entity.Patient;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PatientDAOImpl implements PatientDAO {
    @Override
    public boolean add(Patient patient) throws Exception {
        String sql="insert into patient values(?,?,?,?,?)";
        return CrudUtill.executeUpdate(sql,patient.getpId(),patient.getpName(),patient.getpDob(),patient.getpAddress(),patient.getpTelephone());
    }

    @Override
    public Patient search(String s) throws Exception {
        return null;
    }

    @Override
    public boolean update(Patient patient) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public ArrayList<Patient> getAll() throws Exception {
        return null;
    }

    @Override
    public ArrayList<PatientDTO> getPatientId() throws Exception {
        String sql="select Pid from patient";
        ArrayList<PatientDTO> arrayList=new ArrayList<>();
        ResultSet res= CrudUtill.executeQuery(sql);
        while (res.next()){
            arrayList.add(new PatientDTO(res.getString(1)));
        }
        return arrayList;
    }
}
