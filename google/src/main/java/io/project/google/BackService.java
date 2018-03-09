/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.google;

import org.reactivestreams.Publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 *
 * @author armena
 */
@Service
@Component
public class BackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BackService.class);

    //@HystrixCommand(fallbackMethod = "findSecondary")
    public Publisher<String> justDoIt() {
        Publisher<String> ret = HystrixCommands.from(Flux.from(findPrimary())).commandName("findSecondary")
                .fallback((findSecondary())).build();
        return ret;
    }

    public Flux<String> findPrimary() {
        return Flux.error(new Error());
    }

    public Publisher<String> findSecondary() {
        LOGGER.info("Request again failed ");
        return Flux.just("HMMM, Error");
    }
}
