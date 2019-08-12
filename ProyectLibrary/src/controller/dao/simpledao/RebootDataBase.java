/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.dao.simpledao;

import controller.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author Julian Markowskyj <julian.markowskyj at gmail.com>
 */
public class RebootDataBase implements RebootDbDao{

    private Connection userConn;
    
    private final String SQL_EXECUTE = "EXEC DB_REBOOT";
    @Override
    public int ejecute() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_EXECUTE);
            stmt = conn.prepareStatement(SQL_EXECUTE);
            rows = stmt.executeUpdate();
        } finally {
            Connexion.close(stmt);
            if (this.userConn == null) {
                Connexion.close(conn);
            }
        }
        return rows;
    }
    
}
