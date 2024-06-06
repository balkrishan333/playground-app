package com.nagpal.bala.playgroundapp.csv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.Data;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

    public static void main(String[] args) throws  Exception {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = CsvSchema.emptySchema().withColumnSeparator('|').withQuoteChar('\'').withHeader();

        parseCourseList(csvMapper, csvSchema);
        parseOSR(csvMapper, csvSchema);

    }

    private static void parseOSR(CsvMapper csvMapper, CsvSchema csvSchema) {

        ObjectReader objectReader = csvMapper.readerFor(OSR.class).with(csvSchema);

        List<OSR> osrRows = new ArrayList<>();

        try (Reader reader = new FileReader("src/main/resources/osr.csv")) {
            MappingIterator<OSR> mappingIterator = objectReader.readValues(reader);
            while (mappingIterator.hasNext()) {
                OSR row = mappingIterator.next();
                osrRows.add(row);
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("OSR size = " + osrRows.size());
    }

    private static void parseCourseList(CsvMapper csvMapper, CsvSchema csvSchema) {

        ObjectReader objectReader = csvMapper.readerFor(OnlineCourse.class).with(csvSchema);

        List<OnlineCourse> onlineCourses = new ArrayList<>();

        try (Reader reader = new FileReader("src/main/resources/course-list.csv")) {
            MappingIterator<OnlineCourse> mappingIterator = objectReader.readValues(reader);
            while (mappingIterator.hasNext()) {
                OnlineCourse onlineCourse = mappingIterator.next();
                onlineCourses.add(onlineCourse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("onlineCourses = " + onlineCourses);
        System.out.println("onlineCourses size = " + onlineCourses.size());
    }

    @Data
    public  static class OnlineCourse {
        @JsonProperty("name")
        private String title;
        private String author;
        private int price;

    }

    @Data
    public static class OSR {
        @JsonProperty("Client Order ID")
        private String clientOrderId;
        @JsonProperty("Vendor Order ID")
        private String vendorOrderId;
        @JsonProperty("VendorName")
        private String vendorName;
        @JsonProperty("Order Name")
        private String orderName;
        @JsonProperty("Roster File Name")
        private String rosterFileName;
        @JsonProperty("Unique Member ID")
        private String uniqueMemberID;
        @JsonProperty("Tracker1")
        private String tracker1;
        @JsonProperty("Tracker2")
        private String tracker2;
        @JsonProperty("Tracker3")
        private String tracker3;
        @JsonProperty("Match Status")
        private String matchStatus;
        @JsonProperty("NCCPackages")
        private String nccPackages;
        @JsonProperty("Document Count")
        private String documentCount;
        @JsonProperty("Row Status")
        private String rowStatus;
        @JsonProperty("Response Status")
        private String responseStatus;
    }
}
