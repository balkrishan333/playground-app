package com.nagpal.bala.playgroundapp.xml;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "book")
@XmlType(propOrder = { "id", "name", "date" })
public class Book {
    private Long id;
    private String name;
    private String author;
    private Date date;

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    @XmlElement(name = "title")
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @XmlTransient
    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }
}
