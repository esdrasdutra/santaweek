package com.bootcamp.santanderweek.exceptions;

import com.bootcamp.santanderweek.util.MessageUtils;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
