package co.com.sofka.cargame.routers;

import co.com.sofka.cargame.collections.Angle;
import co.com.sofka.cargame.usecases.CreateAngleUseCase;
import co.com.sofka.cargame.usecases.GetUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class AngleRouter {

    @Bean
    public RouterFunction<ServerResponse> createGame(CreateAngleUseCase createAngleUseCase){

        Function<Angle, Mono<ServerResponse>> executor = newAngle -> createAngleUseCase.apply(newAngle)
                .flatMap(result -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                        .bodyValue(result));

        return route(
                POST("/createAngle").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(Angle.class).flatMap(executor)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> get(GetUseCase getUseCase) {
        return route(
                GET("/get/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getUseCase.apply(
                                        request.pathVariable("id")),
                                Angle.class
                        ))
        );
    }

}
