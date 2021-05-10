package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.Country;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.CountryModel;
import kg.inai.equeuesystem.repositories.CountryRepository;
import kg.inai.equeuesystem.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public Country create(CountryModel countryModel) {
        Country country = Country.builder()
                .name(countryModel.getName())
                .build();
        return countryRepository.save(country);
    }

    @Override
    public Country update(CountryModel countryModel) {
        return countryRepository.findById(countryModel.getId())
                .map(newCountry -> {
                    newCountry.setName(countryModel.getName());
                    return countryRepository.save(newCountry);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + countryModel.getId()));
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getById(Long id) {
        return countryRepository.getOne(id);
    }
}
