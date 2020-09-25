package com.example.demo.repository;

import com.example.demo.entity.VueBoard;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Log
@Repository
public class VueBoardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public VueBoard read(Long userNo) throws Exception {
        log.info("READ");
        List<VueBoard> results = jdbcTemplate.query(
                "select userNo, userId, userPw, userName" +
                        "from sth where userNo = ?",
                new RowMapper<VueBoard>() {
                    @Override
                    public VueBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
                        VueBoard board = new VueBoard();
                        board.setUserNo(rs.getInt("userNo"));
                        board.setUserId(rs.getString("userId"));
                        board.setUserPw(rs.getString("userPw"));
                        board.setUserName(rs.getString("userName"));

                        return board;
                    }
                }, userNo
        );
        return results.isEmpty() ? null : results.get(0);
    }

    public List<VueBoard> list() throws Exception {
        log.info("LIST");
        List<VueBoard> results = jdbcTemplate.query(
                "select userNo, userId, userPw, userName from sth",
                new RowMapper<VueBoard>() {
                    @Override
                    public VueBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
                        VueBoard board = new VueBoard();
                        board.setUserNo(rs.getInt("userNo"));
                        board.setUserId(rs.getString("userId"));
                        board.setUserPw(rs.getString("userPw"));
                        board.setUserName(rs.getString("userName"));

                        return board;
                    }
                }
        );
        return results;
    }
}
