package com.nagpal.bala.playgroundapp.jaxb;

import lombok.ToString;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "details")
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class JaxbModel {

    @XmlElement(name = "firstname")
    private String firstName;
    @XmlElement(name = "lastname")
    private String lastName;
    @XmlElement(name = "phone")
    private String phone;
    @XmlAnyElement(lax = true)
    @XmlJavaTypeAdapter(type = Element.class, value = JavaAdapter.class)
    private List<Element> catchAll;

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(JaxbModel.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        File file = new File(JaxbModel.class.getClassLoader().getResource("sample.xml").getFile());
        JaxbModel unmarshalContent = (JaxbModel)unmarshaller.unmarshal(file);

        System.out.println("unmarshalContent = " + unmarshalContent);
    }
}
