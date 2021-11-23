package co.com.sofka.cargame.usecases;

import co.com.sofka.cargame.collections.Angle;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SaveAngle {
    Mono<String> apply(Angle angle);
}
