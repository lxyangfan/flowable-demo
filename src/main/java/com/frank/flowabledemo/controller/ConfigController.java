package com.frank.flowabledemo.controller;

import com.frank.flowabledemo.config.MyApolloProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
@Slf4j
public class ConfigController {

    @Autowired
    private MyApolloProperties myApolloProperties;

    @Value("${com.miotech.ip.manual-mapping.usCidr}")
    private String usCidr;


    @Value("#{'${com.miotech.ip.manual-mapping.usCidr}'.split(',')}")
    private List<String> usCidrList;

    @GetMapping("/apollo")
    public String apollo() {
        log.info("usCidr: {}", usCidr);
        log.info("usCidrList: {}", usCidrList);
        log.info("myApolloProperties: {}", myApolloProperties);
        return myApolloProperties.getUsCidr().toString();
    }
}
