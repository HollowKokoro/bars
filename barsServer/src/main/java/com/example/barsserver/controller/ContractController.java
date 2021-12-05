package com.example.barsserver.controller;

import com.example.barsserver.model.Contract;
import com.example.barsserver.service.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContractController {

    ContractServiceImpl service;

    @Autowired
    public ContractController(ContractServiceImpl service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contract> index() {
        return service.findAll();
    }
}
