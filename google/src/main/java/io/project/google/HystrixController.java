/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.google;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 *
 * @author armena
 */
@RestController
@RequestMapping(path = "/api/v2/actions", produces = MediaType.APPLICATION_JSON_VALUE)
public class HystrixController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixController.class);
    
    @Autowired
    private BackService backService;

    @GetMapping("/find")
    public Publisher<String> findPrimary() {
        return backService.justDoIt();
    }

}
