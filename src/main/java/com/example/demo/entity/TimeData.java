package com.example.demo.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class TimeData {

    private int timeData;
    private String userId;
    private int lastMove;

    public int getTimeData() { return timeData;}
    public int getLastMove() { return lastMove;}
    public String getUserId() { return userId; }

    public void setTimeData(int timeData) { this.timeData = timeData; }
    public void setLastMove(int lastMove) { this.lastMove = lastMove; }
    public void setUserId(String userId) { this.userId = userId; }


}
