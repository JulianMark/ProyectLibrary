/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.simpledao;

import controller.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dto.GenderDTO;

/**
 *
 * @author Nana
 */
public class GenderDao implements SimpleObjDao<GenderDTO>{
    
    private Connection userConn;

    private final String SQL_INSERT = "INSERT INTO genders (description) VALUES(?)";

    private final String SQL_UPDATE = "UPDATE genders SET description= ? WHERE id= ?";

    private final String SQL_DELETE = "DELETE FROM genders WHERE id = ?";

    private final String SQL_SELECT = "SELECT id, description FROM genders ORDER BY description";

    public GenderDao() {
    }

    public GenderDao(Connection userConn) {
        this.userConn = userConn;
    }
    
    @Override
    public int insert(GenderDTO gender) throws SQLException {
         Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index, gender.getDescription());
            System.out.println("Ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            Connexion.close(stmt);
            if (this.userConn == null) {
                Connexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int update(GenderDTO gender) throws SQLException {
          Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index, gender.getDescription());
            System.out.println("Ejecutando query:" + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
        } finally {
            Connexion.close(stmt);
            if (this.userConn == null) {
                Connexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int delete(GenderDTO gender) throws SQLException {
          Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, gender.getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            Connexion.close(stmt);
            if (this.userConn == null) {
                Connexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public List<GenderDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        GenderDTO genderDTO;
        List<GenderDTO> genders = new ArrayList<>();
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTemp = rs.getInt(1);
                String descriptionTemp = rs.getString(2);
                genderDTO = new GenderDTO();
                genderDTO.setId(idTemp);
                genderDTO.setDescription(descriptionTemp);
                genders.add(genderDTO);
            }
        } finally {
            Connexion.close(rs);
            Connexion.close(stmt);
            if (this.userConn == null) {
                Connexion.close(conn);
            }
        }
        return genders;
       
    }

    @Override
    public List<GenderDTO> select_for_name(String description) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
