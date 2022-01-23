package com.converter.converter.controller;

import com.converter.converter.dto.CurrencyDTO;
import com.converter.converter.dto.RequestDTO;
import com.converter.converter.service.CurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "converter/")
public class CurrencyController {

    @Autowired
    private CurrencyServiceImpl currencyService;

    @PostMapping
    @RequestMapping(path = "convert")
    public ResponseEntity<Object> convert(@RequestBody RequestDTO requestDTO){
        CurrencyDTO currencyDTO = currencyService.convert(requestDTO);
        if(currencyDTO == null){
            Map<String, String> error = new HashMap<>();
            error.put("message", "Bad Request Input.");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(currencyDTO, HttpStatus.OK);
    }
}
