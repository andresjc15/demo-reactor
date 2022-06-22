package com.ajcp.operador.error;

import com.ajcp.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class ErrorOp {

    private static final Logger log = LoggerFactory.getLogger(ErrorOp.class);

    public void retry() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Camila", 23));
        personas.add(new Persona(3, "Jean", 25));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR RANDOM")))
                .retry(1)
                .doOnNext(x -> log.info(x.toString()))
                .subscribe();
    }

    public void errorReturn() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Camila", 23));
        personas.add(new Persona(3, "Jean", 25));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR RANDOM")))
                .onErrorReturn(new Persona(0, "RANDOM", 99))
                .subscribe(x -> log.info(x.toString()));
    }

    public void errorResume() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Camila", 23));
        personas.add(new Persona(3, "Jean", 25));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR RANDOM")))
                .onErrorResume(e -> Mono.just(new Persona(0, "RANDOM", 99)))// Maneja atributos del exception
                .subscribe(x -> log.info(x.toString()));
    }

    public void errorMap() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Camila", 23));
        personas.add(new Persona(3, "Jean", 25));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR RANDOM")))
                .onErrorMap(e -> new InterruptedException(e.getMessage()))
                .subscribe(x -> log.info(x.toString()));
    }
}
