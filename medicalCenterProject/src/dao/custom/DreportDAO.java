package dao.custom;

import dao.CrudDAO;
import dto.DreportDTO;
import entity.Dreport;

public interface DreportDAO extends CrudDAO<Dreport,String> {
    public String getReportId()throws Exception;
}
