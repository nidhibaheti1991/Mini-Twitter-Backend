/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thousandeyes;
import java.util.*;

/**
 *
 * @author Nidhi
 */
public class Person {
    private long id;
    private String name;

    public Person(long id, String name){
        this.id = id;
        this.name = name;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
