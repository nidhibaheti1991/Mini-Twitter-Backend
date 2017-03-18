/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thousandeyes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

/**
 *
 * @author Nidhi
 */
@RestController
public class PersonController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonRepository person;

    @RequestMapping("/test")
    public String test() {
        log.info("Test");
        return "OK";
    }

    @RequestMapping("/person")
    public Person getPerson(@RequestParam("id") long id) {
        log.info("Get person");
        return person.getPerson(id);
    }
    @RequestMapping("/count")
    public int getCount() {
        log.info("Get count of persons");
        return person.getCount();
    }
    @RequestMapping("/followers")
    public List<Person> getFollowers(@RequestParam("id") long id) {
        log.info("Get followers of person: "+id);
        return person.getFollowers(id);
    }
    @RequestMapping("/following")
    public List<Person> getFollowing(@RequestParam("id") long id) {
        log.info("Get following of person: "+id);
        return person.getFollowing(id);
    }

    @RequestMapping("/follow")
    public List<Person> follow(@RequestParam("id") long id,@RequestParam("idToFollow") long idToFollow ) {
        log.info("Follow of person: "+idToFollow);
        person.follow(id, idToFollow);
        return person.getFollowing(id);
    }

    @RequestMapping("/unfollow")
    public List<Person> unfollow(@RequestParam("id") long id,@RequestParam("idToUnfollow") long idToUnfollow ) {
        log.info("Unfollow of person: "+idToUnfollow);
        person.unfollow(id, idToUnfollow);
        return person.getFollowing(id);
    }

    @RequestMapping("/messages")
    public List<Message> messages(@RequestParam("id") long id){
        log.info("Get messages of person: " + id);
        return person.messages(id);
    }


}

