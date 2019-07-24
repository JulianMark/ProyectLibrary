/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

/**
 *
 * @author Julian
 */
public class BookDTO extends SimpleObjDTO{
    private String name;
    private int idGender;
    private int idAuthor;
    private boolean available;

    public BookDTO(int id, String name, int idAuthor, int idGender, boolean available) {
        super.id = id;
        this.name = name;
        this.idAuthor = idAuthor;
        this.idGender = idGender;
        this.available = available;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    
}
