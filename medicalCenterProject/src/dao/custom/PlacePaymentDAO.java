package dao.custom;

import dao.CrudDAO;
import entity.PatientPayment;

public interface PlacePaymentDAO extends CrudDAO<PatientPayment,String> {
    public String getPayId() throws Exception;
}
