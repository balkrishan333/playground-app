package com.nagpal.bala.playgroundapp.effectivejava.item88;

import java.io.InvalidObjectException;
import java.io.ObjectInputValidation;

public class ObjectGraphValidator implements ObjectInputValidation {
    @Override
    public void validateObject() throws InvalidObjectException {
        // This method is registered with ObjectInputStream and is invoked when entire graph of objects is deserialized
    }
}
