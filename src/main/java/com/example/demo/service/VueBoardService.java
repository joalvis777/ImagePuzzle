package com.example.demo.service;

import com.example.demo.entity.VueBoard;

import java.util.List;

public interface VueBoardService {
    public VueBoard read(Long userNo) throws Exception;
    public List<VueBoard> list() throws Exception;
}
