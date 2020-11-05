package bo.custom;

import bo.SuperBO;
import dto.BankTableDTO;

import java.util.ArrayList;

public interface BankPaymentTableBO extends SuperBO {
    public ArrayList<BankTableDTO> getDetailTable()throws Exception;
}
