package com.prit.playground.hystrix.circuitbreaker.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/rest")
public class MainController {

    @HystrixCommand (fallbackMethod = "fallBackWelcome",
            commandKey = "welcome",
            groupKey = "welcome")
    @GetMapping("/welcome")
    public String welcome() {
        if(RandomUtils.nextBoolean()){
           throw new RuntimeException("Failed in welcome");
        }
        return "Hi, Welcome ";
    }

    public String fallBackWelcome(){
        return "fall Back Welcome initiated";
    }

}
