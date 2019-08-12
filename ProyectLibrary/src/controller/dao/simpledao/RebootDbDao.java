/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.simpledao;

import java.sql.SQLException;

/**
 *
 * @author Julian Markowskyj <julian.markowskyj at gmail.com>
 */
public interface RebootDbDao {
    
   public int ejecute() throws SQLException; 
}
