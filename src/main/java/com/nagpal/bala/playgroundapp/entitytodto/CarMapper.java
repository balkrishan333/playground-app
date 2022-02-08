package com.nagpal.bala.playgroundapp.entitytodto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDTO carToCarDto(Car car);

    @Mapping(source = "seatCount", target = "numberOfSeats")
    Car carDTOToCar(CarDTO carDTO);
}
