package bo.custom.impl;

import bo.custom.MedicineBO;
import dao.DAOFactory;
import dao.custom.MedicineDAO;
import entity.Medicine;

import java.util.ArrayList;

public class MedicineBOImpl implements MedicineBO {
    static MedicineDAO dao= (MedicineDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.MEDICINE);

    @Override
    public boolean addMedicine(Medicine medicine) throws Exception {
        return dao.add(medicine);
    }

    @Override
    public ArrayList<Medicine> getAllMedicine() throws Exception {
        return dao.getAll();
    }

    @Override
    public boolean updateMedicine(Medicine medicine) throws Exception {
        return dao.update(medicine);
    }

    @Override
    public boolean deleteMedicine(String id) throws Exception {
        return dao.delete(id);
    }
}
