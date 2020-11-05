package bo.custom.impl;

import bo.custom.CashierBO;
import dao.CrudUtill;
import dao.DAOFactory;
import dao.custom.CashierDAO;
import entity.Cashier;

import java.util.ArrayList;

public class CashierBOImpl implements CashierBO {
    static CashierDAO dao= (CashierDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.CASHIER);
    @Override
    public boolean addCashier(Cashier cashier) throws Exception {
        return dao.add(cashier);
    }

    @Override
    public ArrayList<Cashier> getAllCashier() throws Exception {
        return dao.getAll();
    }

    @Override
    public boolean CashierDelete(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public boolean updateCashier(Cashier cashier) throws Exception {
      return dao.update(cashier);
    }

}
