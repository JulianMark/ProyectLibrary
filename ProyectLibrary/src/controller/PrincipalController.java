/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 *
 */
public abstract class PrincipalController {
    protected Connection con;
    protected Statement st;
    protected ResultSet rs;
    protected PreparedStatement stmt;


    public void openConnection() throws SQLException {
        try {
            String url = "";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(url, "sa", "1234");
            System.out.println("Conexión a la BD");
	} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("Error al intentar abrir la conexión: "+e.getMessage());
	}
    }

    public void closeConnection() {
        try {
            con.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: "+e.toString());
	}
    }

    public int getMaxId (String tabla) {
        int maxId = 0;
        try
        {
            openConnection();
            String sqlMaxId = "SELECT MAX(ID) FROM "+tabla;
            st = con.createStatement();
            rs = st.executeQuery(sqlMaxId);
            if(rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta del método getMax Id de la tabla: "+tabla+"\n"+ex.getMessage());
        } finally {
            try {
                closeConnection();
            }
            catch (Exception ex)  {
                System.out.println("Error al cerrar la conexión del método getMax Id de la tabla: "+tabla+"\n"+ex.getMessage());
            }
        }

        return maxId;
    }
}
