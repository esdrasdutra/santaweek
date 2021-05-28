package com.bootcamp.sdweek.exceptions;

import com.bootcamp.sdweek.util.MessageUtils;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
