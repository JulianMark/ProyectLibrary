/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.simpledao;

import controller.Connexion;
import model.dto.BookDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian
 */
public class BookDao implements SimpleObjDao<BookDTO>{
    
    private Connection userConn;

    private final String SQL_INSERT = "INSERT INTO books (name, id_author, id_gender) VALUES(?,?,?)";

    private final String SQL_UPDATE = "UPDATE books SET name= ?, id_author= ?, id_gender= ? WHERE id= ?";

    private final String SQL_DELETE = "DELETE FROM books WHERE id = ?";

    private final String SQL_SELECT = "SELECT id, name, id_author, id_gender FROM books ORDER BY name";

    private final String SQL_SELECT_FOR_NAME = "SELECT id, name, id_author, id_gender FROM books \n" +
                                               "WHERE name like ?\n" +
                                               "ORDER BY name";
    
    public BookDao() {
    }

    public BookDao(Connection userConn) {
        this.userConn = userConn;
    }
    
    @Override
    public int insert(BookDTO book) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, book.getName());
            stmt.setInt(index++, book.getIdGender());
            stmt.setInt(index, book.getIdAuthor());
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
    public int update(BookDTO book) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, book.getName());
            stmt.setInt(index++, book.getIdAuthor());
            stmt.setInt(index++, book.getIdGender());
            stmt.setInt(index, book.getId());
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
    public int delete(BookDTO book) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, book.getId());
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
    public List<BookDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        BookDTO bookDTO;
        List<BookDTO> books = new ArrayList<>();
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTemp = rs.getInt(1);
                String nameTemp = rs.getString(2);
                int idAuthorTemp = rs.getInt(3);
                int idGenderTemp = rs.getInt(4);
                bookDTO = new BookDTO();
                bookDTO.setId(idTemp);
                bookDTO.setName(nameTemp);
                bookDTO.setIdAuthor(idAuthorTemp);
                bookDTO.setIdGender(idGenderTemp);
                books.add(bookDTO);
            }
        } finally {
            Connexion.close(rs);
            Connexion.close(stmt);
            if (this.userConn == null) {
                Connexion.close(conn);
            }
        }
        return books;
    }    
    
    @Override
    public List<BookDTO> select_for_name(String name) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        BookDTO bookDTO;
        List<BookDTO> books = new ArrayList<>();
        StringBuilder search = new StringBuilder();
        search.append("%");
        search.append(name);
        search.append("%");
        try {
            conn = (this.userConn != null) ? this.userConn : Connexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_FOR_NAME);
            stmt.setString(1, search.toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTemp = rs.getInt(1);
                String nameTemp = rs.getString(2);
                int idAuthorTemp = rs.getInt(3);
                int idGenderTemp = rs.getInt(4);
                bookDTO = new BookDTO();
                bookDTO.setId(idTemp);
                bookDTO.setName(nameTemp);
                bookDTO.setIdAuthor(idAuthorTemp);
                bookDTO.setIdGender(idGenderTemp);
                books.add(bookDTO);
            }
        } finally {
            Connexion.close(rs);
            Connexion.close(stmt);
            if (this.userConn == null) {
                Connexion.close(conn);
            }
        }
        return books;
    }    
}
