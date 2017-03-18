package com.thousandeyes;

/**
 * Created by Nidhi on 3/18/17.
 */
public class Message {
    private Person person;
    private String message;

    public Message(Person person,String message) {
        this.person = person;
        this.message = message;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public Person getPerson() {
        return person;
    }


    public String getMessage() {
        return message;
    }

    
}
