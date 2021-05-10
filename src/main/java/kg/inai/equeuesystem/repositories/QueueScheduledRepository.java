package kg.inai.equeuesystem.repositories;

import kg.inai.equeuesystem.entities.QueueScheduled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueScheduledRepository extends JpaRepository<QueueScheduled, Long> {
}
