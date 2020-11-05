package bo.custom.impl;

import bo.custom.BankPaymentTableBO;
import dao.DAOFactory;
import dao.custom.QueryDAO;
import dto.BankTableDTO;

import java.util.ArrayList;

public class BankPaymentTableBOImpl implements BankPaymentTableBO {
    static QueryDAO dao= (QueryDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.QUERDAO);
    @Override
    public ArrayList<BankTableDTO> getDetailTable() throws Exception {
        return dao.getBankAll();
    }
}
