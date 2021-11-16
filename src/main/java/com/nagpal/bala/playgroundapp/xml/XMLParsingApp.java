package com.nagpal.bala.playgroundapp.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class XMLParsingApp {

    private static final String filePath = "/Users/bnagpal1/temp/book.xml";

    public static void main(String[] args) throws Exception {
//        marshal();
        System.out.println(unmarshall());;
    }

    public static void marshal() throws JAXBException {
        Book book = new Book();
        book.setId(1L);
        book.setName("Book1");
        book.setAuthor("Author1");
        book.setDate(new Date());

        JAXBContext context = JAXBContext.newInstance(Book.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(book, new File(filePath));
    }

    public static Book unmarshall() throws Exception {
        JAXBContext context = JAXBContext.newInstance(Book.class);
        Reader file = new FileReader(filePath);
        Document root = getRootElement(Files.readAllBytes(Paths.get(filePath)));
        String content =root.getElementsByTagName("title").item(0).getTextContent();
        System.out.println("content = " + content);
        return (Book) context.createUnmarshaller().unmarshal(file);
    }

    static Document getRootElement(byte[] contents) throws Exception {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return documentBuilder.parse(new InputSource(new StringReader(new String(contents, StandardCharsets.US_ASCII))));
    }
}
