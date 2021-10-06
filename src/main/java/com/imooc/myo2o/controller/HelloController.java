package com.imooc.myo2o.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Api(value = "desc of class")
@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger logger = LogManager.getLogger(HelloController.class);

    @ApiOperation(value = "desc of method", notes = "")
    @RequestMapping(value = "/lane", method = RequestMethod.GET)
    public String lane( @ApiParam(value = "desc of param", required = false)
            @RequestParam String name){
        logger.warn("parameter is : {}", name);
        String nameParameter = name == null? "Lane" : name;
        return "hello " + nameParameter;
    }
}
