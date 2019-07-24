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
import model.dto.AuthorDTO;

/**
 *
 * @author Nana
 */
public class AuthorDao implements SimpleObjDao <AuthorDTO>{
    
    private Connection userConn;

    private final String SQL_INSERT = "INSERT INTO authors_books (name, lastname) VALUES(?,?)";

    private final String SQL_UPDATE = "UPDATE authors_books SET name= ?, lastname= ? WHERE id= ?";

    private final String SQL_DELETE = "DELETE FROM authors_books WHERE id = ?";

    private final String SQL_SELECT = "SELECT id, name, lastname FROM authors_books ORDER BY name";
    
    private final String SQL_SELECT_FOR_NAME = "SELECT id, name, lastname FROM authors_books\n" +
                                               "WHERE lastname like ? OR name like ?\n" +
                                               "ORDER BY name";

    public AuthorDao() {
    }

    public AuthorDao(Connection userConn) {
        this.userConn = userConn;
    }

    @Override
    public int insert(AuthorDTO author) throws SQLException {
         Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, author.getName());
            stmt.setString(index, author.getLastname());
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
    public int update(AuthorDTO author) throws SQLException {
         Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, author.getName());
            stmt.setString(index++, author.getLastname());
            stmt.setInt(index, author.getId());
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
    public int delete(AuthorDTO author) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, author.getId());
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
    public List<AuthorDTO> select() throws SQLException {
         Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AuthorDTO authorDTO;
        List<AuthorDTO> authors = new ArrayList<>();
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTemp = rs.getInt(1);
                String nameTemp = rs.getString(2);
                String lastnameTemp = rs.getString(3);
                authorDTO = new AuthorDTO(idTemp,nameTemp,lastnameTemp);
                authors.add(authorDTO);
            }
        } finally {
            Connexion.close(rs);
            Connexion.close(stmt);
            if (this.userConn == null) {
                Connexion.close(conn);
            }
        }
        return authors;
    }
    
    @Override
    public List<AuthorDTO> select_for_name(String lastname) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AuthorDTO authorDTO;
        List<AuthorDTO> authors = new ArrayList<>();
        StringBuilder search = new StringBuilder();
        search.append("%");
        search.append(lastname);
        search.append("%");
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_FOR_NAME);
            stmt.setString(1, search.toString());
            stmt.setString(2, search.toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTemp = rs.getInt(1);
                String lastnameTemp = rs.getString(2);
                String nameTemp = rs.getString(3);
                authorDTO = new AuthorDTO(idTemp,nameTemp,lastnameTemp);
                authors.add(authorDTO);
            }
        } finally {
            Connexion.close(rs);
            Connexion.close(stmt);
            if (this.userConn == null) {
                Connexion.close(conn);
            }
        }
        return authors;
    }

}