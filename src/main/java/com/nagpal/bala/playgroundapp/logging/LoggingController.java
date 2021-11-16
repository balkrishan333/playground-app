package com.nagpal.bala.playgroundapp.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagpal.bala.playgroundapp.CallingClass1;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringWriter;

@RestController
@Slf4j
public class LoggingController {

    private static boolean startLogging;

    @RequestMapping(method = RequestMethod.GET, path = "/startlogging")
    public String startLogging() {
        ThreadContext.put("forLogging", "bala");
        startLogging = true;
        log.info("starting logging...");
        while (startLogging) {
            log.info("This is info level log message");
            log.warn("This is warn level log message");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Logging started...";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/stoplogging")
    public String stopLogging() {
        startLogging = false;
        log.info("logging stopped...");
        return "Logging stopped.";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admin")
    public String admin() throws Exception {

        CallingClass1 class1 = new CallingClass1();
        try {
            class1.callClass1();
        } catch (Exception e) {
//            e.printStackTrace();
            log.error(e.getMessage(), e);
        }


        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        Car car = new Car();
        car.setColor("red");
        car.setType("suv");
        objectMapper.writeValue(stringWriter, car);

//        log.warn("logging car json...." + stringWriter);
        return stringWriter.toString();
    }
}

@Getter
@Setter
class Car {

    private String color;
    private String type;

}
