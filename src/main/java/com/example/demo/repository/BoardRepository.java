package com.example.demo.repository;
import com.example.demo.entity.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardRepository {
    static final Logger log = LoggerFactory.getLogger(BoardRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Board> list() throws Exception {
        log.info("Repository list()");
        List<Board> results = jdbcTemplate.query(
                "select userNo, userId, userPw, userName from sth",
                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Board board = new Board();
                        board.setUserNo(rs.getInt("userNo"));
                        board.setUserId(rs.getString("userId"));
                        board.setUserPw(rs.getString("userPw"));
                        board.setUserName(rs.getString("userName"));

                        return board;
                    }
                });
        return results;
    }

}