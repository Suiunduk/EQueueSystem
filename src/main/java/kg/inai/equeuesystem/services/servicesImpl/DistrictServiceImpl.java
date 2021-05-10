package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.District;
import kg.inai.equeuesystem.entities.Region;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.DistrictModel;
import kg.inai.equeuesystem.repositories.DistrictRepository;
import kg.inai.equeuesystem.repositories.RegionRepository;
import kg.inai.equeuesystem.services.CountryService;
import kg.inai.equeuesystem.services.DistrictService;
import kg.inai.equeuesystem.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private RegionService regionService;

    @Override
    public District create(DistrictModel districtModel) {
        District district = District.builder()
                .name(districtModel.getName())
                .isCity(districtModel.getIsCity())
                .region(regionService.create(districtModel.getRegionModel()))
                .build();
        return districtRepository.save(district);
    }

    @Override
    public District update(DistrictModel districtModel) {
        return districtRepository.findById(districtModel.getId())
                .map(newDistrict -> {
                    newDistrict.setName(districtModel.getName());
                    newDistrict.setIsCity(districtModel.getIsCity());
                    newDistrict.setRegion(regionService.update(districtModel.getRegionModel()));
                    return districtRepository.save(newDistrict);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + districtModel.getId()));
    }

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public District getById(Long id) {
        return districtRepository.getOne(id);
    }
}
