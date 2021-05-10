package kg.inai.equeuesystem.repositories;

import kg.inai.equeuesystem.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository  extends JpaRepository<Region, Long> {
}
