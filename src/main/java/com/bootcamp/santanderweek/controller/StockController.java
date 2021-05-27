package com.bootcamp.santanderweek.controller;

import com.bootcamp.santanderweek.model.dto.StockDTO;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save (@Valid @RequestBody StockDTO dto){

        return ResponseEntity.ok(dto);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<StockDTO>> findAll(){
        List<StockDTO> list = new ArrayList<>();
        StockDTO dto = new StockDTO();

        dto.setId(1L);
        dto.setName("Magazine Luiza");
        dto.setPrice(100D);
        dto.setVariation(10D);
        dto.setDate(LocalDate.now());
        list.add(dto);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        List<StockDTO> list = new ArrayList<>();

        StockDTO stock1 = new StockDTO();
        StockDTO stock2 = new StockDTO();

        stock1.setId(1L);
        stock1.setName("Magazine Luiza");
        stock1.setPrice(100D);
        stock1.setVariation(10D);
        stock1.setDate(LocalDate.now());

        stock2.setId(2L);
        stock2.setName("Ponto Frio");
        stock2.setPrice(200D);
        stock2.setVariation(5D);
        stock2.setDate(LocalDate.now());

        list.add(stock1);
        list.add(stock2);

        StockDTO dtoSelected = list.stream().filter(x -> x.getId().compareTo(id) == 0 ).findFirst().get();
        return ResponseEntity.ok(dtoSelected);
    }


}
