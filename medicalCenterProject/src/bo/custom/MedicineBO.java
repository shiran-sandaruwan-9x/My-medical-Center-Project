package bo.custom;

import bo.SuperBO;
import entity.Medicine;

import java.util.ArrayList;

public interface MedicineBO extends SuperBO {
    public boolean addMedicine(Medicine medicine) throws Exception;
    public ArrayList<Medicine> getAllMedicine() throws Exception;
    public boolean updateMedicine(Medicine medicine) throws Exception;
    public boolean deleteMedicine(String id) throws Exception;
}
