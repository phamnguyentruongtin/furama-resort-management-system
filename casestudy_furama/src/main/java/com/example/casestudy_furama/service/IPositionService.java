package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPositionService {
    List<Position> positionList();
}
