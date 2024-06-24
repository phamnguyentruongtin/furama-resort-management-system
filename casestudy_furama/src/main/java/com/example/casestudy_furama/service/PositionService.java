package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Position;
import com.example.casestudy_furama.repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository iPositionRepository;

    @Override
    public List<Position> positionList() {
        return iPositionRepository.findAll();
    }
}
