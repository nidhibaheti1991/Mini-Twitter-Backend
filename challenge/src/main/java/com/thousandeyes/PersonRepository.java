/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thousandeyes;

import com.thousandeyes.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.activation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import java.util.*;
/**
 *
 * @author Nidhi
 */
@Repository
public class PersonRepository {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /* number of users of the application */
    public int getCount() {
        return this.jdbcTemplate.queryForObject("select count(*) from person", Integer.class);
    }

    /* gets the person's details given parameter id */
    public Person getPerson(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id=?", personMapper, id);
    }

    private static final RowMapper<Person> personMapper = new RowMapper<Person>() {
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person(rs.getLong("id"), rs.getString("name"));
            return person;
        }
    };

    public List<Person> getFollowers(long id){
        return jdbcTemplate.query("SELECT id,name FROM person where id IN ( SELECT  follower_person_id FROM followers WHERE person_id=?)", personMapper, id);
    }
    
    public List<Person> getFollowing(long id){
        return jdbcTemplate.query("SELECT id,name FROM person where id IN ( SELECT  person_id FROM followers WHERE follower_person_id=?)", personMapper, id);
    }

    public void follow(long id, long idToFollow){
        this.jdbcTemplate.update(
                "INSERT INTO followers (person_id, follower_person_id) values (?, ?)",
                 idToFollow,id);
    }
    
    public void unfollow(long id, long idToUnfollow){
        this.jdbcTemplate.update(
                "DELETE FROM followers WHERE person_id=? AND follower_person_id=?",
                 idToUnfollow,id);
    }
    
    public List<Message> messages(long id){
        return this.jdbcTemplate.query("SELECT tweet.person_id as id, person.name as name, tweet.content as content " +
                "FROM tweet LEFT JOIN person " +
                "ON tweet.person_id=person.id " +
                "WHERE tweet.person_id IN " +
                "(SELECT person_id FROM followers WHERE follower_person_id=?) OR tweet.person_id=?",messageMapper, id, id);

    }


    private static final RowMapper<Message> messageMapper = new RowMapper<Message>() {
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person(rs.getLong("id"), rs.getString("name"));
            Message message = new Message(person,rs.getString("content"));
            return message;
        }
    };

}



