package com.nagpal.bala.playgroundapp.jaxb;

import org.w3c.dom.Element;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class JavaAdapter extends XmlAdapter<Element, JavaType> {

    @Override
    public JavaType unmarshal(Element v) throws Exception {
        JavaType javaType = new JavaType();
        javaType.setKey(v.getTagName());
        javaType.setValue(v.getTextContent());

        return javaType;
    }

    @Override
    public Element marshal(JavaType v) throws Exception {
        return null;
    }
}
