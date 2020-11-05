package bo.custom.impl;

import dao.DAOFactory;
import bo.custom.DreportBO;
import dao.custom.DreportDAO;

public class DreportBOImpl implements DreportBO {
    static DreportDAO dao= (DreportDAO) DAOFactory.getDaoFactory().getType(DAOFactory.Type.DREPORT);
    @Override
    public String reportId() throws Exception {
        return dao.getReportId();
    }
}
