/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.google;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author armena
 */
@Service
@Component
public class BackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BackService.class);

    @HystrixCommand(fallbackMethod = "findSecondary")
    public String findPrimary() {
        LOGGER.info("IllegalArgumentException  ");
        throw new IllegalArgumentException();
    }

    public String findSecondary() {
        LOGGER.info("Request again failed ");
        return "SecondaryJson";
    }
}
