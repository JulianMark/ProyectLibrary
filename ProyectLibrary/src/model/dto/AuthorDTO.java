/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

/**
 *
 * @author Nana
 */
public class AuthorDTO extends SimpleObjDTO{
    private String name;
    private String lastname;

    public AuthorDTO(int id, String name, String lastname) {
        super.id = id;
        this.name = name;
        this.lastname = lastname;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return name + " " + lastname;
    }
   
}
