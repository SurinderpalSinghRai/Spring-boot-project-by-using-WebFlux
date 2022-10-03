package com.javaWebflux.springbootwebfluxdemo;

import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("Surinderpal Singh")
                .then(Mono.error(new RuntimeException("error occured")))
                .log();
        monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux(){
        Flux<?> fluxString = Flux.just("Surinderpal Singh","Dinesh","ABul","Nishu",1)
                .concatWithValues("Rajveer")
               // .concatWith(Flux.error(new RuntimeException("something is wrong")))
                .concatWithValues("Harman")
                .log();
        fluxString.subscribe(System.out::println);
    }
}
