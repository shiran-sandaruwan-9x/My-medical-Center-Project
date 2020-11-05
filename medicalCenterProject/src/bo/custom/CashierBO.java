package bo.custom;

import bo.SuperBO;
import entity.Cashier;

import java.util.ArrayList;

public interface CashierBO extends SuperBO {
    public boolean addCashier(Cashier cashier) throws Exception;

    public ArrayList<Cashier> getAllCashier() throws Exception;

    public boolean CashierDelete(String id) throws Exception;

    public boolean updateCashier(Cashier cashier) throws Exception;
}
