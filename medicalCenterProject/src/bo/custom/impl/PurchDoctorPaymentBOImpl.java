package bo.custom.impl;

import bo.custom.PurchDoctorPaymentBO;
import dao.DAOFactory;
import dao.custom.DpaymentDAO;
import dao.custom.DreportDAO;
import db.DBConnection;
import dto.DPaymentDTO;
import dto.DreportDTO;
import entity.DPayment;
import entity.Dreport;

import java.sql.Connection;

public class PurchDoctorPaymentBOImpl implements PurchDoctorPaymentBO {
    static DreportDAO dao1= (DreportDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.DREPORT);
    static DpaymentDAO dao2= (DpaymentDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.DPAYMENT);
    @Override
    public boolean purchDoctor(DreportDTO dreportDTO, DPaymentDTO paymentDTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean res1=dao1.add(new Dreport(dreportDTO.getDrid(),dreportDTO.getDname(),dreportDTO.getBname(),dreportDTO.getAccountNo(),dreportDTO.getDate()));
        if (res1){

            boolean res2=dao2.add(new DPayment(paymentDTO.getPayid(),paymentDTO.getDid(),paymentDTO.getQty(),paymentDTO.getFee()));
            if (!res2){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;

        }else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }


    }
}
