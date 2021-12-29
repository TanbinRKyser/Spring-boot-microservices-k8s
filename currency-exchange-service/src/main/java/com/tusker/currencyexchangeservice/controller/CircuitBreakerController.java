package com.tusker.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger( CircuitBreakerController.class );

    @GetMapping("/sample-api")
//    @Retry(  name="sample-api", fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(  name="default", fallbackMethod = "hardcodedResponse" )
//    @RateLimiter( name="default" )
    @Bulkhead( name="default" )
    public String sampleApi(){

        logger.info( "Sample API -> " );
       /* ResponseEntity<String> forEntity = new RestTemplate()
                .getForEntity( "http://localhost:8080/some-api-url", String.class );

        return forEntity.getBody();*/
        return "SAMPLE API";
    }

    public String hardcodedResponse( Exception exception ){
        return "Fallback Response";
    }
}