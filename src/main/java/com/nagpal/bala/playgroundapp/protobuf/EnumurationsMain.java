package com.nagpal.bala.playgroundapp.protobuf;

import com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass;

public class EnumurationsMain {

    public static void main(String[] args) {
        EnumurationsOuterClass.Enumurations message = EnumurationsOuterClass.Enumurations.newBuilder()
                .setEyeColor(EnumurationsOuterClass.EYE_COLOR.EYE_COLOR_BLUE)
                .build();

        System.out.println(message);
    }
}
