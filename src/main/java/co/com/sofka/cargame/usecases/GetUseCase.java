package co.com.sofka.cargame.usecases;

import co.com.sofka.cargame.collections.Angle;
import co.com.sofka.cargame.repositories.AngleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class GetUseCase implements Function<String, Mono<Angle>> {

    private final AngleRepository angleRepository;

    public GetUseCase(AngleRepository angleRepository) {
        this.angleRepository = angleRepository;
    }

    @Override
    public Mono<Angle> apply(String id) {
        return angleRepository.findById(id);
    }
}
