package com.bootcamp.sdweek.controller;

import com.bootcamp.sdweek.model.dto.StockDTO;

import com.bootcamp.sdweek.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/stock")
@AllArgsConstructor
public class StockController {

    private StockService stockService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save (@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(stockService.save(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(stockService.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        return ResponseEntity.ok(stockService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(stockService.findById(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(stockService.delete(id));
    }

    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(){
        return ResponseEntity.ok(stockService.findByToday());

    }
}