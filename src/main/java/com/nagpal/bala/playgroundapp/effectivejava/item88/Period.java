package com.nagpal.bala.playgroundapp.effectivejava.item88;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {

    private Date start;
    private Date end;

    public Period(Date start, Date end) {

        //Directly assigning the object would mean both will have same reference
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalStateException("Start can't be larger than end");
        }
    }

    /*
        If we don't override this method, malformed stream can create objects which fail business validation
     */
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalStateException("From readObject : Start can't be larger than end");
        }
    }
}
