package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.QueueLive;
import kg.inai.equeuesystem.models.QueueLiveModel;

import java.util.List;

public interface QueueLiveService {
    QueueLive create(QueueLiveModel queueLiveModel);
    QueueLive update(QueueLiveModel queueLiveModel);
    List<QueueLive> findAll();
    QueueLive getById(Long id);
}
