package com.example.demo.service;

import com.example.demo.entity.VueBoard;
import com.example.demo.repository.VueBoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueBoardServiceImpl implements VueBoardService {
    static final Logger log = LoggerFactory.getLogger(VueBoardServiceImpl.class);

    @Autowired
    private VueBoardRepository repository;

    @Override
    public VueBoard read(Long userNo) throws Exception {
        log.info("VueBoardService read(userNo): "+ userNo);
        return repository.read(userNo);
    }

    @Override
    public List<VueBoard> list() throws Exception {
        return repository.list();
    }
}
