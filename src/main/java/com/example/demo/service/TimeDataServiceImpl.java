package com.example.demo.service;

import com.example.demo.entity.TimeData;
import com.example.demo.repository.TimeDataRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class TimeDataServiceImpl implements TimeDataService {

    @Autowired
    private TimeDataRepository timeDataRepository;

    @Override
    public void save(TimeData timeData) throws Exception {
        timeDataRepository.create(timeData);
    }

    @Override
    public List<TimeData> list() throws Exception {
        log.info("SERVICE LIST");
        return timeDataRepository.list();

    }

}
