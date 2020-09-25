package com.example.demo.service;

import com.example.demo.entity.Member;
import org.springframework.stereotype.Service;

public interface MemberService {

    public void register(Member member) throws Exception;
    public Member login(Member member) throws Exception;

}