/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.simpledao;

import java.sql.SQLException;
import java.util.List;
import model.dto.SimpleObjDTO;

/**
 *
 * @author Julian
 * @param <T>
 */
public interface SimpleObjDao <T extends SimpleObjDTO> {
    
    public int insert (T object) throws SQLException;
    
    public int update (T object) throws SQLException;
    
    public int delete (T object) throws SQLException;
    
    public List<T> select() throws SQLException;
}
