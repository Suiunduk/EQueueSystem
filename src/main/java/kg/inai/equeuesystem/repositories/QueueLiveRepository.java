package kg.inai.equeuesystem.repositories;

import kg.inai.equeuesystem.entities.QueueLive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueLiveRepository extends JpaRepository<QueueLive, Long> {
}
