package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.District;
import kg.inai.equeuesystem.models.DistrictModel;

import java.util.List;

public interface DistrictService {
    District create(DistrictModel districtModel);
    District update(DistrictModel districtModel);
    List<District> findAll();
    District getById(Long id);
}
