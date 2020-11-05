package bo;

import bo.custom.impl.*;
import dao.custom.impl.DreportDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getBoFactory() {
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }

    public enum Type{
        CASHIER,MEDICINE,DOCTOR,PURCHPAYMENTMEDICINE,QUERYBO,PUCHCHANNEL,BANKPAYMENTDETAIL,DREPORT,DPAYMENT,PURCHDOCTOR
    }

    public SuperBO getType(Type type){
        switch (type){
            case CASHIER:return new CashierBOImpl();
            case MEDICINE:return new MedicineBOImpl();
            case DOCTOR:return new DoctorBOImpl();
            case PURCHPAYMENTMEDICINE:return new PurchMedicineAndPaymentBOImpl();
            case QUERYBO:return new PatientAndAppoinmentDetailImpl();
            case PUCHCHANNEL:return new PurchPatiendAndChannelBOImpl();
            case BANKPAYMENTDETAIL:return new BankPaymentTableBOImpl();
            case DREPORT:return new DreportBOImpl();
            case DPAYMENT:return new DpaymentBOImpl();
            case PURCHDOCTOR:return new PurchDoctorPaymentBOImpl();
            default:return null;
        }
    }
}
