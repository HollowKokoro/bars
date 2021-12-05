package com.example.barsserver.service;

import com.example.barsserver.model.Contract;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractService {
    List<Contract> findAll();
}
