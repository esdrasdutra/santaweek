package com.bootcamp.santanderweek.service;

import com.bootcamp.santanderweek.mapper.StockMapper;
import com.bootcamp.santanderweek.model.Stock;
import com.bootcamp.santanderweek.model.dto.StockDTO;
import com.bootcamp.santanderweek.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class StockService {

    private StockRepository stockRepository;
    private StockMapper stockMapper;

    @Transactional
    public StockDTO save(StockDTO dto){
        Stock stock = stockMapper.toEntity(dto);
        stockRepository.save(stock);
        return stockMapper.toDto(stock);
    }

}
