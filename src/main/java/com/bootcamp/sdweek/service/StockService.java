package com.bootcamp.sdweek.service;

import com.bootcamp.sdweek.exceptions.BusinessException;
import com.bootcamp.sdweek.exceptions.NotFoundException;
import com.bootcamp.sdweek.mapper.StockMapper;
import com.bootcamp.sdweek.model.Stock;
import com.bootcamp.sdweek.model.dto.StockDTO;
import com.bootcamp.sdweek.repository.StockRepository;
import com.bootcamp.sdweek.util.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
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

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> optionalStock = stockRepository.StockUpdate(dto.getName(), dto.getDate(), dto.getId());
        if (optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = stockMapper.toEntity(dto);
        stockRepository.save(stock);
        return stockMapper.toDto(stock);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        stockRepository.deleteById(dto.getId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findAll(){
        return stockMapper.toDto(stockRepository.findAll());
    }
    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return stockRepository.findById(id).map(stockMapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return stockRepository.findByToday(LocalDate.now()).map(stockMapper::toDto).orElseThrow(NotFoundException::new);
    }
}
