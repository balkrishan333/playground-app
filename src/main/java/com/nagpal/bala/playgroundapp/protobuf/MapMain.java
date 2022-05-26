package com.nagpal.bala.playgroundapp.protobuf;

import com.nagpal.bala.playgroundapp.protobuf.generated.Map;

public class MapMain {

    private static Map.IdWrapper newIdWrapper(int id) {
        Map.IdWrapper wrapper = Map.IdWrapper.newBuilder()
                .setId(id)
                .build();
        return wrapper;
    }

    public static void main(String[] args) {
        Map.MapExample message = Map.MapExample.newBuilder()
                .putIds("myId", newIdWrapper(1))

                .build();

        System.out.println(message);
    }
}
