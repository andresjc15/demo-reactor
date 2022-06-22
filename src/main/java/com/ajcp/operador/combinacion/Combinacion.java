package com.ajcp.operador.combinacion;

import com.ajcp.model.Persona;
import com.ajcp.model.Venta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combinacion {

    private static final Logger log = LoggerFactory.getLogger(Combinacion.class);

    public void merge() {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Camila", 23));
        personas.add(new Persona(3, "Jean", 25));

        List<Persona> personas2 = new ArrayList<>();
        personas.add(new Persona(4, "Cesar", 24));
        personas.add(new Persona(5, "Juan", 23));
        personas.add(new Persona(6, "Geraldine", 25));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        Flux.merge(fx1, fx2, fx3)
                .subscribe(p -> log.info(p.toString()));

    }

    public void zip() {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Camila", 23));
        personas.add(new Persona(3, "Jean", 25));

        List<Persona> personas2 = new ArrayList<>();
        personas.add(new Persona(4, "Cesar", 24));
        personas.add(new Persona(5, "Juan", 23));
        personas.add(new Persona(6, "Geraldine", 25));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        Flux.zip(fx1, fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(x -> log.info(x.toString()));

    }

    public void zipWith() {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Andres", 24));
        personas.add(new Persona(2, "Camila", 23));
        personas.add(new Persona(3, "Jean", 25));

        List<Persona> personas2 = new ArrayList<>();
        personas.add(new Persona(4, "Cesar", 24));
        personas.add(new Persona(5, "Juan", 23));
        personas.add(new Persona(6, "Geraldine", 25));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        fx1.zipWith(fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(x -> log.info(x.toString()));

    }
}
