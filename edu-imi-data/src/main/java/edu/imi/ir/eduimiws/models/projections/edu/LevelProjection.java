package edu.imi.ir.eduimiws.models.projections.edu;

import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "levelProjection",
        types = { LevelEntity.class })
public interface LevelProjection {

    @Value("#{target.id}")
    Long getId();

    @Value("#{target.levelApi?.levelPublicId}")
    String getLevelPublicId();

}
