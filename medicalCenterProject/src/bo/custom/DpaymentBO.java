package bo.custom;

import bo.SuperBO;
import dto.DPaymentDTO;

import java.util.ArrayList;

public interface DpaymentBO extends SuperBO {
    public ArrayList<DPaymentDTO> getAllDpayment()throws Exception;
}
