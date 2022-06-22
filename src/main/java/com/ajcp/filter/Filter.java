package com.ajcp.filter;

import com.ajcp.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    private static final Logger log = LoggerFactory.getLogger(Filter.class);

    public void filter() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Camila", 23));
        personas.add(new Persona(3, "Jean", 25));

        Flux.fromIterable(personas)
                .filter(p -> p.getEdad() > 24)
                .subscribe(p -> log.info(p.toString()));
    }

    public void distinct() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Andres", 23));
        personas.add(new Persona(3, "Jean", 25));
        personas.add(new Persona(1, "Andres", 24));

        Flux.fromIterable(personas)
                .distinct()
                .subscribe(p -> log.info(p.toString()));
    }

    public void take() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Camila", 23));
        personas.add(new Persona(3, "Jean", 25));

        Flux.fromIterable(personas)
                .take(2)
                .subscribe(p -> log.info(p.toString()));
    }

    public void takeLast() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Camila", 23));
        personas.add(new Persona(3, "Jean", 25));

        Flux.fromIterable(personas)
                .takeLast(2)
                .subscribe(p -> log.info(p.toString()));
    }

    public void skip() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Camila", 23));
        personas.add(new Persona(3, "Jean", 25));

        Flux.fromIterable(personas)
                .skip(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public void skipLast() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Camila", 23));
        personas.add(new Persona(3, "Jean", 25));

        Flux.fromIterable(personas)
                .skipLast(1)
                .subscribe(p -> log.info(p.toString()));
    }
}
