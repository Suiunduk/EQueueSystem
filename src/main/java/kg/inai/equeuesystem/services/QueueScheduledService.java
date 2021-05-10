package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.QueueScheduled;
import kg.inai.equeuesystem.models.QueueScheduledModel;

import java.util.List;

public interface QueueScheduledService {
    QueueScheduled create(QueueScheduledModel queueScheduledModel);
    QueueScheduled update(QueueScheduledModel queueScheduledModel);
    List<QueueScheduled> findAll();
    QueueScheduled getById(Long id);
}
