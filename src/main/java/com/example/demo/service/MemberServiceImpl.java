package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void register(Member member) throws Exception {
        memberRepository.create(member);
    }

    @Override
    public Member login(Member member) throws Exception {
        return memberRepository.read(member);
    }

}