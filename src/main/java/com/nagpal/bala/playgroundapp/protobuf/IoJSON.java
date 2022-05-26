package com.nagpal.bala.playgroundapp.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.nagpal.bala.playgroundapp.protobuf.generated.SimpleOuterClass;

public class IoJSON {

    private static String toJSON(SimpleOuterClass.Simple message) throws InvalidProtocolBufferException {
        return JsonFormat.printer().print(message);
    }

    private static SimpleOuterClass.Simple fromJSON(String json) throws InvalidProtocolBufferException {
        SimpleOuterClass.Simple.Builder builder = SimpleOuterClass.Simple.newBuilder();
        JsonFormat.parser().merge(json, builder);

        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SimpleOuterClass.Simple message = SimpleOuterClass.Simple.newBuilder()
                .setName("Balkrishan")
                .setId(1)
                .setIsSimple(true)
                .build();

        String json = toJSON(message);
        System.out.println("json = " + json);

        SimpleOuterClass.Simple message2 = fromJSON(json);
        System.out.println("message2 = " + message2);
    }
}
