/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books.jdbc;

import books.dto.BookDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Julian
 */
public interface BookDao {
    
    public int insert (BookDTO book) throws SQLException;
    
    public int update (BookDTO book) throws SQLException;
    
    public int delete (BookDTO book) throws SQLException;
    
    public List <BookDTO> select() throws SQLException;
}
