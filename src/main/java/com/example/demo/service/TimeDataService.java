package com.example.demo.service;

import com.example.demo.entity.TimeData;


import java.util.List;

public interface TimeDataService {

    public void save(TimeData timeData) throws Exception;
    public List<TimeData> list() throws Exception;

}
