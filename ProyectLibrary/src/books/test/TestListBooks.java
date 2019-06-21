/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books.test;

import model.dto.BookDTO;
import controller.dao.BookDao;
import java.sql.SQLException;
import controller.SimpleObjDao;

/**
 *
 * @author Julian
 */
public class TestListBooks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //Utilizamos el tipo interface como referencia
        //a una clase concreta
        SimpleObjDao bookDao = new BookDao();

        //Creamos un nuevo registro
        //Hacemos uso de la clase persona DTO la cual se usa
        //para transferiri la informacion entre las capas
        //no es necesario especificar la llave primaria
        //ya que en este caso es de tipo autonumerico y la BD se encarga
        //de asignarle un nuevo valor
        BookDTO book = new BookDTO();
        book.setName("EL HOMBRE ILUSTRADO");
        book.setIdAuthor(1);
        book.setIdGender(3);
        //Utilizamos la capa DAO para persistir el objeto DTO
        try {
            bookDao.insert(book);

        } catch (SQLException e) {
            System.out.println("Excepcion en la capa de prueba");
            e.printStackTrace();
        }
    }
}
    
