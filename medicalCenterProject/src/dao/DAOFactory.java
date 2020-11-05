package dao;

import dao.custom.impl.*;

public class DAOFactory {
private static DAOFactory daoFactory;

private DAOFactory(){

}

public static DAOFactory getDaoFactory(){
    if(daoFactory==null){
        daoFactory=new DAOFactory();
        return daoFactory;
    }
    return daoFactory;
}

public enum Type{
    CASHIER,MEDICINE,DOCTOR,PATIENTPAYMENT,PATIENT,QUERDAO,CHANNEL,APPOIONTMENT,PLACEMEDICINE,DREPORT,DPAYMENT
}

public SuperDAO getType(Type type){
    switch (type){
        case CASHIER:return new CashierDAOImpl();
        case MEDICINE:return new MedicineDAOImpl();
        case DOCTOR:return new DoctorDAOImpl();
        case PATIENTPAYMENT:return new PlacePaymentDAOImpl();
        case PATIENT:return new PatientDAOImpl();
        case QUERDAO:return new QueryDAOImpl();
        case CHANNEL:return new ChannelDAOImpl();
        case APPOIONTMENT:return new AppointmentDAOImpl();
        case PLACEMEDICINE:return new PlaceMedicineDAOImpl();
        case DREPORT:return new DreportDAOImpl();
        case DPAYMENT:return new DpaymentDAOImpl();
        default: return null;
    }
}

}
