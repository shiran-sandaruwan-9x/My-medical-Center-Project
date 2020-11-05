package bo.custom;

import bo.SuperBO;
import entity.Patient;
import tm.AppoimentTableTM;

import java.util.ArrayList;

public interface PurchPatiendAndChannelBO extends SuperBO {
    public String getPatientId() throws Exception;
    public String getChannelId() throws Exception;
    public boolean purchPatiendAndChannel(Patient patient, ArrayList<AppoimentTableTM> arrayList)throws Exception;
}
