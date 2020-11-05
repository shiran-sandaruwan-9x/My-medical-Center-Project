package bo.custom;

import bo.SuperBO;
import dto.DPaymentDTO;
import dto.DreportDTO;

public interface PurchDoctorPaymentBO extends SuperBO {
    public boolean purchDoctor(DreportDTO dreportDTO, DPaymentDTO paymentDTO)throws Exception;
}
