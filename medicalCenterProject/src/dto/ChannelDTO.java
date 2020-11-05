package dto;

import entity.Appointment;
import tm.AppoimentTableTM;

import java.util.ArrayList;

public class ChannelDTO {
    private String pid;
    private String pname;
    private String pdob;
    private String paddress;
    private String ptele;
    private ArrayList<AppoimentTableTM> list;

    public ChannelDTO() {
    }

    public ChannelDTO(String pid, String pname, String pdob, String paddress, String ptele, ArrayList<AppoimentTableTM> list) {
        this.pid = pid;
        this.pname = pname;
        this.pdob = pdob;
        this.paddress = paddress;
        this.ptele = ptele;
        this.list = list;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdob() {
        return pdob;
    }

    public void setPdob(String pdob) {
        this.pdob = pdob;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getPtele() {
        return ptele;
    }

    public void setPtele(String ptele) {
        this.ptele = ptele;
    }

    public ArrayList<AppoimentTableTM> getList() {
        return list;
    }

    public void setList(ArrayList<AppoimentTableTM> list) {
        this.list = list;
    }
}
