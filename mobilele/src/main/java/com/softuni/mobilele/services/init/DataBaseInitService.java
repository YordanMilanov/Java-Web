package com.softuni.mobilele.services.init;

import org.springframework.stereotype.Service;

@Service
public interface DataBaseInitService {
    void dbInit();
    boolean isDbInit();
}
