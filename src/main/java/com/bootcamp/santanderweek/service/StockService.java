package com.bootcamp.santanderweek.service;

import com.bootcamp.santanderweek.exceptions.BusinessException;
import com.bootcamp.santanderweek.mapper.StockMapper;
import com.bootcamp.santanderweek.model.Stock;
import com.bootcamp.santanderweek.model.dto.StockDTO;
import com.bootcamp.santanderweek.repository.StockRepository;
import com.bootcamp.santanderweek.util.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StockService {

    private StockRepository stockRepository;
    private StockMapper stockMapper;

    @Transactional
    public StockDTO save(StockDTO dto){
        Optional<Stock> optionalStock = stockRepository.findByNameAndDate(dto.getName(), dto.getDate());
        if (optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);

        }

        Stock stock = stockMapper.toEntity(dto);
        stockRepository.save(stock);
        return stockMapper.toDto(stock);
    }

    public Object update(StockDTO dto) {
        
    }
}
