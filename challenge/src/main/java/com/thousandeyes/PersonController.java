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
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Long id = Long.parseLong(name.substring(4));
        log.info("Test"+name+" "+id);
        return "OK";
    }

    @RequestMapping("/person")
    public Person getPerson() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Long id = Long.parseLong(name.substring(4));
        log.info("Get person");
        return person.getPerson(id);
    }
    @RequestMapping("/count")
    public int getCount() {
        log.info("Get count of persons");
        return person.getCount();
    }
    @RequestMapping("/followers")
    public List<Person> getFollowers() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Long id = Long.parseLong(name.substring(4));
        log.info("Get followers of person: "+id);
        return person.getFollowers(id);
    }
    @RequestMapping("/following")
    public List<Person> getFollowing() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Long id = Long.parseLong(name.substring(4));
        log.info("Get following of person: "+id);
        return person.getFollowing(id);
    }

    @RequestMapping("/follow")
    public List<Person> follow(@RequestParam("idToFollow") long idToFollow ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Long id = Long.parseLong(name.substring(4));
        log.info("Follow of person: "+idToFollow);
        person.follow(id, idToFollow);
        return person.getFollowing(id);
    }

    @RequestMapping("/unfollow")
    public List<Person> unfollow(@RequestParam("idToUnfollow") long idToUnfollow ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Long id = Long.parseLong(name.substring(4));
        log.info("Unfollow of person: "+idToUnfollow);
        person.unfollow(id, idToUnfollow);
        return person.getFollowing(id);
    }

    @RequestMapping("/messages")
    public List<Message> messages(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Long id = Long.parseLong(name.substring(4));
        log.info("Get messages of person: " + id);
        return person.messages(id);
    }

    @RequestMapping("/popular")
    public List<Person> popular(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Long id = Long.parseLong(name.substring(4));
        log.info("Get messages of person: " + id);
        return person.popular();
    }


}

