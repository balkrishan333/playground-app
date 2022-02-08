package com.nagpal.bala.playgroundapp.entitytodto;

public class EntityToDTOMain {

    public static void main(String[] args) {

        Car car = new Car();
        car.setMake("Maruti");
        car.setType("Hetchback");
        car.setNumberOfSeats(5);
        System.out.println("car = " + car);

        //Entity to DTO
       CarDTO carDTO = CarMapper.INSTANCE.carToCarDto(car);
       System.out.println("carDTO = " + carDTO);

        //DTO to Entity
        Car car1 = CarMapper.INSTANCE.carDTOToCar(carDTO);
        System.out.println("car from DTO = " + car1);
    }
}
