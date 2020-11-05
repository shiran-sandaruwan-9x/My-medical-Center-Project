package bo.custom.impl;

import bo.custom.DpaymentBO;
import dao.DAOFactory;
import dao.custom.DpaymentDAO;
import dto.DPaymentDTO;
import entity.DPayment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DpaymentBOImpl implements DpaymentBO {
    static DpaymentDAO dao= (DpaymentDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.DPAYMENT);
    @Override
    public ArrayList<DPaymentDTO> getAllDpayment() throws Exception {
        ArrayList<DPayment> arrayList=dao.getAll();
        ArrayList<DPaymentDTO> arrayList1=new ArrayList<>();
        for(DPayment dto: arrayList){
            arrayList1.add(new DPaymentDTO(dto.getPayid(),dto.getDid(),dto.getQty(),dto.getFee()));
        }
        return arrayList1;
    }
}
