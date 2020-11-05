package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtill {
    private static PreparedStatement getPreparedStatement(String sql,Object... parms) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        for(int i=0; i<parms.length; i++){
            stm.setObject((i+1),parms[i]);
        }
        return stm;
    }

    public static boolean executeUpdate(String sql,Object... parms) throws SQLException, ClassNotFoundException {
        PreparedStatement stm=getPreparedStatement(sql,parms);
        return stm.executeUpdate()>0;
    }

    public static ResultSet executeQuery(String sql,Object... parms) throws SQLException, ClassNotFoundException {
        PreparedStatement stm=getPreparedStatement(sql,parms);
        return stm.executeQuery();
    }

}
