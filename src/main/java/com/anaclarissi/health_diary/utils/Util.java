package com.anaclarissi.health_diary.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Util {

    @Autowired
    private ModelMapper modelMapper;

    public static void updateData(Object source, Object destination) {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.map(source, destination);

    }

}
