package com.converter.converter.service;

import com.converter.converter.dto.CurrencyDTO;
import com.converter.converter.dto.RequestDTO;

public interface CurrencyService {
    public CurrencyDTO convert(RequestDTO requestDTO);
}
