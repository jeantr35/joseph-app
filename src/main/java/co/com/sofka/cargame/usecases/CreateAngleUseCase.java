package co.com.sofka.cargame.usecases;

import co.com.sofka.cargame.collections.Angle;
import co.com.sofka.cargame.repositories.AngleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateAngleUseCase implements SaveAngle {

    private final AngleRepository angleRepository;

    public CreateAngleUseCase(AngleRepository angleRepository) {
        this.angleRepository = angleRepository;
    }

    @Override
    public Mono<String> apply(Angle angle) {
        return angleRepository.save(angle).map(Angle::getId);
    }
}
