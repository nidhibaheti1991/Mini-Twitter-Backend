///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.thousandeyes;
//
///**
// *
// * @author Nidhi
// */
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class WebController {
//
//    @RequestMapping(value={"/","home"})
//        public String home(){
//            return "home";
//        }
//
//    @RequestMapping(value={"/welcome"})
//    public String welcome(){
//        return "welcome";
//    }
//
//    @RequestMapping(value="/admin")
//    public String admin(){
//        return "admin";
//    }
//
//    @RequestMapping(value={"/login"})
//    public String login(){
//        return "login";
//    }
//
//
//    @RequestMapping(value="/403")
//    public String Error403(){
//        return "403";
//    }
//}