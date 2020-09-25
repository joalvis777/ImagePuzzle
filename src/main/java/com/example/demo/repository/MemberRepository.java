package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MemberRepository {
    static final Logger log = LoggerFactory.getLogger(MemberRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Member member) throws Exception {
        log.info("Repository create()");

        String query = "insert into sth(userId, userPw, userName) values(?, ?, ?)";

        jdbcTemplate.update(query, member.getUserId(), member.getUserPw(), member.getUserName());
    }

    public Member read(Member member) throws Exception {
        List<Member> results = jdbcTemplate.query(
                "select userId from sth where userId = ? and userPw = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setUserId(rs.getString("userId"));

                        return member;
                    }
                }, member.getUserId(), member.getUserPw()
        );
        return results.isEmpty() ? null : member;
    }

}
