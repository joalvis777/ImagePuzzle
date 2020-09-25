package com.example.demo.repository;
import com.example.demo.entity.TimeData;
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
public class TimeDataRepository {
    static final Logger log = LoggerFactory.getLogger(MemberRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(TimeData timeData) throws Exception {
        String query = "insert into lastData(userId, timeData, lastMove) values(?,?,?)";

        jdbcTemplate.update(query, timeData.getUserId(), timeData.getTimeData(), timeData.getLastMove());
    }

    public List<TimeData> list() throws Exception {
    log.info("Repository LIST");
        List<TimeData> results = jdbcTemplate.query(
                "select userId, timeData, lastMove from lastData order by timeData ASC;",
                new RowMapper<TimeData>() {
                    @Override
                    public TimeData mapRow(ResultSet rs, int rowNum) throws SQLException {
                        TimeData timeData = new TimeData();
                        timeData.setUserId(rs.getString("userId"));
                        timeData.setTimeData(rs.getInt("timeData"));
                        timeData.setLastMove(rs.getInt("lastMove"));

                        return timeData;
                    }
                }
        );
        return results;
    }

}
