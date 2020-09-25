package com.example.demo.controller;

import com.example.demo.entity.TimeData;
import com.example.demo.entity.VueBoard;
import com.example.demo.service.TimeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class TimeDataController {
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private TimeDataService service;

    @PostMapping("/users/timeData")
    public ResponseEntity<TimeData> register(@RequestBody TimeData timeData) throws Exception {
        service.save(timeData);

        return new ResponseEntity<>(timeData, HttpStatus.OK);
    }

   @GetMapping("/rank")
   public ResponseEntity<List<TimeData>> list() throws Exception {
       log.info("Controller LIST");
       return new ResponseEntity<>(service.list(), HttpStatus.OK);
   }

}
