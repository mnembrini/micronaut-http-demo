package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SimpleController {

    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);


    @Get("/time")
    public String getTime() {
        return Instant.now().toString();
    }
}
