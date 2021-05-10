package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.Region;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.RegionModel;
import kg.inai.equeuesystem.repositories.RegionRepository;
import kg.inai.equeuesystem.services.CountryService;
import kg.inai.equeuesystem.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private CountryService countryService;

    @Override
    public Region create(RegionModel regionModel) {
        Region region = Region.builder()
                .name(regionModel.getName())
                .country(countryService.create(regionModel.getCountryModel()))
                .build();
        return regionRepository.save(region);
    }

    @Override
    public Region update(RegionModel regionModel) {
        return regionRepository.findById(regionModel.getId())
                .map(newRegion -> {
                    newRegion.setName(regionModel.getName());
                    newRegion.setCountry(countryService.update(regionModel.getCountryModel()));
                    return regionRepository.save(newRegion);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + regionModel.getId()));
    }

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region getById(Long id) {
        return regionRepository.getOne(id);
    }
}
