package com.example.demo.controller;
import com.example.demo.entity.VueBoard;
import com.example.demo.service.VueBoardService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@Log
@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueBoardController {

    @Autowired
    private VueBoardService service;

    @GetMapping("/{userNo}")
    public ResponseEntity<VueBoard> read(
            @PathVariable("userNo") Long userNo) throws Exception {
        log.info("read()");
        VueBoard board = service.read(userNo);
        System.out.println("VueBoardController: " + board);
        return new ResponseEntity<VueBoard>(board, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<VueBoard>> list() throws Exception {
        log.info("list()");
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

}