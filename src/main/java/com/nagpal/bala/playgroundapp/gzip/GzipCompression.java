package com.nagpal.bala.playgroundapp.gzip;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagpal.bala.playgroundapp.model.Person;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;

public class GzipCompression {

    //without compression : 337 bytes
    //with compression (serialization) : 267 bytes
    //with compression (json) : 172 bytes
    public static void main(String[] args) throws Exception {
        Person person = constructPersonObject();

        withoutCompression(person);
        compressSerializedObject(person);
        compressJSONObject(person);
    }

    private static void withoutCompression(final Person person) throws Exception {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(person);

        objectOutputStream.flush();
        objectOutputStream.close();
        outputStream.close();

        byte[] bytes = outputStream.toByteArray();
        System.out.println("Size without compression = " + bytes.length);
    }

    private static void compressSerializedObject(final Person person) throws Exception {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(gzipOutputStream);

        objectOutputStream.writeObject(person);

        objectOutputStream.flush();
        objectOutputStream.close();
        gzipOutputStream.close();
        outputStream.close();

        byte[] compressed = outputStream.toByteArray();
        System.out.println("Compressed size with serialization = " + compressed.length);
    }

    private static void compressJSONObject(final Person person) throws Exception {
        String json = toJSON(person);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
        gzipOutputStream.write(json.getBytes(StandardCharsets.UTF_8));

        gzipOutputStream.close();
        outputStream.close();

        byte[] compressed = outputStream.toByteArray();
        System.out.println("Compressed size with JSON = " + compressed.length);
    }

    private static Person constructPersonObject() {
        Person person = new Person();

        person.setFirstName("Balkrishan");
        person.setLastName("Nagpal");
        person.setAddress("Mahagun Mywoods");
        person.setCity("Noida");
        person.setCountry("India");
        person.setCountryCode(91);
        person.setEmail("balkrishan.nagpal@gmail.com");
        person.setGender("male");
        person.setMobile("9650821621");
        person.setState("UP");

        return person;
    }

    private static String toJSON(Serializable person) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        String className = "com.nagpal.bala.playgroundapp.model.Person";

        Object deserializedPerson = objectMapper.readValue(json, Class.forName(className));
        return json;
    }
}
