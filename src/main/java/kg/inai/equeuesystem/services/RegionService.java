package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.Region;
import kg.inai.equeuesystem.models.RegionModel;

import java.util.List;

public interface RegionService {
    Region create(RegionModel regionModel);
    Region update(RegionModel regionModel);
    List<Region> findAll();
    Region getById(Long id);
}
