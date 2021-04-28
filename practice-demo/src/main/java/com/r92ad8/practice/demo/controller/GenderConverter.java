package com.r92ad8.practice.demo.controller;

import org.springframework.core.convert.converter.Converter;

public class GenderConverter implements Converter<String, GenderEnum> {

    @Override
    public GenderEnum convert(String source) {
        return GenderEnum.getByValue(Integer.parseInt(source));
    }
}

