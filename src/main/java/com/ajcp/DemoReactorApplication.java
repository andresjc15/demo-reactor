package com.ajcp;

import com.ajcp.filter.Filter;
import com.ajcp.model.Persona;
import com.ajcp.operador.combinacion.Combinacion;
import com.ajcp.operador.condicional.Condicional;
import com.ajcp.operador.creacion.Creacion;
import com.ajcp.operador.error.ErrorOp;
import com.ajcp.operador.math.Math;
import com.ajcp.operador.transformacion.Transformacion;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public void reactor() {
		Mono.just(new Persona(1, "Andres", 24))
				.subscribe(p -> log.info("[Reactor] Persona: " + p));
	}

	public void rxjava2() {
		Observable.just(new Persona(1, "Andres", 24))
				.subscribe(p -> log.info("[RxJava2] Persona: " + p));
	}

	public void flux() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Andres", 24));
		personas.add(new Persona(2, "Camila", 23));
		personas.add(new Persona(3, "Jean", 25));

		Flux.fromIterable(personas).subscribe(p -> log.info(p.toString()));
	}

	public void fluxMono() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Andres", 24));
		personas.add(new Persona(2, "Camila", 23));
		personas.add(new Persona(3, "Jean", 25));

		Flux<Persona> fx = Flux.fromIterable(personas);
		fx.collectList().subscribe(list -> log.info(list.toString()));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//========Basic======//
		//reactor();
		//rxjava2();
		//flux();
		//fluxMono();
		//========Creacion======//
		//Creacion app = new Creacion();
		//app.range();
		//app.repeat();
		//========Transformaciones======//
		//Transformacion trans = new Transformacion();
		//trans.map();
		//trans.flatMap();
		//========Filtros======//
		//Filter app = new Filter();
		//app.filter();
		//app.distinct();
		//app.take();
		//app.takeLast();
		//app.skip();
		//app.skipLast();
		//========Combinaciones======//
		//Combinacion app = new Combinacion();
		//app.merge();
		//app.zip();
		//app.zipWith();
		//ErrorOp app = new ErrorOp();
		//app.retry();
		//app.errorReturn();
		//app.errorResume();
		//app.errorMap();
		//Condicional app = new Condicional();
		//app.defaultIfEmpty();
		//app.takeUntil();
		//app.timeout();
		Math app = new Math();
		//app.average();
		//app.count();
		//app.min();
		//app.sum();
		app.summarizing();

	}
}
