package bo.custom;

import bo.SuperBO;
import dto.PatientDTO;
import entity.Patient;
import entity.PatientPayment;
import entity.PlaceMedicine;

import java.util.ArrayList;

public interface PurchMedicineAndPaymentBO extends SuperBO {
    public boolean PurchPaymentPatient(PatientPayment patient, ArrayList<PlaceMedicine> arrayList) throws Exception;
    public String getPayID() throws Exception;
    public ArrayList<PatientDTO> getPatientId() throws Exception;
}
