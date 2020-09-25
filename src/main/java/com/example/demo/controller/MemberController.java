package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService service;

    @PostMapping("/users/setup")
    public ResponseEntity<Member> register(@RequestBody Member member) throws Exception { // RequestBody 필수!!!!
        log.info("member.getUserId(): " + member.getUserId());
        service.register(member);
        log.info("register member.getUserNo():" + member.getUserNo());

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Member> Login(@RequestBody @Validated Member member) throws Exception {
        log.info("Login");

        log.info("memberId: " + member.getUserId());
        log.info("memberPw: " + member.getUserPw());
        Member id = null;
        id = service.login(member);
        if(id != null) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(member, HttpStatus.NO_CONTENT);
        }
    }
}