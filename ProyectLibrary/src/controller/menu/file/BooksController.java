/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menu.file;

import controller.PrincipalController;
import java.sql.SQLException;
import java.util.ArrayList;
import model.books.Book;

/**
 *
 * @author Nana
 */
public class BooksController extends PrincipalController{
       
    public ArrayList<Book> getBooks () {
        ArrayList<Book> books = new ArrayList<>();
        try
        {
            openConnection();
            String sql = "SELECT ID, NAME\n" +
                         "FROM BOOKS\n" +
                         "ORDER BY NAME ";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) { 
               int id = rs.getInt(1);
               String name = rs.getString(2);
               Book b = new Book(id,name);  
               books.add(b);
            }           
        } catch (SQLException ex) {
            System.out.println("Error en la consulta del método controller.menu.file.getBooks:\n"+ex.getMessage());
        } finally {
            try {
                closeConnection();
            }
            catch (Exception ex)  {
                System.out.println("Error en la consulta del método controller.menu.file.getBooks:\n"+ex.getMessage());
            }
        }       
        return books;
    }
}
